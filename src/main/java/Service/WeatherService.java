package Service;

import java.io.IOException;

/**Interface do servi�o de busca de temperatura.
 * @author Eric Castro Santos
 * @version 1.00
 */

public interface WeatherService {

    String hourlyForecastByCityID(Long id) throws IOException;
}
