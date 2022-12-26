package septagram.Theomachy.Utility;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

public class Particles {
	
	public static void particleP(Particle particle, Location loc, Player player, int count, double X_spread, double Y_spread, double Z_spread) {
		player.spawnParticle(particle, loc, count, X_spread, Y_spread, Z_spread);
	}
	
	public static void particleL(Particle particle, Location loc, Player player, int count, double X_spread, double Y_spread, double Z_spread) {
		player.getWorld().spawnParticle(particle, loc, count, X_spread, Y_spread, Z_spread);
	}

}
