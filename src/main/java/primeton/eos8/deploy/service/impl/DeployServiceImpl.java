package primeton.eos8.deploy.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import primeton.eos8.deploy.configuration.PathConfig;
import primeton.eos8.deploy.dao.DeployFilesRepository;
import primeton.eos8.deploy.deployfiles.vo.AppDeployFilesVo;
import primeton.eos8.deploy.entity.DeployFilesEntity;
import primeton.eos8.deploy.service.DeployService;

import java.io.File;
import java.io.IOException;

@Service
public class DeployServiceImpl implements DeployService {
    private final Logger logger = LoggerFactory.getLogger(DeployServiceImpl.class);

    @Autowired
    DeployFilesRepository deployFilesRepository;

    @Transactional
    @Override
    public void uploadFile(MultipartFile file, String appName) throws IOException {
        String savePath = PathConfig.path + "/" + file.getOriginalFilename();
        logger.info("fileName:" + file.getOriginalFilename() + "appName:" + appName + "savePath:" + savePath);
        file.transferTo(new File(savePath));
        DeployFilesEntity deployFiles = new DeployFilesEntity();
        deployFiles.setSavePath(savePath);
        deployFiles.setAppName(appName);
        deployFilesRepository.save(deployFiles);
    }

    @Override
    public AppDeployFilesVo getAppDeployFiles(String appName) {
        DeployFilesEntity deployFiles = deployFilesRepository.findByAppName(appName);
        AppDeployFilesVo appDeployFilesVo = new AppDeployFilesVo();
        appDeployFilesVo.setAppName(deployFiles.getAppName());
        appDeployFilesVo.setId(deployFiles.getId());
        appDeployFilesVo.setSavePath(deployFiles.getSavePath());
        return appDeployFilesVo;
    }

    @Override
    public void deployApp(String appName, String[] ip) {

    }

    @Override
    public void deleteDeloy() {

    }

    @Override
    public void rollbackApp(String verison) {

    }

    @Override
    public void queryDeployFileList() {

    }

    @Override
    public void addDeployPath(String Path) {

    }
}
