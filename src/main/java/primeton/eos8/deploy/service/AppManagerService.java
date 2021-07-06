package primeton.eos8.deploy.service;

import primeton.eos8.deploy.app.vo.ServiceVo;

import java.util.List;


public interface AppManagerService {
    List<ServiceVo> queryDepolyAppListOfEureka();
}
