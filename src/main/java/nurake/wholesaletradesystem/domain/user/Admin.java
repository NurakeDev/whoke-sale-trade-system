/**
 * Created By: NurakeBackendDeveloper
 * Date: 24.02.2023 пятница
 * Time: 22:57:37
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.domain.user;


import lombok.*;
import nurake.wholesaletradesystem.domain.Auditable;
import nurake.wholesaletradesystem.domain.Order;
import nurake.wholesaletradesystem.domain.address.Address;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "admin")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Admin extends Auditable {
    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "password_confirmation")
    private String passwordConfirmation;


    @OneToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(name = "address", nullable = false, unique = true)
    private Address address;

    @OneToMany
    @ToString.Exclude
    @JoinColumn(name = "permissions")
    private Set<Permission> permissions = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    @JoinColumn(name = "orders")
    private Set<Order> orders = new HashSet<>();

}
