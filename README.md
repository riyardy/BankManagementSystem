                                                                   BANK MANAGEMENT SYSTEM

Project Description:
The Bank Management System is a desktop-based application developed in Java using Swing for GUI and MySQL for backend database operations. 
It provides users with basic banking functionalities such as account creation, login, deposit, withdrawal, mini statement view, and PIN change.

Features:

1.Multi-step account signup process

2.Login using card number and PIN

3.Account type selection (Saving, Fixed Deposit, etc.)

4.Services selection (ATM Card, Internet Banking, etc.)

5.Deposit and withdraw functionality

6.Mini statement display with transaction history

7.PIN change functionality

8.JDBC-based connection to MySQL database

9.User-friendly interface with proper validations

Technologies Used:Java,Swing (GUI),MySQL,JDBC,IDE: VS Code

Database Schema:
Database Name: bankmanagementsystem

Tables:

signup
Fields: formno, name, father_name, dob, gender, email, marital_status, address, city, pincode, state

signuptwo
Fields: formno, religion, category, income, education, occupation, pan, aadhar, senior_citizen, existing_account

signupthree
Fields: formno, account_type, card_number, pin_number, services

login
Fields: formno, card_number, pin_number

bank
Fields: card_number, date, type, amount

How to Run the Project:

1.Install Java and MySQL on your system

2.Clone or download the project files

3.Create a database named bankmanagementsystem in MySQL

4.Create all required tables as per the schema above

5.Open the project in an IDE (e.g., VS Code or IntelliJ)

6.Update your MySQL username and password in Conn.java

7.Compile and run SignupOne.java to start the application

Note:
This project is developed for educational purposes and demonstrates the basic structure of a bank management system using core Java technologies.


