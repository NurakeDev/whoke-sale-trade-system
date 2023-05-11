/**
 * Created By: NurakeBackendDeveloper
 * Date: 02.03.2023 четверг
 * Time: 23:29:56
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.rest.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nurake.wholesaletradesystem.domain.address.Address;
import nurake.wholesaletradesystem.enums.RoleName;


public class AuthRequest {

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class RegisterPartially {

        private String fullName;
        private String phoneNumber;
        private String password;
        private String reTypePassword;
        private Address address;
        private RoleName roleName;

    }

}
