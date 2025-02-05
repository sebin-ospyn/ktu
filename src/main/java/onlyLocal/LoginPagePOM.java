package onlyLocal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.github.dockerjava.api.model.Config;
import com.ospyn.ktu.util.SeleniumBase;
import com.ospyn.ktu.util.ViewCommonUtil;

public class LoginPagePOM extends SeleniumBase {
	
	public LoginPagePOM(WebDriver driver) throws Exception{
		super(driver);
	}
	@FindBy (xpath = "//input[@id='CSRF_TOKEN']")
	private WebElement loginTxtBx;
	
	@FindBy (xpath ="//input[@id='login-password']")
	private WebElement pswdTxtBx;
	
	@FindBy (xpath = "//input[@id='btn-login']")
	private WebElement loginBtn;
	
	public void performLogin(String path,String sheetname,String username, String pswd)
	{
		path=("");
//		loginTxtBx.sendKeys(ViewCommonUtil.getValueFromExcel(path, sheetname, pswd));
//		pswdTxtBx.sendKeys(ViewCommonUtil.getValueFromExcel(path, sheetname, pswd));
		loginBtn.click();
	}
	

}
