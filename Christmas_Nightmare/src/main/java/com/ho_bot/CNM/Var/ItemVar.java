package com.ho_bot.CNM.Var;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.ho_bot.CNM.Utility.MsgUtil;

public class ItemVar
{
	public static ItemStack WoolItem()
    {
        ItemStack itemi = new ItemStack(Material.WHITE_DYE);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName(ChatColor.GOLD + "[재료] " + ChatColor.WHITE + "솜");
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack TreeItem()
    {
        ItemStack itemi = new ItemStack(Material.WHITE_DYE);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName(ChatColor.GOLD + "[재료] " + ChatColor.WHITE + "목재");
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack StoneItem()
    {
        ItemStack itemi = new ItemStack(Material.WHITE_DYE);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName(ChatColor.GOLD + "[재료] " + ChatColor.WHITE + "광석");
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack SnowItem()
    {
        ItemStack itemi = new ItemStack(Material.WHITE_DYE);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName(ChatColor.GOLD + "[재료] " + ChatColor.WHITE + "눈");
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack BigGuyGuiItem(Player player)
    {
        ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName(ChatColor.WHITE + "빅가이");
        itemmm.setLore(MsgUtil.ColorVarMsg(JobVar.BigGuy_Des, ChatColor.GRAY));
        if(TeamVar.Player_Team.containsKey(player.getUniqueId())) {
        	if(JobVar.TeamJobList.containsKey(TeamVar.Player_Team.get(player.getUniqueId()))) {
        		HashMap<UUID, String> joblist = JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
                if(joblist != null && joblist.containsValue("빅가이"))
                {
                    UUID JobP = null;
                    for(Entry<UUID, String> entry : joblist.entrySet())
                    {
                        if(entry.getValue().equals("빅가이")) {
                        	JobP = entry.getKey();
                        }
                    }

                    Player jobplayer = Bukkit.getPlayer(JobP);
                    List<String> lore = new ArrayList<String>();
                    for(String s : itemmm.getLore()) {
                        lore.add(s);
                    }
                    lore.add("");
                    lore.add(ChatColor.GRAY + jobplayer.getName() + "님이 능력을 선택했습니다");
                    itemmm.setLore(lore);
                }
        	}
        }
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack CruiseGuiItem(Player player)
    {
        ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName(ChatColor.WHITE + "크루스");
        itemmm.setLore(MsgUtil.ColorVarMsg(JobVar.Cruise_Des, ChatColor.GRAY));
        if(TeamVar.Player_Team.containsKey(player.getUniqueId())) {
        	if(JobVar.TeamJobList.containsKey(TeamVar.Player_Team.get(player.getUniqueId()))) {
        		HashMap<UUID, String> joblist = JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
                if(joblist != null && joblist.containsValue("크루스"))
                {
                    UUID JobP = null;
                    for(Entry<UUID, String> entry : joblist.entrySet())
                    {
                        if(entry.getValue().equals("크루스")) {
                        	JobP = entry.getKey();
                        }
                    }

                    Player jobplayer = Bukkit.getPlayer(JobP);
                    List<String> lore = new ArrayList<String>();
                    for(String s : itemmm.getLore()) {
                        lore.add(s);
                    }
                    lore.add("");
                    lore.add(ChatColor.GRAY + jobplayer.getName() + "님이 능력을 선택했습니다");
                    itemmm.setLore(lore);
                }
        	}
        }
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack EgisGuiItem(Player player)
    {
        ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName(ChatColor.WHITE + "에기스");
        itemmm.setLore(MsgUtil.ColorVarMsg(JobVar.Egis_Des, ChatColor.GRAY));
        if(TeamVar.Player_Team.containsKey(player.getUniqueId())) {
        	if(JobVar.TeamJobList.containsKey(TeamVar.Player_Team.get(player.getUniqueId()))) {
        		HashMap<UUID, String> joblist = JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
                if(joblist != null && joblist.containsValue("에기스"))
                {
                    UUID JobP = null;
                    for(Entry<UUID, String> entry : joblist.entrySet())
                    {
                        if(entry.getValue().equals("에기스")) {
                        	JobP = entry.getKey();
                        }
                    }

                    Player jobplayer = Bukkit.getPlayer(JobP);
                    List<String> lore = new ArrayList<String>();
                    for(String s : itemmm.getLore()) {
                        lore.add(s);
                    }
                    lore.add("");
                    lore.add(ChatColor.GRAY + jobplayer.getName() + "님이 능력을 선택했습니다");
                    itemmm.setLore(lore);
                }
        	}
        }
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack PataiGuiItem(Player player)
    {
        ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName(ChatColor.WHITE + "파타이");
        itemmm.setLore(MsgUtil.ColorVarMsg(JobVar.Patai_Des, ChatColor.GRAY));
        if(TeamVar.Player_Team.containsKey(player.getUniqueId())) {
        	if(JobVar.TeamJobList.containsKey(TeamVar.Player_Team.get(player.getUniqueId()))) {
        		HashMap<UUID, String> joblist = JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
                if(joblist != null && joblist.containsValue("파타이"))
                {
                    UUID JobP = null;
                    for(Entry<UUID, String> entry : joblist.entrySet())
                    {
                        if(entry.getValue().equals("파타이")) {
                        	JobP = entry.getKey();
                        }
                    }

                    Player jobplayer = Bukkit.getPlayer(JobP);
                    List<String> lore = new ArrayList<String>();
                    for(String s : itemmm.getLore()) {
                        lore.add(s);
                    }
                    lore.add("");
                    lore.add(ChatColor.GRAY + jobplayer.getName() + "님이 능력을 선택했습니다");
                    itemmm.setLore(lore);
                }
        	}
        }
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack BomberGuiItem(Player player)
    {
        ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName(ChatColor.WHITE + "봄버");
        itemmm.setLore(MsgUtil.ColorVarMsg(JobVar.Bomber_Des, ChatColor.GRAY));
        if(TeamVar.Player_Team.containsKey(player.getUniqueId())) {
        	if(JobVar.TeamJobList.containsKey(TeamVar.Player_Team.get(player.getUniqueId()))) {
        		HashMap<UUID, String> joblist = JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
                if(joblist != null && joblist.containsValue("봄버"))
                {
                    UUID JobP = null;
                    for(Entry<UUID, String> entry : joblist.entrySet())
                    {
                        if(entry.getValue().equals("봄버")) {
                        	JobP = entry.getKey();
                        }
                    }

                    Player jobplayer = Bukkit.getPlayer(JobP);
                    List<String> lore = new ArrayList<String>();
                    for(String s : itemmm.getLore()) {
                        lore.add(s);
                    }
                    lore.add("");
                    lore.add(ChatColor.GRAY + jobplayer.getName() + "님이 능력을 선택했습니다");
                    itemmm.setLore(lore);
                }
        	}
        }
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack FasterGuiItem(Player player)
    {
        ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName(ChatColor.WHITE + "페스트");
        itemmm.setLore(MsgUtil.ColorVarMsg(JobVar.Faster_Des, ChatColor.GRAY));
        if(TeamVar.Player_Team.containsKey(player.getUniqueId())) {
        	if(JobVar.TeamJobList.containsKey(TeamVar.Player_Team.get(player.getUniqueId()))) {
        		HashMap<UUID, String> joblist = JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
                if(joblist != null && joblist.containsValue("페스트"))
                {
                    UUID JobP = null;
                    for(Entry<UUID, String> entry : joblist.entrySet())
                    {
                        if(entry.getValue().equals("페스트")) {
                        	JobP = entry.getKey();
                        }
                    }

                    Player jobplayer = Bukkit.getPlayer(JobP);
                    List<String> lore = new ArrayList<String>();
                    for(String s : itemmm.getLore()) {
                        lore.add(s);
                    }
                    lore.add("");
                    lore.add(ChatColor.GRAY + jobplayer.getName() + "님이 능력을 선택했습니다");
                    itemmm.setLore(lore);
                }
        	}
        }
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack KratosGuiItem(Player player)
    {
        ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName(ChatColor.WHITE + "크라토스");
        itemmm.setLore(MsgUtil.ColorVarMsg(JobVar.Kratos_Des, ChatColor.GRAY));
        if(TeamVar.Player_Team.containsKey(player.getUniqueId())) {
        	if(JobVar.TeamJobList.containsKey(TeamVar.Player_Team.get(player.getUniqueId()))) {
        		HashMap<UUID, String> joblist = JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
                if(joblist != null && joblist.containsValue("크라토스"))
                {
                    UUID JobP = null;
                    for(Entry<UUID, String> entry : joblist.entrySet())
                    {
                        if(entry.getValue().equals("크라토스")) {
                        	JobP = entry.getKey();
                        }
                    }

                    Player jobplayer = Bukkit.getPlayer(JobP);
                    List<String> lore = new ArrayList<String>();
                    for(String s : itemmm.getLore()) {
                        lore.add(s);
                    }
                    lore.add("");
                    lore.add(ChatColor.GRAY + jobplayer.getName() + "님이 능력을 선택했습니다");
                    itemmm.setLore(lore);
                }
        	}
        }
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack SaluranGuiItem(Player player)
    {
        ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName(ChatColor.WHITE + "살루란");
        itemmm.setLore(MsgUtil.ColorVarMsg(JobVar.Saluran_Des, ChatColor.GRAY));
        if(TeamVar.Player_Team.containsKey(player.getUniqueId())) {
        	if(JobVar.TeamJobList.containsKey(TeamVar.Player_Team.get(player.getUniqueId()))) {
        		HashMap<UUID, String> joblist = JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
                if(joblist != null && joblist.containsValue("살루란"))
                {
                    UUID JobP = null;
                    for(Entry<UUID, String> entry : joblist.entrySet())
                    {
                        if(entry.getValue().equals("살루란")) {
                        	JobP = entry.getKey();
                        }
                    }

                    Player jobplayer = Bukkit.getPlayer(JobP);
                    List<String> lore = new ArrayList<String>();
                    for(String s : itemmm.getLore()) {
                        lore.add(s);
                    }
                    lore.add("");
                    lore.add(ChatColor.GRAY + jobplayer.getName() + "님이 능력을 선택했습니다");
                    itemmm.setLore(lore);
                }
        	}
        }
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack PaladinGuiItem(Player player)
    {
        ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName(ChatColor.WHITE + "팔라딘");
        itemmm.setLore(MsgUtil.ColorVarMsg(JobVar.Paladin_Des, ChatColor.GRAY));
        if(TeamVar.Player_Team.containsKey(player.getUniqueId())) {
        	if(JobVar.TeamJobList.containsKey(TeamVar.Player_Team.get(player.getUniqueId()))) {
        		HashMap<UUID, String> joblist = JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
                if(joblist != null && joblist.containsValue("팔라딘"))
                {
                    UUID JobP = null;
                    for(Entry<UUID, String> entry : joblist.entrySet())
                    {
                        if(entry.getValue().equals("팔라딘")) {
                        	JobP = entry.getKey();
                        }
                    }

                    Player jobplayer = Bukkit.getPlayer(JobP);
                    List<String> lore = new ArrayList<String>();
                    for(String s : itemmm.getLore()) {
                        lore.add(s);
                    }
                    lore.add("");
                    lore.add(ChatColor.GRAY + jobplayer.getName() + "님이 능력을 선택했습니다");
                    itemmm.setLore(lore);
                }
        	}
        }
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack PemanahGuiItem(Player player)
    {
        ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName(ChatColor.WHITE + "페모나");
        itemmm.setLore(MsgUtil.ColorVarMsg(JobVar.Pemanah_Des, ChatColor.GRAY));
        if(TeamVar.Player_Team.containsKey(player.getUniqueId())) {
        	if(JobVar.TeamJobList.containsKey(TeamVar.Player_Team.get(player.getUniqueId()))) {
        		HashMap<UUID, String> joblist = JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
                if(joblist != null && joblist.containsValue("페모나"))
                {
                    UUID JobP = null;
                    for(Entry<UUID, String> entry : joblist.entrySet())
                    {
                        if(entry.getValue().equals("페모나")) {
                        	JobP = entry.getKey();
                        }
                    }

                    Player jobplayer = Bukkit.getPlayer(JobP);
                    List<String> lore = new ArrayList<String>();
                    for(String s : itemmm.getLore()) {
                        lore.add(s);
                    }
                    lore.add("");
                    lore.add(ChatColor.GRAY + jobplayer.getName() + "님이 능력을 선택했습니다");
                    itemmm.setLore(lore);
                }
        	}
        }
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack ZoukGuiItem(Player player)
    {
        ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName(ChatColor.WHITE + "주크");
        itemmm.setLore(MsgUtil.ColorVarMsg(JobVar.Zouk_Des, ChatColor.GRAY));
        if(TeamVar.Player_Team.containsKey(player.getUniqueId())) {
        	if(JobVar.TeamJobList.containsKey(TeamVar.Player_Team.get(player.getUniqueId()))) {
        		HashMap<UUID, String> joblist = JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
                if(joblist != null && joblist.containsValue("주크"))
                {
                    UUID JobP = null;
                    for(Entry<UUID, String> entry : joblist.entrySet())
                    {
                        if(entry.getValue().equals("주크")) {
                        	JobP = entry.getKey();
                        }
                    }

                    Player jobplayer = Bukkit.getPlayer(JobP);
                    List<String> lore = new ArrayList<String>();
                    for(String s : itemmm.getLore()) {
                        lore.add(s);
                    }
                    lore.add("");
                    lore.add(ChatColor.GRAY + jobplayer.getName() + "님이 능력을 선택했습니다");
                    itemmm.setLore(lore);
                }
        	}
        }
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack[] BigGuyJobItem(Player player)
    {
        ItemStack Weapon = new ItemStack(Material.BLAZE_ROD);
        ItemMeta Weapon_M = Weapon.getItemMeta();
        AttributeModifier Weapon_A = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", 4, Operation.ADD_NUMBER, EquipmentSlot.HAND);
        Weapon_M.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, Weapon_A);
        Weapon_M.setDisplayName(WordVar.XM + "빅가이");
        Weapon.setItemMeta(Weapon_M);
        
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta Helmet_M = Helmet.getItemMeta();
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Helmet_A);
        Helmet_M.setDisplayName(WordVar.XM + "투구");
        Helmet.setItemMeta(Helmet_M);
        
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "갑옷");
        Chestplate.setItemMeta(Chestplate_M);
        
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "하의");
        Leggings.setItemMeta(Leggings_M);
        
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "신발");
        Boots.setItemMeta(Boots_M);
        
        ItemStack itemlist[] = { Weapon, Helmet, Chestplate, Leggings, Boots };
        return itemlist;
    }

    public static ItemStack[] CruiseJobItem(Player player)
    {
        ItemStack Weapon = new ItemStack(Material.BLAZE_ROD);
        ItemMeta Weapon_M = Weapon.getItemMeta();
        AttributeModifier Weapon_A = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", 4, Operation.ADD_NUMBER, EquipmentSlot.HAND);
        Weapon_M.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, Weapon_A);
        Weapon_M.setDisplayName(WordVar.XM + "크루스");
        Weapon.setItemMeta(Weapon_M);
        
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta Helmet_M = Helmet.getItemMeta();
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Helmet_A);
        Helmet_M.setDisplayName(WordVar.XM + "투구");
        Helmet.setItemMeta(Helmet_M);
        
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "갑옷");
        Chestplate.setItemMeta(Chestplate_M);
        
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "하의");
        Leggings.setItemMeta(Leggings_M);
        
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "신발");
        Boots.setItemMeta(Boots_M);
        
        ItemStack itemlist[] = { Weapon, Helmet, Chestplate, Leggings, Boots };
        return itemlist;
    }

    public static ItemStack[] EgisJobItem(Player player)
    {
        ItemStack Weapon = new ItemStack(Material.BLAZE_ROD);
        ItemMeta Weapon_M = Weapon.getItemMeta();
        AttributeModifier Weapon_A = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", 4, Operation.ADD_NUMBER, EquipmentSlot.HAND);
        Weapon_M.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, Weapon_A);
        Weapon_M.setDisplayName(WordVar.XM + "에기스");
        Weapon.setItemMeta(Weapon_M);
        
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta Helmet_M = Helmet.getItemMeta();
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Helmet_A);
        Helmet_M.setDisplayName(WordVar.XM + "투구");
        Helmet.setItemMeta(Helmet_M);
        
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "갑옷");
        Chestplate.setItemMeta(Chestplate_M);
        
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "하의");
        Leggings.setItemMeta(Leggings_M);
        
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "신발");
        Boots.setItemMeta(Boots_M);
        
        ItemStack itemlist[] = { Weapon, Helmet, Chestplate, Leggings, Boots };
        return itemlist;
    }

