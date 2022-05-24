package game;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	
	Clip clip;
	URL soundURL[] = new URL[4]; //Increase in size if more sounds used later
	
	public Sound() {
		
		soundURL[0] = getClass().getResource("/sound/TextQuest_Intro_1.wav");
		soundURL[1] = getClass().getResource("/sound/TextQuest_Key.wav");
		soundURL[2] = getClass().getResource("/sound/TextQuest_LevelUp.wav");
		soundURL[3] = getClass().getResource("/sound/TextQuest_Silence.wav");
	}
	
	public void setFile(int i) {
		try {
			
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void play() {
		clip.start();
	}
	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	public void stop() {
		if(clip != null) {
		clip.stop();
		}
	}	

}
