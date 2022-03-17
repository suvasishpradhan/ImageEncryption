import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Main extends JFrame implements ActionListener{
    
	JButton b1;
	JTextArea t1;
	@Override
	public void actionPerformed(ActionEvent e) {
		String h=t1.getText();
		int j=Integer.parseInt(h);
		JFileChooser ch=new JFileChooser();
		ch.showOpenDialog(null);
		File n=ch.getSelectedFile();
		try {
			
			FileInputStream fis =new FileInputStream(n);
			byte arr[]=new byte[fis.available()];
			int i=0;
			for (byte b : arr) {
				System.out.println(b);
				arr[i]=(byte)(b^j);
				i++;
			}
			FileOutputStream fos=new FileOutputStream(n);
			fos.write(arr);
			fos.close();
			fis.close();
			JOptionPane.showMessageDialog(null, "Done");
		}
		catch(Exception ae)
		{
			ae.printStackTrace();
		}
		
	}
	
		public Main() {
		setLayout(null);
		setTitle("Image Encryption");
		setBounds(50,50,400,400);
		
		JLabel l1=new JLabel("Enter The Key");
		l1.setBounds(20, 20, 100, 50);
		add(l1);
		
		t1=new JTextArea();
		t1.setBounds(140, 30, 150, 30);
		t1.setBackground(Color.DARK_GRAY);
		t1.setForeground(Color.white);
		add(t1);
		
		b1=new JButton("ENCRYPT");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(100, 100, 100, 30);
		b1.addActionListener(this);
		add(b1);
		getContentPane().setBackground(Color.white);
		setVisible(true);
		}
	public static void main(String[] args) {
		
     new Main().setVisible(true);
	}

	

}
