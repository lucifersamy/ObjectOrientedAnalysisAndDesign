package MyGame;
/**
A Powerup class for it multiply the last powerup by 2
 */
public class A_PowerUp extends PowerUpDecorator {
    /**
     * PowerUp instance for wrap
     */
    PowerUp powerUp;

    /**
     * One parameter constructor for last powerUp assign this powerup so it can be wrap
     * @param powerUp last powerup for wrapping
     */
    public A_PowerUp(PowerUp powerUp){
        this.powerUp = powerUp;
    }

    /**
     * prints which powerup itself terminal and calculation returns
     * @return new powerup returns
     */
    public int currentPowerUp() {
        System.out.println("A Powerup");
        return powerUp.currentPowerUp() * 2;
    }

}
