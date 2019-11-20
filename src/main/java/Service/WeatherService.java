package Service;

import java.io.IOException;

public interface WeatherService {

    String hourlyForecastByCityID(Long id) throws IOException;
}
