import javax.swing.*; 
import java.util.HashMap; 
/**
 * This class represents a Beast and all the actions/events that can happen to it
 * Private instance variables such as currentHealth, attack, defenese, and experiencePoints are added to enhance the functionality of the Fighter 
 * Mutators, Accessors, toString, and game specific methods are added as well
 * Default constructor initializes attributes to a default range of values and parameter constructor is utilized when the Beast evolves to Dragon form 
 */
public class Beast extends Fighter
{
    //Represents the currentHealth, maxHealth, attack, defense, EXP, attackIcon, fighterIcon, food and gold that the Beast currently has
    private int currentHealth, maxHealth, attack, defense, experiencePoints, gold;
    private String fighterType;
    protected ImageIcon attackIcon, fighterIcon;
    private HashMap <String, Integer> inventory;

    /**Default constructor initializes attributes of a default Beast Fighter*/
    public Beast(){
        maxHealth = (int)(Math.random() * 3) + 28;
        currentHealth = maxHealth;
        fighterType = "Beast";
        attack = 8;
        defense = 1;
        experiencePoints = 0;
        gold = 0;
        attackIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\claws.png");
        fighterIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\beast.gif");
        inventory = new HashMap<String, Integer>();
        //Beast starts with one of each food since it's attack power is extremely high
        inventory.put("Chicken", 1);
        inventory.put("Lobster", 1);
        inventory.put("Dragon Egg", 1);
    }

    /**7 parameter constructor used when a Beast evolves to a Dragon*/
    public Beast(int mxHealth, int att, int def, int exp, int g, String fightType, HashMap<String, Integer> inven){
        maxHealth = mxHealth;
        currentHealth = maxHealth;
        attack = att;
        defense = def;
        experiencePoints = exp;
        gold = g;
        fighterType = fightType;
        inventory = inven;
    }

    /**Returns Beast's currentHealth points left*/
    public int getHealth(){
        return currentHealth;
    }

    /**Returns Beast's max health points*/
    public int getMaxHealth(){
        return maxHealth;
    }

    /**If the Beast has the food item given in the parameter, then subtract 1 from the total quantity of that food item and return true, otherwise user does not have that particular food item so return false*/
    public boolean eatFood(String food){
        if(inventory.get(food) > 0){
            inventory.put(food, inventory.get(food) - 1);
            return true;
        }
        return false;
    }

    /**Adds food to Beast's inventory depending on what the user bought*/
    public void addFood(String food, int amount){
        inventory.put(food, inventory.get(food) + amount);
    }

    /**Returns all food that a Beast has in a String to be displayed in the JOptionPane*/
    public String getFoodInventory(){
        String foodInventory = "";
        for(String entry: inventory.keySet())
            foodInventory += entry + ": " + inventory.get(entry) + "\n";
        return foodInventory;  
    }

    /**Returns the whole inventory. Used when Beast evolves to a Dragon*/
    public HashMap<String, Integer> getInventory(){
        return inventory;
    }

    /**Decreases Beast's currentHealth by the damage given*/
    public void loseHealth(int damage){
        currentHealth -= damage;
        if(currentHealth < 0)
            currentHealth = 0;
    }

    /**If Beast's currentHealth is equal to zero (dead) then return true, otherwise false*/
    public boolean isDead(){
        if(currentHealth == 0)
            return true;
        return false;
    }

    /**Returns Beast's defense points randomly generated as a 1 or 2*/
    public int getDefense(){
        return (int)(Math.random() * 2) + defense;
    }

    /**Returns Beast's attack points randomly generated as a 8 or 9*/
    public int getAttack(){
        return (int)(Math.random() * 2) + attack;
    }

    /**Returns Beast's XP*/
    public  int getExperiencePoints(){
        return experiencePoints;
    }

    /**Adds between 8-12 XP every time user kills another Fighter*/
    public void addExperiencePoints(int experience){
        experiencePoints += experience;
    }

    /**Adds a specified amount of health to currentHealth. If it exceeds the maxHealth then it will be reduced back to the maxHealth*/
    public void addHealth(int health){
        currentHealth += health;
        if(currentHealth > maxHealth)
            currentHealth = maxHealth;
    }

    /**Increases max health of a Beast (used to increase user's starting health and if Beast evolves)*/
    public void addMaxHealth(int health){
        //if the Beast has max health already, then increase the max health and make the current health the maximum amount out as well
        if(currentHealth == maxHealth){
            maxHealth += health;
            currentHealth = maxHealth;
        }
        //otherwise just increase the max health 
        else maxHealth += health;
    }

    /**Returns Beast's current stats: Fighter type, currentHealth left, attack, defense, and EXP*/
    public String toString(){
        return "Fighter Type: " + fighterType + "\nHealth Points: " + currentHealth + " / " + maxHealth + "\nAttack Points: " + attack + " - " + (attack + 1) + "\nDefense Points: " + defense + " - " + (defense + 1) + "\nExperience Points (XP): " + experiencePoints + "\nGold: " + gold; 
    }

    /**Returns fighter type as a Beast*/
    public String getFighterType(){
        return fighterType;
    }

    /**Returns Beast's weapon icon to be displayed*/
    public ImageIcon getWeaponIcon(){
        return attackIcon;
    }

    /**Changes Beast's weapon icon if the Beast is an enemy*/
    public void setEnemyWeaponIcon(){
        attackIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\enemyClaws.png");
    }

    /**Changes Beast's Fighter icon to be displayed if the Beast is an enemy*/
    public void setEnemyFighterIcon(){
        fighterIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\enemyMonster.gif");
    }

    /**Returns Beast's Fighter icon to be displayed*/
    public ImageIcon getFighterIcon(){
        return fighterIcon;
    }

    /**Adds gold to user's Beasts' pouch*/
    public void addGold(int g){
        gold += g;
    }

    /**makes sure user's Beast has enough money to purchase the item*/
    public boolean enoughMoney(int g){
        return gold >= g;
    }

    /**Subtracts gold from Beast's pouch depending on what the user bought*/
    public void buyItem(int g){
        gold -= g;
    }

    /**Returns Beast's gold*/
    public int getGold(){
        return gold;
    }

    /**If Beast has more than 80 XP, return true to initiate transformation to Knight, otherwise return false*/
    public boolean evolve(){
        return experiencePoints >= 80;
    }
}
