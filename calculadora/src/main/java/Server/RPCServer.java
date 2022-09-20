package Server;

import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Properties;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.webserver.WebServer;

public class RPCServer {

    public static void main(String[] args) throws XmlRpcException, IOException {
        System.out.println("iniciando servidor....");
        PropertyHandlerMapping mapping= new PropertyHandlerMapping();
        mapping.addHandler("Metodos",Metodos.class);
        WebServer server =new WebServer(1200);
        server.getXmlRpcServer().setHandlerMapping(mapping);
        server.start();
        System.out.println("Esperando deciciones");
    }

}
