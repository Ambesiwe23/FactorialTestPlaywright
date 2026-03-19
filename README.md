 Factorial App Test Automation

## Overview
This project contains automated tests for a factorial calculator web application.

The testing approach includes:
- Manual exploratory testing
- Test case documentation
- Automated UI and API validation using Playwright (Java)
- Page Object Model (POM) design pattern

---

## Tech Stack
- Java
- Playwright
- TestNG
- Maven

---

## Test Coverage
- Functional testing
- Input validation
- UI validation
- Navigation testing
- API request validation

---

## Key Features Tested
- Factorial calculation
- Invalid input handling
- Page title verification
- Hyperlink navigation
- API method validation (GET vs POST)

---

## Known Defects Found
- Incorrect HTTP method used (POST instead of GET)
- Validation inconsistencies
- UI feedback issues (if applicable)

---

## Observations

Some tests fail due to application issues such as:
- Result element not becoming visible
- Incorrect API method used
- UI inconsistencies

These failures indicate defects in the application rather than test issues.

## How to Run Tests

### 1. Install dependencies
```bash
mvn clean install
