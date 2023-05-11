/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 16:45:37
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nurake.wholesaletradesystem.enums.MeasurementName;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MeasurementDto {

    private MeasurementName measurementName;

    private String description;


}
