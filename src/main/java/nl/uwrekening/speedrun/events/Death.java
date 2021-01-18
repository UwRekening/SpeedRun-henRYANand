package nl.uwrekening.speedrun.events;

import nl.uwrekening.speedrun.Main;
import nl.uwrekening.speedrun.commands.SpeedRun;
import nl.uwrekening.speedrun.data.Joined_Data;
import nl.uwrekening.speedrun.time.CountDown;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Death implements Listener {

    public static boolean death = false;

    @EventHandler
    public void OnDeath(PlayerDeathEvent e){
        Player player = e.getEntity().getPlayer();
        Player player_2 = e.getEntity().getKiller();


        if (Joined_Data.getJoined(player, true) == false){
            Bukkit.broadcastMessage("§c" + player.getName() + "is gekild door" + player_2.getName());
            death = true;
        }
    }

}
