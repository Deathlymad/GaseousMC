package gaseousMC.main.proxy;

import net.minecraftforge.client.MinecraftForgeClient;
import gaseousMC.main.proxy.GaseousMCCommonProxy;

public class GaseousMCClientProxy extends GaseousMCCommonProxy {
	
	@Override
	public void registerRenderers() {
        // Nothing here as the server doesn't render graphics or entities!
	}
}
