package gfm.net;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// TODO: Auto-generated Javadoc
/**
 * The Class GFMServerTCP.
 */
public class GFMServerTCP {
   
   /** The my port. */
   private int myPort;
   
   /** The my server socket. */
   private ServerSocket myServerSocket;
   
   /** The my socket in. */
   private Socket mySocketIn;
   
   /** The my input stream. */
   private InputStream myInputStream;
   
   /** The my output stream. */
   private OutputStream myOutputStream;
   
   /** The my reader. */
   private BufferedReader myReader;
   
   /** The my writer. */
   private DataOutputStream myWriter;

   // either this creates own thread (more abst.), or
   /**
    * Instantiates a new GFM server tcp.
    *
    * @param port the port
    * @throws IOException Signals that an I/O exception has occurred.
    */
   // game creator makes own thread.
   public GFMServerTCP(int port) throws IOException {
      myPort = port;
      myServerSocket = new ServerSocket(myPort);
      connect();
   }

   /**
    * Connect.
    *
    * @throws IOException Signals that an I/O exception has occurred.
    */
   public void connect() throws IOException {
      mySocketIn = myServerSocket.accept();
      myInputStream = mySocketIn.getInputStream();
      InputStreamReader in = new InputStreamReader(myInputStream);
      myOutputStream = mySocketIn.getOutputStream();
      myReader = new BufferedReader(in);
      myWriter = new DataOutputStream(myOutputStream);
   }
}