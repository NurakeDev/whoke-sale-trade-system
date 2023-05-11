/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 16:50:11
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nurake.wholesaletradesystem.domain.Order;
import nurake.wholesaletradesystem.domain.address.Address;
import nurake.wholesaletradesystem.domain.user.Permission;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AgentDto {
    private String fullName;

    private String phoneNumber;

    private String password;

    private String passwordConfirmation;

    private Address address;

    private Set<Permission> permissions = new HashSet<>();

    private Set<Order> orders = new HashSet<>();
}
