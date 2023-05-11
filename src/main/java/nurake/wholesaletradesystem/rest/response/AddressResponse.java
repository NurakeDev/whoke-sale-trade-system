/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 16:56:52
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.rest.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import nurake.wholesaletradesystem.domain.address.Region;

@AllArgsConstructor
@Data
public class AddressResponse {

    private final Long id;

    private Region region;

}
