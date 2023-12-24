package uz.pdp.shorturl.services;

import org.springframework.lang.NonNull;
import uz.pdp.shorturl.entities.AuthUser;
import uz.pdp.shorturl.entities.AuthUserOtp;

public interface AuthUserOtpService {

    AuthUserOtp create(@NonNull AuthUserOtp authUserOtp);

    AuthUserOtp createOTP(@NonNull AuthUser authUser);
}
