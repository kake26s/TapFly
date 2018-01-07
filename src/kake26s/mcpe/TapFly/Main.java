package kake26s.mcpe.TapFly;


import cn.nukkit.Player;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.event.Listener;
import cn.nukkit.math.Vector3;
import cn.nukkit.item.Item;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.player.PlayerInteractEvent;

public class Main extends PluginBase implements Listener{

    @Override
    public void onEnable(){
        this.getServer().getLogger().info("§b[TapFly]起動しました");
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onInterct(PlayerInteractEvent e){
        Player pl = e.getPlayer();
        Item item = pl.getInventory().getItemInHand();
        int itemid = item.getId();
        if(itemid == Item.WOODEN_SWORD) {
            double yaw = pl.getYaw();
            double pitch = pl.getPitch();
            double addX = -Math.sin(yaw * Math.PI / 180) * Math.cos(pitch * Math.PI / 180);
            double addY = -Math.sin(pitch * Math.PI / 180);
            double addZ = Math.cos(yaw * Math.PI / 180) * Math.cos(pitch * Math.PI / 180);
            pl.setMotion(new Vector3(addX, addY, addZ));
        }
    }
}
