package com.ospyn.ktu.util;

public class ConfigurationProperties {

	private String browser;

	private String url;

	private BrowserSetup driverPath;

	private String reportPath;
	private String excelPath;

	public String getBrowser() {

		return browser;

	}

	public void setBrowser(String browser) {

		this.browser = browser;
		System.out.println("browser is "+this.browser);

	}

	public String getUrl() {

		return url;


	}

	public void setUrl(String url) {

		this.url = url;
		System.out.println("url "+this.url);

	}

	public BrowserSetup getDriverPath() {

		return driverPath;

	}

	public void setDriverPath(BrowserSetup driverPath) {

		this.driverPath = driverPath;
		System.out.println("driver path "+this.driverPath);

	}

	public String getReportPath() {

		return reportPath;

	}

	public void setReportPath(String reportPath) {

		this.reportPath = reportPath;

	}
	public String getexcelPath() {

		return excelPath;

	}

	public void setexcelPath(String reportPath) {

		this.excelPath = reportPath;

	}

}
