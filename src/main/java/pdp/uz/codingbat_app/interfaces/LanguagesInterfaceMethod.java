package pdp.uz.codingbat_app.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import pdp.uz.codingbat_app.entity.LanguagesEntity;
import pdp.uz.codingbat_app.entity.UsersEntity;
import pdp.uz.codingbat_app.payload.ApiResponse;

import java.util.List;

public interface LanguagesInterfaceMethod {

    ResponseEntity<List<LanguagesEntity>> getLanguages(int page, int size);

    ResponseEntity<LanguagesEntity> getLanguage(Long id);

    ResponseEntity<ApiResponse> saveLanguages(LanguagesEntity languagesEntity);

    ResponseEntity<ApiResponse> editLanguages(Long id , LanguagesEntity languagesEntity);

    ResponseEntity<ApiResponse> deleteLanguages(Long id);

}
