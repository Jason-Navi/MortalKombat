import javax.swing.*; 
import java.util.HashMap; 
/**
 * This class represents a Human and all the actions/events that can happen to him/her
 * Private instance variables such as currentHealth, attack, defenese, and experiencePoints are added to enhance the functionality of the Fighter 
 * Mutators, Accessors, toString, and game specific methods are added as well
 * Default constructor initializes attributes to a default range of values and parameter constructor is utilized when the Human evolves to Knight form 
 */
public class Human extends Fighter
{
    //Represents the currentHealth, maxHealth, attack, defense, EXP, attackIcon, fighterIcon, food and gold that the Human currently has
    private int currentHealth, maxHealth, attack, defense, experiencePoints, gold;
    private String fighterType;
    protected ImageIcon attackIcon, fighterIcon;
    private HashMap <String, Integer> inventory;

    /**Default constructor initializes attributes of a default Human Fighter*/
    public Human(){
        maxHealth = (int)(Math.random() * 6) + 30;
        currentHealth = maxHealth;
        fighterType = "Human";
        attack = 6;
        defense = 2;
        experiencePoints = 0;
        gold = 0;
        attackIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\sword.png");
        fighterIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\warrior.gif");
        inventory = new HashMap<String, Integer>();
        //human starts with 2 of each food since it's stats are below par
        inventory.put("Chicken", 2);
        inventory.put("Lobster", 2);
        inventory.put("Dragon Egg", 2);
    }

    /**7 parameter constructor used when a Human evolves to a Knight*/
    public Human(int mxHealth, int att, int def, int exp, int g, String fightType, HashMap<String, Integer> inven){
        maxHealth = mxHealth;
        currentHealth = maxHealth;
        attack = att;
        defense = def;
        experiencePoints = exp;
        gold = g;
        fighterType = fightType;
        inventory = inven;
    }

    /**Returns Human's currentHealth points left*/
    public int getHealth(){
        return currentHealth;
    }

    /**Returns Human's max health points*/
    public int getMaxHealth(){
        return maxHealth;
    }

    /**If the Human has the food item given in the parameter, then subtract 1 from the total quantity of that food item and return true, otherwise user does not have that particular food item so return false*/
    public boolean eatFood(String food){
        if(inventory.get(food) > 0){
            inventory.put(food, inventory.get(food) - 1);
            return true;
        }
        return false;
    }

    /**Adds food to Human's inventory depending on what the user bought*/
    public void addFood(String food, int amount){
        inventory.put(food, inventory.get(food) + amount);
    }

    /**Returns all food that a Human has in a String to be displayed in the JOptionPane*/
    public String getFoodInventory(){
        String foodInventory = "";
        for(String entry: inventory.keySet())
            foodInventory += entry + ": " + inventory.get(entry) + "\n";
        return foodInventory;  
    }

    /**Returns the whole inventory. Used when Human evolves to a Knight*/
    public HashMap<String, Integer> getInventory(){
        return inventory;
    }

    /**Decreases Human's currentHealth by the damage given*/
    public void loseHealth(int damage){
        currentHealth -= damage;
        if(currentHealth < 0)
            currentHealth = 0;
    }

    /**If Human's currentHealth is equal to zero (dead) then return true, otherwise false*/
    public boolean isDead(){
        if(currentHealth == 0)
            return true;
        return false;
    }

    /**Returns Human's defense points randomly generated as a 2 or 3*/
    public int getDefense(){
        return (int)(Math.random() * 2) + defense;
    }

    /**Returns Human's attack points randomly generated as a 6 or 7*/
    public int getAttack(){
        return (int)(Math.random() * 2) + attack;
    }

    /**Returns Human's XP*/
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

    /**Increases max health of a Human (used to increase user's starting health and if Human evolves)*/
    public void addMaxHealth(int health){
        //if the Human has max health already, then increase the max health and make the current health the maximum amount out as well
        if(currentHealth == maxHealth){
            maxHealth += health;
            currentHealth = maxHealth;
        }
        //otherwise just increase the max health 
        else maxHealth += health;
    }

    /**Returns Human's current stats: Fighter type, currentHealth left, attack, defense, and EXP*/
    public String toString(){
        return "Fighter Type: " + fighterType + "\nHealth Points: " + currentHealth + " / " + maxHealth + "\nAttack Points: " + attack + " - " + (attack + 1) + "\nDefense Points: " + defense + " - " + (defense + 1) + "\nExperience Points (XP): " + experiencePoints + "\nGold: " + gold; 
    }

    /**Returns fighter type as a Human*/
    public String getFighterType(){
        return fighterType;
    }

    /**Returns Human's weapon icon to be displayed*/
    public ImageIcon getWeaponIcon(){
        return attackIcon;
    }

    /**Changes Human's weapon icon if the Human is an enemy*/
    public void setEnemyWeaponIcon(){
        attackIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\enemySword.png");
    }

    /**Changes Human's Fighter icon to be displayed if the Human is an enemy*/
    public void setEnemyFighterIcon(){
        fighterIcon = new ImageIcon("C:\\Users\\jnavi1002\\Documents\\CS Portfolio\\Java\\mortalKombat\\Icons\\evilWarrior.gif");
    }

    /**Returns Human's Fighter icon to be displayed*/
    public ImageIcon getFighterIcon(){
        return fighterIcon;
    }

    /**Adds gold to user's Humans' pouch*/
    public void addGold(int g){
        gold += g;
    }

    /**makes sure user's Human has enough money to purchase the item*/
    public boolean enoughMoney(int g){
        return gold >= g;
    }

    /**Subtracts gold from Human's pouch depending on what the user bought*/
    public void buyItem(int g){
        gold -= g;
    }

    /**Returns Human's gold*/
    public int getGold(){
        return gold;
    }

    /**If Human has more than 80 XP, return true to initiate transformation to Knight, otherwise return false*/
    public boolean evolve(){
        return experiencePoints >= 80;
    }
}
