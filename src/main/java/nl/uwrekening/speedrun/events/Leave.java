package nl.uwrekening.speedrun.events;

import nl.uwrekening.speedrun.data.Joined_Data;
import nl.uwrekening.speedrun.data.PlayerData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Leave implements Listener {

    @EventHandler
    public void OnLeave(PlayerQuitEvent e){
        Joined_Data.resetJoined(e.getPlayer());
    }

}
