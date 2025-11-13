package com.yongama;

public class GameLoop implements Runnable {
    private static final int TARGET_UPS = 60;
    private static final double TIME_PER_UPDATE = 1000000000.0 / TARGET_UPS;
    
    private Thread gameThread;
    private volatile boolean running = false;
    
    private final GameLogic gameLogic;
    private final Display display;
    
    public GameLoop(GameLogic gameLogic, Display display) {
        this.gameLogic = gameLogic;
        this.display = display;
    }
    
    public synchronized void start() {
        if (running) return;
        
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public synchronized void stop() {
        if (!running) return;
        
        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    @Override
    public void run() {
        long previousTime = System.nanoTime();
        double delta = 0;
        
        int frames = 0;
        int updates = 0;
        long timer = System.currentTimeMillis();
        
        while (running) {
            long currentTime = System.nanoTime();
            delta += (currentTime - previousTime) / TIME_PER_UPDATE;
            previousTime = currentTime;
            
            while (delta >= 1) {
                update();
                updates++;
                delta--;
            }
            
            render();
            frames++;
            
            if (System.currentTimeMillis() - timer >= 1000) {
                timer += 1000;
                System.out.printf("UPS: %d, FPS: %d%n", updates, frames);
                updates = 0;
                frames = 0;
            }
        }
    }
    
    private void update() {
        gameLogic.update();
    }
    
    private void render() {
        display.render();
    }
    
    public interface GameLogic {
        void update();
    }
    
    public interface Display {
        void render();
    }
}