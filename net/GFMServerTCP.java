/*
 *
 */
package gfm.net;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The GFM TCP server class.
 */
public class GFMServerTCP {
   public static void main(String[] args) {

   }

   /** The port number. */
   private int myPort;

   /** The server socket. */
   private ServerSocket myServerSocket;

   /** The socket in. */
   private Socket mySocketIn;

   /** The input stream. */
   private InputStream myInputStream;

   /** The output stream. */
   private OutputStream myOutputStream;

   /** The buffered reader. */
   private BufferedReader myReader;

   /** The data outputstream. */
   private DataOutputStream myWriter;

   /**
    * Instantiates a new GFM TCP server.
    *
    * @param port the port to start the server on
    * @throws IOException Signals that an I/O exception has occurred.
    */
   public GFMServerTCP(int port) throws IOException {
      myPort = port;
      myServerSocket = new ServerSocket(myPort);
      connect();
   }

   /**
    * Wait for a connection from a client.
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