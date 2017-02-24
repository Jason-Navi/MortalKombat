import javax.swing.*; 
import java.util.HashMap; 
/**
 * This class represents a Goblin and all the actions/events that can happen to it
 * Private instance variables such as currentHealth, attack, defenese, and experiencePoints are added to enhance the functionality of the Fighter 
 * Mutators, Accessors, toString, and game specific methods (dying, evolving, etc) are added as well
 * Default constructor initializes attributes to a default range of values and parameter constructor is utilized when the Goblin evolves to Ogre form
 */
public class Goblin extends Fighter
{
    //Represents the currentHealth, maxHealth, attack, defense, EXP, attackIcon, fighterIcon, food, and gold that the Goblin currently has
    private int currentHealth, maxHealth, attack, defense, experiencePoints, gold;
    private String fighterType;
    protected ImageIcon attackIcon, fighterIcon;
    private HashMap<String, Integer> inventory;

    /**Default constructor initializes attributes of a default Goblin Fighter*/
    public Goblin(){
        maxHealth = (int)(Math.random() * 4) + 17;
        currentHealth = maxHealth;
        fighterType = "Goblin";
        attack = 7;
        defense = 3;
        experiencePoints = 0;
        gold = 0;
        attackIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\Demonclub.png");
        fighterIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\goblin.gif");
        inventory = new HashMap<String, Integer>();
        //Goblin starts with 1 of each food since it's overall stats are better than a human
        inventory.put("Chicken", 1);
        inventory.put("Lobster", 1);
        inventory.put("Dragon Egg", 1);
    }

    /**7 parameter constructor used when Goblin evolves to an ogre*/
    public Goblin(int mxHealth, int att, int def, int exp, int g, String fightType, HashMap<String, Integer> inven){
        maxHealth = mxHealth;
        currentHealth = maxHealth;
        attack = att;
        defense = def;
        experiencePoints = exp;
        gold = g;
        fighterType = fightType;
        inventory = inven;
    }

    /**Returns Goblin's current health points left*/
    public int getHealth(){
        return currentHealth;
    }

    /**Returns Goblin's max health points*/
    public int getMaxHealth(){
        return maxHealth;
    }

    /**If the Goblin has the food item given in the parameter, then subtract 1 from the total quantity of that food item and return true, otherwise user does not have that particular food item so return false*/
    public boolean eatFood(String food){
        if(inventory.get(food) > 0){
            inventory.put(food, inventory.get(food) - 1);
            return true;
        }
        return false;
    }

    /**Adds food to Goblin's inventory depending on what the user bought*/
    public void addFood(String food, int amount){
        inventory.put(food, inventory.get(food) + amount);
    }

    /**Returns all food that a Goblin has in a String to be displayed in the JOptionPane*/
    public String getFoodInventory(){
        //initializes foodInventory to empty String
        String foodInventory = "";
        //for every key inside hashmap "inventory", add the entry (food) which is the key and the corresponding value which represents the quantity of food to the String  
        for(String entry: inventory.keySet())
            foodInventory += entry + ": " + inventory.get(entry) + "\n";
        return foodInventory;  
    }

    /**Returns the whole inventory. Used when goblin evolves to an Ogre*/
    public HashMap<String, Integer> getInventory(){
        return inventory;
    }

    /**Decreases Goblin's currentHealth by the damage given*/
    public void loseHealth(int damage){
        currentHealth -= damage;
        if(currentHealth < 0)
            currentHealth = 0;
    }

    /**If Goblin's currentHealth is equal to zero (dead) then return true, otherwise false*/
    public boolean isDead(){
        if(currentHealth <= 0)
            return true;
        return false;
    }

    /**Returns Goblins's defense points randomly generated as a 3 or 4*/
    public int getDefense(){
        return (int)(Math.random() * 2) + defense;
    }

    /**Returns Goblin's attack points randomly generated as a 7 or 8*/
    public int getAttack(){
        return (int)(Math.random() * 2) + attack;
    }

    /**Returns Goblin's XP*/
    public int getExperiencePoints(){
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

    /**Increases max health of a Goblin (used to increase user's starting health and if Goblin evolves)*/
    public void addMaxHealth(int health){
        //if the Goblin has max health already, then increase the max health and make the current health the maximum amount out as well
        if(currentHealth == maxHealth){
            maxHealth += health;
            currentHealth = maxHealth;
        }
        //otherwise just increase the max health 
        else maxHealth += health;
    }

    /**Returns fighter type as a Goblin*/
    public String getFighterType(){
        return fighterType;
    }

    /**Returns Goblin's weapon icon to be displayed*/
    public ImageIcon getWeaponIcon(){
        return attackIcon;
    }

    /**Returns Goblin's Fighter icon to be displayed*/
    public ImageIcon getFighterIcon(){
        return fighterIcon;
    }

    /**Changes Goblin's weapon icon if the Goblin is an enemy*/
    public void setEnemyWeaponIcon(){
        attackIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\redAxe.png");
    }

    /**Changes Goblin's Fighter icon to be displayed if the Goblin is an enemy*/
    public void setEnemyFighterIcon(){
        fighterIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\evilGoblin.gif");
    }

    /**Returns Goblin's current stats: Fighter type, currentHealth left, attack, defense, and EXP*/
    public String toString(){
        return "Fighter Type: " + fighterType + "\nHealth Points: " + currentHealth + " / " + maxHealth + "\nAttack Points: " + attack + " - " + (attack + 1) + "\nDefense Points: " + defense + " - " + (defense + 1) + "\nExperience Points (XP): " + experiencePoints + "\nGold: " + gold; 
    }

    /**Adds gold to Goblin's pouch*/
    public void addGold(int g){
        gold += g;
    }

    /**makes sure user's Goblin has enough money to purchase the item*/
    public boolean enoughMoney(int g){
        return gold >= g;
    }

    /**Subtracts gold from Goblin's pouch depending on what the user bought*/
    public void buyItem(int g){
        gold -= g;
    }

    /**Returns Goblin's gold*/
    public int getGold(){
        return gold;
    }

    /**If Goblin has more than 80 XP, return true to initiate transformation to Ogre, otherwise return false*/
    public boolean evolve(){
        return experiencePoints >= 80;
    }
}

