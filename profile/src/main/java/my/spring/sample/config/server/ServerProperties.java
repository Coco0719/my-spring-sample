package my.spring.sample.config.server;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties("server")
public class ServerProperties {

    private String name;
    private List<Server> cluster = new ArrayList<>();

    public static class Server {
        private String ip;
        private String path;

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        @Override
        public String toString() {
            return "Server{" +
                    "ip='" + ip + '\'' +
                    ", path='" + path + '\'' +
                    '}';
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Server> getCluster() {
        return cluster;
    }

    public void setCluster(List<Server> cluster) {
        this.cluster = cluster;
    }

    @Override
    public String toString() {
        return "ServerProperties{" +
                "name='" + name + '\'' +
                ", cluster=" + cluster +
                '}';
    }
}
