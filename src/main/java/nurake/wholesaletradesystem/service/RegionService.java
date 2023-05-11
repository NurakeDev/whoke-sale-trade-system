/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 17:49:25
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.service;

import nurake.wholesaletradesystem.rest.dto.RegionDto;
import nurake.wholesaletradesystem.rest.response.SingleResponse;

public interface RegionService {
    SingleResponse getAll();

    SingleResponse save(RegionDto dto);

    SingleResponse findById(Long id);

    SingleResponse update(Long id, RegionDto regionDto);

    SingleResponse delete(Long id);

}
