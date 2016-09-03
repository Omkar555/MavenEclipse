package MavenProject.MavenProject;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
	WebDriver driver;
	//final String appURL="http://naukri.com";
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        App obj = new App();
        /*obj.launchApplication("chrome");
        obj.closeApplication();
        obj.testCase1();*/
        //WebDriver driver= new FirefoxDriver();
        //driver.get("http://inportia.com/");
        //driver.close();
        //driver.manage().window().maximize();
        //String title = driver.getTitle();
       obj.testCase1();
    }
    
    public void testCase1(){
    	
    	
    	this.launchApplication("chrome");
    	this.launchURL("http://naukri.com");
    	//this.handleWindow();
    	//this.getAllLinksFromPage();
    	//this.toRefreashPage();
    	//obj.testCase1();
    	//obj.closeApplication();
    	//this.getValueDropdown();
    	this.selectList();
    	//this.explicitWaitExample();
    }
  
    public void launchURL(String appURL){
    	
    	driver.get(appURL);
    	//driver.manage().window().maximize();
    	String url=driver.getCurrentUrl();
    	String actualTitle=driver.getTitle();
    	
    	if (url.contains("naukri")){
    		if(actualTitle.startsWith("Jobs")){
    			System.out.println("Passed");
    		}
    	}
    	else {
    		System.out.println("failed");
    	}
    	//else{
    		//System.out.println("Failed");
    	//}
    	
    }
    public void handleWindow(){
    	String aaa= driver.getWindowHandle();
    		
    	System.out.println(aaa);
    	  	
    	
    		Set<String> handles = driver.getWindowHandles();
        	
        	System.out.println(handles);
    		
    	/*int x = handles.size();
    	int i;
    	for(i=1;i<x;i++){
    		
    		//System.out.println(x);
    	}*/
        	for(String s:handles)
        	{
        		driver.switchTo().window(s);       		
        		System.out.println(s);
        		System.out.println(driver.getTitle());
        	}
        	
        	driver.switchTo().window(aaa);
        	//System.out.println(aaa);
        	System.out.println(driver.getTitle());
        	
        	Iterator<String> irt = handles.iterator();
    	while(irt.hasNext()){
    		System.out.println(irt.next());
    	}
    	
    }
    
    //get all links from a page
    
    public void getAllLinksFromPage(){
    	
    	List<WebElement> Webelement = driver.findElements(By.tagName("a"));
    	for(WebElement a: Webelement){
    		System.out.println(a.getText());
    	}
    	
    }
    
    public void toRefreashPage(){
    	
    	driver.findElement(By.name("qp")).sendKeys("asd");
    	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//driver.findElement(By.name("ql")).sendKeys("\uE035");
    	//driver.navigate().refresh();
    	//driver.getCurrentUrl();
    	driver.navigate().to(driver.getCurrentUrl());
    	
    }
    
    /*public void getValueDropdown(){
    	
    	
    	//driver.findElement(By.xpath("//*[@id='exp_dd']/div[1]/input[1]")).click();
    	driver.get("http://the-internet.herokuapp.com/dropdown");
    	WebElement dd = driver.findElement(By.id("dropdown"));
    	//dd.click();
    	
    	// tag name was select, using select class constructor
    	
    	// learn about constructor
    	    	
    	Select ss= new Select(dd);
    	ss.selectByIndex(1);
    	ss.deselectByValue("1");
    	
    	
    }*/
    
   /* public void getValueDropdown(){
    	
    	
    	//driver.findElement(By.xpath("//*[@id='exp_dd']/div[1]/input[1]")).click();
    	driver.get("http://the-internet.herokuapp.com/dropdown");
    	WebElement dd = driver.findElement(By.id("dropdown"));
    	//dd.click();
    	
    	// tag name was select, using select class constructor
    	
    	// learn about constructor
    	Select ss= new Select(dd);
    	ss.selectByIndex(1);
    	ss.deselectByValue("1");
    	
    	
    }*/
    public void selectList(){
    	this.explicitWaitExample();
    	driver.findElement(By.xpath(".//*[@id='exp_dd']/div[1]/input[1]")).click();
    	
    	//driver.findElement(By.xpath(".//div[@id='exp_dd']//div[@class='sDrop']//div[@class='nScrollable']//div[@class='matchParent content']/ul/li[2]"));
    }
    
	public void closeApplication() {
		// TODO Auto-generated method stub
		driver.close();
	}

	public void launchApplication(String browserName){
    
    	if(browserName.equalsIgnoreCase("firefox")){
    		
    		driver =new FirefoxDriver();
    		//this.implicitWaitExample();
    	}
    	else if(browserName.equalsIgnoreCase("chrome")){
    		
    		System.setProperty("webdriver.chrome.driver", "H:\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
    		driver = new ChromeDriver();
    		//this.implicitWaitExample();
    	}
    	else if(browserName.equalsIgnoreCase("ie")){
    		
    		System.setProperty("webdriver.ie.driver", "H:\\SELENIUM\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe");
    		driver=new InternetExplorerDriver();
    		//this.implicitWaitExample();
    	}
    }
    public void implicitWaitExample(){
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	
    }
    
    
    public void explicitWaitExample(){
    	WebDriverWait wdw=new WebDriverWait(driver,10);
    	//wdw.until(ExpectedConditions.titleContains(title));
    	wdw.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='exp_dd']/div[1]/input[1]")));
    }
    
}
