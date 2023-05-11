/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 17:46:25
 * Project Name: wholesale-trade-system
 */
package nurake.wholesaletradesystem.service;

import nurake.wholesaletradesystem.rest.dto.AddressDto;
import nurake.wholesaletradesystem.rest.response.SingleResponse;

public interface AddressService {
    SingleResponse getAll();

    SingleResponse save(AddressDto addressDto);

    SingleResponse findById(Long id);

    SingleResponse update(Long id, AddressDto addressDto);

    SingleResponse delete(Long id);

}
