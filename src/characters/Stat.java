package characters;

import java.util.Arrays;

public class Stat{
	
	//Strength, Dexterity, Charisma, Wisdom, Intelligence, Constitution 
	
	protected String stat;
	protected int value;
	protected String[] stats = {"Strength", "Dexterity", "Charisma", "Wisdom", "Intelligence", "Constitution"};
	
	public Stat (String stat, int value) {
		//Checks to make sure the Stat is a valid type
		if(!(Arrays.asList(stats).contains(stat))){System.out.println("Unexpected Stat");}
		//Assigns Stat name and value
		this.stat = stat;
		this.value = value;
	}
	//Getters
	public String getStat() { return stat; }
	public int getValue()	{return value; }
	
	//Setters
	public void setStat(String stat) { this.stat = stat; }
	public void setValue(int value)	 { this.value = value; }
	
	//Increments by 1
	public void inc() { value++; }
	
	
	public String getBenefit() {
		if(stat == "Strength") {
			return "Health \n" + value;
		}
		else if(stat == "Constitution") {
			return "Health \n" + value *2;
		}
		else if(stat == "Wisdom") {
			return "Mana \n" + value;
		}
		else if(stat == "Intelligence") {
			return "Health \n" + value *2;
		}
		else {
			return "N/a \n" + "0"; 
		}
	}
	
	
	
	
	
	//Test
	/*
	 * Stat dex = new Stat("Dexterity", 1);
	 * System.out.println(dex.getValue());
	 * dex.inc();
	 * System.out.println(dex.getValue());
	 * System.out.println(dex.getStat());
	 * System.out.println(dex.getBenefit());
	 * 
	 */
}
