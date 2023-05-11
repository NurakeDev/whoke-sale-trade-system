/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 17:47:57
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.service;

import nurake.wholesaletradesystem.rest.dto.DealerDto;
import nurake.wholesaletradesystem.rest.response.SingleResponse;

public interface DealerService {
    SingleResponse getAll();

    SingleResponse save(DealerDto dealerDto);

    SingleResponse findById(Long id);

    SingleResponse update(Long id, DealerDto dto);

    SingleResponse delete(Long id);

}
