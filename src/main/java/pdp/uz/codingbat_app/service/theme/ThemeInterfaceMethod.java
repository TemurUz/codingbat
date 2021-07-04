package pdp.uz.codingbat_app.service.theme;

import org.springframework.http.ResponseEntity;
import pdp.uz.codingbat_app.entity.ThemeEntity;
import pdp.uz.codingbat_app.entity.UsersEntity;
import pdp.uz.codingbat_app.payload.ApiResponse;
import pdp.uz.codingbat_app.payload.ThemeDto;

import java.util.List;

public interface ThemeInterfaceMethod {
    ResponseEntity<List<ThemeEntity>> getThemes(int page, int size);

    ResponseEntity<ThemeEntity> getTheme(Long id);

    ResponseEntity<ApiResponse> saveTheme(ThemeDto themeDto);

    ResponseEntity<ApiResponse> editTheme(Long id , ThemeDto themeDto);

    ApiResponse deleteTheme(Long id);
}
