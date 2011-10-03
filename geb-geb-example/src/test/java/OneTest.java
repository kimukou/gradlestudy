import junit.framework.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.android.AndroidDriver;

public class OneTest extends TestCase {

  public void testGoogle() throws Exception {
    AndroidDriver driver = new AndroidDriver();
    
    // And now use this to visit Google
    driver.get("http://www.google.com");
    
    // Find the text input element by its name
    WebElement element = driver.findElement(By.name("q"));
    
    // Enter something to search for
    element.sendKeys("Cheese!");
    
    // Now submit the form. WebDriver will find the form for us from the element
    element.submit();
    
    // Check the title of the page
    System.out.println("Page title is: " + driver.getTitle());
    driver.quit();

  }
}
