package primeton.eos8.deploy.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import primeton.eos8.deploy.vo.deployvo.AppDeployFilesVo;

import java.util.List;


public interface DeployService {
    Boolean uploadFile(MultipartFile files, String appName);

    AppDeployFilesVo getAppDeployFiles(@PathVariable String appName);

    void deployApp(String appName, String[] ip);

    Boolean deleteDeployFiles(List<Integer> ids);

    void rollbackApp(String verison);

    void addDeployPath(String Path);

}
