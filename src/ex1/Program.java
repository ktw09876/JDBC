package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1"; //오라클 접속 정보
		String sql = "SELECT * FROM NOTICE"; //sql
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); //메모리에 드라이버가 올라감
		Connection con = DriverManager.getConnection(url,"TEST_USER", "1234"); //db 연결/접속정보, id, pwd
		Statement st = con.createStatement(); //쿼리를 실행
		ResultSet rs = st.executeQuery(sql); //커서를 움직일 수 있는 도구
		
		if(rs.next()) { //데이터를 꺼낼 때는 레코드 단위로 한 줄씩 꺼냄
			String title = rs.getString("title"); //title 이라는 컬럼의 데이터를 대입
			System.out.println(title);
		}
		
		rs.close();
		st.close();
		con.close();

	}

}
