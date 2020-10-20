package kougi04;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Ex43 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ex43 frame = new Ex43();
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
	public Ex43() {
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

		JTextArea textArea_1 = new JTextArea();
		scrollPane.setRowHeaderView(textArea_1);

		JLabel label = new JLabel("学年");
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

						Statement stmt = con.createStatement();

						String sql = "select * from T_STUDENT";

						ResultSet rs = stmt.executeQuery(sql);

						String result = "";

						while(rs.next()) {
							result += rs.getInt("student_id") + ":";
							result += rs.getString("fullname") + '\n';
							}
							textArea.setText(result);

						rs.close();
						stmt.close();
						con.close();
					} catch (SQLException e1) {
						// TODO 自動生成された catch ブロック
						e1.printStackTrace();
					}
				}
		});
		button.setBounds(248, 36, 91, 21);
		contentPane.add(button);

	}
}
