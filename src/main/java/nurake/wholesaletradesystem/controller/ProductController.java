/**
 * Created By: NurakeBackendDeveloper
 * Date: 08.05.2023 понедельник
 * Time: 13:36:25
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.controller;

import lombok.RequiredArgsConstructor;
import nurake.wholesaletradesystem.rest.dto.ProductDto;
import nurake.wholesaletradesystem.rest.response.SingleResponse;
import nurake.wholesaletradesystem.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/product")
public class ProductController {

    private final ProductService service;

    @GetMapping(name = "getOne", path = "/get/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        SingleResponse byId = service.findById(id);
        return ResponseEntity.status(byId.getHttpStatus()).body(byId);
    }

    @GetMapping(name = "all", path = "/getAll")
    public ResponseEntity<?> getAll(){
        SingleResponse response = service.getAll();
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PostMapping(name = "create", path = "/save/{product}")
    public ResponseEntity<?> save(@RequestBody ProductDto dto){
        SingleResponse response = service.save(dto);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PutMapping(name = "update", path = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductDto dto){
        SingleResponse response = service.update(id, dto);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @DeleteMapping(name = "delete", path = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        SingleResponse response = service.delete(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }



}
