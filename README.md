Product Management CRUD

Overview:
The Product Management CRUD application is a simple, yet comprehensive tool designed to manage product information efficiently. This application allows users to Create, Read, Update, and Delete product records, making it easy to handle product data in various contexts such as inventory management, e-commerce, and more.

Features:
Create: Add new products with essential details such as name, brand, madeIn and price.
Read: View a list of all products or search for specific items.
Update: Edit product details to keep information current.
Delete: Remove products that are no longer needed.

Technologies Used:
Frontend: Thymeleaf for the user interface.
Backend: Spring MVC for server-side logic.
Database: H2 Database for storing product information.
Styling: Bootstrap for modern design.
API: RESTful API for communication between frontend and backend.

API Endpoints:
GET: /products/getform - Get the form to add new Product
GET: /products/getproducts - Retrieve a list of all products.
POST: /products/saveproduct - Create a new product.
GET: /products/editproduct/{proId} - Update an existing product.
GET: /products/deleteproduct/{proId} - Delete a product.

Add a New Product:
Navigate to the "Add Product" section and fill out the form with product details.

View Products:
Access the "Product List" to view all products. You can search and filter the list as needed.

Update a Product:
Click on a product in the list to edit its details.

Delete a Product:
Remove a product by selecting it from the list and clicking the "Delete" button.

Contact:
For any questions or feedback, please contact Debashis.
