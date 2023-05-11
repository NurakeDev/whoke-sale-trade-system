/**
 * Created By: NurakeBackendDeveloper
 * Date: 01.05.2023 понедельник
 * Time: 7:53:11
 * Project Name: wholesale-trade-system
 */
package nurake.wholesaletradesystem.repository;

import nurake.wholesaletradesystem.domain.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
