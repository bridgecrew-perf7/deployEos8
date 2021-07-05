package primeton.eos8.deploy.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/deploy")
public class DeployController {

    @PostMapping("/deployFileUpload")
    public void upload(@RequestParam("file") MultipartFile[] files) {
        for (MultipartFile file : files) {
            try {
                file.transferTo(new File("E:/temp/" + file.getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @PostMapping("/deployApp")
    public void deployApp(@PathVariable("appName") String appName, String [] ip) {

    }

    @DeleteMapping("/deleteDeploy")
    public void deleteDeloy() {

    }

    @GetMapping("/rollbackApp/version/{verison}")
    public void rollbackApp(@PathVariable("version") String verison) {

    }

    @GetMapping("/queryDeployFileList")
    public void queryDeployFileList() {

    }

    @PutMapping("/addDeployPath")
    public void addDeployPath(String Path) {

    }


}
