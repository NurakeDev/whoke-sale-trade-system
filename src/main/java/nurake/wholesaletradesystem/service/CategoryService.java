/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 17:47:47
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.service;

import nurake.wholesaletradesystem.rest.dto.CategoryDto;
import nurake.wholesaletradesystem.rest.response.SingleResponse;

public interface CategoryService {
    SingleResponse getAll();

    SingleResponse save(CategoryDto categoryDto);

    SingleResponse findById(Long id);

    SingleResponse update(Long id, CategoryDto categoryDto);

    SingleResponse delete(Long id);

}
