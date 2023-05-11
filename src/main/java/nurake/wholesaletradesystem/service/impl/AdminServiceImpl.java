/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 17:51:50
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.service.impl;

import lombok.RequiredArgsConstructor;
import nurake.wholesaletradesystem.domain.user.Admin;
import nurake.wholesaletradesystem.repository.AdminRepository;
import nurake.wholesaletradesystem.rest.dto.AdminDto;
import nurake.wholesaletradesystem.rest.response.AdminResponse;
import nurake.wholesaletradesystem.rest.response.SingleResponse;
import nurake.wholesaletradesystem.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;



    @Override
    public SingleResponse getAll() {
        List<Admin> all = adminRepository.findAll();
        List<AdminResponse> responses = new ArrayList<>();
        for (Admin admin : all) {
            AdminResponse response = new AdminResponse(
                    admin.getId(), admin.getFullName(),
                    admin.getPhoneNumber(),
                    admin.getPassword(),
                    admin.getPasswordConfirmation(),
                    admin.getAddress(),
                    admin.getPermissions(),
                    admin.getOrders()
            );
            responses.add(response);

        }
        return new SingleResponse(true, "Admin List", responses);
    }

    @Override
    public SingleResponse save(AdminDto adminDto) {
        Admin admin = new Admin();
        admin.setFullName(adminDto.getFullName());
        admin.setPassword(adminDto.getPassword());
        admin.setPasswordConfirmation(adminDto.getPasswordConfirmation());
        admin.setPhoneNumber(adminDto.getPhoneNumber());
        admin.setPermissions(adminDto.getPermissions());
        admin.setAddress(adminDto.getAddress());
        admin.setPermissions(adminDto.getPermissions());
        adminRepository.save(admin);
        return new SingleResponse(true, "Admin successfully created", HttpStatus.OK);
    }

    @Override
    public SingleResponse findById(Long id) {
        Optional<Admin> byId = adminRepository.findById(id);
        if (byId.isPresent()) {
            Admin admin = byId.get();
            AdminResponse adminResponse = new AdminResponse(
                    admin.getId(),
                    admin.getFullName(),
                    admin.getPhoneNumber(),
                    admin.getPassword(),
                    admin.getPasswordConfirmation(),
                    admin.getAddress(),
                    admin.getPermissions(),
                    admin.getOrders()
            );
            return new SingleResponse(true, "Admin by id {" + id + "}", adminResponse);
        }
        return new SingleResponse(false, "Admin not found with id {" + id + "}", HttpStatus.NOT_FOUND);
    }

    @Override
    public SingleResponse update(Long id, AdminDto adminDto) {
        Optional<Admin> byId = adminRepository.findById(id);
        if (byId.isPresent()) {
            Admin admin = byId.get();

            if(adminDto.getFullName() != null && !admin.getFullName().equals(adminDto.getFullName())){
                admin.setFullName(adminDto.getFullName());
            }

            if(adminDto.getPhoneNumber() != null && !admin.getPhoneNumber().equals(adminDto.getPhoneNumber())){
                admin.setPhoneNumber(adminDto.getPhoneNumber());
            }

            if(adminDto.getPassword() != null && !admin.getPassword().equals(adminDto.getPassword()) &&
                    adminDto.getPassword().equals(adminDto.getPasswordConfirmation())){
                admin.setPassword(adminDto.getPassword());
            }

            if (adminDto.getPermissions() != null && !admin.getPermissions().equals(adminDto.getPermissions())){
                admin.setPermissions(adminDto.getPermissions());
            }

            if (adminDto.getAddress() != null && !admin.getAddress().equals(adminDto.getAddress())){
                admin.setAddress(adminDto.getAddress());
            }

            if(adminDto.getOrders() != null && !admin.getOrders().equals(adminDto.getOrders())){
                admin.setOrders(adminDto.getOrders());
            }

            adminRepository.save(admin);
            return new SingleResponse(true, "Admin successfully updated");
        }
        return new SingleResponse(false, "Admin not found with id {" + id + "}", HttpStatus.NOT_FOUND);
    }

    @Override
    public SingleResponse delete(Long id) {
        Optional<Admin> byId = adminRepository.findById(id);
        if (byId.isPresent()) {
            Admin admin = byId.get();
            adminRepository.delete(admin);
            return new SingleResponse(true, "Admin successfully deleted");
        }
        return  new SingleResponse(false, "Admin not found with id {" + id + "}", HttpStatus.NOT_FOUND);

    }
}
