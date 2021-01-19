package me.magiccmax.magicctime;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.magiccmax.magicctime.command.CheckTimeCommand;
import me.magiccmax.magicctime.core.JoinEventListener;
import me.magiccmax.magicctime.core.LeaveEventListener;

public class MagiccTime extends JavaPlugin{
	
	public static MagiccTime instance;
	public File storage;
	public Map<Player, Long> timeMap = new HashMap<Player, Long>();
	
	@Override
	public void onEnable() {
		getServer().getLogger().info("Loading MagiccTime Plugin");
		// TODO Auto-generated method stub
		super.onEnable();
		
		instance = this;
		
		this.getCommand("playTime").setExecutor(new CheckTimeCommand());
		
		getServer().getPluginManager().registerEvents(new JoinEventListener(), MagiccTime.instance);
		getServer().getPluginManager().registerEvents(new LeaveEventListener(), MagiccTime.instance);
		this.getCommand("playtime").setExecutor(new CheckTimeCommand());
		File dir = new File("./plugins/MagiccMax/MagiccTime/playtimes");
		if(!dir.exists()) {
			dir.mkdirs();
		}
	}
	
	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		super.onDisable();
	}
	

}
