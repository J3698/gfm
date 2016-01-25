package gfm.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class GFMServerUDP {
   private DatagramSocket mySocket;
   private int myPort;
   private int myClientPort;
   private InetAddress myClientAddress;
   // need "soundmanager" of packets?
   private DatagramPacket myPacketIn;
   private DatagramPacket myPacketOut;

   public GFMServerUDP(int port) throws SocketException {
      this("", port);
   }
   public GFMServerUDP(String clientIp, int port) throws SocketException {
      myPort = port;
      connect(clientIp);
   }

   private void connect() {
      connect(null);
   }

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

   public void send(byte[] data) throws IOException {
      myPacketOut =
            new DatagramPacket(data, data.length, myClientAddress, myClientPort);
      mySocket.send(myPacketOut);
   }

   public byte[] receive(int bytes) throws IOException {
      byte[] data = new byte[bytes];
      myPacketIn = new DatagramPacket(data, data.length);
      mySocket.receive(myPacketIn);
      return data;
   }

   public void close() {
      mySocket.close();
   }
}