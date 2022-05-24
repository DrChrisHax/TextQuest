package type;

public abstract class Type {
	
	protected String name;
	
	Type(String name){
		name = this.name;
	}
	
	public String getType() {
		return name;
	}

}
