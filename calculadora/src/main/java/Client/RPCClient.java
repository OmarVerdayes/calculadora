package Client;

import back.DaoOperaciones;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


public class RPCClient {

    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        Scanner scanner=new Scanner(System.in);
        XmlRpcClientConfigImpl config=new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client =new XmlRpcClient();
        client.setConfig(config);
        /*Object[] numbers={5.0,5D};
        Double response =(Double) client.execute("Metodos.addition",numbers);
        System.out.println("Resultado= "+response);*/

        /*----------ejercicio de imc----------*/
        /*System.out.println("Ingresa tu nombre");
        String nombre=scanner.nextLine();
        System.out.println("Ingresa tu peso en kilogramos");
        double peso=scanner.nextDouble();
        System.out.println("Ingresa tu altura en metros");
        double altura=scanner.nextDouble();
        Object[] datos={nombre,peso,altura};
        String imc =(String) client.execute("Metodos.imc",datos);
        System.out.println(imc);*/
        int opcion=0;
        double num1,num2,resu;
        String n1,n2,resul,nombre;
        DaoOperaciones dao=new DaoOperaciones();
        do {
            num1=0;
            num2=0;
            System.out.println("Elija una opcion\n" +
                    "1.-Suma\n" +
                    "2.-Resta\n" +
                    "3.-Multiplicación\n" +
                    "4.-División\n" +
                    "5.-Exponente\n" +
                    "6.-Raíz\n" +
                    "7.-Historial de operaciones\n" +
                    "8.-Salir");
                opcion=scanner.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("ingrese el primer valor");
                    num1=scanner.nextDouble();
                    System.out.println("Ingrese el segundo valor");
                    num2=scanner.nextDouble();
                    Object[] suma={num1,num2};
                    double Rsuma=(Double) client.execute("Metodos.suma",suma);
                    System.out.println("El resultado de la suma es: "+Rsuma);
                    nombre="suma";
                    n1=num1+"";
                    n2=num2+"";
                    resul=Rsuma+"";
                    dao.saveoperacion(nombre,n1,n2,resul);

                    break;
                case 2:
                    System.out.println("ingrese el primer valor");
                    num1=scanner.nextDouble();
                    System.out.println("Ingrese el segundo valor");
                    num2=scanner.nextDouble();
                    Object[] resta={num1,num2};
                    double Rresta=(Double) client.execute("Metodos.resta",resta);
                    System.out.println("El resultado de la resta es: "+Rresta);
                    nombre="suma";
                    n1=num1+"";
                    n2=num2+"";
                    resul=Rresta+"";
                    dao.saveoperacion(nombre,n1,n2,resul);
                    break;
                case 3:
                    System.out.println("ingrese el primer valor");
                    num1=scanner.nextDouble();
                    System.out.println("Ingrese el segundo valor");
                    num2=scanner.nextDouble();
                    Object[] multiplicacion={num1,num2};
                    double Rmultiplicacion=(Double) client.execute("Metodos.multiplicacion",multiplicacion);
                    System.out.println("El resultado de la multiplicacion es: "+Rmultiplicacion);
                    nombre="suma";
                    n1=num1+"";
                    n2=num2+"";
                    resul=Rmultiplicacion+"";
                    dao.saveoperacion(nombre,n1,n2,resul);
                    break;
                case 4:
                    System.out.println("ingrese el primer valor");
                    num1=scanner.nextDouble();
                    System.out.println("Ingrese el segundo valor");
                    num2=scanner.nextDouble();
                    Object[] division={num1,num2};
                    double Rdivision=(Double) client.execute("Metodos.division",division);
                    System.out.println("El resultado de la division es: "+Rdivision);
                    nombre="suma";
                    n1=num1+"";
                    n2=num2+"";
                    resul=Rdivision+"";
                    dao.saveoperacion(nombre,n1,n2,resul);
                    break;
                case 5:
                    System.out.println("ingrese el valor del numero base");
                    num1=scanner.nextDouble();
                    System.out.println("Ingrese el valor del exponente");
                    num2=scanner.nextDouble();
                    Object[] expo={num1,num2};
                    double Rexpo=(Double) client.execute("Metodos.expo",expo);
                    System.out.println("El resultado del exponente es: "+Rexpo);
                    nombre="suma";
                    n1=num1+"";
                    n2=num2+"";
                    resul=Rexpo+"";
                    dao.saveoperacion(nombre,n1,n2,resul);
                    break;
                case 6:
                    System.out.println("ingrese el valor del numero base");
                    num1=scanner.nextDouble();
                    System.out.println("Ingrese el valor de la raiz");
                    num2=scanner.nextDouble();
                    Object[] raiz={num1,num2};
                    double Rraiz=(Double) client.execute("Metodos.raiz",raiz);
                    System.out.println("El resultado de la raiz es: "+Rraiz);
                    nombre="suma";
                    n1=num1+"";
                    n2=num2+"";
                    resul=Rraiz+"";
                    dao.saveoperacion(nombre,n1,n2,resul);
                    break;
                case 7:
                    System.out.println("| Operacion | Primer num | Segundo num | Resultado | Fecha |");
                    dao.listOperaciones();
                    break;
                case 8:
                    System.out.println("Programa finalizado");
                    break;
                default:
                    System.out.println("opcion invalida");
            }
        }while (opcion!=8);




    }
}
