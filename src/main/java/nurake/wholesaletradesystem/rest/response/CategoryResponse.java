/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 16:59:47
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.rest.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import nurake.wholesaletradesystem.domain.product.Category;
import nurake.wholesaletradesystem.enums.CategoryName;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Data
public class CategoryResponse {

    private final Long id;

    private CategoryName name;

    private String description;

    private Set<Category> subCategories = new HashSet<>();

}
