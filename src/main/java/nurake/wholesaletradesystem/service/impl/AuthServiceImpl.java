/**
 * Created By: NurakeBackendDeveloper
 * Date: 28.02.2023 вторник
 * Time: 15:36:48
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.service.impl;

import nurake.wholesaletradesystem.domain.user.Role;
import nurake.wholesaletradesystem.exceptions.ResourceNotFoundException;
import nurake.wholesaletradesystem.repository.RoleRepository;
import nurake.wholesaletradesystem.repository.UserRepository;
import nurake.wholesaletradesystem.rest.request.AuthRequest;
import nurake.wholesaletradesystem.rest.response.SingleResponse;
import nurake.wholesaletradesystem.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public AuthServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public SingleResponse registerPartially(AuthRequest.RegisterPartially request) {
        if (userRepository.findByPhoneNumber(request.getPhoneNumber()).isPresent()) {
            return new SingleResponse(false, "Bu raqam tizimda allaqachon mavjud.",
                    HttpStatus.BAD_REQUEST);
        }

        if (!request.getPassword().equals(request.getReTypePassword())) {
            return new SingleResponse(false, "Parol xato kiritildi.",
                    HttpStatus.BAD_REQUEST);
        }

        Role role = roleRepository.findByRoleName(request.getRoleName())
                .orElseThrow(() -> new ResourceNotFoundException("Role topilmadi."));

        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        return userRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found for this phone number: {" + phoneNumber + "}"));

    }
}
