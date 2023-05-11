/**
 * Created By: NurakeBackendDeveloper
 * Date: 21.02.2023 вторник
 * Time: 0:13:27
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.domain.user;

import lombok.*;
import nurake.wholesaletradesystem.domain.Auditable;
import nurake.wholesaletradesystem.enums.PermissionName;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "permissions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Permission extends Auditable implements GrantedAuthority
{
    @Enumerated(EnumType.STRING)
    private PermissionName permissionName;

    @Column(name = "description")
    private String description;

    @Override
    public String getAuthority() {
        return null;
    }
}
