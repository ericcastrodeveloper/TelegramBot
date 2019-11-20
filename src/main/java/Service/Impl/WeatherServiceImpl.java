package Service.Impl;

import Service.WeatherService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.IOException;

public class WeatherServiceImpl implements WeatherService {

    private static final String apiKey = "ad908c7e2c3b6239408cb8469fa0c111";

    @Override
    public String hourlyForecastByCityID(Long id) throws IOException {

        OkHttpClient client = new OkHttpClient();
//
        Request request = new Request.Builder()
                .url("http://api.openweathermap.org/data/2.5/weather?id=" + id + "&appid=" + apiKey + "&units=metric&cnt=5")
                .get()
                .addHeader("Cache-Control", "no-cache")
                .build();

        Response response = client.newCall(request).execute();
        String jsonData = response.body().string();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject) parser.parse(jsonData);
            JSONObject jsonMain = (JSONObject) json.get("main");

            if (jsonMain != null) {
                Object temperatura = jsonMain.get("temp");

                return temperatura.toString();

            }

            return null;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
