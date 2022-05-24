package enemies;

public abstract class enemy {
	private double health;
	private String name;
	
	public enemy(int health, String name) {
		this.setHealth(health);
		this.setName(name);
	}

	public String getName()				 	{ return name; }
	public void setName(String name) 		{ this.name = name; }
	public double getHealth() 				{ return health; }
	public void setHealth(double health) 	{ this.health = health; }
	
	
}
