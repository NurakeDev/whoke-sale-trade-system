/**
 * Created By: NurakeBackendDeveloper
 * Date: 01.05.2023 понедельник
 * Time: 7:47:57
 * Project Name: wholesale-trade-system
 */
package nurake.wholesaletradesystem.repository;

import nurake.wholesaletradesystem.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
