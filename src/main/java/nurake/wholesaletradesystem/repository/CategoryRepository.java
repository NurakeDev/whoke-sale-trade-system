package nurake.wholesaletradesystem.repository;

import nurake.wholesaletradesystem.domain.product.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}