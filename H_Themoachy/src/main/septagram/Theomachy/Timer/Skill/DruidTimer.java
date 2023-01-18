package septagram.Theomachy.Timer.Skill;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.TreeType;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.type.Sapling;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import septagram.Theomachy.Utility.Sounds;

public class DruidTimer extends BukkitRunnable
{
	Player player;
	private int duration;
	private int XZ_distance;
	private int Y_distance;
	private int locX;
	private int locY;
	private int locZ;
	
	public DruidTimer(Player player, int duration, int XZ_distance, int Y_distance)
	{
		this.player=player;
		this.duration=duration;
		this.XZ_distance=XZ_distance;
		this.Y_distance=Y_distance;
		this.locX=player.getLocation().getBlockX();
		this.locY=player.getLocation().getBlockY();
		this.locZ=player.getLocation().getBlockZ();
	}
	
	public void run()
	{
		if(duration <= 0) {
			this.cancel();
		}
		else if(duration <= 5) {
			player.sendMessage("남은 지속시간 : " + duration + "초");
		}
		try{
			locX=player.getLocation().getBlockX();
			locY=player.getLocation().getBlockY();
			locZ=player.getLocation().getBlockZ();
			for(int x = (XZ_distance*-1); x <= XZ_distance; x++) {
				for(int y = (Y_distance*-1); y <= Y_distance; y++) {
					for(int z = (XZ_distance*-1); z <= XZ_distance; z++) {
						Location BlockLoc = new Location(player.getWorld(), locX+x, locY+y, locZ+z);
						Block getblock = player.getWorld().getBlockAt(BlockLoc);
						if(getblock.getType()!=null||getblock.getType()!=Material.AIR) {
							if(getblock.getBlockData() instanceof Ageable) {
								Ageable blockage = (Ageable) getblock.getBlockData();
								if(blockage.getAge()<blockage.getMaximumAge()) {
									blockage.setAge(blockage.getAge()+1);
									player.getWorld().getBlockAt(BlockLoc).setBlockData(blockage);
									player.getWorld().spawnParticle(Particle.TOTEM, getblock.getLocation(), 2);
								}
							}
							if(getblock.getBlockData() instanceof Sapling) {
								Random r = new Random();
								if(r.nextInt(8)==0) {
									player.getWorld().getBlockAt(BlockLoc).setType(Material.AIR);
									player.getWorld().generateTree(BlockLoc, TreeType.TREE);
								}
								player.getWorld().spawnParticle(Particle.TOTEM, getblock.getLocation(), 2);
							}
						}
					}
				}
			}
			Sounds.SoundP(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.3f, 1.8f);
		}
		catch (Exception e)
		{
		}
		duration--;
		
	}
}
