package primeton.eos8.deploy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import primeton.eos8.deploy.vo.ServiceVo;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/deployapp")
public class DeployAppController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/queryDepolyAppListOfEureka")
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
