package com.ho_bot.CNM.Var;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.ho_bot.CNM.Utility.MsgUtil;

public class ItemVar
{
	public static ItemStack WoolItem()
    {
        ItemStack itemi = new ItemStack(Material.WHITE_DYE);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName(ChatColor.GOLD + "[Àç·á] " + ChatColor.WHITE + "¼Ø");
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack TreeItem()
    {
        ItemStack itemi = new ItemStack(Material.WHITE_DYE);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName(ChatColor.GOLD + "[Àç·á] " + ChatColor.WHITE + "¸ñÀç");
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack StoneItem()
    {
        ItemStack itemi = new ItemStack(Material.WHITE_DYE);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName(ChatColor.GOLD + "[Àç·á] " + ChatColor.WHITE + "±¤¼®");
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack SnowItem()
    {
        ItemStack itemi = new ItemStack(Material.WHITE_DYE);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName(ChatColor.GOLD + "[Àç·á] " + ChatColor.WHITE + "´«");
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack BigGuyGuiItem(Player player)
    {
        ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName(ChatColor.WHITE + "ºò°¡ÀÌ");
        itemmm.setLore(MsgUtil.ColorVarMsg(JobVar.BigGuy_Des, ChatColor.GRAY));
        if(TeamVar.Player_Team.containsKey(player.getUniqueId()) && JobVar.TeamJobList.containsKey(TeamVar.Player_Team.get(player.getUniqueId())))
        {
            HashMap joblist = (HashMap)JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
            if(joblist != null && joblist.containsValue("\uBE45\uAC00\uC774"))
            {
                UUID JobP = null;
                for(Iterator iterator = joblist.entrySet().iterator(); iterator.hasNext();)
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                    if(((String)entry.getValue()).equals("\uBE45\uAC00\uC774"))
                        JobP = (UUID)entry.getKey();
                }

                Player jobplayer = Bukkit.getPlayer(JobP);
                List lore = new ArrayList();
                String s;
                for(String s : itemmm.getLore()) {
                    lore.add(s);
                }
                lore.add("");
                lore.add((new StringBuilder()).append(ChatColor.GRAY).append(jobplayer.getName()).append("\uB2D8\uC774 \uB2A5\uB825\uC744 \uC120\uD0DD\uD588\uC2B5\uB2C8\uB2E4").toString());
                itemmm.setLore(lore);
            }
        }
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack CruiseGuiItem(Player player)
    {
        ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName((new StringBuilder()).append(ChatColor.WHITE).append("\uD06C\uB8E8\uC2A4").toString());
        itemmm.setLore(MsgUtil.ColorVarMsg(JobVar.Cruise_Des, ChatColor.GRAY));
        if(TeamVar.Player_Team.containsKey(player.getUniqueId()) && JobVar.TeamJobList.containsKey(TeamVar.Player_Team.get(player.getUniqueId())))
        {
            HashMap joblist = (HashMap)JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
            if(joblist != null && joblist.containsValue("\uD06C\uB8E8\uC2A4"))
            {
                UUID JobP = null;
                for(Iterator iterator = joblist.entrySet().iterator(); iterator.hasNext();)
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                    if(((String)entry.getValue()).equals("\uD06C\uB8E8\uC2A4"))
                        JobP = (UUID)entry.getKey();
                }

                Player jobplayer = Bukkit.getPlayer(JobP);
                List lore = new ArrayList();
                String s;
                for(Iterator iterator1 = itemmm.getLore().iterator(); iterator1.hasNext(); lore.add(s))
                    s = (String)iterator1.next();

                lore.add((new StringBuilder()).append(ChatColor.GRAY).append(jobplayer.getName()).append("\uB2D8\uC774 \uB2A5\uB825\uC744 \uC120\uD0DD\uD588\uC2B5\uB2C8\uB2E4").toString());
                itemmm.setLore(lore);
            }
        }
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack EgisGuiItem(Player player)
    {
        ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName((new StringBuilder()).append(ChatColor.WHITE).append("\uC5D0\uAE30\uC2A4").toString());
        itemmm.setLore(MsgUtil.ColorVarMsg(JobVar.Egis_Des, ChatColor.GRAY));
        if(TeamVar.Player_Team.containsKey(player.getUniqueId()) && JobVar.TeamJobList.containsKey(TeamVar.Player_Team.get(player.getUniqueId())))
        {
            HashMap joblist = (HashMap)JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
            if(joblist != null && joblist.containsValue("\uC5D0\uAE30\uC2A4"))
            {
                UUID JobP = null;
                for(Iterator iterator = joblist.entrySet().iterator(); iterator.hasNext();)
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                    if(((String)entry.getValue()).equals("\uC5D0\uAE30\uC2A4"))
                        JobP = (UUID)entry.getKey();
                }

                Player jobplayer = Bukkit.getPlayer(JobP);
                List lore = new ArrayList();
                String s;
                for(Iterator iterator1 = itemmm.getLore().iterator(); iterator1.hasNext(); lore.add(s))
                    s = (String)iterator1.next();

                lore.add((new StringBuilder()).append(ChatColor.GRAY).append(jobplayer.getName()).append("\uB2D8\uC774 \uB2A5\uB825\uC744 \uC120\uD0DD\uD588\uC2B5\uB2C8\uB2E4").toString());
                itemmm.setLore(lore);
            }
        }
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack PataiGuiItem(Player player)
    {
        ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName((new StringBuilder()).append(ChatColor.WHITE).append("\uD30C\uD0C0\uC774").toString());
        itemmm.setLore(MsgUtil.ColorVarMsg(JobVar.Patai_Des, ChatColor.GRAY));
        if(TeamVar.Player_Team.containsKey(player.getUniqueId()) && JobVar.TeamJobList.containsKey(TeamVar.Player_Team.get(player.getUniqueId())))
        {
            HashMap joblist = (HashMap)JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
            if(joblist != null && joblist.containsValue("\uD30C\uD0C0\uC774"))
            {
                UUID JobP = null;
                for(Iterator iterator = joblist.entrySet().iterator(); iterator.hasNext();)
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                    if(((String)entry.getValue()).equals("\uD30C\uD0C0\uC774"))
                        JobP = (UUID)entry.getKey();
                }

                Player jobplayer = Bukkit.getPlayer(JobP);
                List lore = new ArrayList();
                String s;
                for(Iterator iterator1 = itemmm.getLore().iterator(); iterator1.hasNext(); lore.add(s))
                    s = (String)iterator1.next();

                lore.add((new StringBuilder()).append(ChatColor.GRAY).append(jobplayer.getName()).append("\uB2D8\uC774 \uB2A5\uB825\uC744 \uC120\uD0DD\uD588\uC2B5\uB2C8\uB2E4").toString());
                itemmm.setLore(lore);
            }
        }
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack BomberGuiItem(Player player)
    {
        ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName((new StringBuilder()).append(ChatColor.WHITE).append("\uBD04\uBC84").toString());
        itemmm.setLore(MsgUtil.ColorVarMsg(JobVar.Bomber_Des, ChatColor.GRAY));
        if(TeamVar.Player_Team.containsKey(player.getUniqueId()) && JobVar.TeamJobList.containsKey(TeamVar.Player_Team.get(player.getUniqueId())))
        {
            HashMap joblist = (HashMap)JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
            if(joblist != null && joblist.containsValue("\uBD04\uBC84"))
            {
                UUID JobP = null;
                for(Iterator iterator = joblist.entrySet().iterator(); iterator.hasNext();)
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                    if(((String)entry.getValue()).equals("\uBD04\uBC84"))
                        JobP = (UUID)entry.getKey();
                }

                Player jobplayer = Bukkit.getPlayer(JobP);
                List lore = new ArrayList();
                String s;
                for(Iterator iterator1 = itemmm.getLore().iterator(); iterator1.hasNext(); lore.add(s))
                    s = (String)iterator1.next();

                lore.add((new StringBuilder()).append(ChatColor.GRAY).append(jobplayer.getName()).append("\uB2D8\uC774 \uB2A5\uB825\uC744 \uC120\uD0DD\uD588\uC2B5\uB2C8\uB2E4").toString());
                itemmm.setLore(lore);
            }
        }
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack FasterGuiItem(Player player)
    {
        ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName((new StringBuilder()).append(ChatColor.WHITE).append("\uD398\uC2A4\uD2B8").toString());
        itemmm.setLore(MsgUtil.ColorVarMsg(JobVar.Faster_Des, ChatColor.GRAY));
        if(TeamVar.Player_Team.containsKey(player.getUniqueId()) && JobVar.TeamJobList.containsKey(TeamVar.Player_Team.get(player.getUniqueId())))
        {
            HashMap joblist = (HashMap)JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
            if(joblist != null && joblist.containsValue("\uD398\uC2A4\uD2B8"))
            {
                UUID JobP = null;
                for(Iterator iterator = joblist.entrySet().iterator(); iterator.hasNext();)
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                    if(((String)entry.getValue()).equals("\uD398\uC2A4\uD2B8"))
                        JobP = (UUID)entry.getKey();
                }

                Player jobplayer = Bukkit.getPlayer(JobP);
                List lore = new ArrayList();
                String s;
                for(Iterator iterator1 = itemmm.getLore().iterator(); iterator1.hasNext(); lore.add(s))
                    s = (String)iterator1.next();

                lore.add((new StringBuilder()).append(ChatColor.GRAY).append(jobplayer.getName()).append("\uB2D8\uC774 \uB2A5\uB825\uC744 \uC120\uD0DD\uD588\uC2B5\uB2C8\uB2E4").toString());
                itemmm.setLore(lore);
            }
        }
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack KratosGuiItem(Player player)
    {
        ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName((new StringBuilder()).append(ChatColor.WHITE).append("\uD06C\uB77C\uD1A0\uC2A4").toString());
        itemmm.setLore(MsgUtil.ColorVarMsg(JobVar.Kratos_Des, ChatColor.GRAY));
        if(TeamVar.Player_Team.containsKey(player.getUniqueId()) && JobVar.TeamJobList.containsKey(TeamVar.Player_Team.get(player.getUniqueId())))
        {
            HashMap joblist = (HashMap)JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
            if(joblist != null && joblist.containsValue("\uD06C\uB77C\uD1A0\uC2A4"))
            {
                UUID JobP = null;
                for(Iterator iterator = joblist.entrySet().iterator(); iterator.hasNext();)
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                    if(((String)entry.getValue()).equals("\uD06C\uB77C\uD1A0\uC2A4"))
                        JobP = (UUID)entry.getKey();
                }

                Player jobplayer = Bukkit.getPlayer(JobP);
                List lore = new ArrayList();
                String s;
                for(Iterator iterator1 = itemmm.getLore().iterator(); iterator1.hasNext(); lore.add(s))
                    s = (String)iterator1.next();

                lore.add((new StringBuilder()).append(ChatColor.GRAY).append(jobplayer.getName()).append("\uB2D8\uC774 \uB2A5\uB825\uC744 \uC120\uD0DD\uD588\uC2B5\uB2C8\uB2E4").toString());
                itemmm.setLore(lore);
            }
        }
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack SaluranGuiItem(Player player)
    {
        ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName((new StringBuilder()).append(ChatColor.WHITE).append("\uC0B4\uB8E8\uB780").toString());
        itemmm.setLore(MsgUtil.ColorVarMsg(JobVar.Saluran_Des, ChatColor.GRAY));
        if(TeamVar.Player_Team.containsKey(player.getUniqueId()) && JobVar.TeamJobList.containsKey(TeamVar.Player_Team.get(player.getUniqueId())))
        {
            HashMap joblist = (HashMap)JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
            if(joblist != null && joblist.containsValue("\uC0B4\uB8E8\uB780"))
            {
                UUID JobP = null;
                for(Iterator iterator = joblist.entrySet().iterator(); iterator.hasNext();)
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                    if(((String)entry.getValue()).equals("\uC0B4\uB8E8\uB780"))
                        JobP = (UUID)entry.getKey();
                }

                Player jobplayer = Bukkit.getPlayer(JobP);
                List lore = new ArrayList();
                String s;
                for(Iterator iterator1 = itemmm.getLore().iterator(); iterator1.hasNext(); lore.add(s))
                    s = (String)iterator1.next();

                lore.add((new StringBuilder()).append(ChatColor.GRAY).append(jobplayer.getName()).append("\uB2D8\uC774 \uB2A5\uB825\uC744 \uC120\uD0DD\uD588\uC2B5\uB2C8\uB2E4").toString());
                itemmm.setLore(lore);
            }
        }
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack PaladinGuiItem(Player player)
    {
        ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName((new StringBuilder()).append(ChatColor.WHITE).append("\uD314\uB77C\uB518").toString());
        itemmm.setLore(MsgUtil.ColorVarMsg(JobVar.Paladin_Des, ChatColor.GRAY));
        if(TeamVar.Player_Team.containsKey(player.getUniqueId()) && JobVar.TeamJobList.containsKey(TeamVar.Player_Team.get(player.getUniqueId())))
        {
            HashMap joblist = (HashMap)JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
            if(joblist != null && joblist.containsValue("\uD314\uB77C\uB518"))
            {
                UUID JobP = null;
                for(Iterator iterator = joblist.entrySet().iterator(); iterator.hasNext();)
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                    if(((String)entry.getValue()).equals("\uD314\uB77C\uB518"))
                        JobP = (UUID)entry.getKey();
                }

                Player jobplayer = Bukkit.getPlayer(JobP);
                List lore = new ArrayList();
                String s;
                for(Iterator iterator1 = itemmm.getLore().iterator(); iterator1.hasNext(); lore.add(s))
                    s = (String)iterator1.next();

                lore.add((new StringBuilder()).append(ChatColor.GRAY).append(jobplayer.getName()).append("\uB2D8\uC774 \uB2A5\uB825\uC744 \uC120\uD0DD\uD588\uC2B5\uB2C8\uB2E4").toString());
                itemmm.setLore(lore);
            }
        }
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack PemanahGuiItem(Player player)
    {
        ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName((new StringBuilder()).append(ChatColor.WHITE).append("\uD398\uBAA8\uB098").toString());
        itemmm.setLore(MsgUtil.ColorVarMsg(JobVar.Pemanah_Des, ChatColor.GRAY));
        if(TeamVar.Player_Team.containsKey(player.getUniqueId()) && JobVar.TeamJobList.containsKey(TeamVar.Player_Team.get(player.getUniqueId())))
        {
            HashMap joblist = (HashMap)JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
            if(joblist != null && joblist.containsValue("\uD398\uBAA8\uB098"))
            {
                UUID JobP = null;
                for(Iterator iterator = joblist.entrySet().iterator(); iterator.hasNext();)
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                    if(((String)entry.getValue()).equals("\uD398\uBAA8\uB098"))
                        JobP = (UUID)entry.getKey();
                }

                Player jobplayer = Bukkit.getPlayer(JobP);
                List lore = new ArrayList();
                String s;
                for(Iterator iterator1 = itemmm.getLore().iterator(); iterator1.hasNext(); lore.add(s))
                    s = (String)iterator1.next();

                lore.add((new StringBuilder()).append(ChatColor.GRAY).append(jobplayer.getName()).append("\uB2D8\uC774 \uB2A5\uB825\uC744 \uC120\uD0DD\uD588\uC2B5\uB2C8\uB2E4").toString());
                itemmm.setLore(lore);
            }
        }
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack ZoukGuiItem(Player player)
    {
        ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName((new StringBuilder()).append(ChatColor.WHITE).append("\uC8FC\uD06C").toString());
        itemmm.setLore(MsgUtil.ColorVarMsg(JobVar.Zouk_Des, ChatColor.GRAY));
        if(TeamVar.Player_Team.containsKey(player.getUniqueId()) && JobVar.TeamJobList.containsKey(TeamVar.Player_Team.get(player.getUniqueId())))
        {
            HashMap joblist = (HashMap)JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
            if(joblist != null && joblist.containsValue("\uC8FC\uD06C"))
            {
                UUID JobP = null;
                for(Iterator iterator = joblist.entrySet().iterator(); iterator.hasNext();)
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                    if(((String)entry.getValue()).equals("\uC8FC\uD06C"))
                        JobP = (UUID)entry.getKey();
                }

                Player jobplayer = Bukkit.getPlayer(JobP);
                List lore = new ArrayList();
                String s;
                for(Iterator iterator1 = itemmm.getLore().iterator(); iterator1.hasNext(); lore.add(s))
                    s = (String)iterator1.next();

                lore.add((new StringBuilder()).append(ChatColor.GRAY).append(jobplayer.getName()).append("\uB2D8\uC774 \uB2A5\uB825\uC744 \uC120\uD0DD\uD588\uC2B5\uB2C8\uB2E4").toString());
                itemmm.setLore(lore);
            }
        }
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack[] BigGuyJobItem(Player player)
    {
        ItemStack Weapon = new ItemStack(Material.BLAZE_ROD);
        ItemMeta Weapon_M = Weapon.getItemMeta();
        AttributeModifier Weapon_A = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", 4D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        Weapon_M.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, Weapon_A);
        Weapon_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uBE45\uAC00\uC774").toString());
        Weapon.setItemMeta(Weapon_M);
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta Helmet_M = Helmet.getItemMeta();
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1.0D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Helmet_A);
        Helmet_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uD22C\uAD6C").toString());
        Helmet.setItemMeta(Helmet_M);
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uAC11\uC637").toString());
        Chestplate.setItemMeta(Chestplate_M);
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uD558\uC758").toString());
        Leggings.setItemMeta(Leggings_M);
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.10000000000000001D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uC2E0\uBC1C").toString());
        Boots.setItemMeta(Boots_M);
        ItemStack itemlist[] = {
            Weapon, Helmet, Chestplate, Leggings, Boots
        };
        return itemlist;
    }

    public static ItemStack[] CruiseJobItem(Player player)
    {
        ItemStack Weapon = new ItemStack(Material.BLAZE_ROD);
        ItemMeta Weapon_M = Weapon.getItemMeta();
        AttributeModifier Weapon_A = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", 4D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        Weapon_M.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, Weapon_A);
        Weapon_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uD06C\uB8E8\uC2A4").toString());
        Weapon.setItemMeta(Weapon_M);
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta Helmet_M = Helmet.getItemMeta();
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1.0D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Helmet_A);
        Helmet_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uD22C\uAD6C").toString());
        Helmet.setItemMeta(Helmet_M);
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uAC11\uC637").toString());
        Chestplate.setItemMeta(Chestplate_M);
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uD558\uC758").toString());
        Leggings.setItemMeta(Leggings_M);
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.10000000000000001D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uC2E0\uBC1C").toString());
        Boots.setItemMeta(Boots_M);
        ItemStack itemlist[] = {
            Weapon, Helmet, Chestplate, Leggings, Boots
        };
        return itemlist;
    }

    public static ItemStack[] EgisJobItem(Player player)
    {
        ItemStack Weapon = new ItemStack(Material.BLAZE_ROD);
        ItemMeta Weapon_M = Weapon.getItemMeta();
        AttributeModifier Weapon_A = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", 4D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        Weapon_M.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, Weapon_A);
        Weapon_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uC5D0\uAE30\uC2A4").toString());
        Weapon.setItemMeta(Weapon_M);
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta Helmet_M = Helmet.getItemMeta();
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1.0D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Helmet_A);
        Helmet_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uD22C\uAD6C").toString());
        Helmet.setItemMeta(Helmet_M);
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uAC11\uC637").toString());
        Chestplate.setItemMeta(Chestplate_M);
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uD558\uC758").toString());
        Leggings.setItemMeta(Leggings_M);
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.10000000000000001D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uC2E0\uBC1C").toString());
        Boots.setItemMeta(Boots_M);
        ItemStack itemlist[] = {
            Weapon, Helmet, Chestplate, Leggings, Boots
        };
        return itemlist;
    }

    public static ItemStack[] PataiJobItem(Player player)
    {
        ItemStack Weapon = new ItemStack(Material.BLAZE_ROD);
        ItemMeta Weapon_M = Weapon.getItemMeta();
        AttributeModifier Weapon_A = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", 4D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        Weapon_M.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, Weapon_A);
        Weapon_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uD30C\uD0C0\uC774").toString());
        Weapon.setItemMeta(Weapon_M);
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta Helmet_M = Helmet.getItemMeta();
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1.0D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Helmet_A);
        Helmet_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uD22C\uAD6C").toString());
        Helmet.setItemMeta(Helmet_M);
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uAC11\uC637").toString());
        Chestplate.setItemMeta(Chestplate_M);
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uD558\uC758").toString());
        Leggings.setItemMeta(Leggings_M);
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.10000000000000001D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uC2E0\uBC1C").toString());
        Boots.setItemMeta(Boots_M);
        ItemStack itemlist[] = {
            Weapon, Helmet, Chestplate, Leggings, Boots
        };
        return itemlist;
    }

