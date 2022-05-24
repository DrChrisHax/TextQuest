package skills;

public class skill {
	private int damage, manaCost, enemiesAffected;
	private String name, description;
	//private Effect effect; (Implement Later)
	
	public skill(int damage, int manaCost, int enemiesAffected, String name, String description){
		this.name = name;
		this.description = description;
		this.damage = damage;
		this.manaCost = manaCost;
		this.enemiesAffected = enemiesAffected;
		
		
	}
	
	
}
