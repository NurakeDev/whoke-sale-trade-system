/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 17:49:36
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.service;

import nurake.wholesaletradesystem.rest.dto.RoleDto;
import nurake.wholesaletradesystem.rest.response.SingleResponse;

public interface RoleService {
    SingleResponse getAll();

    SingleResponse save(RoleDto roleDto);

    SingleResponse findById(Long id);

    SingleResponse update(Long id, RoleDto roleDto);

    SingleResponse delete(Long id);

}
