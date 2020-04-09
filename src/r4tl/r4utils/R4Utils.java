package r4tl.r4utils;

import org.bukkit.plugin.java.JavaPlugin;

import r4tl.r4utils.commands.DiceRoll;
import r4tl.r4utils.commands.Hash;

public class R4Utils extends JavaPlugin {
	
	@Override
	public void onEnable() {
		this.getCommand("hash").setExecutor(new Hash());
		this.getCommand("roll").setExecutor(new DiceRoll());
	}
	
	@Override
	public void onDisable() {
		
	}

}
