package me.Korgen0.TownyUranium;

import com.palmergames.bukkit.towny.object.TownBlock;
import com.palmergames.bukkit.towny.object.TownyWorld;
import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.utils.CombatUtil;

import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactive;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import net.minecraft.server.v1_16_R2.BlockBase.e;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.meta.ItemMeta;

public class UraniumCheck implements Listener{

	
	@EventHandler 
	public void OnItemDrop(PlayerDropItemEvent event) {
		Player p = event.getPlayer();
		if (SlimefunItem.getByItem(event.getItemDrop().getItemStack()) != null) {
			if (SlimefunItem.getByItem(event.getItemDrop().getItemStack()) instanceof Radioactive) {
				if (TownyAPI.getInstance().isWilderness(p.getLocation())) {
					return;
				}
				TownBlock tb = TownyAPI.getInstance().getTownBlock(p.getLocation());
				if(CombatUtil.preventPvP(tb.getWorld(), tb) == true) {
					//event.setCancelled(true);
					//p.sendMessage(ChatColor.RED + "You are not allowed to drop this while PvP is disabled!");
					if(!p.hasPermission("tu.bypassdrop")) {
						ItemMeta meta = event.getItemDrop().getItemStack().getItemMeta();
						meta.setLore(Arrays.asList(ChatColor.COLOR_CHAR + p.getUniqueId().toString()));
						event.getItemDrop().getItemStack().setItemMeta(meta);
					}
				}
			}
		}
	}
	
	
	@EventHandler
	public void OnItemPickup(EntityPickupItemEvent e) {
		if (e.getEntityType() == EntityType.PLAYER) {
			Player p = Bukkit.getPlayer(e.getEntity().getName());
			if (SlimefunItem.getByItem(e.getItem().getItemStack()) != null) {
				if (SlimefunItem.getByItem(e.getItem().getItemStack()) instanceof Radioactive) {
					if (TownyAPI.getInstance().isWilderness(p.getLocation())) {
						return;
					}
					TownBlock tb = TownyAPI.getInstance().getTownBlock(p.getLocation());
					if(CombatUtil.preventPvP(tb.getWorld(), tb) == true) {
						if (e.getItem().getItemStack().hasItemMeta()) {
							if(!p.hasPermission("tu.bypasspickup")) {
								ItemMeta meta = e.getItem().getItemStack().getItemMeta();
								if(meta.hasLore()) {
									if(meta.getLore().equals(Arrays.asList(ChatColor.COLOR_CHAR + p.getUniqueId().toString()))) {
										ItemMeta me = SlimefunItem.getByItem(e.getItem().getItemStack()).getItem().getItemMeta();
										e.getItem().getItemStack().setItemMeta(me);
									}
									else {
										e.setCancelled(true);
									}
								}
							} else {
								ItemMeta me = SlimefunItem.getByItem(e.getItem().getItemStack()).getItem().getItemMeta();
								e.getItem().getItemStack().setItemMeta(me);
							}
						}
					}
				}
			}
		}
	}
}
	

