package primeton.eos8.deploy.vo.appvo;

import java.util.List;

public class ServiceVo {
    private String serviceName;
    private List<String> host;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public List<String> getHost() {
        return host;
    }

    public void setUri(List<String> host) {
        this.host = host;
    }
}