    public static ItemStack[] PataiJobItem(Player player)
    {
        ItemStack Weapon = new ItemStack(Material.BLAZE_ROD);
        ItemMeta Weapon_M = Weapon.getItemMeta();
        AttributeModifier Weapon_A = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", 4, Operation.ADD_NUMBER, EquipmentSlot.HAND);
        Weapon_M.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, Weapon_A);
        Weapon_M.setDisplayName(WordVar.XM + "파타이");
        Weapon.setItemMeta(Weapon_M);
        
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta Helmet_M = Helmet.getItemMeta();
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Helmet_A);
        Helmet_M.setDisplayName(WordVar.XM + "투구");
        Helmet.setItemMeta(Helmet_M);
        
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "갑옷");
        Chestplate.setItemMeta(Chestplate_M);
        
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "하의");
        Leggings.setItemMeta(Leggings_M);
        
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "신발");
        Boots.setItemMeta(Boots_M);
        
        ItemStack itemlist[] = { Weapon, Helmet, Chestplate, Leggings, Boots };
        return itemlist;
    }

    public static ItemStack[] BomberJobItem(Player player)
    {
        ItemStack Weapon = new ItemStack(Material.BLAZE_ROD);
        ItemMeta Weapon_M = Weapon.getItemMeta();
        AttributeModifier Weapon_A = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", 4, Operation.ADD_NUMBER, EquipmentSlot.HAND);
        Weapon_M.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, Weapon_A);
        Weapon_M.setDisplayName(WordVar.XM + "봄버");
        Weapon.setItemMeta(Weapon_M);
        
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta Helmet_M = Helmet.getItemMeta();
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Helmet_A);
        Helmet_M.setDisplayName(WordVar.XM + "투구");
        Helmet.setItemMeta(Helmet_M);
        
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "갑옷");
        Chestplate.setItemMeta(Chestplate_M);
        
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "하의");
        Leggings.setItemMeta(Leggings_M);
        
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "신발");
        Boots.setItemMeta(Boots_M);
        
        ItemStack itemlist[] = { Weapon, Helmet, Chestplate, Leggings, Boots };
        return itemlist;
    }

    public static ItemStack[] FasterJobItem(Player player)
    {
        ItemStack Weapon = new ItemStack(Material.BLAZE_ROD);
        ItemMeta Weapon_M = Weapon.getItemMeta();
        AttributeModifier Weapon_A = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", 4, Operation.ADD_NUMBER, EquipmentSlot.HAND);
        Weapon_M.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, Weapon_A);
        Weapon_M.setDisplayName(WordVar.XM + "페스트");
        Weapon.setItemMeta(Weapon_M);
        
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta Helmet_M = Helmet.getItemMeta();
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Helmet_A);
        Helmet_M.setDisplayName(WordVar.XM + "투구");
        Helmet.setItemMeta(Helmet_M);
        
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "갑옷");
        Chestplate.setItemMeta(Chestplate_M);
        
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "하의");
        Leggings.setItemMeta(Leggings_M);
        
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "신발");
        Boots.setItemMeta(Boots_M);
        
        ItemStack itemlist[] = { Weapon, Helmet, Chestplate, Leggings, Boots };
        return itemlist;
    }

    public static ItemStack[] KratosJobItem(Player player)
    {
        ItemStack Weapon = new ItemStack(Material.BLAZE_ROD);
        ItemMeta Weapon_M = Weapon.getItemMeta();
        AttributeModifier Weapon_A = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", 4, Operation.ADD_NUMBER, EquipmentSlot.HAND);
        Weapon_M.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, Weapon_A);
        Weapon_M.setDisplayName(WordVar.XM + "크라토스");
        Weapon.setItemMeta(Weapon_M);
        
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta Helmet_M = Helmet.getItemMeta();
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Helmet_A);
        Helmet_M.setDisplayName(WordVar.XM + "투구");
        Helmet.setItemMeta(Helmet_M);
        
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "갑옷");
        Chestplate.setItemMeta(Chestplate_M);
        
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "하의");
        Leggings.setItemMeta(Leggings_M);
        
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "신발");
        Boots.setItemMeta(Boots_M);
        
        ItemStack itemlist[] = { Weapon, Helmet, Chestplate, Leggings, Boots };
        return itemlist;
    }

    public static ItemStack[] SaluranJobItem(Player player)
    {
        ItemStack Weapon = new ItemStack(Material.BLAZE_ROD);
        ItemMeta Weapon_M = Weapon.getItemMeta();
        AttributeModifier Weapon_A = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", 4, Operation.ADD_NUMBER, EquipmentSlot.HAND);
        Weapon_M.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, Weapon_A);
        Weapon_M.setDisplayName(WordVar.XM + "살루란");
        Weapon.setItemMeta(Weapon_M);
        
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta Helmet_M = Helmet.getItemMeta();
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Helmet_A);
        Helmet_M.setDisplayName(WordVar.XM + "투구");
        Helmet.setItemMeta(Helmet_M);
        
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "갑옷");
        Chestplate.setItemMeta(Chestplate_M);
        
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "하의");
        Leggings.setItemMeta(Leggings_M);
        
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "신발");
        Boots.setItemMeta(Boots_M);
        
        ItemStack itemlist[] = { Weapon, Helmet, Chestplate, Leggings, Boots };
        return itemlist;
    }

    public static ItemStack[] PaladinJobItem(Player player)
    {
        ItemStack Weapon = new ItemStack(Material.BLAZE_ROD);
        ItemMeta Weapon_M = Weapon.getItemMeta();
        AttributeModifier Weapon_A = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", 4, Operation.ADD_NUMBER, EquipmentSlot.HAND);
        Weapon_M.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, Weapon_A);
        Weapon_M.setDisplayName(WordVar.XM + "팔라딘");
        Weapon.setItemMeta(Weapon_M);
        
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta Helmet_M = Helmet.getItemMeta();
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Helmet_A);
        Helmet_M.setDisplayName(WordVar.XM + "투구");
        Helmet.setItemMeta(Helmet_M);
        
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "갑옷");
        Chestplate.setItemMeta(Chestplate_M);
        
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "하의");
        Leggings.setItemMeta(Leggings_M);
        
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "신발");
        Boots.setItemMeta(Boots_M);
        
        ItemStack itemlist[] = { Weapon, Helmet, Chestplate, Leggings, Boots };
        return itemlist;
    }

    public static ItemStack[] PemanahJobItem(Player player)
    {
        ItemStack Weapon = new ItemStack(Material.BLAZE_ROD);
        ItemMeta Weapon_M = Weapon.getItemMeta();
        AttributeModifier Weapon_A = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", 4, Operation.ADD_NUMBER, EquipmentSlot.HAND);
        Weapon_M.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, Weapon_A);
        Weapon_M.setDisplayName(WordVar.XM + "페모나");
        Weapon.setItemMeta(Weapon_M);
        
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta Helmet_M = Helmet.getItemMeta();
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Helmet_A);
        Helmet_M.setDisplayName(WordVar.XM + "투구");
        Helmet.setItemMeta(Helmet_M);
        
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "갑옷");
        Chestplate.setItemMeta(Chestplate_M);
        
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "하의");
        Leggings.setItemMeta(Leggings_M);
        
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "신발");
        Boots.setItemMeta(Boots_M);
        
        ItemStack itemlist[] = { Weapon, Helmet, Chestplate, Leggings, Boots };
        return itemlist;
    }

    public static ItemStack[] ZoukJobItem(Player player)
    {
        ItemStack Weapon = new ItemStack(Material.BLAZE_ROD);
        ItemMeta Weapon_M = Weapon.getItemMeta();
        AttributeModifier Weapon_A = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", 4, Operation.ADD_NUMBER, EquipmentSlot.HAND);
        Weapon_M.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, Weapon_A);
        Weapon_M.setDisplayName(WordVar.XM + "주크");
        Weapon.setItemMeta(Weapon_M);
        
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta Helmet_M = Helmet.getItemMeta();
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Helmet_A);
        Helmet_M.setDisplayName(WordVar.XM + "투구");
        Helmet.setItemMeta(Helmet_M);
        
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "갑옷");
        Chestplate.setItemMeta(Chestplate_M);
        
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "하의");
        Leggings.setItemMeta(Leggings_M);
        
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "신발");
        Boots.setItemMeta(Boots_M);
        
        ItemStack itemlist[] = { Weapon, Helmet, Chestplate, Leggings, Boots };
        return itemlist;
    }
}
