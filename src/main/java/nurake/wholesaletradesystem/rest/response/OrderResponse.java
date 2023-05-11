/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 17:02:29
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.rest.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import nurake.wholesaletradesystem.domain.product.Product;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Data
public class OrderResponse {

    private final Long id;

    private Long orderNumber;

    private String name;

    private Set<Product> products = new HashSet<>();

    private Double sum;

    private boolean status;
}
