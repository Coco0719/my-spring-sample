package my.spring.sample.config.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
public class DatabaseConfig {

    @Value("${spring.datasource.message.pre}") private String preMessage;
    @Value("${spring.datasource.message.post}") private String postMessage;

    private String url;
    private String username;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Profile("dev")
    @Bean
    public void devConnectionSetting() {
        System.out.println("Dev:: " + preMessage);
        System.out.println(username);
        System.out.println(url);
        System.out.println("Dev:: " + postMessage);
    }

    @Profile("test")
    @Bean
    public void testConnectionSetting() {
        System.out.println("Test:: " + preMessage);
        System.out.println(username);
        System.out.println(url);
        System.out.println("Test:: " + postMessage);
    }

    @Profile("prod")
    @Bean
    public void prodConnectionSetting() {
        System.out.println("Prod:: " + preMessage);
        System.out.println(username);
        System.out.println(url);
        System.out.println("Prod:: " + postMessage);
    }
}
