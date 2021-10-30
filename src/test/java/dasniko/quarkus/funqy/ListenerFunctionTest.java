package dasniko.quarkus.funqy;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
public class ListenerFunctionTest {

    @Test
    public void testDynamoDbEvent() {
        InputStream event = this.getClass().getResourceAsStream("/payload.json");
        given().contentType("application/json")
                .accept("application/json")
                .body(event)
                .when()
                .post()
                .then()
                .statusCode(200)
                .body(containsString("eventID: 1"));
    }

}
