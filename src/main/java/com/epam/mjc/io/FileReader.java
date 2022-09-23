package com.epam.mjc.io;

import javax.imageio.IIOException;
import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            int ch;
            StringBuilder stringBuilder = new StringBuilder();
            while ((ch = fileInputStream.read()) != -1) {
                stringBuilder.append((char) ch);
            }
            String[] lines = stringBuilder.toString().split("\\n");
            for (int i = 0; i < lines.length; i++) {
                if (i % 4 == 0) {
                    profile.setName(lines[i].substring(6));
                } else if (i % 4 == 1) {
                    profile.setAge(Integer.valueOf(lines[i].substring(5)));

                } else if (i % 4 == 2) {
                    profile.setEmail(lines[i].substring(7));

                } else {
                    profile.setPhone(Long.valueOf(lines[i].substring(7)));
                }

            }
        } catch (IOException e) {
// exception handling
        }
        return profile;
    }

    public static void test() {
        String directory = System.getProperty("user.home");
        String fileName = "sample.txt";
        String absolutePath = directory + File.separator + fileName;
// reading the content of file
        try (FileInputStream fileInputStream = new FileInputStream(absolutePath)) {
            int ch;
            while ((ch = fileInputStream.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (IOException e) {
// exception handling
        }
    }
}




