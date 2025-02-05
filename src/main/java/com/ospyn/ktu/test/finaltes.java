package com.ospyn.ktu.test;

import org.testng.annotations.Test;

import com.ospyn.ktu.view.ViewCertificateVerificationOuterPage;

public class finaltes extends BaseClass {
@Test
public void a()
{
	System.out.println("sesese");
	
	ViewCertificateVerificationOuterPage vcvop=new ViewCertificateVerificationOuterPage(driver);
	vcvop.setRegisterNumber("test");
	vcvop.setDOB("12,21,2008");
	vcvop.clickSearch();
}
}
