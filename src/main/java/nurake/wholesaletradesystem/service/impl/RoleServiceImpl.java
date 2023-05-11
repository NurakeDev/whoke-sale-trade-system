/**
 * Created By: NurakeBackendDeveloper
 * Date: 27.04.2023 четверг
 * Time: 17:54:29
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.service.impl;

import lombok.RequiredArgsConstructor;
import nurake.wholesaletradesystem.domain.user.Role;
import nurake.wholesaletradesystem.repository.RoleRepository;
import nurake.wholesaletradesystem.rest.dto.RoleDto;
import nurake.wholesaletradesystem.rest.response.RoleResponse;
import nurake.wholesaletradesystem.rest.response.SingleResponse;
import nurake.wholesaletradesystem.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public SingleResponse getAll() {
        List<Role> roles = roleRepository.findAll();
        List<RoleResponse> responses = new ArrayList<>();
        for (Role role : roles) {
            RoleResponse response = new RoleResponse(
                    role.getId(),
                    role.getRoleName(),
                    role.getDescription(),
                    role.getPermissions()
            );
            responses.add(response);
        }
        return new SingleResponse(true, "Role List: ", responses);
    }

    @Override
    public SingleResponse save(RoleDto roleDto) {
        Role role = new Role(
                roleDto.getRoleName(),
                roleDto.getDescription(),
                roleDto.getPermissions()
        );
        roleRepository.save(role);
        return new SingleResponse(true, "Role successfully saved: ");
    }

    @Override
    public SingleResponse findById(Long id) {
        Optional<Role> byId = roleRepository.findById(id);
        if (byId.isPresent()) {
            Role role = byId.get();
            RoleResponse response = new RoleResponse(
                    role.getId(),
                    role.getRoleName(),
                    role.getDescription(),
                    role.getPermissions()
            );
            return new SingleResponse(true, "Role with id {" + id + "}", response);
        }
        return new SingleResponse(false, "Role not found with id {" + id + "}", HttpStatus.NOT_FOUND);
    }

    @Override
    public SingleResponse update(Long id, RoleDto roleDto) {
        Optional<Role> byId = roleRepository.findById(id);
        if (byId.isPresent()) {
            Role role = byId.get();
            if (roleDto.getRoleName() != null && !role.getRoleName().equals(roleDto.getRoleName())) {
                role.setRoleName(roleDto.getRoleName());
            }
            if (roleDto.getDescription() != null && !role.getDescription().equals(roleDto.getDescription())){
                role.setDescription(roleDto.getDescription());
            }
            if (roleDto.getPermissions() != null && !role.getPermissions().equals(roleDto.getPermissions())){
                role.setPermissions(roleDto.getPermissions());
            }

            roleRepository.save(role);
            return new SingleResponse(true, "Role updated successfully");
        }
        return new SingleResponse(false, "Role not found with id {" + id + "}", HttpStatus.NOT_FOUND);
    }

    @Override
    public SingleResponse delete(Long id) {
        return null;
    }
}
