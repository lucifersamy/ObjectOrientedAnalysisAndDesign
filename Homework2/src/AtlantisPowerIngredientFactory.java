/**
 * AtlantisPowerIngredientFactory for creating values suitable for Atlantis
 */
public class AtlantisPowerIngredientFactory implements PowerIngredientFactory{
    /**
     * Atlantis strength
     * @return strength
     */
    @Override
    public Strength createStrength(){
        return new Strength_x0_8();
    }
    /**
     * Atlantis agility
     * @return agility
     */
    @Override
    public Agility createAgility(){
        return new Agility_x1_2();
    }
    /**
     * Atlantis health
     * @return health
     */
    @Override
    public Health createHealth(){
        return new Health_x1_2();
    }
}