    public static ItemStack[] BomberJobItem(Player player)
    {
        ItemStack Weapon = new ItemStack(Material.BLAZE_ROD);
        ItemMeta Weapon_M = Weapon.getItemMeta();
        AttributeModifier Weapon_A = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", 4D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        Weapon_M.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, Weapon_A);
        Weapon_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uBD04\uBC84").toString());
        Weapon.setItemMeta(Weapon_M);
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta Helmet_M = Helmet.getItemMeta();
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1.0D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Helmet_A);
        Helmet_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uD22C\uAD6C").toString());
        Helmet.setItemMeta(Helmet_M);
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uAC11\uC637").toString());
        Chestplate.setItemMeta(Chestplate_M);
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uD558\uC758").toString());
        Leggings.setItemMeta(Leggings_M);
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.10000000000000001D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uC2E0\uBC1C").toString());
        Boots.setItemMeta(Boots_M);
        ItemStack itemlist[] = {
            Weapon, Helmet, Chestplate, Leggings, Boots
        };
        return itemlist;
    }

    public static ItemStack[] FasterJobItem(Player player)
    {
        ItemStack Weapon = new ItemStack(Material.BLAZE_ROD);
        ItemMeta Weapon_M = Weapon.getItemMeta();
        AttributeModifier Weapon_A = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", 4D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        Weapon_M.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, Weapon_A);
        Weapon_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uD398\uC2A4\uD2B8").toString());
        Weapon.setItemMeta(Weapon_M);
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta Helmet_M = Helmet.getItemMeta();
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1.0D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Helmet_A);
        Helmet_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uD22C\uAD6C").toString());
        Helmet.setItemMeta(Helmet_M);
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uAC11\uC637").toString());
        Chestplate.setItemMeta(Chestplate_M);
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uD558\uC758").toString());
        Leggings.setItemMeta(Leggings_M);
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.10000000000000001D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uC2E0\uBC1C").toString());
        Boots.setItemMeta(Boots_M);
        ItemStack itemlist[] = {
            Weapon, Helmet, Chestplate, Leggings, Boots
        };
        return itemlist;
    }

    public static ItemStack[] KratosJobItem(Player player)
    {
        ItemStack Weapon = new ItemStack(Material.BLAZE_ROD);
        ItemMeta Weapon_M = Weapon.getItemMeta();
        AttributeModifier Weapon_A = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", 4D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        Weapon_M.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, Weapon_A);
        Weapon_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uD06C\uB77C\uD1A0\uC2A4").toString());
        Weapon.setItemMeta(Weapon_M);
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta Helmet_M = Helmet.getItemMeta();
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1.0D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Helmet_A);
        Helmet_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uD22C\uAD6C").toString());
        Helmet.setItemMeta(Helmet_M);
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uAC11\uC637").toString());
        Chestplate.setItemMeta(Chestplate_M);
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uD558\uC758").toString());
        Leggings.setItemMeta(Leggings_M);
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.10000000000000001D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uC2E0\uBC1C").toString());
        Boots.setItemMeta(Boots_M);
        ItemStack itemlist[] = {
            Weapon, Helmet, Chestplate, Leggings, Boots
        };
        return itemlist;
    }

    public static ItemStack[] SaluranJobItem(Player player)
    {
        ItemStack Weapon = new ItemStack(Material.BLAZE_ROD);
        ItemMeta Weapon_M = Weapon.getItemMeta();
        AttributeModifier Weapon_A = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", 4D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        Weapon_M.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, Weapon_A);
        Weapon_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uC0B4\uB8E8\uB780").toString());
        Weapon.setItemMeta(Weapon_M);
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta Helmet_M = Helmet.getItemMeta();
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1.0D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Helmet_A);
        Helmet_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uD22C\uAD6C").toString());
        Helmet.setItemMeta(Helmet_M);
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uAC11\uC637").toString());
        Chestplate.setItemMeta(Chestplate_M);
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uD558\uC758").toString());
        Leggings.setItemMeta(Leggings_M);
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.10000000000000001D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uC2E0\uBC1C").toString());
        Boots.setItemMeta(Boots_M);
        ItemStack itemlist[] = {
            Weapon, Helmet, Chestplate, Leggings, Boots
        };
        return itemlist;
    }

    public static ItemStack[] PaladinJobItem(Player player)
    {
        ItemStack Weapon = new ItemStack(Material.BLAZE_ROD);
        ItemMeta Weapon_M = Weapon.getItemMeta();
        AttributeModifier Weapon_A = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", 4D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        Weapon_M.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, Weapon_A);
        Weapon_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uD314\uB77C\uB518").toString());
        Weapon.setItemMeta(Weapon_M);
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta Helmet_M = Helmet.getItemMeta();
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1.0D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Helmet_A);
        Helmet_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uD22C\uAD6C").toString());
        Helmet.setItemMeta(Helmet_M);
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uAC11\uC637").toString());
        Chestplate.setItemMeta(Chestplate_M);
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uD558\uC758").toString());
        Leggings.setItemMeta(Leggings_M);
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.10000000000000001D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uC2E0\uBC1C").toString());
        Boots.setItemMeta(Boots_M);
        ItemStack itemlist[] = {
            Weapon, Helmet, Chestplate, Leggings, Boots
        };
        return itemlist;
    }

    public static ItemStack[] PemanahJobItem(Player player)
    {
        ItemStack Weapon = new ItemStack(Material.BLAZE_ROD);
        ItemMeta Weapon_M = Weapon.getItemMeta();
        AttributeModifier Weapon_A = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", 4D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        Weapon_M.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, Weapon_A);
        Weapon_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uD398\uBAA8\uB098").toString());
        Weapon.setItemMeta(Weapon_M);
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta Helmet_M = Helmet.getItemMeta();
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1.0D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Helmet_A);
        Helmet_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uD22C\uAD6C").toString());
        Helmet.setItemMeta(Helmet_M);
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uAC11\uC637").toString());
        Chestplate.setItemMeta(Chestplate_M);
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uD558\uC758").toString());
        Leggings.setItemMeta(Leggings_M);
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.10000000000000001D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uC2E0\uBC1C").toString());
        Boots.setItemMeta(Boots_M);
        ItemStack itemlist[] = {
            Weapon, Helmet, Chestplate, Leggings, Boots
        };
        return itemlist;
    }

    public static ItemStack[] ZoukJobItem(Player player)
    {
        ItemStack Weapon = new ItemStack(Material.BLAZE_ROD);
        ItemMeta Weapon_M = Weapon.getItemMeta();
        AttributeModifier Weapon_A = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", 4D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        Weapon_M.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, Weapon_A);
        Weapon_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uC8FC\uD06C").toString());
        Weapon.setItemMeta(Weapon_M);
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta Helmet_M = Helmet.getItemMeta();
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1.0D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Helmet_A);
        Helmet_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uD22C\uAD6C").toString());
        Helmet.setItemMeta(Helmet_M);
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uAC11\uC637").toString());
        Chestplate.setItemMeta(Chestplate_M);
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uD558\uC758").toString());
        Leggings.setItemMeta(Leggings_M);
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.10000000000000001D, org.bukkit.attribute.AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName((new StringBuilder(String.valueOf(WordVar.XM))).append("\uC2E0\uBC1C").toString());
        Boots.setItemMeta(Boots_M);
        ItemStack itemlist[] = {
            Weapon, Helmet, Chestplate, Leggings, Boots
        };
        return itemlist;
    }
}
