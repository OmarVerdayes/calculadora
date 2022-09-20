package Server;

import java.util.ArrayList;
import java.util.Collections;

public class Metodos {

    public double suma(double num1,double num2){
        double suma=num1+num2;
        return suma;
    }
    public double resta(double num1,double num2){
        double resta=num1-num2;
        return resta;
    }
    public double multiplicacion(double num1,double num2){
        double multiplicacion=num1*num2;
        return multiplicacion;
    }
    public double division(double num1,double num2){
        double division=num1/num2;
        return division;
    }
    public double exponante(double num1,double num2){
        double expo=Math.pow(num1,num2);
        return expo;
    }
    public double raiz(double num1,double num2){
        double exp=1/num2;
        double raiz=Math.pow(num1,exp);
        return raiz;
    }


}
