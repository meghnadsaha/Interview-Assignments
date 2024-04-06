Real-life case questions involving PLpg/SQL might include scenarios like:

1. **Inventory Management**: Write a PLpg/SQL query to calculate the total value of inventory items in a warehouse, considering quantity and unit price.
```roomsql
-- Create the inventory_items table
CREATE TABLE inventory_items (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    quantity INTEGER NOT NULL,
    unit_price NUMERIC(10, 2) NOT NULL
);

-- Insert some sample data
INSERT INTO inventory_items (name, quantity, unit_price) VALUES
   ('Product A', 100, 10.00),
   ('Product B', 50, 20.00),
    ('Product C', 200, 5.00);

   
CREATE OR REPLACE FUNCTION calculate_total_inventory_value()
RETURNS NUMERIC AS $$
DECLARE
    total_value NUMERIC := 0;
BEGIN
    SELECT SUM(quantity * unit_price) INTO total_value
    FROM inventory_items;
    
    RETURN total_value;
END;
$$ LANGUAGE plpgsql;



SELECT calculate_total_inventory_value();

```
2. **Order Processing**: Develop a PLpg/SQL procedure to update the status of an order based on the availability of items in the inventory.
```roomsql
CREATE TABLE order_items (
    id SERIAL PRIMARY KEY,
    order_id INT,
    product_id INT,
    quantity INT
);

ALTER TABLE order_items
ADD COLUMN status VARCHAR(255);



CREATE TABLE inventory (
    id SERIAL PRIMARY KEY,
    product_id INT,
    quantity INT
);


INSERT INTO order_items (order_id, product_id, quantity)
VALUES
    (1, 1, 2),
    (1, 2, 1),
    (2, 1, 3),
    (3, 3, 2);

   
   INSERT INTO inventory (product_id, quantity)
VALUES
    (1, 5),
    (2, 3),
    (3, 1),
    (4, 0);

 
DROP FUNCTION update_order_status(integer);
 

CREATE OR REPLACE FUNCTION update_order_status(p_order_id INT) RETURNS VOID AS
$$
DECLARE
    total_items_needed INT;
    total_items_available INT;
    item_product_id INT;
    item_quantity INT;
    cur_order_items CURSOR FOR
        SELECT product_id, quantity
        FROM order_items
        WHERE order_id = p_order_id;
BEGIN
    -- Get the total number of items needed for the order
    SELECT SUM(quantity) INTO total_items_needed
    FROM order_items
    WHERE order_id = p_order_id;
    
    -- Get the total number of items available in the inventory
    SELECT SUM(quantity) INTO total_items_available
    FROM inventory;
    
    -- Check if there are enough items available
    IF total_items_available >= total_items_needed THEN
        -- Update the status of the order to 'Approved'
        UPDATE order_items
        SET status = 'Approved'
        WHERE id = p_order_id;
        
        -- Update the inventory
        OPEN cur_order_items;
        LOOP
            FETCH cur_order_items INTO item_product_id, item_quantity;
            EXIT WHEN NOT FOUND;
            
            UPDATE inventory
            SET quantity = quantity - item_quantity
            WHERE product_id = item_product_id;
        END LOOP;
        CLOSE cur_order_items;
    ELSE
        -- Update the status of the order to 'Cancelled'
        UPDATE orders
        SET status = 'Cancelled'
        WHERE id = p_order_id;
    END IF;
END;
$$
LANGUAGE plpgsql;


SELECT update_order_status(3);

select * from  inventory;
select * from  order_items oi ;




```
3. **Customer Management**: Create a PLpg/SQL script to generate a report of customers who have not made a purchase in the last six months.
```roomsql
drop TABLE customers;

CREATE TABLE customers (
    customer_id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    last_purchase_date DATE
);

truncate customers;
INSERT INTO customers (name, last_purchase_date)
VALUES
    ('Alice', '2024-01-15'),
    ('Bob', '2024-04-20'),
    ('Charlie', '2022-12-05'),
    ('David', NULL),
    ('Eve', '2022-11-10');

drop    FUNCTION generate_customer_report;
CREATE OR REPLACE FUNCTION generate_customer_report() RETURNS TABLE (
    cust_id INT,
    name VARCHAR(255),
    last_purchase_date DATE
) AS
$$
DECLARE
    six_months_ago DATE;
BEGIN
    -- Calculate the date six months ago
    six_months_ago := CURRENT_DATE - INTERVAL '6 months';

    -- Return customers who have not made a purchase in the last six months
    RETURN QUERY
    SELECT c.customer_id as cust_id, c.name, c.last_purchase_date
    FROM customers c
    WHERE c.last_purchase_date IS NULL OR c.last_purchase_date < six_months_ago;
END;
$$
LANGUAGE plpgsql;

SELECT * FROM generate_customer_report();

```
4. **Employee Performance**: Write a PLpg/SQL query to calculate the average performance rating of employees in a department.
```roomsql
DROP TABLE IF EXISTS employees;

CREATE TABLE employees (
    employee_id SERIAL PRIMARY KEY,
    department_id INT,
    performance_rating NUMERIC
);

INSERT INTO employees (department_id, performance_rating)
VALUES
    (1, 4.5),
    (1, 3.9),
    (1, 4.2),
    (2, 4.7),
    (2, 4.1),
    (2, 3.8),
    (3, 4.6),
    (3, 4.3),
    (3, 4.0);

   
DROP FUNCTION calculate_average_performance_rating(integer)  ;

CREATE OR REPLACE FUNCTION calculate_average_performance_rating(p_department_id INT) RETURNS NUMERIC AS
$$
DECLARE
    avg_rating NUMERIC;
BEGIN
    -- Calculate the average performance rating for the department
    SELECT AVG(performance_rating) INTO avg_rating
    FROM employees
    WHERE department_id = p_department_id;

    -- Return the average performance rating
    RETURN avg_rating;
END;
$$
LANGUAGE plpgsql;

SELECT calculate_average_performance_rating(1);


```
5. **Sales Analysis**: Develop a PLpg/SQL function to calculate the total sales amount for a specific product category in the last quarter.
```roomsql
DROP TABLE IF EXISTS sales;
CREATE TABLE sales (
    sale_id SERIAL PRIMARY KEY,
    product_category VARCHAR(255),
    sale_date DATE,
    amount NUMERIC
);


INSERT INTO sales (product_category, sale_date, amount)
VALUES
    ('Electronics', '2023-01-15', 500.00),
    ('Clothing', '2023-04-20', 300.00),
    ('Electronics', '2023-04-25', 700.00),
    ('Electronics', '2022-12-05', 450.00),
    ('Clothing', '2023-02-10', 200.00),
    ('Electronics', '2022-11-10', 600.00);

   
   
CREATE OR REPLACE FUNCTION calculate_total_sales_amount(category_name VARCHAR(255)) RETURNS NUMERIC AS
$$
DECLARE
    total_sales_amount NUMERIC;
    start_date DATE;
    end_date DATE;
BEGIN
    -- Calculate the start and end dates for the last quarter
    start_date := DATE_TRUNC('quarter', CURRENT_DATE) - INTERVAL '24 months';
    end_date := DATE_TRUNC('quarter', CURRENT_DATE) - INTERVAL '1 day';

    -- Calculate the total sales amount for the specific product category in the last quarter
    SELECT COALESCE(SUM(amount), 0) INTO total_sales_amount
    FROM sales
    WHERE product_category = category_name
    AND sale_date BETWEEN start_date AND end_date;

    -- Return the total sales amount
    RETURN total_sales_amount;
END;
$$
LANGUAGE plpgsql;


SELECT calculate_total_sales_amount('Electronics');

```
6. **Financial Transactions**: Create a PLpg/SQL trigger to log all financial transactions exceeding a certain amount into a separate table for auditing purposes.
```roomsql
DROP TABLE IF EXISTS audit_transactions;
CREATE TABLE audit_transactions (
    transaction_id SERIAL PRIMARY KEY,
    original_transaction_id INT,
    amount NUMERIC,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


DROP TABLE IF EXISTS transactions;
CREATE TABLE transactions (
    transaction_id SERIAL PRIMARY KEY,
    amount NUMERIC,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);





DROP FUNCTION log_high_value_transaction() CASCADE;

-- Next, you can create the trigger function and attach it to the transactions table:
CREATE OR REPLACE FUNCTION log_high_value_transaction()
RETURNS TRIGGER AS
$$
BEGIN
    IF NEW.amount > 1000.00 THEN
        INSERT INTO audit_transactions (original_transaction_id, amount)
        VALUES (NEW.transaction_id, NEW.amount);
    END IF;
    RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER audit_high_value_transactions
AFTER INSERT ON transactions
FOR EACH ROW
EXECUTE FUNCTION log_high_value_transaction();




--NOW triiger this 
truncate transactions;
INSERT INTO transactions (amount) VALUES
(500.00),
(1200.00),
(750.00),
(900.00),
(1100.00),
(600.00);

select * from  audit_transactions;

select * from  transactions;




```
7. **Product Pricing**: Write a PLpg/SQL function to calculate the discounted price of a product based on the customer's membership status.
```roomsql
DROP TABLE IF EXISTS products;
CREATE TABLE products (
    product_id SERIAL PRIMARY KEY,
    product_name VARCHAR(255),
    price NUMERIC
);


INSERT INTO products (product_name, price) VALUES
('Product A', 100.00),
('Product B', 50.00),
('Product C', 75.00);


DROP TABLE IF EXISTS customers;
CREATE TABLE customers (
    customer_id SERIAL PRIMARY KEY,
    customer_name VARCHAR(255),
    membership_status VARCHAR(255)
);


INSERT INTO customers (customer_name, membership_status) VALUES
('Alice', 'Gold'),
('Bob', 'Silver'),
('Charlie', 'Bronze');




DROP FUNCTION calculate_discounted_price(integer,integer) ;
CREATE OR REPLACE FUNCTION calculate_discounted_price(product_id_param INT, customer_id_param INT) RETURNS NUMERIC AS
$$
DECLARE
    base_price NUMERIC;
    discount_factor NUMERIC;
    discounted_price NUMERIC;
    cust_membership_status VARCHAR(255);
BEGIN
    -- Get the base price of the product
    SELECT price INTO base_price
    FROM products
    WHERE product_id = product_id_param;

    -- Get the customer's membership status
    SELECT membership_status INTO cust_membership_status
    FROM customers
    WHERE customer_id = customer_id_param;

    -- Calculate the discount factor based on the membership status
    IF cust_membership_status = 'Gold' THEN
        discount_factor := 0.9; -- 10% discount for Gold members
    ELSIF cust_membership_status = 'Silver' THEN
        discount_factor := 0.95; -- 5% discount for Silver members
    ELSE
        discount_factor := 1.0; -- No discount for other members
    END IF;

    -- Calculate the discounted price
    discounted_price := base_price * discount_factor;
   
       -- Log the transaction
    IF discounted_price > 1000.00 THEN
        RAISE NOTICE 'High-value transaction: Product ID: %, Customer ID: %, Discounted Price: %', product_id_param, customer_id_param, discounted_price;
    END IF;


    -- Return the discounted price
    RETURN discounted_price;
END;
$$
LANGUAGE plpgsql;




SELECT calculate_discounted_price(1, 1);


```
8. **Logistics Management**: Develop a PLpg/SQL procedure to optimize the route for delivering orders to customers based on their locations and order priorities.
```roomsql
DROP TABLE IF EXISTS customer_locations;

-- Create the customer_locations table
CREATE TABLE customer_locations (
    customer_id INT PRIMARY KEY,
    location VARCHAR(255)
);

DROP TABLE IF EXISTS orders;

-- Create the orders table with a foreign key constraint referencing customer_locations
CREATE TABLE orders (
    order_id SERIAL PRIMARY KEY,
    customer_id INT,
    priority INT,
    CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES customer_locations(customer_id)
);


-- Insert data into the customer_locations table
INSERT INTO customer_locations (customer_id, location)
VALUES
    (1, 'Location A'),
    (2, 'Location B'),
    (3, 'Location C');

-- Insert data into the orders table
INSERT INTO orders (customer_id, priority)
VALUES
    (1, 1),
    (2, 2),
    (3, 1);

   
   
DROP FUNCTION optimize_delivery_route() ;
CREATE OR REPLACE FUNCTION optimize_delivery_route() RETURNS TABLE (
    order_id INT,
    customer_id INT,
    priority INT,
    location VARCHAR(255),
    route_order INT
) AS
$$
DECLARE
    loc_customer_id INT;
    loc_location VARCHAR(255);
    customer_locations_cursor CURSOR FOR
       SELECT cl.customer_id, cl.location
        FROM customer_locations cl;
    customer_id_array INT[];
    location_array VARCHAR(255)[];
    i INT := 1;
BEGIN
    -- Fetch customer locations
    OPEN customer_locations_cursor;
    FETCH customer_locations_cursor INTO loc_customer_id, loc_location;
    WHILE FOUND LOOP
        customer_id_array := customer_id_array || loc_customer_id;
        location_array := location_array || loc_location;
        FETCH customer_locations_cursor INTO loc_customer_id, loc_location;
    END LOOP;
    CLOSE customer_locations_cursor;

    -- Calculate optimal route using TSP solver (example implementation)
    -- Replace this with your actual TSP solver logic
    FOR i IN ARRAY_LOWER(customer_id_array, 1)..ARRAY_UPPER(customer_id_array, 1) LOOP
        RETURN QUERY
        SELECT o.order_id, o.customer_id, o.priority, cl.location, i
        FROM orders o
        JOIN customer_locations cl ON o.customer_id = cl.customer_id
        WHERE o.customer_id = customer_id_array[i];
    END LOOP;

    RETURN;
END;
$$
LANGUAGE plpgsql;



select optimize_delivery_route();
```
9. **Healthcare System**: Create a PLpg/SQL query to identify patients who have visited the hospital more than five times in the last month.
```roomsql
DROP TABLE IF EXISTS visits;
CREATE TABLE visits (
    visit_id SERIAL PRIMARY KEY,
    patient_id INT,
    visit_date DATE
);

INSERT INTO visits (patient_id, visit_date) VALUES
(1, '2024-03-01'),
(1, '2024-03-05'),
(1, '2024-03-10'),
(1, '2024-02-15'),
(1, '2024-03-20'),
(2, '2024-03-02'),
(2, '2024-03-05'),
(2, '2024-03-07'),
(2, '2024-03-10'),
(2, '2024-03-11'),
(2, '2024-03-12'),
(2, '2024-03-13'),
(2, '2024-03-14'),
(3, '2024-03-01'),
(3, '2024-02-02'),
(3, '2024-02-03');


DROP function if exists identify_frequent_patients() ;
CREATE OR REPLACE FUNCTION identify_frequent_patients() RETURNS TABLE (
    patient_id INT,
    visit_count INT
) AS
$$
DECLARE
    start_date DATE := CURRENT_DATE - INTERVAL '1 month';
begin
   
	RAISE NOTICE 'Start Date: %', start_date;
    
    RETURN QUERY
    SELECT v.patient_id, COUNT(*)::INT AS visit_count
    FROM visits v
    WHERE v.visit_date >= start_date
    GROUP BY v.patient_id
    HAVING COUNT(*) > 5;
END;
$$
LANGUAGE plpgsql;




SELECT * FROM identify_frequent_patients();

```
10. **Security System**: Write a PLpg/SQL trigger to alert administrators when there are multiple failed login attempts for a user within a short period.
```roomsql
drop TABLE if exists  login_attempts;
-- Create the login_attempts table
CREATE TABLE login_attempts (
    attempt_id SERIAL PRIMARY KEY,
    user_id INT,
    attempt_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    success BOOLEAN
);

   

drop function if exists check_failed_login_attempts() cascade;		  
CREATE OR REPLACE FUNCTION check_failed_login_attempts() RETURNS TRIGGER AS
$$
DECLARE
    v_user_id INT;
    attempt_count INT;
    time_threshold INTERVAL := INTERVAL '5 minutes'; -- Threshold for failed login attempts within 5 minutes
BEGIN
    -- Get the user_id of the current login attempt
    v_user_id := NEW.user_id;

    -- Count the number of failed login attempts for the user within the threshold
    SELECT COUNT(*)
    INTO attempt_count
    FROM login_attempts
    WHERE user_id = v_user_id
    AND attempt_time >= CURRENT_TIMESTAMP - time_threshold
    AND success = false;

    -- Raise a notice with the attempt count and time threshold for debugging
    RAISE NOTICE 'User %: Attempt Count: %, Time Threshold: %', v_user_id, attempt_count, time_threshold;

    -- Raise a notice if the number of failed attempts exceeds 3
    IF attempt_count > 3 THEN
        RAISE NOTICE 'Multiple failed login attempts detected for user % within a short period.', v_user_id;
    END IF;

    RETURN NEW;
END;
$$
LANGUAGE plpgsql;

--CREATE TRIGGER failed_login_trigger
--AFTER INSERT ON login_attempts
--FOR EACH ROW
--EXECUTE FUNCTION check_failed_login_attempts();
--
--
---- Add 1 second to a timestamp
--SELECT CURRENT_TIMESTAMP + INTERVAL '1 sec';
--
---- Subtract 1 second from a timestamp
--SELECT CURRENT_TIMESTAMP - INTERVAL '1 sec';
--
---- Use interval in a WHERE clause to filter data within the last second
--SELECT count(*) 
--FROM login_attempts
--WHERE attempt_time <= CURRENT_TIMESTAMP - INTERVAL '1 sec';


-- Insert sample data
INSERT INTO login_attempts (user_id, success)
VALUES
    (1, false),
    (1, false),
    (1, false),
    (1, true),
    (2, false),
    (2, false),
    (2, false),
    (3, false),
    (3, false),
    (3, false),
    (3, false),
    (3, false);

select * from login_attempts;


```
Here are 40 more real-life case questions involving PLpg/SQL:

