package com.ho_bot.CNM.Tools;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Print_Effect
{
    public static void CircleParticle(Particle particle, Location loc, int radius, int count, double offsetX, double offsetY, double offsetZ, double speed)
    {
        for(int d = 0; d <= 100; d++)
        {
            float x = radius * (float)Math.sin(d);
            float z = radius * (float)Math.cos(d);
            loc.getWorld().spawnParticle(particle, new Location(loc.getWorld(), loc.getX() + x, loc.getY(), loc.getZ() + z), count, offsetX, offsetY, offsetZ, speed);
        }

    }

    public static void ParticleSpawn(Particle particle, Location loc, int count, double xOffset, double yOffset, double zOffset, double speed)
    {
        loc.getWorld().spawnParticle(particle, loc, count, xOffset, yOffset, zOffset, speed);
    }

    public static void Loc_Sound(Sound sound, Location loc, float volume, float pitch)
    {
        loc.getWorld().playSound(loc, sound, volume, pitch);
    }

    public static void P_Sound(Sound sound, Player player, float volume, float pitch)
    {
        player.playSound(player.getLocation(), sound, volume, pitch);
    }
}
