/**
 * Created By: NurakeBackendDeveloper
 * Date: 09.05.2023 вторник
 * Time: 23:49:06
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import nurake.wholesaletradesystem.rest.dto.RoleDto;
import nurake.wholesaletradesystem.rest.response.SingleResponse;
import nurake.wholesaletradesystem.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/getAll")
    @ApiOperation(value = "Get all roles")
    public ResponseEntity<?> getAllRoles() {
        SingleResponse response = roleService.getAll();
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @GetMapping("/byId/{id}")
    @ApiOperation(value = "Get role by ID")
    public ResponseEntity<?> getOrderById(@PathVariable Long id) {
        SingleResponse response = roleService.findById(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PostMapping("/create")
    @ApiOperation(value = "Create new role")
    public ResponseEntity<?> createOrder(@RequestBody RoleDto roleDto) {
        SingleResponse response = roleService.save(roleDto);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "Update role by ID")
    public ResponseEntity<?> updateOrder(@PathVariable Long id, @RequestBody RoleDto roleDto) {
        SingleResponse response = roleService.update(id, roleDto);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Delete role by ID")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        roleService.delete(id);
        return ResponseEntity.ok().build();
    }
}
