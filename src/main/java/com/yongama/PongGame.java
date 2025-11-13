package com.yongama;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;

public class PongGame implements GameLoop.GameLogic, GameLoop.Display {
  private static final int WIDTH = 800;
  private static final int HEIGHT = 600;
  private static final int PADDLE_WIDTH = 15;
  private static final int PADDLE_HEIGHT = 100;
  private static final int BALL_SIZE = 20;
  private static final int BALL_SPEED = 5;

  private Frame frame;
  private Canvas canvas;
  private BufferStrategy bufferStrategy;

  private int player1Y, player2Y;
  private int ballX, ballY;
  private int ballVelX, ballVelY;
  private int player1Score, player2Score;
  private boolean upPressed, downPressed, wPressed, sPressed;

  public PongGame() {
    initialiseWindow();
    initialiseGame();
    setupInput();
  }

  private void initialiseWindow() {
    frame = new Frame("Ping Pong Game");
    frame.setSize(WIDTH, HEIGHT);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);

    canvas = new Canvas();
    canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    canvas.setFocusable(true);

    frame.add(canvas);
    frame.pack();
    frame.setVisible(true);

    canvas.createBufferStrategy(2);
    bufferStrategy = canvas.getBufferStrategy();

    frame.addWindowListener(new WindowAdapter() {

      @Override
      public void windowClosing(WindowEvent e) {
        stopGame();
      }

    });

  }

  private void stopGame() {
    System.exit(0);
  }

  public static void main(String[] args){
    PongGame pongGame = new PongGame();
    GameLoop gameLoop = new GameLoop(pongGame, pongGame);
    gameLoop.start();
  }

  private void initialiseGame() {
  }

  private void setupInput() {
  }

  @Override
  public void render() {
  }

  @Override
  public void update() {
  }

}
