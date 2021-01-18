package nl.uwrekening.speedrun.commands;

import nl.uwrekening.speedrun.data.Joined_Data;
import nl.uwrekening.speedrun.events.Join;
import nl.uwrekening.speedrun.time.CountDown;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Collection;
import java.util.Random;

public class SpeedRun implements CommandExecutor {

    public static int players_10 = 10;
    public static int players = 0;
    public static int playersIn;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (args.length == 0){
            if (players == 10) {
                player.sendMessage("Yo de speedrun is vol!");
            } else {
                if (Joined_Data.getJoined(player, true) == false){
                    player.sendMessage("§lJe bent al gejoint, wacht even tot dat ryan de game start...");
                } else {
                    if (player.getName().contains("henRYANand")){
                        player.sendMessage("§lYo ryan je bent gejoint pog, als alle spelers klaar zijn kan je /speedrun start doen! succses");
                        Location tpl = null;

                        Random random = new Random();

                        int x = random.nextInt(1000);
                        int y = 150;
                        int z = random.nextInt(1000);
                        playersIn = random.nextInt(10);

                        boolean IsOnLand = false;

                        while (IsOnLand == false){

                            tpl = new Location(player.getWorld(), x, y, z);

                            if (tpl.getBlock().getType() != Material.AIR){
                                IsOnLand = true;
                            } else y--;

                        }
                        player.teleport(new Location(player.getWorld(), tpl.getX(), tpl.getY(), tpl.getZ()));
                        Joined_Data.setJoined(player, false);

                        Collection<PotionEffect> pe = player.getActivePotionEffects();
                        for (PotionEffect effect : pe){
                            if (effect.getType().equals(PotionEffectType.JUMP) || effect.getType().equals(PotionEffectType.HEAL)){
                                player.removePotionEffect(PotionEffectType.JUMP);
                                player.removePotionEffect(PotionEffectType.HEAL);
                            }
                        }
                        player.setHealthScale(40);
                        player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 10, 4));

                    } else {
                        player.sendMessage("§lJe bent SpeedRun gejoint, wacht even tot dat ryan de game start...");
                        Location tpl = null;

                        Random random = new Random();

                        int x = random.nextInt(1000);
                        int y = 150;
                        int z = random.nextInt(1000);
                        playersIn = random.nextInt(10);

                        boolean IsOnLand = false;

                        while (IsOnLand == false){

                            tpl = new Location(player.getWorld(), x, y, z);

                            if (tpl.getBlock().getType() != Material.AIR){
                                IsOnLand = true;
                            } else y--;

                        }
                        player.teleport(new Location(player.getWorld(), tpl.getX(), tpl.getY(), tpl.getZ()));

                        players++;
                        player.getLocation().getWorld().setTime(1000);

                        player.setGameMode(GameMode.ADVENTURE);
                        player.setFoodLevel(20);
                        player.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1000000, 250, true, false));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000000, 250, true, false));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 15, 250, true, false));
                        player.setWalkSpeed(0);
                        Joined_Data.setJoined(player, false);
                    }
                }
            }
        }
        if (args.length == 1){
            if (args[0].equalsIgnoreCase("start")){
                if (player.hasPermission("speedrun.start")){
                    CountDown.CountDown(player);
                    CountDown.countdown = 61;
                    Join.RandomTp = false;
                }
            }
        }
        return true;
    }
}
