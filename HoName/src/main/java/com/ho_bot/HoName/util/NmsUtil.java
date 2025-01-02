package com.ho_bot.HoName.util;

import java.util.Collections;
import java.util.List;

import org.bukkit.entity.Player;

import com.comphenix.protocol.wrappers.EnumWrappers;
import com.comphenix.protocol.wrappers.PlayerInfoData;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import com.comphenix.protocol.wrappers.WrappedGameProfile;

public class NmsUtil {

	public static PlayerInfoData getPlayerInfoData(Player player) {
	    return new PlayerInfoData(WrappedGameProfile.fromPlayer(player), player.getPing(), EnumWrappers.NativeGameMode.fromBukkit(player.getGameMode()), WrappedChatComponent.fromText(player.getDisplayName()));
	}

	public static List<PlayerInfoData> getPlayerInfoDataList(Player player) {
	    return Collections.singletonList(getPlayerInfoData(player));
	}
}
