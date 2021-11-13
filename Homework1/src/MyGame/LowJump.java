package MyGame;

/**
 * This class is for low jump behavior
 */
public class LowJump implements JumpBehavior{
    /**
     * implements the jump behavior according to low height and prints the jump type to the terminal
     * @return height
     */
    @Override
    public int jump() {
        System.out.println("Low Jump!");
        return 400;
    }
}
