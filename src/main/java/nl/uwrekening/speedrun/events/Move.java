package nl.uwrekening.speedrun.events;

import nl.uwrekening.speedrun.time.CountDown;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Collection;

public class Move implements Listener {

    public static boolean Moveing = true;


    @EventHandler
    public void OnPlayerMove(PlayerMoveEvent e){
        Player player = e.getPlayer();


        if (!Moveing){
            player.setGameMode(GameMode.SURVIVAL);
            player.setWalkSpeed(0.2f);
            Collection<PotionEffect> pe = player.getActivePotionEffects();
            Moveing = true;
            for (PotionEffect effect : pe){
                if (effect.getType().equals(PotionEffectType.JUMP) || effect.getType().equals(PotionEffectType.HEAL)){
                    player.removePotionEffect(PotionEffectType.JUMP);
                    player.removePotionEffect(PotionEffectType.HEAL);
                }
            }
        }
    }

}
