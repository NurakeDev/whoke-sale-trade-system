/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 17:51:26
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.service.impl;

import lombok.RequiredArgsConstructor;
import nurake.wholesaletradesystem.domain.address.Address;
import nurake.wholesaletradesystem.repository.AddressRepository;
import nurake.wholesaletradesystem.rest.dto.AddressDto;
import nurake.wholesaletradesystem.rest.response.AddressResponse;
import nurake.wholesaletradesystem.rest.response.SingleResponse;
import nurake.wholesaletradesystem.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Override
    public SingleResponse getAll() {
        List<Address> all = addressRepository.findAll();
        List<AddressResponse> responses = new ArrayList<>();
        for (Address address : all) {
            AddressResponse response = new AddressResponse(
                    address.getId(),
                    address.getRegion()
            );
            responses.add(response);
        }
        return new SingleResponse(true, "Region List ", responses);
    }

    @Override
    public SingleResponse save(AddressDto addressDto) {
        Address address = new Address();
        address.setRegion(addressDto.getRegion());
        addressRepository.save(address);
        return new SingleResponse(true, "Address Saved successfully");
    }

    @Override
    public SingleResponse findById(Long id) {
        Optional<Address> byId = addressRepository.findById(id);
        if (byId.isPresent()) {
            Address address = byId.get();
            AddressResponse response = new AddressResponse(
                    address.getId(),
                    address.getRegion()
            );
            return new SingleResponse(true, "Address with id {" + id + "}", response);
        }
        return new SingleResponse(false, "Address not found with id {" + id + "}", HttpStatus.NOT_FOUND);
    }

    @Override
    public SingleResponse update(Long id, AddressDto addressDto) {
        Optional<Address> byId = addressRepository.findById(id);
        if (byId.isPresent()) {
            Address address = byId.get();
            if (addressDto.getRegion() != null && !address.getRegion().equals(addressDto.getRegion())) {
                address.setRegion(addressDto.getRegion());
            }
            addressRepository.save(address);
            return new SingleResponse(true, "Address updated successfully");
        }
        return new SingleResponse(false, "Address not found with id {" + id + "}", HttpStatus.NOT_FOUND);
    }

    @Override
    public SingleResponse delete(Long id) {
        return null;
    }
}
