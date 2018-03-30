package com.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.testbase.BaseTest;

public class WeightWatcherTest extends BaseTest{

	@Test
	public void testPage() throws Throwable{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String search_key = "10011";
		String pageTitle = "Weight Loss Program, Recipes & Help | Weight Watchers";
	
		//comparing titles
		if(driver.getTitle().contentEquals(pageTitle)){
			Assert.assertEquals(pageTitle, driver.getTitle());
		}
		else{
			Assert.assertFalse(true, "The title did not match");
		}
		
		//Click on find meeting
		WebElement meeting = driver.findElement(By.xpath(".//*[@id='ela-menu-visitor-desktop-supplementa_find-a-meeting']"));
		meeting.click();
		//entering for search input
		WebElement search_box = wait.until(ExpectedConditions.elementToBeClickable(By.id("meetingSearch")));
		search_box.sendKeys(search_key);
		search_box.submit();
		
		//getting the list of the location and select the 1st one
		List<WebElement> titles = driver.findElements(By.className("location__name"));
		List<WebElement> distances = driver.findElements(By.className("location__distance"));
		//printing title of 1st location and distance
		String title = titles.get(0).getText();
		String distance = distances.get(0).getText();
		System.out.println(title);
		System.out.println(distance);
		//selecting 1st location
		titles.get(0).click();
		WebElement locationEle = wait.until(ExpectedConditions.elementToBeClickable(By.className("location__name")));
		String meetingLocation = locationEle.getText();
		
		//validating the 1st chosen location
		Assert.assertEquals(title, meetingLocation, "Meeting location doesn'nt match");
		
		String day = "Mon";
		//getting scheduled time and print
		List<WebElement> times = getMeetingTime(day);
		for(WebElement e: times){	
			String time = e.getText();
			System.out.println(time);
		}
		
	}
	
	//this function will find the meeting schedule with the given day
	public List<WebElement> getMeetingTime(String day) {
		String start = "//schedule-detailed/div/div[";
		String end = "]/div/div/div[1]";
		String locator = null;

		switch (day) {
		case "Sun":
			locator = start + 1 + end;
			break;
		case "Mon":
			locator = start + 2 + end;
			break;
		case "Tue":
			locator = start + 3 + end;
			break;
		case "Wed":
			locator = start + 4 + end;
			break;
		case "Thu":
			locator = start + 5 + end;
			break;
		case "Fri":
			locator = start + 6 + end;
			break;
		case "Sat":
			locator = start + 7 + end;
			break;

		}

		List<WebElement> times = driver.findElements(By.xpath(locator));
		return times;

	}
	
}
