package primeton.eos8.deploy.service;

import primeton.eos8.deploy.entity.DeployAppEntity;
import primeton.eos8.deploy.vo.appvo.ServiceVo;

import java.util.List;


public interface AppManagerService {
    List<ServiceVo> queryDepolyAppListOfEureka();

    Boolean addDeployApp(String appName, String deployPath);

    Boolean updateDeployApp(DeployAppEntity deployAppEntity);

    List<DeployAppEntity> queryDepolyAppList();

    Boolean deleteDepoyApp(List<Integer> ids);
}
