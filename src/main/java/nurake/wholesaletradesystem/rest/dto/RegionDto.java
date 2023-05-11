/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 16:42:21
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nurake.wholesaletradesystem.domain.address.Street;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class RegionDto {
    private String name;
    private Street street;
}
