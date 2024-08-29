package com.ho_bot.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

import com.ho_bot.gamegui.FieldGui;
import com.ho_bot.gamegui.ItemOptionGui;
import com.ho_bot.main.HoMiniGame;
import com.ho_bot.util.VarUtil;

public class HMG_Event implements Listener{
	
	public static HoMiniGame plugin;

	public static void setPlugin(HoMiniGame MainPlugin)
    {
        plugin = MainPlugin;
    }
	
	public FieldGui fieldG = new FieldGui();
	public ItemOptionGui itemOG = new ItemOptionGui();
	
	@EventHandler
	public void onClickInv(InventoryClickEvent event) {
		itemOG.clickPlayerWeapon(event);
		itemOG.clickWeaponOption(event);
		fieldG.clickFieldGui(event);
	}

}
