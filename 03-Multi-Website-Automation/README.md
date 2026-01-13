# Multi-Website Automation Testing

Simple automation testing project covering two e-commerce websites using Selenium WebDriver and TestNG.

## Project Overview

This project tests two websites with basic user flows including registration, login, product search, cart operations, and checkout. Test data is retrieved randomly from MySQL databases.

## Websites Tested

1. **Practice Software Testing** - Demo e-commerce site
2. **Automation Exercise** - Practice testing website

## Technologies Used

- Java
- Selenium WebDriver
- TestNG
- MySQL (for test data)
- Chrome & Edge browsers

## Project Structure
```
multi-website-automation/
├── src/
│   ├── practicesoftware/
│   │   ├── PracticeSoftwareHelper.java
│   │   └── PracticeSoftwareTests.java
│   │
│   ├── automationexercise/
│   │   ├── AutomationExerciseHelper.java
│   │   └── AutomationExerciseTests.java
│   │
│   └── utils/
│       └── TestUtils.java
│
└── screenshots/
```

## How It Works

Each website has two files:
- **Helper**: Sets up the browser, connects to database, and gets random test data
- **Tests**: Contains all test cases that run in sequence

### Database Integration

- **Practice Software**: Uses `classicmodels` database
- **Automation Exercise**: Uses `automation_test_data` database

Test data (names, emails, addresses) is fetched randomly from MySQL to make each test run unique.

## Test Coverage

### Practice Software Testing (13 tests)
- Homepage accessibility
- User registration & login
- Product search & filtering
- Add/remove items from cart
- Checkout process
- Account management

### Automation Exercise (14 tests)
- Homepage verification
- User registration
- Product search & details
- Cart operations
- Checkout
- Contact form & subscription
- Category & brand filtering
- Scroll functionality

## Features

- Sequential test execution
- Random test data from database
- Automatic screenshots on test failure
- Scroll and screenshot utility

## How to Run

1. Set up MySQL with test data
2. Update database credentials in Helper files
3. Run test classes using TestNG

## Notes

Tests are designed to run sequentially - each test continues from where the previous one stopped, maintaining the user session throughout.

---

**Author:** Mahdi  
**Date:** January 2025
