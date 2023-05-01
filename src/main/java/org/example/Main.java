package org.example;
import java.util.*;
import java.io.*;

import static java.lang.Math.pow;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            System.out.println(a+ pow(2,i)*b+pow(2,i++));
        }
        in.close();;
    }
}