1. **Customer Segmentation**: Write a PLpg/SQL query to categorize customers based on their purchasing behavior (e.g., frequent buyers, occasional buyers, one-time buyers).

2. **Product Recommendations**: Develop a PLpg/SQL function to suggest products to customers based on their past purchase history.

3. **Supply Chain Management**: Create a PLpg/SQL procedure to track the movement of goods from suppliers to warehouses to customers.

4. **Employee Attendance**: Write a PLpg/SQL script to calculate the attendance percentage of employees in a given month.

5. **Healthcare System**: Develop a PLpg/SQL function to calculate the BMI (Body Mass Index) of patients based on their height and weight records.

6. **Retail Sales Analysis**: Write a PLpg/SQL query to analyze sales data and identify trends in product sales over different time periods.

7. **Inventory Replenishment**: Create a PLpg/SQL procedure to automatically reorder items when the inventory level falls below a certain threshold.

8. **Customer Feedback Analysis**: Develop a PLpg/SQL script to analyze customer feedback and generate a report on the most common issues reported by customers.

9. **Fraud Detection**: Write a PLpg/SQL trigger to detect suspicious transactions and flag them for further investigation.

10. **Hotel Reservation System**: Create a PLpg/SQL query to calculate the total revenue generated from room bookings in a given month.

