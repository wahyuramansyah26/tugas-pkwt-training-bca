package id.batch7.demospring.services.category;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import id.batch7.demospring.models.dto.request.CategoryRequest;
import id.batch7.demospring.models.dto.response.ResponseData;
import id.batch7.demospring.models.entity.Category;
import id.batch7.demospring.repositories.CategoryRepository;
import id.batch7.demospring.validators.CategoryValidator;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryValidator categoryValidator;

    private Category category;
    private ResponseData responseData;
    private List<Category> categories;

    @Override
    public ResponseData createCategoryService(CategoryRequest categoryRequest) {
        // TODO Auto-generated method stub
        category = new Category();
        category.setName(categoryRequest.getNamaCategory());
        categoryRepository.save(category);
        responseData = new ResponseData(HttpStatus.CREATED.value(), "success", category);
        return responseData;
    }

    @Override
    public ResponseData readCategoryService(Boolean status) {
        // TODO Auto-generated method stub
        if (status == null) {
            categories = categoryRepository.findAll();
        } else {
            categories = categoryRepository.findByIsDeleted(status);
        }
        responseData = new ResponseData(200, "success", categories);
        return responseData;
    }

    @Override
    public ResponseData readCategoryService(Integer id) throws Exception {
        // TODO Auto-generated method stub
        Optional<Category> categoryFind = categoryRepository.findById(id);
        categoryValidator.validateCategoryNotFound(categoryFind);

        category = categoryFind.get();
        responseData = new ResponseData(200, "success", category);
        return responseData;
    }

    @Override
    public ResponseData updateCategoryService(Integer id, CategoryRequest categoryRequest) throws Exception {
        // TODO Auto-generated method stub
        Optional<Category> categoryFind = categoryRepository.findById(id);
        categoryValidator.validateCategoryNotFound(categoryFind);

        category = categoryFind.get();
        category.setName(categoryRequest.getNamaCategory());
        categoryRepository.save(category);
        responseData = new ResponseData(200, "success updated", category);
        return responseData;
    }

    @Override
    public ResponseData deleteCategoryService(Integer id) throws Exception {
        // TODO Auto-generated method stub
        Optional<Category> categoryFind = categoryRepository.findById(id);
        categoryValidator.validateCategoryNotFound(categoryFind);
        category = categoryFind.get();
        categoryValidator.validateIsAlreadyDeleted(category);
        category.setIsDeleted(true);
        categoryRepository.save(category);
        responseData = new ResponseData(200, "success deleted", category);

        return responseData;
    }
    
}
