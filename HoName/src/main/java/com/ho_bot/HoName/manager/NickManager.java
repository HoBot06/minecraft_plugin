package com.ho_bot.HoName.manager;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.EnumSet;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers;
import com.comphenix.protocol.wrappers.EnumWrappers.NativeGameMode;
import com.comphenix.protocol.wrappers.EnumWrappers.PlayerInfoAction;
import com.comphenix.protocol.wrappers.PlayerInfoData;
import com.ho_bot.HoName.main.HoName;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import com.comphenix.protocol.wrappers.WrappedGameProfile;

public class NickManager {
	
	public void changeName(Player player, String newName) {
		PacketContainer packet = updateDisplayName(player, newName);
		for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            HoName.protocolM.sendServerPacket(onlinePlayer, packet);
            onlinePlayer.hidePlayer(player);
            onlinePlayer.showPlayer(player);
        }
	}

	public PacketContainer updateDisplayName(Player player, String newName) {
        PacketContainer packet = new PacketContainer(PacketType.Play.Server.PLAYER_INFO);
        packet.getPlayerInfoActions().write(0, EnumSet.of(
                EnumWrappers.PlayerInfoAction.UPDATE_DISPLAY_NAME,
                EnumWrappers.PlayerInfoAction.ADD_PLAYER,
                EnumWrappers.PlayerInfoAction.UPDATE_LATENCY,
                EnumWrappers.PlayerInfoAction.UPDATE_LISTED,
                EnumWrappers.PlayerInfoAction.UPDATE_GAME_MODE
        ));

        WrappedGameProfile gameProfile = new WrappedGameProfile(player.getUniqueId(), newName);
        packet.getPlayerInfoDataLists().write(1, Collections.singletonList(new PlayerInfoData(
                gameProfile,
                player.getPing(),
                EnumWrappers.NativeGameMode.fromBukkit(player.getGameMode()),
                WrappedChatComponent.fromText(newName)
        )));

        return packet;
    }
}
