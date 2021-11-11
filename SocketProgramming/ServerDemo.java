import java.net.*;
import java.io.*;
class ServerDemo{
    public static void main(String args[]) throws IOException{
        //Step 1: Create a ServerSocket on port 777
        ServerSocket ss=new ServerSocket(777);

        //Step 2: Created Server will wait till the client application is 
        //accepted the connection
        Socket s=ss.accept();

        //Step 3: Attach an output stream to the server
        OutputStream obj=s.getOutputStream();
        //Step 4: Take PrintStream Object

        PrintStream ps=new PrintStream(obj);

        String str="Hello from Server Side...";
        ps.println(str);

        //Step 5: close all open stream in reverse order of their creation.
        ps.close();
        ss.close();
        s.close();
    }
}