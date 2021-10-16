package entity;

import controller.Controller;
import core.Position;
import entity.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject {

    private Controller controller;

    public Player(Controller controller) {
        super();
        this.controller = controller;
    }

    @Override
    public void update() {
        int deltaX =0;
        int deltaY=0;

        if(controller.isrequestingUp()) {
            deltaY--;
        }
        if(controller.isrequestingDown()) {
            deltaY++;
        }
        if(controller.isrequestingLeft()) {
            deltaX--;
        }
        if(controller.isrequestingRight()) {
            deltaX++;
        }
        position = new Position(position.getX() +deltaX, position.getY()+deltaY);
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
