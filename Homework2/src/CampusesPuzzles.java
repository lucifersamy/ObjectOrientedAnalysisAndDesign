import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;


//Rapora->neyi farklı yaptım yeni görseller aşağıdan switch olmuyo da yeni üretiliyor. char meselesi. 3lü match olduğunda ilk kesişimi

/**
 * Main class for the game
 */
public class CampusesPuzzles {
    /**
     * E1, E2 and E3 enemies
     */
    Power[] enemies = new Power[3];
    /**
     * C1, C2 ad C3 enemies
     */
    Power[] chars = new Power[3];

    /**
     * For the getting colors icon of game
     */
    ImageIcon []icon = new ImageIcon[3];

    /**
     * For the colors icons
     */
    URL []url = new URL[3];

    /**
     * For locations
     */
    int x=-1,y=-1;
    /**
     * Fields for detection which stars are match for enemy damage ratio
     */
    int konumj = 0,  konumi = 0;

    /**
     * frame
     */
    JFrame jf = new JFrame();
    /**
     * panel 1
     */
    JPanel jp = new JPanel(new GridLayout(6,9));
    /**
     * panel 2
     */
    JPanel jp1 = new JPanel(new BorderLayout());
    /**
     * buttons for game
     */
    JButton [][] table = new JButton[6][9];
    /**
     * enemy label
     */
    JLabel jb = new JLabel("-----------------------Enemies came here-----------------------");
    /**
     * current information label
     */
    JLabel jb2 = new JLabel("-----------------------Current information came here-----------------------");
    /**
     * No parameter constructor creates board, color items, create enemies vs.
     */
    public CampusesPuzzles()
    {
        Dimension d1 = new Dimension();
        d1.height = 100;
        Dimension d2 = new Dimension();
        d2.height = 100;
        jb.setPreferredSize(d1);
        jb2.setPreferredSize(d2);

        jb.setFont(jb.getFont().deriveFont(25.0f));
        jb2.setFont(jb2.getFont().deriveFont(25.0f));

        url[0] = getClass().getResource("/star-70_blue.png");
        url[1] = getClass().getResource("/star-70_green.png");
        url[2] = getClass().getResource("/star-70_red.png");

        for(int i = 0 ; i < 3; i++) {
            icon[i] = new ImageIcon(url[i]);
        }

        Container cn = jf.getContentPane();
        cn.setLayout(new BorderLayout());
        cn.add(jp1, BorderLayout.EAST);
        cn.add(jb,BorderLayout.NORTH);
        cn.add(jb2,BorderLayout.SOUTH);
        cn.add(jp);

        jf.setTitle("Campuses and Puzzles");
        jf.setLocation(150,0);
        jf.setSize(1100,800);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        for(int i=0; i < 6; i++) {
            for (int j = 0; j < 9; j++) {
                int d = rand();
                table[i][j] = new JButton();
                table[i][j].addActionListener(new Action());
                table[i][j].setActionCommand(String.valueOf(d));
                table[i][j].setIcon(new ImageIcon(url[d]));
                table[i][j].setBorderPainted(true);
                table[i][j].setOpaque(true);
                table[i][j].setBackground(Color.pink);

                jp.add(table[i][j]);
            }
        }

        jf.setVisible(true);
        createAsset(enemies);
        createAsset(chars);

        if(charsDead()){
            gameOver();
        }

        if(enemiesDead()){
            createAsset(enemies);
        }
        check();

    }

    /**
     * after all chars die ask the player what she/he wants to do
     */
    public void gameOver(){
        int check = JOptionPane.showConfirmDialog(null,   "All 3 of your characters are dead. Do you want to Play again?");

        if(check == JOptionPane.YES_OPTION)
        {
            new CampusesPuzzles();
            jf.dispose();
        }
        else if(check == JOptionPane.NO_OPTION)
            System.exit(0);
        if(check == JOptionPane.CANCEL_OPTION)
            System.exit(0);
    }

    /**
     * controls the end of the game by controlling all the characters
     * @return true if all chars die
     */
    public boolean charsDead(){
        return chars[0].realHealth < 0 && chars[1].realHealth < 0 && chars[2].realHealth < 0;
    }

