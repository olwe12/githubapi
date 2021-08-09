package pl.empik.githubapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class GitHubUserEntity {

    @Id
    private String login;
    private Long requestCount = 0L;

    public GitHubUserEntity() {
    }

    public GitHubUserEntity(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(Long requestCount) {
        this.requestCount = requestCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GitHubUserEntity)) return false;
        GitHubUserEntity that = (GitHubUserEntity) o;
        return Objects.equals(getLogin(), that.getLogin()) &&
                Objects.equals(getRequestCount(), that.getRequestCount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogin(), getRequestCount());
    }

    @Override
    public String toString() {
        return "GitHubUserEntity{" +
                "login='" + login + '\'' +
                ", requestCount='" + requestCount + '\'' +
                '}';
    }
}
