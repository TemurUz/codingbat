package pdp.uz.codingbat_app.service.theme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import pdp.uz.codingbat_app.entity.LanguagesEntity;
import pdp.uz.codingbat_app.entity.ThemeEntity;
import pdp.uz.codingbat_app.payload.ApiResponse;
import pdp.uz.codingbat_app.payload.ThemeDto;
import pdp.uz.codingbat_app.repository.LanguagesRepository;
import pdp.uz.codingbat_app.repository.ThemeRepository;


import java.util.List;
import java.util.Optional;

@Service
public class ThemeService implements ThemeInterfaceMethod {

    private final ThemeRepository themeRepository;
    private final LanguagesRepository languagesRepository;

    @Autowired
    public ThemeService(ThemeRepository themeRepository, LanguagesRepository languagesRepository) {
        this.themeRepository = themeRepository;
        this.languagesRepository = languagesRepository;
    }

    @Override
    public ResponseEntity<List<ThemeEntity>> getThemes(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ThemeEntity> entityPage = themeRepository.findAll(pageable);
        return ResponseEntity.ok(entityPage.getContent());
    }

    @Override
    public ResponseEntity<ThemeEntity> getTheme(Long id) {
        Optional<ThemeEntity> byId = themeRepository.findById(id);
        if (!byId.isPresent()){
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.ok(byId.get());
    }

    @Override
    public ResponseEntity<ApiResponse> saveTheme(ThemeDto themeDto) {
        boolean existsByName = themeRepository.existsByName(themeDto.getName());
        if (existsByName)
            return ResponseEntity.status(409)
                    .body(new ApiResponse("there is such a theme", false));
        Optional<LanguagesEntity> languages
                = languagesRepository.findById(themeDto.getLanguagesId());
        if (!languages.isPresent())
            return ResponseEntity.status(409).body(new ApiResponse("not found languages", false));

        ThemeEntity themeEntity = new ThemeEntity();
        themeEntity.setName(themeDto.getName());
        themeEntity.setDescription(themeDto.getDescription());
        themeEntity.setLanguages(languages.get());

        return ResponseEntity.status(201).body(new ApiResponse("saved theme", false));
    }

    @Override
    public ResponseEntity<ApiResponse> editTheme(Long id, ThemeDto themeDto) {
        boolean existsByNameAndIdNot
                = themeRepository.existsByNameAndIdNot(themeDto.getName(), id);

        if (existsByNameAndIdNot)
            return ResponseEntity.status(409).body(new ApiResponse("bunaqa mavzu bor", false));

        Optional<LanguagesEntity> languages
                = languagesRepository.findById(themeDto.getLanguagesId());
        if (!languages.isPresent())
            return ResponseEntity.status(409).body(new ApiResponse("not found languages", false));

        Optional<ThemeEntity> byId = themeRepository.findById(id);
        if (!byId.isPresent())
            return ResponseEntity.status(409).body(new ApiResponse("bunday " + id + " li theme yuq", false));

        ThemeEntity themeEntity = byId.get();
        themeEntity.setName(themeDto.getName());
        themeEntity.setDescription(themeDto.getDescription());
        themeEntity.setLanguages(languages.get());
        return ResponseEntity.status(201).body(new ApiResponse("edit theme", true));
    }

    @Override
    public ApiResponse deleteTheme(Long id) {
        try{
            themeRepository.deleteById(id);
            return new ApiResponse("delete theme",true);
        }catch (Exception e){
            return new ApiResponse("Xatolik", false);
        }

    }
}
