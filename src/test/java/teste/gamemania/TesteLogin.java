package teste.gamemania;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLogin {
	
	private WebDriver driver;

	@Before
	public void ConfigurarTeste() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://localhost:4200/");
		driver.findElement(By.xpath("//*[@id=\"menu\"]/a[5]")).click();
		
	}
		
	@Test
	public void TestarLogin() {
		
		WebElement campoEmail = driver.findElement(By.id("email"));
		WebElement campoSenha = driver.findElement(By.id("senha"));
		WebElement botao = driver.findElement(By.id("botao-enviar"));
		
		String[] listaEmails = {"melina@gmail.com", "alessclaro@gmail.com", "vivi@gmail.com"};
		String[] listasenhas = {"senhaforte", "senhaincorreta", "senhavivi"};
		
		try {
			
			for(int contador = 0; contador < 3; contador++) {
				campoEmail.sendKeys(listaEmails[contador]);
				campoSenha.sendKeys(listasenhas[contador]);
				botao.click();
				
				Thread.sleep(3000);
				
				campoEmail.clear();
				campoSenha.clear();
			}
				
			
			/*
			//caso teste email incorreto
			campoEmail.sendKeys("melina@gmail.com");
			campoSenha.sendKeys("senhaforte");
			botao.click();
		
			Thread.sleep(3000);
			
			campoEmail.clear();
			campoSenha.clear();
			
			//caso teste de senha incorreta para email cadastrado
			campoEmail.sendKeys("alessclaro@gmail.com");
			campoSenha.sendKeys("senhaincorreta");
			botao.click();
			
			Thread.sleep(3000);
			
			campoEmail.clear();
			campoSenha.clear();
			
			//caso de teste com senha e email corretos
			campoEmail.sendKeys("vivi@gmail.com");
			campoSenha.sendKeys("senhavivi");
			botao.click();
			
			Thread.sleep(5000);
			*/
			
			 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@After
	public void EncerrarTest() {
		driver.quit();
	}

}
