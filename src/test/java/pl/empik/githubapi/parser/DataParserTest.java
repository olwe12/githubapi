package pl.empik.githubapi.parser;

import org.junit.jupiter.api.Test;
import pl.empik.githubapi.model.GitHubUser;
import pl.empik.githubapi.parser.DataParser;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class DataParserTest {

    private static final String FILE_PATH = "src/test/resources/json/octocat.json";
    private DataParser dataParser = new DataParser();

    @Test
    void shouldNotReturnNull_whenParseDataFromJson() throws Exception {
        //given
        String json = readFileAsString(FILE_PATH);
        //when
        GitHubUser gitHubUser = dataParser.parse(json);
        //then
        assertNotNull(gitHubUser);
    }

    @Test
    void shouldCalculationFieldEqualsZero_whenParseDataFromJson() throws Exception {
        //given
        String json = readFileAsString(FILE_PATH);
        //when
        GitHubUser gitHubUser = dataParser.parse(json);
        //then
        assertEquals(0.0, gitHubUser.getCalculation());
    }

    private String readFileAsString(String file) throws Exception {
        return new String(Files.readAllBytes(Paths.get(file)));
    }


}
