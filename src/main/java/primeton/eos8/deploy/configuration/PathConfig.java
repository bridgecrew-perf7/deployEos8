package primeton.eos8.deploy.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PathConfig {

    public static String path;

    @Value("${upload.path}")
    public void setPath(String path) {
        PathConfig.path = path;
    }
}
