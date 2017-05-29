package com.gs.reusebook.util;

/**
 * 
 * @author 丁修正 from red_maple_final
 *
 */
public class SecurityCodeGenerate {
	public static String getSecurityCode(){
		String securityCode = "";
		int [] random = new int[4];
		char[] codes={'1','2','3','4','5','6','7','8','9',
						'a','b','c','d','e','f','g','h','i',
						'j','k','m','n','p','q','r','s','t',
						'u','v','w','x','y','z','A','B','C',
						'D','E','F','G','H','I','J','K','L',
						'M','N','P','Q','R','S','T','U','V',
						'W','X','Y','Z'};
		for(int i = 0 ; i < 4 ; i++)
		{
			random[i]= (int) (Math.random()*58);
			securityCode += codes[random[i]];
		}
		return securityCode;
	}

}
