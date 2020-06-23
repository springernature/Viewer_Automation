package Regression_Suite_Viewer.test.early_proof;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Regression_Suite_Viewer.base.TestBase;

public class early_proof_test extends TestBase {
	
	@BeforeMethod
	public void setup() {
		initialization();
	}	
	@Test(priority=1)
	public void earlyproof_validation() {
		String actualTitle = driver.findElement(By.xpath("//*[@class='error_heading']")).getText();
		String expectedTitle="Early Proof Not Generated";
		assertEquals(actualTitle, expectedTitle);
		System.err.println(actualTitle);
	}
	
	
	@Test(priority=2)
	public void earlyprrof_test() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='InternalRef' and @refid='Fig1']")).click();
		Thread.sleep(2000);
		
		List<WebElement>hyperlinks = driver.findElements(By.xpath("//span[@class='InternalRef' and @refid='Fig1']"));
		
		System.out.println(hyperlinks.size());
		
		for(int i=0; i<hyperlinks.size();i++) {
			System.out.println(hyperlinks.get(i).getText());
		}
		
		driver.findElement(By.xpath("//*[@class='mdl-layout__drawer-button']")).click();
		driver.findElement(By.xpath("//*[@class='mdl-button__ripple-container']")).click();;
		
		
		String manuscript = driver.findElement(By.xpath("//*[@class='mdl-cell mdl-cell--3-col mdl-typography--text-left mdl-manuscript-txt']")).getText();
		System.out.println(manuscript);
		String revisionnumber = driver.findElement(By.xpath("//*[@class='mdl-cell mdl-cell--2-col mdl-typography--text-center mdl-rivisionNumber-txt']")).getText();
		System.out.println(revisionnumber);    //Revision number
	}

}
