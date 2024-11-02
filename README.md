Welcome to the Foundation Course repository! This project contains Java code focused on design patterns and data structures, 
along with corresponding test cases to ensure functionality and reliability.
## [Table of Contents](#table-of-contents)
  * [Introduction](#introduction)
  * [Getting Started](#getting-started)
    + [Clone the Repository](#clone-the-repository)
    + [Navigate to the Project Directory](#navigate-to-the-project-directory)
  * [Project Structure](#project-structure)
  * [Usage](#usage)
  * [Running Tests](#running-tests)
  * [Contributing](#contributing)
  * [License](#license)
## Introduction
This repository serves as a comprehensive guide to understanding fundamental concepts in Java programming, 
particularly in design patterns and data structures. 
It is designed for learners who want to deepen their knowledge and practical skills in software development.
## Getting Started
To get started with this project, you need to have the following prerequisites installed:
  Java JDK (version 8 or higher)
  Maven (for managing dependencies and building the project)
  ### Clone the Repository
  You can clone this repository using the following command:
  ```bash
     git clone https://github.com/eswarap/foundation-course.git
  ```
  ### Navigate to the Project Directory
  ```bash
     cd foundation-course
  ```
## Project Structure
The project is organized as follows:
```text
foundation-course/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org/
│   │           └── woven/
│   │               └── algorithm/       # Contains data structure implementations
│   │               └── collections/     # Contains data structure implementations
|   |               └── datastructures/  # Contains data structure implementations
│   │               └── designpattern/   # Contains design pattern implementations
│   │
│   └── test/
│       └── java/
│           └── org/
│               └── woven/
│                  └── algorithm/         # Contains test case
│                  └── collections/       # Contains test case
|                  └── datastructures/    # Contains test case
│                  └── designpattern/     # Contains test case
│
├── pom.xml                               # Maven configuration file
└── README.md                             # Project documentation
```
## Usage
To use any of the data structures or design patterns, simply import the relevant classes into your Java application. For example:
```bash
  package org.woven.foundation.course.datastructures;
  
  import lombok.Getter;
  
  import java.util.logging.Logger;
  
  @Getter
  public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList(final T value) {
        Node<T> newNode = new Node<>(value);
        head = newNode;
        tail = newNode;
        size = 1;
    }
  }
```
## Running Tests
To run the test cases included in this project, you can use Maven. Execute the following command in your terminal:
```bash
mvn test
```
This will compile the code and run all the tests, providing you with feedback on their success or failure.
## Contributing
Contributions are welcome! If you would like to contribute to this project, please follow these steps:
Fork the repository.
Create a new branch (git checkout -b feature/YourFeature).
Make your changes and commit them (git commit -m 'Add some feature').
Push to the branch (git push origin feature/YourFeature).
Open a pull request.
## License
This project is licensed under the MIT License - see the LICENSE file for details.
 Feel free to explore and enhance your understanding of Java design patterns and data structures through this course!
