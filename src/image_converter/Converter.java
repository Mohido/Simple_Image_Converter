package image_converter;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Converter {

	public static void main(String[] args) {
		
		BufferedImage img;
		

		for(int i = 0 ; i < args.length; i++) {
			
			try {
				String path = System.getProperty("user.dir") + args[i];
				img = ImageIO.read(new File(path));
				
				FileWriter output = new FileWriter("converted_image" + i +".cimg");
				output.write(img.getWidth() + " "+ img.getHeight() + "\n");
				
				
				for (int x = 0 ; x < img.getWidth(); x++) {
					StringBuffer  colourLine = new StringBuffer ();
					
					for (int y =  0 ; y  < img.getHeight() ; y++) {
						int argb = img.getRGB(x, y);
						
						int a = argb >> 24;
						int r = (argb >> 16) & 0xff;
						int g = (argb >> 8) & 0xff;
						int b = (argb) & 0xff;
						
						colourLine.append(r);
						colourLine.append(" ");
						colourLine.append(g);
						colourLine.append(" ");
						colourLine.append(b);
						colourLine.append(" ");
						
					}
					output.write(colourLine.toString() + "\n");
				}
				
				
				output.close();
				System.out.println("Converted: "+ args[i] + " to " + "converted_image" + i +".cimg");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
