package pdp.uz.codingbat_app.controller.themeCon;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pdp.uz.codingbat_app.entity.ThemeEntity;
import pdp.uz.codingbat_app.interfaces.ThemeInterfaceMethod;
import pdp.uz.codingbat_app.payload.ApiResponse;

import java.util.List;

@RestController
@RequestMapping("/api/theme")
public class ThemeController implements ThemeInterfaceMethod {

    @Override
    public ResponseEntity<List<ThemeEntity>> getThemes(int page, int size) {
        return null;
    }

    @Override
    public ResponseEntity<ThemeEntity> getTheme(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse> saveTheme(ThemeEntity themeEntity) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse> editTheme(Long id, ThemeEntity themeEntity) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse> deleteTheme(Long id) {
        return null;
    }
}
