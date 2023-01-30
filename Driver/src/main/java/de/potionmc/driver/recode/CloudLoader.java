package de.potionmc.driver.recode;

import de.potionmc.driver.cloudcommands.HelpCMD;
import de.potionmc.driver.cloudcommands.StopCMD;
import de.potionmc.driver.cloudcommands.VersionCMD;
import de.potionmc.driver.commands.CommandManager;
import de.potionmc.driver.config.ConfigManager;
import de.potionmc.driver.logger.Loggers;
import de.potionmc.driver.logger.LoggersType;

//Author Louispix
//Uhr zeit 23:34
public class CloudLoader {



    ConfigManager configManager = new ConfigManager();

    public static void CommandSystem(){
        CommandManager commandManager = new CommandManager();
        commandManager.register("help", "can you see all cloud commands", new HelpCMD());
        commandManager.register("version", "can you see cloud version", new VersionCMD());
        commandManager.register("ver", "can you see cloud version", new VersionCMD());
        commandManager.register("stop", "can to cloud stop command", new StopCMD());
        commandManager.register("shutdown", "can to cloud stop command", new StopCMD());
    }

    public ConfigManager getConfigManager() {
        Loggers.useColorSystem = true;
        logo("\n" +
                "     ____  _            _____ _     _      _     _ \n" +
                "    |  _ \\| |          / ____| |   (_)    | |   | |\n" +
                "    | |_) | | __ _ ___| (___ | |__  _  ___| | __| |\n" +
                "    |  _ <| |/ _` |_  /\\___ \\| '_ \\| |/ _ \\ |/ _` |\n" +
                "    | |_) | | (_| |/ / ____) | | | | |  __/ | (_| |\n" +
                "    |____/|_|\\__,_/___|_____/|_| |_|_|\\___|_|\\__,_| [OBSIDIAN-0.0.1]\n" +
                "                                                \n" +
                "_________________________________________________________________________________________________________\n");
        a("everything is being prepared...");
        a("an instance of the Manager is executed");
        b("a new node called InternalNode wants to connect");
        h("type 'start' to start proxy and lobby");
        h("type 'help' to see the help list");

        configManager.ConfigManager();
       return configManager;
    }
    private static void a(String message) {
        new Loggers(LoggersType.INFO, Loggers.useColorSystem, message);
    }

    private static void b(String message) {
        new Loggers(LoggersType.SERVICEREM, Loggers.useColorSystem, message);
    }

    private static void h(String message) {
        new Loggers(LoggersType.HELP, Loggers.useColorSystem, message);

    }
    private static void logo(String message) {
        new Loggers(LoggersType.LOGO, Loggers.useColorSystem, message);

    }

}
