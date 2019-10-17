package kr.or.nextit.memo;

import java.util.Date;

public class memoVO {

	private long memoId;
	private String memoContents;
	private Date memoCreateDate;
	private Date memoModifyDate;

	public memoVO() {

	}
	
	public memoVO(long memoId, String memoContents, Date memoCreateDate, Date memoModifyDate) {

		this.memoId = memoId;
		this.memoContents = memoContents;
		this.memoCreateDate = memoCreateDate;
		this.memoModifyDate = memoModifyDate;
	}

	public long getMemoId() {
		return memoId;
	}

	public void setMemoId(long memId) {
		this.memoId = memId;
	}

	public String getMemoContents() {
		return memoContents;
	}

	public void setMemoContents(String memoContents) {
		this.memoContents = memoContents;
	}

	public Date getMemoCreateDate() {
		return memoCreateDate;
	}

	public void setMemoCreateDate(Date memoCreateDate) {
		this.memoCreateDate = memoCreateDate;
	}

	public Date getMemoModifyDate() {
		return memoModifyDate;
	}

	public void setMemoModifyDate(Date memoModifyDate) {
		this.memoModifyDate = memoModifyDate;
	}

	@Override
	public String toString() {
		return "memoVO [memoId=" + memoId + ", memoContents=" + memoContents + ", memoCreateDate=" + memoCreateDate
				+ ", memoModifyDate=" + memoModifyDate + "]";
	}

}
