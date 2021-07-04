package pdp.uz.codingbat_app.service.languages;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import pdp.uz.codingbat_app.entity.LanguagesEntity;
import pdp.uz.codingbat_app.entity.UsersEntity;
import pdp.uz.codingbat_app.payload.ApiResponse;

import java.util.List;

public interface LanguagesService {

    List<LanguagesEntity> getLanguages(int page, int size);

    LanguagesEntity getLanguage(Long id);

    ApiResponse saveLanguages(LanguagesEntity languagesEntity);

    ApiResponse editLanguages(Long id, LanguagesEntity languagesEntity);

    ApiResponse deleteLanguages(Long id);

}
