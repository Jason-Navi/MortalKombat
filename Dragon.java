import javax.swing.*; 
import java.util.HashMap; 
/**
 * Dragon represents an evolved form of a Beast with enhanced stats and different Icons to be displayed
 * 7 parameter constructor initializes the Beast's attributes
 */
public class Dragon extends Beast
{
    /**Default constructor calls super to the Beast class to initialize attributes*/
    public Dragon(int maxHealth, int att, int def, int exp, int g, String fightType, HashMap<String, Integer> inven){
        super(maxHealth, att, def, exp, g, fightType, inven);
        //change the Beast's fighter icon and attack icon to the Dragon's fighter icon and attack icon
        fighterIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\dragon.gif");
        attackIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\fire.png");
    }
}
