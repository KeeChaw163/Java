package chatroomclient;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashSet;
import java.util.TimerTask;
import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import chatroomsend.Send;
import chatroomutil.ChatRoomUtil;
public class ChatDialog extends JFrame implements ActionListener {//�Ի���
	 private static final long serialVersionUID = 1437996471885472344L;
     String myId;
     String otsId;
     String serverIP;
     int serverPort;
     JLabel chatRoomLabel = new JLabel();
     JTextArea chatArea = new JTextArea();
     JTextArea sendArea = new JTextArea(5, 20);
     JButton sendButton = new JButton();
     JScrollPane chatScroll = new JScrollPane(chatArea);
     JScrollPane sendScroll = new JScrollPane(sendArea);
     JPanel chatPanel = new JPanel();
     JPanel sendPanel = new JPanel();
     HashSet<String> friends = new HashSet<String>();
     BorderLayout mainLayout = new BorderLayout();
     BorderLayout chatLayout = new BorderLayout();
     BorderLayout sendLayout = new BorderLayout();
     ChatRoom chatRoom;
     public ChatDialog(final ChatRoom chatRoom, String id, final String otsId,
             String serverIP, int port) {
         super(id + "��" + otsId + "����");
         this.chatRoom = chatRoom;
         this.myId = id;
         this.otsId = otsId;
         this.serverIP = serverIP;
         this.serverPort = port;
         mainLayout.setVgap(5);
         sendLayout.setHgap(10);
         this.setLayout(mainLayout);
         chatPanel.setLayout(chatLayout);
         sendPanel.setLayout(sendLayout);
         chatArea.setLineWrap(true);
         sendArea.setLineWrap(true);
         sendButton.setText("   ����    ");
         sendButton.setBackground(Color.LIGHT_GRAY);
         sendButton.addActionListener(this);
         chatRoomLabel.setText("����");
         chatArea.setEditable(false);
         chatArea.setBackground(new Color(230, 230, 230));
         chatPanel.add(chatRoomLabel, BorderLayout.NORTH);
         chatPanel.add(chatScroll, BorderLayout.CENTER);
         sendPanel.add(sendScroll, BorderLayout.CENTER);
         sendPanel.add(sendButton, BorderLayout.EAST);
         this.add(sendPanel, BorderLayout.SOUTH);
         this.add(chatPanel, BorderLayout.CENTER);
         this.setBounds(200, 200, 530, 600);
         setVisible(true);
         this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
         sendArea.addCaretListener(new CaretListener() {
             @Override
             public void caretUpdate(CaretEvent e) {
                 String str = sendArea.getText();
                 if (str.length() > 5000) {
                     ChatRoomUtil.showErrorBox("�������࣬�������ơ�");
                 }
             }
         });
         this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
         this.addWindowListener(new WindowAdapter() {
        	 public void windowClosing(WindowEvent e) {//�رմ��ں�ChatRoomҪ�Ƴ��öԻ�
                 chatRoom.removeDialog(otsId);
                 dispose();
             }
         });
         new java.util.Timer().schedule(new TimerTask() {
             public void run() {
                 repaint();
             }
         }, 400, 400);
     }
     public int addRecord(String mesg) {
         chatArea.append(mesg + "\n");
         chatArea.setCaretPosition(chatArea.getText().length());
         this.validate();
         return 0;
     }
     private String sendMessage(String mesg) {
         Send sendClient = new Send();
         sendClient.connect(serverIP, serverPort, 1000);
         String getm = sendClient.send(
                 "chat" + otsId + ":" + myId + ":" + myId + ":   \n" + mesg);
         addRecord(myId + ":   \n" + mesg);
         return getm;
     }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 if (e.getSource().getClass() == JButton.class) {
             sendMessage(sendArea.getText());
             sendArea.setText("");
         }
	}

}
