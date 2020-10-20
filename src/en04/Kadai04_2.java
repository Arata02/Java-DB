package en04;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Kadai04_2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kadai04_2 frame = new Kadai04_2();
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
	public Kadai04_2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 90, 410, 161);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setText("");
		scrollPane.setViewportView(textArea);

		JLabel label = new JLabel("学部");
		label.setBounds(12, 40, 50, 13);
		contentPane.add(label);

		textField = new JTextField();
		textField.setBounds(45, 37, 119, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton button = new JButton("検索");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					try {
						String driverUrl = "jdbc:derby:C:\\Users\\Kaiki\\Documents\\JavaDB\\meibo;create=false";

						Connection con
								= DriverManager.getConnection(driverUrl, "db", "db");


						String sql = "select * from T_STUDENT where gakubu_id=?";

						PreparedStatement ps = con.prepareStatement(sql);

						ps.setInt(1, Integer.parseInt(textField.getText()));

						ResultSet rs = ps.executeQuery();

						String result = "";

						while(rs.next()) {
							result += rs.getInt("student_id") + ",";
							result += rs.getString("fullname") + ",";
							result += rs.getString("gakubu_id") + ",";
							result += rs.getString("grade") + ",";
							result += rs.getString("score") + "\n";
							}
							textArea.setText(result);

						rs.close();
						ps.close();
						con.close();
					} catch (Exception e1) {
						// TODO 自動生成された catch ブロック
						textArea.setText(e1.getMessage());
						e1.printStackTrace();
					}
				}
		});
		button.setBounds(248, 36, 91, 21);
		contentPane.add(button);

	}

}
