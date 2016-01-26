package gfm.net;

import java.net.InetAddress;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class GFMClientUDP {
   private DatagramSocket mySocket;
   private InetAddress myServerAddress;
   private int myServerPort;
   private DatagramPacket myPacketIn;
   private DatagramPacket myPacketOut;


   public GFMClientUDP(int port) throws IOException {
      this("", port);
   }
   public GFMClientUDP(String serverIp, int port) throws IOException {
      myServerPort = port;
      mySocket = new DatagramSocket();
      connect(serverIp);
   }

   private void connect(String serverIp) throws IOException {
      myServerAddress = InetAddress.getByName(serverIp);
      send(new byte[]{0});
   }

   public void send(byte[] data) throws IOException {
      myPacketOut =
            new DatagramPacket(data, data.length, myServerAddress, myServerPort);
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