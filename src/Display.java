import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Display extends JFrame {

    private Canvas canvas;

    //created constructor
    public Display(int width, int height) {
        setTitle("PK 2d game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        //creating new window canvas
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setFocusable(false);
        add(canvas);
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

        //create rectangle here
        Rectangle rectangle = game.getRectangle();
        graphics.setColor(Color.BLUE);
        graphics.fillRect(
                (int) rectangle.getX(),
                (int) rectangle.getY(),
                (int) rectangle.getWidth(),
                (int) rectangle.getHeight()
        );

        //free memory
        graphics.dispose();
        bufferStrategy.show();
    }

}
