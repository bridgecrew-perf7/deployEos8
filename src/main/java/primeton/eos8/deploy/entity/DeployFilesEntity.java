package primeton.eos8.deploy.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_deploy_files")
public class DeployFilesEntity extends BaseEntity{

    @Column
    private String appName;

    @Column
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
