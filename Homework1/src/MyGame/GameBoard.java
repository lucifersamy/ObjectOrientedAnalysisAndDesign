package MyGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class for Game board. Background, characters, actions, painting etc
 */
public class GameBoard extends JPanel implements ActionListener {
    /**
     * This is main character player
     */
    UcanTekmePlayer player;
    /**
     * this is for background image
     */
    Image img ;
    /**
     * timer for painting the screen
     */
    Timer time;
    /**
     * Monsters randomly occurs
     */
    Monster[] monsters = new Monster[100] ;

    /**
     * life fixed 3. prints to the game screen
     */
    private int life = 3;

    /**
     * For game finish
     */
    boolean lostGame = false;

    /**
     * for creating game board with player and monster with their pictures and editing time etc
     */
    public GameBoard(){
        player = new UcanTekmePlayer();
        addKeyListener(new ActListener());
        setFocusable(true);
        ImageIcon image = new ImageIcon("src/background.png");
        img = image.getImage();
        time = new Timer(5, this);
        time.start();

        for(int i=0; i<100; i++){
            monsters[i] = new Monster("src/Tai-Lung-icon.png", getRandomNumber(player.getX()+550,50000), 650  );
        }

    }

    /**
     * generating random number
     * @param min min value
     * @param max max value
     * @return generated number
     */
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    /**
     * Action performer method. moves can occur in here anc checkCollision calls here
     * @param e Action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {

       // checkCollision();
        player.move();
            for(int i=0; i<100; i++){
                monsters[i].move();
            }

        repaint();
    }

    /**
     * paints the screen monsters player background and if lost game exits the game
     * @param g Graphic object
     */
    public void paint(Graphics g){
        if(lostGame)
            System.exit(0);
        super.paint(g);

        Graphics2D two_d = (Graphics2D) g;
        two_d.drawImage(img, 1150-player.getNx2(), 0,  null); //background
        //monsters
        two_d.drawString("Life: " + life , 700,50);
        for(int i=0; i<100; i++){
            two_d.drawImage(monsters[i].getImg(), monsters[i].getX(), monsters[i].getY(),null);
        }
        two_d.drawImage(player.getImage(), player.getX(), player.getY(), null); // for main character

    }

    /**
     * Action Listener class for determining which key is pressed our case. KeyTyped is not used
     */
     private class ActListener implements KeyListener {
        /**
         * keyTyped
         * @param e event
         */
         @Override
         public void keyTyped(KeyEvent e) {

         }

        /**
         * Determining is key pressed and which key
         * @param e keyEvent object
         */
         @Override
         public void keyPressed(KeyEvent e) {
             player.KeyPressed(e);
         }

        /**
         * Determining is keyReleased and which key
         * @param e KeyEvent object
         */
         @Override
         public void keyReleased(KeyEvent e) {
             player.KeyReleased(e);
         }
     }

    /**
     * for the checking collision with monsters and main character and main character and powerup letters
     */
    public void checkCollision(){
     /*    Rectangle[] rectanglesMonsters = new Rectangle[100];
         for(int i=0; i<100; ++i){
             rectanglesMonsters[i] = monsters[i].getBounds();
         }

         Rectangle d = player.getBounds();


         Rectangle[] rectanglesLetters = new Rectangle[70];
         for(int i=0; i<30; ++i){
             rectanglesLetters[i] = letters[i].getBounds();
         }


         if(d.intersects(rectanglesMonsters[0])) {
             lostGame = true;
         }
         if(d.intersects(rectanglesMonsters[1])){
             lostGame = true;
         }
*/
       /*  for(int i=0; i<100; ++i){
            if(d.intersect((rectanglesMonsters[i]))
                lostGame = true;
         }

         for(int i=0; i<30; ++i){
            if(d.intersect((rectanglesLetters[i]))
                lostGame = true;
         }
        */


     }
}
