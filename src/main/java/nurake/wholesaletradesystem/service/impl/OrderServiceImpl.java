/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 17:52:42
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.service.impl;

import lombok.RequiredArgsConstructor;
import nurake.wholesaletradesystem.rest.dto.OrderDto;
import nurake.wholesaletradesystem.rest.response.SingleResponse;
import nurake.wholesaletradesystem.service.OrderService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    @Override
    public SingleResponse getAll() {
        return null;
    }

    @Override
    public SingleResponse save(OrderDto orderDto) {
        return null;
    }

    @Override
    public SingleResponse findById(Long id) {
        return null;
    }

    @Override
    public SingleResponse update(Long id, OrderDto orderDto) {
        return null;
    }

    @Override
    public SingleResponse delete(Long id) {
        return null;
    }
}
