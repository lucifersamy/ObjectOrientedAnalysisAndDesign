/**
 * Power store for styles
 */
public abstract class PowerStore {
    /**
     * create power according to styles
     * @param item style name
     * @return proper type power
     */
    abstract Power createPower(String item);
}
