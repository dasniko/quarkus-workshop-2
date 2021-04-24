package dasniko.quarkus.funqy;

import io.quarkus.amazon.lambda.test.LambdaClient;
import io.quarkus.test.junit.QuarkusTest;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

@QuarkusTest
public class ListenerFunctionTest {

    @Test
    public void testDynamoDbEvent() throws Exception {
        String event = IOUtils.resourceToString("/payload.json", StandardCharsets.UTF_8);
        String result = LambdaClient.invokeJson(String.class, event);
        Assertions.assertTrue(result.contains("eventID: 1"));
    }

}
