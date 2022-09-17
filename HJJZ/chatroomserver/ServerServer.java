package chatroomserver;
import java.io.BufferedReader;//从字符输入流中读取文本并缓冲字符
import java.io.FileNotFoundException;  //对文件进行输入输出流操作
import java.io.FileReader;   //按字符读取流中数据
import java.io.IOException; //流异常
import java.io.RandomAccessFile; //访问保存的数据记录文件
import java.net.ServerSocket;   //负责接收客户连接请求--服务器端
import java.net.Socket;//负责接收客户连接请求--建立在网络
import java.util.Enumeration; //接口类，封装了有关枚举数据集合的方法连接
import java.util.Hashtable;   //缓存在线离线人数
import chatroomsend.Send; //调用包中的类
import chatroomutil.ChatRoomUtil; //调用包中的类
import chatroomutil.Server;  //调用包中的类
public class ServerServer extends Server {
	Hashtable<String, User> onlineTable = new Hashtable<String, User>();// 在线用户集合
	Hashtable<String, User> offlineTable = new Hashtable<String, User>();// 离线用户集合
	// 用户内部类
	class User {
		String id;  //账号
		String pwd; //密码
		String IP;  //地址
		int port;  //端口
		User(String id, String pwd) {
			this.id = id;
			this.pwd = pwd;
		}
	}
	// 发送进程内部类
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

	public ServerServer(int port) throws IOException { //这个方法可能会抛出异常
		init(port);  //对端口等进行初始化
		initUsers();
		listen();
	}

	private int init(int port) throws IOException {
		try {
			sSocket = new ServerSocket(port);// 绑定指定端口
		} catch (IOException e) {
			ChatRoomUtil.showErrorBox("服务器初始化失败，无法绑定端口。"); //显示错误信息的对话框
			System.exit(-1);
		}
		return port;
	}

	private int initUsers() {// 读取Users文件，初始化offlineTable
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("D:\\新建文件夹\\新建文件夹\\hjjz\\src\\chatroomserver\\Users.txt"));
		} catch (FileNotFoundException e1) {
			ChatRoomUtil.showErrorBox("无法找到User文件");
			System.exit(-1);
		}
		String line;
		String[] fa;
		try {
			while ((line = reader.readLine()) != null) { //读取整个文件的所有行
				fa = line.split(":", 2);
				User f = new User(fa[0], fa[1]); //发文件的地址
				offlineTable.put(fa[0], f);
			}
			reader.close();
		} catch (IOException e) {
			ChatRoomUtil.showErrorBox("读取User文件错误");
			System.exit(-1);
		}
		return 0;
	}

	private int saveNewUser(String id, String pwd) {// 将新用户写入Users文件最后
		try {
			RandomAccessFile file = new RandomAccessFile("D:\\新建文件夹\\新建文件夹\\hjjz\\src\\chatroomserver\\Users.txt", "rw");
			file.seek(file.length());
			file.writeBytes(id + ":" + pwd + "\r\n");
			file.close();
		} catch (FileNotFoundException e) {
			ChatRoomUtil.showErrorBox("写入User文件错误");
			System.exit(-1);
		} catch (IOException e) {
			ChatRoomUtil.showErrorBox("写入User文件错误");
			System.exit(-1);  //非正常退出
		}
		return 0;
	}

	String loginCheck(String id, String pwd, String IP, int port) {// 检查登录用户的合法性
		System.out.println("logi check");
		if (onlineTable.containsKey(id))
			return "alreadyonline";// 该用户已在线
		User f = offlineTable.get(id);
		if (f == null)
			return "nothisid";// 无此用户
		if (f.pwd.compareTo(pwd) == 0) {
			oneUserOnline(id, IP, port);
			sendOnlinesToNewOnlineUser(id, IP, port);
			sendNewOnlineUserToOnlines(id);
			return "yes";// 合法
		} else {
			return "wrong";// 密码错误
		}
	}

	int oneUserOnline(String id, String IP, int port) {// 一个新用户上线
		User f = offlineTable.get(id);
		offlineTable.remove(id);
		onlineTable.put(id, f);
		f.IP = IP;
		f.port = port;
		return 0;
	}

	int sendNewOnlineUserToOnlines(String id) {// 给所有在线用户发送新上线的用户的id
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

	int sendMesg(String mesg) {// 向所有在线用户转发一条消息
		Enumeration<User> fs = onlineTable.elements();
		while (fs.hasMoreElements()) {
			User f = fs.nextElement();
			Thread hThread = new Thread(new sendThread(f.IP, f.port, "mesg" + mesg));
			hThread.start();
		}
		return 0;
	}

	int sendChat(String id, String mesg) {// 向一个用户发送一条一对一聊天的消息
		User f = onlineTable.get(id);
		Thread hThread = new Thread(new sendThread(f.IP, f.port, "chat" + mesg));
		hThread.start();
		return 0;
	}

	String newRegisUser(String id, String pwd) {// 有新注册的用户
		if (onlineTable.containsKey(id) || offlineTable.containsKey(id)) {
			return "no";
		}
		offlineTable.put(id, new User(id, pwd));
		saveNewUser(id, pwd);
		return "yes";
	}

	int sendOnlinesToNewOnlineUser(String id, String IP, int port) {// 给新上线的用户发送所有已在线用户的id
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

	int oneUserOffline(String id) {// 有一个用户下线，将其下线消息发送给所有在线用户
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
		if (rMessage.startsWith("regi")) {// 注册
			rMessage = rMessage.substring("regi".length());
			String id = rMessage.substring(0, rMessage.indexOf(','));
			String pwd = rMessage.substring(rMessage.indexOf(',') + 1);
			return newRegisUser(id, pwd);
		}
		if (rMessage.startsWith("logi")) {// 登录
			System.out.println("logi");
			rMessage = rMessage.substring("logi".length());
			String id = rMessage.substring(0, rMessage.indexOf(','));
			String pwd = rMessage.substring(rMessage.indexOf(',') + 1, rMessage.lastIndexOf(','));
			String portstr = rMessage.substring(rMessage.lastIndexOf(',') + 1);
			int port = new Integer(portstr);
			String IP = ots.getInetAddress().getHostAddress();
			return loginCheck(id, pwd, IP, port);
		}
		if (rMessage.startsWith("mesg")) {// 聊天室消息
			String mesg = rMessage.substring(("mesg").length());
			sendMesg(mesg);
			return "getm";
		}
		if (rMessage.startsWith("chat")) {// 一对一消息
			String chat = rMessage.substring(("chat").length());
			String id = chat.substring(0, chat.indexOf(':'));
			String mesg = chat.substring(chat.indexOf(':') + 1);
			sendChat(id, mesg);
			return "getm";
		}
		if (rMessage.startsWith("offl")) {// 下线
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
