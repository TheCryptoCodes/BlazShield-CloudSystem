package de.potionmc.driver.cloudcommands;


import de.potionmc.driver.commands.ICommand;
import de.potionmc.driver.logger.Loggers;
import de.potionmc.driver.logger.LoggersType;

//Author Louispix
//Uhr zeit 23:22
public class StopCMD implements ICommand {


    @Override
    public void execute(String[] args) {
        new Loggers(LoggersType.INFO, Loggers.useColorSystem, "The service has been successfully stopped");
        System.exit(-0);
        for (int i = 0; i != 200; i++) {
            System.out.println(" " + i);
        }
    }
}
