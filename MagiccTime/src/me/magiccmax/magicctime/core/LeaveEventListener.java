package me.magiccmax.magicctime.core;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.magiccmax.magicctime.MagiccTime;

public class LeaveEventListener implements Listener{
	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event) {
		this.save(event.getPlayer());
	}
	
	public void save(Player player) {
		
		File dir = new File("./plugins/MagiccMax/MagiccTime/cplaytimes");
		if(!dir.exists()) {
			dir.mkdirs();
		}
		File pFile = new File("./plugins/MagiccMax/MagiccTime/playtimes/" + player.getUniqueId() + ".dat");
		if(!pFile.exists()) {
			try {
				pFile.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				DataOutputStream os = new DataOutputStream(new FileOutputStream(pFile));
				os.writeLong(((long) System.currentTimeMillis()) - MagiccTime.instance.timeMap.remove(player));
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			long already = 0;
			try {
				DataInputStream os = new DataInputStream(new FileInputStream(pFile));
				already = os.readLong();
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				DataOutputStream os = new DataOutputStream(new FileOutputStream(pFile));
				os.writeLong(((long) System.currentTimeMillis()) - MagiccTime.instance.timeMap.remove(player) + already);
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
