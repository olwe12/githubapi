package pl.empik.githubapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.empik.githubapi.model.GitHubUserEntity;

import java.util.Optional;

@Repository
public interface GitHubUserRepository extends JpaRepository<GitHubUserEntity, String> {
    default GitHubUserEntity saveData(GitHubUserEntity gitHubUserEntity) {
        final Optional<GitHubUserEntity> userInfo = findById(gitHubUserEntity.getLogin());
        GitHubUserEntity entity = userInfo.orElse(gitHubUserEntity);
        entity.setRequestCount(entity.getRequestCount() + 1);
        return save(entity);
    }
}
