package RUNTESTS;
import org.testng.annotations.Test;

import Base.Base;


public class Dummy_test extends Base{
    @Test 
    public void dummytest(){
        String Title_NM = driver.getTitle();
        assert Title_NM.equals("OrangeHRM"): "Test failed - Title is not matching";
        System.out.println("Test passed - Title is matching");
    }
}
