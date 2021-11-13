/**
 * Blue Type
 */
public class BlueIcePower extends Power{
    /**
     * For determining and using strength, health, agility
     */
    PowerIngredientFactory ingredientFactory;
    /**
     * one parameter constructor takes ingredient factory type
     * @param ingredientFactory ingredient factory
     */
    public BlueIcePower(PowerIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }
    /**
     * prepare the object according to Red Type
     */
    @Override
    void prepare() {
         this.name = "BlueIcePower";

        strength = ingredientFactory.createStrength();
        agility = ingredientFactory.createAgility();
        health = ingredientFactory.createHealth();
        realHealth = health.health() * 100;

        damage = 100 * Math.pow( ( (strength.strength() * 125) / (agility.agility() * 75) ),1.35 );
    }

}
