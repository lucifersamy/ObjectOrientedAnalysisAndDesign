package MyGame;

/**
 * This class for the base, it powerup it's 1. it can be wrap according to other powerups.
 */
public class PurePowerUp extends PowerUp {
    /**
     *  base pure powerup. its 1 and it can be wapr
     * @return 1 because it can multiply and wrap other real powerup decorators.
     */
    public int currentPowerUp() {
        return 1;
    }
}
