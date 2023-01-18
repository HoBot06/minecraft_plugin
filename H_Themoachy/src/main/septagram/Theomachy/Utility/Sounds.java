package septagram.Theomachy.Utility;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Sounds {
	
	public static void SoundP(Player player, org.bukkit.Sound sound, float volume, float pitch) {
		player.playSound(player.getLocation(), sound, volume, pitch);
	}

	public static void SoundPL(Player player, Location loc, org.bukkit.Sound sound, float volume, float pitch) {
		player.playSound(loc, sound, volume, pitch);
	}

}
