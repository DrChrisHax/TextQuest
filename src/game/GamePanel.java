package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import object.SuperObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{
	//Default Screen Size- 1920 x 1080 - 40 x 22.5 tiles
	

	private static final long serialVersionUID = 1L;
	//Screen settings
	public int orignalTileSize = 16; //16x16 tile
	public int scale = 3;
	public int tileSize = orignalTileSize * scale; //48x48 tile
	public int maxScreenCol = 36;
	public int maxScreenRow = 20;
	public int screenWidth = tileSize * maxScreenCol; //1728 pixels
	public int screenHeight = tileSize * maxScreenRow;	//960 pixels
	
	//WORLD SETTINGS
	public final int maxWorldCol = 50;
	public final int maxWorldRow = 50;
	
	
	//FPS
	int FPS = 120;
	
	//Debug
	long drawTime;
	
	//System
	TileManager tileManager = new TileManager(this);
	KeyHandler key = new KeyHandler(this);
	Sound backgroundMusic = new Sound();
	Sound soundEffect = new Sound();
	public CollisionCheck cc = new CollisionCheck(this);
	public AssetManager am = new AssetManager(this);
	public UI ui = new UI(this);
	Thread gameThread;
	
	//Entity and Object
	public Player player = new Player(this, key); 
	public SuperObject obj[] = new SuperObject[100]; //Number of objects displayed
	
	
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true); //All the drawing from this component will be done in an off screen painting buffer
		this.addKeyListener(key);
		this.setFocusable(true); //GamePanel can be "focused" to receive key input
		
	}
	
	public void setupGame() {
		
		am.setObject();
		
		playMusic(3);
	}
	
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		
		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		
		while(gameThread != null) {
			
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if(delta >= 1) {
			update();
			repaint();
			delta--;
			drawCount++;
			}
			
			if(timer >= 1000000000) { //Every Second, Every Billion Nanoseconds
				System.out.println("FPS:" + drawCount);
				ui.setFPS(drawCount);
				drawCount = 0;
				timer = 0;
			}
		}
	}
	
	public void update() {
		
		player.update();
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g; //Gives more control over the graphics
		
		//Debug
		long drawStart = 0;
		drawStart = System.nanoTime();
		
		
		//TILE
		tileManager.draw(g2);
		
		//OBJECT
		for(int i = 0; i < obj.length; i++) {
			if(obj[i] != null) {
				obj[i].draw(g2,  this);
			}
		}
		//PLAYER
		player.draw(g2);
		
		//UI
		ui.draw(g2);
		
		drawTime = System.nanoTime() - drawStart;
		
		g2.dispose(); //Good practice for cleaning up objects and saving memory
	}
	
	//Sound (Line 63 to start music)
	//Background Music
	public void playMusic(int i ) {
		backgroundMusic.setFile(i);
		backgroundMusic.play();
		backgroundMusic.loop();
	}
	public void stopMusic() {
		backgroundMusic.stop();
	}
	
	//Sound Effects
	public void playSoundEffect(int i) {
		soundEffect.setFile(i);
		soundEffect.play();
	}
	public void stopSoundEffect() {
		soundEffect.stop();
	}
	
	
	
	//Debug
	public long getDrawTime() {
		return drawTime;
	}
	
	//Cheats
	public void collisionOff() {
		tileManager.collisionOff();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