11. **E-commerce Platform**: Develop a PLpg/SQL procedure to calculate shipping costs based on the distance between the warehouse and the customer's location.

12. **Social Media Analytics**: Write a PLpg/SQL script to analyze social media data and identify trends in user engagement.
```roomsql
drop table social_media_data;
-- Create a temporary table to store sample social media data
CREATE TEMP TABLE social_media_data (
    id SERIAL PRIMARY KEY,
    content_type VARCHAR(255),
    likes INT,
    shares INT,
    comments INT
);

-- Insert sample data into the table
INSERT INTO social_media_data (content_type, likes, shares, comments)
VALUES
    ('video', 100, 50, 20),
    ('image', 150, 75, 30),
    ('text', 50, 25, 10),
    ('video', 200, 100, 40),
    ('image', 300, 150, 60),
    ('text', 75, 35, 15);

-- Create a function to calculate engagement score
CREATE OR REPLACE FUNCTION calculate_engagement(likes INT, shares INT, comments INT)
RETURNS INT AS $$
BEGIN
    RETURN likes + shares + (comments * 2); -- Adjust weights as needed
END;
$$ LANGUAGE plpgsql;


DROP FUNCTION analyze_engagement_trends()

-- Create a function to analyze engagement trends based on content type
CREATE OR REPLACE FUNCTION analyze_engagement_trends()
--RETURNS TABLE (content_type VARCHAR(255), total_likes BIGINT, total_shares INT, total_comments INT, total_engagement INT) AS $$
RETURNS TABLE (content_type VARCHAR(255), total_likes BIGINT, total_shares BIGINT, total_comments BIGINT, total_engagement BIGINT) AS $$
BEGIN
    RETURN QUERY
    SELECT
        social_media_data.content_type,
        SUM(social_media_data.likes) AS total_likes,
        SUM(social_media_data.shares) AS total_shares,
        SUM(social_media_data.comments) AS total_comments,
        SUM(calculate_engagement(social_media_data.likes, social_media_data.shares, social_media_data.comments)) AS total_engagement
    FROM
        social_media_data
    GROUP BY
        social_media_data.content_type;
END;
$$ LANGUAGE plpgsql;

-- Call the function to analyze engagement trends
SELECT * FROM analyze_engagement_trends();

```
13. **Loan Management System**: Create a PLpg/SQL function to calculate the monthly installment amount for a loan based on the loan amount, interest rate, and loan duration.
```roomsql

drop TABLE if exists  loans CASCADE;
CREATE TABLE loans (
    loan_id SERIAL PRIMARY KEY,
    loan_amount NUMERIC NOT NULL,
    interest_rate NUMERIC NOT NULL,
    loan_duration INTEGER NOT NULL,
    monthly_installment NUMERIC
);


CREATE OR REPLACE FUNCTION calculate_monthly_installment(
    loan_amount NUMERIC,
    interest_rate NUMERIC,
    loan_duration INTEGER
)
RETURNS NUMERIC AS $$
DECLARE
    monthly_interest_rate NUMERIC;
    monthly_installment NUMERIC;
BEGIN
    monthly_interest_rate := interest_rate / 100 / 12;
    monthly_installment := (loan_amount * monthly_interest_rate) /
                            (1 - POWER(1 + monthly_interest_rate, -loan_duration));

    RETURN monthly_installment;
END;
$$ LANGUAGE plpgsql;




select calculate_monthly_installment(10000, 5, 36)



INSERT INTO loans (loan_amount, interest_rate, loan_duration, monthly_installment)
VALUES (10000, 5, 36, calculate_monthly_installment(10000, 5, 36)),
       (15000, 6, 48, calculate_monthly_installment(15000, 6, 48)),
       (20000, 7, 60, calculate_monthly_installment(20000, 7, 60));


```
14. **Employee Training Management**: Develop a PLpg/SQL procedure to track employee training sessions and ensure that employees complete mandatory training courses.
```roomsql
truncate  employees cascade;
truncate  training_sessions cascade;

-- Insert dummy employees
INSERT INTO employees  (name) VALUES
('Alice'),
('Bob'),
('Charlie'),
('David');

-- Insert dummy training sessions
INSERT INTO training_sessions  (name,mandatory) VALUES
('Session A',true),
('Session B',true),
('Session C',true),
('Session D',true);

select  * from  training_sessions;
select  * from  employees;
select  * from  employee_training et ;




```
15. **Energy Consumption Analysis**: Write a PLpg/SQL query to analyze energy consumption data and identify areas where energy-saving measures can be implemented.
```roomsql
CREATE TABLE energy_data (
    id SERIAL PRIMARY KEY,
    area VARCHAR(255),
    energy_consumption DECIMAL,
    timestamp TIMESTAMP
);
INSERT INTO energy_data (area, energy_consumption, timestamp) VALUES
('Room A', 100.5, '2023-04-01 08:00:00'),
('Room A', 110.3, '2023-04-01 09:00:00'),
('Room A', 95.2, '2023-04-01 10:00:00'),
('Room B', 120.7, '2023-04-01 08:00:00'),
('Room B', 130.2, '2023-04-01 09:00:00'),
('Room B', 115.8, '2023-04-01 10:00:00'),
('Floor 1', 500.2, '2023-04-01 08:00:00'),
('Floor 1', 510.5, '2024-04-01 09:00:00'),
('Floor 1', 495.1, '2024-04-01 10:00:00');


select * from energy_data ed ;
CREATE OR REPLACE PROCEDURE analyze_energy_consumption()
 AS $$
DECLARE
    baseline_energy_consumption DECIMAL;
    area_energy RECORD;
BEGIN
    -- Calculate the baseline energy consumption (e.g., average energy consumption for the last month)
    SELECT AVG(energy_consumption)
    INTO baseline_energy_consumption
    FROM energy_data
    WHERE date_trunc('month', "timestamp") = date_trunc('month', CURRENT_DATE - interval '12 month');

    -- Analyze energy consumption data
    FOR area_energy IN
        SELECT area, SUM(energy_consumption) AS total_energy_consumption
        FROM energy_data
        GROUP BY area
    LOOP
        -- Compare total energy consumption for each area with the baseline value
        IF area_energy.total_energy_consumption > baseline_energy_consumption THEN
            RAISE NOTICE 'Area % has higher than baseline energy consumption: %', area_energy.area, area_energy.total_energy_consumption;
            -- Implement energy-saving measures for the area
            -- For example, update a table to mark the area for energy-saving measures
        END IF;
    END LOOP;
END $$ LANGUAGE plpgsql;

call analyze_energy_consumption()
--
-- SELECT AVG(energy_consumption)
--    FROM energy_data
--    WHERE date_trunc('month', "timestamp") = date_trunc('month', CURRENT_DATE - interval '12 month');

```
16. **Transportation Management**: Create a PLpg/SQL function to calculate the optimal route for transporting goods between multiple locations, considering factors such as distance and traffic conditions.

