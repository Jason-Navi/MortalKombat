import javax.swing.*; 
import java.util.HashMap; 
/**
 * Knight represents an evolved form of a Human with enhanced stats and different Icons to be displayed
 * 7 parameter constructor initializes the Knight's attributes 
 */
public class Knight extends Human
{
    /**Default constructor calls super to the Human class to initialize attributes*/
    public Knight(int maxHealth, int att, int def, int exp, int g, String fightType, HashMap<String, Integer> inven){
        super(maxHealth, att, def, exp, g, fightType, inven);
        //change the Human's fighter icon and attack icon to the Knight's fighter icon and attack icon
        fighterIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\Knight.gif");
        attackIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\knightSword.png");
    }
}
