CarCatalog REST API
Welcome to the CarCatalog API! This is a Spring Boot application that helps you manage a digital catalog of cars. Think of it as a virtual garage where you can add, view, update, and remove cars, as well as search through your collection in various ways.
What Can This API Do?

✨ Create, view, update, and delete cars in the catalog
🔍 Smart search features:

Find cars by brand
Search within your price range
Check what's available vs. what's sold


📋 View results page by page (pagination)
✅ Validates all your inputs to prevent errors
📚 Comes with detailed API documentation
🛡️ Comprehensive error handling to help you understand what went wrong

Built With

Java & Spring Boot
MySQL Database for data storage
API documentation using Swagger

See It In Action
Here are some examples of the API in use:
Getting All Cars
![Get All Cars](docs/images/Screenshot 2025-02-10 132910.png)
Creating a New Car
![Create Car](docs/images/Screenshot 2025-02-10 132928.png)
Searching Cars
![Search Cars](docs/images/Screenshot 2025-02-10 133040.png)
Updating a Car
![Update Car](docs/images/Screenshot 2025-02-10 133141.png)
Deleting a Car
![Delete Car](docs/images/Screenshot 2025-02-10 133215.png)
Additional Postman Operations
![More Operations](docs/images/Screenshot 2025-02-10 133243.png)
![Additional Examples](docs/images/Screenshot 2025-02-10 133256.png)

API Overview
The API lets you:

Get a list of all cars
Look up specific cars
Add new cars to the catalog
Update existing car details
Remove cars from the catalog
Search cars using different filters

Each car in the catalog includes:

Brand name
Model
Year it was made
Price
Whether it's available or sold

Want to Learn More?
Once you start the application, you can explore all available endpoints and try them out through our Swagger documentation at:
http://localhost:8080/swagger-ui.html
