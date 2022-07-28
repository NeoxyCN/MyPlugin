package myplugin.helloworld;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import  org.bukkit.command.CommandSender;
import  javax.annotation.ParametersAreNonnullByDefault;

public class HelloWorld extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Hello, world!");
        //Bukkit.getPluginManager().registerEvents(new EventProcessor(),this);

        if(Bukkit.getPluginCommand("superkill")!=null){
            Bukkit.getPluginCommand("superkill").setExecutor(new Commander());
        }

    }

    public class Commander implements CommandExecutor {
        @Override
        @ParametersAreNonnullByDefault
        public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
            if(args.length==0){
                return false;
            }
            Player player=Bukkit.getPlayer(args[0]);
            if(player==null){
                return true;
            }
            player.setHealth(0);
            return true;
        }
    }
    public class EventProcessor implements Listener {
        @EventHandler
        public void donotMove(PlayerMoveEvent e) {
            double distance = e.getFrom().distance(e.getTo());
            if (distance != 0) {
                e.setCancelled(true);
            }
        }

    }
}