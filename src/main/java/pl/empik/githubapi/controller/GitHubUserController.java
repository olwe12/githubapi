package pl.empik.githubapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.empik.githubapi.model.GitHubUser;
import pl.empik.githubapi.model.GitHubUserEntity;
import pl.empik.githubapi.parser.DataParser;
import pl.empik.githubapi.repository.GitHubUserRepository;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.springframework.http.ResponseEntity.status;

@RestController
public class GitHubUserController {

    private static final String API_URL = "https://api.github.com/users/";
    private final GitHubUserRepository repository;

    public GitHubUserController(GitHubUserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users/{login}")
    public Object getUserInfo(@PathVariable String login) {
        try {
            URL url = createUrl(login);
            String dataFromGitHubApi = getDataFromGitHubApi(url);
            GitHubUser data = new DataParser().parse(dataFromGitHubApi);
            repository.saveData(new GitHubUserEntity(login));
            return data;
        } catch (MalformedURLException e) {
            return status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("{\"message\": \"MalformedURLException occur\"}");
        } catch (IOException e) {
            return status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("{\"message\": \"Data not found for login: " + login + "\"}");
        }
    }

    private URL createUrl(String login) throws MalformedURLException {
        return new URL(API_URL + login);
    }

    private String getDataFromGitHubApi(URL url) throws IOException {
        return new String(url.openStream().readAllBytes());
    }
}
