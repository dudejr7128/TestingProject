package kr.or.nextit;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

public class MemberDAOTest {

	@Test
	public void testSelectMemberList() throws Exception {
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.selectMemberList();
		assertTrue(list.size() == 24);
		assertTrue(list.get(7).getMemId().equals("h001"));
	}

	@Test
	public void testSelectMember() throws Exception {
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.selectMember("p001");
		//assertTrue(vo.getMemName().equals("오성순"));
		assertThat(vo.getMemName(), is("오성순"));
	}

	@Test
	
	public void testInsertMember() throws Exception{
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		vo.setMemId("a002");
		vo.setMemPass("qwer");
		vo.setMemName("홍길동");
		vo.setMemReg01("960101");
		vo.setMemReg02("1234567");
		vo.setMemBir("960101");
		vo.setMemZip("30217");
		vo.setMemAdd1("대전광역시 중구");
		vo.setMemAdd2("희영빌딩");
		vo.setMemHometel("042-123-7897");
		vo.setMemComtel("042-466-1275");
		vo.setMemHp("010-4563-1223");
		vo.setMemMail("hong@hong.kr");
		dao.insertMember(vo);
		dao.selectMember("a002");
		assertThat(dao.selectMember(vo.getMemId()).getMemName(), is("홍길동"));
	}

	@Test
	public void testUpdateMember() throws Exception {
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		vo.setMemId("a002");
		vo.setMemPass("qwer");
		vo.setMemName("김영덕");
		vo.setMemReg01("960101");
		vo.setMemReg02("1234567");
		vo.setMemBir("960101");
		vo.setMemZip("30217");
		vo.setMemAdd1("대전광역시 중구");
		vo.setMemAdd2("희영빌딩");
		vo.setMemHometel("042-123-7897");
		vo.setMemComtel("042-466-1275");
		vo.setMemHp("010-4563-1223");
		vo.setMemMail("hong@hong.kr");
		dao.insertMember(vo);
		dao.selectMember("a002");
		assertThat(dao.selectMember(vo.getMemId()).getMemName(), is("김영덕"));

	}

	@Test
	public void testDeleteMember() {
		MemberDAO dao = new MemberDAO();
		dao.deleteMember("a002");
	}

}
