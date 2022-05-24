package dungeon;

import java.util.*;

public class DungeonMap {
	private ArrayList <Room>map; //the map- an ArrayList of Rooms
	private String dungeonName;
	
	List<String> commands = new ArrayList<>(Arrays.asList( "n", "s", "w", "e" ));
	
	
	public DungeonMap(String dungeonName) {
		this.dungeonName = dungeonName;
		this.map = new ArrayList<Room>();
		
		
		//N, S, W, E
		/*
		// map.add(new Room("Name", "Description", Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT));
		map.add(new Room("Entrance", "The entrance to" + dungeonName, Direction.NOEXIT, 2, Direction.NOEXIT, Direction.NOEXIT));
		map.add(new Room("Name", "Description", Direction.NOEXIT, 5, Direction.NOEXIT, 2));
		map.add(new Room("Name", "Description", 0, Direction.NOEXIT, 1, 3));
		map.add(new Room("Name", "Description", Direction.NOEXIT, 7, 2, 4));
		*/
	}
	
	

}
