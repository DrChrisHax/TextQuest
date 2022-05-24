package races;

public abstract class Race {
	protected String name;
	
	Race(String name){
		name = this.name;
	}
	
	public String toString() {
		return name;
	}
	
	public String getRace() {
		return name;
	}

}
