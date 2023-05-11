/**
 * Created By: NurakeBackendDeveloper
 * Date: 02.03.2023 четверг
 * Time: 13:39:51
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.controller;

import nurake.wholesaletradesystem.rest.request.AuthRequest;
import nurake.wholesaletradesystem.rest.response.SingleResponse;
import nurake.wholesaletradesystem.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("register/partially")
    public ResponseEntity<?> registerPartially(@RequestBody AuthRequest.RegisterPartially request) {
        SingleResponse response = authService.registerPartially(request);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    

}
