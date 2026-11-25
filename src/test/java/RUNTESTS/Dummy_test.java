package RUNTESTS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Base.Base;


public class Dummy_test extends Base{


    @FindBy (id ="USERNAME") WebElement elem;

    ExtentReports extentReports = new ExtentReports();
    ExtentSparkReporter rep = new ExtentSparkReporter("C:\\Users\\manim\\Downloads\\SEL_FRAMEWORK\\framework\\src\\test\\Resources\\report.html");
    
    
    
    
    @Test (groups = {"smoke", "functional"},enabled = true, priority = 0)
    public void dummytest(){
        String Title_NM = driver.getTitle();
        
        
        assert Title_NM.equals("OrangeHRM"): "Test failed - Title is not matching";
        extentReports.attachReporter(rep);
        extentReports.createTest("TEST_TITLE")
                     .info("Title_NM")
                     .fail(new RuntimeException("ERROR"))
                     .pass("testpassed");

        extentReports.flush();
        System.out.println("Test passed - Title is matching");
        
    }
    
    @Test (groups = "smoke", priority  = 1)
    public void test1(){
        System.out.println("printing from test 1");
    }
    
    @Test (groups = "regression", priority = 2)
    public void test2(){
        System.out.println("printing from test 2");
    }
    
    @Test (groups = "function", priority = 3)
    public void test3(){
        System.out.println("printing from test 3");
    }
    
}
