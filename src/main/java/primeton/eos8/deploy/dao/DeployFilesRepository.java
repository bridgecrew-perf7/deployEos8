package primeton.eos8.deploy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import primeton.eos8.deploy.entity.DeployFilesEntity;

import java.util.List;

@Repository
public interface DeployFilesRepository extends JpaRepository<DeployFilesEntity,Integer> {
    List<DeployFilesEntity> findByAppNameOrderByIdDesc(String appName);
}
