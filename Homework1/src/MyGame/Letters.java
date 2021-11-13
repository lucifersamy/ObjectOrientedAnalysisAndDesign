package MyGame;

import javax.swing.*;
import java.awt.*;

/**
 * This class for powerup letters, exactly same monster class, not used because of collision isn't implemented.
 */
public class Letters {
    /**
     * Image for letters
     */
    Image img;
    /**
     * location for letters
     */
    int x,y;

    /**
     * Letters constructor
     * @param whichLetter letter picture path
     * @param startX start x location
     * @param startY start y location
     */
    public Letters(String whichLetter, int startX, int startY){
        x = startX;
        y = startY;
        ImageIcon letter = new ImageIcon(whichLetter);
        img = letter.getImage();
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
     * @return image
     */
    public Image getImg() {
        return img;
    }

    /**
     * moving for letters
     */
    public void move(){
        x = x-2;
    }

    /**
     * for the collision get bounds
     * @return bounds
     */
    public Rectangle getBounds(){
        return new Rectangle(x,y,512,512);
    }
}
