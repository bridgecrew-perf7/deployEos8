package primeton.eos8.deploy.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_deploy_files")
public class DeployFilesEntity extends BaseEntity{

    @Column(name = "appname")
    private String appName;

    @Column(name = "savepath")
    private String savePath;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }
}
