package pl.empik.githubapi.model;

import com.google.gson.annotations.SerializedName;

public class GitHubUser {

    public GitHubUser() {
    }

    @SerializedName("id")
    private Integer id;
    @SerializedName("login")
    private String login;
    @SerializedName("name")
    private String name;
    @SerializedName("type")
    private String type;
    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("created_at")
    private String createdAt;
    private Double calculation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Double getCalculation() {
        return calculation;
    }

    public void setCalculation(Double calculation) {
        this.calculation = calculation;
    }

    @Override
    public String toString() {
        return "GitHubUser{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", calculation=" + calculation +
                '}';
    }
}

