/**
 * Created By: NurakeBackendDeveloper
 * Date: 10.05.2023 среда
 * Time: 17:12:49
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import nurake.wholesaletradesystem.rest.dto.StreetDto;
import nurake.wholesaletradesystem.rest.response.SingleResponse;
import nurake.wholesaletradesystem.service.StreetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/street")
@RequiredArgsConstructor
public class StreetController {

    private final StreetService service;

    @GetMapping(path = "/getAll")
    @ApiOperation(value = "Get all street")
    public ResponseEntity<?> getAllStreet() {
        SingleResponse response = service.getAll();
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @GetMapping("/byId/{id}")
    @ApiOperation(value = "Get street by ID")
    public ResponseEntity<?> getStreetById(@PathVariable Long id) {
        SingleResponse response = service.findById(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PostMapping("/create")
    @ApiOperation(value = "Create new street")
    public ResponseEntity<?> createStreet(@RequestBody StreetDto dto) {
        SingleResponse response = service.save(dto);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "Update street by ID")
    public ResponseEntity<?> updateStreet(@PathVariable Long id, @RequestBody StreetDto dto) {
        SingleResponse response = service.update(id, dto);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Delete street by ID")
    public ResponseEntity<?> deleteStreet(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
