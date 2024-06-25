package com.nftchange.util;



import java.util.regex.Pattern;

public class EmailUtil {

	private static final String regex = "(?:[a-z0-9!#$%&\'*+\\/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&\'*+\\/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

    public static boolean isItEmail(String email){
        return Pattern.matches(regex, email);
    }
	
    public static String maskEmail(String email){
		String[] emailSplit = email.split("");
		String[] maskedEmail = email.replaceAll("([^@])", "*").split("");
		String previous	= "";
        int count = 0;
		for(int i=0;i<maskedEmail.length;i++){
            if(previous.equals("@"))
                count = 0;
			if (count<=3){
				maskedEmail[i] = emailSplit[i];
                count++;
            }
			previous = emailSplit[i];
		}
		return String.join("", maskedEmail);
	}
}
