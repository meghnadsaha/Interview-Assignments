//package com.coding.apexon;
//
//import javax.annotation.processing.Generated;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//
//
//class Review{
//
//
//    private Long id;
//    private String comment;
//    private int rating;
//
//    @Manytoone
//    Customer customer;
//    @ManytoOne
//    Product product;
//}
//
//class Customer{
//
//    @Override@Generatevalue(strategy=Generationtype.identity)
//    private Long id;
//    private String name;
//
//
//
//}
//
//select distinct c.*
//from customer c
//join review r on c.id= r.customer_id
//where r.product_id=:prouduct and
//r.rating=5 ;
//
//
//class Product {
//
//    String brand;
//    int price;
//    String id;
//    String name;
//
//
//    public String getId () {
//        return id;
//    }
//
//    public void setId ( String id ) {
//        this.id = id;
//    }
//
//    public String getName () {
//        return name;
//    }
//
//    public void setName ( String name ) {
//        this.name = name;
//    }
//
//    public String getBrand () {
//        return brand;
//    }
//
//    public void setBrand ( String brand ) {
//        this.brand = brand;
//    }
//
//    public int getPrice () {
//        return price;
//    }
//
//    public void setPrice ( int price ) {
//        this.price = price;
//    }
//
//
//    public Product ( String id , String name , String brand , int price ) {
//        this.id = id;
//        this.name = name;
//        this.brand = brand;
//        this.price = price;
//    }
//
//
//}
//@RestController
//@RequestMapping("/products")
//public class Apexon {
//
//    @Autowired
//    private ProductService productService;
//
//    @GetMapping
//    public List<Product> getAllProduct(){
//        return productService.getAll();
//    }
//
//
//    @PostMapping("/save")
//    public Product createProduct(@Requestbody Product product){
//        return productService.save(product);
//    }
//
//
//
//    @PutMapping("/{id}")
//    public Product updateProduct(@Pathvariable Long id,@Requestbody Product product){
//        return productService.update(id,product);
//    }
//
//
//
//    @GetMapping
//    public List<Product> getAllProduct(){
//        return productService.getAll();
//    }
//
//
//
//
//
//
//
//
//
////    public static void main ( String[] args ) {
////        List<Product> products = new ArrayList<>();
////
////        Map<String, Long> brandCounts = products.stream()
////                                                .filter(product -> product.getPrice() >= 5000 && product.getPrice() <= 10000)
////                                                .collect(Collectors.groupingBy(Product::getBrand ,
////                                                                               Collectors.counting()));
////
////    }
//}
