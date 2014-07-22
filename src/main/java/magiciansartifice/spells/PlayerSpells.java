package magiciansartifice.spells;

import magiciansartifice.items.wand.Wand;
import magiciansartifice.utils.FlipTableException;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.*;

public class PlayerSpells {

    public static void levitation(EntityPlayer player) {
            if (player.motionY <= -0.5) {
                double newMotion = player.motionY / 2;
                player.motionY = newMotion;
                player.fallDistance = 0;
            }
    }

    public static void murderSpell(EntityPlayer player, EntityLivingBase entityLivingBase) {
            System.err.println("Started code!");
            if (entityLivingBase.attackEntityFrom(DamageSource.magic, 40.0F)) {
                System.err.println("Finished code!");
            } else {
                try {
                    throw new FlipTableException();
                } catch (FlipTableException ex) {
                    ex.printStackTrace();
                }
            }
    }

    public static void broadcastUnforgivableCurse(EntityPlayer player) {
        for (int i = 0; i < player.worldObj.playerEntities.size(); i++) {
            Vec3 playerVec = Vec3.createVectorHelper(player.posX, player.posY, player.posZ);
            Vec3 player2Vec = Vec3.createVectorHelper(((EntityPlayer) player.worldObj.playerEntities.get(i)).posX, ((EntityPlayer) player.worldObj.playerEntities.get(i)).posY, ((EntityPlayer) player.worldObj.playerEntities.get(i)).posZ);
            if (playerVec.distanceTo(player2Vec) <= 100) {
                if (((EntityPlayer) player.worldObj.playerEntities.get(i)).getCommandSenderName() != player.getCommandSenderName()) {
                    ((EntityPlayer) player.worldObj.playerEntities.get(i)).addChatComponentMessage(new ChatComponentTranslation("spell.unforgivable.announce").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.DARK_GRAY)));
                }
            }
        }
    }

}
