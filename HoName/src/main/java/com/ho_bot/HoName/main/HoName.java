package com.ho_bot.HoName.main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.PlayerInfoData;
import com.comphenix.protocol.wrappers.WrappedGameProfile;
import com.ho_bot.HoName.cmd.HN_Cmd;
import com.ho_bot.HoName.event.HN_Event;

public class HoName extends JavaPlugin {
	
	public static HoName inst;
	public static ProtocolManager protocolM;
	
	@Override
	public void onEnable() {
		inst = this;
		protocolM = ProtocolLibrary.getProtocolManager();
		//테스트
		ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(this, PacketType.Play.Server.PLAYER_INFO) {
	        @Override
	        public void onPacketSending(PacketEvent event) {
//	            PacketContainer packet = new PacketContainer(PacketType.Play.Server.PLAYER_INFO);
//	            packet.getModifier().writeDefaults();
//	            int mode = packet.getIntegers().read(0);
//	            if (mode != 0 && mode != 2) // 0 == TEAM_CREATE, 2 == TEAM_UPDATED
//	                return;
//	            packet.getChatComponents().write(0, WrappedChatComponent.fromLegacyText("Player name")); // FieldAccessException
//	            event.setPacket(packet);
	        	Bukkit.getLogger().info(event.getPacket().getPlayerInfoDataLists().read(1)+":before");
	        	PacketContainer packet = event.getPacket();
	        	List<PlayerInfoData> list = packet.getPlayerInfoDataLists().read(1);
	        	List<PlayerInfoData> fix_list = new ArrayList<>();
	        	for(PlayerInfoData pl : list) {
	        		WrappedGameProfile gameprofile = new WrappedGameProfile(pl.getProfile().getUUID(), "test");
	        		gameprofile.getProperties().putAll(pl.getProfile().getProperties());
	        		
	        		PlayerInfoData data = new PlayerInfoData(pl.getProfileId(), pl.getLatency(), pl.isListed(), pl.getGameMode(), gameprofile, pl.getDisplayName());
	        		fix_list.add(data);
	        	}
	        	packet.getPlayerInfoDataLists().write(1, fix_list);
	        	event.setPacket(packet);
	        	
	        	Bukkit.getLogger().info(event.getPacket().getPlayerInfoDataLists().read(1)+":after");
	        }
	    });
		
		HN_Event.setPlugin(this);
		getServer().getPluginManager().registerEvents(new HN_Event(), this);
        
        getCommand("HoName").setExecutor(new HN_Cmd());
        getCommand("HoName").setTabCompleter(new HN_Cmd());
        
        getConfig().options().copyDefaults(true);
        saveConfig();
	}

}
