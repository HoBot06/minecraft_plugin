// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CNM_Event.java

package com.ho_bot.CNM.Event;

import com.ho_bot.CNM.Gui.JobSelect;
import com.ho_bot.CNM.Job.Job;
import com.ho_bot.CNM.Main;
import com.ho_bot.CNM.Event.Job.BigGuyEvent;
import com.ho_bot.CNM.NPC.JobSelectNPC;
import com.ho_bot.CNM.Utility.DamageUtil;
import com.ho_bot.CNM.Var.*;
import com.ho_bot.CNM.mat.MatGiveEvent;

import java.util.*;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xyz.haoshoku.nick.api.NickAPI;

public class CNM_Event
    implements Listener
{

    public CNM_Event()
    {
        MGE = new MatGiveEvent();
    }

    public static void setPlugin(Main MainPlugin)
    {
        plugin = MainPlugin;
    }

    public void onChat(PlayerChatEvent event)
    {
        Player player = event.getPlayer();
        if(TeamVar.Player_Team.containsKey(player.getUniqueId()))
        {
            event.setCancelled(true);
            for(Iterator iterator = Bukkit.getOnlinePlayers().iterator(); iterator.hasNext();)
            {
                Player each_p = (Player)iterator.next();
                if(((String)TeamVar.Player_Team.get(player.getUniqueId())).equals(TeamVar.Player_Team.get(each_p.getUniqueId())))
                    each_p.sendMessage((new StringBuilder(String.valueOf(TeamVar.TeamShowName_Get((String)TeamVar.Player_Team.get(player.getUniqueId()))))).append(player.getName()).append(ChatColor.WHITE).append(" : ").append(event.getMessage()).toString());
            }

        }
    }

    public void onJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        if(TeamVar.Player_Team.containsKey(player.getUniqueId()))
        {
            String TeamCustomName = chmain.getConfig().getString((new StringBuilder(String.valueOf((String)TeamVar.Player_Team.get(player.getUniqueId())))).append(".").append("\uD300\uD45C\uC2DC\uC774\uB984").toString());
            NickAPI.nick(player, (new StringBuilder(String.valueOf(TeamCustomName))).append(player.getName()).toString());
            NickAPI.refreshPlayer(player);
        }
    }

    public void onLeave(PlayerQuitEvent event)
    {
        String CapName;
        for(Iterator iterator = EtcVar.CapNameList.iterator(); iterator.hasNext(); EtcVar.RemoveNowCap(CapName, event.getPlayer()))
            CapName = (String)iterator.next();

    }

    public void PlayerInteractEvent(PlayerInteractEvent event)
    {
        Action action = event.getAction();
        Player player = event.getPlayer();
        if(event.getHand() == EquipmentSlot.HAND)
        {
            if(action == Action.LEFT_CLICK_BLOCK)
            {
                if(EtcVar.isPos1.containsKey(player.getUniqueId()) && ((Boolean)EtcVar.isPos1.get(player.getUniqueId())).booleanValue())
                {
                    EtcVar.isPos1.put(player.getUniqueId(), Boolean.valueOf(false));
                    Location pb_loc = event.getClickedBlock().getLocation();
                    EtcVar.Pos1.put(player.getUniqueId(), pb_loc);
                    player.sendMessage((new StringBuilder("[POS1] X : ")).append(pb_loc.getX()).append(" Y : ").append(pb_loc.getY()).append(" Z : ").append(pb_loc.getZ()).toString());
                    event.setCancelled(true);
                }
                if(EtcVar.isPos2.containsKey(player.getUniqueId()) && ((Boolean)EtcVar.isPos2.get(player.getUniqueId())).booleanValue())
                {
                    EtcVar.isPos2.put(player.getUniqueId(), Boolean.valueOf(false));
                    Location pb_loc = event.getClickedBlock().getLocation();
                    EtcVar.Pos2.put(player.getUniqueId(), pb_loc);
                    player.sendMessage((new StringBuilder("[POS2] X : ")).append(pb_loc.getX()).append(" Y : ").append(pb_loc.getY()).append(" Z : ").append(pb_loc.getZ()).toString());
                    event.setCancelled(true);
                }
            }
            Job job = (Job)JobVar.Job_Player.get(player.getUniqueId());
            if(job != null)
                job.T_Active(event);
        }
    }

    public void PlayerInteractEntityEvent(PlayerInteractEntityEvent event)
    {
        Entity entity = event.getRightClicked();
        Player player = event.getPlayer();
        if(event.getHand() == EquipmentSlot.HAND && (entity instanceof Player) && entity.getCustomName() != null && entity.getCustomName().equalsIgnoreCase("\uB2A5\uB825\uC120\uD0DDNPC"))
            JobSelectNPC.JobSelectNPC_Click(event);
    }

    public void InventoryClickEvent(InventoryClickEvent event)
    {
        JobSelect.JobSelectEvent(event);
        if(event.getCurrentItem() != null && event.getCurrentItem().getType() != Material.AIR && event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().getDisplayName().contains(WordVar.XM))
            event.setCancelled(true);
    }

    public void onShear(PlayerShearEntityEvent event)
    {
        MGE.WoolEvent(event);
    }

    public void onEntityDrop(EntityDropItemEvent event)
    {
        MGE.WoolEvent(event);
    }

    public void onBreak(BlockBreakEvent event)
    {
        MGE.TreeEvent(event);
        MGE.StoneEvent(event);
        MGE.SnowEvent(event);
    }

    public void onDamageEntity(EntityDamageEvent event)
    {
        if((event.getEntity() instanceof Player) && event.getCause() == org.bukkit.event.entity.EntityDamageEvent.DamageCause.FALL)
            event.setCancelled(true);
    }

    public void onDamage(EntityDamageByEntityEvent event)
    {
        DamageUtil.PlayerDamageEntity(event);
        BigGuyEvent.onDamage(event);
        if(event.getEntity() instanceof Player)
        {
            Player player = (Player)event.getEntity();
            Job job = (Job)JobVar.Job_Player.get(player.getUniqueId());
            if(job != null)
                job.T_Passive(event);
        }
        if(event.getDamager() instanceof Player)
        {
            Player attacker = (Player)event.getDamager();
            Job job = (Job)JobVar.Job_Player.get(attacker.getUniqueId());
            if(job != null)
                job.T_Passive(event);
        }
    }

    public void onMove(PlayerMoveEvent event)
    {
        Player player = event.getPlayer();
        Job job = (Job)JobVar.Job_Player.get(player.getUniqueId());
        if(job != null)
            job.T_Passive(event);
    }

    public void onShoot(ProjectileLaunchEvent event)
    {
        if(event.getEntity().getShooter() instanceof Player)
        {
            Player player = (Player)event.getEntity().getShooter();
            Job job = (Job)JobVar.Job_Player.get(player.getUniqueId());
            if(job != null)
                job.T_Passive(event);
        }
    }

    public void onShootHit(ProjectileHitEvent event)
    {
        if(event.getEntity().getShooter() instanceof Player)
        {
            Player player = (Player)event.getEntity().getShooter();
            Job job = (Job)JobVar.Job_Player.get(player.getUniqueId());
            if(job != null)
                job.T_Passive(event);
        }
    }

    public MatGiveEvent MGE;
    public static Main plugin;
    static Main chmain = (Main)Main.getPlugin(com/ho_bot/CNM/Main);

}
