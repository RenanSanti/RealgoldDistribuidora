/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

/**
 *
 * @author DELL
 */
public class Util {
    
    public Util(){
        
    }

    public static String formatadorData(String pDataAntiga) {
        String data = pDataAntiga.replaceAll("-", "/");
        String[] s = data.split("/");
        String novaData = s[2] + "/" + s[1] + "/" + s[0];
        return novaData;
    }
    
    public static String desformatadorData(String pDataAntiga) {
        String data = pDataAntiga.replaceAll("/", "-");
        String[] s = data.split("-");
        String novaData = s[2] + "-" + s[1] + "-" + s[0];
        return novaData;
    }
    
    public static void main(String[] args) {
        
    }
}
