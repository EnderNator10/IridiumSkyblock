package com.peaches.epicskyblock.listeners;

import com.peaches.epicskyblock.EpicSkyblock;
import com.peaches.epicskyblock.Island;
import com.peaches.epicskyblock.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class onBlockBreak implements Listener {

    @EventHandler
    public void onBreakBlock(BlockBreakEvent e) {
        User u = User.getUser(e.getPlayer().getName());
        if (e.getBlock().getLocation().getWorld().equals(EpicSkyblock.getIslandManager().getWorld())) {
            Island island = u.getIsland();
            if (island != null) {
                if ((e.getBlock().getX() > island.getPos1().getX() && e.getBlock().getX() <= island.getPos2().getX()) && (e.getBlock().getZ() > island.getPos1().getZ() && e.getBlock().getZ() <= island.getPos2().getZ())) {
                    // Block is in players island
                } else {
                    e.setCancelled(true);
                }
            } else {
                e.setCancelled(true);
            }
        }
    }
}
