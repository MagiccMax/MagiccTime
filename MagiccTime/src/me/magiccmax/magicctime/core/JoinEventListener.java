package me.magiccmax.magicctime.core;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.magiccmax.magicctime.MagiccTime;

public class JoinEventListener implements Listener{
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		MagiccTime.instance.timeMap.put(event.getPlayer(), System.currentTimeMillis());
		MagiccTime.instance.getServer().getLogger().info("Player" + event.getPlayer() + "logged in at " + System.currentTimeMillis());
	}

}
