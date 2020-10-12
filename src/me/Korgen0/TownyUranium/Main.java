package me.Korgen0.TownyUranium;




import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;



public class Main extends JavaPlugin{
	
	@Override
		public void onEnable() {
		//run on startup / reloads
		
		getServer().getPluginManager().registerEvents(new UraniumCheck(), this);
		
		
	}
	
	@Override
	public void onDisable() {
		//runs on shutdowns / reloads / disabled
		
		
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("tuversion")) {
			if (sender instanceof Player) {
				//player
				Player player = (Player) sender;
				player.sendMessage(ChatColor.RED + "Towny Uranium version" + ChatColor.AQUA + " 1.0.1 " + ChatColor.RED + "by" + ChatColor.AQUA +" Korgen0");
				return true;
			}
			else {
				//console
				sender.sendMessage(ChatColor.RED + "Towny Uranium version 1.0.1 by Korgen0");
				return true;
			}
		}
		
		
		return false;
	}
}
