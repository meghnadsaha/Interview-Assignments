### Total number of items bought in your online store

You are writing an endpoint that returns the total number of items bought in your online store by a given user. Orders in your system are stored in an external service called Orderslervice, Your task is to

write an endpoint in the given UsersController class

write a method in the given hersService class that counts the number of items bought by the given user, configure the UsersController and Userstervice classes.

Solving this task requires from you editing the following three files. Please make sure they are all present in your final solution.

som.codility.app.AppConfiguration

com.codility app UsersController

com.codility age harshervice

Interfaces

The UsersService class declares

a field ardersService: private OrdersService ordersServics

a method pethunterftesight public int getmust(String username)

The UsersController class declares

a field asersService, private Userservice userservice a

method tatalltansought public Rap-String, Integer totalitemsBought()

They are all present in your initial solution.

Environment

Your application is written with the Spring Framework

Your Spring contest is already populated with the riderservis bean that implements the following interface

package codility.esternal:

import jave util.List

public interface OrdersService (

List Item tums@ought (String username);

Note that Orderater is located in the cocodility external package, whereas your application uses the somsafility apo package.

Requirements

1. Make sure that the AppConfiguration clase is treated as a Spring configuration bean

2. Configure Spring la scan for beans in the one codility external package.

2. Prepare the Orderservice bean (please refer to the signatures described above) Inject the riderslervice bean into the andersservice held

Use it in the petight method to count the number of items bought by the given user

4. Inject seraßervice into Useratantroller

5. Use it in the totalltsought method to fetch the number of items bought by the given user.
   . The totalltensBought method should implement the following contract:

endpoint URL: /users/(username)/items/total, where username is a path variable,

response JSON format: ("totalItemsBought" number), where number is the number of items bought by the given uses

status code 200 in case of a successful response.

7. Make sure you pass the username variable to the totalitemsbought call.

8. For simplicity, you don't have to write any input validation or error handling.

9. You are working with the Spring Framework version 5.1.7 and Java 8.

Copyright 2009-2024 by Codility Limited. All Rights Reserved. Unauthorizat copying publication or disclosure prohibited