/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 17:47:32
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.service;

import nurake.wholesaletradesystem.rest.dto.StreetDto;
import nurake.wholesaletradesystem.rest.response.SingleResponse;

public interface StreetService {
    SingleResponse getAll();

    SingleResponse save(StreetDto streetDto);

    SingleResponse findById(Long id);

    SingleResponse update(Long id, StreetDto user);

    SingleResponse delete(Long id);

}
