/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 17:44:16
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.rest.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import nurake.wholesaletradesystem.domain.user.Permission;
import nurake.wholesaletradesystem.enums.RoleName;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Data
public class RoleResponse {

    private final Long id;

    private RoleName roleName;

    private String description;

    private Set<Permission> permissions = new HashSet<>();
}
