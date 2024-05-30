import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Xoriant {

    public static void main ( String[] args ) {
        String str = "aabccdihhk";
        char firstUnique = str.chars()
                              .mapToObj(ch -> (char) ch)
                              .collect(Collectors.groupingBy(ch -> ch , LinkedHashMap::new , Collectors.counting()))
                              .entrySet().stream()
                              .filter(entry -> entry.getValue() == 1)
                              .map(Map.Entry::getKey)
                              .findFirst().
                              orElseThrow(() -> new RuntimeException(""));

        System.out.println("firstUnique is : " + firstUnique);
    }
}
