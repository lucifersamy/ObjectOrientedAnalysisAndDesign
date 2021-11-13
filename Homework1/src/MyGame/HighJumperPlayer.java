package MyGame;

/**
 * This class for if someone wants to create UcanTekme player as a HighJumpPlayer
 */
public class HighJumperPlayer extends UcanTekmePlayer{
    /**
     * It assigns jump behavior as high
     */
    public HighJumperPlayer(){
        jumpBehavior = new HighJump();
    }
}
