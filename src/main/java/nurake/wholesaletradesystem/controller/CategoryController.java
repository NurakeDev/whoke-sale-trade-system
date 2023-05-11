/**
 * Created By: NurakeBackendDeveloper
 * Date: 10.05.2023 среда
 * Time: 18:15:57
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import nurake.wholesaletradesystem.rest.dto.CategoryDto;
import nurake.wholesaletradesystem.rest.response.SingleResponse;
import nurake.wholesaletradesystem.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @GetMapping("/getAll")
    @ApiOperation(value = "Get all categories")
    public ResponseEntity<?> getAllCategory() {
        SingleResponse response = service.getAll();
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @GetMapping("/byId/{id}")
    @ApiOperation(value = "Get category by ID")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
        SingleResponse response = service.findById(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PostMapping("/create")
    @ApiOperation(value = "Create new category")
    public ResponseEntity<?> createCategory(@RequestBody CategoryDto dto) {
        SingleResponse response = service.save(dto);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "Update category by ID")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody CategoryDto dto) {
        SingleResponse response = service.update(id, dto);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Delete category by ID")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}