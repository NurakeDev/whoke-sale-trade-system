/**
 * Created By: NurakeBackendDeveloper
 * Date: 10.05.2023 среда
 * Time: 18:23:58
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import nurake.wholesaletradesystem.rest.dto.MeasurementDto;
import nurake.wholesaletradesystem.rest.response.SingleResponse;
import nurake.wholesaletradesystem.service.MeasurementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/measurement")
@RequiredArgsConstructor
public class MeasurementController {

    private final MeasurementService service;

    @GetMapping("/getAll")
    @ApiOperation(value = "Get all measurements")
    public ResponseEntity<?> getAllMeasurement() {
        SingleResponse response = service.getAll();
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @GetMapping("/byId/{id}")
    @ApiOperation(value = "Get measurement by ID")
    public ResponseEntity<?> getMeasurementById(@PathVariable Long id) {
        SingleResponse response = service.findById(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PostMapping("/create")
    @ApiOperation(value = "Create new measurement")
    public ResponseEntity<?> createMeasurement(@RequestBody MeasurementDto dto) {
        SingleResponse response = service.save(dto);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "Update measurement by ID")
    public ResponseEntity<?> updateMeasurement(@PathVariable Long id, @RequestBody MeasurementDto dto) {
        SingleResponse response = service.update(id, dto);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Delete measurement by ID")
    public ResponseEntity<?> deleteMeasurement(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