    /**
     * controls all enemies died
     * @return true if all die
     */
    public boolean enemiesDead(){
        if(enemies[0].realHealth < 0 && enemies[1].realHealth < 0 && enemies[2].realHealth < 0) {
            jb2.setText("All enemies died and were resurrected again.");
            return true;
        }
        else
            return false;
    }
    /**
     * This method is for creating random characters and/or enemies according to types and styles
     * @param assets enemy or character array
     */
    public void createAsset(Power[] assets){
        int type, style;

        for(int i=0; i<3; ++i) {
            type = rand();
            style = rand();

            if (type == 0 && style == 0)
                assets[i] = new BlueIcePower(new AtlantisPowerIngredientFactory());
            else if(type == 0 && style == 1)
                assets[i] = new BlueIcePower(new ValhallaPowerIngredientFactory());
            else if(type == 0 && style == 2)
                assets[i] = new BlueIcePower(new UnderwildPowerIngredientFactory());

            else if (type == 1 && style == 0)
                assets[i] = new RedFirePower(new AtlantisPowerIngredientFactory());
            else if(type == 1 && style == 1)
                assets[i] = new RedFirePower(new ValhallaPowerIngredientFactory());
            else if(type == 1 && style == 2)
                assets[i] = new RedFirePower(new UnderwildPowerIngredientFactory());

            else if (type == 2 && style == 0)
                assets[i] = new GreenNaturePower(new AtlantisPowerIngredientFactory());
            else if(type == 2 && style == 1)
                assets[i] = new GreenNaturePower(new ValhallaPowerIngredientFactory());
            else if(type == 2 && style == 2)
                assets[i] = new GreenNaturePower(new UnderwildPowerIngredientFactory());

            assets[i].prepare();
        }
    }

    /**
     * Action listener for catching actions
     */
    class Action implements ActionListener{
        /**
         * Action performed class
         * @param e event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if(charsDead()){
                gameOver();
            }
            if(enemiesDead()){
                createAsset(enemies);
            }


            for(int i=0; i < 6; i++)
                for(int j=0; j < 9; j++ ) {
                    if(e.getSource() == table[i][j]) {
                        if (x == -1 && y == -1) {
                            x = i;
                            y = j;

                        }
                        else {
                            if ((i == x + 1 && j == y) || (i == x - 1 && j == y) || (i == x  && j == y - 1) || (i == x && j == y + 1)) {
                                table[i][j].setBackground(table[x][y].getBackground());
                                table[x][y].setBackground(table[i][j].getBackground());
                                table[i][j].setActionCommand(table[x][y].getActionCommand());
                                table[x][y].setActionCommand(table[i][j].getActionCommand());
                                table[i][j].setIcon(new ImageIcon(url[Integer.parseInt(table[x][y].getActionCommand())]));
                                table[x][y].setIcon(new ImageIcon(url[Integer.parseInt(table[i][j].getActionCommand())]));
                                x=-1; y=-1;
                                check();
                            }
                            else {
                                x = i;
                                y = j;
                            }
                        }
                        jb.setText("Enemies: " + enemies[0].name + ":" + enemies[0].realHealth + "  " + enemies[1].name + ":" + enemies[1].realHealth + "   " + enemies[2].name + ":" + enemies[2].realHealth);
                    }

                }

        }
    }

    /**
     * Checking is there success in puzzle
     */
    public void check(){

        for(int i = 0; i < 6; i++)
        {
            for(int j = 0;j< 7; j++)
            {
                if(table[i][j].getActionCommand().matches(table[i][j + 1].getActionCommand()) && table[i][j].getActionCommand().matches(table[i][j + 2].getActionCommand())){

                    if(j+ 3 < 9 && (table[i][j].getActionCommand().matches(table[i][j + 3].getActionCommand())))
                    {
                        int d;

                        if(j + 4 < 9 && (table[i][j].getActionCommand().matches(table[i][j + 4].getActionCommand())))
                        {
                            d = rand();
                            table[i][j+4].setActionCommand(String.valueOf(d));
                            table[i][j+4].setIcon(icon[d]);
                        }

                        d = rand();
                        table[i][j+3].setActionCommand(String.valueOf(d));
                        table[i][j+3].setIcon(icon[d]);
                    }
                    //yatay
                    int d = rand();
                    table[i][j].setActionCommand(String.valueOf(d));
                    table[i][j].setIcon(icon[d]);

                    d = rand();
                    table[i][j+1].setActionCommand(String.valueOf(d));
                    table[i][j+1].setIcon(icon[d]);


                    d = rand();
                    table[i][j+2].setActionCommand(String.valueOf(d));
                    table[i][j+2].setIcon(icon[d]);

                    konumj = j;
                    konumi = i;
                    check();
                    jb.setText("Enemies: " + enemies[0].name + ":" + enemies[0].realHealth + "  " + enemies[1].name + ":" + enemies[1].realHealth + "   " + enemies[2].name + ":" + enemies[2].realHealth);

                }
            }
        }


        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 4; i++) {
                if (table[i][j].getActionCommand().matches(table[i + 1][j].getActionCommand()) && table[i][j].getActionCommand().matches(table[i + 2][j].getActionCommand())) {
                    int d;

                    if (i + 3 < 6 && (table[i][j].getActionCommand().matches(table[i + 3][j].getActionCommand()))) {
                        if (i + 4 < 6 && (table[i][j].getActionCommand().matches(table[i + 4][j].getActionCommand()))) {
                            d = rand();
                            table[i + 4][j].setActionCommand(String.valueOf(d));
                            table[i + 4][j].setIcon(icon[d]);
                        }

                        d = rand();
                        table[i + 3][j].setActionCommand(String.valueOf(d));
                        table[i + 3][j].setIcon(icon[d]);
                    }
                    //dikey
                    d = rand();
                    table[i][j].setActionCommand(String.valueOf(d));
                    table[i][j].setIcon(icon[d]);

                    d = rand();
                    table[i + 1][j].setActionCommand(String.valueOf(d));
                    table[i + 1][j].setIcon(icon[d]);

                    d = rand();
                    table[i + 2][j].setActionCommand(String.valueOf(d));
                    table[i + 2][j].setIcon(icon[d]);

                    konumj = j;
                    konumi = i;

                    check();
                    jb.setText("Enemies: " + enemies[0].name + ":" + enemies[0].realHealth + "  " + enemies[1].name + ":" + enemies[1].realHealth + "   " + enemies[2].name + ":" + enemies[2].realHealth);

                }

            }

        }


