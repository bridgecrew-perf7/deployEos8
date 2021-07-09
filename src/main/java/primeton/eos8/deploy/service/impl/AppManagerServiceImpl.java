package primeton.eos8.deploy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import primeton.eos8.deploy.dao.DeployAppRepository;
import primeton.eos8.deploy.entity.DeployAppEntity;
import primeton.eos8.deploy.service.AppManagerService;
import primeton.eos8.deploy.vo.appvo.ServiceVo;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppManagerServiceImpl implements AppManagerService {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private DeployAppRepository deployAppRepository;

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

    @Override
    public Boolean addDeployApp(String appName, String deployPath) {
        DeployAppEntity app = new DeployAppEntity();
        app.setAppName(appName);
        app.setDeloyPath(deployPath);
        deployAppRepository.save(app);
        return true;
    }

    @Override
    public Boolean updateDeployApp(DeployAppEntity deployAppEntity) {
        deployAppRepository.saveAndFlush(deployAppEntity);
        return true;
    }

    @Override
    public List<DeployAppEntity> queryDepolyAppList() {
        return deployAppRepository.findAll();
    }

    @Override
    public Boolean deleteDepoyApp(List<Integer> ids) {
        deployAppRepository.deleteAllById(ids);
        return true;
    }
}
