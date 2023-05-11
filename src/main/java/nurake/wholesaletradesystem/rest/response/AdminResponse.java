/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 16:57:47
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.rest.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import nurake.wholesaletradesystem.domain.Order;
import nurake.wholesaletradesystem.domain.address.Address;
import nurake.wholesaletradesystem.domain.user.Permission;

import java.util.Set;

@AllArgsConstructor
@Data
public class AdminResponse {

    private final Long id;

    private String fullName;

    private String phoneNumber;

    private String password;

    private String passwordConfirmation;

    private Address address;

    private Set<Permission> permissions;

    private Set<Order> orders;

}
