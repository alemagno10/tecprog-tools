package br.edu.insper.tecprog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static InsperArrayList<String> sumarioRegex(String md) {
        var sumarios = new InsperArrayList<String>();
        Pattern pattern = Pattern.compile("^#\\s([^.\n]+)", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(md);
        while(matcher.find()) sumarios.add(matcher.group(1));
        return sumarios;
    }

    public static ArrayList<String> sumario(String md) {
        ArrayList<String> sumario = new ArrayList<String>();
        for (int i = 0; i < md.length(); i++) {
            int end = i;
            if(i == 0){
                if(md.charAt(i) == '#' && md.charAt(i+1) == ' '){
                    while(end < md.length() && md.charAt(end) != '\n') end++;
                    sumario.add(subString(md, i+2, end));
                }
            } else if (md.charAt(i-1) == '\n' && md.charAt(i) == '#' && md.charAt(i+1) == ' '){
                while(end < md.length() && md.charAt(end) != '\n') end++;
                sumario.add(subString(md, i+2, end));
            }
        }
        return sumario;
    }

    private static String subString(String S, int start, int end){
        char[] str = new char[end - start];
        int k = 0;
        for (int i = start; i < end; i++) {
            str[k] = S.charAt(i);
            k++;
        }
        return String.valueOf(str);
    }

    public static boolean prefixoAllowed(String S, String Q) {
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(10,20,30));
        al.size();
        al.set(0, 20);
        al.get(0);
        if(S.length() < Q.length()) return false;
        for (int i = 0; i < Q.length(); i++) {
            if(S.charAt(i) != Q.charAt(i)){
                return false;
            }
        } 
        return true;
    }

    public static boolean prefixoBlocked(String S, String Q) {
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(10,20,30));
        al.size();
        al.set(0, 20);
        al.get(0);
        al.remove(0);
        if(S.length() < Q.length()) return false;
        for (int i = 0; i < Q.length(); i++) {
            if(S.charAt(i) != Q.charAt(i)){
                return false;
            }
        } 
        return true;
    } 
}