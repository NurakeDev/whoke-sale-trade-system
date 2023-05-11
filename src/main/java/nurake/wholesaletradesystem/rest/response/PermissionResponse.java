/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 17:03:44
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.rest.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import nurake.wholesaletradesystem.enums.PermissionName;

@AllArgsConstructor
@Data
public class PermissionResponse {

    private final Long id;

    private PermissionName permissionName;

    private String description;

}
