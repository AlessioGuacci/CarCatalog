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
Here are some examples of the API in use through Postman:

Creating a New Car
(Error msg)
https://github.com/AlessioGuacci/CarCatalog/blob/master/Screenshot%202025-02-10%20132910.png

(Success)
https://github.com/AlessioGuacci/CarCatalog/blob/master/Screenshot%202025-02-10%20132928.png

Searching Cars
(All Cars)
https://github.com/AlessioGuacci/CarCatalog/blob/master/Screenshot%202025-02-10%20133040.png

(Specific Car with Error)
https://github.com/AlessioGuacci/CarCatalog/blob/master/Screenshot%202025-02-10%20133243.png

(Specific Car)
https://github.com/AlessioGuacci/CarCatalog/blob/master/Screenshot%202025-02-10%20133256.png

(With Filters)
https://github.com/AlessioGuacci/CarCatalog/blob/master/Screenshot%202025-02-10%20133313.png
https://github.com/AlessioGuacci/CarCatalog/blob/master/Screenshot%202025-02-10%20133337.png
https://github.com/AlessioGuacci/CarCatalog/blob/master/Screenshot%202025-02-10%20133350.png

(With Pages)
https://github.com/AlessioGuacci/CarCatalog/blob/master/Screenshot%202025-02-10%20133422.png

Deleting a Car
(Specific Car)
https://github.com/AlessioGuacci/CarCatalog/blob/master/Screenshot%202025-02-10%20133215.png

(Delete All Cars)
https://github.com/AlessioGuacci/CarCatalog/blob/master/Screenshot%202025-02-10%20133429.png


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
