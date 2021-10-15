import javax.swing.*;
import java.awt.*;

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

        //pop up window on center
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
