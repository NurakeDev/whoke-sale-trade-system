/**
 * Created By: NurakeBackendDeveloper
 * Date: 10.05.2023 среда
 * Time: 18:09:20
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import nurake.wholesaletradesystem.rest.dto.DealerDto;
import nurake.wholesaletradesystem.rest.response.SingleResponse;
import nurake.wholesaletradesystem.service.DealerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/dealer")
@RequiredArgsConstructor
@Api(value = "Dealer managment controller")
public class DealerController {

    private final DealerService service;

    @GetMapping("/getAll")
    @ApiOperation(value = "Get all dealers")
    public ResponseEntity<?> getAllDealer() {
        SingleResponse response = service.getAll();
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @GetMapping("/byId/{id}")
    @ApiOperation(value = "Get dealer by ID")
    public ResponseEntity<?> getDealerById(@PathVariable Long id) {
        SingleResponse response = service.findById(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PostMapping("/create")
    @ApiOperation(value = "Create new dealer")
    public ResponseEntity<?> createDealer(@RequestBody DealerDto dto) {
        SingleResponse response = service.save(dto);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "Update dealer by ID")
    public ResponseEntity<?> updateDealer(@PathVariable Long id, @RequestBody DealerDto dto) {
        SingleResponse response = service.update(id, dto);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Delete dealer by ID")
    public ResponseEntity<?> deleteDealer(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}