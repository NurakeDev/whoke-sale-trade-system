package nurake.wholesaletradesystem.repository;

import nurake.wholesaletradesystem.domain.user.Role;
import nurake.wholesaletradesystem.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleName(RoleName roleName);
}