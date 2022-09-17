package chatroomutil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;
public class ChatRoomUtil {
	public static String showErrorBox(String message) {//��ʾ������Ϣ�Ի���
         JOptionPane.showMessageDialog(null, message, "����",
                 JOptionPane.ERROR_MESSAGE);
         return message;
     }
     //��ȡ��Ϣ
     public static BufferedReader getMsgFromSocket(Socket socket,StringBuffer buffer){
         BufferedReader reader = null;
         try {
             reader = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
         } catch (IOException e) {
             ChatRoomUtil.showErrorBox("��ȡSocket����������");
	             System.exit(-1);
         }
         try {
             String line = "";
             while ((line = reader.readLine()) != null) {
                 buffer.append(line + "\n");
             }
             buffer.deleteCharAt(buffer.length()-1);//ȥ�����һ���س���
         } catch (IOException e) {
             ChatRoomUtil.showErrorBox("��ȡSocket����������");
             System.exit(-1);
         }
         try {
             socket.shutdownInput();
         } catch (IOException e) {
             ChatRoomUtil.showErrorBox("�ر�Socket����ʱ��������");
             System.exit(-1);
         }
         return reader; 
     }
     //������Ϣ
     public static PrintWriter putMesgToSocket(Socket socket,String message){
         PrintWriter writer = null;
         try {
             writer = new PrintWriter(socket.getOutputStream());
         } catch (IOException e) {
             ChatRoomUtil.showErrorBox("��ȡSocket���������");
             System.exit(-1);
         }
         writer.println(message);
         writer.flush();
         try {
             socket.shutdownOutput();
         } catch (IOException e1) {
             ChatRoomUtil.showErrorBox("�ر�Socket���ʱ��������");
             System.exit(-1);
         }
         return writer;
     }
	     //�ر�socket���������������
     public static void closeSocket(Socket socket,BufferedReader reader,PrintWriter writer ){
         try {
             reader.close();
         } catch (IOException e) {
             ChatRoomUtil.showErrorBox("�ر�Scoket������ʱ��������");
             System.exit(-1);
         }
         writer.close();
         try {
             socket.close();
         } catch (IOException e) {
	             ChatRoomUtil.showErrorBox("�ر�Scoket�����ʱ��������");
             System.exit(-1);
         }
     }
}
