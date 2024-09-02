package za.ac.cput.util;

import za.ac.cput.domain.Product;

import java.util.List;
import java.util.UUID;

public class Helper {
    public static Boolean isNullOrEmpty(String s){
        if(s == null || s.isEmpty())
            return true;
        return false;

    }

    public static Boolean isListNullOrEmpty(List list){
        if(list == null || list.isEmpty())
            return true;
        return false;

    }


    public static Boolean isIntegerNotValid(Integer integer){
        if(integer == null || integer.toString().isEmpty())
            return true;
        return false;

    }

    public static Boolean isLongNotValid(Long l){
        if(l == null || l.longValue() <= 0)
            return true;
        return false;

    }



    public static boolean isObjectNotValid(Object obj) {
        return obj == null;
    }

    public static boolean isNullOrEmpty(Product product) {
        return product == null /* Additional checks if needed */;
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

