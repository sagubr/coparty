package github.sagubr.util

import java.nio.charset.StandardCharsets

class PasswordEncoder {

    String encodePassword(String password) {
        Base64.encoder
                .encodeToString(password.getBytes(StandardCharsets.UTF_8))
    }
}
