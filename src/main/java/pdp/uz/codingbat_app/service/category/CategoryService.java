package pdp.uz.codingbat_app.service.category;

import pdp.uz.codingbat_app.entity.CategoryEntity;
import pdp.uz.codingbat_app.payload.ApiResponse;
import pdp.uz.codingbat_app.payload.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryEntity> getLanguages(int page, int size);

    CategoryEntity getCategory(Long id);

    ApiResponse saveCategory(CategoryDto categoryDto);

    ApiResponse editCategory(Long id, CategoryDto categoryDto);

    ApiResponse deleteCategory(Long id);

}
