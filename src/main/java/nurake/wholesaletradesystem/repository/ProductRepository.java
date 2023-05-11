/**
 * Created By: NurakeBackendDeveloper
 * Date: 01.05.2023 понедельник
 * Time: 7:51:51
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.repository;

import nurake.wholesaletradesystem.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findProductByName(String name);

}
