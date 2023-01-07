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
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import com.ho_bot.CNM.Tools.JobSelectTool;
import com.ho_bot.CNM.Utility.JobListUtil;
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
        ItemStack itemi = new ItemStack(Material.GREEN_DYE);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName(ChatColor.GOLD + "[재료] " + ChatColor.WHITE + "목재");
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack StoneItem()
    {
        ItemStack itemi = new ItemStack(Material.GRAY_DYE);
        ItemMeta itemmm = itemi.getItemMeta();
        itemmm.setDisplayName(ChatColor.GOLD + "[재료] " + ChatColor.WHITE + "광석");
        itemi.setItemMeta(itemmm);
        return itemi;
    }

    public static ItemStack SnowItem()
    {
        ItemStack itemi = new ItemStack(Material.YELLOW_DYE);
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
    
    public static ItemStack BigGuyChoiceGuiItem(Player player)
    {
        ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemm = itemi.getItemMeta();
        HashMap<String, Integer> JobUp = TeamVar.Team_JobUpgrade.get(TeamVar.Player_Team.get(player.getUniqueId()));
        int UpInt = JobUp.get(JobListUtil.BigGuy);
        itemm.setDisplayName(ChatColor.WHITE + JobListUtil.BigGuy);
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "현재 업그레이드 단계");
        lore.add(ChatColor.GRAY + " - " + UpInt);
        itemm.setLore(lore);
        
        itemi.setItemMeta(itemm);
        return itemi;
    }

    public static ItemStack CruiseChoiceGuiItem(Player player)
    {
    	ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemm = itemi.getItemMeta();
        HashMap<String, Integer> JobUp = TeamVar.Team_JobUpgrade.get(TeamVar.Player_Team.get(player.getUniqueId()));
        int UpInt = JobUp.get(JobListUtil.Cruise);
        itemm.setDisplayName(ChatColor.WHITE + JobListUtil.Cruise);
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "현재 업그레이드 단계");
        lore.add(ChatColor.GRAY + " - " + UpInt);
        itemm.setLore(lore);
        
        itemi.setItemMeta(itemm);
        return itemi;
    }

    public static ItemStack EgisChoiceGuiItem(Player player)
    {
    	ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemm = itemi.getItemMeta();
        HashMap<String, Integer> JobUp = TeamVar.Team_JobUpgrade.get(TeamVar.Player_Team.get(player.getUniqueId()));
        int UpInt = JobUp.get(JobListUtil.Egis);
        itemm.setDisplayName(ChatColor.WHITE + JobListUtil.Egis);
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "현재 업그레이드 단계");
        lore.add(ChatColor.GRAY + " - " + UpInt);
        itemm.setLore(lore);
        
        itemi.setItemMeta(itemm);
        return itemi;
    }

    public static ItemStack PataiChoiceGuiItem(Player player)
    {
    	ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemm = itemi.getItemMeta();
        HashMap<String, Integer> JobUp = TeamVar.Team_JobUpgrade.get(TeamVar.Player_Team.get(player.getUniqueId()));
        int UpInt = JobUp.get(JobListUtil.Patai);
        itemm.setDisplayName(ChatColor.WHITE + JobListUtil.Patai);
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "현재 업그레이드 단계");
        lore.add(ChatColor.GRAY + " - " + UpInt);
        itemm.setLore(lore);
        
        itemi.setItemMeta(itemm);
        return itemi;
    }

    public static ItemStack BomberChoiceGuiItem(Player player)
    {
    	ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemm = itemi.getItemMeta();
        HashMap<String, Integer> JobUp = TeamVar.Team_JobUpgrade.get(TeamVar.Player_Team.get(player.getUniqueId()));
        int UpInt = JobUp.get(JobListUtil.Bomber);
        itemm.setDisplayName(ChatColor.WHITE + JobListUtil.Bomber);
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "현재 업그레이드 단계");
        lore.add(ChatColor.GRAY + " - " + UpInt);
        itemm.setLore(lore);
        
        itemi.setItemMeta(itemm);
        return itemi;
    }

    public static ItemStack FasterChoiceGuiItem(Player player)
    {
    	ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemm = itemi.getItemMeta();
        HashMap<String, Integer> JobUp = TeamVar.Team_JobUpgrade.get(TeamVar.Player_Team.get(player.getUniqueId()));
        int UpInt = JobUp.get(JobListUtil.Faster);
        itemm.setDisplayName(ChatColor.WHITE + JobListUtil.Faster);
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "현재 업그레이드 단계");
        lore.add(ChatColor.GRAY + " - " + UpInt);
        itemm.setLore(lore);
        
        itemi.setItemMeta(itemm);
        return itemi;
    }

    public static ItemStack KratosChoiceGuiItem(Player player)
    {
    	ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemm = itemi.getItemMeta();
        HashMap<String, Integer> JobUp = TeamVar.Team_JobUpgrade.get(TeamVar.Player_Team.get(player.getUniqueId()));
        int UpInt = JobUp.get(JobListUtil.Kratos);
        itemm.setDisplayName(ChatColor.WHITE + JobListUtil.Kratos);
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "현재 업그레이드 단계");
        lore.add(ChatColor.GRAY + " - " + UpInt);
        itemm.setLore(lore);
        
        itemi.setItemMeta(itemm);
        return itemi;
    }

    public static ItemStack SaluranChoiceGuiItem(Player player)
    {
    	ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemm = itemi.getItemMeta();
        HashMap<String, Integer> JobUp = TeamVar.Team_JobUpgrade.get(TeamVar.Player_Team.get(player.getUniqueId()));
        int UpInt = JobUp.get(JobListUtil.Saluran);
        itemm.setDisplayName(ChatColor.WHITE + JobListUtil.Saluran);
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "현재 업그레이드 단계");
        lore.add(ChatColor.GRAY + " - " + UpInt);
        itemm.setLore(lore);
        
        itemi.setItemMeta(itemm);
        return itemi;
    }

    public static ItemStack PaladinChoiceGuiItem(Player player)
    {
    	ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemm = itemi.getItemMeta();
        HashMap<String, Integer> JobUp = TeamVar.Team_JobUpgrade.get(TeamVar.Player_Team.get(player.getUniqueId()));
        int UpInt = JobUp.get(JobListUtil.Paladin);
        itemm.setDisplayName(ChatColor.WHITE + JobListUtil.Paladin);
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "현재 업그레이드 단계");
        lore.add(ChatColor.GRAY + " - " + UpInt);
        itemm.setLore(lore);
        
        itemi.setItemMeta(itemm);
        return itemi;
    }

    public static ItemStack PemanahChoiceGuiItem(Player player)
    {
    	ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemm = itemi.getItemMeta();
        HashMap<String, Integer> JobUp = TeamVar.Team_JobUpgrade.get(TeamVar.Player_Team.get(player.getUniqueId()));
        int UpInt = JobUp.get(JobListUtil.Pemanah);
        itemm.setDisplayName(ChatColor.WHITE + JobListUtil.Pemanah);
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "현재 업그레이드 단계");
        lore.add(ChatColor.GRAY + " - " + UpInt);
        itemm.setLore(lore);
        
        itemi.setItemMeta(itemm);
        return itemi;
    }

    public static ItemStack ZoukChoiceGuiItem(Player player)
    {
    	ItemStack itemi = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemm = itemi.getItemMeta();
        HashMap<String, Integer> JobUp = TeamVar.Team_JobUpgrade.get(TeamVar.Player_Team.get(player.getUniqueId()));
        int UpInt = JobUp.get(JobListUtil.Zouk);
        itemm.setDisplayName(ChatColor.WHITE + JobListUtil.Zouk);
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "현재 업그레이드 단계");
        lore.add(ChatColor.GRAY + " - " + UpInt);
        itemm.setLore(lore);
        
        itemi.setItemMeta(itemm);
        return itemi;
    }

    public static ItemStack[] BigGuyJobItem(Player player)
    {
        ItemStack Weapon = new ItemStack(Material.BLAZE_ROD);
        ItemMeta Weapon_M = Weapon.getItemMeta();
        AttributeModifier Weapon_A = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", 4, Operation.ADD_NUMBER, EquipmentSlot.HAND);
        Weapon_M.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, Weapon_A);
        HashMap<String, Integer> JobUp = TeamVar.Team_JobUpgrade.get(TeamVar.Player_Team.get(player.getUniqueId()));
        Weapon_M.setDisplayName(WordVar.XM + "빅가이 +" + JobUp.get(JobListUtil.BigGuy));
        Weapon.setItemMeta(Weapon_M);
        
        ItemStack Helmet = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta Helmet_M = (LeatherArmorMeta) Helmet.getItemMeta();
        Helmet_M.setColor(JobSelectTool.JobArmorColor(player));
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 0, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Helmet_A);
        Helmet_M.setDisplayName(WordVar.XM + TeamVar.Player_Team.get(player.getUniqueId()));
        Helmet_M.setUnbreakable(true);
        Helmet.setItemMeta(Helmet_M);
        
        int Chestplate_Int = TeamVar.Player_Upgrade.get(player.getUniqueId())[0];
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20+Chestplate_Int*5, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "갑옷 +" + Chestplate_Int);
        Chestplate_M.setUnbreakable(true);
        Chestplate.setItemMeta(Chestplate_M);
        
        int Leggings_Int = TeamVar.Player_Upgrade.get(player.getUniqueId())[1];
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1+Leggings_Int*1, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "하의 +" + Leggings_Int);
        Leggings_M.setUnbreakable(true);
        Leggings.setItemMeta(Leggings_M);
        
        int Boots_Int = TeamVar.Player_Upgrade.get(player.getUniqueId())[2];
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1+Boots_Int*0.1, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "신발 +" + Boots_Int);
        Boots_M.setUnbreakable(true);
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
        HashMap<String, Integer> JobUp = TeamVar.Team_JobUpgrade.get(TeamVar.Player_Team.get(player.getUniqueId()));
        Weapon_M.setDisplayName(WordVar.XM + "크루스 +" + JobUp.get(JobListUtil.Cruise));
        Weapon.setItemMeta(Weapon_M);
        
        ItemStack Helmet = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta Helmet_M = (LeatherArmorMeta) Helmet.getItemMeta();
        Helmet_M.setColor(JobSelectTool.JobArmorColor(player));
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 0, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Helmet_A);
        Helmet_M.setDisplayName(WordVar.XM + TeamVar.Player_Team.get(player.getUniqueId()));
        Helmet_M.setUnbreakable(true);
        Helmet.setItemMeta(Helmet_M);
        
        int Chestplate_Int = TeamVar.Player_Upgrade.get(player.getUniqueId())[0];
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20+Chestplate_Int*5, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "갑옷 +" + Chestplate_Int);
        Chestplate_M.setUnbreakable(true);
        Chestplate.setItemMeta(Chestplate_M);
        
        int Leggings_Int = TeamVar.Player_Upgrade.get(player.getUniqueId())[1];
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1+Leggings_Int*1, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "하의 +" + Leggings_Int);
        Leggings_M.setUnbreakable(true);
        Leggings.setItemMeta(Leggings_M);
        
        int Boots_Int = TeamVar.Player_Upgrade.get(player.getUniqueId())[2];
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1+Boots_Int*0.1, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "신발 +" + Boots_Int);
        Boots_M.setUnbreakable(true);
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
        HashMap<String, Integer> JobUp = TeamVar.Team_JobUpgrade.get(TeamVar.Player_Team.get(player.getUniqueId()));
        Weapon_M.setDisplayName(WordVar.XM + "에기스 +" + JobUp.get(JobListUtil.Egis));
        Weapon.setItemMeta(Weapon_M);
        
        ItemStack Helmet = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta Helmet_M = (LeatherArmorMeta) Helmet.getItemMeta();
        Helmet_M.setColor(JobSelectTool.JobArmorColor(player));
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 0, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Helmet_A);
        Helmet_M.setDisplayName(WordVar.XM + TeamVar.Player_Team.get(player.getUniqueId()));
        Helmet_M.setUnbreakable(true);
        Helmet.setItemMeta(Helmet_M);
        
        int Chestplate_Int = TeamVar.Player_Upgrade.get(player.getUniqueId())[0];
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20+Chestplate_Int*5, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "갑옷 +" + Chestplate_Int);
        Chestplate_M.setUnbreakable(true);
        Chestplate.setItemMeta(Chestplate_M);
        
        int Leggings_Int = TeamVar.Player_Upgrade.get(player.getUniqueId())[1];
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1+Leggings_Int*1, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "하의 +" + Leggings_Int);
        Leggings_M.setUnbreakable(true);
        Leggings.setItemMeta(Leggings_M);
        
        int Boots_Int = TeamVar.Player_Upgrade.get(player.getUniqueId())[2];
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1+Boots_Int*0.1, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "신발 +" + Boots_Int);
        Boots_M.setUnbreakable(true);
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
        HashMap<String, Integer> JobUp = TeamVar.Team_JobUpgrade.get(TeamVar.Player_Team.get(player.getUniqueId()));
        Weapon_M.setDisplayName(WordVar.XM + "파타이 +" + JobUp.get(JobListUtil.Patai));
        Weapon.setItemMeta(Weapon_M);
        
        ItemStack Helmet = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta Helmet_M = (LeatherArmorMeta) Helmet.getItemMeta();
        Helmet_M.setColor(JobSelectTool.JobArmorColor(player));
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 0, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Helmet_A);
        Helmet_M.setDisplayName(WordVar.XM + TeamVar.Player_Team.get(player.getUniqueId()));
        Helmet_M.setUnbreakable(true);
        Helmet.setItemMeta(Helmet_M);
        
        int Chestplate_Int = TeamVar.Player_Upgrade.get(player.getUniqueId())[0];
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20+Chestplate_Int*5, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "갑옷 +" + Chestplate_Int);
        Chestplate_M.setUnbreakable(true);
        Chestplate.setItemMeta(Chestplate_M);
        
        int Leggings_Int = TeamVar.Player_Upgrade.get(player.getUniqueId())[1];
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1+Leggings_Int*1, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "하의 +" + Leggings_Int);
        Leggings_M.setUnbreakable(true);
        Leggings.setItemMeta(Leggings_M);
        
        int Boots_Int = TeamVar.Player_Upgrade.get(player.getUniqueId())[2];
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1+Boots_Int*0.1, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "신발 +" + Boots_Int);
        Boots_M.setUnbreakable(true);
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
        HashMap<String, Integer> JobUp = TeamVar.Team_JobUpgrade.get(TeamVar.Player_Team.get(player.getUniqueId()));
        Weapon_M.setDisplayName(WordVar.XM + "봄버 +" + JobUp.get(JobListUtil.Bomber));
        Weapon.setItemMeta(Weapon_M);
        
        ItemStack Helmet = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta Helmet_M = (LeatherArmorMeta) Helmet.getItemMeta();
        Helmet_M.setColor(JobSelectTool.JobArmorColor(player));
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 0, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Helmet_A);
        Helmet_M.setDisplayName(WordVar.XM + TeamVar.Player_Team.get(player.getUniqueId()));
        Helmet_M.setUnbreakable(true);
        Helmet.setItemMeta(Helmet_M);
        
        int Chestplate_Int = TeamVar.Player_Upgrade.get(player.getUniqueId())[0];
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20+Chestplate_Int*5, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "갑옷 +" + Chestplate_Int);
        Chestplate_M.setUnbreakable(true);
        Chestplate.setItemMeta(Chestplate_M);
        
        int Leggings_Int = TeamVar.Player_Upgrade.get(player.getUniqueId())[1];
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1+Leggings_Int*1, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "하의 +" + Leggings_Int);
        Leggings_M.setUnbreakable(true);
        Leggings.setItemMeta(Leggings_M);
        
        int Boots_Int = TeamVar.Player_Upgrade.get(player.getUniqueId())[2];
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1+Boots_Int*0.1, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "신발 +" + Boots_Int);
        Boots_M.setUnbreakable(true);
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
        HashMap<String, Integer> JobUp = TeamVar.Team_JobUpgrade.get(TeamVar.Player_Team.get(player.getUniqueId()));
        Weapon_M.setDisplayName(WordVar.XM + "페스트 +" + JobUp.get(JobListUtil.Faster));
        Weapon.setItemMeta(Weapon_M);
        
        ItemStack Helmet = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta Helmet_M = (LeatherArmorMeta) Helmet.getItemMeta();
        Helmet_M.setColor(JobSelectTool.JobArmorColor(player));
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 0, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Helmet_A);
        Helmet_M.setDisplayName(WordVar.XM + TeamVar.Player_Team.get(player.getUniqueId()));
        Helmet_M.setUnbreakable(true);
        Helmet.setItemMeta(Helmet_M);
        
        int Chestplate_Int = TeamVar.Player_Upgrade.get(player.getUniqueId())[0];
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20+Chestplate_Int*5, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "갑옷 +" + Chestplate_Int);
        Chestplate_M.setUnbreakable(true);
        Chestplate.setItemMeta(Chestplate_M);
        
        int Leggings_Int = TeamVar.Player_Upgrade.get(player.getUniqueId())[1];
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1+Leggings_Int*1, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "하의 +" + Leggings_Int);
        Leggings_M.setUnbreakable(true);
        Leggings.setItemMeta(Leggings_M);
        
        int Boots_Int = TeamVar.Player_Upgrade.get(player.getUniqueId())[2];
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1+Boots_Int*0.1, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "신발 +" + Boots_Int);
        Boots_M.setUnbreakable(true);
        Boots.setItemMeta(Boots_M);
        
        ItemStack itemlist[] = { Weapon, Helmet, Chestplate, Leggings, Boots };
        return itemlist;
    }

    public static ItemStack[] KratosJobItem(Player player)
    {
        ItemStack Weapon = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta Weapon_M = Weapon.getItemMeta();
        AttributeModifier Weapon_A = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", 4, Operation.ADD_NUMBER, EquipmentSlot.HAND);
        Weapon_M.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, Weapon_A);
        HashMap<String, Integer> JobUp = TeamVar.Team_JobUpgrade.get(TeamVar.Player_Team.get(player.getUniqueId()));
        Weapon_M.setDisplayName(WordVar.XM + "크라토스 +" + JobUp.get(JobListUtil.Kratos));
        Weapon.setItemMeta(Weapon_M);
        
        ItemStack Helmet = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta Helmet_M = (LeatherArmorMeta) Helmet.getItemMeta();
        Helmet_M.setColor(JobSelectTool.JobArmorColor(player));
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 0, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Helmet_A);
        Helmet_M.setDisplayName(WordVar.XM + TeamVar.Player_Team.get(player.getUniqueId()));
        Helmet_M.setUnbreakable(true);
        Helmet.setItemMeta(Helmet_M);
        
        int Chestplate_Int = TeamVar.Player_Upgrade.get(player.getUniqueId())[0];
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20+Chestplate_Int*5, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "갑옷 +" + Chestplate_Int);
        Chestplate_M.setUnbreakable(true);
        Chestplate.setItemMeta(Chestplate_M);
        
        int Leggings_Int = TeamVar.Player_Upgrade.get(player.getUniqueId())[1];
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1+Leggings_Int*1, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "하의 +" + Leggings_Int);
        Leggings_M.setUnbreakable(true);
        Leggings.setItemMeta(Leggings_M);
        
        int Boots_Int = TeamVar.Player_Upgrade.get(player.getUniqueId())[2];
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1+Boots_Int*0.1, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "신발 +" + Boots_Int);
        Boots_M.setUnbreakable(true);
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
        HashMap<String, Integer> JobUp = TeamVar.Team_JobUpgrade.get(TeamVar.Player_Team.get(player.getUniqueId()));
        Weapon_M.setDisplayName(WordVar.XM + "살루란 +" + JobUp.get(JobListUtil.Saluran));
        Weapon.setItemMeta(Weapon_M);
        
        ItemStack Helmet = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta Helmet_M = (LeatherArmorMeta) Helmet.getItemMeta();
        Helmet_M.setColor(JobSelectTool.JobArmorColor(player));
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 0, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Helmet_A);
        Helmet_M.setDisplayName(WordVar.XM + TeamVar.Player_Team.get(player.getUniqueId()));
        Helmet_M.setUnbreakable(true);
        Helmet.setItemMeta(Helmet_M);
        
        int Chestplate_Int = TeamVar.Player_Upgrade.get(player.getUniqueId())[0];
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20+Chestplate_Int*5, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "갑옷 +" + Chestplate_Int);
        Chestplate_M.setUnbreakable(true);
        Chestplate.setItemMeta(Chestplate_M);
        
        int Leggings_Int = TeamVar.Player_Upgrade.get(player.getUniqueId())[1];
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1+Leggings_Int*1, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "하의 +" + Leggings_Int);
        Leggings_M.setUnbreakable(true);
        Leggings.setItemMeta(Leggings_M);
        
        int Boots_Int = TeamVar.Player_Upgrade.get(player.getUniqueId())[2];
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1+Boots_Int*0.1, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "신발 +" + Boots_Int);
        Boots_M.setUnbreakable(true);
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
        HashMap<String, Integer> JobUp = TeamVar.Team_JobUpgrade.get(TeamVar.Player_Team.get(player.getUniqueId()));
        Weapon_M.setDisplayName(WordVar.XM + "팔라딘 +" + JobUp.get(JobListUtil.Paladin));
        Weapon.setItemMeta(Weapon_M);
        
        ItemStack Helmet = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta Helmet_M = (LeatherArmorMeta) Helmet.getItemMeta();
        Helmet_M.setColor(JobSelectTool.JobArmorColor(player));
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 0, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Helmet_A);
        Helmet_M.setDisplayName(WordVar.XM + TeamVar.Player_Team.get(player.getUniqueId()));
        Helmet_M.setUnbreakable(true);
        Helmet.setItemMeta(Helmet_M);
        
        int Chestplate_Int = TeamVar.Player_Upgrade.get(player.getUniqueId())[0];
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20+Chestplate_Int*5, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "갑옷 +" + Chestplate_Int);
        Chestplate_M.setUnbreakable(true);
        Chestplate.setItemMeta(Chestplate_M);
        
        int Leggings_Int = TeamVar.Player_Upgrade.get(player.getUniqueId())[1];
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1+Leggings_Int*1, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "하의 +" + Leggings_Int);
        Leggings_M.setUnbreakable(true);
        Leggings.setItemMeta(Leggings_M);
        
        int Boots_Int = TeamVar.Player_Upgrade.get(player.getUniqueId())[2];
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1+Boots_Int*0.1, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "신발 +" + Boots_Int);
        Boots_M.setUnbreakable(true);
        Boots.setItemMeta(Boots_M);
        
        ItemStack itemlist[] = { Weapon, Helmet, Chestplate, Leggings, Boots };
        return itemlist;
    }

    public static ItemStack[] PemanahJobItem(Player player)
    {
        ItemStack Weapon = new ItemStack(Material.BOW);
        ItemMeta Weapon_M = Weapon.getItemMeta();
        HashMap<String, Integer> JobUp = TeamVar.Team_JobUpgrade.get(TeamVar.Player_Team.get(player.getUniqueId()));
        Weapon_M.setDisplayName(WordVar.XM + "페모나 +" + JobUp.get(JobListUtil.Pemanah));
        Weapon_M.setUnbreakable(true);
        Weapon.setItemMeta(Weapon_M);
        Weapon.addEnchantment(Enchantment.ARROW_INFINITE, 1);
        
        ItemStack Helmet = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta Helmet_M = (LeatherArmorMeta) Helmet.getItemMeta();
        Helmet_M.setColor(JobSelectTool.JobArmorColor(player));
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 0, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Helmet_A);
        Helmet_M.setDisplayName(WordVar.XM + TeamVar.Player_Team.get(player.getUniqueId()));
        Helmet_M.setUnbreakable(true);
        Helmet.setItemMeta(Helmet_M);
        
        int Chestplate_Int = TeamVar.Player_Upgrade.get(player.getUniqueId())[0];
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20+Chestplate_Int*5, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "갑옷 +" + Chestplate_Int);
        Chestplate_M.setUnbreakable(true);
        Chestplate.setItemMeta(Chestplate_M);
        
        int Leggings_Int = TeamVar.Player_Upgrade.get(player.getUniqueId())[1];
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1+Leggings_Int*1, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "하의 +" + Leggings_Int);
        Leggings_M.setUnbreakable(true);
        Leggings.setItemMeta(Leggings_M);
        
        int Boots_Int = TeamVar.Player_Upgrade.get(player.getUniqueId())[2];
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1+Boots_Int*0.1, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "신발 +" + Boots_Int);
        Boots_M.setUnbreakable(true);
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
        HashMap<String, Integer> JobUp = TeamVar.Team_JobUpgrade.get(TeamVar.Player_Team.get(player.getUniqueId()));
        Weapon_M.setDisplayName(WordVar.XM + "주크 +" + JobUp.get(JobListUtil.Zouk));
        Weapon.setItemMeta(Weapon_M);
        
        ItemStack Helmet = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta Helmet_M = (LeatherArmorMeta) Helmet.getItemMeta();
        Helmet_M.setColor(JobSelectTool.JobArmorColor(player));
        AttributeModifier Helmet_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 0, Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        Helmet_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Helmet_A);
        Helmet_M.setDisplayName(WordVar.XM + TeamVar.Player_Team.get(player.getUniqueId()));
        Helmet_M.setUnbreakable(true);
        Helmet.setItemMeta(Helmet_M);
        
        int Chestplate_Int = TeamVar.Player_Upgrade.get(player.getUniqueId())[0];
        ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.max_health", 20+Chestplate_Int*5, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "갑옷 +" + Chestplate_Int);
        Chestplate_M.setUnbreakable(true);
        Chestplate.setItemMeta(Chestplate_M);
        
        int Leggings_Int = TeamVar.Player_Upgrade.get(player.getUniqueId())[1];
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistance", 1+Leggings_Int*1, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "하의 +" + Leggings_Int);
        Leggings_M.setUnbreakable(true);
        Leggings.setItemMeta(Leggings_M);
        
        int Boots_Int = TeamVar.Player_Upgrade.get(player.getUniqueId())[2];
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.movement_speed", 0.1+Boots_Int*0.1, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "신발 +" + Boots_Int);
        Boots_M.setUnbreakable(true);
        Boots.setItemMeta(Boots_M);
        
        ItemStack itemlist[] = { Weapon, Helmet, Chestplate, Leggings, Boots };
        return itemlist;
    }
    
    public static ItemStack[] ScienceGuiItem(Player player) {
    	
    	if (!TeamVar.Player_Upgrade.containsKey(player.getUniqueId())) {
    		int[] UpInt = {0,0,0};
    		TeamVar.Player_Upgrade.put(player.getUniqueId(), UpInt);
    	}
    	int[] UpInt = TeamVar.Player_Upgrade.get(player.getUniqueId());
    	List<String> lore = new ArrayList<String>();
    	
    	ItemStack Chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Chestplate_M = Chestplate.getItemMeta();
        AttributeModifier Chestplate_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 0, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        Chestplate_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Chestplate_A);
        Chestplate_M.setDisplayName(WordVar.XM + "+" + UpInt[0]);
        lore.clear();
        lore.add(ChatColor.GRAY + player.getName());
        lore.add(WordVar.Chest_Up);
        Chestplate_M.setLore(lore);
        Chestplate.setItemMeta(Chestplate_M);
        
        ItemStack Leggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta Leggings_M = Leggings.getItemMeta();
        AttributeModifier Leggings_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 0, Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        Leggings_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Leggings_A);
        Leggings_M.setDisplayName(WordVar.XM + "+" + UpInt[1]);
        lore.clear();
        lore.add(ChatColor.GRAY + player.getName());
        lore.add(WordVar.Leg_Up);
        Leggings_M.setLore(lore);
        Leggings.setItemMeta(Leggings_M);
        
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta Boots_M = Boots.getItemMeta();
        AttributeModifier Boots_A = new AttributeModifier(UUID.randomUUID(), "generic.armor", 0, Operation.ADD_NUMBER, EquipmentSlot.FEET);
        Boots_M.addAttributeModifier(Attribute.GENERIC_ARMOR, Boots_A);
        Boots_M.setDisplayName(WordVar.XM + "+" + UpInt[2]);
        lore.clear();
        lore.add(ChatColor.GRAY + player.getName());
        lore.add(WordVar.Boots_Up);
        Boots_M.setLore(lore);
        Boots.setItemMeta(Boots_M);
        
        ItemStack itemlist[] = { Chestplate, Leggings, Boots };
        return itemlist;
    }
}
