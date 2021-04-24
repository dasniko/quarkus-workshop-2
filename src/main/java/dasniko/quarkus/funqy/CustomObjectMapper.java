package dasniko.quarkus.funqy;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import io.quarkus.jackson.ObjectMapperCustomizer;

import javax.inject.Singleton;
import java.io.IOException;
import java.util.Date;

/**
 * @author Niko Köbler, https://www.n-k.de, @dasniko
 */
@Singleton
public class CustomObjectMapper extends JsonDeserializer<Date> implements ObjectMapperCustomizer {
    @Override
    public void customize(ObjectMapper objectMapper) {
        objectMapper.registerModules(new SimpleModule().addDeserializer(Date.class, this));
    }

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        double dateSeconds = jsonParser.getValueAsDouble();
        return dateSeconds == 0.0D ? null : new Date((long) (dateSeconds * 1000.0D));
    }
}
