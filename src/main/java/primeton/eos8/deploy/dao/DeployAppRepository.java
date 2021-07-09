package primeton.eos8.deploy.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import primeton.eos8.deploy.entity.DeployAppEntity;

@Repository
public interface DeployAppRepository extends JpaRepository<DeployAppEntity,Integer> {
}
