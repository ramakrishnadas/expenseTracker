# Overview

This is an Expense Tracker application using Java. I created this to learn and demonstrate how to use the Java programming language to create a basic commandline-based program that allows users to add and delete expenses, view the list of expenses, and view the expense summary (where each expense category is totaled, and the total expenses amount is displayed). There are two types of expenses: one-time expenses and recurring expenses. The only difference between them is that recurring expenses have two additional fields to be filled: frequency and end date.

To run the application, you must execute the Java project. A menu will be displayed in the command line, showing the available options. The user can then interact with the application by following the prompts. The user can choose to add an expense or a recurring expense, to view the list of expenses, to delete an expense, to view the expense summary, or to exit the program.

When the user chooses to add an expense or a recurring expense, the application will prompt them to input the necessary fields to add an expense. Additionally, the program validates that the date and amount introduced by the user are correctly formatted.

When the user chooses to delete an expense, they program will prompt them to input the ID of the expense they wish to delete. Once the user provides an ID, assuming the ID exists, the program will delete the corresponding expense.

When the user chooses to view the expense summary, the program performs the necessary calculations and displays the summary to the user. The summary includes the category totals and the overall total.

It is important to note that, whenever the user introduces an invalid input or choice, the program will handle it gracefully and display the main menu once again.

Software demonstration video: [Software Demo Video](https://youtu.be/Ruq90qIK33I)

# Development Environment

- Visual Studio Code
- Git / GitHub
- OpenJDK 17.0.13
- OpenJDK Runtime Environment Temurin-17.0.13+11
- OpenJDK 64-Bit Server VM Temurin-17.0.13+11 (build 17.0.13+11, mixed mode, sharing)

# Useful Websites

- [Java Setup in VSCode](https://code.visualstudio.com/docs/java/java-tutorial)
- [Java Setup Tutorial](https://www.youtube.com/watch?v=BB0gZFpukJU)
- [Java Language Tutorial](https://www.w3schools.com/java/)
- [Java Reference Documentation](https://www.w3schools.com/java/java_ref_reference.asp)

# Future Work

- Implement an appealing GUI to improve user experience.
- Add different options for personalized expense summaries.
- Improve data validation and error handling.
- Integrate with database to save expense data.
- Develop expense summary download functionality.
- Add import/export feature for expense data and summary.