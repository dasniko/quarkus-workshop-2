package dasniko.quarkus.funqy;

import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;
import io.quarkus.funqy.Funq;
import io.quarkus.logging.Log;

/**
 * @author Niko Köbler, https://www.n-k.de, @dasniko
 */
public class ListenerFunction {

    @Funq
    public String listen(DynamodbEvent event) {
        String stringEvent = event.toString();
        Log.infof("Received Event: %s", stringEvent);
        return stringEvent;
    }
}
