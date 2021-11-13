/**
 * Valhalla Power Store
 */
public class ValhallaPowerStore extends PowerStore{
    /**
     * create power according to styles
     * @param item style name
     * @return Valhalla type power
     */
    @Override
    protected Power createPower(String item) {
        Power power = null;
        PowerIngredientFactory ingredientFactory =  new ValhallaPowerIngredientFactory();


        switch (item) {
            case "BlueIcePower" -> {
                power = new BlueIcePower(ingredientFactory);
                power.setName("BlueIcePower");
            }
            case "RedFirePower" -> {
                power = new RedFirePower(ingredientFactory);
                power.setName("RedFirePower");
            }
            case "GreenNaturePower" -> {
                power = new GreenNaturePower(ingredientFactory);
                power.setName("GreenNaturePower");
            }
        }
        return power;
    }
}
