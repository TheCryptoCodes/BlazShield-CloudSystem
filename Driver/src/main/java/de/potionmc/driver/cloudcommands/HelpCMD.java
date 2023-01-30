package de.potionmc.driver.cloudcommands;


import de.potionmc.driver.commands.ICommand;
import de.potionmc.driver.logger.Loggers;
import de.potionmc.driver.logger.LoggersType;

//Author Louispix
//Uhr zeit 23:22
public class HelpCMD implements ICommand {


    @Override
    public void execute(String[] args) {

            new Loggers(LoggersType.INFO, Loggers.useColorSystem, "The following Commands are registered:");
            new Loggers(LoggersType.INFO, Loggers.useColorSystem, " ");

            new Loggers(LoggersType.INFO, Loggers.useColorSystem, "'version' Aliases: [version, ver] - the Cloud version is online!");
            new Loggers(LoggersType.INFO, Loggers.useColorSystem, "'start' Aliases: [start, run] - the service start command!");
            new Loggers(LoggersType.INFO, Loggers.useColorSystem, "'stop' Aliases: [stop, shutdown] - Cloud stop command!");
            new Loggers(LoggersType.INFO, Loggers.useColorSystem, " ");

            new Loggers(LoggersType.INFO, Loggers.useColorSystem, "Threads: " + Runtime.getRuntime().availableProcessors());
            new Loggers(LoggersType.INFO, Loggers.useColorSystem, "OS System: " + System.getProperty("os.name"));
            new Loggers(LoggersType.INFO, Loggers.useColorSystem, "Support: http://discord.blazmc.de");

    }
}
