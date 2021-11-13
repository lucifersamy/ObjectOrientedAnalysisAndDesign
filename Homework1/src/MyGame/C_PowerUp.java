package MyGame;

/**
 * C Powerup class for it multiply the last powerup by 10
 */
public class C_PowerUp extends PowerUpDecorator {
    /**
     * PowerUp instance for wrap
     */
    PowerUp powerUp;

    /**
     * One parameter constructor for last powerUp assign this powerup so it can be wrap
     * @param powerUp last powerup for wrapping
     */
    public C_PowerUp(PowerUp powerUp){
        this.powerUp = powerUp;
    }

    /**
     * prints which powerup itself terminal and calculation returns
     * @return new powerup returns
     */
    public int currentPowerUp() {
        System.out.println("C Powerup");
        return powerUp.currentPowerUp() * 10;
    }

}
