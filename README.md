
# API Testing with RestAssured and ApprovalTests

This repository demonstrates how to use [RestAssured](https://rest-assured.io/) for API testing and [ApprovalTests](https://approvaltests.com/) for verifying API responses. The project is built using [Gradle](https://gradle.org/) and is designed to help you get started with both tools in a Java environment.

## Project Structure

```plaintext
├── build.gradle
├── README.md
├── src
│   ├── main
│   │   └── java
│   │       └── apis
│   │           └── JsonPlaceholderApi.java
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── JsonPlaceholderApiTests.java
```

## Prerequisites

- [Java JDK 11+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Gradle 6+](https://gradle.org/install/)

## Dependencies

The project uses the following dependencies, which are declared in the `build.gradle` file:

- **JUnit 5**: For writing and running tests.
  ```groovy
  testImplementation 'org.junit.jupiter:junit-jupiter-api:5.10.0'
  testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.10.0'
  ```
- **RestAssured**: For making HTTP requests and validating responses. Available in both `main` and `test` source sets.
  ```groovy
  testImplementation 'io.rest-assured:rest-assured:5.3.2'
  implementation 'io.rest-assured:rest-assured:5.3.2'
  ```
- **ApprovalTests**: For verifying the correctness of API responses by comparing them to approved results.
  ```groovy
  testImplementation 'com.approvaltests:approvaltests:24.4.0'
  ```

## Running the Tests

To run the tests and see how the API responses are validated:

1. Clone this repository:

    ```sh
    git clone https://github.com/teymureyvaz/approvaltests-example.git
    ```

2. Navigate to the project directory:

    ```sh
    cd <project_directory>
    ```

3. Run the tests:

    ```sh
    ./gradlew test
    ```

This will run the tests in `JsonPlaceholderApiTests.java`, which includes:
- `testGetUserBody`: Verifies the response body of a GET request to `/users/1`.
- `testGetUserFullResponse`: Verifies the full response (headers and body) for the same endpoint, masking dynamic content like dates and cookies.

## ApprovalTests Workflow

1. **First Run**: On the first run, ApprovalTests will generate `.received.txt` files for each test in `src/test/resources/com/example/`.

2. **Approve Responses**: If the responses are correct, approve them by renaming the `.received.txt` files to `.approved.txt`.

3. **Subsequent Runs**: On subsequent test runs, ApprovalTests will compare the actual responses to the approved ones. If they match, the tests pass.

## Customizing the API

To test different endpoints, modify the `JsonPlaceholderApi` class to use different paths, or add new methods to the `JsonPlaceholderApiTests` class.

## Example API Tests

This project includes two main tests:

1. **`testGetUserBody`**: This test sends a GET request to `/users/1` using the `JsonPlaceholderApi` class and verifies the response body using ApprovalTests.

2. **`testGetUserFullResponse`**: This test sends the same GET request but verifies the entire response, including headers and body. Dynamic content such as dates and cookies can be masked during verification.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