17. **Insurance Claims Processing**: Develop a PLpg/SQL procedure to process insurance claims and calculate the payout amount based on the policy terms and claim details.
```roomsql
CREATE TABLE policies (
    id SERIAL PRIMARY KEY,
    policy_number VARCHAR(255) NOT NULL,
    amount DECIMAL NOT NULL
);


CREATE TABLE claims (
    id SERIAL PRIMARY KEY,
    policy_id INT NOT NULL,
    claim_amount DECIMAL NOT NULL,
    status VARCHAR(255) NOT NULL DEFAULT 'Pending',
    payout DECIMAL
);
--
--ALTER TABLE claims
--RENAME COLUMN amount TO claim_amount;

truncate policies;

INSERT INTO policies (policy_number, amount) VALUES
('POL001', 5000.00),
('POL002', 10000.00),
('POL003', 7500.00);

truncate claims;
INSERT INTO claims (policy_id, claim_amount) VALUES
(1, 3000.00),
(2, 12000.00),
(3, 8000.00);

select * from policies;
select * from claims;



CREATE OR REPLACE FUNCTION process_claim(claim_id INT) RETURNS VOID AS $$
DECLARE
    claim_record RECORD;
    policy_amount DECIMAL;
    payout_amount DECIMAL;
BEGIN
    -- Get the claim record
    SELECT * INTO claim_record FROM claims WHERE id = claim_id;

    -- Check if the claim status is 'Pending'
    IF claim_record.status = 'Pending' THEN
        -- Get the policy amount for the claim
        SELECT amount INTO policy_amount FROM policies WHERE id = claim_record.policy_id;

        -- Calculate the payout amount (e.g., 80% of the claim amount)
        payout_amount := claim_record.claim_amount * 0.8;

        -- Update the claim record with the payout amount and status
        UPDATE claims SET payout = payout_amount, status = 'Processed' WHERE id = claim_id;
    END IF;
END;
$$ LANGUAGE plpgsql;

select  process_claim(4)



```
18. **Student Performance Analysis**: Write a PLpg/SQL script to analyze student performance data and identify students who may need additional support.

