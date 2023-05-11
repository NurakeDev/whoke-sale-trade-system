/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 17:53:02
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.service.impl;

import lombok.RequiredArgsConstructor;
import nurake.wholesaletradesystem.domain.product.Measurement;
import nurake.wholesaletradesystem.repository.MeasurementRepository;
import nurake.wholesaletradesystem.rest.dto.MeasurementDto;
import nurake.wholesaletradesystem.rest.response.MeasurementResponse;
import nurake.wholesaletradesystem.rest.response.SingleResponse;
import nurake.wholesaletradesystem.service.MeasurementService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MeasurementServiceImpl implements MeasurementService {
    private final MeasurementRepository measurementRepository;

    @Override
    public SingleResponse getAll() {
        List<Measurement> all = measurementRepository.findAll();
        List<MeasurementResponse> responses = new ArrayList<>();
        for (Measurement measurement : all) {
            MeasurementResponse response = new MeasurementResponse(
                    measurement.getId(),
                    measurement.getMeasurementName(),
                    measurement.getDescription()
            );
            responses.add(response);
        }
        return new SingleResponse(true, "Measurement List ", responses);
    }

    @Override
    public SingleResponse save(MeasurementDto measurementDto) {
        Measurement measurement = new Measurement();
        measurement.setMeasurementName(measurementDto.getMeasurementName());
        measurement.setDescription(measurementDto.getDescription());
        measurementRepository.save(measurement);
        return new SingleResponse(true, "Measurement Saved successfully");
    }

    @Override
    public SingleResponse findById(Long id) {
        Optional<Measurement> byId = measurementRepository.findById(id);
        if (byId.isPresent()){
            Measurement measurement = byId.get();
            MeasurementResponse response = new MeasurementResponse(
                    measurement.getId(),
                    measurement.getMeasurementName(),
                    measurement.getDescription()
            );
            return new SingleResponse(true, "Measurement with id {" + id + "}", response);
        }
        return new SingleResponse(false, "Measurement not found with id {" + id +"}");
    }

    @Override
    public SingleResponse update(Long id, MeasurementDto measurementDto) {
        Optional<Measurement> byId = measurementRepository.findById(id);
        if (byId.isPresent()) {
            Measurement measurement = byId.get();

            if(measurementDto.getDescription() != null && !measurement.getDescription().equals(measurementDto.getDescription())) {
                measurement.setDescription(measurementDto.getDescription());
            }

            if(measurementDto.getMeasurementName() != null && !measurement.getMeasurementName().equals(measurementDto.getMeasurementName())){
                measurement.setMeasurementName(measurementDto.getMeasurementName());
            }
            measurementRepository.save(measurement);

            return new SingleResponse(true, "Measurement successfully updated");

        }
        return new SingleResponse(false, "Measurement not found with id {" + id + "}", HttpStatus.NOT_FOUND);

    }

    @Override
    public SingleResponse delete(Long id) {
        return null;
    }
}
