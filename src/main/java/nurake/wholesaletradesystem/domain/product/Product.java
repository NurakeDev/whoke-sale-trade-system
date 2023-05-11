/**
 * Created By: NurakeBackendDeveloper
 * Date: 21.02.2023 вторник
 * Time: 3:33:00
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.domain.product;


import lombok.*;
import nurake.wholesaletradesystem.domain.Auditable;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "products")
public class Product extends Auditable {

    @Column(name = "product_name", nullable = false)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "measurement")
    private Measurement measurement;

    @Column(name = "description")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @Column(name = "optom_price", nullable = false)
    private Double wholeSalePrice;

    @Column(name = "price", nullable = false)
    private Double price;

}
