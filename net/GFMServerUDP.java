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
   
   /** The my socket. */
   private DatagramSocket mySocket;
   
   /** The my port. */
   private int myPort;
   
   /** The my client port. */
   private int myClientPort;
   
   /** The my client address. */
   private InetAddress myClientAddress;
   
   /** The my packet in. */
   // need "soundmanager" of packets?
   private DatagramPacket myPacketIn;
   
   /** The my packet out. */
   private DatagramPacket myPacketOut;

   /**
    * Instantiates a new GFM server udp.
    *
    * @param port the port
    * @throws IOException Signals that an I/O exception has occurred.
    */
   public GFMServerUDP(int port) throws IOException {
      this(null, port);
   }
   
   /**
    * Instantiates a new GFM server udp.
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
    * Connect.
    *
    * @param ip the ip
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
    * Send.
    *
    * @param data the data
    * @throws IOException Signals that an I/O exception has occurred.
    */
   public void send(byte[] data) throws IOException {
      myPacketOut =
            new DatagramPacket(data, data.length, myClientAddress, myClientPort);
      mySocket.send(myPacketOut);
   }

   /**
    * Receive.
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
    * Close.
    */
   public void close() {
      mySocket.close();
   }
}