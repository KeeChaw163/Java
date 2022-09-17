package chatroomserver;
import java.io.BufferedReader;//���ַ��������ж�ȡ�ı��������ַ�
import java.io.FileNotFoundException;  //���ļ������������������
import java.io.FileReader;   //���ַ���ȡ��������
import java.io.IOException; //���쳣
import java.io.RandomAccessFile; //���ʱ�������ݼ�¼�ļ�
import java.net.ServerSocket;   //������տͻ���������--��������
import java.net.Socket;//������տͻ���������--����������
import java.util.Enumeration; //�ӿ��࣬��װ���й�ö�����ݼ��ϵķ�������
import java.util.Hashtable;   //����������������
import chatroomsend.Send; //���ð��е���
import chatroomutil.ChatRoomUtil; //���ð��е���
import chatroomutil.Server;  //���ð��е���
public class ServerServer extends Server {
	Hashtable<String, User> onlineTable = new Hashtable<String, User>();// �����û�����
	Hashtable<String, User> offlineTable = new Hashtable<String, User>();// �����û�����
	// �û��ڲ���
	class User {
		String id;  //�˺�
		String pwd; //����
		String IP;  //��ַ
		int port;  //�˿�
		User(String id, String pwd) {
			this.id = id;
			this.pwd = pwd;
		}
	}
	// ���ͽ����ڲ���
	class sendThread implements Runnable {
		String mesg;
		String IP;
		int port;

		sendThread(String IP, int port, String mesg) {
			this.IP = IP;
			this.port = port;
			this.mesg = mesg;
		}

		@Override
		public void run() {
			Send sendClient = new Send();
			sendClient.connect(IP, port, 1000);
			sendClient.send(mesg);
		}
	}

	public ServerServer(int port) throws IOException { //����������ܻ��׳��쳣
		init(port);  //�Զ˿ڵȽ��г�ʼ��
		initUsers();
		listen();
	}

	private int init(int port) throws IOException {
		try {
			sSocket = new ServerSocket(port);// ��ָ���˿�
		} catch (IOException e) {
			ChatRoomUtil.showErrorBox("��������ʼ��ʧ�ܣ��޷��󶨶˿ڡ�"); //��ʾ������Ϣ�ĶԻ���
			System.exit(-1);
		}
		return port;
	}

