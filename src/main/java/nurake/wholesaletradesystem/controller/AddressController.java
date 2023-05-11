/**
 * Created By: NurakeBackendDeveloper
 * Date: 10.05.2023 среда
 * Time: 17:07:28
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import nurake.wholesaletradesystem.rest.dto.AddressDto;
import nurake.wholesaletradesystem.rest.response.SingleResponse;
import nurake.wholesaletradesystem.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/address")
@RestController
@RequiredArgsConstructor
public class AddressController {

    private final AddressService service;

    @GetMapping("/getAll")
    @ApiOperation(value = "Get all address")
    public ResponseEntity<?> getAllRoles() {
        SingleResponse response = service.getAll();
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @GetMapping("/byId/{id}")
    @ApiOperation(value = "Get address by ID")
    public ResponseEntity<?> getOrderById(@PathVariable Long id) {
        SingleResponse response = service.findById(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PostMapping("/create")
    @ApiOperation(value = "Create new address")
    public ResponseEntity<?> createOrder(@RequestBody AddressDto dto) {
        SingleResponse response = service.save(dto);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "Update address by ID")
    public ResponseEntity<?> updateOrder(@PathVariable Long id, @RequestBody AddressDto dto) {
        SingleResponse response = service.update(id, dto);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Delete role by ID")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}