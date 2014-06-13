package gaseousMC.deathlymad.blocks.vanilla;

import gaseousMC.deathlymad.entity.TileEntitySmoker;
import net.minecraft.block.BlockTorch;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ModTorch extends BlockTorch {

	public ModTorch(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		par1World.setBlock(par2, par3, par4, blockID);
		par1World.setBlockTileEntity( par2, par3, par4, createTileEntity(par1World, 0));
	}
	
	@Override
	public TileEntity createTileEntity(World w, int metadata)
	{
		return new TileEntitySmoker(456);
	}
	
	@Override
	public void breakBlock(World w, int x, int y, int z, int i, int j)
	{
		w.removeBlockTileEntity(x, y, z);
	}
	
}
