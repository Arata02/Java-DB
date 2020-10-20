package kougi01;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Ex13 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex13 frame = new Ex13();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ex13() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton button = new JButton("ファイル選択");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			JFileChooser fc = new JFileChooser();

			int selected = fc.showOpenDialog(contentPane);

			if(selected == JFileChooser.APPROVE_OPTION) {
				File f1 = fc.getSelectedFile();

				String fileName = f1.getName();
				System.out.println("ファイル名:" + fileName);
				System.out.println("絶対パス: " + f1.getAbsolutePath());
				System.out.println("サイズ: " + f1.length() + "バイト");
			}

			}
		});
		button.setBounds(173, 115, 91, 21);
		contentPane.add(button);
	}
}
