package com.ho_bot.CNM.mat;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.inventory.ItemStack;

import com.ho_bot.CNM.Var.ItemVar;
import com.ho_bot.CNM.Var.TeamVar;

public class MatGiveEvent
{
    public void WoolEvent(PlayerShearEntityEvent event)
    {
        int amo = event.getItem().getAmount();
        ItemStack wool_item = ItemVar.WoolItem();
        wool_item.setAmount(amo);
        if(event.getEntity().getType() == EntityType.SHEEP)
        {
            event.getItem().setType(Material.AIR);
            event.getPlayer().getInventory().addItem(wool_item);
            RandomGivePoint(event.getPlayer());
        }
    }

    public void WoolEvent(EntityDropItemEvent event)
    {
        if(event.getEntity().getType() == EntityType.SHEEP) {
            event.setCancelled(true);
        }
    }

    public void TreeEvent(BlockBreakEvent event)
    {
        if(Tag.LOGS.isTagged(event.getBlock().getType()))
        {
            event.setCancelled(true);
            ItemStack tree = ItemVar.TreeItem();
            tree.setAmount(1);
            event.getPlayer().getInventory().addItem(tree);
            RandomGivePoint(event.getPlayer());
        }
    }

    public void StoneEvent(BlockBreakEvent event)
    {
        if(Tag.BASE_STONE_OVERWORLD.isTagged(event.getBlock().getType()))
        {
        	event.setCancelled(true);
            ItemStack stone = ItemVar.StoneItem();
            stone.setAmount(1);
            event.getPlayer().getInventory().addItem(stone);
            RandomGivePoint(event.getPlayer());
        }
    }

    public void SnowEvent(BlockBreakEvent event)
    {
        if(event.getBlock().getType() == Material.SNOW || event.getBlock().getType() == Material.SNOW_BLOCK)
        {
        	event.setCancelled(true);
            ItemStack snow = ItemVar.SnowItem();
            snow.setAmount(1);
            event.getPlayer().getInventory().addItem(snow);
            RandomGivePoint(event.getPlayer());
        }
    }
    
    private void RandomGivePoint(Player player) {
    	Random r = new Random();
    	if(r.nextInt(10)==0) {
    		if(TeamVar.Player_Team.containsKey(player.getUniqueId())) {
    			String team = TeamVar.Player_Team.get(player.getUniqueId());
    			int point = TeamVar.Team_JobUpPoint.get(team);
    			point++;
    			TeamVar.Team_JobUpPoint.put(team, point);
    			player.sendMessage("연구포인트를 획득했습니다");
    		}
    	}
    }
}
