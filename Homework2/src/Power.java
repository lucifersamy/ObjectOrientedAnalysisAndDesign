/**
 * Power class for keeping and manipulating all types(Blue-Red-Green for now)
 */
public abstract class Power {
    /**
     * type name
     */
    String name;

    /**
     * calculated damage with type, style, ingredient(strength-agility health)
     */
    double damage;

    /**
     * strength
     */
    Strength strength;
    /**
     * Agility
     */
    Agility agility;
    /**
     * health
     */
    Health health;

    /**
     * real health for multiplied health
     */
    double realHealth;

    /**
     * preparing base
     */
    abstract void prepare();

    /**
     * setter name
     * @param name name
     */
    void setName(String name) {
        this.name = name;
    }

    /**
     * getter name
     * @return name
     */
    String getName() {
        return name;
    }


}
