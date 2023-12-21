import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageUtils {

    public static BufferedImage loadImage(String imagePath) throws IOException {
        return ImageIO.read(new File(imagePath));
    }

    public static void saveImage(BufferedImage image, String outputPath) throws IOException {
        ImageIO.write(image, "jpg", new File(outputPath));
    }

    public static byte[] imageToBytes(BufferedImage image) throws IOException {
        ImageIO.write(image, "jpg", new FileOutputStream("temp.jpg"));
        return loadBytesFromFile("temp.jpg");
    }

    public static BufferedImage bytesToImage(byte[] bytes) throws IOException {
        saveBytesAsImage(bytes, "temp.jpg");
        return loadImage("temp.jpg");
    }

    public static byte[] loadBytesFromFile(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        byte[] bytes = new byte[fis.available()];
        fis.read(bytes);
        fis.close();
        return bytes;
    }

    public static void saveBytesAsImage(byte[] bytes, String outputPath) throws IOException {
        FileOutputStream fos = new FileOutputStream(outputPath);
        fos.write(bytes);
        fos.close();
    }
}