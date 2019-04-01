package me.mrdaniel.adventuremmo.listeners;

import me.mrdaniel.adventuremmo.AdventureMMO;
import me.mrdaniel.adventuremmo.MMOObject;
import me.mrdaniel.adventuremmo.utils.ItemUtils;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.network.ClientConnectionEvent;

import javax.annotation.Nonnull;

public class ClientListener extends MMOObject {

	public ClientListener(@Nonnull final AdventureMMO mmo) {
		super(mmo);
	}

	@Listener
	public void onQuit(final ClientConnectionEvent.Disconnect e) {
		super.getMMO().getPlayerDatabase().unload(e.getTargetEntity().getUniqueId());
		super.getMMO().getMenus().getScoreboardManager().unload(e.getTargetEntity());
		ItemUtils.restoreSuperTool(e.getTargetEntity(), super.getMMO().getContainer());
	}
}