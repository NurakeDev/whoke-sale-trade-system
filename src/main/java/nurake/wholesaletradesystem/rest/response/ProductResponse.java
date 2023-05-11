/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 17:04:59
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.rest.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import nurake.wholesaletradesystem.domain.product.Category;
import nurake.wholesaletradesystem.domain.product.Measurement;

@AllArgsConstructor
@Data
public class ProductResponse {

    private final Long id;

    private String name;

    private Measurement measurement;

    private String description;

    private Category category;

    private Double wholeSalePrice;

    private Double price;
}
