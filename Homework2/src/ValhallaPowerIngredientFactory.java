/**
 * ValhallaPowerIngredientFactory for creating values suitable for Valhalla
 */
public class ValhallaPowerIngredientFactory implements PowerIngredientFactory{
    /**
     * Valhalla strength
     * @return strength
     */
    @Override
    public Strength createStrength() {
        return new Strength_x1_3();
    }
    /**
     * Valhalla agility
     * @return agility
     */
    @Override
    public Agility createAgility(){
        return new Agility_x0_4();
    }
    /**
     * Valhalla health
     * @return health
     */
    @Override
    public Health createHealth(){
        return new Health_x1_3();
    }

}
