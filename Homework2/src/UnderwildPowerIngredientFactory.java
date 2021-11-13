/**
 * UnderwildPowerIngredientFactory for creating values suitable for Underwild
 */
public class UnderwildPowerIngredientFactory implements PowerIngredientFactory{
    /**
     *
     * @return strength
     */
    @Override
    public Strength createStrength() {
        return new Strength_x0_8();
    }
    /**
     * UnderWild agility
     * @return agility
     */
    @Override
    public Agility createAgility(){
        return new Agility_x1_6();
    }
    /**
     * Underwild health
     * @return health
     */
    @Override
    public Health createHealth(){
        return new Health_x0_8();
    }

}
