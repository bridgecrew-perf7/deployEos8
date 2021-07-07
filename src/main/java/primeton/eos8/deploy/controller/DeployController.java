package primeton.eos8.deploy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import primeton.eos8.deploy.commons.beans.ResultBean;
import primeton.eos8.deploy.vo.deployvo.AppDeployFilesVo;
import primeton.eos8.deploy.service.DeployService;

import java.util.List;

@RestController
@RequestMapping("/deploy")
public class DeployController {
    @Autowired
    private DeployService deployService;

    @PostMapping("/deployFileUpload")
    public ResultBean<Boolean> upload(@RequestParam("file") MultipartFile file, @RequestParam String appName) {
        return new ResultBean<Boolean>(deployService.uploadFile(file, appName));
    }

    @GetMapping("/getAppDeployFiles/appName/{appName}")
    public ResultBean<AppDeployFilesVo> getAppDeployFiles(@PathVariable String appName) {
        return new ResultBean<AppDeployFilesVo>(deployService.getAppDeployFiles(appName));
    }

    @PostMapping("/deleteDeployFiles")
    public ResultBean<Boolean> deleteDeployFiles(@RequestBody List<Integer> ids) {
        return new ResultBean<Boolean>(deployService.deleteDeployFiles(ids));
    }

    @PostMapping("/deployApp")
    public void deployApp(@PathVariable("appName") String appName, String[] ip) {

    }

    @GetMapping("/rollbackApp/version/{verison}")
    public void rollbackApp(@PathVariable("version") String verison) {

    }

    @PutMapping("/addDeployPath")
    public void addDeployPath(String Path) {

    }
}