        kill(enemies);

    }

    /**
     * killing enemy/char each other
     * @param assets enemy or char list (Es and Cs)
     */
    public void kill(Power[] assets){
        int color = rand();
        //0 red
        //1 blue
        //2 green
        //System.out.println(table[konumi][konumj].getIcon());

        double damageOran;

        if(konumj<3){
            damageOran = calculateDamageRatio(assets[0], color);
            assets[0].realHealth = assets[0].realHealth - (damageOran * assets[0].damage ) ;
            jb2.setText("First place " +assets[0].getName() + " is damaged: " + (damageOran * assets[0].damage ));
        }
        else if(konumj<6){
            damageOran = calculateDamageRatio(assets[1], color);
            assets[1].realHealth -= (damageOran * assets[1].damage);
            jb2.setText("Second place " +assets[1].getName() + " is damaged: " + (damageOran * assets[1].damage));
        }
        else{
            damageOran = calculateDamageRatio(assets[2], color);
            assets[2].realHealth -= (damageOran * assets[2].damage);
            jb2.setText("Third place " +assets[2].getName() + " is damaged: " + (damageOran * assets[2].damage));
        }
        jb.setText("Enemies: " + enemies[0].name + ":" + enemies[0].realHealth + "  " + enemies[1].name + ":" + enemies[1].realHealth + "   " + enemies[2].name + ":" + enemies[2].realHealth);
    }

    /**
     * calculates tha damage ratio fot enemy or character (according to hw pdf table 1)
     * @param asset enemy or character for color
     * @param color of
     * @return calculated ratio
     */
    public double calculateDamageRatio(Power asset, int color){
        //color 0 yani color Red
        if(color == 0 && asset.getName().equals("RedFirePower")){
            return 1;
        }
        else if(color == 0 && asset.getName().equals("GreenNaturePower")){
            return 2;
        }
        else if(color == 0 && asset.getName().equals("BlueIcePower")){
            return 0.5;
        }

        //color 1 yani color blue
        else if(color == 1 && asset.getName().equals("RedFirePower")){
            return 2;
        }
        else if(color == 1 && asset.getName().equals("GreenNaturePower")){
            return 0.5;
        }
        else if(color == 1 && asset.getName().equals("BlueIcePower")){
            return 1;
        }

        //color 2 yani color green
        else if(color == 2 && asset.getName().equals("RedFirePower")){
            return 0.5;
        }
        else if(color == 2 && asset.getName().equals("GreenNaturePower")){
            return 1;
        }
        else if(color == 2 && asset.getName().equals("BlueIcePower")){
            return 2;
        }
        return 1;
    }


    /**
     * random function. colors, types and styles all have three possibilities. used for all of these
     * @return created random number 0-3
     */
    public int rand()
    {
        Random r = new Random();
        return r.nextInt(3);

    }

    /**
     * main function
     * @param arg command line arg
     */
    public static void main(String [] arg)
    {
        new CampusesPuzzles();
    }
}