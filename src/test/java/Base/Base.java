package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {

    protected WebDriver driver;
    protected Properties prop;


  

    
    //Initialize browser 
    @BeforeMethod
    public void Initialize_Broser() throws IOException{
        //Load prop file
        prop = new Properties();
        FileInputStream file = new FileInputStream("C:\\Users\\manim\\Downloads\\SEL_FRAMEWORK\\framework\\src\\main\\resources\\config.properties");
        prop.load(file);
        String B_name = prop.getProperty("Browser");
        ChromeOptions options = new  ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless=new");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        if(B_name.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver(options);
        }else if (B_name.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }else if (B_name.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }else{
            throw new IllegalArgumentException("Unsupported browser" + B_name);
        }

        //Initialize implisit wait
        
        int wait_sec = Integer.parseInt(prop.getProperty("Implicitwt").trim());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait_sec));

        //Maximize browser
        driver.manage().window().maximize();

        //Navigate to URL
        String URL = prop.getProperty("URL");
        driver.get(URL);
    }

    //Tear down
    @AfterMethod 
    public void teardown(){
        if(driver!=(null)){
            driver.quit();
        }
    }

    


}
