package Utils;

import java.util.Map;

/**Classe utilit�ria para pegar a chave  atrav�s de um valor.
 * @author Eric Castro Santos
 * @version 1.00
 */
public class MapUtils {

    public static <T, E> T getKeysByValue(Map<T, E> map, E value) {

        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
