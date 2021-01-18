package nl.uwrekening.speedrun.time;

import nl.uwrekening.speedrun.Main;
import nl.uwrekening.speedrun.data.Joined_Data;
import nl.uwrekening.speedrun.events.Move;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Random;

public class CountDown {

    public static int countdown = 61;
    public static int countdown_2 = 1;

    static int count;
    static int count_2;

    public static void CountDown(Player player){
        count = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
            @Override
            public void run() {
                countdown--;
                if (countdown == 60){
                    Bukkit.broadcastMessage("§aGame Starts In: " + "60s");
                }
                if (countdown == 30){
                    Bukkit.broadcastMessage("§aGame Starts In: " + "30s");
                }
                if (countdown == 10){
                    Bukkit.broadcastMessage("§aGame Starts In: " + "10s");
                }
                if (countdown == 5){
                    Bukkit.broadcastMessage("§aGame Starts In: " + "5s");
                }
                if (countdown == 4){
                    Bukkit.broadcastMessage("§aGame Starts In: " + "4s");
                }
                if (countdown == 3){
                    Bukkit.broadcastMessage("§aGame Starts In: " + "3s");
                }
                if (countdown == 2){
                    Bukkit.broadcastMessage("§aGame Starts In: " + "2s");
                }
                if (countdown == 1){
                    Bukkit.broadcastMessage("§aGame Starts In: " + "1s");
                }
                if (countdown == 0){
                    Finish(player);
                    countdown = 61;
                    Bukkit.getScheduler().cancelTask(count);
                    Joined_Data.setJoined(player, true);
                }
            }
        }, 0l, 20l);
    }

    public static void CountDown_2(Player player){
        count_2 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
            @Override
            public void run() {
                countdown_2--;
                if (countdown_2 == 0){
                    Main.plugin.getServer().dispatchCommand(Main.plugin.getServer().getConsoleSender(), "ban " + player.getName());
                    Bukkit.getScheduler().cancelTask(count_2);
                    countdown_2 = 1;
                }
            }
        },0l, 20l);
    }

    public static void Finish(Player player){
        Bukkit.broadcastMessage("§aGoo");
        Random random = new Random();

        Player randomPlayer = (Player) Bukkit.getOnlinePlayers().toArray()[new Random().nextInt(Bukkit.getOnlinePlayers().size())];

        randomPlayer.sendTitle("§aBuddy van Ryan", randomPlayer.getDisplayName());

        Move.Moveing = false;

        Player Ryan = Bukkit.getServer().getPlayer("henRYANand");

        if (Ryan.isOnline()){
            randomPlayer.teleport(Ryan);
        } else {
            player.sendMessage("§cRyan is niet online!");
        }
    }
}
