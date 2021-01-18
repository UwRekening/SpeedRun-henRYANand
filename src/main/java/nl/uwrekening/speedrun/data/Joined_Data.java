package nl.uwrekening.speedrun.data;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class Joined_Data {

    public static boolean getJoined(Player p, boolean Joined){
        File f = PlayerData.getPlayerDataFile(p);
        YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
        return Boolean.parseBoolean(config.get("Joined", Joined).toString());
    }
    public static void setJoined(Player p, boolean Joined){
        File f = PlayerData.getPlayerDataFile(p);
        YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
        config.set("Joined", Joined);
        try {
            config.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void resetJoined(Player p){
        File f = PlayerData.getPlayerDataFile(p);
        YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
        config.set("Joined", true);
        try {
            config.save(f);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
