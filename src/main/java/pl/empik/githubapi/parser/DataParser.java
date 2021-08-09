package pl.empik.githubapi.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import pl.empik.githubapi.model.GitHubUser;

public class DataParser {

    public GitHubUser parse(String json) {
        final Gson gson = new GsonBuilder().create();
        GitHubUser gitHubUser = parseJsonToPojo(json, gson);
        final double calculation = computeDataForCalculationField(json, gson);
        gitHubUser.setCalculation(calculation);
        return gitHubUser;
    }

    private GitHubUser parseJsonToPojo(String json, Gson gson) {
        return gson.fromJson(json, GitHubUser.class);
    }

    private double computeDataForCalculationField(String json, Gson gson) {
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        final long publicRepos = jsonObject.getAsJsonObject().get("public_repos").getAsLong();
        final long followers = jsonObject.getAsJsonObject().get("followers").getAsLong();
        return followers == 0L ? 0 : 6.0 / followers * (2.0 + publicRepos);
    }
}
