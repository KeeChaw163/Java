package chatroomclient;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import chatroomutil.ChatRoomUtil;
import chatroomutil.Server;
public class ClientServer extends Server implements Runnable {//�ͻ�����ˣ������߳��������
	 ChatRoom chatRoom;
     private int myPort;
     public ClientServer(String serverIP, int serverPort) throws IOException {
         super();
         myPort = init();
     }
     int getMyServerPort() {
         return myPort;
     }
     private int createServerSocket(int i) throws IOException {//�󶨶˿�i
         if (i >= 65536) {
             ChatRoomUtil.showErrorBox("ClientServer�޶˿ڿɰ�");
             System.exit(-1);
         }
         try {
             sSocket = new ServerSocket(i);
         } catch (IOException e) {
             return createServerSocket(i + 1);
         }
         return i;
     }
     private int init() throws IOException {
         int port = createServerSocket(1025); //����ServerSocket���󣬰󶨼����˿�
         return port;
     }
	@Override
	protected String handle(Socket ots, String rMessage) {
		// TODO Auto-generated method stub
		 String message = "getm";
         if (rMessage.startsWith("newf")) {
             while (chatRoom == null) {
                 try {
                     Thread.sleep(300);
                 } catch (InterruptedException e) {
                     ChatRoomUtil.showErrorBox("ClientServer��Sleepʱ����");
                     System.exit(-1); //�������˳�
                 }
             }
             String ids = rMessage.substring(("newf").length());
             String[] idArray = ids.split(";");
             chatRoom.addFriend(idArray);
         }
         if (rMessage.startsWith("offl")) { //�û�����
        	 //startsWith�������жϵ�ǰ�ַ����Ƿ�������ַ���
             String name = rMessage.substring(("offl").length()); 
             chatRoom.removeFriend(name); //���û�����
         }
         if (rMessage.startsWith("mesg")) { //��Ϣû��
             String mesg = rMessage.substring(("mesg").length());
             chatRoom.addRecord(mesg); //��¼����Ϣ
         }
         if (rMessage.startsWith("chat")) {  //����
             String chat = rMessage.substring(("chat").length());
             String id = chat.substring(0, chat.indexOf(':'));
             String mesg = chat.substring(chat.indexOf(':') + 1);
             chatRoom.dialogAddRecord(id, mesg);
         }
		return message;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		listen();
	}

}
