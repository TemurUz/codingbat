package pdp.uz.codingbat_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.codingbat_app.entity.ThemeEntity;
import pdp.uz.codingbat_app.payload.ThemeDto;
import pdp.uz.codingbat_app.payload.ApiResponse;
import pdp.uz.codingbat_app.service.theme.ThemeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/theme")
public class ThemeController  {

    @Autowired
    private ThemeServiceImpl themeService;

    @GetMapping("/list")
    public ResponseEntity<List<ThemeEntity>> getThemes(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        List<ThemeEntity> themes = themeService.getThemes(page, size);
        return ResponseEntity.status(200).body(themes);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ThemeEntity> getTheme(@PathVariable  Long id) {
        ThemeEntity theme = themeService.getTheme(id);
        if (theme == null)
            return ResponseEntity.status(409).body(null);

        return ResponseEntity.status(200).body(theme);
    }


    @PostMapping("/save")
    public ResponseEntity<ApiResponse> saveTheme(@RequestBody ThemeDto themeDto) {
        ApiResponse apiResponse = themeService.saveTheme(themeDto);
        if (!apiResponse.isSuccess())
            return ResponseEntity.status(409).body(apiResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<ApiResponse> editTheme(@PathVariable Long id, @RequestBody ThemeDto themeDto) {

        ApiResponse apiResponse = themeService.editTheme(id, themeDto);

        if (!apiResponse.isSuccess())
            return ResponseEntity.status(409).body(apiResponse);
        return ResponseEntity.status(202).body(apiResponse);
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
