package primeton.eos8.deploy.deployfiles.vo;

import java.util.List;

public class AppDeployFilesVo {
    private List<Integer> id;
    private String appName;
    private List<String> savePath;

    public AppDeployFilesVo(String appName) {
        this.appName = appName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public List<Integer> getId() {
        return id;
    }

    public void setId(List<Integer> id) {
        this.id = id;
    }

    public List<String> getSavePath() {
        return savePath;
    }

    public void setSavePath(List<String> savePath) {
        this.savePath = savePath;
    }
}
