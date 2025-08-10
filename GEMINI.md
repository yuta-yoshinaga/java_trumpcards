# GEMINI.md
This file provides guidance to GEMINI when working with code in this repository.

## High-Level Code Architecture

This project implements a command-line Blackjack game in Java. The core components are:

*   **`Card.java`**: Defines the structure and properties of a playing card (suit, rank, value).
*   **`Player.java`**: Represents a player in the game, managing their hand of cards.
*   **`TrumpCards.java`**: Manages the deck of cards, including shuffling and dealing.
*   **`BlackJack.java`**: Contains the main game logic for Blackjack, handling rules, scoring, and game flow.
*   **`BlackJackMain.java`**: The application's entry point, responsible for user interaction, command parsing (hit, stand, reset, quit), and orchestrating the game using the `BlackJack` class.

The project follows a standard Java package structure: `jp.gr.java_conf.yuta_yoshinaga.java_trumpcards`.

## Common Development Tasks

### Build

To compile the Java source files:

```sh
javac -d bin src/jp/gr/java_conf/yuta_yoshinaga/java_trumpcards/*.java
```

This command compiles all `.java` files in the `src/jp/gr/java_conf/yuta_yoshinaga/java_trumpcards/` directory and places the compiled `.class` files into the `bin/` directory, preserving the package structure.

### Run

To run the compiled Blackjack application:

```sh
java -cp bin jp.gr.java_conf.yuta_yoshinaga.java_trumpcards.BlackJackMain
```

This command executes the `BlackJackMain` class, which is the entry point of the application, using the `bin/` directory as the classpath.

### Testing

There are no explicit automated test files or testing frameworks configured in this project. Manual testing by running the application and interacting with it via the command line is the primary method of verification.
