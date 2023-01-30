package de.potionmc.driver.downloader;



import de.potionmc.driver.logger.Loggers;
import de.potionmc.driver.logger.LoggersType;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

//Author Louispix
//Uhr zeit 23:37
public class URLListener {

    public static void saveUrl(final String filename, final String urlString)
            throws MalformedURLException, IOException {
        BufferedInputStream in = null;
        FileOutputStream fout = null;
        try {
            in = new BufferedInputStream(new URL(urlString).openStream());
            fout = new FileOutputStream(filename);

            final byte data[] = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1) {
                fout.write(data, 0, count);


            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (fout != null) {
                fout.close();
              //  a("Succesfully downloaded BlazShield");
            }


        }
        a("Succesfully update BlazShield");

    }
    private static void a(String message) {
        new Loggers(LoggersType.DOWNLOADER, Loggers.useColorSystem, message);
    }


}
