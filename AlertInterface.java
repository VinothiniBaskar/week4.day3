package week3.day3.alerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertInterface {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Launch the URL
		driver.get("https://www.leafground.com/alert.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Find the element and click the button
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt91']//span[2]")).click();
		// create an Alert interface and use switchTo method ,its for move to the alert
		// box
		Alert alert = driver.switchTo().alert();
		// Accept the option in alert box
		alert.accept();
		// Get the text after the accept the alert
		String text = driver.findElement(By.xpath("//span[@id='simple_result']")).getText();
		// print the text
		System.out.println("The Alert message of simple Daialog is :" + text);
		// verify the text
		if (text.contains("You have successfully clicked an alert")) {
			System.out.println("Text is successfully verified");
		} else {
			System.out.println("Text is not  verified");

		}

		// Alert Box2
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt93']//span[2]")).click();
		driver.switchTo().alert();
		alert.dismiss();
		String text1 = driver.findElement(By.xpath("//span[@id='result']")).getText();
		System.out.println("The Alert message of confirm  Daialog is :" + text1);
		// verify the text
		if (text1.contains("User Clicked : Cancel")) {
			System.out.println("Text is successfully verified");
		} else {
			System.out.println("Text is not  verified");

		}

		// Alert Box3
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt95']//span[2]")).click();
		driver.findElement(By.xpath("//span[text()='Dismiss']")).click();

		// Alert Box4
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt100']//span[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Modal Dialog (Sweet Alert)']/following::span")).click();

		// Alert Box5
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt104']//span[2]")).click();
		driver.switchTo().alert();
		alert.sendKeys("Vino");
		alert.accept();
		String text2 = driver.findElement(By.xpath("//span[@id='confirm_result']")).getText();
		System.out.println("The Alert message of confirm  Daialog is :" + text2);
		// verify the text
		if (text2.contains("User entered name as: Vino")) {
			System.out.println("Text is successfully verified");
		} else {
			System.out.println("Text is not  verified");

		}

		// Alert Box6
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		driver.findElement(By.xpath("//span[text()='Yes']")).click();

		// Alert Box7
		driver.findElement(By.xpath("(//span[text()='Show'])[6]")).click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//a[contains(@class,'ui-dialog-titlebar-icon ui-dialog-titlebar-minimize')]//span")).click();
		System.out.println(driver.getTitle());

	}

}
