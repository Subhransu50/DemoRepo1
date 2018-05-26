package com.crm.qa.testcases;
/*
 * author:subhransu  p
 */
import org.testng.Assert;
import org.testng.annotations.Test;

public class xyz {
@Test(priority=1)
public void test1()
{
	Assert.assertEquals(false, true);
}
@Test(priority=2)
public void test2()
{
	Assert.assertEquals(true, true);
}
}
