/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 17:48:11
 * Project Name: wholesale-trade-system
 */
package nurake.wholesaletradesystem.service;

import nurake.wholesaletradesystem.rest.dto.OrderDto;
import nurake.wholesaletradesystem.rest.response.SingleResponse;

public interface OrderService {
    SingleResponse getAll();

    SingleResponse save(OrderDto orderDto);

    SingleResponse findById(Long id);

    SingleResponse update(Long id, OrderDto dto);

    SingleResponse delete(Long id);

}
