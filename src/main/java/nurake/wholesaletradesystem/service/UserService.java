/**
 * Created By: NurakeBackendDeveloper
 * Date: 13.04.2023 четверг
 * Time: 21:03:41
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.service;

import nurake.wholesaletradesystem.rest.dto.UserDto;
import nurake.wholesaletradesystem.rest.response.SingleResponse;

public interface UserService {
    SingleResponse getAll();

    SingleResponse save(UserDto user);

    SingleResponse findById(Long id);

    SingleResponse update(Long id, UserDto user);

    SingleResponse delete(Long id);

}
