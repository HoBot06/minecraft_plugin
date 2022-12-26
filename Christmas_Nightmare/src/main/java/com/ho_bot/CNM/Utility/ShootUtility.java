// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ShootUtility.java

package com.ho_bot.CNM.Utility;

import com.ho_bot.CNM.Tools.Print_Effect;
import com.ho_bot.CNM.Var.TeamVar;
import java.util.*;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.util.Vector;

// Referenced classes of package com.ho_bot.CNM.Utility:
//            HitBox

public class ShootUtility
{

    public ShootUtility()
    {
    }

    public static void LineShoot(Player player, Particle particle, int distance, float hit_radius, double damage, double xOffset, 
            double yOffset, double zOffset, double speed, int count, 
            Sound sound, float volume, float pitch)
    {
        Location loc = player.getLocation();
        loc.add(0.0D, 1.5D, 0.0D);
label0:
        for(int i = 0; i <= distance; i++)
        {
            loc = loc.add(loc.getDirection().getX(), loc.getDirection().getY(), loc.getDirection().getZ());
            Print_Effect.ParticleSpawn(particle, loc, count, xOffset, yOffset, zOffset, speed);
            for(Iterator iterator = getEntitiesByLocation(loc, hit_radius).iterator(); iterator.hasNext();)
            {
                Entity ent = (Entity)iterator.next();
                if((ent instanceof LivingEntity) && ent.getUniqueId() != player.getUniqueId() && TeamVar.Player_Team.containsKey(ent.getUniqueId()) && !((String)TeamVar.Player_Team.get(ent.getUniqueId())).equals(TeamVar.Player_Team.get(player.getUniqueId())))
                {
                    if(HeadShot(ent, loc))
                    {
                        ((LivingEntity)ent).damage(damage * 2D, player);
                        player.sendMessage("\uD5E4\uB4DC\uC0F7!");
                    } else
                    {
                        ((LivingEntity)ent).damage(damage, player);
                    }
                    break label0;
                }
            }

            if(loc.getBlock().getType().isSolid())
                break;
        }

        Print_Effect.Loc_Sound(sound, player.getLocation(), volume, pitch);
    }

    public static void SpreadShoot(Player player, Particle particle, int distance, float hit_radius, double damage, double xOffset, 
            double yOffset, double zOffset, double speed, int count, 
            Sound sound, float volume, float pitch, int spread)
    {
        Location loc = player.getLocation();
        loc.add(0.0D, 1.5D, 0.0D);
        loc.setPitch(loc.getPitch() + (float)(random.nextInt(spread * 2 + 1) - spread));
        loc.setYaw(loc.getYaw() + (float)(random.nextInt(spread * 2 + 1) - spread));
label0:
        for(int i = 0; i <= distance; i++)
        {
            loc = loc.add(loc.getDirection().getX(), loc.getDirection().getY(), loc.getDirection().getZ());
            Print_Effect.ParticleSpawn(particle, loc, count, xOffset, yOffset, zOffset, speed);
            for(Iterator iterator = getEntitiesByLocation(loc, hit_radius).iterator(); iterator.hasNext();)
            {
                Entity ent = (Entity)iterator.next();
                if((ent instanceof LivingEntity) && ent.getUniqueId() != player.getUniqueId() && TeamVar.Player_Team.containsKey(ent.getUniqueId()) && !((String)TeamVar.Player_Team.get(ent.getUniqueId())).equals(TeamVar.Player_Team.get(player.getUniqueId())))
                {
                    if(HeadShot(ent, loc))
                    {
                        ((LivingEntity)ent).damage(damage * 2D, player);
                        player.sendMessage("\uD5E4\uB4DC\uC0F7!");
                    } else
                    {
                        ((LivingEntity)ent).damage(damage, player);
                    }
                    break label0;
                }
            }

            if(loc.getBlock().getType().isSolid())
                break;
        }

        Print_Effect.Loc_Sound(sound, player.getLocation(), volume, pitch);
    }

    public static void ShootGunSpreadShoot(Player player, Particle particle, int distance, float hit_radius, double damage, double xOffset, 
            double yOffset, double zOffset, double speed, int count, 
            Sound sound, float volume, float pitch, int bullet, int spread)
    {
        for(int bull = 0; bull < bullet; bull++)
        {
            Location loc = player.getLocation();
            loc.add(0.0D, 1.5D, 0.0D);
            loc.setPitch(loc.getPitch() + (float)(random.nextInt(spread * 2 + 1) - spread));
            loc.setYaw(loc.getYaw() + (float)(random.nextInt(spread * 2 + 1) - spread));
label0:
            for(int i = 0; i <= distance; i++)
            {
                loc = loc.add(loc.getDirection().getX(), loc.getDirection().getY(), loc.getDirection().getZ());
                Print_Effect.ParticleSpawn(particle, loc, count, xOffset, yOffset, zOffset, speed);
                for(Iterator iterator = getEntitiesByLocation(loc, hit_radius).iterator(); iterator.hasNext();)
                {
                    Entity ent = (Entity)iterator.next();
                    if((ent instanceof LivingEntity) && ent.getUniqueId() != player.getUniqueId() && TeamVar.Player_Team.containsKey(ent.getUniqueId()) && !((String)TeamVar.Player_Team.get(ent.getUniqueId())).equals(TeamVar.Player_Team.get(player.getUniqueId())))
                    {
                        if(HeadShot(ent, loc))
                        {
                            ((LivingEntity)ent).damage(damage * 2D, player);
                            player.sendMessage("\uD5E4\uB4DC\uC0F7!");
                        } else
                        {
                            ((LivingEntity)ent).damage(damage, player);
                        }
                        break label0;
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
        Snowball snowball = (Snowball)player.getWorld().spawn(player.getLocation().add(0.0D, 1.5D, 0.0D), org/bukkit/entity/Snowball);
        snowball.setShooter(player);
        snowball.setVelocity(vector.multiply(speed));
    }

    private static List getEntitiesByLocation(Location loc, float hit_radius)
    {
        List ent = new ArrayList();
        for(Iterator iterator = loc.getWorld().getEntities().iterator(); iterator.hasNext();)
        {
            Entity e = (Entity)iterator.next();
            HitBox HB = new HitBox(e);
            if(HB.intersects(loc, hit_radius))
                ent.add(e);
        }

        return ent;
    }

    private static boolean HeadShot(Entity entity, Location loc)
    {
        double head = entity.getLocation().getY();
        double hit_loc = loc.getY();
        boolean headshot = hit_loc - head > 1.3500000000000001D;
        return headshot;
    }

    private static Random random = new Random();

}
