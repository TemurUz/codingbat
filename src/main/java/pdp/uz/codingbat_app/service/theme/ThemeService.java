package pdp.uz.codingbat_app.service.theme;

import org.springframework.http.ResponseEntity;
import pdp.uz.codingbat_app.entity.ThemeEntity;
import pdp.uz.codingbat_app.entity.UsersEntity;
import pdp.uz.codingbat_app.payload.ApiResponse;
import pdp.uz.codingbat_app.payload.ThemeDto;

import java.util.List;

public interface ThemeService {

    List<ThemeEntity> getThemes(int page, int size);

    ThemeEntity getTheme(Long id);

    ApiResponse saveTheme(ThemeDto themeDto);

    ApiResponse editTheme(Long id , ThemeDto themeDto);

    ApiResponse deleteTheme(Long id);
}
