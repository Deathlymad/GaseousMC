package gaseousMC.deathlymad.entity;

import gaseousMC.deathlymad.block.BlockSmoke;
import net.minecraft.tileentity.TileEntityFurnace;
import gaseousMC.deathlymad.entity.TileEntitySmoke;
import gaseousMC.deathlymad.Enum.gas;

public class TileEntityModFurnace extends TileEntityFurnace { //basicly a copy of TileEntitySmoker besides the fact that it is still a furnace
	
	int T;
	int tickcounter=0;
	
	public TileEntityModFurnace(int temp)
	{
		super();
		T=temp;
	}
	
	@Override
	public void updateEntity()
	{
		super.updateEntity();
		tickcounter++;
		if (tickcounter>=100)
		{
			tickcounter=0;
			
			if(worldObj.getBlockId(xCoord, yCoord+1, zCoord)==0)
			{
				worldObj.setBlock(xCoord, yCoord+1, zCoord, BlockSmoke.id);
				/*
				TileEntitySmoke tempTE = (TileEntitySmoke)worldObj.getBlockTileEntity(xCoord, yCoord+1, zCoord);
				
				tempTE.addGasToList(gas.carbonmonoxide);
				tempTE.addGasToList(gas.carbondioxide);
				tempTE.addGasToList(gas.sulfurdioxide);*/
				
			}else if (worldObj.getBlockTileEntity(xCoord, yCoord+1, zCoord)!=null)
			{
				if(worldObj.getBlockTileEntity(xCoord, yCoord+1, zCoord) instanceof TileEntitySmoke)
				{
					TileEntitySmoke te = (TileEntitySmoke) worldObj.getBlockTileEntity(xCoord, yCoord+1, zCoord);
				
					te.setTemp(T);
					te.updateEntity();
				}
			}
		}
	}
}
