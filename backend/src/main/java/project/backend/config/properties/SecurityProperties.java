package project.backend.config.properties;

import project.backend.config.SecurityPropertiesConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * This configuration class offers all necessary security properties in an immutable manner.
 */
@Component
@RequiredArgsConstructor
public class SecurityProperties {

    private final SecurityPropertiesConfig.Auth auth;
    private final SecurityPropertiesConfig.Jwt jwt;

    public String getAuthHeader() {
        return auth.getHeader();
    }

    public String getAuthTokenPrefix() {
        return auth.getPrefix();
    }

    public String getLoginUri() {
        return auth.getLoginUri();
    }

    public String getJwtSecret() {
        return jwt.getSecret();
    }

    public String getJwtType() {
        return jwt.getType();
    }

    public String getJwtIssuer() {
        return jwt.getIssuer();
    }

    public String getJwtAudience() {
        return jwt.getAudience();
    }

    public Long getJwtExpirationTime() {
        return jwt.getExpirationTime();
    }

}
