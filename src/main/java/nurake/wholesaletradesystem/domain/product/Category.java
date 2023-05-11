/**
 * Created By: NurakeBackendDeveloper
 * Date: 21.02.2023 вторник
 * Time: 3:43:00
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.domain.product;

import lombok.*;
import nurake.wholesaletradesystem.domain.Auditable;
import nurake.wholesaletradesystem.enums.CategoryName;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
@Entity
public class Category extends Auditable {
    @Enumerated
    private CategoryName name;

    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Category> subCategories = new HashSet<>();


}
