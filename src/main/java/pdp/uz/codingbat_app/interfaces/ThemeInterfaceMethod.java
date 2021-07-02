package pdp.uz.codingbat_app.interfaces;

import org.springframework.http.ResponseEntity;
import pdp.uz.codingbat_app.entity.ThemeEntity;
import pdp.uz.codingbat_app.entity.UsersEntity;
import pdp.uz.codingbat_app.payload.ApiResponse;

import java.util.List;

public interface ThemeInterfaceMethod {
    ResponseEntity<List<ThemeEntity>> getThemes(int page, int size);

    ResponseEntity<ThemeEntity> getTheme(Long id);

    ResponseEntity<ApiResponse> saveTheme(ThemeEntity themeEntity);

    ResponseEntity<ApiResponse> editTheme(Long id , ThemeEntity themeEntity);

    ResponseEntity<ApiResponse> deleteTheme(Long id);
}
