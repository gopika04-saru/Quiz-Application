# 🎯 QuizApp

## 📝 Overview
QuizApp is a RESTful web application built using **Spring Boot** 🚀 and **PostgreSQL** 🗄️. It allows users to create quizzes, retrieve questions based on categories, and submit answers. The application provides APIs to manage quizzes and questions efficiently.

## ✨ Features
- ✅ Create and store quiz questions with multiple-choice answers.
- 📂 Retrieve questions based on categories.
- 🎲 Generate quizzes with a specified number of random questions.
- 🏆 Submit quiz responses and calculate scores.
- Uses **Spring Boot**, **Spring Data JPA**, and **PostgreSQL**.

## 🛠️ Technologies Used
- 🔹 **Spring Boot 3.4.4** 🌱
- 🔹 **Spring Data JPA** ⚙️
- 🔹 **PostgreSQL** 🗃️
- 🔹 **Maven** 📦
- 🔹 **Java 21** ☕

## 📌 Installation & Setup
### ✅ Prerequisites
- ☕ Java 21 installed
- 🗄️ PostgreSQL installed and running
- 📦 Maven installed

### 🚀 Steps to Run
1. Clone the repository:
   ```sh
   git clone https://github.com/your-repository/QuizApp.git
   cd QuizApp
   ```

2. Configure the database in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/questiondb
   spring.datasource.username=postgres
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Build and run the application:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```

## 📌 pom.xml Dependencies
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
    </dependency>
</dependencies>
```

## 📌 API Endpoints
### 📌 Question Controller
📦 **Base URL**: `/Question`

📝 **Endpoints:**
```
📋 GET    /Question/allQuestions       - Get all questions
🔍 GET    /Question/category/{category} - Get questions by category
➕ POST   /Question/add                 - Add a new question
```

### 🎯 Quiz Controller
📦 **Base URL**: `/Quiz`

📝 **Endpoints:**
```
📝 POST   /Quiz/create?category={category}&numQ={num}&title={title} - Create a quiz
📄 GET    /Quiz/get/{id}                                             - Get quiz questions
🏆 POST   /Quiz/submit/{id}                                          - Submit a quiz
```

## 📌 Controller Code Examples
### 📌 QuestionController.java
```java
@RestController
@RequestMapping("/Question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/allQuestions")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        questionService.addQuestion(question);
        return ResponseEntity.ok("Question added successfully!");
    }
}
```
### 📌 QuizController.java
```
@RequestMapping("Quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title) {
        return  quizService.createQuiz(category,numQ,title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id) {
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses) {
        return quizService.calculateResult(id,responses);
    }
}
```
## 📊 Database Schema
### `📄 Question` Table
| Column          | Type    |
|----------------|---------|
| 🆔 id             | Integer |
| ❓ questionTitle  | String  |
| 🅰️ option1        | String  |
| 🅱️ option2        | String  |
| 🆎 option3        | String  |
| 🅾️ option4        | String  |
| 📂 category       | String  |
| ✅ rightAnswer    | String  |
| 🎚 difficultylevel| String  |

### `📝 Quiz` Table
| Column   | Type      |
|----------|----------|
| 🆔 id       | Integer  |
| 🏷 title    | String   |
| 📋 questions| List<Question> |

## 🚀 Future Enhancements
- 🔐 User authentication & authorization
- 🎨 UI for quiz participation
- ⏳ Timer-based quizzes
- 📈 Advanced difficulty level handling

## 👥 Contributors
- **Gopika Saranya** - 💻 Developer

## ⚖️ License
This project is open-source and available under the **MIT License** 📜.

