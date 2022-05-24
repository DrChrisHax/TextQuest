package game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class UTools {
	
	public BufferedImage scaleImage(BufferedImage original, int width, int hieght) {
		
		
		BufferedImage scaledImage = new BufferedImage(width, hieght, original.getType());
		Graphics2D g2 = scaledImage.createGraphics();
		g2.drawImage(original, 0, 0, width, hieght, null);
		g2.dispose();

		return scaledImage;
		
		
		
	}
}
