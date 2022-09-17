package chatroomclient;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import chatroomsend.Send;
import chatroomutil.ChatRoomUtil;
public class RegisBox extends JFrame implements ActionListener {//ע���
	 private static final long serialVersionUID = 5795626909275119718L;
	 String serverIP;
	 int serverPort;
	 int myServerPort;
	 JLabel id_label = new JLabel();
	 JLabel pwd_label = new JLabel();
	 JLabel pwdCheck_label = new JLabel();
	 JLabel num_label = new JLabel();
	 JLabel firstName_label = new JLabel();
	 JLabel lastName_label = new JLabel();
	 JLabel age_label = new JLabel();
     JLabel sex_label = new JLabel();
     JTextField id_text = new JTextField();
     JPasswordField pwd_text = new JPasswordField();
     JPasswordField pwdCheck_text = new JPasswordField();
     JTextField num_text = new JTextField();
     JTextField firstName_text = new JTextField();
     JTextField lastName_text = new JTextField();
     JTextField age_text = new JTextField();
     JComboBox sex_box = new JComboBox();
     JButton cancel = new JButton();
     JButton regis = new JButton();
     public RegisBox(String serverIP, int serverPort, int myServerPort) {
    	 super();
         this.serverIP = serverIP;
         this.serverPort = serverPort;
         this.myServerPort = myServerPort;
         setLayout(null);
         setTitle("ע��    ||     HJJZ");
         id_label.setBounds(60, 23, 50, 20);
         pwd_label.setBounds(60, 53, 50, 20);
         pwdCheck_label.setBounds(50, 83, 70, 20);
         num_label.setBounds(60, 113, 50, 20);
         firstName_label.setBounds(60, 143, 50, 20);
         lastName_label.setBounds(60, 173, 50, 20);
         age_label.setBounds(60, 203, 50, 20);
         sex_label.setBounds(60, 233, 50, 20);
         id_text.setBounds(130, 20, 200, 26);
         pwd_text.setBounds(130, 50, 200, 26);
         pwdCheck_text.setBounds(130, 80, 200, 26);
         num_text.setBounds(130, 110, 200, 26);
         firstName_text.setBounds(130, 140, 200, 26);
         lastName_text.setBounds(130, 170, 200, 26);
         age_text.setBounds(130, 200, 200, 26);
         sex_box.setBounds(130, 230, 200, 26);
         regis.setBounds(190, 270, 70, 30);
         cancel.setBounds(270, 270, 70, 30);
         id_label.setText("�˺�");
         pwd_label.setText("����");
         pwdCheck_label.setText("����ȷ��");
         num_label.setText("���");
         firstName_label.setText("��");
         lastName_label.setText("��");
         age_label.setText("����");
         sex_label.setText("�Ա�");
         sex_box.addItem("��");
         sex_box.addItem("Ů");
         regis.setText("�ύ");
         cancel.setText("ȡ��");
         regis.setBackground(Color.LIGHT_GRAY);
         cancel.setBackground(Color.LIGHT_GRAY);
         sex_box.setBackground(Color.LIGHT_GRAY);
         regis.addActionListener(this);
         cancel.addActionListener(this);
         this.add(id_label);
         this.add(pwd_label);
         this.add(pwdCheck_label);
         this.add(num_label);
         this.add(firstName_label);
         this.add(lastName_label);
         this.add(age_label);
         this.add(sex_label);
         this.add(id_text);
         this.add(pwd_text);
         this.add(pwdCheck_text);
         this.add(num_text);
         this.add(firstName_text);
         this.add(lastName_text);
         this.add(age_text);
         this.add(sex_box);
         this.add(regis);
         this.add(cancel);
         setBounds(200, 200, 500, 400);
         validate();
         setResizable(false);
         setVisible(true);
     }
     boolean regis(String serverIP, int serverPort, String id, String pwd,
             int myServerPort) {
         Send sendClient = new Send();
         sendClient.connect(serverIP, serverPort, 1000);
         if (sendClient.send("regi" + id + "," + pwd).compareTo("yes") == 0) {
             return true;
         }
         return false;
     }
     boolean check() {
         String id = id_text.getText();
         String pwd = String.valueOf(pwd_text.getPassword());
         String pwdc = String.valueOf(pwdCheck_text.getPassword());
         String fName = firstName_text.getText();
         String lName = lastName_text.getText();
         String age = age_text.getText();
         String num = num_text.getText();
         String sex = sex_box.getSelectedItem().toString();
         if (id.compareTo("") == 0) {
             ChatRoomUtil.showErrorBox("�˺Ų���Ϊ��");
             return false;
         }
         if (pwd.compareTo("") == 0) {
             ChatRoomUtil.showErrorBox("���벻��Ϊ��");
             return false;
         }
         if (pwdc.compareTo("") == 0) {
             ChatRoomUtil.showErrorBox("��ȷ������");
             return false;
         }
         if (pwd.compareTo(pwdc) != 0) {
             ChatRoomUtil.showErrorBox("������������벻��");
             return false;
         }
         if (num.compareTo("") == 0) {
             ChatRoomUtil.showErrorBox("��Ų���Ϊ��");
             return false;
         }
         if (fName.compareTo("") == 0) {
             ChatRoomUtil.showErrorBox("������Ϊ��");
             return false;
         }
         if (lName.compareTo("") == 0) {
             ChatRoomUtil.showErrorBox("�ղ���Ϊ��");
             return false;
         }
         if (age.compareTo("") == 0) {
             ChatRoomUtil.showErrorBox("���䲻��Ϊ��");
             return false;
         }
         if (sex.compareTo("") == 0) {
             ChatRoomUtil.showErrorBox("�Ա���Ϊ��");
             return false;
         }
         if (regis(serverIP, serverPort, id, pwd, myServerPort)) {
             dispose();
         } else {
             ChatRoomUtil.showErrorBox("ע��ʧ�ܡ����û��Ѵ���");
             return false;
         }
         return true;
     }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object t = e.getSource();
         if (e.getSource().getClass() == JButton.class) {
             JButton button = (JButton) (t);
             if (button.getText().compareTo("�ύ") == 0) {
                 check();
             }
             if (button.getText().compareTo("ȡ��") == 0) {
                 dispose();
             }
        }
	}

}
