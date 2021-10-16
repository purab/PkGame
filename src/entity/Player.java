package entity;

import controller.Controller;
import core.Position;
import entity.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends MovingEntity {



    public Player(Controller controller) {
        super(controller);

    }

    @Override
    public void update() {
        super.update();
        //position = new Position(position.getX() +deltaX, position.getY()+deltaY);
    }

    @Override
    public Image getSprite() {
        //create image here
        BufferedImage image = new BufferedImage(size.getWidth(),size.getHeight(),BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();

        //set color to image
        graphics.setColor(Color.BLUE);
        graphics.fillRect(0,0,size.getWidth(),size.getHeight());

        graphics.dispose();
        return image;
    }
}
