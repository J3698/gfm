package gfm.net;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

// TODO: Auto-generated Javadoc
/**
 * The Class GFMClientTCP.
 */
public class GFMClientTCP {
   
   /** The my server ip. */
   private String myServerIp;
   
   /** The my server port. */
   private int myServerPort;
   
   /** The my socket. */
   private Socket mySocket;
   
   /** The my input stream. */
   private InputStream myInputStream;
   
   /** The my output stream. */
   private OutputStream myOutputStream;
   
   /** The my reader. */
   private BufferedReader myReader;
   
   /** The my writer. */
   private DataOutputStream myWriter;


   /**
    * Instantiates a new GFM client tcp.
    *
    * @param serverIp the server ip
    * @param serverPort the server port
    * @throws UnknownHostException the unknown host exception
    * @throws IOException Signals that an I/O exception has occurred.
    */
   // same thing with error handling, see server note.
   public GFMClientTCP(String serverIp, int serverPort) throws UnknownHostException, IOException {
      myServerIp = serverIp;
      myServerPort = serverPort;
      connect();
   }

   /**
    * Connect.
    *
    * @throws UnknownHostException the unknown host exception
    * @throws IOException Signals that an I/O exception has occurred.
    */
   public void connect() throws UnknownHostException, IOException {
      mySocket = new Socket(myServerIp, myServerPort);
      myInputStream = mySocket.getInputStream();
      myOutputStream = mySocket.getOutputStream();
      InputStreamReader in = new InputStreamReader(myInputStream);
      myReader = new BufferedReader(in);
      myWriter = new DataOutputStream(myOutputStream);
   }
}