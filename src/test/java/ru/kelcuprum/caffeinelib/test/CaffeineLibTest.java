package ru.kelcuprum.caffeinelib.test;

import com.google.gson.JsonObject;
import ru.kelcuprum.caffeinelib.CoffeeLogger;
import ru.kelcuprum.caffeinelib.WebHelper;
import ru.kelcuprum.caffeinelib.config.Config;

import java.io.IOException;

public class CaffeineLibTest {
    public static CoffeeLogger logger = new CoffeeLogger("CaffeineLib/Test");
    public static Config config = new Config("./give me coffee pls.json");
    public static void main(String[] args) throws IOException, InterruptedException {
        logger.log("Hello, %s!", System.getProperty("user.name"));
        String cfg = config.getString("name", "Kel Cuprum");
        logger.log("Your conf name: %s", cfg);
        if(cfg.contains("Kel")) config.setString("name", "Alina Kotova");
        else config.setString("name", "Kel Cuprum");
        cfg = config.getString("name", "Kel Cuprum");
        logger.warn("Now: %s", cfg);

        JsonObject jsonObject = WebHelper.getJsonObject("https://api.kelcuprum.ru/");
        logger.log(jsonObject.toString());
    }
}
