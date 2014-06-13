package gaseousMC.deathlymad.entity;

import gaseousMC.deathlymad.block.BlockSmoke;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySmoker extends TileEntity {
	
	int tickcounter=0;
	int T;
	
	public TileEntitySmoker(int temp)
	{
		super();
		T=temp;
	}
	
	@Override
	public void updateEntity()
	{
		tickcounter++;
		if (tickcounter>=100)
		{
			tickcounter=0;
			
			if(worldObj.getBlockId(xCoord, yCoord+1, zCoord)==0)
			{
				worldObj.setBlock(xCoord, yCoord+1, zCoord, BlockSmoke.id);
			}else if (worldObj.getBlockTileEntity(xCoord, yCoord+1, zCoord)!=null)
			{
				if(worldObj.getBlockTileEntity(xCoord, yCoord+1, zCoord)instanceof TileEntitySmoke)
				{
					TileEntitySmoke te = (TileEntitySmoke) worldObj.getBlockTileEntity(xCoord, yCoord+1, zCoord);
				
					te.setTemp(T);
				}
			}
		}
	}
}
