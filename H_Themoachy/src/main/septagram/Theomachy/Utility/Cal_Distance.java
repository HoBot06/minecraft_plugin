package septagram.Theomachy.Utility;

import org.bukkit.Location;

public class Cal_Distance {
	public static float GetFloatDistance(Location point, Location another) {
		float distance = (float) (Math.pow(Math.abs(point.getX()) - Math.abs(another.getX()), 2) + Math.pow(Math.abs(point.getY()) - Math.abs(another.getY()), 2) + Math.pow(Math.abs(point.getZ()) - Math.abs(another.getZ()), 2));
		return (float) Math.sqrt(distance);
	}
}
