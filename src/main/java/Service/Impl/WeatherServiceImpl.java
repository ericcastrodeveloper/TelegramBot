package Service.Impl;

import Service.WeatherService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/**Classe que implementa o serviço de busca de temperatura do openweathermap
 * @author Eric Castro Santos
 * @version 1.00
 */
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

        StringBuilder climaTempo = new StringBuilder();
        try {
            JSONObject json = (JSONObject) parser.parse(jsonData);
            JSONObject jsonTemperature = (JSONObject) json.get("main");
            JSONArray jsonWeather = (JSONArray) json.get("weather");

            if (jsonTemperature != null) {
                Object temperatura = jsonTemperature.get("temp");

                climaTempo.append(temperatura.toString()).append("º C");

            }
            if(jsonWeather != null){
                Object clima = ((JSONObject) jsonWeather.get(0)).get("main");
                String climaString = clima.toString().toLowerCase();

                if(climaString.contains("cloud")) {
                    char nuvem = 9729;
                    climaTempo.append(" "+nuvem);
                }
                else
                    if(climaString.contains("sun")) {
                        char sol = 9728;
                        climaTempo.append(" "+sol);
                    }
                    else
                        if(climaString.contains("rain")) {
                            char chuva = 9928;
                            climaTempo.append(" "+chuva);
                        }
                        else
                            if(climaString.contains("snow")) {
                                char snow = 10052;
                                climaTempo.append(" " + snow);
                            }

            }

            return climaTempo.toString();

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
