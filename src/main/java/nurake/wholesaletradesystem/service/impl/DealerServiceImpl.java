/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 17:52:22
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.service.impl;

import lombok.RequiredArgsConstructor;
import nurake.wholesaletradesystem.domain.user.Dealer;
import nurake.wholesaletradesystem.repository.DealerRepository;
import nurake.wholesaletradesystem.rest.dto.DealerDto;
import nurake.wholesaletradesystem.rest.response.DealerResponse;
import nurake.wholesaletradesystem.rest.response.SingleResponse;
import nurake.wholesaletradesystem.service.DealerService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DealerServiceImpl implements DealerService {
    private final DealerRepository dealerRepository;

    @Override
    public SingleResponse getAll() {

        List<Dealer> all = dealerRepository.findAll();
        ArrayList<DealerResponse> responses = new ArrayList<>();
        for (Dealer dealer : all) {
            DealerResponse response = new DealerResponse(
                    dealer.getId(), dealer.getFullName(),
                    dealer.getPhoneNumber(),
                    dealer.getPassword(),
                    dealer.getPasswordConfirmation(),
                    dealer.getAddress(),
                    dealer.getDebt(),
                    dealer.getPermissions(),
                    dealer.getOrders()
            );
            responses.add(response);

        }
        return new SingleResponse(true, "Admin List", responses);
    }

    @Override
    public SingleResponse save(DealerDto dealerDto) {
        Dealer dealer = new Dealer();
        dealer.setFullName(dealerDto.getFullName());
        dealer.setPassword(dealerDto.getPassword());
        dealer.setPasswordConfirmation(dealerDto.getPasswordConfirmation());
        dealer.setPhoneNumber(dealerDto.getPhoneNumber());
        dealer.setPermissions(dealerDto.getPermissions());
        dealer.setAddress(dealerDto.getAddress());
        dealer.setPermissions(dealerDto.getPermissions());
        dealer.setOrders(dealerDto.getOrders());
        dealerRepository.save(dealer);
        return new SingleResponse(true, "Agent successfully created", HttpStatus.OK);
    }

    @Override
    public SingleResponse findById(Long id) {
        Optional<Dealer> byId = dealerRepository.findById(id);
        if (byId.isPresent()) {
            Dealer dealer = byId.get();
            DealerResponse dealerResponse = new DealerResponse(
                    dealer.getId(),
                    dealer.getFullName(),
                    dealer.getPhoneNumber(),
                    dealer.getPassword(),
                    dealer.getPasswordConfirmation(),
                    dealer.getAddress(),
                    dealer.getDebt(),
                    dealer.getPermissions(),
                    dealer.getOrders()
            );
            return new SingleResponse(true, "Agent by id {" + id + "}", dealerResponse);
        }
        return new SingleResponse(false, "Agent not found with id {" + id + "}", HttpStatus.NOT_FOUND);
    }

    @Override
    public SingleResponse update(Long id, DealerDto dealerDto) {
        Optional<Dealer> byId = dealerRepository.findById(id);
        if (byId.isPresent()) {
            Dealer dealer = byId.get();

            if(dealerDto.getFullName() != null && !dealer.getFullName().equals(dealerDto.getFullName())){
                dealer.setFullName(dealerDto.getFullName());
            }

            if(dealerDto.getPhoneNumber() != null && !dealer.getPhoneNumber().equals(dealerDto.getPhoneNumber())){
                dealer.setPhoneNumber(dealerDto.getPhoneNumber());
            }

            if(dealerDto.getPassword() != null && !dealer.getPassword().equals(dealerDto.getPassword()) &&
                    dealerDto.getPassword().equals(dealerDto.getPasswordConfirmation())){
                dealer.setPassword(dealerDto.getPassword());
            }

            if (dealerDto.getPermissions() != null && !dealer.getPermissions().equals(dealerDto.getPermissions())){
                dealer.setPermissions(dealerDto.getPermissions());
            }

            if (dealerDto.getAddress() != null && !dealer.getAddress().equals(dealerDto.getAddress())){
                dealer.setAddress(dealerDto.getAddress());
            }

            if(dealerDto.getOrders() != null && !dealer.getOrders().equals(dealerDto.getOrders())){
                dealer.setOrders(dealerDto.getOrders());
            }

            if(dealerDto.getDebt() != null  && !dealer.getDebt().equals(dealerDto.getDebt())){
                dealer.setDebt(dealerDto.getDebt());
            }

            dealerRepository.save(dealer);
            return new SingleResponse(true, "Dealer successfully updated");
        }
        return new SingleResponse(false, "Dealer not found with id {" + id + "}", HttpStatus.NOT_FOUND);
    }

    @Override
    public SingleResponse delete(Long id) {
        Optional<Dealer> byId = dealerRepository.findById(id);
        if (byId.isPresent()) {
            Dealer dealer = byId.get();
            dealerRepository.delete(dealer);
            return new SingleResponse(true, "Dealer successfully deleted");
        }
        return  new SingleResponse(false, "Dealer not found with id {" + id + "}", HttpStatus.NOT_FOUND);
    }
}
