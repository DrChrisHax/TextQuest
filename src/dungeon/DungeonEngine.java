package dungeon;

import java.util.*;

public class DungeonEngine {
	private ArrayList <Room> map;
	private PlaceHolder player;
	private int level;
	private String dungeonName;
	
	public DungeonEngine(int level, String dungeonName) {
		this.level = level;
		this.dungeonName = dungeonName;
		
		// map.add(new Room("Name", "Description", Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT));
		if(level < 10) {
			map.add(new Room("Entrance", "The entrance to" + dungeonName, Direction.NOEXIT, 2, Direction.NOEXIT, Direction.NOEXIT));
			for(int i = 0; i < 5; i++) {
				map.add(new Room("Name", "Desc", Direction.NOEXIT, 2, Direction.NOEXIT, Direction.NOEXIT));
			}
		}
		else if (level < 50) {
			map.add(new Room("Entrance", "The entrance to" + dungeonName, Direction.NOEXIT, 2, Direction.NOEXIT, Direction.NOEXIT));
			for(int i = 0; i < level - 1; i++) {
				map.add(new Room("Name", "Desc", Direction.NOEXIT, 2, Direction.NOEXIT, Direction.NOEXIT));
			}
		}
		else {
			map.add(new Room("Entrance", "The entrance to" + dungeonName, Direction.NOEXIT, 2, Direction.NOEXIT, Direction.NOEXIT));
			for(int i = 0; i < 49; i++) {
				map.add(new Room("Name", "Desc", Direction.NOEXIT, 2, Direction.NOEXIT, Direction.NOEXIT));
			}
		}
		
		player = new PlaceHolder(map.get(0));
		
		
	}
	
	
	

}
