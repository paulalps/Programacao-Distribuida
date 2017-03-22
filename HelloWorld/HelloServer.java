/** HelloServer.java **/
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class HelloServer implements HelloWorld {

   public HelloServer() {}

   public static void main(String[] args) {

	      try {

	         // Instancia o objeto servidor e a sua stub  

	         HelloServer server = new HelloServer();

	         HelloWorld stub = (HelloWorld) UnicastRemoteObject.exportObject(server, 0);

	         // Registra a stub no RMI Registry para que ela seja obtida pelos clientes

	         Registry registry = LocateRegistry.getRegistry();

	         registry.bind("Hello", stub);

	         System.out.println("Servidor pronto");

	      } catch (Exception ex) {

	         ex.printStackTrace();

	      } 

	   }
   
   public String hello() throws RemoteException {

	   System.out.println("Executando hello()");

	   return "Hello!!!";

	}
}