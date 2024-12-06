package me.mchiappinam.pdghkit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	final HashMap<String, Integer> taskIDs = new HashMap<String, Integer>();
	final HashMap<String, Integer> taskIDsPvP = new HashMap<String, Integer>();
	List<String> nb = new ArrayList<String>();
	List<String> pvp = new ArrayList<String>();
	List<String> vip = new ArrayList<String>();
	
	@Override
    public void onEnable() {
		getServer().getPluginManager().registerEvents(new Comando(this), this);
		
		getServer().getPluginCommand("kit").setExecutor(new Comando(this));
		
		getServer().getConsoleSender().sendMessage("§3[PDGHKit] §2ativado - Plugin by: mchiappinam");
		getServer().getConsoleSender().sendMessage("§3[PDGHKit] §2Acesse: http://pdgh.net/");
	}
	
	@Override
    public void onDisable() {
		getServer().getConsoleSender().sendMessage("§3[PDGHKit] §2desativado - Plugin by: mchiappinam");
		getServer().getConsoleSender().sendMessage("§3[PDGHKit] §2Acesse: http://pdgh.net/");
    }
	
	public void startTask(final Player p) {
		taskIDs.put(p.getName().toLowerCase(), getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
			public void run() {
		    	nb.remove(p.getName().toLowerCase());
		    	cancelTask(p);
		    }
		}, 5*60*20L));
	}
	
	public void startTaskPvP(final Player p) {
		taskIDsPvP.put(p.getName().toLowerCase(), getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
			public void run() {
		    	pvp.remove(p.getName().toLowerCase());
		    	cancelTaskPvP(p);
		    }
		}, 5*60*20L));
	}
		
	public void cancelTask(Player p) {
		Bukkit.getScheduler().cancelTask(taskIDs.get(p.getName().toLowerCase()));
	}
	
	public void cancelTaskPvP(Player p) {
		Bukkit.getScheduler().cancelTask(taskIDsPvP.get(p.getName().toLowerCase()));
	}
	
	
	
	
	
	
	
	
	
}
