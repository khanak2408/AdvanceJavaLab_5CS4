import java.rmi.*;
import java.net.MalformedURLException;
public class AdditionClient{
    public static void main(String args[]) throws RemoteException{
        AdditionInterface hello=null;
        try{
            hello=(AdditionInterface)Naming.lookup("//localhost:1091/Hello");
            System.out.println("Sum of two number is:"+hello.Add(20,40));
        }
        catch(MalformedURLException e){
            e.printStackTrace();
        }
        catch(RemoteException e1){
            e1.printStackTrace();
        }
        catch(NotBoundException e1){
            e1.printStackTrace();
        }
    }
}