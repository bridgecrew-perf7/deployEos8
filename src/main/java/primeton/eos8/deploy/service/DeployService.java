package primeton.eos8.deploy.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import primeton.eos8.deploy.deployfiles.vo.AppDeployFilesVo;

import java.io.IOException;

public interface DeployService {
    void uploadFile(MultipartFile files,String appName) throws IOException;

    AppDeployFilesVo getAppDeployFiles(@PathVariable String appName);

    void deployApp(String appName, String[] ip);

    void deleteDeloy();

    void rollbackApp(String verison);

    void addDeployPath(String Path);

}
