/**
 * Created By: NurakeBackendDeveloper
 * Date: 09.05.2023 вторник
 * Time: 16:57:21
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import nurake.wholesaletradesystem.rest.dto.OrderDto;
import nurake.wholesaletradesystem.rest.response.SingleResponse;
import nurake.wholesaletradesystem.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private OrderService orderService;

    @GetMapping("/getAll")
    @ApiOperation(value = "Get all orders")
    public ResponseEntity<?> getAllOrders() {
        SingleResponse response = orderService.getAll();
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @GetMapping("/byId/{id}")
    @ApiOperation(value = "Get order by ID")
    public ResponseEntity<?> getOrderById(@PathVariable Long id) {
        SingleResponse response = orderService.findById(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PostMapping("/create")
    @ApiOperation(value = "Create new order")
    public ResponseEntity<?> createOrder(@RequestBody OrderDto orderDto) {
        SingleResponse response = orderService.save(orderDto);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "Update order by ID")
    public ResponseEntity<?> updateOrder(@PathVariable Long id, @RequestBody OrderDto orderDto) {
        SingleResponse response = orderService.update(id, orderDto);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Delete order by ID")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.ok().build();
    }
}
