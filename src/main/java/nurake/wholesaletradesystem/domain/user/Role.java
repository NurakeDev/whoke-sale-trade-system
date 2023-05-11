/**
 * Created By: NurakeBackendDeveloper
 * Date: 21.02.2023 вторник
 * Time: 0:10:43
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.domain.user;

import lombok.*;
import nurake.wholesaletradesystem.domain.Auditable;
import nurake.wholesaletradesystem.enums.RoleName;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Role extends Auditable implements GrantedAuthority {

    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    @Column(name = "description")
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "role_permissions",
            joinColumns = {@JoinColumn(name = "permission_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    @ToString.Exclude
    private Set<Permission> permissions = new HashSet<>();

    @Override
    public String getAuthority() {
        return null;
    }
}
