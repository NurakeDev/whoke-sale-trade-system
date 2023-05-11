/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 17:54:48
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.service.impl;

import lombok.RequiredArgsConstructor;
import nurake.wholesaletradesystem.domain.address.Street;
import nurake.wholesaletradesystem.repository.StreetRepository;
import nurake.wholesaletradesystem.rest.dto.StreetDto;
import nurake.wholesaletradesystem.rest.response.SingleResponse;
import nurake.wholesaletradesystem.rest.response.StreetResponse;
import nurake.wholesaletradesystem.service.StreetService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StreetServiceImpl implements StreetService {

    private final StreetRepository streetRepository;

    @Override
    public SingleResponse getAll() {
        List<Street> streetList = streetRepository.findAll();
        List<StreetResponse> responses = new ArrayList<>();

        for (Street street : streetList) {
            StreetResponse response = new StreetResponse(
                    street.getId(),
                    street.getName(),
                    street.getHome()
            );

            responses.add(response);

        }

        return new SingleResponse(true, "Streets List", responses);

    }

    @Override
    public SingleResponse save(StreetDto streetDto) {
        Street newStreet = new Street();
        newStreet.setName(streetDto.getName());

        return new SingleResponse(true, "User successfully saved");

    }

    @Override
    public SingleResponse findById(Long id) {
        Optional<Street> byId = streetRepository.findById(id);
        if(byId.isPresent()){
            Street street = byId.get();
            StreetResponse response = new StreetResponse(
                    street.getId(),
                    street.getName(),
                    street.getHome()
            );
            return new SingleResponse(true, "Street with id {" + id + "}", response);
        }
        return new SingleResponse(false, "Street not found with id {" + id + "}");
    }

    @Override
    public SingleResponse update(Long id, StreetDto dto) {
        Optional<Street> byId = streetRepository.findById(id);
        if(byId.isPresent()){
            Street entity = byId.get();

            if(dto.getName() != null && !entity.getName().equals(dto.getName())){
                entity.setName(dto.getName());
            }
            if(dto.getHome() != null && !entity.getHome().equals(dto.getHome())){
                entity.setHome(dto.getHome());
            }

            streetRepository.save(entity);
            return new SingleResponse(true, "Street successfully updated");
        }
        return new SingleResponse(false, "Street not found with id {" + id + "}", HttpStatus.NOT_FOUND);
    }

    @Override
    public SingleResponse delete(Long id) {
        return null;

    }
}
