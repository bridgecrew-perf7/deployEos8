package primeton.eos8.deploy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_deploy_Application")
public class DeployAppEntity extends BaseEntity {

    @Column
    private String appName;

    @Column
    private String deloyPath;

    @Column
    private String appServer;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getDeloyPath() {
        return deloyPath;
    }

    public void setDeloyPath(String deloyPath) {
        this.deloyPath = deloyPath;
    }
}
