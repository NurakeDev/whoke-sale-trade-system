/**
 * Created By: NurakeBackendDeveloper
 * Date: 10.02.2023 пятница
 * Time: 13:59:07
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.domain.user;

import lombok.*;
import nurake.wholesaletradesystem.domain.Auditable;
import nurake.wholesaletradesystem.domain.Order;
import nurake.wholesaletradesystem.domain.address.Address;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User extends Auditable implements UserDetails {

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

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @ToString.Exclude
    private Set<Role> roles;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    @JoinColumn(name = "orders")
    private Set<Order> orders = new HashSet<>();

    boolean accountNonExpired = true;       // Bu user akkountning amal qilish muddati o`tmagan
    boolean accountNonLocked = true;        // Bu user akkountning bloklanmaganligi
    boolean credentialsNonExpired = false;  // Bu user akkountning credential lari amal qilish muddati o`tmagan
    boolean enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection< GrantedAuthority> authorities = new HashSet<>(getRoles());
        getRoles()
                .stream()
                .map(Role::getPermissions)
                .forEach(authorities::addAll);
        return authorities;
    }

    @Override
    public String getUsername() {
        return getFullName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

}
