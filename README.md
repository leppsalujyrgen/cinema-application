# Cinema Booking System
## Overview
This is a Cinema Booking System built using Java Spring framework and Maven. The application allows users to browse movies, view their schedules, and book seats for screenings. The project includes both backend and frontend components.

## Setup
To run the application, follow these steps:

1. Clone the repository to your local machine:
`git clone https://github.com/leppsalujyrgen/cinema-application.git`

1. Navigate to the project directory:
`cd cinema-application`

1. Build the project using Maven:
`mvn clean install`

1. Run the application using the Maven Spring Boot plugin:
`mvn spring-boot:run`

1. Access the application through a web browser at
`http://localhost:8080/`

## Database
The application uses an H2 in-memory database. To access the H2 database console, navigate to http://localhost:8080/h2-ui in your web browser. Use the following credentials:

* Username: admin
* Password: admin

## Usage
* Homepage: Browse through available movies and filter them by genre or age restriction.
* Schedule Page: View the schedule of movie screenings and filter them by genre or age restriction.
* Movie Overview Page: See detailed information about a specific movie and upcoming screenings.
* Seat Booking: Select seats for a screening and complete the booking process. (Incomplete: Selected seats can not be submitted)

## Dependencies
Java 8 or higher
Maven
Spring Boot
Thymeleaf
H2 Database

## Templates used
* [HTML/CSS/JS front-end template by Themezy](https://www.themezy.com/free-website-templates/10-movie-reviews-responsive-template)
* [Spring Boot MVC template project by Bezkoder](https://github.com/bezkoder/spring-boot-thymeleaf-example)

## Author
Jürgen Leppsalu

License
This project is licensed under the MIT License.
