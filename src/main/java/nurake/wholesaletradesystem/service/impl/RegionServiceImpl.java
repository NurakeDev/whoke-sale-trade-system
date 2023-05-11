/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 17:54:08
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.service.impl;

import lombok.RequiredArgsConstructor;
import nurake.wholesaletradesystem.domain.address.Region;
import nurake.wholesaletradesystem.repository.RegionRepository;
import nurake.wholesaletradesystem.rest.dto.RegionDto;
import nurake.wholesaletradesystem.rest.response.RegionResponse;
import nurake.wholesaletradesystem.rest.response.SingleResponse;
import nurake.wholesaletradesystem.service.RegionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {
    private final RegionRepository regionRepository;

    @Override
    public SingleResponse getAll() {
        List<Region> all = regionRepository.findAll();
        List<RegionResponse> responses = new ArrayList<>();
        for (Region region : all) {
            RegionResponse response = new RegionResponse(
                    region.getId(),
                    region.getName(),
                    region.getStreet()
            );
            responses.add(response);
        }
        return new SingleResponse(true, "Region list ", responses);
    }

    @Override
    public SingleResponse save(RegionDto dto) {
        Region region = new Region();
        region.setName(dto.getName());
        region.setStreet(dto.getStreet());
        regionRepository.save(region);
        return new SingleResponse(true, "Region saved successfully");
    }

    @Override
    public SingleResponse findById(Long id) {
        Optional<Region> byId = regionRepository.findById(id);
        if (byId.isPresent()) {
            Region region = byId.get();
            RegionResponse response = new RegionResponse(
                    region.getId(), region.getName(), region.getStreet()
            );
            return new SingleResponse(true, "Region with id {" + id + "}" , response);
        }
        return new SingleResponse(false, "Region not found with id {" + id + "}", HttpStatus.NOT_FOUND);
    }

    @Override
    public SingleResponse update(Long id, RegionDto dto) {
        Optional<Region> byId = regionRepository.findById(id);
        if (byId.isPresent()) {
            Region region = byId.get();
            if (dto.getName() != null && !region.getName().equals(dto.getName())) {
                region.setName(dto.getName());
            }

            if (dto.getStreet() != null && !region.getStreet().equals(dto.getStreet())) {
                region.setStreet(dto.getStreet());
            }
            return new SingleResponse(true, "Region successfully updated");
        }
        return new SingleResponse(false, "Region not found with id {" + id + "}", HttpStatus.NOT_FOUND);
    }

    @Override
    public SingleResponse delete(Long id) {
        return null;
    }
}
