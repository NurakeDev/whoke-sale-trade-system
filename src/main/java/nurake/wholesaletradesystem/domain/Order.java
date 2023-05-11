/**
 * Created By: NurakeBackendDeveloper
 * Date: 21.02.2023 вторник
 * Time: 15:31:49
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.domain;

import lombok.*;
import nurake.wholesaletradesystem.domain.product.Product;
import nurake.wholesaletradesystem.domain.user.User;
import nurake.wholesaletradesystem.enums.OrderStatus;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order extends Auditable{
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long orderNumber;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "products")
    @ToString.Exclude
    private Set<Product> products = new HashSet<>();

    @Column(name = "summa")
    private Double sum;

    @Column(name = "status")
    private OrderStatus status;

}
