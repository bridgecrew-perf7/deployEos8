package primeton.eos8.deploy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import primeton.eos8.deploy.entity.DeployFilesEntity;

@Repository
public interface DeployFilesRepository extends JpaRepository<DeployFilesEntity,Integer> {
    DeployFilesEntity findByAppName(String appName);
}
