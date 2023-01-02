package id.batch7.demospring.services.category;

import id.batch7.demospring.models.dto.request.CategoryRequest;
import id.batch7.demospring.models.dto.response.ResponseData;

public interface CategoryService {
    ResponseData createCategoryService(CategoryRequest categoryRequest);
    ResponseData readCategoryService(Boolean status);
    ResponseData readCategoryService(Integer id) throws Exception;
    ResponseData updateCategoryService(Integer id, CategoryRequest categoryRequest) throws Exception;
    ResponseData deleteCategoryService(Integer id) throws Exception;
}
