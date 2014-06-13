package gaseousMC.main;

//standard FML Imports
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


//Our Imports

import gaseousMC.deathlymad.Enum.gas;
import gaseousMC.deathlymad.block.BlockSmoke;
import gaseousMC.deathlymad.blocks.vanilla.ModFurnace;
import gaseousMC.deathlymad.blocks.vanilla.ModTorch;
import gaseousMC.main.proxy.GaseousMCCommonProxy;


//Other Imports

import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.BlockTorch;
import net.minecraft.creativetab.CreativeTabs;


@Mod(modid = "gaseousMC", name = "GaseousMC", version = "0.0.1")
@NetworkMod(clientSideRequired=true)
public class GaseousMC {
	@Instance(value = "gaseousMC")
    public static GaseousMC instance;
    
    @SidedProxy(clientSide="gaseousMC.main.proxy.GaseousMCClientProxy", serverSide="gaseousMC.main.proxy.GaseousMCClientProxy")
    public static GaseousMCCommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	
    }
    
    @EventHandler
    public void load(FMLInitializationEvent event) {
    	//creates the basic smoke block
    	gas[] mix = {gas.carbondioxide, gas.carbonmonoxide};
    	Block Carbondioxide = new BlockSmoke(1000, mix)
        .setCreativeTab(CreativeTabs.tabBlock)
        .setTextureName("gaseousmc:Smoke");
    	GameRegistry.registerBlock(Carbondioxide, "Carbondioixide");
    	LanguageRegistry.addName(Carbondioxide, "Carbon dioxide rich smoke");
    	
    	//replaces torch as a smoke spawner
    	Block.blocksList[50] = null;
    	BlockTorch Torch = new ModTorch(Block.torchWood.blockID);
        GameRegistry.registerBlock(Torch, "wooden Torch");
    	LanguageRegistry.addName(Torch, "Torch");
    	
    	//replaces the burning furnance as a smoke spawner
    	Block.blocksList[Block.furnaceBurning.blockID]=null;
    	BlockFurnace ModFurnanceRunning = new ModFurnace();
        GameRegistry.registerBlock(ModFurnanceRunning, "Furnance");
    	LanguageRegistry.addName(ModFurnanceRunning, "Furnance");
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	
    }
}
