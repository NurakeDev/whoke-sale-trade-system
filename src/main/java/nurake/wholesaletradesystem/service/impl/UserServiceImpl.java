/**
 * Created By: NurakeBackendDeveloper
 * Date: 13.04.2023 четверг
 * Time: 21:06:06
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.service.impl;


import lombok.RequiredArgsConstructor;
import nurake.wholesaletradesystem.domain.user.User;
import nurake.wholesaletradesystem.repository.UserRepository;
import nurake.wholesaletradesystem.rest.dto.UserDto;
import nurake.wholesaletradesystem.rest.response.SingleResponse;
import nurake.wholesaletradesystem.rest.response.UserResponse;
import nurake.wholesaletradesystem.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public SingleResponse getAll() {
        List<User> users = userRepository.findAll();
        List<UserResponse> responses = new ArrayList<>();

        for (User user : users) {
            UserResponse respone = new UserResponse(
                    user.getId(),
                    user.getFullName(),
                    user.getPhoneNumber(),
                    user.getPassword(),
                    user.getPasswordConfirmation(),
                    user.getAddress(),
                    user.getRoles(),
                    user.getOrders()
            );
            responses.add(respone);
        }
        return new SingleResponse(true, "Users List", responses);
    }

    @Override
    public SingleResponse save(UserDto dto) {
        User newUser = new User();
        newUser.setFullName(dto.getFullName());
        newUser.setPhoneNumber(dto.getPhoneNumber());
        newUser.setPassword(dto.getPassword());
        newUser.setPasswordConfirmation(dto.getPasswordConfirmation());
        newUser.setAddress(dto.getAddress());
        newUser.setRoles(dto.getRoles());
        newUser.setOrders(dto.getOrders());

        User savedUser = userRepository.save(newUser);

        return new SingleResponse(true, "User successfully saved");
    }

    @Override
    public SingleResponse findById(Long id) {
        Optional<User> userById = userRepository.findById(id);
        if (userById.isPresent()) {
            User user = userById.get();

            UserResponse newResponse = new UserResponse(
                    user.getId(),
                    user.getFullName(),
                    user.getPhoneNumber(),
                    user.getPassword(),
                    user.getPasswordConfirmation(),
                    user.getAddress(),
                    user.getRoles(),
                    user.getOrders()
            );
            return new SingleResponse(true, "User with ID {" + id + "}", newResponse);
        }
        return new SingleResponse(false, "User not found with ID {" + id + "}", HttpStatus.NOT_FOUND);
    }

    @Override
    public SingleResponse update(Long id, UserDto dto) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {

            User entity = byId.get();
            if (dto.getFullName() != null && !entity.getFullName().equals(dto.getFullName())) {
                entity.setFullName(dto.getFullName());
            }

            if (dto.getPhoneNumber() != null && !entity.getPhoneNumber().equals(dto.getPhoneNumber())) {
                entity.setPhoneNumber(dto.getPhoneNumber());
            }

            if (dto.getPassword() != null && !entity.getPassword().equals(dto.getPassword()) &&
                    dto.getPassword().equals(dto.getPasswordConfirmation())) {
                entity.setPassword(dto.getPassword());
            }

            if (dto.getAddress() != null && !entity.getAddress().equals(dto.getAddress())) {
                entity.setAddress(dto.getAddress());
            }

            if (dto.getRoles() != null && !entity.getRoles().equals(dto.getRoles())) {
                entity.setRoles(dto.getRoles());
            }

            if (dto.getOrders() != null && !entity.getOrders().equals(dto.getOrders())) {
                entity.setOrders(dto.getOrders());
            }

            userRepository.save(entity);
            return new SingleResponse(true, "User saved successfully", HttpStatus.OK);
        }
        return new SingleResponse(false, "User not found with id " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public SingleResponse delete(Long id) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            User user = byId.get();
            userRepository.delete(user);

            return new SingleResponse(true, "User deleted successfully", HttpStatus.OK);
        }
        return  new SingleResponse(false, "User not found with id: " + id, HttpStatus.NOT_FOUND);
    }
}