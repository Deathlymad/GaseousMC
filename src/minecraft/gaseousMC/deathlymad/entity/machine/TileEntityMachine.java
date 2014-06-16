package gaseousMC.deathlymad.entity.machine;

import gaseousMC.deathlymad.Enum.gas;

import net.minecraft.tileentity.TileEntity;

import ic2.api.energy.tile.IEnergySink;

import buildcraft.api.power.IPowerReceptor;
import buildcraft.api.power.PowerHandler;

public class TileEntityMachine extends TileEntity implements IEnergySink /*IC2 Energy Interface */, IPowerReceptor /*BC Power Interface*/ {

	public gas[] spawnsSmoke;
	int tickcounter=0;
	int TickDelay=20
	
	public final PowerHandler BCPowerHandler = new PowerHangdler(this, MACHINE);
	
	public TileEntityMachine(gas[] spawnsSmoke2 /*Sets the smoke being emmitted while machine is running*/) {
		spawnsSmoke=spawnsSmoke2;
	}

	@Override
	public void updateEntity()
	{
		tickcounter++;
		
		if(tickcounter>=TickDelay)
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
