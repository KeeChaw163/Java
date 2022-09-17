package chatroomclient;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.*;
import chatroomsend.Send;
import chatroomutil.ChatRoomUtil;
public class LoginBox extends JFrame implements ActionListener, MouseListener {     //��¼��
	private static final long serialVersionUID = -329711894663212488L; //��ϣ�ֶ�
	ClientServer myServer;
	String serverIP;
	int serverPort;
	JLabel l_account = new JLabel();
	JLabel l_password = new JLabel();
	JLabel l_regist = new JLabel();  //ע��
	JTextField j_account = new JTextField();
	JPasswordField j_password = new JPasswordField();
	JButton submit = new JButton(); //�ύ
	JButton cancel = new JButton(); //ȡ��
	JLabel clearAccount = new JLabel();  //���˺�
	JLabel clearPassword = new JLabel(); //������

	public LoginBox(String ip, int port) {
		super("��¼    ||     HJJZ   ");
		try {
			myServer = new ClientServer(serverIP, serverPort);
			Thread myServerThread = new Thread(myServer);
			myServerThread.start();
		} catch (IOException e) {
			ChatRoomUtil.showErrorBox("���������̳�ʼ��ʧ�ܣ��޷��󶨶˿ڡ�");
			System.exit(-1);  //�޷������˳�
		}
		serverIP = ip;
		serverPort = port;
		setLayout(null); //�����û������ϵ���Ļ����ĸ�ʽ����
		l_account.setVisible(true); //������ʾ������GUI���
		l_account.setBounds(80, 40, 50, 30); //���õ�½����
		l_account.setText("�˺�:");
		l_password.setVisible(true);
		l_password.setBounds(80, 80, 50, 30);
		l_password.setText("����:");
		j_account.setBounds(130, 40, 150, 30);
		j_password.setBounds(130, 80, 150, 30);
		clearAccount.setBounds(280, 42, 26, 26);
		clearPassword.setBounds(280, 82, 26, 26);
		submit.setBounds(100, 130, 80, 30);
		submit.setText("��¼");
		cancel.setText("ȡ��");
		clearAccount.setText("X");
		clearPassword.setText("X");
		clearAccount.setOpaque(true); //���ÿؼ��Ƿ�͸��
		clearPassword.setOpaque(true);
		clearAccount.setBackground(Color.LIGHT_GRAY);  //���õײ���ɫ
		clearPassword.setBackground(Color.LIGHT_GRAY);
		clearAccount.setHorizontalAlignment(JLabel.CENTER);
		clearPassword.setHorizontalAlignment(JLabel.CENTER);
		submit.setBackground(Color.LIGHT_GRAY);
		cancel.setBackground(Color.LIGHT_GRAY);
		submit.addActionListener(this);
		cancel.addActionListener(this);
		cancel.setBounds(190, 130, 80, 30);
		l_regist.setBounds(270, 200, 70, 30);
		l_regist.setText("û���˺�?");
		this.add(l_account);
		this.add(l_password);
		this.add(j_account);
		this.add(j_password);
		this.add(submit);  //�ύ
		this.add(cancel);
		this.add(l_regist); //ע��
		this.add(clearAccount);
		this.add(clearPassword);
		setBounds(480, 240, 370, 270);
		setVisible(true);
		setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		validate();
		l_regist.addMouseListener(this);
		clearAccount.addMouseListener(this);
		clearPassword.addMouseListener(this);
	}

	String checkPwd(String id, String pwd) {
		Send sendClient = new Send();
		sendClient.connect(serverIP, serverPort, 1000);
		String ret = sendClient.send("logi" + id + "," + pwd + "," + myServer.getMyServerPort());
		if (ret.compareTo("yes") == 0) {
			myServer.chatRoom = new ChatRoom(id, serverIP, serverPort);
			dispose();
		} else if (ret.compareTo("wrong") == 0) {
			ChatRoomUtil.showErrorBox("��¼ʧ�ܣ���������");
		} else if (ret.compareTo("alreadyonline") == 0) {
			ChatRoomUtil.showErrorBox("��¼ʧ�ܣ����˺�������");
		} else if (ret.compareTo("nothisid") == 0) {
			ChatRoomUtil.showErrorBox("��¼ʧ�ܣ��˺Ų����ڡ�");
			new RegisBox(serverIP, serverPort, myServer.getMyServerPort());
		}
		return ret;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(l_regist)) {
			new RegisBox(serverIP, serverPort, myServer.getMyServerPort());
		}
		if (e.getSource().equals(clearAccount)) {
			j_account.setText("");
		}
		if (e.getSource().equals(clearPassword)) {
			j_password.setText("");
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		Object x = e.getSource();
		if (x.equals(l_regist)) {
			JLabel l = (JLabel) x;
			l.setForeground(Color.blue);
		}
		if (x.equals(clearAccount) || x.equals(clearPassword)) {
			JLabel l = (JLabel) x;
			l.setBackground(Color.GRAY);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		Object x = e.getSource();
		if (x.equals(l_regist)) {
			JLabel l = (JLabel) x;
			l.setForeground(Color.BLACK);
		}
		if (x.equals(clearAccount) || x.equals(clearPassword)) {
			JLabel l = (JLabel) x;
			l.setBackground(Color.LIGHT_GRAY);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {  //�¼�������
		// TODO Auto-generated method stub
		Object t = e.getSource();
		if (e.getSource().getClass() == JButton.class) {
			JButton button = (JButton) (t);
			if (button.getText().compareTo("��¼") == 0) {
				String id = j_account.getText();
				String pwd = String.valueOf(j_password.getPassword());
				if (id.compareTo("") == 0 || pwd.compareTo("") == 0) {
					ChatRoomUtil.showErrorBox("�˺������������Ϊ��");
					return;
				}
				checkPwd(id, pwd);
			}
			if (button.getText().compareTo("ȡ��") == 0) {
				dispose();
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		String serverIP = "127.0.0.1";
		int serverPort = 65142;
		new LoginBox(serverIP, serverPort);
	}

}
