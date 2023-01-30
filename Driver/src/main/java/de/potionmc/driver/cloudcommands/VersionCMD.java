package de.potionmc.driver.cloudcommands;


import de.potionmc.driver.commands.ICommand;
import de.potionmc.driver.logger.Loggers;
import de.potionmc.driver.logger.LoggersType;

//Author Louispix
//Uhr zeit 23:22
public class VersionCMD implements ICommand {


    @Override
    public void execute(String[] args) {
        new Loggers(LoggersType.INFO, Loggers.useColorSystem, "The Service is on BlazShield");
        new Loggers(LoggersType.INFO, Loggers.useColorSystem, "Version [OBSIDIAN-0.0.1]");
    }
}
