/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 17:05:54
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.rest.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import nurake.wholesaletradesystem.domain.address.Street;

@AllArgsConstructor
@Data
public class RegionResponse {
    private final Long id;
    private String name;
    private Street street;
}
