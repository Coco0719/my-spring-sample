package my.spring.sample.config.cloud;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestCloudConfig extends CloudConfig {
    @Override
    @Bean
    void setUp() {
        // Dev 환경일 때 셋업
        System.out.println(super.getName() + ":: " + super.preMessage);
        System.out.println("Test Cloud Configuration");
        System.out.println(super.getHost());
        System.out.println(super.getName() + ":: " + super.postMessage);
    }
}
