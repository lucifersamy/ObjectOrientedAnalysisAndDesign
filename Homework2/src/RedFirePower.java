/**
 * Red Type
 */
public class RedFirePower extends Power{
    /**
     * For determining and using strength, health, agility
     */
    PowerIngredientFactory ingredientFactory;

    /**
     * one parameter constructor takes ingredient factory type
     * @param ingredientFactory ingredient factory
     */
    public RedFirePower(PowerIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    /**
     * prepare the object according to Red Type
     */
    @Override
    void prepare() {
        this.name = "RedFirePower";
        strength = ingredientFactory.createStrength();

        agility = ingredientFactory.createAgility();
        health = ingredientFactory.createHealth();
        realHealth = health.health() * 75;

        damage = 100 * Math.pow( ( (strength.strength() * 100) / (agility.agility() * 125) ),1.35 );


    }

}