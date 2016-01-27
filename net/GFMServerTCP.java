package gfm.net;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class GFMServerTCP {
   private int myPort;
   private ServerSocket myServerSocket;
   private Socket mySocketIn;
   private InputStream myInputStream;
   private OutputStream myOutputStream;
   private BufferedReader myReader;
   private DataOutputStream myWriter;

   // either this creates own thread (more abst.), or
   // game creator makes own thread.
   public GFMServerTCP(int port) throws IOException {
      myPort = port;
      myServerSocket = new ServerSocket(myPort);
      connect();
   }

   public void connect() throws IOException {
      mySocketIn = myServerSocket.accept();
      myInputStream = mySocketIn.getInputStream();
      InputStreamReader in = new InputStreamReader(myInputStream);
      myOutputStream = mySocketIn.getOutputStream();
      myReader = new BufferedReader(in);
      myWriter = new DataOutputStream(myOutputStream);
   }
}