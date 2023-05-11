/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 17:47:20
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.service;

import nurake.wholesaletradesystem.rest.dto.ProductDto;
import nurake.wholesaletradesystem.rest.response.SingleResponse;

public interface ProductService {
    SingleResponse getAll();

    SingleResponse save(ProductDto productDto);

    SingleResponse findById(Long id);

    SingleResponse update(Long id, ProductDto dto);

    SingleResponse delete(Long id);

    SingleResponse getByName(String nameProduct);

}
