package primeton.eos8.deploy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import primeton.eos8.deploy.service.AppManagerService;
import primeton.eos8.deploy.app.vo.ServiceVo;

import java.util.List;

@RestController
@RequestMapping("/deployapp")
public class DeployAppController {
    @Autowired
    private AppManagerService appManagerService;

    @GetMapping("/getDepolyAppList")
    public List<ServiceVo> getDepolyAppList() {
        List<ServiceVo> serviceVos = appManagerService.queryDepolyAppListOfEureka();
        return serviceVos;
    }
}
