package kr.or.nextit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleDriver;

public class MemberDAO {
	public List<MemberVO> selectMemberList() throws Exception {
		// 1. DB 드라이버 로딩을 한다.
		// 2. DB 연결을 한다.
		// 3. 쿼리를 만든다.
		// 4. 쿼리를 전송한다.
		// 5. 결과를 받는다.
		// 6. 자원을 반납한다.

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "java", "oracle");
		PreparedStatement statement = connection.prepareStatement("select * from member");
		ResultSet resultSet = statement.executeQuery();
		List<MemberVO> list = new ArrayList<MemberVO>();
		while (resultSet.next()) {
			String memId = resultSet.getString("mem_id");
			String memName = resultSet.getString("mem_name");
			String memHp = resultSet.getString("mem_hp");
			String memMail = resultSet.getString("mem_mail");
			list.add(new MemberVO(memId,memName,memHp,memMail));
		}
		resultSet.close();
		statement.close();
		connection.close();
		return list;
	}

	public MemberVO selectMember(String id) throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "java", "oracle");
		PreparedStatement statement = connection.prepareStatement("select * from member where mem_id = ?");
		statement.setString(1, id);
		ResultSet resultSet = statement.executeQuery();
		
		MemberVO vo =null;
		while (resultSet.next()) {
			String memId = resultSet.getString("mem_id");
			String memName = resultSet.getString("mem_name");
			String memHp = resultSet.getString("mem_hp");
			String memMail = resultSet.getString("mem_mail");
		vo = new MemberVO(memId,memName,memHp,memMail);
		}
		resultSet.close();
		statement.close();
		connection.close();

		return vo;
	}
	public void insertMember(MemberVO vo) throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "java", "oracle");
		String sql = "insert into member (MEM_ID,MEM_PASS,MEM_NAME,MEM_REGNO1,MEM_REGNO2,MEM_BIR,MEM_ZIP,MEM_ADD1,MEM_ADD2,MEM_HOMETEL,MEM_COMTEL,MEM_HP,MEM_MAIL) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getMemId());
		statement.setString(2, vo.getMemPass());
		statement.setString(3, vo.getMemName());
		statement.setString(4, vo.getMemReg01());
		statement.setString(5, vo.getMemReg02());
		statement.setString(6, vo.getMemBir());
		statement.setString(7, vo.getMemZip());
		statement.setString(8, vo.getMemAdd1());
		statement.setString(9, vo.getMemAdd2());
		statement.setString(10, vo.getMemHometel());
		statement.setString(11, vo.getMemComtel());
		statement.setString(12, vo.getMemHp());
		statement.setString(13, vo.getMemMail());
		statement.executeUpdate();
		statement.close();
		connection.close();


	}

	public void updateMember(MemberVO vo) {

	}

	public void deleteMember(String id) {

	}
}