	private int initUsers() {// ��ȡUsers�ļ�����ʼ��offlineTable
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("D:\\�½��ļ���\\�½��ļ���\\hjjz\\src\\chatroomserver\\Users.txt"));
		} catch (FileNotFoundException e1) {
			ChatRoomUtil.showErrorBox("�޷��ҵ�User�ļ�");
			System.exit(-1);
		}
		String line;
		String[] fa;
		try {
			while ((line = reader.readLine()) != null) { //��ȡ�����ļ���������
				fa = line.split(":", 2);
				User f = new User(fa[0], fa[1]); //���ļ��ĵ�ַ
				offlineTable.put(fa[0], f);
			}
			reader.close();
		} catch (IOException e) {
			ChatRoomUtil.showErrorBox("��ȡUser�ļ�����");
			System.exit(-1);
		}
		return 0;
	}

	private int saveNewUser(String id, String pwd) {// �����û�д��Users�ļ����
		try {
			RandomAccessFile file = new RandomAccessFile("D:\\�½��ļ���\\�½��ļ���\\hjjz\\src\\chatroomserver\\Users.txt", "rw");
			file.seek(file.length());
			file.writeBytes(id + ":" + pwd + "\r\n");
			file.close();
		} catch (FileNotFoundException e) {
			ChatRoomUtil.showErrorBox("д��User�ļ�����");
			System.exit(-1);
		} catch (IOException e) {
			ChatRoomUtil.showErrorBox("д��User�ļ�����");
			System.exit(-1);  //�������˳�
		}
		return 0;
	}

	String loginCheck(String id, String pwd, String IP, int port) {// ����¼�û��ĺϷ���
		System.out.println("logi check");
		if (onlineTable.containsKey(id))
			return "alreadyonline";// ���û�������
		User f = offlineTable.get(id);
		if (f == null)
			return "nothisid";// �޴��û�
		if (f.pwd.compareTo(pwd) == 0) {
			oneUserOnline(id, IP, port);
			sendOnlinesToNewOnlineUser(id, IP, port);
			sendNewOnlineUserToOnlines(id);
			return "yes";// �Ϸ�
		} else {
			return "wrong";// �������
		}
	}

	int oneUserOnline(String id, String IP, int port) {// һ�����û�����
		User f = offlineTable.get(id);
		offlineTable.remove(id);
		onlineTable.put(id, f);
		f.IP = IP;
		f.port = port;
		return 0;
	}

	int sendNewOnlineUserToOnlines(String id) {// �����������û����������ߵ��û���id
		Enumeration<User> fs = onlineTable.elements();
		while (fs.hasMoreElements()) {
			User f = fs.nextElement();
			if (f.id.compareTo(id) != 0) {
				Thread hThread = new Thread(new sendThread(f.IP, f.port, "newf" + id));
				hThread.start();
			}
		}
		return 0;
	}

	int sendMesg(String mesg) {// �����������û�ת��һ����Ϣ
		Enumeration<User> fs = onlineTable.elements();
		while (fs.hasMoreElements()) {
			User f = fs.nextElement();
			Thread hThread = new Thread(new sendThread(f.IP, f.port, "mesg" + mesg));
			hThread.start();
		}
		return 0;
	}

	int sendChat(String id, String mesg) {// ��һ���û�����һ��һ��һ�������Ϣ
		User f = onlineTable.get(id);
		Thread hThread = new Thread(new sendThread(f.IP, f.port, "chat" + mesg));
		hThread.start();
		return 0;
	}

	String newRegisUser(String id, String pwd) {// ����ע����û�
		if (onlineTable.containsKey(id) || offlineTable.containsKey(id)) {
			return "no";
		}
		offlineTable.put(id, new User(id, pwd));
		saveNewUser(id, pwd);
		return "yes";
	}

	int sendOnlinesToNewOnlineUser(String id, String IP, int port) {// �������ߵ��û����������������û���id
		if (onlineTable.isEmpty() || onlineTable.size() == 1) {
			return 0;
		}
		StringBuffer strBuf = new StringBuffer();
		Enumeration<User> fs = onlineTable.elements();
		while (fs.hasMoreElements()) {
			User f = fs.nextElement();
			if (f.id.compareTo(id) != 0) {
				strBuf.append(f.id);
				strBuf.append(";");
			}
		}
		String str = strBuf.toString();
		Thread hThread = new Thread(new sendThread(IP, port, "newf" + str));
		hThread.start();
		return 0;
	}

	int oneUserOffline(String id) {// ��һ���û����ߣ�����������Ϣ���͸����������û�
		Enumeration<User> fs = onlineTable.elements();
		while (fs.hasMoreElements()) {
			User f = fs.nextElement();
			if (f.id.compareTo(id) == 0) {
				onlineTable.remove(id);
				offlineTable.put(id, f);
			} else {
				Thread hThread = new Thread(new sendThread(f.IP, f.port, "offl" + id));
				hThread.start();
			}
		}
		return 0;
	}

	protected String handle(Socket ots, String rMessage) {
		System.out.println("handle");
		if (rMessage.startsWith("regi")) {// ע��
			rMessage = rMessage.substring("regi".length());
			String id = rMessage.substring(0, rMessage.indexOf(','));
			String pwd = rMessage.substring(rMessage.indexOf(',') + 1);
			return newRegisUser(id, pwd);
		}
		if (rMessage.startsWith("logi")) {// ��¼
			System.out.println("logi");
			rMessage = rMessage.substring("logi".length());
			String id = rMessage.substring(0, rMessage.indexOf(','));
			String pwd = rMessage.substring(rMessage.indexOf(',') + 1, rMessage.lastIndexOf(','));
			String portstr = rMessage.substring(rMessage.lastIndexOf(',') + 1);
			int port = new Integer(portstr);
			String IP = ots.getInetAddress().getHostAddress();
			return loginCheck(id, pwd, IP, port);
		}
		if (rMessage.startsWith("mesg")) {// ��������Ϣ
			String mesg = rMessage.substring(("mesg").length());
			sendMesg(mesg);
			return "getm";
		}
		if (rMessage.startsWith("chat")) {// һ��һ��Ϣ
			String chat = rMessage.substring(("chat").length());
			String id = chat.substring(0, chat.indexOf(':'));
			String mesg = chat.substring(chat.indexOf(':') + 1);
			sendChat(id, mesg);
			return "getm";
		}
		if (rMessage.startsWith("offl")) {// ����
			String id = rMessage.substring(("offl").length());
			oneUserOffline(id);
			return "getm";
		}
		return "getm";
	}

	public static void main(String[] args) {
		try {
			new ServerServer(65142);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
