import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {
    public static BufferedImage img;
    public static void main(String args[])
    {
        readImage();
        //bearbeiten(-1, 0);
        blackAndWhite();
        writeImage();

    }

    public static void readImage()
    {
        Main.img = null;

        try {
            img = ImageIO.read(new File(Main.class.getResource("test.png").getFile()));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void bearbeiten(int a, int b)
    {
        for(int x = 0; x < img.getWidth(); x++)
        {
            for(int y = 0; y < img.getHeight(); y++)
            {
                int rgb = a*Main.img.getRGB(x, y) + b;
                Main.img.setRGB(x, y, rgb);
            }
        }
    }

    public static void blackAndWhite()
    {
        for(int x = 0; x < img.getWidth(); x++)
        {
            for(int y = 0; y < img.getHeight(); y++)
            {
                int rgb = Main.img.getRGB(x, y);
                Color c = new Color(rgb);
                int gray = (int) (0.299 * c.getRed() + 0.587 * c.getGreen() + 0.114 * c.getBlue());
                Color c2 = new Color(gray, gray, gray);
                Main.img.setRGB( x, y, c2.getRGB());
            }
        }
    }
    public static void writeImage()
    {
        File output = new File("1211810004changed.png");
        try {
            ImageIO.write(img,"png", output);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}