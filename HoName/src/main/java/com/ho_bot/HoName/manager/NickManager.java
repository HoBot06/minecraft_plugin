package com.ho_bot.HoName.manager;

import java.util.Collections;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers;
import com.comphenix.protocol.wrappers.PlayerInfoData;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import com.comphenix.protocol.wrappers.WrappedGameProfile;
import com.ho_bot.HoName.main.HoName;

public class NickManager {

	public void changePlayerNameTag(Player player, String newname) { // Currently isn't working and isn't coloring and bolding
        PacketContainer nameTagPacket = HoName.protocolM.createPacket(PacketType.Play.Server.PLAYER_INFO);
        PlayerInfoData playerInfo = new PlayerInfoData(
                WrappedGameProfile.fromPlayer(player),
                1,
                EnumWrappers.NativeGameMode.fromBukkit(player.getGameMode()),
                WrappedChatComponent.fromText(newname)
        );
//        PlayerInfoData new_playerinfo = new PlayerInfoData(playerInfo.getProfileId(),
//                playerInfo.getLatency(), playerInfo.isListed(), playerInfo.getGameMode(),
//                playerInfo.getProfile(), playerInfo.getDisplayName());

		// write it into packet
		nameTagPacket.getPlayerInfoDataLists().write(1, Collections.singletonList(playerInfo));
        try {
            HoName.protocolM.sendServerPacket(player, nameTagPacket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public void resetPlayerNameTag(Player player) {
        PacketContainer nameTagPacket = HoName.protocolM.createPacket(PacketType.Play.Server.PLAYER_INFO);
        nameTagPacket.getPlayerInfoAction().write(0, EnumWrappers.PlayerInfoAction.UPDATE_DISPLAY_NAME);
        nameTagPacket.getPlayerInfoDataLists().write(0, Collections.singletonList(new PlayerInfoData(
                WrappedGameProfile.fromPlayer(player),
                1,
                EnumWrappers.NativeGameMode.fromBukkit(player.getGameMode()),
                WrappedChatComponent.fromText(player.getName()) // Original name without formatting
        )));
        try {
        	HoName.protocolM.sendServerPacket(player, nameTagPacket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
}
