package pdp.uz.codingbat_app.service.languages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pdp.uz.codingbat_app.entity.LanguagesEntity;
import pdp.uz.codingbat_app.entity.UsersEntity;
import pdp.uz.codingbat_app.interfaces.LanguagesInterfaceMethod;
import pdp.uz.codingbat_app.payload.ApiResponse;
import pdp.uz.codingbat_app.repository.LanguagesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LanguagesService implements LanguagesInterfaceMethod {

    private final LanguagesRepository languagesRepository;

    @Autowired
    public LanguagesService(LanguagesRepository languagesRepository) {
        this.languagesRepository = languagesRepository;
    }

    @Override
    public ResponseEntity<List<LanguagesEntity>> getLanguages(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<LanguagesEntity> languagesPage = languagesRepository.findAll(pageable);
        List<LanguagesEntity> content = languagesPage.getContent();
        return ResponseEntity.ok(content);
    }

    @Override
    public ResponseEntity<LanguagesEntity> getLanguage(Long id) {
        Optional<LanguagesEntity> optionalById = languagesRepository.findById(id);
        if (optionalById.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(optionalById.get());
    }

    @Override
    public ResponseEntity<ApiResponse> saveLanguages(LanguagesEntity languagesEntity) {
        if (languagesRepository.existsByName(languagesEntity.getName()))
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(new ApiResponse("alerady languages name", false));

        LanguagesEntity save = languagesRepository.save(languagesEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(languagesEntity.getName()+" language save", true));
    }

    @Override
    public ResponseEntity<ApiResponse> editLanguages(Long id, LanguagesEntity languagesEntity) {
        boolean byNameAndIdNot = languagesRepository.existsByNameAndIdNot(languagesEntity.getName(), id);
        if (byNameAndIdNot){
            return ResponseEntity.status(409).body(new ApiResponse(languagesEntity.getName() + " such a language exists by name", false));
        }
        Optional<LanguagesEntity> byId = languagesRepository.findById(id);
        if (byId.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("such a language does not exist",false));
        }

        LanguagesEntity languagesEntityUz = byId.get();
        languagesEntityUz.setName(languagesEntity.getName());
        languagesRepository.save(languagesEntityUz);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("edit languages",true));
    }

    @Override
    public ResponseEntity<ApiResponse> deleteLanguages(Long id) {
        try {
            languagesRepository.deleteById(id);
            return ResponseEntity.ok(new ApiResponse("delete language", true));
        }catch (Exception e){
            return ResponseEntity.ok(new ApiResponse("not found languages", false));
        }
    }
}
