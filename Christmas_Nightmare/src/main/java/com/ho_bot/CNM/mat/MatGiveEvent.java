// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MatGiveEvent.java

package com.ho_bot.CNM.mat;

import com.ho_bot.CNM.Var.ItemVar;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class MatGiveEvent
{

    public MatGiveEvent()
    {
    }

    public void WoolEvent(PlayerShearEntityEvent event)
    {
        int amo = event.getItem().getAmount();
        ItemStack wool_item = ItemVar.WoolItem();
        wool_item.setAmount(amo);
        if(event.getEntity().getType() == EntityType.SHEEP)
        {
            event.getItem().setType(Material.AIR);
            event.getPlayer().getInventory().addItem(new ItemStack[] {
                wool_item
            });
        }
    }

    public void WoolEvent(EntityDropItemEvent event)
    {
        if(event.getEntity().getType() == EntityType.SHEEP)
            event.setCancelled(true);
    }

    public void TreeEvent(BlockBreakEvent event)
    {
        if(Tag.LOGS.isTagged(event.getBlock().getType()))
        {
            event.setCancelled(true);
            ItemStack tree = ItemVar.TreeItem();
            tree.setAmount(1);
            event.getPlayer().getInventory().addItem(new ItemStack[] {
                tree
            });
        }
    }

    public void StoneEvent(BlockBreakEvent event)
    {
        if(event.getBlock().getType() == Material.STONE)
        {
            event.setCancelled(true);
            ItemStack stone = ItemVar.StoneItem();
            stone.setAmount(1);
            event.getPlayer().getInventory().addItem(new ItemStack[] {
                stone
            });
        }
    }

    public void SnowEvent(BlockBreakEvent event)
    {
        if(event.getBlock().getType() == Material.SNOW || event.getBlock().getType() == Material.SNOW_BLOCK)
        {
            event.setDropItems(false);
            ItemStack snow = ItemVar.SnowItem();
            snow.setAmount(1);
            event.getPlayer().getInventory().addItem(new ItemStack[] {
                snow
            });
        }
    }
}
