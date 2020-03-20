package Steps;

import cucumber.api.java.After;

public class Hooks{
    @After(order = 1)
    public void end_01(){
        System.out.println("-----");
    }
}
