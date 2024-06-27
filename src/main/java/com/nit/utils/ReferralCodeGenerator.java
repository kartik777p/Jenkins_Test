package com.nit.utils;

//@Component
public class ReferralCodeGenerator {

    public static String generateReferralCode(String name,String userId) {
    	String referralCode=null;
        try {
            if (name == null || userId == null || name.length() < 4 || userId.length() < 4) {
                throw new IllegalArgumentException("Invalid name or userId");
            }

            referralCode = generateCode(name, userId);
           //response.put("referral_code", referralCode);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return referralCode;
    }

    private static String generateCode(String name, String userId) {
    	    String code = userId.substring(0, 3) + name.substring(0, 4) + userId.substring(userId.length() - 4);
    	    return code;
    	}

}
