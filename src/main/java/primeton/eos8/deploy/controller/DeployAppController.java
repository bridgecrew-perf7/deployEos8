package primeton.eos8.deploy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import primeton.eos8.deploy.commons.beans.ResultBean;
import primeton.eos8.deploy.service.AppManagerService;
import primeton.eos8.deploy.vo.appvo.ServiceVo;

import java.util.List;

@RestController
@RequestMapping("/deployapp")
public class DeployAppController {
    @Autowired
    private AppManagerService appManagerService;

    @GetMapping("/getDepolyAppListByEureka")
    public ResultBean<List<ServiceVo>> getDepolyAppListByEureka() {
        return new ResultBean<List<ServiceVo>>(appManagerService.queryDepolyAppListOfEureka());
    }

    public void addDeployApp(){

    }

    public void editDeployApp(){

    }

    public void queryDepolyAppList(){

    }
}
