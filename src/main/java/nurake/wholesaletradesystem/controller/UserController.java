/**
 * Created By: NurakeBackendDeveloper
 * Date: 02.03.2023 четверг
 * Time: 8:22:51
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import nurake.wholesaletradesystem.rest.dto.UserDto;
import nurake.wholesaletradesystem.rest.response.SingleResponse;
import nurake.wholesaletradesystem.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //@Secured({"ADMIN"})
    @GetMapping(name = "all",path = "/list")
    @ApiOperation(value = "Get all users")
    public ResponseEntity<?> getAll(){
        SingleResponse list = userService.getAll();
        return ResponseEntity.status(list.getHttpStatus()).body(list);
    }

    @PostMapping (name = "save",path = "/save/{userDto}")
    public ResponseEntity<?> save(@RequestBody UserDto userDto){
        SingleResponse response = userService.save(userDto);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @GetMapping(name = "byId",path = "/byId/{id}")
    public ResponseEntity<?> findById(@RequestParam Long id) {
        SingleResponse response = userService.findById(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PutMapping(name = "update", path = "/update/{id}")
    public ResponseEntity<?> update(@RequestParam Long id, @RequestBody UserDto dto){
        SingleResponse response = userService.update(id, dto);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @DeleteMapping(name = "delete",path = "/delete/{id}")
    public ResponseEntity<?> delete(@RequestParam Long id) {
        SingleResponse response = userService.delete(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

}