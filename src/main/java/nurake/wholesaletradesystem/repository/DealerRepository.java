/**
 * Created By: NurakeBackendDeveloper
 * Date: 01.05.2023 понедельник
 * Time: 7:55:31
 * Project Name: wholesale-trade-system
 */
package nurake.wholesaletradesystem.repository;

import nurake.wholesaletradesystem.domain.user.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealerRepository extends JpaRepository<Dealer, Long> {
}
