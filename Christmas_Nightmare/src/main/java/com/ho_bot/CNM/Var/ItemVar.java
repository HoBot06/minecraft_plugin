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
        itemmm.setDisplayName(ChatColor.GOLD + "[���] " + ChatColor.WHITE + "��");
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack TreeItem()
    {
        ItemStack itemi = new ItemStack(Material.WHITE_DYE);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName(ChatColor.GOLD + "[���] " + ChatColor.WHITE + "����");
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack StoneItem()
    {
        ItemStack itemi = new ItemStack(Material.WHITE_DYE);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName(ChatColor.GOLD + "[���] " + ChatColor.WHITE + "����");
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack SnowItem()
    {
        ItemStack itemi = new ItemStack(Material.WHITE_DYE);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName(ChatColor.GOLD + "[���] " + ChatColor.WHITE + "��");
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack BigGuyGuiItem(Player player)
    {
        ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName(ChatColor.WHITE + "����");
        itemmm.setLore(MsgUtil.ColorVarMsg(JobVar.BigGuy_Des, ChatColor.GRAY));
        if(TeamVar.Player_Team.containsKey(player.getUniqueId())) {
        	if(JobVar.TeamJobList.containsKey(TeamVar.Player_Team.get(player.getUniqueId()))) {
        		HashMap<UUID, String> joblist = JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
                if(joblist != null && joblist.containsValue("����"))
                {
                    UUID JobP = null;
                    for(Entry<UUID, String> entry : joblist.entrySet())
                    {
                        if(entry.getValue().equals("����")) {
                        	JobP = entry.getKey();
                        }
                    }

                    Player jobplayer = Bukkit.getPlayer(JobP);
                    List<String> lore = new ArrayList<String>();
                    for(String s : itemmm.getLore()) {
                        lore.add(s);
                    }
                    lore.add("");
                    lore.add(ChatColor.GRAY + jobplayer.getName() + "���� �ɷ��� �����߽��ϴ�");
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
        itemmm.setDisplayName(ChatColor.WHITE + "ũ�罺");
        itemmm.setLore(MsgUtil.ColorVarMsg(JobVar.Cruise_Des, ChatColor.GRAY));
        if(TeamVar.Player_Team.containsKey(player.getUniqueId())) {
        	if(JobVar.TeamJobList.containsKey(TeamVar.Player_Team.get(player.getUniqueId()))) {
        		HashMap<UUID, String> joblist = JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
                if(joblist != null && joblist.containsValue("ũ�罺"))
                {
                    UUID JobP = null;
                    for(Entry<UUID, String> entry : joblist.entrySet())
                    {
                        if(entry.getValue().equals("ũ�罺")) {
                        	JobP = entry.getKey();
                        }
                    }

                    Player jobplayer = Bukkit.getPlayer(JobP);
                    List<String> lore = new ArrayList<String>();
                    for(String s : itemmm.getLore()) {
                        lore.add(s);
                    }
                    lore.add("");
                    lore.add(ChatColor.GRAY + jobplayer.getName() + "���� �ɷ��� �����߽��ϴ�");
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
        itemmm.setDisplayName(ChatColor.WHITE + "���⽺");
        itemmm.setLore(MsgUtil.ColorVarMsg(JobVar.Egis_Des, ChatColor.GRAY));
        if(TeamVar.Player_Team.containsKey(player.getUniqueId())) {
        	if(JobVar.TeamJobList.containsKey(TeamVar.Player_Team.get(player.getUniqueId()))) {
        		HashMap<UUID, String> joblist = JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
                if(joblist != null && joblist.containsValue("���⽺"))
                {
                    UUID JobP = null;
                    for(Entry<UUID, String> entry : joblist.entrySet())
                    {
                        if(entry.getValue().equals("���⽺")) {
                        	JobP = entry.getKey();
                        }
                    }

                    Player jobplayer = Bukkit.getPlayer(JobP);
                    List<String> lore = new ArrayList<String>();
                    for(String s : itemmm.getLore()) {
                        lore.add(s);
                    }
                    lore.add("");
                    lore.add(ChatColor.GRAY + jobplayer.getName() + "���� �ɷ��� �����߽��ϴ�");
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
        itemmm.setDisplayName(ChatColor.WHITE + "��Ÿ��");
        itemmm.setLore(MsgUtil.ColorVarMsg(JobVar.Patai_Des, ChatColor.GRAY));
        if(TeamVar.Player_Team.containsKey(player.getUniqueId())) {
        	if(JobVar.TeamJobList.containsKey(TeamVar.Player_Team.get(player.getUniqueId()))) {
        		HashMap<UUID, String> joblist = JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
                if(joblist != null && joblist.containsValue("��Ÿ��"))
                {
                    UUID JobP = null;
                    for(Entry<UUID, String> entry : joblist.entrySet())
                    {
                        if(entry.getValue().equals("��Ÿ��")) {
                        	JobP = entry.getKey();
                        }
                    }

                    Player jobplayer = Bukkit.getPlayer(JobP);
                    List<String> lore = new ArrayList<String>();
                    for(String s : itemmm.getLore()) {
                        lore.add(s);
                    }
                    lore.add("");
                    lore.add(ChatColor.GRAY + jobplayer.getName() + "���� �ɷ��� �����߽��ϴ�");
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
        itemmm.setDisplayName(ChatColor.WHITE + "����");
        itemmm.setLore(MsgUtil.ColorVarMsg(JobVar.Bomber_Des, ChatColor.GRAY));
        if(TeamVar.Player_Team.containsKey(player.getUniqueId())) {
        	if(JobVar.TeamJobList.containsKey(TeamVar.Player_Team.get(player.getUniqueId()))) {
        		HashMap<UUID, String> joblist = JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
                if(joblist != null && joblist.containsValue("����"))
                {
                    UUID JobP = null;
                    for(Entry<UUID, String> entry : joblist.entrySet())
                    {
                        if(entry.getValue().equals("����")) {
                        	JobP = entry.getKey();
                        }
                    }

                    Player jobplayer = Bukkit.getPlayer(JobP);
                    List<String> lore = new ArrayList<String>();
                    for(String s : itemmm.getLore()) {
                        lore.add(s);
                    }
                    lore.add("");
                    lore.add(ChatColor.GRAY + jobplayer.getName() + "���� �ɷ��� �����߽��ϴ�");
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
        itemmm.setDisplayName(ChatColor.WHITE + "�佺Ʈ");
        itemmm.setLore(MsgUtil.ColorVarMsg(JobVar.Faster_Des, ChatColor.GRAY));
        if(TeamVar.Player_Team.containsKey(player.getUniqueId())) {
        	if(JobVar.TeamJobList.containsKey(TeamVar.Player_Team.get(player.getUniqueId()))) {
        		HashMap<UUID, String> joblist = JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
                if(joblist != null && joblist.containsValue("�佺Ʈ"))
                {
                    UUID JobP = null;
                    for(Entry<UUID, String> entry : joblist.entrySet())
                    {
                        if(entry.getValue().equals("�佺Ʈ")) {
                        	JobP = entry.getKey();
                        }
                    }

                    Player jobplayer = Bukkit.getPlayer(JobP);
                    List<String> lore = new ArrayList<String>();
                    for(String s : itemmm.getLore()) {
                        lore.add(s);
                    }
                    lore.add("");
                    lore.add(ChatColor.GRAY + jobplayer.getName() + "���� �ɷ��� �����߽��ϴ�");
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
        itemmm.setDisplayName(ChatColor.WHITE + "ũ���佺");
        itemmm.setLore(MsgUtil.ColorVarMsg(JobVar.Kratos_Des, ChatColor.GRAY));
        if(TeamVar.Player_Team.containsKey(player.getUniqueId())) {
        	if(JobVar.TeamJobList.containsKey(TeamVar.Player_Team.get(player.getUniqueId()))) {
        		HashMap<UUID, String> joblist = JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
                if(joblist != null && joblist.containsValue("ũ���佺"))
                {
                    UUID JobP = null;
                    for(Entry<UUID, String> entry : joblist.entrySet())
                    {
                        if(entry.getValue().equals("ũ���佺")) {
                        	JobP = entry.getKey();
                        }
                    }

                    Player jobplayer = Bukkit.getPlayer(JobP);
                    List<String> lore = new ArrayList<String>();
                    for(String s : itemmm.getLore()) {
                        lore.add(s);
                    }
                    lore.add("");
                    lore.add(ChatColor.GRAY + jobplayer.getName() + "���� �ɷ��� �����߽��ϴ�");
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
        itemmm.setDisplayName(ChatColor.WHITE + "����");
        itemmm.setLore(MsgUtil.ColorVarMsg(JobVar.Saluran_Des, ChatColor.GRAY));
        if(TeamVar.Player_Team.containsKey(player.getUniqueId())) {
        	if(JobVar.TeamJobList.containsKey(TeamVar.Player_Team.get(player.getUniqueId()))) {
        		HashMap<UUID, String> joblist = JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
                if(joblist != null && joblist.containsValue("����"))
                {
                    UUID JobP = null;
                    for(Entry<UUID, String> entry : joblist.entrySet())
                    {
                        if(entry.getValue().equals("����")) {
                        	JobP = entry.getKey();
                        }
                    }

                    Player jobplayer = Bukkit.getPlayer(JobP);
                    List<String> lore = new ArrayList<String>();
                    for(String s : itemmm.getLore()) {
                        lore.add(s);
                    }
                    lore.add("");
                    lore.add(ChatColor.GRAY + jobplayer.getName() + "���� �ɷ��� �����߽��ϴ�");
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
        itemmm.setDisplayName(ChatColor.WHITE + "�ȶ��");
        itemmm.setLore(MsgUtil.ColorVarMsg(JobVar.Paladin_Des, ChatColor.GRAY));
        if(TeamVar.Player_Team.containsKey(player.getUniqueId())) {
        	if(JobVar.TeamJobList.containsKey(TeamVar.Player_Team.get(player.getUniqueId()))) {
        		HashMap<UUID, String> joblist = JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
                if(joblist != null && joblist.containsValue("�ȶ��"))
                {
                    UUID JobP = null;
                    for(Entry<UUID, String> entry : joblist.entrySet())
                    {
                        if(entry.getValue().equals("�ȶ��")) {
                        	JobP = entry.getKey();
                        }
                    }

                    Player jobplayer = Bukkit.getPlayer(JobP);
                    List<String> lore = new ArrayList<String>();
                    for(String s : itemmm.getLore()) {
                        lore.add(s);
                    }
                    lore.add("");
                    lore.add(ChatColor.GRAY + jobplayer.getName() + "���� �ɷ��� �����߽��ϴ�");
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
        itemmm.setDisplayName(ChatColor.WHITE + "���");
        itemmm.setLore(MsgUtil.ColorVarMsg(JobVar.Pemanah_Des, ChatColor.GRAY));
        if(TeamVar.Player_Team.containsKey(player.getUniqueId())) {
        	if(JobVar.TeamJobList.containsKey(TeamVar.Player_Team.get(player.getUniqueId()))) {
        		HashMap<UUID, String> joblist = JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
                if(joblist != null && joblist.containsValue("���"))
                {
                    UUID JobP = null;
                    for(Entry<UUID, String> entry : joblist.entrySet())
                    {
                        if(entry.getValue().equals("���")) {
                        	JobP = entry.getKey();
                        }
                    }

                    Player jobplayer = Bukkit.getPlayer(JobP);
                    List<String> lore = new ArrayList<String>();
                    for(String s : itemmm.getLore()) {
                        lore.add(s);
                    }
                    lore.add("");
                    lore.add(ChatColor.GRAY + jobplayer.getName() + "���� �ɷ��� �����߽��ϴ�");
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
        itemmm.setDisplayName(ChatColor.WHITE + "��ũ");
        itemmm.setLore(MsgUtil.ColorVarMsg(JobVar.Zouk_Des, ChatColor.GRAY));
        if(TeamVar.Player_Team.containsKey(player.getUniqueId())) {
        	if(JobVar.TeamJobList.containsKey(TeamVar.Player_Team.get(player.getUniqueId()))) {
        		HashMap<UUID, String> joblist = JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
                if(joblist != null && joblist.containsValue("��ũ"))
                {
                    UUID JobP = null;
                    for(Entry<UUID, String> entry : joblist.entrySet())
                    {
                        if(entry.getValue().equals("��ũ")) {
                        	JobP = entry.getKey();
                        }
                    }

                    Player jobplayer = Bukkit.getPlayer(JobP);
                    List<String> lore = new ArrayList<String>();
                    for(String s : itemmm.getLore()) {
                        lore.add(s);
                    }
                    lore.add("");
                    lore.add(ChatColor.GRAY + jobplayer.getName() + "���� �ɷ��� �����߽��ϴ�");
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
        Weapon_M.setDisplayName(WordVar.XM + "����");
        Weapon.setItemMeta(Weapon_M);
        
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta Helmet_M = Helmet.getItemMeta();
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Helmet_A);
        Helmet_M.setDisplayName(WordVar.XM + "����");
        Helmet.setItemMeta(Helmet_M);
        
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "����");
        Chestplate.setItemMeta(Chestplate_M);
        
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "����");
        Leggings.setItemMeta(Leggings_M);
        
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "�Ź�");
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
        Weapon_M.setDisplayName(WordVar.XM + "ũ�罺");
        Weapon.setItemMeta(Weapon_M);
        
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta Helmet_M = Helmet.getItemMeta();
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Helmet_A);
        Helmet_M.setDisplayName(WordVar.XM + "����");
        Helmet.setItemMeta(Helmet_M);
        
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "����");
        Chestplate.setItemMeta(Chestplate_M);
        
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "����");
        Leggings.setItemMeta(Leggings_M);
        
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "�Ź�");
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
        Weapon_M.setDisplayName(WordVar.XM + "���⽺");
        Weapon.setItemMeta(Weapon_M);
        
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta Helmet_M = Helmet.getItemMeta();
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Helmet_A);
        Helmet_M.setDisplayName(WordVar.XM + "����");
        Helmet.setItemMeta(Helmet_M);
        
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "����");
        Chestplate.setItemMeta(Chestplate_M);
        
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "����");
        Leggings.setItemMeta(Leggings_M);
        
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "�Ź�");
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
        Weapon_M.setDisplayName(WordVar.XM + "��Ÿ��");
        Weapon.setItemMeta(Weapon_M);
        
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta Helmet_M = Helmet.getItemMeta();
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Helmet_A);
        Helmet_M.setDisplayName(WordVar.XM + "����");
        Helmet.setItemMeta(Helmet_M);
        
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "����");
        Chestplate.setItemMeta(Chestplate_M);
        
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "����");
        Leggings.setItemMeta(Leggings_M);
        
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "�Ź�");
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
        Weapon_M.setDisplayName(WordVar.XM + "����");
        Weapon.setItemMeta(Weapon_M);
        
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta Helmet_M = Helmet.getItemMeta();
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Helmet_A);
        Helmet_M.setDisplayName(WordVar.XM + "����");
        Helmet.setItemMeta(Helmet_M);
        
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "����");
        Chestplate.setItemMeta(Chestplate_M);
        
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "����");
        Leggings.setItemMeta(Leggings_M);
        
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "�Ź�");
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
        Weapon_M.setDisplayName(WordVar.XM + "�佺Ʈ");
        Weapon.setItemMeta(Weapon_M);
        
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta Helmet_M = Helmet.getItemMeta();
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Helmet_A);
        Helmet_M.setDisplayName(WordVar.XM + "����");
        Helmet.setItemMeta(Helmet_M);
        
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "����");
        Chestplate.setItemMeta(Chestplate_M);
        
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "����");
        Leggings.setItemMeta(Leggings_M);
        
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "�Ź�");
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
        Weapon_M.setDisplayName(WordVar.XM + "ũ���佺");
        Weapon.setItemMeta(Weapon_M);
        
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta Helmet_M = Helmet.getItemMeta();
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Helmet_A);
        Helmet_M.setDisplayName(WordVar.XM + "����");
        Helmet.setItemMeta(Helmet_M);
        
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "����");
        Chestplate.setItemMeta(Chestplate_M);
        
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "����");
        Leggings.setItemMeta(Leggings_M);
        
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "�Ź�");
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
        Weapon_M.setDisplayName(WordVar.XM + "����");
        Weapon.setItemMeta(Weapon_M);
        
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta Helmet_M = Helmet.getItemMeta();
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Helmet_A);
        Helmet_M.setDisplayName(WordVar.XM + "����");
        Helmet.setItemMeta(Helmet_M);
        
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "����");
        Chestplate.setItemMeta(Chestplate_M);
        
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "����");
        Leggings.setItemMeta(Leggings_M);
        
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "�Ź�");
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
        Weapon_M.setDisplayName(WordVar.XM + "�ȶ��");
        Weapon.setItemMeta(Weapon_M);
        
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta Helmet_M = Helmet.getItemMeta();
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Helmet_A);
        Helmet_M.setDisplayName(WordVar.XM + "����");
        Helmet.setItemMeta(Helmet_M);
        
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "����");
        Chestplate.setItemMeta(Chestplate_M);
        
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "����");
        Leggings.setItemMeta(Leggings_M);
        
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "�Ź�");
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
        Weapon_M.setDisplayName(WordVar.XM + "���");
        Weapon.setItemMeta(Weapon_M);
        
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta Helmet_M = Helmet.getItemMeta();
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Helmet_A);
        Helmet_M.setDisplayName(WordVar.XM + "����");
        Helmet.setItemMeta(Helmet_M);
        
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "����");
        Chestplate.setItemMeta(Chestplate_M);
        
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "����");
        Leggings.setItemMeta(Leggings_M);
        
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "�Ź�");
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
        Weapon_M.setDisplayName(WordVar.XM + "��ũ");
        Weapon.setItemMeta(Weapon_M);
        
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta Helmet_M = Helmet.getItemMeta();
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Helmet_A);
        Helmet_M.setDisplayName(WordVar.XM + "����");
        Helmet.setItemMeta(Helmet_M);
        
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "����");
        Chestplate.setItemMeta(Chestplate_M);
        
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 10, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "����");
        Leggings.setItemMeta(Leggings_M);
        
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "�Ź�");
        Boots.setItemMeta(Boots_M);
        
        ItemStack itemlist[] = { Weapon, Helmet, Chestplate, Leggings, Boots };
        return itemlist;
    }
}
