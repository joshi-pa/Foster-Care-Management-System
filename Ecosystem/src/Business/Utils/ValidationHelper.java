/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Kunjan
 */
public class ValidationHelper {
    
    public static Boolean isValidContactNo(String contactNo) {
        Pattern pattern = Pattern.compile("^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$");
        Matcher matcher = pattern.matcher(contactNo);
        return matcher.matches();
    }

    public static boolean isValidEmailId(String email) {
        Pattern pattern = Pattern.compile("^[\\w!#$%&‘*+/=?`{|}~^-]+(?:\\.[\\w!#$%&‘*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    public static Boolean isNumeric(String val) {
        Pattern pattern = Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(val);
        return matcher.matches();
    }

}