package com.altmetric.orderservice;

import com.altmetric.orderservice.controller.OrderController;
import com.altmetric.orderservice.domain.Customer;
import com.altmetric.orderservice.domain.Order;
import com.altmetric.orderservice.domain.Product;
import com.altmetric.orderservice.repository.CustomerRepository;
import com.altmetric.orderservice.repository.ProductRepository;
import com.altmetric.orderservice.service.OrderService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;
    @MockBean
    private ProductRepository productRepository;
    @MockBean
    private CustomerRepository customerRepository;

    @InjectMocks
    private OrderController orderController;


    @Test
    public void testCreateOrder () throws Exception {
        String productId = "65f751adf7fadd0488faa111";
        String customerId = "65f89ae05e68d24f0d69b1b5";
        Gson gson = new Gson();
        String productJson = "{\n" +
                "  \"_id\": {\n" +
                "    \"$oid\": \"65f751adf7fadd0488faa111\"\n" +
                "  },\n" +
                "  \"productId\": \"65f751adf7fadd0488faa111\",\n" +
                "  \"name\": \"SAMSUNG T7 / 1050 Mbs / PC,Mac,Android / Portable,Type C Enabled / 3Y Warranty / USB 3.2 1 TB External Solid State Drive (SSD)  (Grey)\",\n" +
                "  \"price\": 11.109,\n" +
                "  \"quantity\": 12,\n" +
                "  \"_class\": \"com.altimetrik.orderservice.model.Product\"\n" +
                "}";
        String customerJson = "{\n" +
                "  \"_id\": {\n" +
                "    \"$oid\": \"65f89ae05e68d24f0d69b1b5\"\n" +
                "  },\n" +
                "  \"name\": \"Rohit Singh\",\n" +
                "  \"email\": \"RohitSingh56@gmail.com\",\n" +
                "  \"_class\": \"com.altmetric.orderservice.domain.Customer\"\n" +
                "}";
        Product product = gson.fromJson(productJson , Product.class);
        Customer customer = gson.fromJson(customerJson , Customer.class);


        Order order = new Order();
        order.setProduct(product);
        order.setCustomer(customer);

        Mockito.when(orderService.createOrder(Mockito.anyString() , Mockito.anyString())).thenReturn(
               order);


        mockMvc.perform(MockMvcRequestBuilders.post("/orders")
                                              .param("productId" , productId)
                                              .param("customerId" , customerId))
               .andExpect(MockMvcResultMatchers.status().isCreated())
               .andExpect(MockMvcResultMatchers.jsonPath("$.product.productId").value(productId))
               .andExpect(MockMvcResultMatchers.jsonPath("$.customer.name").value("Rohit Singh"))
               .andExpect(MockMvcResultMatchers.jsonPath("$.customer.email").value("RohitSingh56@gmail.com"));

    }
}
