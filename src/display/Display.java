package display;

import game.Game;
import input.Input;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Display extends JFrame {

    private Canvas canvas;
    private Renderer renderer;

    //created constructor
    public Display(int width, int height, Input input) {
        setTitle("PK 2d game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        this.renderer = new Renderer();

        //creating new window canvas
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setFocusable(false);
        add(canvas);
        addKeyListener(input);
        pack();

        //stop game window flicking
        canvas.createBufferStrategy(3);

        //pop up window on center
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void render(Game game) {
        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();

        //clear our window
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0,canvas.getWidth(),canvas.getHeight());

        //Call render from Display class
        renderer.render(game, graphics);

        //free memory
        graphics.dispose();
        bufferStrategy.show();
    }

}
