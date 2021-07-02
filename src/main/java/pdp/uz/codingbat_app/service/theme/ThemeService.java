package pdp.uz.codingbat_app.service.theme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pdp.uz.codingbat_app.entity.ThemeEntity;
import pdp.uz.codingbat_app.interfaces.ThemeInterfaceMethod;
import pdp.uz.codingbat_app.payload.ApiResponse;
import pdp.uz.codingbat_app.repository.LanguagesRepository;
import pdp.uz.codingbat_app.repository.ThemeRepository;

import java.util.List;

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
