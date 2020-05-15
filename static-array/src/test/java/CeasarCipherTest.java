import org.junit.Test;
import static org.junit.Assert.*;

public class CeasarCipherTest {

    @Test
    public void uppercase() {

        String message = "HELLO WORLD";

        CeasarCipher cipher = new CeasarCipher(48);

        String encrypted = cipher.encrypt(message);

        String decrypted = cipher.decrypt(encrypted);

        System.out.println("Message: " + message);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);

        assertNotNull("Encrypted message isn't null", encrypted);
        assertNotNull("Decrypted message isn't null", decrypted);
        assertEquals("Decrypted message equals to original message", decrypted, message);
    }

    @Test
    public void lowercase() {

        String message = "hello world";

        CeasarCipher cipher = new CeasarCipher(48);

        String encrypted = cipher.encrypt(message);

        String decrypted = cipher.decrypt(encrypted);

        System.out.println("Message: " + message);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);

        assertNotNull("Encrypted message isn't null", encrypted);
        assertNotNull("Decrypted message isn't null", decrypted);
        assertEquals("Decrypted message equals to original message", decrypted, message);
    }

    @Test
    public void mixedWithNumber() {

        String message = "Hello world 2020";

        CeasarCipher cipher = new CeasarCipher(48);

        String encrypted = cipher.encrypt(message);

        String decrypted = cipher.decrypt(encrypted);

        System.out.println("Message: " + message);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);

        assertNotNull("Encrypted message isn't null", encrypted);
        assertNotNull("Decrypted message isn't null", decrypted);
        assertEquals("Decrypted message equals to original message", decrypted, message);
    }

    @Test
    public void mixedWithSpecialChars() {

        String message = "**Hello world** 2020";

        CeasarCipher cipher = new CeasarCipher(48);

        String encrypted = cipher.encrypt(message);

        String decrypted = cipher.decrypt(encrypted);

        System.out.println("Message: " + message);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);

        assertNotNull("Encrypted message isn't null", encrypted);
        assertNotNull("Decrypted message isn't null", decrypted);
        assertEquals("Decrypted message equals to original message", decrypted, message);
    }
}
