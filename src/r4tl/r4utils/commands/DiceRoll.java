package r4tl.r4utils.commands;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class DiceRoll implements CommandExecutor {

	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player || sender instanceof ConsoleCommandSender)) return false;
        int n = 1, f = 6;
        if(args.length > 0) {
        	try {
        		f = Integer.parseInt(args[0]);
        	} catch (NumberFormatException e) {
        		return false;
        	}
        	if(args.length > 1) {
        		try {
        			n = Integer.parseInt(args[1]);
        		} catch (NumberFormatException e) {
            		return false;
            	}
        	}
        }
        if(!(n > 0 && f > 0)) return false;
        int[] rolls = roll(f, n);
        String str = ChatColor.GOLD + "Roll result of " + ChatColor.DARK_RED + n + ChatColor.GOLD + " number of " + ChatColor.DARK_RED + f + ChatColor.GOLD + "-sided die: ";
        for(int i = 0; i < n; i++) {
        	str += ("" + ChatColor.GREEN + rolls[i] + " ");
        }
        Bukkit.broadcastMessage(str);
        return true;
    }
	
	private int[] roll(int f, int n) {
		int[] rolls = new int[n];
		Random generator = new Random(System.currentTimeMillis());
		for(int i = 0; i < n; i++) {
			rolls[i] = generator.nextInt(f) + 1;
		}
		return rolls;
    }

}
