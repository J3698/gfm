package gfm.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// TODO: Auto-generated Javadoc
/**
 * The Class GFMServerUDP.
 */
public class GFMServerUDP {

   /** The socket. */
   private DatagramSocket mySocket;

   /** The port number. */
   private int myPort;

   /** The client port number. */
   private int myClientPort;

   /** The client address. */
   private InetAddress myClientAddress;

   /** The packet for receiving data. */
   private DatagramPacket myPacketIn;

   /** The packet for sending data. */
   private DatagramPacket myPacketOut;

   /**
    * Instantiates a new UDP GFM server.
    *
    * @param port the port
    * @throws IOException Signals that an I/O exception has occurred.
    */
   public GFMServerUDP(int port) throws IOException {
      this(null, port);
   }

   /**
    * Instantiates a new UDP GFM server.
    *
    * @param clientIp the client ip
    * @param port the port
    * @throws IOException Signals that an I/O exception has occurred.
    */
   public GFMServerUDP(String clientIp, int port) throws IOException {
      myPort = port;
      mySocket = new DatagramSocket(myPort);
      connect(clientIp);
   }

   /**
    * Wait for a given ip to connect, or if ip is null, wait for any connection.
    *
    * @param ip the client ip to wait for, or null
    * @throws IOException Signals that an I/O exception has occurred.
    */
   private void connect(String ip) throws IOException {
      byte[] connectData = new byte[1];
      myPacketIn = new DatagramPacket(connectData, connectData.length);
      mySocket.receive(myPacketIn);
      myClientAddress = myPacketIn.getAddress();
      myClientPort = myPacketIn.getPort();
      // if we're wating for a specific ip
      if ( ip != null ) {
         while ( !myClientAddress.getHostAddress().equals(ip) ) {
            mySocket.receive(myPacketIn);
            myClientAddress = myPacketIn.getAddress();
            myClientPort = myPacketIn.getPort();
         }
      }
   }

   /**
    * Send the given byte data.
    *
    * @param data the data
    * @throws IOException Signals that an I/O exception has occurred.
    */
   public void send(final byte[] data) throws IOException {
      myPacketOut =
            new DatagramPacket(data, data.length, myClientAddress, myClientPort);
      mySocket.send(myPacketOut);
   }

   /**
    * Receive the given byte data.
    *
    * @param bytes the bytes
    * @return the byte[]
    * @throws IOException Signals that an I/O exception has occurred.
    */
   public byte[] receive(int bytes) throws IOException {
      byte[] data = new byte[bytes];
      myPacketIn = new DatagramPacket(data, data.length);
      mySocket.receive(myPacketIn);
      return data;
   }

   /**
    * Close the server.
    */
   public void close() {
      mySocket.close();
   }
}