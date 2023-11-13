package ebc.ipn.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

@ConfigurationProperties(prefix = "ebc.firebase")
public class FirebaseProperties {
    @Getter @Setter
    private Resource serviceAccount;

}
