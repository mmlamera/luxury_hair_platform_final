package za.ac.cput.util;

import java.util.UUID;

public class Helper {
    public static Boolean isNullOrEmpty(String s){
        if(s == null || s.isEmpty())
            return true;
        return false;
//Note to self: dont forget email validation
    }
    public static String generateId(){
        return UUID.randomUUID().toString();
    }

    public static boolean isArrayNullOrEmpty(byte[] array) {
        return array == null || array.length == 0;
    }
    public static Boolean isIntNullOrEmpty(Integer num){
        if(num == null || num == 0){
            return true;
        }
        return false;
    }
}

