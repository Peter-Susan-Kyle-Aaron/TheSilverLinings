import java.io.File;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MGSample {
    // have to do a post request and add a controller

    @Value("${mailgun-api-key}")
    private static String mailGunKey;
    @PostMapping("/email")
    public static JsonNode sendSimpleMessage() throws UnirestException {
        HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/" + "mg.thesilverlining.com" + "/messages")
			.basicAuth("api", mailGunKey)
                .queryString("from", "Excited User <USER@YOURDOMAIN.COM>")
                .queryString("to", "peterjhollman@gmail.com")
                .queryString("subject", "hello")
                .queryString("text", "testing")
                .asJson();
        return request.getBody();
    }
}