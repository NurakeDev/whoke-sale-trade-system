/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 17:46:53
 * Project Name: wholesale-trade-system
 */
package nurake.wholesaletradesystem.service;

import nurake.wholesaletradesystem.rest.dto.AdminDto;
import nurake.wholesaletradesystem.rest.response.SingleResponse;

public interface AdminService {
    SingleResponse getAll();

    SingleResponse save(AdminDto adminDto);

    SingleResponse findById(Long id);

    SingleResponse update(Long id, AdminDto adminDto);

    SingleResponse delete(Long id);

}
