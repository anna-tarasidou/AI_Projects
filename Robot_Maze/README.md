# 🤖 Robot Maze Game

**Course:** MYY602 - Artificial Intelligence 
**Type:** Individual Mini Project  
**Development Platform:** Java, Eclipse

## Project Overview
A terminal-based maze game implemented in **Java**, where the player must navigate from a starting point to a goal through a randomly generated grid-based maze filled with obstacles. The maze can be solved either manually or using classic pathfinding algorithms.

---

## 🎮 Features

- 🧱 **Maze Generation**
  - User-defined size (N x N)
  - Random obstacle placement (`1`) based on user-defined probability (0.0 - 1.0)

- 🚦 **Start and Goal Setup**
  - Manual input of start (`S`) and goal (`G`) positions
  - Validation to prevent placing them on obstacles

- 🧭 **Solving Options**
  1. 📦 **Uniform Cost Search (UCS) Algorithm**
  2. 🧠 **A\* Search Algorithm**
  3. 🔁 **Both UCS and A\***
  4. 👤 **Manual Play Mode**
     - Keyboard controls:
       - Movement: `W`, `A`, `S`, `D`
       - Diagonals: `I`, `O`, `K`, `L`
       - Teleportation with `T` (bottom-left ↔ top-right if allowed)
       - Quit anytime with `q`
     - Visual feedback:
       - Current position → `R`
       - Path so far → `*`
     - Step counter 🧮
     - Instructions appear only once per session
  5. **Game Mode**
	- Levels 1-3
	- Tracking Points

- 🔁 **Replayability**
  - Option to restart with new start/goal in same maze
  - Or generate an entirely new maze
  - Instructions can be reset programmatically (`resetInstructions()`)

- 📊 **Statistics & Feedback**
  - Solved maze with visualized path (`printMazeWithPath(...)`)
  - Total cost of the path
  - Number of nodes expanded
  - Execution time (in milliseconds)

- ☕ **Built in Java (CLI)**

---

## 🧠 Technical Highlights

- ✅ **Optical Effects**  
  - Colored messages using ANSI escape codes (RED, CYAN) for feedback

- ✅ **Obstacle/Boundary Detection**  
  - Prevents invalid moves with clear messages

- ✅ **Teleportation Mechanism**
  - Only possible between opposite corners if unobstructed

- ✅ **Endgame Recognition**
  - Automatically detects when player reaches the goal and displays full path

- ✅ **Dynamic Display System**
  - `Maze` class uses overloaded `printMaze(...)` and `printMazeWithPath(...)` methods for various visualizations

---
## ▶️ How to Compile & Run
To run the project from terminal:

### 🔧 Compile

Compile all `.java` files:

```bash
javac src/maze/*.java src/solver/*.java src/core/*.java
```
### 🚀 Run
Choose one of the following modes:

🧠 Run with Solvers (UCS / A*)
```bash
java -cp bin core.RobotMaze
```
🎮 Run the Maze Game (Manual Player Mode with Levels)

```bash
java -cp bin core.Game
```
## 📂 Project Structure
```bash
src/
├── core/
│ ├── PlayerMode.java // Manual movement logic
│ └── RobotMaze.java // Main interface & algorithm selection
│
├── maze/
│ ├── Cell.java // Grid cell definition
│ ├── Maze.java // Maze generation and utilities
│ └── Node.java // Helper for search algorithms
│
├── solver/
├── AStar.java // A* algorithm implementation
└── UCS.java // Uniform Cost Search implementation
