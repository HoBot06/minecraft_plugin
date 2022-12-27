package com.ho_bot.CNM.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.util.Vector;

import com.ho_bot.CNM.Tools.Print_Effect;
import com.ho_bot.CNM.Var.TeamVar;

public class ShootUtility
{
	private static Random random = new Random();
	
	public static void LineShoot(Player player, Particle particle, int distance, float hit_radius, double damage,
			double xOffset, double yOffset, double zOffset, double speed, int count, Sound sound, float volume, float pitch)
    {
        Location loc = player.getLocation();
        loc.add(0, 1.5, 0);
        shoot:
        for(int i = 0; i <= distance; i++)
        {
            loc = loc.add(loc.getDirection().getX(), loc.getDirection().getY(), loc.getDirection().getZ());
            Print_Effect.ParticleSpawn(particle, loc, count, xOffset, yOffset, zOffset, speed);
            for(Entity ent : getEntitiesByLocation(loc, hit_radius))
            {
                if((ent instanceof LivingEntity)) {
                	if(ent.getUniqueId() != player.getUniqueId()) {
                		if(TeamVar.Player_Team.containsKey(ent.getUniqueId())) {
                			if(!TeamVar.Player_Team.get(ent.getUniqueId()).equals(TeamVar.Player_Team.get(player.getUniqueId()))) {
                				if(HeadShot(ent, loc))
                                {
                                    ((LivingEntity)ent).damage(damage * 2D, player);
                                    player.sendMessage("Çìµå¼¦!");
                                } else
                                {
                                    ((LivingEntity)ent).damage(damage, player);
                                }
                                break shoot;
                			}
                		}
                	}
                }
            }
            if(loc.getBlock().getType().isSolid()) {
            	break;
            }
        }
        Print_Effect.Loc_Sound(sound, player.getLocation(), volume, pitch);
    }

    public static void SpreadShoot(Player player, Particle particle, int distance, float hit_radius, double damage,
    		double xOffset, double yOffset, double zOffset, double speed, int count, Sound sound, float volume, float pitch, int spread)
    {
        Location loc = player.getLocation();
        loc.add(0, 1.5, 0);
        loc.setPitch(loc.getPitch() + (float)(random.nextInt(spread * 2 + 1) - spread));
        loc.setYaw(loc.getYaw() + (float)(random.nextInt(spread * 2 + 1) - spread));
        shoot:
        for(int i = 0; i <= distance; i++)
        {
            loc = loc.add(loc.getDirection().getX(), loc.getDirection().getY(), loc.getDirection().getZ());
            Print_Effect.ParticleSpawn(particle, loc, count, xOffset, yOffset, zOffset, speed);
            for(Entity ent : getEntitiesByLocation(loc, hit_radius))
            {
                if((ent instanceof LivingEntity)) {
                	if(ent.getUniqueId() != player.getUniqueId()) {
                		if(TeamVar.Player_Team.containsKey(ent.getUniqueId())) {
                			if(!TeamVar.Player_Team.get(ent.getUniqueId()).equals(TeamVar.Player_Team.get(player.getUniqueId()))) {
                				if(HeadShot(ent, loc))
                                {
                                    ((LivingEntity)ent).damage(damage * 2D, player);
                                    player.sendMessage("Çìµå¼¦!");
                                } else
                                {
                                    ((LivingEntity)ent).damage(damage, player);
                                }
                                break shoot;
                			}
                		}
                	}
                }
            }
            if(loc.getBlock().getType().isSolid())
                break;
        }
        Print_Effect.Loc_Sound(sound, player.getLocation(), volume, pitch);
    }

    public static void ShootGunSpreadShoot(Player player, Particle particle, int distance, float hit_radius, double damage,
    		double xOffset, double yOffset, double zOffset, double speed, int count, Sound sound, float volume, float pitch, int bullet, int spread)
    {
        for(int bull = 0; bull < bullet; bull++)
        {
            Location loc = player.getLocation();
            loc.add(0, 1.5, 0);
            loc.setPitch(loc.getPitch() + (float)(random.nextInt(spread * 2 + 1) - spread));
            loc.setYaw(loc.getYaw() + (float)(random.nextInt(spread * 2 + 1) - spread));
            shoot:
            for(int i = 0; i <= distance; i++)
            {
                loc = loc.add(loc.getDirection().getX(), loc.getDirection().getY(), loc.getDirection().getZ());
                Print_Effect.ParticleSpawn(particle, loc, count, xOffset, yOffset, zOffset, speed);
                for(Entity ent : getEntitiesByLocation(loc, hit_radius))
                {
                    if((ent instanceof LivingEntity)) {
                    	if(ent.getUniqueId() != player.getUniqueId()) {
                    		if(TeamVar.Player_Team.containsKey(ent.getUniqueId())) {
                    			if(!TeamVar.Player_Team.get(ent.getUniqueId()).equals(TeamVar.Player_Team.get(player.getUniqueId()))) {
                    				if(HeadShot(ent, loc))
                                    {
                                        ((LivingEntity)ent).damage(damage * 2D, player);
                                        player.sendMessage("Çìµå¼¦!");
                                    } else
                                    {
                                        ((LivingEntity)ent).damage(damage, player);
                                    }
                                    break shoot;
                    			}
                    		}
                    	}
                    }
                }
                if(loc.getBlock().getType().isSolid())
                    break;
            }
        }
        Print_Effect.Loc_Sound(sound, player.getLocation(), volume, pitch);
    }

    public static void SnowShoot(Player player, Vector vector, float speed)
    {
        Snowball snowball = player.getWorld().spawn(player.getLocation().add(0, 1.5, 0), Snowball.class);
        snowball.setShooter(player);
        snowball.setVelocity(vector.multiply(speed));
    }

    private static List<Entity> getEntitiesByLocation(Location loc, float hit_radius)
    {
        List<Entity> ent = new ArrayList<Entity>();
        for(Entity e : loc.getWorld().getEntities())
        {
            HitBox HB = new HitBox(e);
            if(HB.intersects(loc, hit_radius)) {
                ent.add(e);
            }
        }
        return ent;
    }

    private static boolean HeadShot(Entity entity, Location loc)
    {
        double head = entity.getLocation().getY();
        double hit_loc = loc.getY();
        boolean headshot = hit_loc - head > 1.35d;
        return headshot;
    }
    
}
