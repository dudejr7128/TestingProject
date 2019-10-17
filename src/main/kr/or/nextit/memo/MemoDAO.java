package kr.or.nextit.memo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.or.nextit.MemberVO;

public class MemoDAO {
	
	public List<memoVO> selectMemoList() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "java", "oracle");
		PreparedStatement statement = connection.prepareStatement("select * from memo");
		ResultSet resultSet = statement.executeQuery();
		
		List<memoVO> list = new ArrayList<memoVO>();
		while (resultSet.next()) {
			long memoId = resultSet.getLong("MEMO_ID");
			String memoContents = resultSet.getString("MEMO_CONTENTS");
			Date memoCreateDate = resultSet.getDate("MEMO_CREATE_DATE");
			Date memoModifyDate = resultSet.getDate("MEMO_MODIFY_DATE");
			list.add(new memoVO(memoId,memoContents,memoCreateDate,memoModifyDate));
		}
		resultSet.close();
		statement.close();
		connection.close();
		return list;
	}
	
	public memoVO selectMemoVO(int id) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "java", "oracle");
		PreparedStatement statement = connection.prepareStatement("select * from memo where memo_id = ?");
		statement.setInt(1, id);
		
		memoVO vo = null;
		ResultSet resultSet = statement.executeQuery();
		
		while (resultSet.next()) {
			long memoId = resultSet.getLong("MEMO_ID");
			String memoContents = resultSet.getString("MEMO_CONTENTS");
			Date memoCreateDate = resultSet.getDate("MEMO_CREATE_DATE");
			Date memoModifyDate = resultSet.getDate("MEMO_MODIFY_DATE");
			vo = new memoVO(memoId,memoContents,memoCreateDate,memoModifyDate);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return vo;

	}
	public int insertMemo(memoVO vo) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "java", "oracle");
		PreparedStatement statement = connection.prepareStatement("INSERT INTO MEMO(memo_id,MEMO_CONTENTS) VALUES ( SEQ_MEMO.nextval, ?");
		statement.setString(1, vo.getMemoContents());
		
		int update = statement.executeUpdate();
	
		statement.close();
		connection.close();
		return update;
	}
	public int updateMemo(memoVO vo) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "java", "oracle");
		PreparedStatement statement = connection.prepareStatement("UPDATE MEMO SET MEMO_CONTENTS = ?, MEMO_MODIFY_DATE  = SYSDATE WHERE MEMO_ID =?");
		statement.setString(1, vo.getMemoContents());
		statement.setLong(2, vo.getMemoId());
		int update = statement.executeUpdate();
	
		statement.close();
		connection.close();
		return update;

	}
	public int deleteMemo(int id) throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "java", "oracle");
		PreparedStatement statement = connection.prepareStatement("DELETE FROM MEMO WHERE MEMO_ID = ?; ");
		statement.setLong(1, id);
		int update = statement.executeUpdate();
	
		statement.close();
		connection.close();
		return update;

	}

}
