package MyGame;

/**
 * D Powerup class for the changing current high style low to high or high to low
 */
public class D_PowerUp extends PowerUpDecorator {
    /**
     * PowerUp instance for wrap
     */
    PowerUp powerUp;
    /**
     * for changing mode
     */
    UcanTekmePlayer p;


    /**
     * prints which powerup itself terminal and calculation returns
     * @return new powerup returns
     */
    public int currentPowerUp() {
        System.out.println("D Powerup");
        //changeJumpBehaviour();
       return powerUp.currentPowerUp();

    }

    /**
     * for changing jump behavior
     */
    public void changeJumpBehaviour(){
        if(p.jumpBehavior instanceof LowJump){
            p.setJumpBehavior(new HighJump());
        }
        else if(p.jumpBehavior instanceof HighJump){
            p.setJumpBehavior(new LowJump());
        }
    }

}
