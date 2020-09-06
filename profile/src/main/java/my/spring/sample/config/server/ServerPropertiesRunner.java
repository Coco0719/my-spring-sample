package my.spring.sample.config.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ServerPropertiesRunner implements ApplicationRunner {

    @Autowired
    private ServerProperties serverProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(serverProperties);
    }
}
