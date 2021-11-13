package MyGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * This class for main character Ucan Tekme Game
 */
public class UcanTekmePlayer{

    /**
     * for coordinate and moving how
     */
    private int x,  y,  nx, nx2, nx3;
    /**
     * for main ucan tekme character
     */
    Image character;
    /**
     * score
     */
    public static int score = 0;
    /**
     * Powerup creation
     */
    public PowerUp power = new PurePowerUp();
    /**
     * JumpBehavior creation
     */
    public JumpBehavior jumpBehavior = new LowJump();

    /**
     * Constructor for player init photo location etc
     */
    public UcanTekmePlayer(){

        ImageIcon image = new ImageIcon("src/Po-icon.png");
        character = image.getImage();

        x = 30;
        nx2 = 1190;
        nx = 0;
        y = 550;
        nx3 = 0;

    }

    /**
     * for performing jump, jump method calls according the current jumpBehavior
     */
    public void performJump(){
        y = jumpBehavior.jump();
    }

    /**
     * setting jump behavior. this method for changing jump behavior dynamically
     * @param jb new JumpBehavior type
     */
    public void setJumpBehavior(JumpBehavior jb) {
        jumpBehavior = jb;

    }


    /**
     * x getter
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * nx2 getter
     * @return nx2
     */
    public int getNx2() {
        return nx2;
    }

    /**
     * y getter
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * image getter
     * @return character image
     */
    public Image getImage(){
        return character;
    }

    /**
     * move with changing locations
     */
    public void move(){
        nx2 = nx2 + 1;
        nx = nx + 2;
        nx3++;
    }

    /**
     * For pressed keys. this method calls from GameBoard. Jump for space, D for forwarding right, L for D powerup,
     * A,B,C for powerups, and E for exit
     * @param e KeyEvent object
     */
    public void KeyPressed(KeyEvent e){
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_SPACE) {
            performJump();
            score = score + (5 * power.currentPowerUp());
            System.out.println("Current score: " +score);
        }
        if(key == KeyEvent.VK_D){
            x = x+60;
        }


        if(key == KeyEvent.VK_L){

            if(jumpBehavior instanceof LowJump){
                setJumpBehavior(new HighJump());
            }
            else if(jumpBehavior instanceof HighJump){
                setJumpBehavior(new LowJump());
            }
          //  power = new D_PowerUp(power);
        }

        if(key == KeyEvent.VK_A){
            power = new A_PowerUp(power);
        }
        if(key == KeyEvent.VK_B){
            power = new B_PowerUp(power);
        }
        if(key == KeyEvent.VK_C){
            power = new C_PowerUp(power);
        }


        if(key == KeyEvent.VK_E){
            System.exit(0);
        }



    }

    /**
     * For released keys. When space release character turns his/her old location. to floor
     * @param e Key Event object
     */
    public void KeyReleased(KeyEvent e){
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_SPACE) {
            y = 550;
        }

    }

    /**
     * get bounds method for the collision of main characer
     * @return bounds of character
     */
    public Rectangle getBounds(){
        return new Rectangle(nx3+x ,y,256,256);
    }
}
