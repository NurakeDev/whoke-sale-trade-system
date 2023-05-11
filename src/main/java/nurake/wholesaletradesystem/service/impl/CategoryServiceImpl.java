/**
 * Created By: NurakeBackendDeveloper
 * Date: 10.05.2023 среда
 * Time: 22:03:04
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.service.impl;

import nurake.wholesaletradesystem.domain.product.Category;
import nurake.wholesaletradesystem.repository.CategoryRepository;
import nurake.wholesaletradesystem.rest.dto.CategoryDto;
import nurake.wholesaletradesystem.rest.response.CategoryResponse;
import nurake.wholesaletradesystem.rest.response.SingleResponse;
import nurake.wholesaletradesystem.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public SingleResponse getAll() {
        List<Category> all = categoryRepository.findAll();
        List<CategoryResponse> responses = new ArrayList<>();
        for (Category category : all) {
            CategoryResponse response = new CategoryResponse(
                    category.getId(),
                    category.getName(),
                    category.getDescription(),
                    category.getSubCategories()
            );
            responses.add(response);
        }
        return new SingleResponse(true, "Categories List", responses);
    }

    @Override
    public SingleResponse save(CategoryDto categoryDto) {
        Category entity = new Category();
        entity.setName(categoryDto.getName());
        entity.setDescription(categoryDto.getDescription());
        entity.setSubCategories(categoryDto.getSubCategories());
        categoryRepository.save(entity);
        return new SingleResponse(true, "Category successfully created.", HttpStatus.OK);
    }

    @Override
    public SingleResponse findById(Long id) {
        Optional<Category> byId = categoryRepository.findById(id);
        if (byId.isPresent()) {
            Category category = byId.get();
            CategoryResponse categoryResponse = new CategoryResponse(
                    category.getId(),
                    category.getName(),
                    category.getDescription(),
                    category.getSubCategories()
            );
            return new SingleResponse(true, "Category with id {" + id + "}", categoryResponse);
        }
        return new SingleResponse(false, "Category not found with id {" + id + "}", HttpStatus.NOT_FOUND);
    }

    @Override
    public SingleResponse update(Long id, CategoryDto categoryDto) {
        Optional<Category> byId = categoryRepository.findById(id);
        if (byId.isPresent()) {
            Category category = byId.get();

            if (categoryDto.getName() != null && !category.getName().equals(categoryDto.getName())) {
                category.setName(categoryDto.getName());
            }

            if (categoryDto.getDescription() != null && !category.getDescription().equals(categoryDto.getDescription())) {
                category.setDescription(categoryDto.getDescription());
            }

            if (categoryDto.getSubCategories() != null && !category.getSubCategories().equals(categoryDto.getSubCategories()))  {
                category.setSubCategories(categoryDto.getSubCategories());
            }
            categoryRepository.save(category);
            return new SingleResponse(true, "Category updated successfully", HttpStatus.OK);
        }
        return new SingleResponse(false, "Category not found with id {" + id+ "}", HttpStatus.NOT_FOUND);
    }

    @Override
    public SingleResponse delete(Long id) {
        return null;
    }
}
