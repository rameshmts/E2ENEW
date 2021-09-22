package FramewrkScratch.E2E;

import org.testng.annotations.Test;

public class tstngpriotest {

	
	@Test(groups= {"smoke","regression"},dependsOnMethods= {"test4","test2","test3"})
	public void test11()
	{
		System.out.println("Test method is 1");
	}
	
	@Test(groups= {"regression"})
	public void test2()
	{
		System.out.println("Test method is 2");
	}
	
	@Test(groups= {"smoke"})
	public void test3()
	{
		System.out.println("Test method is 3");
	}
	
	@Test
	public void test4()
	{
		System.out.println("Test method is 4");
	}
}

