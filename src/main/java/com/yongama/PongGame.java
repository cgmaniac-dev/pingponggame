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
    player1Y = HEIGHT/2 - PADDLE_HEIGHT/2;
    player2Y = HEIGHT/2 - PADDLE_HEIGHT/2;
    ballVelX = Math.random() > 0.5 ? BALL_SPEED : -BALL_SPEED;
    ballVelY = (Math.random() > 0.5 ? 1: -1) * (int)(Math.random() * 3 + 2);
  }

  private void setupInput() {
    canvas.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e){
        switch (e.getKeyCode()){
          case KeyEvent.VK_UP -> upPressed = true;
          case KeyEvent.VK_DOWN -> downPressed = true;
          case KeyEvent.VK_W -> wPressed = true;
          case KeyEvent.VK_S -> sPressed = true;
          case KeyEvent.VK_ESCAPE -> stopGame();
        }
      }

      @Override
      public void keyReleased(KeyEvent e){
          switch (e.getKeyCode()){
          case KeyEvent.VK_UP -> upPressed = false;
          case KeyEvent.VK_DOWN -> downPressed = false;
          case KeyEvent.VK_W -> wPressed = false;
          case KeyEvent.VK_S -> sPressed = false;
        }
      }
    });
  }

  @Override
  public void render() {
    Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();

    // Clear screen
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, WIDTH, HEIGHT);

    // Draw Centre line 
    g.setColor(Color.WHITE);
    g.setStroke(new BasicStroke(2));

    for (int i = 0; i < HEIGHT; i+=20){
      g.drawLine(WIDTH/2, i, WIDTH/2, i+10);
    }

    // Draw paddles
    g.fillRect(10, player1Y, PADDLE_WIDTH, HEIGHT);
    g.fillRect(WIDTH - PADDLE_WIDTH - 10, player2Y, PADDLE_WIDTH, HEIGHT);

    // Draw ball 
    g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);

    // Draw scores
    g.setFont(new Font("Arial", Font.BOLD, 36));
    g.drawString(String.valueOf(player1Score), WIDTH/4, 50);
    g.drawString(String.valueOf(player2Score),3 * WIDTH/4, 50);

    g.dispose();
    bufferStrategy.show();
  }

  @Override
  public void update() {
  }

}
