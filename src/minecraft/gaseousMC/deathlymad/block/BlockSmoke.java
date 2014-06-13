package gaseousMC.deathlymad.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.network.packet.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import gaseousMC.deathlymad.Enum.gas;
import gaseousMC.deathlymad.entity.TileEntitySmoke;

public class BlockSmoke extends Block {
	
	public static int id;
	
	public BlockSmoke(int par1, gas[] mix) {
		super(par1, Material.air);
		this.setBlockUnbreakable();
		this.setLightOpacity(0);
		this.setTickRandomly(true);
		this.setUnlocalizedName("Smoke");
		id=this.blockID;
		//this.setBlockBounds(0.0f, 0.0f, 0.0f, 0.1f, 0.1f, 0.1f);
	}
	
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }
	
	@Override
	public TileEntity createTileEntity(World w, int metadata)
	{
		gas[] mix = {gas.carbondioxide};
		return new TileEntitySmoke(mix);
	}
	
	@Override
	public void randomDisplayTick (World par1World, int par2, int par3, int par4, Random par5Random)//ticks randomly to render smoke particle
	{
            float f = (float)par2 + 0.5F;
            float f1 = (float)par3 + 0.0F + par5Random.nextFloat() * 6.0F / 16.0F;
            float f2 = (float)par4 + 0.5F;
            float f3 = 0.52F;
            float f4 = par5Random.nextFloat() * 0.6F - 0.3F;
            par1World.spawnParticle("smoke", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("smoke", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
	}

	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		par1World.setBlock(par2, par3, par4, blockID);
		par1World.setBlockTileEntity( par2, par3, par4, createTileEntity(par1World, 0));
	}
	
	@Override
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	@Override
	public void breakBlock(World w, int x, int y, int z, int i, int j)
	{
		w.removeBlockTileEntity(x, y, z);
	}

}
