package my.spring.sample.config.cloud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DevCloudConfig extends CloudConfig {
    @Override
    @Bean
    void setUp() {
        // Dev 환경일 때 셋업
        System.out.println(super.getName() + ":: " + super.preMessage);
        System.out.println("Dev Cloud Configuration");
        System.out.println(super.getHost());
        System.out.println(super.getName() + ":: " + super.postMessage);
    }
}
