package Utils;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class MapUtils {

    public static <T, E> T getKeysByValue(Map<T, E> map, E value) {

//        for (Map.Entry<T, E> entry : map.entrySet()) {
//            if (Objects.equals(value, entry.getValue())) {
//                return entry.getKey();
//            }
//        }
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
