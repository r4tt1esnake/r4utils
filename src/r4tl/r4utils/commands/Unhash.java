package r4tl.r4utils.commands;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Unhash implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
		if(!(s instanceof Player)) return false;
		
		Player p = (Player) s;
		ItemStack is = p.getInventory().getItemInMainHand();
		if(is == null) return false;
		
		ItemMeta im = is.getItemMeta();
		if(im == null) return false;
		
		List<String> lstr = im.getLore();
		if(lstr == null) return false;
		String hashStr = Hash.getHashString(p);
		for(int i = 0; i < lstr.size(); i++) {
			if(lstr.get(i).equals(hashStr)) {
				lstr.remove(i);
				break;
			}
		}
		
		im.setLore(lstr);
		is.setItemMeta(im);
		
		return true;
	}

}
