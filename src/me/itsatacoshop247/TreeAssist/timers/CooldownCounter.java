package me.itsatacoshop247.TreeAssist.timers;

import me.itsatacoshop247.TreeAssist.core.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CooldownCounter extends BukkitRunnable {
	private final String name;
	private int seconds;
	public CooldownCounter(Player player, int seconds) {

		name = player.getName();
		this.seconds = seconds;
	}

	@Override
	public void run() {
		if (--seconds <= 0) {
			commit();
			try {
				this.cancel();
			} catch (IllegalStateException e) {
				
			}
		}
	}
	
	private void commit() {

		Utils.plugin.removeCountDown(name);
		Player player = Bukkit.getPlayer(name);
		if (player != null) {
			player.sendMessage(ChatColor.GREEN + "TreeAssist cooled down!");
		}
	}

	public int getSeconds() {
		return seconds;
	}

}
