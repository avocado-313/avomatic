# Avomatic

This is a Java project with a focus on testing (automated tested for Avocado: Avomatic). It uses Maven for dependency management and includes a suite of tests for the Avocado application.

## Project Structure

- `.github/workflows/maven.yml`: Contains the GitHub Actions workflow for Maven.
- `avc_suite.xml`: The XML file for the test suite.
- `images/`: Directory for storing image files.
- `pom.xml`: The Maven configuration file.
- `reports/screenshotsSuccess/`: Directory for storing screenshots from successful tests.
- `src/`: The source code directory.
    - `config/env.properties`: Environment configuration properties.
    - `main/java/avocado/`: Contains the main Avocado application files.
    - `main/java/PageBase/`: Contains the base page for the application.
    - `main/java/Utilities/`: Contains utility classes for the application.
    - `test/java/avocadoTests/`: Contains the test files for the Avocado application.
    - `test/java/Base/`: Base test files.
    - `test/java/regression/`: Regression test files.
    - `test/java/Utilities/`: Contains utility classes for the tests.

## CI/CD

This project uses GitHub Actions for CI. The workflow is defined in `.github/workflows/maven.yml`. This workflow, performs the following tasks:

- Trigger: Activates on push or pull request to master, manual trigger, or daily at 21:55 UTC (IST 03:25, EGY 23:55, KSA 00:55).

- Build Job: Checks out the code, sets up JDK 17, and builds the project with Maven, skipping tests.

- Test Job: Runs only if the build job succeeds and the workflow was manually triggered or is running on schedule. It sets up JDK 17 and Chrome, runs the Maven tests with specific options, and creates a reports directory. It uploads the test report as an artifact and, in case of test failures, uploads failure screenshots