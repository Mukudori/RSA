package sample;

import java.lang.Math;
import java.io.*;
import java.lang.ProcessBuilder;
import java.util.Scanner;
import java.math.BigInteger;



public class RSA {
    private int N, P, Q, n, e;


    public RSA(int p, int q)
    {
        this.P=p;
        this.Q=q;
        n = p*q;
        N = Phi();
        e = getFerma();
    }

    private int Phi()
    {
        return (P-1)*(Q-1);
    }

    private int getPriveteKey(int phi)
    {
        int i=2;
        while(!NOD(i,phi))
            i++;
        return i;
    }

    public String getEncrypt(String text)
            throws Exception
    {
        String out="";
        text=text.replaceAll("\\s+", "");
        text=text.toUpperCase();
        for(char symb:text.toCharArray())
        {
            BigInteger c = BigInteger.valueOf(symb-1039);
            c=c.pow(e);
            c=c.mod(BigInteger.valueOf(n));

            //        getSymbol(symb,e,P*Q);//(int) symb - 1039;
           // c =(int)Math.pow(c,e);
            //c %=n;
            //c+= 1040;
            out+=(char)(c.intValue()+1039);
        }


        return (char)e+out;
    }

    public String getDecript(String text)
    {
        int d = getPriveteKey(Phi());
        String out = "";
        for(char sybm: text.toCharArray())
        {
            BigInteger c = BigInteger.valueOf((int)sybm - 1039);
            c=c.pow(d);
            c=c.mod(BigInteger.valueOf(n));
            out+=(char)(c.intValue()+1039);

        }
        return out;
    }


    private int getFerma()
    {
        int valCar=0,i=0, valNew;
        while(true)
        {
            valNew=(int)Math.pow(2,Math.pow(2,i))+ 1;
            if (valNew<n) {
                valCar = valNew;
                i++;
            }
            else
                break;

        }

        return valCar;
    }

    private int getEiler(int N)    {
        int result = N;
        for (int i=2; i*i<=N; ++i)
            if (N % i == 0) {
                while (N % i == 0)
                    N /= i;
                result -= result / i;
            }
        if (n > 1)
            result -= result / N;
        return result;
    }

    private Boolean NOD(int A, int B)
    {
        int a=A, b = B;

        while(a!=b && a>0 && b>0)
            if (a>b) a-=b;
            else b-=a;

         if (a == 1)
             return true;
         else
             return false;
    }
}
