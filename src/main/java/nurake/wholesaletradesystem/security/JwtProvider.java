/**
 * Created By: NurakeBackendDeveloper
 * Date: 06.04.2023 четверг
 * Time: 23:25:51
 * Project Name: wholesale-trade-system
 */

package nurake.wholesaletradesystem.security;

import lombok.RequiredArgsConstructor;
import nurake.wholesaletradesystem.domain.user.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class JwtProvider {

    private final JwtEncoder jwtEncoder;

    private Long jwtExpiresMillisSecond = 36_000_000L;


    public String generateToken(Authentication authentication){
        User user = (User) authentication.getPrincipal();
        return generateTokenWithUserName(user.getId(), user.getPhoneNumber());
    }

    private String generateTokenWithUserName(Long id, String phoneNumber) {
        JwtClaimsSet jwtClaimsSet = JwtClaimsSet
                .builder()
                .id(id.toString())
                .issuer("self")
                .issuedAt(Instant.now())
                .expiresAt(Instant.now().plusMillis(jwtExpiresMillisSecond))
                .subject(phoneNumber)
                .claim("scope", "ROLE_USER")
                .claim("userId", id)
                .build();
        return this.jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue();
    }

}
