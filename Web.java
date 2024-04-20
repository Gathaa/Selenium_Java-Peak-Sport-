package Web;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Web {
			ChromeDriver driver;
			String url = "https://www.peaksports.tn/";
			public void invokeBrowser() {
				System.setProperty("webdriver.chrome.driver","C:\\Users\\GDHAMI\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get(url);
			}
			public void PrintTitle() {
				String titleOfThePage = driver.getTitle();
				System.out.println("Title of the page :  \n"+titleOfThePage);
			}
			public String getTitle() {
				String titleOfThePage = driver.getTitle();
				return titleOfThePage;
			}
			public void closeBrowser() {
				driver.quit();
			}
			public static void main(String[] args) {
				Web wc = new Web();
				wc.invokeBrowser();
				wc.getTitle();
				wc.PrintTitle();
				wc.login("Aimenguedhami6@gmail.com","Aymen123");
				wc.modify("Aimen","Gathaaa","Aymen123");
				//wc.logout();
			}
			 public void login(String Username, String Password) {
			        WebDriverWait wait = new WebDriverWait(driver,15);
			        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"header\"]/div[2]/div/div/div[3]/div[2]/div/div")));
			        loginButton.click();
			        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"header\"]/div[2]/div/div/div[3]/div[2]/ul/li/a")));
			        dropdown.click();
			       WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
			       usernameField.sendKeys(Username);
			        WebElement passwordfield = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
			       passwordfield.sendKeys(Password);
			      WebElement ButtonLogin= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login-form\"]/footer/button")));
			        ButtonLogin.click();
			    }
			 public void logout() {
				 WebDriverWait wait = new WebDriverWait(driver,15);
			      WebElement ButtonLogout= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/footer/div/a")));
			        ButtonLogout.click();
				}
			 public void modify(String FName,String LName,String Password) {
				 WebDriverWait wait = new WebDriverWait(driver,15);
			     WebElement Modify= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"identity-link\"]")));
			     Modify.click();
			     WebElement fnamefield = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname")));
			     fnamefield.sendKeys(FName);
			     WebElement lnamefield = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastname")));
				lnamefield.sendKeys(LName);
				WebElement confirmpasswordfield = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
			       confirmpasswordfield.sendKeys(Password);
				WebElement InsureModify= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"customer-form\"]/footer/button")));
			     InsureModify.click();
			 }

	
}
