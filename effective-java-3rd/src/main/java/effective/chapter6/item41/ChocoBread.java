package effective.chapter6.item41;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ChocoBread {
    public static void main(String[] args) {
        MelonBread melonBread = new MelonBread();
        try {
            FileOutputStream fos = new FileOutputStream("kTae.txt");
            ObjectOutputStream a = new ObjectOutputStream(fos);
            a.writeObject(melonBread);
            a.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
