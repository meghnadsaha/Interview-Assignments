import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//class Author{
//
//    private Long id;
//
//    private String name;
//
//    @OneToMany(mappedBy="author")
//    private List<Book> books = new ArrayList<>();
//}
//
//
//class  Book{
//
//    @Id
//    @GeneratedValue(strategy= GenerationType.Identity)
//    private Long id;
//    private String name;
//    @ManyToOne
//    @JoinColumn(name="author_id")
//    private Author  author;
//
//}

public class Mapping {

    public static void main ( String[] args ) {
        List<String> names = Arrays.asList("apple","ant","book","swing");

        List<String> filteredNames = names.stream()
                                          .filter(name->name.startsWith("a"))
                                          .map(name->name+"ing")
                                          .collect(Collectors.toList());
        System.out.println(filteredNames);

    }


}
