package com.mysite.webapp.classic;

public class MainString {

    public static void main(String[] args) {
        String[] strArray = new String[]{"1", "2", "3", "4", "5"};
        StringBuilder stringBuild = new StringBuilder();
        for (String str : strArray) {
            stringBuild.append(str).append(", ");
        }
        System.out.println(stringBuild.toString());
    }
}
