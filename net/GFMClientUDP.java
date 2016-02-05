package gfm.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// TODO: Auto-generated Javadoc
/**
 * The Class GFMClientUDP.
 */
public class GFMClientUDP {

   /** The my socket. */
   private DatagramSocket mySocket;

   /** The my server address. */
   private InetAddress myServerAddress;

   /** The my server port. */
   private int myServerPort;

   /** The my packet in. */
   private DatagramPacket myPacketIn;

   /** The my packet out. */
   private DatagramPacket myPacketOut;


   /**
    * Instantiates a new GFM client udp.
    *
    * @param port the port
    * @throws IOException Signals that an I/O exception has occurred.
    */
   public GFMClientUDP(int port) throws IOException {
      this("", port);
   }

   /**
    * Instantiates a new GFM client udp.
    *
    * @param serverIp the server ip
    * @param port the port
    * @throws IOException Signals that an I/O exception has occurred.
    */
   public GFMClientUDP(String serverIp, int port) throws IOException {
      myServerPort = port;
      mySocket = new DatagramSocket();
      connect(serverIp);
   }

   /**
    * Connect.
    *
    * @param serverIp the server ip
    * @throws IOException Signals that an I/O exception has occurred.
    */
   private void connect(String serverIp) throws IOException {
      myServerAddress = InetAddress.getByName(serverIp);
      send(new byte[]{0});
   }

   /**
    * Send.
    *
    * @param data the data
    * @throws IOException Signals that an I/O exception has occurred.
    */
   public void send(final byte[] data) throws IOException {
      myPacketOut =
            new DatagramPacket(data, data.length, myServerAddress, myServerPort);
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