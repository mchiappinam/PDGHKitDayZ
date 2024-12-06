package me.mchiappinam.pdghkit;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class Comando implements CommandExecutor, Listener {
	private Main plugin;
	public Comando(Main main) {
		plugin=main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("kit")) {
			if(args.length==0) {
				sendHelp(sender);
				return true;
			}
			if(args[0].equalsIgnoreCase("nb")) {
				if(args.length>1) {
					sender.sendMessage("§3[Ⓚⓘⓣⓢ] §cUse /kit nb");
					return true;
				}
				if (plugin.nb.contains(sender.getName().toLowerCase())) {
					sender.sendMessage("§3[Ⓚⓘⓣⓢ] §cAguarde para pedir esse kit novamente.");
					return true;
				}
				plugin.nb.add(sender.getName().toLowerCase());
				plugin.startTask((Player) sender);
				Kit((Player) sender);
				return true;
			}else if(args[0].equalsIgnoreCase("pvp")) {
				if(args.length>1) {
					sender.sendMessage("§3[Ⓚⓘⓣⓢ] §cUse /kit pvp");
					return true;
				}
				if (plugin.pvp.contains(sender.getName().toLowerCase())) {
					sender.sendMessage("§3[Ⓚⓘⓣⓢ] §cAguarde para pedir esse kit novamente.");
					return true;
				}
				plugin.pvp.add(sender.getName().toLowerCase());
				plugin.startTaskPvP((Player) sender);
				KitPvP((Player) sender);
				return true;
			}else if(args[0].equalsIgnoreCase("vip")) {
				if(args.length>1) {
					sender.sendMessage("§3[Ⓚⓘⓣⓢ] §cUse /kit vip");
					return true;
				}
				if(!sender.hasPermission("pdgh.vip")) {
					sender.sendMessage("§cApenas §6§lVIPs §cpodem usar esse kit.");
					sender.sendMessage("§eAdquira seu §6§lVIP §eem §cwww.pdgh.com.br §ee tenha diversas vantagens.");
					return true;
				}
				if (plugin.vip.contains(sender.getName().toLowerCase())) {
					sender.sendMessage("§3[Ⓚⓘⓣⓢ] §cAguarde o servidor reiniciar para pegar o kit §6§lVIP §cnovamente.");
					return true;
				}
				plugin.vip.add(sender.getName().toLowerCase());
				KitVIP((Player) sender);
				return true;
			}
			sendHelp(sender);
			return true;
		}
		return false;
	}
	
	private void sendHelp(CommandSender sender) {
		sender.sendMessage("§3Ⓚⓘⓣⓢ ⓓⓘⓢⓟⓞⓝⓘⓥⓔⓘⓢ");
		sender.sendMessage("§2/kit nb -§a- Kit para iniciantes.");
		sender.sendMessage("§2/kit pvp -§a- Kit para PvP.");
		if(sender.hasPermission("pdgh.vip"))
			sender.sendMessage("§2/kit vip -§a- Kit para §6§lVIPs§a.");
		else
			sender.sendMessage("§c/kit vip -§a- Kit para §6§lVIPs§a.");
	}
	


	public void Kit(Player p) {
		p.getInventory().addItem(new ItemStack(Material.WOOD_SWORD, 1));
		p.getInventory().addItem(new ItemStack(Material.WOOD_HOE, 1));
		p.getInventory().addItem(new ItemStack(Material.BREAD, 4));
		p.getInventory().addItem(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
		p.getInventory().addItem(new ItemStack(Material.LEATHER_LEGGINGS, 1));
		p.getInventory().addItem(new ItemStack(Material.FLINT, 32));
		p.sendMessage("§eKit nb recebido com sucesso.");
	}

	public void KitVIP(Player p) {
    	p.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD, 1));
    	p.getInventory().addItem(new ItemStack(Material.IRON_HELMET, 1));
    	p.getInventory().addItem(new ItemStack(Material.IRON_CHESTPLATE, 1));
    	p.getInventory().addItem(new ItemStack(Material.IRON_LEGGINGS, 1));
    	p.getInventory().addItem(new ItemStack(Material.IRON_BOOTS, 1));
    	p.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 8));
    	p.getInventory().addItem(new ItemStack(Material.GHAST_TEAR, 24));
    	p.getInventory().addItem(new ItemStack(Material.SEEDS, 64));
    	p.getInventory().addItem(new ItemStack(Material.SEEDS, 64));
    	p.getInventory().addItem(new ItemStack(Material.SEEDS, 64));
    	p.getInventory().addItem(new ItemStack(Material.SEEDS, 64));
    	p.getInventory().addItem(new ItemStack(Material.FLINT, 64));
    	p.getInventory().addItem(new ItemStack(Material.FLINT, 64));
    	p.getInventory().addItem(new ItemStack(Material.GOLD_NUGGET, 32));
    	p.getInventory().addItem(new ItemStack(Material.ROTTEN_FLESH, 32));
    	p.sendMessage("§eKit §6§lVIP §erecebido com sucesso.");
    	p.sendMessage("§eVocê poderá pedir seu kit novamente quando o servidor se reiniciar.");
	}
	
	public void KitPvP(Player p) {
		ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET, 1);
        helmet.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1);
        p.getInventory().addItem(helmet);
        ItemStack chestpl = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        chestpl.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1);
        p.getInventory().addItem(chestpl);
        ItemStack leggings = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
        leggings.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1);
        p.getInventory().addItem(leggings);
        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS, 1);
        boots.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1);
        p.getInventory().addItem(boots);
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
        sword.addEnchantment(Enchantment.DAMAGE_ALL, 2);
        sword.addEnchantment(Enchantment.FIRE_ASPECT, 1);
        p.getInventory().addItem(sword);
        p.getInventory().addItem(new ItemStack(Material.GOLD_AXE, 1));
        p.getInventory().addItem(new ItemStack(Material.IRON_AXE, 1));
        p.getInventory().addItem(new ItemStack(Material.GHAST_TEAR, 64));
        p.getInventory().addItem(new ItemStack(Material.GHAST_TEAR, 64));
        p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP, 25));
        p.getInventory().addItem(new ItemStack(Material.BOWL, 1));
	}
	
}
