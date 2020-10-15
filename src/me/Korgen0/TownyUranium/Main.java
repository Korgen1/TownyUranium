package me.Korgen0.TownyUranium;




import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;



public class Main extends JavaPlugin{
	
	@Override
		public void onEnable() {
		
		getServer().getPluginManager().registerEvents(new UraniumCheck(), this);
		
		
	}
	
	@Override
	public void onDisable() {
		
		
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("tuversion")) {
			if (sender instanceof Player) {
				//player, dont do anything
				return true;
			}
			else {
				//console
				sender.sendMessage(ChatColor.RED + "Towny Uranium version 1.0.4 by Korgen0");
				return true;
			}
		}
		
		
		return false;
	}
}
