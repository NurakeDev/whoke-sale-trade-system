/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 17:01:45
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.rest.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import nurake.wholesaletradesystem.enums.MeasurementName;

@AllArgsConstructor
@Data
public class MeasurementResponse {

    private final Long id;

    private MeasurementName measurementName;

    private String description;

}
