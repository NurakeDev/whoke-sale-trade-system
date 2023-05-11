/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 16:47:18
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nurake.wholesaletradesystem.domain.product.Category;
import nurake.wholesaletradesystem.domain.product.Measurement;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
    private String name;

    private Measurement measurement;

    private String description;

    private Category category;

    private Double wholeSalePrice;

    private Double price;

}
