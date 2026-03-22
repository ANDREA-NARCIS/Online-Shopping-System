Online Shopping System

A Java-based Online Shopping System using JPA/Hibernate and MySQL, allowing customers to place orders, view products, and manage shopping operations. This project demonstrates a simple e-commerce backend with database persistence and a menu-driven console application.

Features
Add Sample Data – Preload customers and products for testing.
Place Orders – Customers can order one or multiple products.
View Orders – Display all orders of a customer with product details.
Database Integration – Uses MySQL with Hibernate JPA for persistence.
Menu-Driven Application – Interactive console interface for easy testing.
Technology Stack
Java – Programming language for application logic.
Hibernate JPA – Object-Relational Mapping (ORM) framework.
MySQL – Relational database for storing customers, products, and orders.
Maven – Project management and dependency handling.
Project Structure
online-shopping-system/
│
├─ src/main/java/com/shopping/
│   ├─ entity/        # JPA entities: Customer, Product, OrderEntity
│   ├─ service/       # ShoppingService.java (business logic)
│   └─ main/          # MainApp.java (menu-driven application)
│
├─ pom.xml            # Maven configuration
└─ README.md          # Project documentation
Setup Instructions
1. Clone or Download Project
git clone <your-repo-url>
cd online-shopping-system
2. Configure Database
Create a MySQL database named shopping_db.
Update persistence.xml with your database username and password:
<property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/shopping_db"/>
<property name="jakarta.persistence.jdbc.user" value="root"/>
<property name="jakarta.persistence.jdbc.password" value="your_password"/>
<property name="hibernate.hbm2ddl.auto" value="update"/>
3. Add Sample Data
Run the addSampleData() method in ShoppingService via MainApp:
ShoppingService service = new ShoppingService();
service.addSampleData();
This will insert sample customers and products into the database.
Alternatively, insert manually using SQL:
INSERT INTO Customer (name) VALUES ('John');
INSERT INTO Product (name, price) VALUES ('Laptop', 50000);
INSERT INTO Product (name, price) VALUES ('Mobile', 20000);
4. Run the Application
mvn compile exec:java -Dexec.mainClass=com.shopping.main.MainApp
Follow the menu to place orders and view orders.
Usage Example

Menu Options:

1. Place Order
2. View Orders
3. Exit

Placing an Order:

Enter Customer ID: 1
Enter Product IDs (comma separated): 1,2
Order placed! Total = 70000.0

Viewing Orders:

Order ID: 1
Total: 70000.0
 - Laptop
 - Mobile
Entity Relationship
Customer → One-to-Many → OrderEntity
OrderEntity → Many-to-Many → Product
Notes
Make sure product and customer IDs exist before placing an order to avoid errors.
Hibernate auto-generates IDs using AUTO_INCREMENT in MySQL.
Transactions are handled via JPA EntityTransaction for safe persistence.
Future Enhancements
Add GUI or Web Interface for user-friendly interaction.
Implement authentication and user roles.
Integrate inventory management and payment gateway.
