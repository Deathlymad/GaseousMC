package gaseousMC.deathlymad.machine;

import gaseousMC.deathlymad.Enum.gas;
import gaseousMC.deathlymad.entity.machine.TileEntityMachine;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class MachineBase extends Block {//TODO
	
	//Power Varibales
	public int power;
	public int pwrIn;
	public int pwrout;
	public gas[] spawnsSmoke;
	
	public MachineBase(int par1, gas[] smoke) {
		super(par1, Material.iron);
		spawnsSmoke=smoke;
	}
	
	@Override
	public TileEntity createTileEntity(World w, int metadata)
	{
		return new TileEntityMachine(spawnsSmoke);
	}
	
	
}
