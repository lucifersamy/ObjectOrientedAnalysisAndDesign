package MyGame;

/**
 * this interface for changing jump behavior any run time
 */
public interface JumpBehavior {
    /**
     * jump method for determining the high according to jump types
     * @return high
     */
    public int jump();
}
