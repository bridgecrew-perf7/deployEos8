package primeton.eos8.deploy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import primeton.eos8.deploy.deployfiles.vo.AppDeployFilesVo;
import primeton.eos8.deploy.service.DeployService;

import java.io.IOException;

@RestController
@RequestMapping("/deploy")
public class DeployController {
    @Autowired
    private DeployService deployService;

    @PostMapping("/deployFileUpload")
    public void upload(@RequestParam("file") MultipartFile file,@RequestParam String appName) {
        if (file == null) {
            throw new IllegalArgumentException();
        } else {
            try {
                deployService.uploadFile(file,appName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @GetMapping("/getAppDeployFiles/appName/{appName}")
    public AppDeployFilesVo getAppDeployFiles(@PathVariable String appName) {
        if (appName.isEmpty()){
            throw new IllegalArgumentException();
        }else {
            return deployService.getAppDeployFiles(appName);
        }
    }
    @PostMapping("/deployApp")
    public void deployApp(@PathVariable("appName") String appName, String[] ip) {

    }

    @DeleteMapping("/deleteDeploy")
    public void deleteDeloy() {

    }

    @GetMapping("/rollbackApp/version/{verison}")
    public void rollbackApp(@PathVariable("version") String verison) {

    }

    @PutMapping("/addDeployPath")
    public void addDeployPath(String Path) {

    }


}
