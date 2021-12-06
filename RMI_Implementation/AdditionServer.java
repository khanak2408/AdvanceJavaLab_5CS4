import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.net.MalformedURLException;
public class AdditionServer{
    public static void main(String args[]) throws RemoteException{
        Addition Hello=new Addition();
        LocateRegistry.createRegistry(1091);
        System.out.println("Java RMI registry created...");
        try{
            Naming.bind("//localhost:1091/Hello",Hello);
            System.out.println("Addition Server is ready");
        }
        catch(RemoteException e){
            e.printStackTrace();
        }
        catch(MalformedURLException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}