19. **Event Management**: Create a PLpg/SQL procedure to manage event registrations and send confirmation emails to registered participants.

20. **Survey Analysis**: Develop a PLpg/SQL function to analyze survey responses and generate a report on the overall satisfaction level of respondents.

21. **Manufacturing Process Optimization**: Write a PLpg/SQL query to analyze production data and identify opportunities for improving efficiency in the manufacturing process.

22. **Airport Management System**: Create a PLpg/SQL procedure to track flight schedules and notify passengers of any changes or delays.

23. **Hotel Revenue Management**: Develop a PLpg/SQL function to calculate the average room rate for a hotel based on historical booking data.

24. **Supply Chain Optimization**: Write a PLpg/SQL query to optimize the supply chain by identifying the most cost-effective suppliers for a given set of products.

25. **Healthcare Appointment Scheduling**: Create a PLpg/SQL procedure to schedule patient appointments based on the availability of doctors and patients' preferences.

26. **Retail Inventory Management**: Develop a PLpg/SQL function to calculate the inventory turnover ratio for a retail store based on sales and inventory data.

27. **Customer Loyalty Program**: Write a PLpg/SQL script to track customer loyalty points and generate rewards for loyal customers.

28. **Banking System**: Create a PLpg/SQL procedure to calculate the interest amount for a savings account based on the account balance and interest rate.

