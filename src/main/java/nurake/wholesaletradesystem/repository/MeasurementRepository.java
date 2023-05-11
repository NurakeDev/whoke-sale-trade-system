/**
 * Created By: NurakeBackendDeveloper
 * Date: 01.05.2023 понедельник
 * Time: 7:54:46
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.repository;

import nurake.wholesaletradesystem.domain.product.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
}
