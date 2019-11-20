package Utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**Classe responsavel por recuperar a lista de cidades através de um arquivo json e armazenar em um Map, ficando disponivel na aplicação.
 * @author Eric Castro Santos
 * @version 1.00
 */
public class CityList {

    public static Map<Long, String> listaCidades = new HashMap<Long, String>();

    public static void listarCidadesDisponiveis() {

        JSONArray jsonArray;

        //Cria o parse de tratamento
        JSONParser parser = new JSONParser();

            listaCidades = new HashMap<>();
        try {
            //Salva no objeto JSONObject o que o parse tratou do arquivo
            jsonArray = (JSONArray) parser.parse(new FileReader(
                    "city.list.json"));

            for (Object object : jsonArray) {

                Long id = (Long) ((JSONObject) object).get("id");
                String cidade = (String) ((JSONObject) object).get("name");
                listaCidades.put(id, cidade);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
