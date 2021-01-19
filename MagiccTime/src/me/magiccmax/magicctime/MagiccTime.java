package me.magiccmax.magicctime;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.magiccmax.magicctime.command.CheckTimeCommand;
import me.magiccmax.magicctime.core.JoinEventListener;
import me.magiccmax.magicctime.core.LeaveEventListener;

public class MagiccTime extends JavaPlugin{
	
	public static MagiccTime instance;
	public Logger logger;
	public File storage;
	public Map<Player, Long> timeMap = new HashMap<Player, Long>();
	
	@Override
	public void onEnable() {
		this.logger = this.getServer().getLogger();
		instance = this;
		getServer().getPluginManager().registerEvents(new JoinEventListener(), MagiccTime.instance);
		getServer().getPluginManager().registerEvents(new LeaveEventListener(), MagiccTime.instance);
		this.getCommand("playtime").setExecutor(new CheckTimeCommand());
		File dir = new File("./plugins/MagiccMax/MagiccTime/playtimes");
		if(!dir.exists()) {
			dir.mkdirs();
		}
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
	}
	

}
