package com.ho_bot.ApiGame.tools;

import java.util.UUID;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.ho_bot.ApiGame.classes.RoulClass;
import com.ho_bot.ApiGame.classes.roul.RoulChat;
import com.ho_bot.ApiGame.classes.roul.RoulList;
import com.ho_bot.ApiGame.classes.roul.RoulTitle;
import com.ho_bot.ApiGame.classes.roul.roulVar;
import com.ho_bot.ApiGame.file.player.PlayerDiaFile;
import com.ho_bot.ApiGame.util.CmdUtil;
import com.ho_bot.ApiGame.util.VarUtil;
import com.ho_bot.ApiGame.util.VarUtil.RoulType;

public class RoulTools {
	
	private PlayerDiaFile pdf = new PlayerDiaFile();
	private CmdUtil cmdU = new CmdUtil();
	
	public void runRoul(Player player, String roulname, UUID uuid, String playername, String sender, String platform, int cash) {
		if(!VarUtil.roulMap.containsKey(roulname)) return;
		RoulClass roul = VarUtil.roulMap.get(roulname);
		RoulList r_roul = roul.getRandRoul();
		roulVar roulv = runType(player, r_roul, uuid, playername, sender, platform, cash);
		if(roul.r_chat != null) {
			RoulChat chat = roul.r_chat;
			if(chat.isEnable) {
				player.sendMessage(replaceMsg(chat.msg, roulv.type, roulv.amo));
			}
		}
		if(roul.r_title != null) {
			RoulTitle title = roul.r_title;
			if(title.isEnable) {
				player.sendTitle(replaceMsg(title.mainmsg, roulv.type, roulv.amo), replaceMsg(title.submsg, roulv.type, roulv.amo), title.fadeIn, title.fadeStay, title.fadeOut);
			}
		}
	}
	
	private roulVar runType(Player player, RoulList roul, UUID uuid, String playername, String sender, String platform, int cash) {
		if(roul.roultype == RoulType.Diamond) {
			pdf.addRemainDia(player.getUniqueId(), roul.amo);
			return new roulVar(RoulType.Diamond, roul.amo);
		}
		if(roul.roultype == RoulType.Monster) {
			EntityType type = EntityType.valueOf(roul.type);
			for(int i = 0; i < roul.amo; i++) {
				player.getWorld().spawnEntity(player.getLocation(), type);
			}
			return new roulVar(RoulType.Monster, roul.amo);
		}
		if(roul.roultype == RoulType.Buff) {
			PotionEffectType type = PotionEffectType.getByName(roul.type);
			PotionEffect effect = new PotionEffect(type, roul.duration, roul.power);
			effect.apply(player);
			return new roulVar(RoulType.Buff, roul.amo);
		}
		if(roul.roultype == RoulType.Command) {
			for(String s_cmd : roul.cmdlist) {
				cmdU.runCmd(s_cmd, uuid, playername, sender, platform, cash);
			}
			return new roulVar(RoulType.Command, roul.amo);
		}
		return null;
	}
	
	private String replaceMsg(String msg, RoulType type, int amo) {
		msg = msg.replace("%종류%", type.getString());
		msg = msg.replace("%갯수%", amo+"");
		return msg;
	}

}
