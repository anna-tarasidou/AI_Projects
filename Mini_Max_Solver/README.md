# 🎮 Mini-Max Solver Game

**Course:** MYY602 - Artificial Intelligence 
**Type:** Individual Mini Project  
**Development Platform:** Java, Eclipse

## Project Overview
A terminal-based grid game implemented in **Java**, where a human player competes against an AI powered by the **Minimax algorithm**. The game is played on a 4x3 grid, and the objective is to form a specific 3-character sequence horizontally, vertically, or diagonally.

## 🌟 Features

### **Game Mechanics**
- **Grid Size:** Custom 4x3 board setup.
- **Winning Conditions:** 
  - **MAX (AI - 'X'):** Wins by forming the sequence `XOX`.
  - **MIN (Player - 'O'):** Wins by forming the sequence `OXO`.
- **Random Initialization:** The game starts with one 'X' and one 'O' placed randomly on the board. The initial placement guarantees they are not adjacent to each other.

### **AI Opponent (Minimax)**
- The AI ('X') evaluates all possible future moves using the classic **Minimax Algorithm** to choose the optimal path.
- **Smart Move Selection:** 
  1. Prioritizes immediate winning moves.
  2. Blocks the player's immediate winning moves.
  3. Uses full depth minimax evaluation for the best strategic play.

### **Interactive Terminal UI**
- Clear ASCII representation of the 4x3 grid.
- Step-by-step interactive CLI for the human player to input row and column choices.
- Real-time feedback for invalid moves or occupied cells.

## 🚀 How to Compile & Run

To run the project from your terminal, navigate to the `Mini_Max_Solver` directory and execute the following commands:

### Compile
Compile all `.java` files inside the `src/core` directory:
```bash
javac src/core/*.java
```

### Run
Start the game:
```bash
java -cp bin core.MiniMaxJava
```

## 📂 Project Structure

```bash
src/
└── core/
    ├── Cell.java          # Represents a single cell (row, column, value)
    ├── Grid.java          # Manages the 4x3 board state, printing, and win validation
    ├── MiniMaxJava.java   # Main application entry point and game loop
    └── MiniMaxSolver.java # AI logic implementing the Minimax algorithm
```

## 🧠 Technical Highlights
- **Minimax with Priority Checks:** The AI optimizes computation time by checking for immediate wins and blocks before diving into the recursive Minimax tree.
- **Dynamic Sequence Validation:** The `Grid` class scans rows, columns, and diagonals dynamically to detect "XOX" and "OXO" patterns.
- **Robust Input Handling:** Prevents users from overriding existing cells or playing out of bounds.