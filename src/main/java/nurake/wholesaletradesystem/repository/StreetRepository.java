/**
 * Created By: NurakeBackendDeveloper
 * Date: 01.05.2023 понедельник
 * Time: 7:52:28
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.repository;

import nurake.wholesaletradesystem.domain.address.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreetRepository extends JpaRepository<Street, Long> {
}
