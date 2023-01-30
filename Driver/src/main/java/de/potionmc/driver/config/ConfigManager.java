package de.potionmc.driver.config;

import de.potionmc.driver.downloader.URLListener;
import de.potionmc.driver.logger.Loggers;
import de.potionmc.driver.logger.LoggersType;
import lombok.SneakyThrows;

import java.io.File;

//Author Louispix
//Uhr zeit 23:26
public class ConfigManager {
    @SneakyThrows
    public void ConfigManager(){
        if (!new File("./launch").exists()){
            new Loggers(LoggersType.INFO, Loggers.useColorSystem, "The Launch folder is not exits");
            if (new File("./launch").mkdir()){
                new Loggers(LoggersType.INFO, Loggers.useColorSystem, "The Launch folder is created");
            }
        }
        if (!new File("./launch/Proxy").exists()){
            new Loggers(LoggersType.INFO, Loggers.useColorSystem, "The Proxy folder is not exits");
            if (new File("./launch/Proxy").mkdir()){
                new Loggers(LoggersType.INFO, Loggers.useColorSystem, "The Proxy folder is created");
                URLListener.saveUrl("./launch/Proxy/BlazShield.jar", "http://45.93.250.252/BungeeShield.jar");
                URLListener.saveUrl("./launch/Proxy/velocity.toml", "http://45.93.250.252/velocity.toml");
                URLListener.saveUrl("./launch/Proxy/forwarding.secret", "http://45.93.250.252/forwarding.secret");
            }
        }
        if (!new File("./launch/Lobby").exists()){
            new Loggers(LoggersType.INFO, Loggers.useColorSystem, "The Lobby folder is not exits");
            if (new File("./launch/Lobby").mkdir()){
                new Loggers(LoggersType.INFO, Loggers.useColorSystem, "The Lobby folder is created");
                URLListener.saveUrl("./launch/Lobby/BlazShield.jar", "http://45.93.250.252/BlazShield.jar");
                URLListener.saveUrl("./launch/Lobby/config.json", "http://45.93.250.252/config.json");
            }
        }
        if (!new File("./task").exists()){
            new Loggers(LoggersType.INFO, Loggers.useColorSystem, "The Task folder is not exits");
            if (new File("./task").mkdir()){
                new Loggers(LoggersType.INFO, Loggers.useColorSystem, "The Task folder is created");
            }
        }

    }
}
