package chatroomutil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
public abstract class Server {
	 protected ServerSocket sSocket;
     public Server() {
     }
     protected int listen() {
         while (true) {
             Socket ots = null;
             try {
                 ots = sSocket.accept();
             } catch (IOException e) {
                 ChatRoomUtil.showErrorBox("������Accept����");
                 System.exit(-1);
             }
             Thread hThread = new Thread(new handleThread(ots));
             hThread.start();
         }
     }
     // ������Ϣ�Ľ��� ���ڲ���
     class handleThread implements Runnable {
         Socket ots;
         handleThread(Socket ots) {
             this.ots = ots;
         }
         @Override
         public void run() {
             handleMessage(ots);
         }
     };
     protected abstract String handle(Socket ots,String rMessage);//�������������յ�����Ϣ������Ҫ���͵���Ϣ
     private String handleMessage(Socket ots) {
         StringBuffer buffer=new StringBuffer();
         BufferedReader reader=ChatRoomUtil.getMsgFromSocket(ots,buffer);//��ȡ��Ϣ
         String rMessage = buffer.toString();
         String message=handle(ots,rMessage);//������Ϣ
         PrintWriter writer=ChatRoomUtil.putMesgToSocket(ots, message);//������Ϣ
         ChatRoomUtil.closeSocket(ots,reader,writer);//�ر�
         return null;
     }
}
