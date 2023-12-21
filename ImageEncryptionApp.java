import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.SecureRandom;

public class ImageEncryptionApp {

    public static void main(String[] args) {
        try {
            // Step 1: Generate a secret key
            SecretKey secretKey = generateSecretKey();

            // Step 2: Generate a random IV
            byte[] iv = generateRandomIV();

            // Step 3: Encrypt the image
            encryptImage("input.jpg", "encrypted.jpg", secretKey, iv);

            // Step 4: Decrypt the image
            decryptImage("encrypted.jpg", "decrypted.jpg", secretKey, iv);

            System.out.println("Image Encryption and Decryption completed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static SecretKey generateSecretKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        return keyGenerator.generateKey();
    }

    private static byte[] generateRandomIV() {
        byte[] iv = new byte[16]; // IV size is 16 bytes for AES
        new SecureRandom().nextBytes(iv);
        return iv;
    }

    private static void encryptImage(String inputImagePath, String outputImagePath, SecretKey secretKey, byte[] iv) throws Exception {
        BufferedImage bufferedImage = ImageUtils.loadImage(inputImagePath);
        byte[] imageBytes = ImageUtils.imageToBytes(bufferedImage);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(iv));
        byte[] encryptedBytes = cipher.doFinal(imageBytes);

        // Save IV and encrypted image bytes
        saveBytesToFile(iv, "iv.bin");
        saveBytesToFile(encryptedBytes, outputImagePath);
    }

    private static void decryptImage(String inputImagePath, String outputImagePath, SecretKey secretKey, byte[] iv) throws Exception {
        byte[] encryptedBytes = loadBytesFromFile(inputImagePath);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv));
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        BufferedImage decryptedImage = ImageUtils.bytesToImage(decryptedBytes);
        ImageUtils.saveImage(decryptedImage, outputImagePath);
    }

    private static void saveBytesToFile(byte[] bytes, String outputPath) throws Exception {
        FileOutputStream fos = new FileOutputStream(outputPath);
        fos.write(bytes);
        fos.close();
    }

    private static byte[] loadBytesFromFile(String filePath) throws Exception {
        FileInputStream fis = new FileInputStream(filePath);
        byte[] bytes = new byte[fis.available()];
        fis.read(bytes);
        fis.close();
        return bytes;
    }
}
