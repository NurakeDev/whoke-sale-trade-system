/**
 * Created By: NurakeBackendDeveloper
 * Date: 16.04.2023 воскресенье
 * Time: 19:44:52
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.rest.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import nurake.wholesaletradesystem.domain.Order;
import nurake.wholesaletradesystem.domain.address.Address;
import nurake.wholesaletradesystem.domain.user.Role;

import java.util.Set;

@AllArgsConstructor
@Data
public class UserResponse {
    private final Long id;

    private String fullName;

    private String phoneNumber;

    private String password;

    private String passwordConfirmation;

    private Address address;

    private Set<Role> roles;

    private Set<Order> orders;
}
