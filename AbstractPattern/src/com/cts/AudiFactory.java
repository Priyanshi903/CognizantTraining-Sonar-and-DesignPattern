package com.cts;
public class AudiFactory extends Factory 
{
	@Override
	public Tire makeTire() 
	{
		return new AudiTire();
	}

	@Override
	public HeadLight makeHeadLight() 
	{
		return new AudiHeadLight();
	}
}