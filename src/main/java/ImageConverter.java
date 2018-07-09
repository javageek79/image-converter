import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageConverter {

    private final BufferedImage input;

    ImageConverter() throws IOException {
        this.input = readImage();
    }

    BufferedImage readImage() throws IOException {
        System.out.println("Reading raw input");
        return ImageIO.read(new File(getClass().getResource("test.png").getFile()));
    }

    void convertImage() {
        System.out.println("converting input");
        int width = this.input.getWidth();
        int height = this.input.getHeight();

        int luma;
        int gray;
        Color c;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                c = new Color(this.input.getRGB(x, y));

                luma = c.calculateLuma();
                gray = c.calculateGrayRgbValue(luma);
                this.input.setRGB(x, y, gray);
            }
        }
    }

    void writeGrayScaleImage() throws IOException {
        System.out.println("writing gray scale input");
        ImageIO.write(input, "png", new File("output.png"));
    }

    public static void main(String[] args) throws IOException {
        ImageConverter converter = new ImageConverter();
        long start = System.currentTimeMillis();
        converter.convertImage();
        long end = System.currentTimeMillis();
        converter.writeGrayScaleImage();

        System.out.println("calc duration = " + (end - start));
    }
}
