package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1"; //����Ŭ ���� ����
		String sql = "SELECT * FROM NOTICE"; //sql
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); //�޸𸮿� ����̹��� �ö�
		Connection con = DriverManager.getConnection(url,"TEST_USER", "1234"); //db ����/��������, id, pwd
		Statement st = con.createStatement(); //������ ����
		ResultSet rs = st.executeQuery(sql); //Ŀ���� ������ �� �ִ� ����
		
		if(rs.next()) { //�����͸� ���� ���� ���ڵ� ������ �� �پ� ����
			String title = rs.getString("title"); //title �̶�� �÷��� �����͸� ����
			System.out.println(title);
		}
		
		rs.close();
		st.close();
		con.close();

	}

}
