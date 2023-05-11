/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 17:45:12
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.rest.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StreetResponse {
    private final Long id;
    private String name;
    private String home;
}
