# Quiz-Application-V1

A simple, scalable Monolithic Quiz Application built with Spring Boot. This app allows creating quizzes with categorized questions, retrieving quiz questions, submitting answers, and calculating scores using RESTful APIs.

## Features

- Add and manage quiz questions by category.
- Generate quizzes based on question categories and desired number of questions.
- Retrieve quiz questions for a specific quiz.
- Submit quiz answers and get the computed score.
- Clean, modular REST controllers for Questions and Quizzes.
- Built with Spring Boot following layered architecture for easy maintenance and scalability.

## Technology Stack

- Java 11+
- Spring Boot
- Spring Web (REST API)
- Spring Data JPA (optional, for persistence)
- Lombok (for boilerplate reduction)
- Maven or Gradle

## API Endpoints

### Question Controller

| Method | Endpoint                | Description                     |
| ------ | ----------------------- | -------------------------------|
| GET    | /question/allQuestions  | Retrieve all questions           |
| GET    | /question/category/{category} | Get questions by category    |
| POST   | /question/add           | Add a new question               |

### Quiz Controller

| Method | Endpoint                 | Description                          |
| ------ | ------------------------ | -----------------------------------|
| POST   | /quiz/create             | Create a quiz by category and count |
| GET    | /quiz/get/{id}           | Retrieve quiz questions by quiz ID  |
| POST   | /quiz/submit/{id}        | Submit quiz answers and calculate score |

## How It Works

1. **Add Questions**: Admin or authorized user can add questions into categories.
2. **Create Quiz**: Create a quiz by specifying category, number of questions, and title.
3. **Retrieve Quiz Questions**: Fetch questions for the created quiz.
4. **Submit Answers**: Users submit their responses; the system calculates and returns the score.


## Future Enhancements

- User authentication and role-based access control.
- Store user quiz history and scores.
- Pagination and filtering for large question banks.
- Enhanced quiz timer and real-time monitoring.
- Support for multiple quiz formats (e.g., True/False, Multiple Choice).

## Getting Started

1. Clone the repository.
2. Configure application properties for your database.
3. Build and run the Spring Boot application.
4. Use Postman or any API client to interact with endpoints.

## Acknowledgments

Thanks to Madam [Insert Madam's Name] for support and guidance throughout this project.

---

Feel free to contribute or raise issues. Enjoy quizzing!
