package dasniko.quarkus.funqy;

import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;
import io.quarkus.funqy.Funq;

/**
 * @author Niko Köbler, https://www.n-k.de, @dasniko
 */
public class ListenerFunction {

    @Funq
    public String listen(DynamodbEvent event) {
        String stringEvent = event.toString();
        System.out.printf("Received Event: %s", stringEvent);
        return stringEvent;
    }
}
