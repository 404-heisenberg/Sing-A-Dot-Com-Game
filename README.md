# Sink a Dot Com Game

Welcome to Sink a Dot Com, a game inspired by the classic Battleship, as featured in the HeadFirstJava book.
Objective

Your goal is to sink all of the computer's Dot Coms using the fewest number of guesses. Your performance will be rated based on how effectively you play the game.

## Setup
Upon launching the game, the computer will randomly place three Dot Coms on a virtual 7x7 grid. The grid is labeled as follows:

Rows: A, B, C, D, E, F, G
Columns: 0, 1, 2, 3, 4, 5, 6

After placing the Dot Coms, the game will prompt you to make your first guess.

## How to Play

**Starting the Game:** The game runs in the command line interface (CLI).

**Making a Guess:** You will be asked to enter a guess, which corresponds to a cell on the grid (e.g., “A3”, “C5”).

**Receiving Feedback:** After each guess, you will receive feedback in the command line:
- “hit” - You have successfully hit a Dot Com.
- “miss” - The guessed cell does not contain a Dot Com.
- “You sunk Pets.com” - You have sunk a Dot Com, with the name of the Dot Com displayed.

**Winning the Game:** The game ends when you have successfully sunk all three Dot Coms. Your final rating will be displayed based on your performance.

## Notes

Ensure that your guesses are within the grid boundaries (e.g., “A0” through “G6”).
