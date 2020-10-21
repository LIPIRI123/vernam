/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incriptacion_Vernam;

import java.util.Scanner;

/**
 *
 * @author lipiri
 */
public class proceso {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner l = new Scanner(System.in);
        int v[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 127};
        String v1[] = {"NULL", "SOH", "STX", "ETX", "EOT", "ENQ", "ACK", "BEL", "BS", "HT", "LF", "VT", "FF", "CR", "SO", "SI", "DLE", "DC1", "DC2", "DC3", "DC4", "NAK", "SYN", "ETB", "CAN", "EM", "SUB", "ESC", "FS", "GS", "RS", "US", "ESPACIO", "DEL"};
        System.out.println("ingrese el mensaje");
        String men = l.nextLine();
        System.out.println("ingrese la clave");
        String clave = l.next();
        int con_es = 0;
        char v2[] = men.toCharArray();
        for (int i = 0; i < men.length(); i++) {
            if (v2[i] == ' ') {
                con_es++;
            }
        }
        int tama = men.length() - con_es;
        int ascci[] = new int[tama];
        int i1 = 0;
        for (int i = 0; i < men.length(); i++) {
            if (v2[i] != ' ') {
                ascci[i1] = (int) (v2[i]);
                i1++;
            }
        }
        int cla = (int) (clave.charAt(0));
        String cl = "";
        while (cla > 0) {
            int nume = cla % 2;
            cl = nume + cl;
            cla /= 2;
        }
        if (cl.length() != 8) {
            int res = 8 - cl.length();
            for (int i = 0; i < res; i++) {
                cl = "0" + cl;
            }
        }

        char vc[] = cl.toCharArray();
        System.out.println(cl);

        String re[] = new String[tama];
        for (int i = 0; i < tama; i++) {
            String m = "";

            while (ascci[i] > 0) {
                int nume = ascci[i] % 2;
                m = nume + m;
                ascci[i] /= 2;
            }
            if (m.length() != 8) {
                int res = 8 - m.length();
                for (int j = 0; j < res; j++) {
                    m = "0" + m;
                }
            }
            String re1 = "";
            char vm[] = m.toCharArray();
            for (int k = 0; k < m.length(); k++) {
                if (vm[k] == vc[k]) {
                    re1 += "0";
                } else {
                    re1 += "1";
                }
            }
            char re2[] = re1.toCharArray();
            // System.out.println(re[i]+"  "+re1);
            int i2 = 0;
            int dec = 0;
            for (int j = re2.length - 1; j >= 0; j--) {
                dec = dec + Integer.parseInt("" + re2[j]) * (int) (Math.pow(2, i2));
                i2++;
            }
            if (dec >= 0 && dec <= 32 || dec == 127) {

                for (int j = 0; j < v.length; j++) {
                    if (dec == v[j]) {
                        re[i] = v1[j];
                        break;
                    }
                }
                System.out.println(dec + "  " + re1);
            }else{
                char cifra=' ';
                cifra=(char)(dec);
                String cif="";
                cif+=cifra;
                re[i]=cif;
            }
        }
        for(int i=0;i<tama;i++){
            System.out.print(re[i]+" ");
        }
    }
}
