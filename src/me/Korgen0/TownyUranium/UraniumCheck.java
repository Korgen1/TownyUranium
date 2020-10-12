package me.Korgen0.TownyUranium;

import com.palmergames.bukkit.towny.object.TownBlock;
import com.palmergames.bukkit.towny.object.TownyWorld;
import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.utils.CombatUtil;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class UraniumCheck implements Listener{

	@EventHandler
	public void OnItemDrop(PlayerDropItemEvent event) {
		Player p = event.getPlayer();
			if(event.getItemDrop().getItemStack().getItemMeta().hasDisplayName() == true) {
				if(event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + "Uranium") || event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.RED + "Small Chunk of Uranium") || event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Nether Ice") || event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Enriched Nether Ice") || event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Blistering Ingot") || event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Blistering Ingot" + ChatColor.GRAY +"(33%)") || event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Blistering Ingot" + ChatColor.GRAY +"(66%)") || event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Neptunium") || event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.GRAY + "Plutonium") || event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN + "Boosted Uranium")) {
					if (TownyAPI.getInstance().isWilderness(p.getLocation())) {
						return;
					}
					TownBlock tb = TownyAPI.getInstance().getTownBlock(p.getLocation());
					if(CombatUtil.preventPvP(tb.getWorld(), tb) == true) {
						event.setCancelled(true);
						p.sendMessage(ChatColor.RED + "You are not allowed to drop this while PvP is disabled!");
				}
			}
		}	
	}
}
	

