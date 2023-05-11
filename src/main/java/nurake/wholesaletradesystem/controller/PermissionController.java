/**
 * Created By: NurakeBackendDeveloper
 * Date: 10.05.2023 среда
 * Time: 18:12:51
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import nurake.wholesaletradesystem.rest.dto.PermissionDto;
import nurake.wholesaletradesystem.rest.response.SingleResponse;
import nurake.wholesaletradesystem.service.PermissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/permission")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService service;

    @GetMapping("/getAll")
    @ApiOperation(value = "Get all permissions")
    public ResponseEntity<?> getAllAdmin() {
        SingleResponse response = service.getAll();
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @GetMapping("/byId/{id}")
    @ApiOperation(value = "Get permission by ID")
    public ResponseEntity<?> getAdminById(@PathVariable Long id) {
        SingleResponse response = service.findById(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PostMapping("/create")
    @ApiOperation(value = "Create new permission")
    public ResponseEntity<?> createAdmin(@RequestBody PermissionDto dto) {
        SingleResponse response = service.save(dto);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "Update permission by ID")
    public ResponseEntity<?> updateAdmin(@PathVariable Long id, @RequestBody PermissionDto dto) {
        SingleResponse response = service.update(id, dto);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Delete permission by ID")
    public ResponseEntity<?> deleteAdmin(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
