import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.io.Serializable;

public class MySerwer {
    public static void main(String[] args) {
        if (args.length==0)
        {
            System.out.println("You ahve to enter RMI object adress in the form : //host_address/service_name");
            return;
        }
        if (System.getSecurityManager() == null) System.setSecurityManager(new SecurityManager());
        try
        {
            Registry reg = LocateRegistry.createRegistry(1099);

        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        try
        {
            CalcObjImpl implObiektu = new CalcObjImpl();
            CalcObjImpl2 implObiektu2 = new CalcObjImpl2();
            java.rmi.Naming.rebind(args[0],implObiektu);
            java.rmi.Naming.rebind(args[1],implObiektu2);
            System.out.println("Server is registered now :)");
            System.out.println("Press Crl+C to stop...");
        }
        catch (Exception e)
        {
            System.out.println("SERVER CANT BE REGISTERED!");
            e.printStackTrace();
            return;
        }
    }
}
