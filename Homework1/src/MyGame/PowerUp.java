package MyGame;

/**
 * Powerup class for calculating core multiplier according to A,B,C and for changing jump style
 * this class and its relations implemented according to Decorator Design Pattern
 */
public abstract class PowerUp {
    /**
     * abstract currentPowerUp method so each powerup can be implement it
     * @return powerup
     */
    public abstract int currentPowerUp();
}
