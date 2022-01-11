package utilities;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JSONConfigUtil {
    public static User getUserFromTestEnvironment(int userIndex) {
        try {
            ObjectMapper mapper = new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Config config = mapper.readValue(new File("ConfigTest.json"), Config.class);
            return config.user[userIndex];
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    public static User getUserFromDevEnvironment(int userIndex) {
        try {
            ObjectMapper mapper = new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Config config = mapper.readValue(new File("ConfigDev.json"), Config.class);
            return config.user[userIndex];
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    public static User getUserFromProdEnvironment(int userIndex) {
        try {
            ObjectMapper mapper = new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Config config = mapper.readValue(new File("ConfigProd.json"), Config.class);
            return config.user[userIndex];
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    public static Dito getDitoFromTestEnvironment(int userIndex) {
        try {
            ObjectMapper mapper = new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Config config = mapper.readValue(new File("ConfigTest.json"), Config.class);
            return config.dito[userIndex];
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    public static Dito getDitoFromDevEnvironment(int userIndex) {
        try {
            ObjectMapper mapper = new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Config config = mapper.readValue(new File("ConfigDev.json"), Config.class);
            return config.dito[userIndex];
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    public static Dito getDitoFromProdEnvironment(int userIndex) {
        try {
            ObjectMapper mapper = new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Config config = mapper.readValue(new File("ConfigProd.json"), Config.class);
            return config.dito[userIndex];
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }
}
