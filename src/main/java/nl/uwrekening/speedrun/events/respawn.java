package nl.uwrekening.speedrun.events;

import nl.uwrekening.speedrun.Main;
import nl.uwrekening.speedrun.time.CountDown;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class respawn implements Listener {

    @EventHandler
    public void OnRespawn(PlayerRespawnEvent e){
        Player player = e.getPlayer();

        if (Death.death = true){
            CountDown.CountDown_2(player);
            Death.death = false;
        }
    }

}
