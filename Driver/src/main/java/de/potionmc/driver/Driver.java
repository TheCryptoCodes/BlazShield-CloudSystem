package de.potionmc.driver;

import de.potionmc.driver.cloudcommands.HelpCMD;
import de.potionmc.driver.cloudcommands.StopCMD;
import de.potionmc.driver.cloudcommands.VersionCMD;
import de.potionmc.driver.commands.CommandManager;
import de.potionmc.driver.logger.Loggers;
import de.potionmc.driver.logger.LoggersType;
import de.potionmc.driver.recode.CloudLoader;
import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;

//Author Louispix
//Uhr zeit 23:10

public class Driver {
    private static CommandManager commandManager = new CommandManager();
    private static volatile LineReader lineReader;
    private static volatile Terminal terminal;
    private static volatile boolean running = false;
    private static CloudLoader cloudLoader = new CloudLoader();

    private static final String PREFIX = "\033[36mBlazShield \033[37m» ";

    public static void main(String[] args){
        CommandManager commandManager = new CommandManager();
        commandManager.register("help", "can you see all cloud commands", new HelpCMD());
        commandManager.register("version", "can you see cloud version", new VersionCMD());
        commandManager.register("ver", "can you see cloud version", new VersionCMD());
        commandManager.register("stop", "can to cloud stop command", new StopCMD());
        commandManager.register("shutdown", "can to cloud stop command", new StopCMD());
        final Thread thread = new Thread(null, () -> {
            try {
                terminal = TerminalBuilder.builder().color(true).dumb(true).encoding("UTF-8").build();
            } catch (IOException e) {
                e.printStackTrace();
            }
            lineReader = LineReaderBuilder.builder().terminal(terminal).build();
            running = true;
            while (running) {
                String command;
                try {
                    command = lineReader.readLine(PREFIX);
                    String finalCommand = command.replace(PREFIX, "");
                    String[] args1 = finalCommand.split(" ");
                    String[] astring = new String[args1.length - 1];
                    System.arraycopy(args1, 1, astring, 0, args1.length - 1);
                    String[] arguments = astring;
                    String commandName = args1[0];
                    if (!commandManager.exists(commandName)) {
                        new Loggers(LoggersType.WARN, Loggers.useColorSystem, "The command was not found please type HELP to get help");
                    } else {
                        commandManager.execute(commandName, arguments);
                    }
                } catch (EndOfFileException e) {
                    return;
                }
            }
        }, "BlazShield");

        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        cloudLoader.getConfigManager();

    }
}
