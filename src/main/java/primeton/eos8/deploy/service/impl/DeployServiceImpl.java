package primeton.eos8.deploy.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import primeton.eos8.deploy.configuration.PathConfig;
import primeton.eos8.deploy.dao.DeployFilesRepository;
import primeton.eos8.deploy.vo.deployvo.AppDeployFilesVo;
import primeton.eos8.deploy.entity.DeployFilesEntity;
import primeton.eos8.deploy.service.DeployService;
import primeton.eos8.deploy.vo.deployvo.DeployFilesVo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeployServiceImpl implements DeployService {
    private final Logger logger = LoggerFactory.getLogger(DeployServiceImpl.class);

    @Autowired
    DeployFilesRepository deployFilesRepository;

    @Transactional
    @Override
    public Boolean uploadFile(MultipartFile file, String appName) {
        if (file == null || appName.isEmpty()) {
            throw new IllegalArgumentException("file or appName is Empty");
        }
        String savePath = PathConfig.path + "/" + System.currentTimeMillis() + file.getOriginalFilename();
        logger.info("fileName:{},appName:{},savePath:{}", file.getOriginalFilename(), appName, savePath);
        try {
            file.transferTo(new File(savePath));
        } catch (IOException e) {
            logger.error("IO exception:{}", e.getMessage());
            return false;
        }
        DeployFilesEntity deployFiles = new DeployFilesEntity();
        deployFiles.setSavePath(savePath);
        deployFiles.setAppName(appName);
        deployFilesRepository.save(deployFiles);
        return true;
    }

    @Override
    public AppDeployFilesVo getAppDeployFiles(String appName) {
        List<DeployFilesEntity> deployFiles = deployFilesRepository.findByAppNameOrderByIdDesc(appName);
        AppDeployFilesVo appDeployFilesVo = new AppDeployFilesVo(appName);
        List<DeployFilesVo> deployFilesVos = new ArrayList<>();
        for (DeployFilesEntity deployFile : deployFiles) {
            DeployFilesVo dfvo = new DeployFilesVo();
            dfvo.setId(deployFile.getId());
            dfvo.setFilePath(deployFile.getSavePath());
            deployFilesVos.add(dfvo);
        }
        appDeployFilesVo.setFiles(deployFilesVos);
        return appDeployFilesVo;
    }

    @Override
    public Boolean deleteDeployFiles(List<Integer> ids) {
        deployFilesRepository.deleteAllById(ids);
        return true;
    }


    @Override
    public void deployApp(String appName, String[] ip) {

    }


    @Override
    public void rollbackApp(String verison) {

    }

    @Override
    public void addDeployPath(String Path) {

    }
}
