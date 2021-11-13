package MyGame;

import javax.swing.*;
import java.awt.*;

/**
 * This class for monsters in the game
 */
public class Monster {
    /**
     * monsters image
     */
    Image img;
    /**
     * monsters location in the screen
     */
    int x,y;

    /**
     * constructor
     * @param whichMonster monster path for image
     * @param startX start location in x axes
     * @param startY start location in y axes
     */
    public Monster(String whichMonster, int startX, int startY){
        x = startX;
        y = startY;
        ImageIcon monster = new ImageIcon(whichMonster);
        img = monster.getImage();
    }

    /**
     * getter x
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * getter y
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * getter image
     * @return img
     */
    public Image getImg() {
        return img;
    }

    /**
     * moves monsters exactly like background so they seem stand
     */
    public void move(){
        x = x-2;
    }

    /**
     * for collision bound
     * @return bounds
     */
    public Rectangle getBounds(){
        return new Rectangle(x,y,128,128);
    }
}
