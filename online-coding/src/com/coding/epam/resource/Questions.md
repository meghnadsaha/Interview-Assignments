To use lazy loading for the `addresses` collection in the `Student` entity, you can change the fetch type of the association to `LAZY`. This way, the `addresses` collection will only be loaded from the database when it is accessed for the first time. Here's how you can modify the `Student` entity to use lazy loading:

```java
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;
    private String country;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    // constructors, getters, setters
}

```
```java
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Address> addresses = new ArrayList<>();

    // constructors, getters, setters
}
```

In this modified `Student` entity, the `fetch = FetchType.LAZY` attribute in the `@OneToMany` annotation specifies that the `addresses` collection should be lazily loaded. This means that when you load a `Student` entity, the `addresses` collection will not be loaded until you explicitly access it.

For example, if you retrieve a `Student` entity using Hibernate and then access its `addresses` collection, Hibernate will issue a separate query to load the addresses from the database:

```java
Student student = studentRepository.findById(studentId).orElse(null);
List<Address> addresses = student.getAddresses(); // This will trigger a separate query to load addresses
```