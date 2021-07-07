package primeton.eos8.deploy.vo.deployvo;

import java.util.List;

public class AppDeployFilesVo {
    private String appName;
    private List<DeployFilesVo> files;

    public AppDeployFilesVo(String appName) {
        this.appName = appName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public List<DeployFilesVo> getFiles() {
        return files;
    }

    public void setFiles(List<DeployFilesVo> files) {
        this.files = files;
    }
}
