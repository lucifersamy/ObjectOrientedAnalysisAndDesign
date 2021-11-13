/**
 * Power ingredient factory interface for proper strength, agility and health creation
 */
public interface PowerIngredientFactory {
    /**
     * creating strength properly
     * @return strength
     */
    public Strength createStrength();

    /**
     * creating agility properly
     * @return agility
     */
    public Agility createAgility();

    /**
     * creating health properly
     * @return health
     */
    public Health createHealth();
}
