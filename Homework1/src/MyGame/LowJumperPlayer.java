package MyGame;
/**
 * This class for if someone wants to create UcanTekme player as a LowJumpPlayer
 */
public class LowJumperPlayer extends UcanTekmePlayer{
    /**
     * It assigns jump behavior as low
     */
    public LowJumperPlayer(){
        jumpBehavior = new LowJump();
    }
}
