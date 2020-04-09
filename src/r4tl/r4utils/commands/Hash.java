package r4tl.r4utils.commands;

import java.util.ArrayList;
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
		
		String str = getHash(p) + "";
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.WHITE + "Hash: " + ChatColor.BOLD + ChatColor.DARK_RED + str);
		im.setLore(lore);
		is.setItemMeta(im);
		
		return true;
	}
	
	private int getHash(Player p) {
		return p.getUniqueId().hashCode();
	}

}
