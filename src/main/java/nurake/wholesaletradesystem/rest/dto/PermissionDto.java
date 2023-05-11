/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 16:51:55
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nurake.wholesaletradesystem.enums.PermissionName;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PermissionDto {

    private PermissionName permissionName;

    private String description;

}
