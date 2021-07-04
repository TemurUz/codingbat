package pdp.uz.codingbat_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.codingbat_app.entity.ThemeEntity;
import pdp.uz.codingbat_app.payload.ThemeDto;
import pdp.uz.codingbat_app.service.theme.ThemeInterfaceMethod;
import pdp.uz.codingbat_app.payload.ApiResponse;
import pdp.uz.codingbat_app.service.theme.ThemeService;

import java.util.List;

@RestController
@RequestMapping("/api/theme")
public class ThemeController  {

    @Autowired
    private ThemeService themeService;

    @GetMapping("/list")
    public ResponseEntity<List<ThemeEntity>> getThemes(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        ResponseEntity<List<ThemeEntity>> themes = themeService.getThemes(page, size);
        return themes;
    }


    @GetMapping("/{id}")
    public ResponseEntity<ThemeEntity> getTheme(@PathVariable  Long id) {
        return themeService.getTheme(id);
    }


    @PostMapping("/save")
    public ResponseEntity<ApiResponse> saveTheme(@RequestBody ThemeDto themeDto) {
        return themeService.saveTheme(themeDto);
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<ApiResponse> editTheme(@PathVariable Long id, @RequestBody ThemeDto themeDto) {

        return themeService.editTheme(id, themeDto);

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteTheme(@PathVariable Long id) {
        ApiResponse apiResponse = themeService.deleteTheme(id);
        if (apiResponse.isSuccess())
            return ResponseEntity.status(202).body(apiResponse);

        else
            return ResponseEntity.status(409).body(apiResponse);
    }
}
