package my.spring.sample.config.cloud;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("spring.cloud")
public abstract class CloudConfig {

    @Value("${spring.cloud.message.pre}") protected String preMessage;
    @Value("${spring.cloud.message.post}") protected String postMessage;

    private String host;

    private String name;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract void setUp();
}
