/**
 * Green type
 */
public class GreenNaturePower extends Power{
    /**
     * For determining and using strength, health, agility
     */
    PowerIngredientFactory ingredientFactory;
    /**
     * one parameter constructor takes ingredient factory type
     * @param ingredientFactory ingredient factory
     */
    public GreenNaturePower(PowerIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }
    /**
     * prepare the object according to Red Type
     */
    @Override
    void prepare() {
        this.name = "GreenNaturePower";
        strength = ingredientFactory.createStrength();

        agility = ingredientFactory.createAgility();
        health = ingredientFactory.createHealth();
        realHealth = health.health() * 125;

        damage = 100 * Math.pow( ( (strength.strength() * 75) / (agility.agility() * 100) ),1.35 );

    }


}