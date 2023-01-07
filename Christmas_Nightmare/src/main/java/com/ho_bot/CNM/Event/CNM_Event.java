package com.ho_bot.CNM.Event;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;

import com.ho_bot.CNM.Main;
import com.ho_bot.CNM.Event.Job.BigGuyEvent;
import com.ho_bot.CNM.Gui.JobSelect;
import com.ho_bot.CNM.Gui.Science;
import com.ho_bot.CNM.Job.Job;
import com.ho_bot.CNM.NPC.JobSelectNPC;
import com.ho_bot.CNM.NPC.ScienceNPC;
import com.ho_bot.CNM.Utility.DamageUtil;
import com.ho_bot.CNM.Var.EtcVar;
import com.ho_bot.CNM.Var.JobVar;
import com.ho_bot.CNM.Var.TeamVar;
import com.ho_bot.CNM.Var.WordVar;
import com.ho_bot.CNM.mat.MatGiveEvent;

import net.md_5.bungee.api.ChatColor;
import xyz.haoshoku.nick.api.NickAPI;

public class CNM_Event implements Listener
{
	public MatGiveEvent MGE = new MatGiveEvent();
	public static Main plugin;
	static Main chmain = Main.getPlugin(Main.class);

    public static void setPlugin(Main MainPlugin)
    {
        plugin = MainPlugin;
    }

