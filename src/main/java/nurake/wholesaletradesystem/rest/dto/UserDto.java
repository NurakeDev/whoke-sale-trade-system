/**
 * Created By: NurakeBackendDeveloper
 * Date: 20.04.2023 четверг
 * Time: 19:27:28
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nurake.wholesaletradesystem.domain.Order;
import nurake.wholesaletradesystem.domain.address.Address;
import nurake.wholesaletradesystem.domain.user.Role;

import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

    private String fullName;

    private String phoneNumber;

    private String password;

    private String passwordConfirmation;

    private Address address;

    private Double debt;

    private Set<Role> roles;

    private Set<Order> orders;


}
