package r4tl.r4utils;

import org.bukkit.plugin.java.JavaPlugin;

import r4tl.r4utils.commands.DiceRoll;
import r4tl.r4utils.commands.Hash;
import r4tl.r4utils.commands.Unhash;

public class R4Utils extends JavaPlugin {
	
	@Override
	public void onEnable() {
		this.getCommand("hash").setExecutor(new Hash());
		this.getCommand("roll").setExecutor(new DiceRoll());
		this.getCommand("unhash").setExecutor(new Unhash());
	}
	
	@Override
	public void onDisable() {
		
	}

}
