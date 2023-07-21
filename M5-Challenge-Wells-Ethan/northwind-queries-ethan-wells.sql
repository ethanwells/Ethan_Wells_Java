-- Name: Ethan Wells | Netflix Pathways Bootcamp Summer 2023

use northwind; -- use the northwind database

-- (1) What are the categories of products in the database?
SELECT category
FROM products;

-- (2) What products are made by Dell?
SELECT *
FROM products
WHERE product_name like "%Dell%";

-- (3) List all the orders shipped to Pennsylvania.
SELECT *
FROM orders
WHERE ship_state like "Pennsylvania";

-- (4) List the first name and last name of all employees with last names that start with the letter W.
SELECT last_name, first_name
FROM employees
WHERE last_name like "W%";

-- (5) List all customers from zip codes that start with 55.
SELECT *
FROM customers
WHERE postal_code like "55%";

-- (6) List all customers from zip codes that end with 0.
SELECT *
FROM customers
WHERE postal_code like "%0";

-- (7) List the first name, last name, and email for all customers with a ".org" email address.
SELECT first_name, last_name, email
FROM customers
WHERE email like "%.org";

-- (8) List the first name, last name, and phone number for all customers from the 202 area code.
SELECT first_name, last_name, phone
FROM customers
WHERE phone like "_-(202%";

-- (9) List the first name, last name, and phone number for all customers from the 202 area code, ordered by last name, first name.
SELECT first_name, last_name, phone
FROM customers
WHERE phone like "_-(202%"
ORDER BY last_name, first_name;

