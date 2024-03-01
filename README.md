That's great! Including Docker support and Swagger UI can enhance the usability and deployment of your Spring Boot Calculator API. Here's an updated version of the README to reflect the Dockerization and Swagger UI integration:

---

# Calculator API Application

## Overview

This is a simple Calculator API application developed using Java Spring Boot. The purpose of this application is to provide basic arithmetic calculations through a RESTful API.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Swagger UI](#swagger-ui)
- [Usage Examples](#usage-examples)
- [Testing](#testing)
- [Dockerization](#dockerization)
- [Contributing](#contributing)
- [License](#license)

## Features
Four basic arithmetic operations: Addition, Subtraction, Multiplication, and Division.
Memory functions: M+ (Add to memory), M- (Subtract from memory), MR (Recall memory), MC (Clear memory).
RESTful API for easy integration into various applications.
Swagger UI for interactive API documentation.
Docker support for containerized deployment.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) 8 or later installed.
- Apache Maven installed.
- Docker installed.
- Your favorite IDE (e.g., IntelliJ, Eclipse) for development.

## Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/Linda-Boateng/CalculatorAPI.git
   ```

2. Navigate to the project directory:

   ```bash
   cd calculator-api
   ```

3. Build the project using Maven:

   ```bash
   mvn clean install
   ```

4. Run the application:

   ```bash
   java -jar target/CalculatorApplication-1.0.0.jar
   ```

The application will be running at `http://localhost:5000`.

## API Endpoints

- **Addition:**
  - Endpoint: `/api/calculator/add`
  - Method: `POST`
  - Request Body: `{"operand1": 5, "operand2": 3}`

- **Subtraction:**
  - Endpoint: `/api/calculator/subtract`
  - Method: `POST`
  - Request Body: `{"operand1": 5, "operand2": 3}`

- **Multiplication:**
  - Endpoint: `/api/calculator/multiply`
  - Method: `POST`
  - Request Body: `{"operand1": 5, "operand2": 3}`

- **Division:**
  - Endpoint: `/api/calculator/divide`
  - Method: `POST`
  - Request Body: `{"operand1": 6, "operand2": 2}`
Memory Functions:

M+ (Add to memory):

Endpoint: /api/calculator/memory/add
Method: POST
Request Body: {"value": 10}
M- (Subtract from memory):

Endpoint: /api/calculator/memory/subtract
Method: POST
Request Body: {"value": 5}
MR (Recall memory):

Endpoint: /api/calculator/memory/recall
Method: GET
MC (Clear memory):

Endpoint: /api/calculator/memory/clear
Method: POST

## Swagger UI

Swagger UI is available at: [http://localhost:5000/swagger-ui.html](http://localhost:5000/swagger-ui.html)

Use the Swagger UI to interactively explore and test the API endpoints.

## Usage Examples

- **Addition:**
  ```bash
  curl -X POST -H "Content-Type: application/json" -d '{"operand1": 5, "operand2": 3}' http://localhost:5000/api/calculator/add
  ```

- **Subtraction:**
  ```bash
  curl -X POST -H "Content-Type: application/json" -d '{"operand1": 5, "operand2": 3}' http://localhost:5000/api/calculator/subtract
  ```

- **Multiplication:**
  ```bash
  curl -X POST -H "Content-Type: application/json" -d '{"operand1": 5, "operand2": 3}' http://localhost:5000/api/calculator/multiply
  ```

- **Division:**
  ```bash
  curl -X POST -H "Content-Type: application/json" -d '{"operand1": 6, "operand2": 2}' http://localhost:5000/api/calculator/divide
  ```

## Testing

To run the unit tests, use the following Maven command:

```bash
mvn test
```

## Dockerization

Build the Docker image:

```bash
docker build -t calculator-api:1.0.0 .
```

Run the Docker container:

```bash
docker run -p 5000:5000 calculator-api:1.0.0
```

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.

## License

This project is licensed under the [MIT License](LICENSE).
