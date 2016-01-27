package gfm.net;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class GFMClientTCP {
   private String myServerIp;
   private int myServerPort;
   private Socket mySocket;
   private InputStream myInputStream;
   private OutputStream myOutputStream;
   private BufferedReader myReader;
   private DataOutputStream myWriter;


   // same thing with error handling, see server note.
   public GFMClientTCP(String serverIp, int serverPort) throws UnknownHostException, IOException {
      myServerIp = serverIp;
      myServerPort = serverPort;
      connect();
   }

   public void connect() throws UnknownHostException, IOException {
      mySocket = new Socket(myServerIp, myServerPort);
      myInputStream = mySocket.getInputStream();
      myOutputStream = mySocket.getOutputStream();
      InputStreamReader in = new InputStreamReader(myInputStream);
      myReader = new BufferedReader(in);
      myWriter = new DataOutputStream(myOutputStream);
   }
}