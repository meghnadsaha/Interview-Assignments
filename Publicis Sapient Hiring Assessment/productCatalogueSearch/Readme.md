##  Product catalogue Search App:


XYZ B2C ecommerce market place is working on building a solution to search an online product catalogue. Create an application to search product catalogue from its database. It' desired for the customer to have a faster search along with consistent data across multiple online channels. The customer desires to have refreshed data every 2hrs based on any available inventory or change in any other parameters considered.

Product catalogue details:

A product (Shirts) can be from multiple brands (Please assume your favorite brands). There could be multiple products categories e.g. Pants, Socks, Caps, etc. The design should be able to accommodate different products categories.

Key search outcomes against the product:

The application should support the following operations

1. Group by brand / client

2. Group by price

3. Group by Color

4. Group by Size

5. Get by SKU

6. Available number of product by seller

Data Structure:

• Create database schema to store above values.

1.  Data will come from multiple suppliers -
2.  This should trigger data refresh should happen on addition / deletion of brand or supplier
3. Should support multiple channels channel for search browser, mobile, kiosk to get a consistent output. List various restful end points that can be developed


Non-functional requirements:

1. There will be multiple customers trying to access this search at the same time some of them may be buying the product as well.

2. All channels should return similar search output in terms of data and format.

3. You can assume it for a single Market but should be scalable to accommodate different market regions.

