package pdp.uz.codingbat_app.controller.languagesCon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.codingbat_app.entity.LanguagesEntity;
import pdp.uz.codingbat_app.interfaces.LanguagesInterfaceMethod;
import pdp.uz.codingbat_app.payload.ApiResponse;
import pdp.uz.codingbat_app.service.languages.LanguagesService;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController  {

    @Autowired
    private LanguagesService languagesService;


//    @Override
    @GetMapping("/list")
    public ResponseEntity<List<LanguagesEntity>> getLanguages(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size){
        ResponseEntity<List<LanguagesEntity>> languages = languagesService.getLanguages(page, size);
        page++;
        return languages;
    }

//    @Override
    @GetMapping("/{id}")
    public ResponseEntity<LanguagesEntity> getLanguage(@PathVariable Long id) {
        return languagesService.getLanguage(id);
    }

    @PostMapping("/save")
//    @Override
    public ResponseEntity<ApiResponse> saveLanguages(@RequestBody  LanguagesEntity languagesEntity) {
        return languagesService.saveLanguages(languagesEntity);
    }

    @PutMapping("/edit")
//    @Override
    public ResponseEntity<ApiResponse> editLanguages(@PathVariable Long id, @RequestBody LanguagesEntity languagesEntity) {
        return languagesService.editLanguages(id, languagesEntity);
    }

    @DeleteMapping("/delete/{id}")
//    @Override
    public ResponseEntity<ApiResponse> deleteLanguages(@PathVariable Long id) {
        ResponseEntity<ApiResponse> apiResponseResponseEntity = languagesService.deleteLanguages(id);
        if (apiResponseResponseEntity.getBody().isSuccess()){
            return apiResponseResponseEntity;
        }
        return ResponseEntity.status(409).body(apiResponseResponseEntity.getBody());
    }
}
