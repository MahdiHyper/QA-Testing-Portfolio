Manual Testing - Sauce Demo E-Commerce
📋 Project Overview
Manual testing performed on Sauce Demo e-commerce website to validate core functionalities including login, product browsing, cart management, and checkout process.
Website: https://www.saucedemo.com

**Test Scope**

Login and Logout
Products Display and Navigation
Shopping Cart Operations
Checkout Flow
Menu Navigation

**Test Environment**

Browser: Chrome (Latest Version)
OS: Windows 10
Testing Type: Manual Functional Testing

**Test Results**
Summary

Total Test Cases: 23
Passed: 20 (87%)
Failed: 3 (13%)

Results by Module
ModuleTotalPassedFailedLogin660Products862Cart330Checkout321Overview220Menu110

**Bugs Found**
BUG_001 - Product Images Issue

Priority: High | Severity: Medium
Problem: All products show same image when using problem_user
Impact: Users cannot identify products correctly

BUG_002 - Remove Button Not Working

Priority: High | Severity: High
Problem: Cannot remove products from cart with error_user
Impact: Users stuck with products in cart

BUG_003 - Checkout Form Data Issue

Priority: High | Severity: High
Problem: Lastname field data moves to Firstname field with error_user
Impact: Cannot complete checkout properly

**Test Documents**
Test_Cases.xlsx
Contains 23 test cases with detailed steps, test data, expected and actual results.
Bug_Reports.xlsx
Contains 3 bug reports with reproduction steps and screenshots.
Screenshots/
Visual proof of bugs found during testing.

✅ What Was Tested
Positive Testing:

Valid login scenarios
Product browsing and viewing
Adding products to cart
Complete checkout process
Menu navigation

Negative Testing:

Invalid login attempts
Empty field validations
Error user scenarios
Locked user access

Users Tested:

standard_user
problem_user
error_user
locked_out_user


**Conclusion**
Testing completed successfully. The website works well for most users with 87% test pass rate. Found 3 critical bugs that need fixing. All bugs are documented with clear steps to reproduce.

Tester: Mahdi Alboon
Date: December 2024
Status: Testing Complete
