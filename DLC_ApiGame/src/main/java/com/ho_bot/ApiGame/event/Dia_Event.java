package com.ho_bot.ApiGame.event;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import com.ho_bot.ApiGame.file.player.PlayerDiaFile;
import com.ho_bot.ApiGame.util.VarUtil;
import com.ho_bot.ApiGame.util.VarUtil.DiaSubmitType;
import com.ho_bot.ApiGame.util.VarUtil.GameType;

public class Dia_Event implements Listener{
	
	private PlayerDiaFile pdf = new PlayerDiaFile();
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		pdf.createPlayerDia(event.getPlayer());
	}
	
	@EventHandler
	public void onDiaInteract(PlayerInteractEvent event) {
		if(!VarUtil.apiGameConfig.able) return;
		if(VarUtil.apiGameConfig.gametype != GameType.DiaGame) return;
		if(!VarUtil.dia_Board.isSubmit) return;
		if(VarUtil.dia_Board.type != DiaSubmitType.RightClick) return;
		if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(event.getItem() == null) return;
			if(event.getItem().getType() != Material.DIAMOND) return;
			int count = event.getItem().getAmount();
			pdf.addCompleteDia(event.getPlayer().getUniqueId(), count);
			event.getItem().setAmount(0);
		}
	}
	
	@EventHandler
	public void onDiaDrop(PlayerDropItemEvent event) {
		if(!VarUtil.apiGameConfig.able) return;
		if(VarUtil.apiGameConfig.gametype != GameType.DiaGame) return;
		if(!VarUtil.dia_Board.isSubmit) return;
		if(VarUtil.dia_Board.type != DiaSubmitType.Drop) return;
		if(event.getItemDrop().getItemStack().getType() == Material.DIAMOND) {
			int count = event.getItemDrop().getItemStack().getAmount();
			pdf.addCompleteDia(event.getPlayer().getUniqueId(), count);
			event.getItemDrop().remove();
		}
	}

}
