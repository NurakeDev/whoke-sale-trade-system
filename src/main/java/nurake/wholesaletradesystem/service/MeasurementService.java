/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 17:48:24
 * Project Name: wholesale-trade-system
 */
package nurake.wholesaletradesystem.service;

import nurake.wholesaletradesystem.rest.dto.MeasurementDto;
import nurake.wholesaletradesystem.rest.response.SingleResponse;

public interface MeasurementService {
    SingleResponse getAll();

    SingleResponse save(MeasurementDto measurementDto);

    SingleResponse findById(Long id);

    SingleResponse update(Long id, MeasurementDto dto);

    SingleResponse delete(Long id);

}
