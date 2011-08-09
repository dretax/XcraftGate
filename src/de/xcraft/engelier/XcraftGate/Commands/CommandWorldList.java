package de.xcraft.engelier.XcraftGate.Commands;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import de.xcraft.engelier.XcraftGate.XcraftGate;
import de.xcraft.engelier.XcraftGate.XcraftGateWorld;

public class CommandWorldList extends CommandHelperWorld {

	public CommandWorldList(XcraftGate plugin) {
		super(plugin);
	}

	@Override
	public void execute(CommandSender sender, String worldName, List<String> args) {
		this.sender = sender;
		
		String worlds = "";
		for (XcraftGateWorld thisWorld : plugin.worlds.values()) {
			worlds += ", " + thisWorld.name;
			if (plugin.getServer().getWorld(thisWorld.name) != null) {
				worlds += "(*)";
			}
		}
		reply("Worlds: " + ChatColor.WHITE + worlds.substring(2));
		reply("World marked with (*) are currently active on the server.");
	}

}
