/**
 * Created By: NurakeBackendDeveloper
 * Date: 01.05.2023 понедельник
 * Time: 7:51:05
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.repository;

import nurake.wholesaletradesystem.domain.user.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
}
