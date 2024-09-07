# eoeats

This API provides a robust platform for restaurants to manage their menus and orders efficiently, while offering a seamless user experience for customers.

Key Features:

Menu Management

Restaurants can easily add, modify, or remove menu items, including dishes, descriptions, prices, and allergens.
Order Management: Customers can browse menus, select dishes, customize orders with extras, view allergen information, and proceed to secure payment.
Kitchen Integration: Orders are automatically sent to the kitchen for preparation, ensuring timely and accurate order fulfillment.

API Endpoints

The provided endpoints below are divided into CMS (Content Management System) for restaurant owners and a customer-facing section for ordering.

User Management

POST /users: Create a new user (employee).
POST /login: Authenticate a user and return user information including role and restaurant configuration.

Restaurant Management

PUT /restaurants/:id: Update restaurant information (email, image, name, phone, location).
POST/PUT/DELETE /categories: Create, update, or delete categories.
POST/PUT/DELETE /dishes: Create, update, or delete dishes, including allergens.
POST/PUT/DELETE /extras: Create, update, or delete extras.
PUT /restaurants/:id/configuration: Update restaurant configuration.
PUT /dishes/:id/availability: Enable or disable a dish.
GET /restaurants/:id: Get detailed restaurant information, including categories.
GET /categories/:id/dishes: Get dishes for a specific category.
GET /dishes/:id: Get detailed information about a dish, including allergens and extras.

Order Management

GET /orders: Get a list of orders for a specific restaurant.
GET /orders/:id: Get details of a specific order.
DELETE /orders/:id: Delete an order.
DELETE /orders/:id/items/:itemId: Delete an item or extra from an order.
GET /tables/:id/summary: Get a summary of all orders for a specific table.
DELETE /tables/:id: Clear all orders for a table.

Customer Ordering

GET /restaurants/:id: Get restaurant information by scanning QR code.
GET /categories/:id/dishes: Get dishes for a specific category.
GET /dishes/:id: Get details about a dish, including extras.
POST /orders: Create a new order.

Data Models

User: id, username, password, role, restaurant_id
Restaurant: id, name, email, image, phone, latitude, longitude, configuration
Category: id, restaurant_id, name
Dish: id, category_id, name, description, price, allergens, is_available
Extra: id, dish_id, name, price
Order: id, restaurant_id, table_number, created_at, status
OrderItem: id, order_id, dish_id, quantity, extras

Technologies

Backend: Java 11+, JPA, Hibernate
Database: PostgreSQL
Framework: SpringBoot

Additional Notes

Error Handling: Handle errors gracefully and return informative error messages.
Follow clean code principles
Use of design patterns

![WhatsApp Image 2024-05-20 at 17 58 48](https://github.com/PabloProgramming/eoeats/assets/169392720/6b498d18-aad6-4aba-8a90-65ec5511f166)
