package characters;

import races.*;
import type.*;

public class character {
	protected double health, maxHealth, mana, maxMana;
	protected int level, xp;
	protected String name;
	protected Stat Strength, Dexterity, Constitution, Charisma, Intelligence, Wisdom;
	protected Race race;
	protected Type type;
	
	//Template for a CHARACTER
	public character(String name, Race race, Type type) {
		this.type = type;
		this.race = race;
		this.name = name;
		
		health = 1;
		mana = 1;
		maxHealth = 1;
		maxMana = 1;
		level = 1;
		xp = 0;
		
		//Set up stats
		Strength = 		new Stat("Strength", 	 0);
		Dexterity = 	new Stat("Dexterity", 	 0);
		Constitution = 	new Stat("Constitution", 0);
		Charisma = 		new Stat("Charisma", 	 0);
		Intelligence = 	new Stat("Intelligence", 0);
		Wisdom = 		new Stat("Wisdom", 		 0);
		
		
		
	}
	
	//getters 
	public Race getRace() 		{ return race; 		}//Used for when more races are added later
	public Type getType() 		{ return type; 		}
	public String getName() 	{ return name; 		}
	public int getXP()   		{ return xp;   		} 	
	public double getHealth() 	{ return health;	}
	public double getMaxHealth(){ return maxHealth; }
	public double getMana()		{ return mana;		}
	public double getMaxMana()	{ return maxMana; 	}
	
	
	
	//Insert Method for choosing stats
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	//XP & level methods
	public void zeroXP() 		{ xp = 0; } 		//Used if character dies
	public void gainXP( int xp) { this.xp += xp; } 	//leveling up will be dealt with in subclasses
	
	/**
	 * Level 1: 0   Total: 0
	 * Level 2: 20  Total: 20
	 * Level 3: 80  Total: 100
	 * Level 4: 180 Total: 280
	 * Level 5: 320 Total: 600
	 * Level 6: 500 Total: 1100
	 * Level 7: 980 Total: 2080
	 */
	public boolean checkLevelUp() { 
		int neededXP = 100 * (int)(Math.pow(level, 2.0)/5);
		return (xp >= neededXP);
	}

	
	public void updateStats(double healthBase, double manaBase) {
		//Used when leveling up
		maxHealth = healthBase + (healthBase/10); //Possible balance later
		maxMana = manaBase + (manaBase/10);
		sleep();
	}
	
	public void sleep() {
		health = maxHealth;
		mana = maxMana;
	}
	public void die() {
		zeroXP();
	}
	
	public void damage( int damage) { 
		health -= damage; 
		if( health < 1) {
			die();
		}
	}
	
	@Override
	public String toString() {
		return name + " " + race.getRace() + " " + type.getType();
	}

}
