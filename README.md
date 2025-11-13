# 🏓 Ping Pong Game

A classic two-player Ping Pong game built with Java AWT and Canvas, featuring a robust game loop and comprehensive testing.

![Java](https://img.shields.io/badge/Java-17%2B-blue)
![AWT](https://img.shields.io/badge/GUI-AWT-orange)
![Tests](https://img.shields.io/badge/Tests-JUnit5-green)

## 🎮 Features

- **Smooth 60 FPS gameplay** with fixed-time step game loop
- **Two-player local multiplayer** with intuitive controls
- **Realistic ball physics** with angle changes based on paddle hit position
- **Score tracking** with visual display
- **Collision detection** for walls and paddles
- **Performance monitoring** with UPS/FPS display in console
- **Comprehensive unit tests** covering game mechanics

## 🚀 How to Run

### Prerequisites
- Java 17 or higher
- JUnit 5 (for running tests)

### Running the Game

1. **Clone or download the project files**
2. **Compile the game:**
   ```bash
   javac *.java
   ```
3. **Run the game:**
   ```bash
   java PongGame
   ```

### Running Tests

1. **Ensure JUnit 5 is available in your classpath**
2. **Compile test files:**
   ```bash
   javac -cp .:junit-platform-console-standalone-1.8.2.jar *.java
   ```
3. **Run tests:**
   ```bash
   java -cp .:junit-platform-console-standalone-1.8.2.jar org.junit.platform.console.ConsoleLauncher --scan-class-path
   ```

## 🎯 Controls

| Player | Move Up | Move Down |
|--------|---------|-----------|
| **Player 1** (Left) | `W` Key | `S` Key |
| **Player 2** (Right) | `↑` Arrow | `↓` Arrow |

- **ESC** - Exit the game

## 🏗️ Project Structure

```
PingPongGame/
├── GameLoop.java          # Core game loop implementation
├── PongGame.java          # Main game class with AWT rendering
├── PongGameTest.java      # Unit tests for game logic
└── GameLoopTest.java      # Tests for game loop components
```

### Key Components

1. **GameLoop** - Fixed-time step game loop ensuring consistent performance
2. **PongGame** - Main game class handling rendering, input, and game state
3. **Game Logic** - Ball physics, collision detection, and scoring system
4. **Rendering** - AWT-based graphics with double buffering

## 🧪 Testing

The project includes comprehensive unit tests covering:

- **Ball movement and collision**
- **Paddle movement and boundaries**
- **Scoring system**
- **Game loop functionality**
- **Edge cases and boundary conditions**

Run the tests to ensure all game mechanics work correctly.

## 🎨 Game Mechanics

- **Ball Physics**: The ball bounces off paddles with angle variations based on hit position
- **Scoring**: Points are awarded when the ball passes a player's paddle
- **Paddle Limits**: Paddles cannot move beyond the screen boundaries
- **Velocity Limits**: Ball speed is capped to maintain playable gameplay

## 🔧 Technical Details

- **Target Performance**: 60 UPS (Updates Per Second) with variable FPS
- **Rendering**: Java AWT with Canvas and BufferStrategy for smooth graphics
- **Input Handling**: KeyListener for responsive controls
- **Collision Detection**: Axis-aligned bounding box (AABB) collision

## 📊 Performance

The game loop provides real-time performance monitoring in the console:
```
UPS: 60, FPS: 120
```
- **UPS**: Updates per second (fixed at 60)
- **FPS**: Frames per second (varies based on system performance)

## 🐛 Known Issues

- Game window may take focus on startup
- Ball velocity can become very fast after multiple paddle hits
- No menu system or pause functionality

## 🔮 Future Enhancements

- [ ] Add AI opponent for single-player mode
- [ ] Implement power-ups and special abilities
- [ ] Add sound effects and background music
- [ ] Create levels with increasing difficulty
- [ ] Add pause menu and game states
- [ ] Implement network multiplayer

## 👥 Contributing

Feel free to fork this project and submit pull requests for any improvements!

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

**Enjoy playing!** 🏓

For any issues or questions, please check the code comments or create an issue in the project repository.
