package kr.or.nextit.memo;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import org.junit.Test;

public class MemoDAOTest {

//	@Test
//	public void test() throws Exception {
//		MemoDAO dao = new MemoDAO();
//		List<memoVO> list = dao.selectMemoList();
//	assertThat(list.size(), is(1));
//	int size = list.size();
//	memoVO vo = new memoVO();
//	vo.setMemoContents("세번째 메모");
//	dao.insertMemo(vo);
//	List<memoVO> list2 = dao.selectMemoList();
//	assertThat(list2.size(), is(size +1));
//	
//	}
	@Test
	public void testUpdateMemo() throws Exception{
		MemoDAO dao = new MemoDAO();
		memoVO vo = new memoVO();
		vo.setMemoId(2);
		vo.setMemoContents("바뀐데이");
		dao.updateMemo(vo);
		//결과 테스트
	    memoVO memo =  dao.selectMemoVO((int) vo.getMemoId());
		assertThat(memo.getMemoContents(), is("바뀐데이"));
	}
	

}