29. **Online Learning Platform**: Develop a PLpg/SQL function to recommend courses to users based on their learning preferences and past course history.

30. **Employee Performance Appraisal**: Write a PLpg/SQL script to evaluate employee performance based on predefined criteria and generate performance appraisal reports.

31. **Food Delivery Service**: Create a PLpg/SQL procedure to track food orders and delivery status, and notify customers of their order status.

32. **Automobile Service Management**: Develop a PLpg/SQL function to calculate the total service cost for a vehicle based on the type of service and parts used.

33. **Retail Price Optimization**: Write a PLpg/SQL query to analyze pricing data and recommend optimal prices for products based on market demand.

34. **Asset Management**: Create a PLpg/SQL procedure to track the maintenance schedule and depreciation of company assets.

35. **Customer Churn Prediction**: Develop a PLpg/SQL function to predict customer churn based on historical customer data.

36. **HR Recruitment System**: Write a PLpg/SQL script to automate the screening of job applications and shortlist candidates based on predefined criteria.

37. **Online Auction Platform**: Create a PLpg/SQL procedure to manage online auctions and notify bidders of auction results.

38. **Hotel Booking System**: Develop a PLpg/SQL function to calculate the total cost of a hotel booking based on the room rate and duration of stay.

39. **Inventory Forecasting**: Write a PLpg/SQL query to forecast future inventory levels based on historical sales data and current inventory levels.

40. **Customer Support Ticketing System**: Create a PLpg/SQL procedure to prioritize customer support tickets based on the severity of the issue and customer's SLA (Service Level Agreement).