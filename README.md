# Invoice Tracker

A web application built with Spring Boot for users to create, manage, and export their invoices to PDF files.

## Table of Contents

- [About](#about)
- [Features](#features)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## About

Invoice Tracker is a Spring Boot web application designed to simplify invoice management for users. It provides functionalities for creating, managing, and exporting invoices to PDF files.

## Features

- Simple interface for creating and managing invoices.
- Export invoices to PDF files for easy sharing and record-keeping.
- Multi-user support with two authorities: USER and ADMIN.
- Utilizes MySQL DBMS for efficient data storage.

## Getting Started

Follow these steps to set up and run Invoice Tracker locally.

### Prerequisites

- Java Development Kit (JDK), version 17 or higher
- Maven
- MySQL Database Server

### Installation

1. Clone the repository:

 ```shell
git clone https://github.com/kalumatic/invoice-tracker.git
cd invoice-tracker
 ```

2. Configure MySQL:
- Create a database schema named `invoice_tracker`.
- Update `application.properties` with your database configuration:

  ```properties
  spring.datasource.url=jdbc:mysql://localhost:3306/invoice_tracker
  spring.datasource.username=username
  spring.datasource.password=password
  ```

3. Build and run the application:
 
```shell
./mvnw clean install
./mvnw spring-boot:run
 ```

## Usage

1. Access the application at `http://localhost:8080` in your web browser.
2. Log in using one of the default users:

   | username |  password   |    roles    |
   |:--------:|:-----------:|:-----------:|
   |   kalu   | progrunners | USER, ADMIN |
   |   srki   | progrunners | USER, ADMIN |
   |  nikola  |   client    |    USER     |
   |   tara   |   client    |    USER     |

  or create a new user in the database, and for password user bcrypt

3. Create, manage, and export invoices as needed.  Admins can also view the list of all users and invoices.

## Contributing

Contributions are welcome! If you'd like to contribute to Invoice Tracker, follow these steps:
1. Fork the repository.
2. Create a new branch for your feature/fix.
3. Make your changes and commit them.
4. Push the changes to your fork.
5. Submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).

## Contact

For questions or feedback, please contact [maticluka888@gmail.com](mailto:your.email@example.com).
