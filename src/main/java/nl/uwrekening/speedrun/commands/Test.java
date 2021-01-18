package nl.uwrekening.speedrun.commands;

import nl.uwrekening.speedrun.events.Move;
import nl.uwrekening.speedrun.time.CountDown;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Random;

public class Test implements CommandExecutor {

    public static boolean Test = false;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0){
            Test = true;
            sender.sendMessage("Yo test is nu true");

            Random random = new Random();

            Move.Moveing = false;

            SpeedRun.playersIn = random.nextInt(10);
            if (SpeedRun.playersIn == 1){
                sender.sendMessage(String.valueOf(SpeedRun.playersIn));
            }
        }
        return true;
    }
}
