/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 17:48:37
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.service;

import nurake.wholesaletradesystem.rest.dto.PermissionDto;
import nurake.wholesaletradesystem.rest.response.SingleResponse;

public interface PermissionService {
    SingleResponse getAll();

    SingleResponse save(PermissionDto permissionDto);

    SingleResponse findById(Long id);

    SingleResponse update(Long id, PermissionDto dto);

    SingleResponse delete(Long id);

}
