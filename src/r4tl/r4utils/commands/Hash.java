package r4tl.r4utils.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class Hash implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
		if(!(s instanceof Player)) return false;
		
		Player p = (Player) s;
		ItemStack is = p.getInventory().getItemInMainHand();
		if(is == null) return false;
		
		ItemMeta im = is.getItemMeta();
		if(im == null) return false;
		
		List<String> lore = im.getLore();
		if(lore == null) lore = new ArrayList<String>();
		String hashStr = getHashString(p);
		if(!lore.contains(hashStr)) {
			lore.add(hashStr);
			Collections.sort(lore);
			im.setLore(lore);
			is.setItemMeta(im);
		}
		
		return true;
	}
	
	public static int getHash(Player p) {
		return p.getUniqueId().hashCode();
	}
	
	public static String getHashString(Player p) {
		return ChatColor.WHITE + "Hash: " + ChatColor.BOLD + ChatColor.DARK_RED + getHash(p);
	}

}
