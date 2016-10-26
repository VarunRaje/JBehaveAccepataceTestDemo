package org.alti.steps;

import org.alti.demo.Addition;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

/**
 * Created by vdeshpande on 19-09-2016.
 */
public class AdditionStepDef {
    public int num1;
    public int num2;

    public int result;

    @Given("User enters number $a and $b")
    public void UserEntersNumber(int a, int b){
        num1 = a;
        num2 = b;
    }

    @When("User call add function")
    public void ICallAddFunction(){
        Addition add = new Addition();
        result = add.add(num1, num2);
    }
    @Then("result would be $c")
    public void ResultWouldBe(int c){
        Assert.assertEquals(c,result);
    }


}
