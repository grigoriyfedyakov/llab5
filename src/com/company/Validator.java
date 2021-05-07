package com.company;


public interface Validator {

    static boolean validationY(long y) {
        if(y>292) return true;
        else return false;
    }
    static boolean validationX(int x){
        return false;
    }
    static boolean validationName(String s){
        if (s==null || s.equals("")) return true;
        else return false;
    }
    static boolean validationPrice(int x){
        if (x<=0) return true;
        else return false;
    }
    static boolean validationDiscount(int x){
        if (x<=0 || x>100) return true;
        else return false;
    }
    static boolean validationCapacity(int x){
        if (x<=0) return true;
        else return false;
    }
}
