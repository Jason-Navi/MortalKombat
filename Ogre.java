import javax.swing.*; 
import java.util.HashMap; 
/**
 * Ogre represents an evolved form of a Goblin with enhanced stats and different Icons to be displayed
 * 7 parameter constructor initializes the Ogre's attributes
 */
public class Ogre extends Goblin
{
    /**Default constructor calls super to the Goblin class to initialize attributes*/
    public Ogre(int maxHealth, int att, int def, int exp, int g, String fightType, HashMap<String, Integer> inven){
        super(maxHealth, att, def, exp, g, fightType, inven);
        //change the Goblin's fighter icon and attack icon to the Ogre's fighter icon and attack icon
        fighterIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\evilTroll.gif");
        attackIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\hammar.png");
    }
}