    @SuppressWarnings("deprecation")
    @EventHandler
	public void onChat(PlayerChatEvent event)
    {
        Player player = event.getPlayer();
        if(TeamVar.Player_Team.containsKey(player.getUniqueId()))
        {
            event.setCancelled(true);
            for(Player each_p : Bukkit.getOnlinePlayers())
            {
                if(TeamVar.Player_Team.get(player.getUniqueId()).equals(TeamVar.Player_Team.get(each_p.getUniqueId()))) {
                    each_p.sendMessage(TeamVar.TeamShowName_Get(TeamVar.Player_Team.get(player.getUniqueId())) + player.getName() + ChatColor.WHITE + " : " + event.getMessage());
                }
            }

        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        if(TeamVar.Player_Team.containsKey(player.getUniqueId()))
        {
            String TeamCustomName = chmain.getConfig().getString((TeamVar.Player_Team.get(player.getUniqueId()) + "." + WordVar.TeamShowName));
            NickAPI.nick(player, TeamCustomName + player.getName());
            NickAPI.refreshPlayer(player);
        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event)
    {
    	for(String CapName : EtcVar.CapNameList) {
    		EtcVar.RemoveNowCap(CapName, event.getPlayer());
    	}
    }

    @EventHandler
    public void PlayerInteractEvent(PlayerInteractEvent event)
    {
        Action action = event.getAction();
        Player player = event.getPlayer();
        if(event.getHand() == EquipmentSlot.HAND)
        {
            if(action == Action.LEFT_CLICK_BLOCK)
            {
                if(EtcVar.isPos1.containsKey(player.getUniqueId())) {
                	if(EtcVar.isPos1.get(player.getUniqueId())) {
                		EtcVar.isPos1.put(player.getUniqueId(), false);
                        Location pb_loc = event.getClickedBlock().getLocation();
                        EtcVar.Pos1.put(player.getUniqueId(), pb_loc);
                        player.sendMessage("[POS1] X : " + pb_loc.getX() + " Y : " + pb_loc.getY() + " Z : " + pb_loc.getZ());
                        event.setCancelled(true);
                	}
                }
                if(EtcVar.isPos2.containsKey(player.getUniqueId())) {
                	if((Boolean)EtcVar.isPos2.get(player.getUniqueId())) {
	                	EtcVar.isPos2.put(player.getUniqueId(), Boolean.valueOf(false));
	                    Location pb_loc = event.getClickedBlock().getLocation();
	                    EtcVar.Pos2.put(player.getUniqueId(), pb_loc);
	                    player.sendMessage("[POS2] X : " + pb_loc.getX() + " Y : " + pb_loc.getY() + " Z : " + pb_loc.getZ());
	                    event.setCancelled(true);
                	}
                }
            }
            Job job = JobVar.Job_Player.get(player.getUniqueId());
            if(job != null) {
                job.T_Active(event);
            }
        }
        if(EtcVar.GameSet) {
        	if(event.getClickedBlock()!=null && event.getClickedBlock().getType() != Material.AIR) {
	        	if(event.getClickedBlock().getType()==Material.CHEST) {
	        		event.setCancelled(true);
	        	}
        	}
        }
    }

    @EventHandler
    public void PlayerInteractEntityEvent(PlayerInteractEntityEvent event)
    {
        Entity entity = event.getRightClicked();
        if(event.getHand() == EquipmentSlot.HAND) {
        	if(entity instanceof Player) {
				if(entity.getCustomName() != null) {
					if(entity.getCustomName().equalsIgnoreCase(WordVar.JobSelectNPC)) {
						JobSelectNPC.JobSelectNPC_Click(event);
					}
					if(entity.getCustomName().equalsIgnoreCase(WordVar.ScienceNPC)) {
						ScienceNPC.ScienceNPC_Click(event);
					}
        		}
        	}
        }
    }
    
    @EventHandler
    public void onChest(InventoryOpenEvent event) {
    	if(EtcVar.GameSet) {
	    	InventoryType invtype = event.getInventory().getType();
	    	if(invtype==InventoryType.WORKBENCH || invtype==InventoryType.CRAFTING || invtype==InventoryType.BEACON) {
	    		event.setCancelled(true);
	    	}
    	}
    }
    
    @EventHandler
    public void InventoryClickEvent(InventoryClickEvent event)
    {
        JobSelect.JobSelectEvent(event);
        Science.ScienceNPCEvent(event);
        Science.JobScienceEvent(event);
        Science.ChoiceNPCEvent(event);
        if(event.getCurrentItem() != null && event.getCurrentItem().getType() != Material.AIR && event.getCurrentItem().hasItemMeta()) {
			if(event.getCurrentItem().getItemMeta().getDisplayName().contains(WordVar.XM)) {
				event.setCancelled(true);
			}
        }
    }

    @EventHandler
    public void onShear(PlayerShearEntityEvent event)
    {
        MGE.WoolEvent(event);
    }

    @EventHandler
    public void onEntityDrop(EntityDropItemEvent event)
    {
        MGE.WoolEvent(event);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event)
    {
        MGE.TreeEvent(event);
        MGE.StoneEvent(event);
        MGE.SnowEvent(event);
        if(EtcVar.GameSet) {
        	event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDamageEntity(EntityDamageEvent event)
    {
        if(event.getEntity() instanceof Player) {
    		if(event.getCause() == EntityDamageEvent.DamageCause.FALL) {
    			event.setCancelled(true);
    		}
        }
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event)
    {
        DamageUtil.PlayerDamageEntity(event);
        BigGuyEvent.onDamage(event);
        if(event.getEntity() instanceof Player)
        {
            Player player = (Player) event.getEntity();
            Job job = JobVar.Job_Player.get(player.getUniqueId());
            if(job != null) {
                job.T_Passive(event);
            }
        }
        if(event.getDamager() instanceof Player)
        {
            Player attacker = (Player) event.getDamager();
            Job job = JobVar.Job_Player.get(attacker.getUniqueId());
            if(job != null) {
                job.T_Passive(event);
            }
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event)
    {
        Player player = event.getPlayer();
        Job job = JobVar.Job_Player.get(player.getUniqueId());
        if(job != null) {
            job.T_Passive(event);
        }
    }

    @EventHandler
    public void onShoot(ProjectileLaunchEvent event)
    {
        if(event.getEntity().getShooter() instanceof Player)
        {
            Player player = (Player) event.getEntity().getShooter();
            Job job = JobVar.Job_Player.get(player.getUniqueId());
            if(job != null) {
                job.T_Passive(event);
            }
        }
    }

    @EventHandler
    public void onShootHit(ProjectileHitEvent event)
    {
        if(event.getEntity().getShooter() instanceof Player)
        {
            Player player = (Player) event.getEntity().getShooter();
            Job job = JobVar.Job_Player.get(player.getUniqueId());
            if(job != null) {
                job.T_Passive(event);
            }
        }
    }
    
    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
    	if(EtcVar.GameSet) {
    		event.setCancelled(true);
    	}
    }
}
