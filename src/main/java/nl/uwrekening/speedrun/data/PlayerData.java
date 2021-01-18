package nl.uwrekening.speedrun.data;

import nl.uwrekening.speedrun.Main;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class PlayerData {

    public static boolean existsPlayerData(Player p){
        File f = new File(Main.plugin.getDataFolder()+"/player-data/",p.getUniqueId().toString()+".ylm");
        if ( f.exists()){
            return true;
        } else {
            return false;
        }
    }

    public static void createPlayerData(Player p){
        if (!existsPlayerData(p)){
            File f = new File(Main.plugin.getDataFolder()+"/player-data/",p.getUniqueId().toString()+".ylm");
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
            config.set("playername", p.getName());
            config.set("Joined", true);
            try {
                config.save(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static File getPlayerDataFile(Player p){
        if (existsPlayerData(p)){
            return new File(Main.plugin.getDataFolder()+"/player-data/",p.getUniqueId().toString()+".ylm");
        } else {
            return null;
        }
    }
}
