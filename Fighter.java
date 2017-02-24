import javax.swing.*; 
import java.util.HashMap;
/**
 * Fighter is an abstract class that represents the basic methods of all fighters from a human to a goblin or to an animal
 * Extended by Goblin, Animal, and Human classes that will fill in these methods
 */
public abstract class Fighter
{
    /**Returns Fighter's health left */
    public abstract int getHealth();

    /**Returns Fighter's max health points*/
    public abstract int getMaxHealth();

    /**Returns Fighter's defense points*/
    public abstract int getDefense();

    /**Returns Fighter's attack points*/
    public abstract int getAttack();

    /**Adds XP every time user kills another Fighter*/
    public abstract int getExperiencePoints();

    /**Adds between 8-12 XP every time user kills another Fighter*/
    public abstract void addExperiencePoints(int experience);

    /**Decreases Fighter's currentHealth by the damage given */
    public abstract void loseHealth(int damage);

    /**Returns true if dead, otherwise false*/
    public abstract boolean isDead();

    /**Increases Fighter's health by a certain amount*/
    public abstract void addHealth(int health);

    /**Increases max health of a Fighter (used to increase user's starting health and if Fighter evolves)*/
    public abstract void addMaxHealth(int health);

    /**If the Fighter has the food item given in the parameter, then subtract 1 from the total quantity of that food item and return true, otherwise user does not have that particular food item so return false*/
    public abstract boolean eatFood(String food);

    /**Returns all food that a Fighter has in a String to be displayed in the JOptionPane*/
    public abstract String getFoodInventory();
    
    /**Adds food to Fighter's inventory depending on what the user bought*/
    public abstract void addFood(String food, int amount);
    
    /**Returns the whole inventory. Used when Fighter evolves to next stage*/
    public abstract HashMap<String, Integer> getInventory();

    /**Returns Fighter's fighting information(health, attack, defense, and type of Fighter)*/
    public abstract String toString();

    /**Returns Fighter's player type (Human, Goblin, etc.)*/
    public abstract String getFighterType();

    /**Returns Fighter's weapon icon to be displayed*/
    public abstract ImageIcon getWeaponIcon();

    /**Returns Fighter's player icon to be displayed*/
    public abstract ImageIcon getFighterIcon();
    
    /**Changes a Fighter's weapon icon if the Fighter is an enemy*/
    public abstract void setEnemyWeaponIcon();

    /**Changes a Fighter's player icon if the Fighter is an enemy*/
    public abstract void setEnemyFighterIcon();
    
    /**Adds gold to Fighter's pouch*/
    public abstract void addGold(int g);
    
    /**Subtracts gold from Fighter's pouch depending on what they bought*/
    public abstract void buyItem(int g);
    
    /**Makes sure Fighter has enough gold to purchase food*/
    public abstract boolean enoughMoney(int g);
    
    /**Returns gold from Fighter's pouch*/
    public abstract int getGold();
    
    /**If Fighter has more than 100 XP, return true to initiate transformation to evolved form, otherwise return false*/
    public abstract boolean evolve();
}

