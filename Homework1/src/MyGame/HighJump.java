package MyGame;
/**
 * This class is for high jump behavior
 */
public class HighJump implements JumpBehavior{
    /**
     * implements the jump behavior according to high height and prints the jump type to the terminal
     * @return high
     */
    @Override
    public int jump() {
        System.out.println("High Jump!");
        return 200;
    }
}
