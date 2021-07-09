package primeton.eos8.deploy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import primeton.eos8.deploy.commons.beans.ResultBean;
import primeton.eos8.deploy.entity.DeployAppEntity;
import primeton.eos8.deploy.service.AppManagerService;
import primeton.eos8.deploy.vo.appvo.ServiceVo;

import java.util.List;

@RestController
@RequestMapping("/api/applist")
public class DeployAppController {
    @Autowired
    private AppManagerService appManagerService;


    @GetMapping("/getDepolyAppListByEureka")
    public ResultBean<List<ServiceVo>> getDepolyAppListByEureka() {
        return new ResultBean<List<ServiceVo>>(appManagerService.queryDepolyAppListOfEureka());
    }

    @PostMapping("/addDepoyApp/appName/{appName}")
    public ResultBean<Boolean> addDeployApp(@PathVariable String appName, @RequestParam String deployPath){
        return new ResultBean<Boolean>(appManagerService.addDeployApp(appName,deployPath));
    }

    @PostMapping("/updateDepoyApp")
    public ResultBean<Boolean> updateDeployApp(@RequestBody DeployAppEntity deployAppEntity){
        return new ResultBean<Boolean>(appManagerService.updateDeployApp(deployAppEntity));
    }

    @GetMapping("/queryDepoyAppList/")
    public ResultBean<List<DeployAppEntity>> queryDepolyAppList(){
        return new ResultBean<List<DeployAppEntity>>(appManagerService.queryDepolyAppList());
    }

    @PostMapping("/deleteBathDepoyApp")
    public ResultBean<Boolean> deleteDepoyApp(@RequestBody List<Integer> ids){
        return new ResultBean<Boolean>();
    }
}
