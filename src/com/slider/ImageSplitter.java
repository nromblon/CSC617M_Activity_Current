package com.slider;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageSplitter {
	
	private BufferedImage[][] imgs;
	
	public ImageSplitter() {
		this.splitImage();
	}
	
	private void splitImage() {
		try {
//			this.getClass().getResource("/images/RoseSlider.png")
			BufferedImage image = ImageIO.read(new File("images/RoseSlider.png"));
			int rows = 4;
			int cols = 4;
			this.imgs = new BufferedImage[4][4];
			
			for(int x = 0; x < rows; x++) {
				for(int y = 0; y < cols; y++) {
					imgs[y][x] = new BufferedImage(100, 100, image.getType());
					Graphics2D graphics = imgs[y][x].createGraphics();
					graphics.drawImage(image, 0, 0, 100, 100, 100*y, 100*x, (100*y+100), (100*x+100), null);
					graphics.dispose();
				}
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage[][] getImages() {
		return this.imgs;
	}

}
