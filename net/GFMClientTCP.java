package gfm.net;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * The GFM TCP client class.
 */
public class GFMClientTCP {

   /** The server ip. */
   private String myServerIp;

   /** The server port. */
   private int myServerPort;

   /** The socket. */
   private Socket mySocket;

   /** The input stream. */
   private InputStream myInputStream;

   /** The output stream. */
   private OutputStream myOutputStream;

   /** The reader. */
   private BufferedReader myReader;

   /** The writer. */
   private DataOutputStream myWriter;


   /**
    * Instantiates a new GFM TCP client.
    *
    * @param serverIp the server ip
    * @param serverPort the server port
    * @throws UnknownHostException if client can't connect to the server
    * @throws IOException Signals that an I/O exception has occurred in connecting.
    */
   public GFMClientTCP(String serverIp, int serverPort) throws UnknownHostException, IOException {
      myServerIp = serverIp;
      myServerPort = serverPort;
      connect();
   }

   /**
    * Connect to the server.
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

   /**
    * Gets the buffered reader of this servers connection.
    *
    * @return the buffered reader
    */
   public BufferedReader getReader() { return myReader; }

   /**
    * Gets the data outputstream of this servers connection.
    *
    * @return the writer
    */
   public DataOutputStream getWriter() { return myWriter; }
}