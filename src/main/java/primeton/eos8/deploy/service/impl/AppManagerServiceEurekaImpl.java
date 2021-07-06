package primeton.eos8.deploy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import primeton.eos8.deploy.service.AppManagerService;
import primeton.eos8.deploy.app.vo.ServiceVo;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppManagerServiceEurekaImpl implements AppManagerService {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Override
    public List<ServiceVo> queryDepolyAppListOfEureka() {
        List<ServiceVo> serviceVos = new ArrayList<>();
        List<String> services = discoveryClient.getServices();
        for (String server : services) {
            List<ServiceInstance> serviceInstances = discoveryClient.getInstances(server);
            if (!server.equals("registry_center")) {
                ServiceVo serviceVo = new ServiceVo();
                serviceVo.setServiceName(server);
                List<String> uriList = new ArrayList<>();
                for (ServiceInstance instace :
                        serviceInstances) {
                    uriList.add(instace.getHost());
                }
                serviceVo.setUri(uriList);
                serviceVos.add(serviceVo);
            }
        }
        return serviceVos;
    }
}
