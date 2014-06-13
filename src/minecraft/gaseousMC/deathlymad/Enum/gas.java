package gaseousMC.deathlymad.Enum;

public enum gas {
	carbondioxide(190),
	carbonmonoxide(297),
	ammonia(488),
	oxygen(260),
	methane(518),
	water(462),
	sulfurdioxide(130),
	helium(2077),
	nitrogen(296),
	hydrogen(4124),
	propane(189),
	ERRGAS(0);
	
	
	public int gas_constant = 0;
	
	private gas (int gasconst)
	{
		gas_constant=gasconst;
	}
	
	public static gas getGas(int i)
	{
		switch(i)
		{
		case 190:
			return carbondioxide;
		case 297:
			return carbonmonoxide;
		case 488:
			return ammonia;
		case 260:
			return oxygen;
		case 518:
			return methane;
		case 462:
			return water;
		case 130:
			return sulfurdioxide;
		case 2077:
			return helium;
		case 296:
			return nitrogen;
		case 4124:
			return hydrogen;
		case 189:
			return propane;
		default:
			return ERRGAS;
		}
	}
}