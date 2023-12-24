package uz.pdp.shorturl.services;

import org.springframework.lang.NonNull;
import uz.pdp.shorturl.dtos.auth.AuthUserCreateDto;
import uz.pdp.shorturl.dtos.auth.GenerateTokenRequest;

public interface AuthUserService {
    String register(@NonNull AuthUserCreateDto dto);

    String generateToken(@NonNull GenerateTokenRequest request);

    String activateAccount(@NonNull String code);
}
