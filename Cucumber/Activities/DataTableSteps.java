package StepDefinitions;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class DataTableSteps{
    WebDriver driver;
    WebDriverWait wait;
    Alert alert;
    List<String> tasks;
    
    @Given("User completes the requirement")
    public void user_completes_the_requirement() {
    	driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Open browser
        driver.get("https://training-support.net/webelements/todo-list");
    }

    @When("User enters the following tasks")
    public void user_enters_the_following_tasks(DataTable inputTasks) throws InterruptedException {
       tasks = inputTasks.asList();
        System.out.println(tasks);
        
        for(String task : tasks) {
        	driver.findElement(By.id("todo-input")).sendKeys(task);
        	driver.findElement(By.id("todo-add")).click();
        	Thread.sleep(1000);
        }
    }

    @Then("Verify results")
    public void verify_results() {
       Assertions.assertEquals(driver.findElement(By.xpath("//ul//li//h3[contains(text(),'task1']")).getText(), tasks.get(0));
       Assertions.assertEquals(driver.findElement(By.xpath("//ul//li//h3[contains(text(),'task2']")).getText(), tasks.get(1));
       Assertions.assertEquals(driver.findElement(By.xpath("//ul//li//h3[contains(text(),'task3']")).getText(), tasks.get(2));
       
       System.out.println("Verification Done!!");
       
       driver.quit();
    }


   }