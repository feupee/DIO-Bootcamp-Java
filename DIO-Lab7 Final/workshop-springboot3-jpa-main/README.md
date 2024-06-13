# Workshop Spring Boot 3 with JPA

## Overview

Welcome to the **Workshop Spring Boot 3 with JPA** project. This comprehensive workshop is designed to equip you with the knowledge and skills required to develop robust web services using Spring Boot and JPA/Hibernate. Our primary focus is on creating a well-structured, scalable, and maintainable backend application leveraging some of the most powerful technologies in the Java ecosystem.

## Goals

This workshop aims to achieve the following objectives:

1. **Create a Spring Boot Java Project**: Initiate and set up a new Spring Boot project using Maven, enabling rapid application development with Spring Boot's auto-configuration and starter dependencies.

2. **Implement Domain Model**: Design and implement the domain model, encapsulating the core business logic and entities in a structured and maintainable manner.

3. **Structure Logical Layers**: Establish a clear separation of concerns by organizing the codebase into logical layers:
   - **Resource Layer**: RESTful controllers to handle HTTP requests and responses.
   - **Service Layer**: Business logic and service orchestration.
   - **Repository Layer**: Data access and interaction with the database using JPA repositories.

4. **Configure Test Database (H2)**: Set up and configure an H2 in-memory database for testing and development purposes, ensuring a smooth and efficient development workflow.

5. **Populate the Database**: Seed the database with initial data, facilitating the demonstration and testing of various CRUD operations.

6. **CRUD Operations**: Implement Create, Retrieve, Update, and Delete operations to interact with the domain entities, providing a complete suite of data manipulation functionalities.

7. **Exception Handling**: Develop a robust exception handling mechanism to gracefully manage and respond to various error scenarios, enhancing the application's resilience and user experience.

## Technologies

This project leverages the following technologies to deliver a high-quality, scalable, and maintainable web service solution:

- **Spring Boot**: Streamlined and efficient Java-based framework for building production-ready applications quickly and easily.
- **Maven**: Dependency management and build automation tool to simplify project configuration and management.
- **JPA/Hibernate**: Object-relational mapping framework to map Java objects to database tables, providing a seamless data access layer.
- **H2 Database**: Lightweight in-memory database for fast and efficient testing and development.
- **Apache Tomcat**: Embedded servlet container to run Spring Boot applications, facilitating easy deployment and management.
- **Postman**: API development and testing tool to streamline the testing of RESTful web services.
- **PostgreSQL**: Robust, scalable, and open-source relational database management system for production deployment.
- **Heroku**: Cloud platform for deploying, managing, and scaling applications effortlessly.
<div align="left">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" height="40" alt="spring logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-original.svg" height="40" alt="postgresql logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" height="40" alt="java logo"  />
  <img width="12" />
  <img src="https://skillicons.dev/icons?i=postman" height="40" alt="postman logo"  />
  <img width="12" />
  <img src="https://skillicons.dev/icons?i=maven" height="40" alt="apachemaven logo"  />
  <img width="12" />
  <img src="https://cdn.simpleicons.org/apachetomcat/F8DC75" height="40" alt="tomcat logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/heroku/heroku-original.svg" height="40" alt="heroku logo"  />
</div>

###

## Project Structure

The project is structured as follows to ensure clarity, maintainability, and scalability:

- **src/main/java**: Contains the main application code.
  - **com.educandoweb.course**: Base package.
    - **entities**: Domain entities representing the core business objects.
    - **repositories**: JPA repositories for data access and manipulation.
    - **services**: Business logic and service layer components.
    - **resources**: RESTful controllers to handle incoming HTTP requests.
    - **config**: Configuration classes, including database setup and other settings.
- **src/main/resources**: Configuration files and resources.
  - **application.properties**: Main configuration file for the Spring Boot application.
- **src/test/java**: Contains test classes.
- **pom.xml**: Maven configuration file to manage project dependencies and build process.

## Getting Started

Follow these steps to set up and run the project locally:

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/workshop-springboot3-jpa.git
   cd workshop-springboot3-jpa
   ```

2. **Configure the Application**:
   - Ensure the `application.properties` file is correctly set up for your environment.
   - Configure the database settings for H2 and PostgreSQL as needed.

3. **Build the Project**:
   ```bash
   mvn clean install
   ```

4. **Run the Application**:
   ```bash
   mvn spring-boot:run
   ```

5. **Access the Application**:
   - The application will be available at `http://localhost:8080`.
   - Use Postman to test the RESTful endpoints.

## Deployment

For production deployment, the application is configured to run on PostgreSQL and can be easily deployed to Heroku or any other cloud platform.

## Contributing

We welcome contributions to enhance this project. Please fork the repository and submit pull requests for review.

## License

This project is licensed under the MIT License.

---

By following this structured approach and leveraging these powerful technologies, you will be able to develop and deploy high-quality web services efficiently, making your applications robust and scalable for enterprise environments.
