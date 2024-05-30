//package com.coding.innova;
//
//
//import java.math.BigDecimal;
//
//class Order{
//    private Long id;
//    private String  name;
//    private BigDecimal amount;
//
//}
//
//@Service
//class OrderService{
//    public Order processOrder(Order order){
//
//    }
//}
//
//
//
//class BatchConfig{
//
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//    @Autowired
//    private OrderItemProcessor orderItemProcessor;
//    @Autowired
//    private OrderItemReader orderItemReader;
//
//    @Bean
//    private Job processOrdersJob(){
//        return jobfactory.get("processOrdersJob")
//                .incrementer(new RunIncrementmenter())
//                .flow(processOrdersStep())
//                .end()
//                .build();
//    }
//
//    @Bean
//    private Step processOrdersStep () {
//        return stepBuilderFactory.get("processOrdersStep")
//                .<Order,Order>chunk(100)
//                .reader(orderItemReader)
//                .processor(orderItemProcessor)
//                .build();
//
//    }
//
//
//
//}
//
//
//@controller
//public class InnovaMain {
//
//
//    public  void main (@requestparam("par") ) {
//
//
//
//    }
//
//}
