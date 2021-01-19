package me.magiccmax.magicctime.command;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.magiccmax.magicctime.MagiccTime;

public class CheckTimeCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arg3) {
		if(sender instanceof Player){
			Player player = (Player) sender;
			player.sendMessage("playtime:" + (System.currentTimeMillis() - MagiccTime.instance.timeMap.get(player)) / 1000);
			player.sendMessage("total playtime" + (System.currentTimeMillis() - MagiccTime.instance.timeMap.get(player) + retrieve(player))/1000);
			return true;
		}
		return false;
	}
	public long retrieve(Player player) {
		File pFile = new File("./plugins/MagiccMax/MagiccTime/playtimes/" + player.getUniqueId() + ".dat");
		try {
			pFile.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		long result = 0;
		try {
			DataInputStream os = new DataInputStream(new FileInputStream(pFile));
			result = os.readLong();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
		
}

}
