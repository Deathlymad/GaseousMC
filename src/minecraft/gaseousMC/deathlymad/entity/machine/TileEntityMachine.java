package gaseousMC.deathlymad.entity.machine;

import gaseousMC.deathlymad.Enum.gas;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMachine extends TileEntity {

	public gas[] spawnsSmoke;
	int tickcounter=0;
	
	public TileEntityMachine(gas[] spawnsSmoke2) {
		spawnsSmoke=spawnsSmoke2;
	}

	@Override
	public void updateEntity()
	{
		tickcounter++;
		
		if(tickcounter>=100)
		{
			if (spawnsSmoke[0]!=gas.ERRGAS)
				{
					if(this.worldObj.getBlockId(this.xCoord, this.yCoord+1, this.zCoord)==0)
						this.worldObj.setBlock(this.xCoord, this.yCoord+1, this.zCoord ,0);
					
				}
			tickcounter=0;
		}
	}
}