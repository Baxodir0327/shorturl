package uz.pdp.shorturl.services;

import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import uz.pdp.shorturl.entities.AuthUser;
import uz.pdp.shorturl.entities.AuthUserOtp;
import uz.pdp.shorturl.repositories.AuthUserOtpRepository;
import uz.pdp.shorturl.utils.BaseUtils;


import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthUserOtpServiceImpl implements AuthUserOtpService {
    private final AuthUserOtpRepository repository;
    private final BaseUtils utils;

    @Override
    public AuthUserOtp create(@NonNull AuthUserOtp authUserOtp) {
        return repository.save(authUserOtp);
    }

    @Override
    public AuthUserOtp createOTP(@NonNull AuthUser authUser) {
        AuthUserOtp authUserOtp = AuthUserOtp.builder()
                .code(utils.generateOtp(authUser.getId()))
                .userID(authUser.getId())
                .expiresAt(LocalDateTime.now().plusMinutes(10))
                .build();
        return create(authUserOtp);
    }
}
