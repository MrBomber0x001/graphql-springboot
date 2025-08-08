# GraphQL API for Customer Order Management

This project implements a GraphQL API using Spring Boot for managing customers, salespersons, products, orders, and order lines. Below is an overview of the GraphQL schema and setup instructions for running the application.

## Table of Contents
- [GraphQL Schema](#graphql-schema)
- [Prerequisites](#prerequisites)
- [Setup](#setup)
- [Running the Application](#running-the-application)
- [Testing the API](#testing-the-api)
- [Sample Queries and Mutations](#sample-queries-and-mutations)


## GraphQL Schema
The GraphQL schema defines the following types and operations:

### Types
- **Customer**: Represents a customer with fields like `id`, `firstName`, `lastName`, `email`, `phoneNumber`, `address`, `city`, `state`, and `zipCode`.
- **Salesperson**: Represents a salesperson with similar fields as Customer.
- **Product**: Represents a product with fields like `id`, `name`, `size`, `variety`, `price`, and `status`.
- **Order**: Represents an order, linking a `customer`, `salesperson`, and a list of `orderLines`.
- **OrderLine**: Represents an item in an order, linking a `product` and specifying a `quantity`.

### Inputs
- **CustomerInput**: Used for creating or updating customer data in mutations.

### Queries
- `customers`: Retrieves a list of all customers.
- `customerById(id: ID)`: Retrieves a customer by their ID.
- `customerByEmail(email: String)`: Retrieves a customer by their email.
- `salespersonById(id: ID)`: Retrieves a salesperson by their ID.
- `salespersonByEmail(email: String)`: Retrieves a salesperson by their email.
- `products`: Retrieves a list of all products.
- `productById(id: ID)`: Retrieves a product by its ID.
- `orders`: Retrieves a list of all orders.
- `orderById(id: ID)`: Retrieves an order by its ID.

### Mutations
- `addCustomer(input: CustomerInput)`: Adds a new customer to the system.

The schema is defined in `schema.graphqls` and is located in the `src/main/resources` directory.

## Prerequisites
- **Java**: Version 17 or higher
- **Maven**: For dependency management and building the project
- **Spring Boot**: Version 3.x
- **GraphQL Java Tools**: For GraphQL schema parsing and execution
- **Database**: (Optional) Configure a database like H2, MySQL, or PostgreSQL for persistence

## Setup
1. **Clone the Repository**

2. **Configure Dependencies**:
   Ensure the following dependencies are included in your `pom.xml`:
   ```xml
   <dependencies>
       <dependency>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-graphql</artifactId>
       </dependency>
       <dependency>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-data-jpa</artifactId>
       </dependency>
       <dependency>
           <groupId>com.h2database</groupId>
           <artifactId>h2</artifactId>
           <scope>runtime</scope>
       </dependency>
   </dependencies>
   ```

3. **Place the GraphQL Schema**:
   Ensure the provided GraphQL schema is saved as `schema.graphqls` in `src/main/resources`.

4. **Configure Application Properties**:
   Update `src/main/resources/application.properties` with your database configuration, for example:
   ```properties
   spring.application.name=graphql-demo
    spring.graphql.schema.printer.enabled=true
    spring.jpa.hibernate.ddl-auto=none
    ```

## Running the Application
1. Build the project:
   ```bash
   mvn clean install
   ```

2. Run the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

3. Access the GraphQL endpoint at `http://localhost:8080/graphql`.

## Testing the API
Use a GraphQL client like **GraphiQL** or **Postman** to interact with the API:
- **GraphiQL**: Access `http://localhost:8080/graphiql` (if enabled in `application.properties`).
- **Postman**: Send POST requests to `http://localhost:8080/graphql` with a JSON body containing your GraphQL query or mutation.

## Sample Queries and Mutations
Below are some example GraphQL queries and mutations you can use to test the API:

### Query: Get All Customers
```graphql
query {
  customers {
    id
    firstName
    lastName
    email
  }
}
```

### Query: Get Customer by Email
```graphql
query {
  customerByEmail(email: "john.doe@example.com") {
    id
    firstName
    lastName
    phoneNumber
  }
}
```

### Mutation: Add a New Customer
```graphql
mutation {
  addCustomer(input: {
    firstName: "Jane"
    lastName: "Doe"
    email: "jane.doe@example.com"
    phoneNumber: "123-456-7890"
    address: "123 Main St"
    city: "Springfield"
    state: "IL"
    zipCode: "62701"
  }) {
    id
    firstName
    email
  }
}
```
