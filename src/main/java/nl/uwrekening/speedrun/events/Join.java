package nl.uwrekening.speedrun.events;

import nl.uwrekening.speedrun.data.PlayerData;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class Join implements Listener {

    public static boolean RandomTp = true;

    @EventHandler
    public void OnJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        e.setJoinMessage("§a" + player.getName() + " joint SpeedRun");

        if (!PlayerData.existsPlayerData(player)){
            PlayerData.createPlayerData(player);
        }

        if (Death.death = true){
            if (RandomTp = false){
                Location tpl = null;

                Random random = new Random();

                int x = random.nextInt(1000);
                int y = 150;
                int z = random.nextInt(1000);

                boolean IsOnLand = false;

                while (IsOnLand == false){

                    tpl = new Location(player.getWorld(), x, y, z);

                    if (tpl.getBlock().getType() != Material.AIR){
                        IsOnLand = true;
                    } else y--;

                }
                player.teleport(new Location(player.getWorld(), tpl.getX(), tpl.getY(), tpl.getZ()));

                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 2));
            }
        }
    }
}
