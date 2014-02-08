package loyy.entity;





public class Books {
	private int bid;
	private String bname;
	private int bTypeId;
	private int bComy;
	private String bComData;
	private String beg;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public int getbTypeId() {
		return bTypeId;
	}
	public void setbTypeId(int bTypeId) {
		this.bTypeId = bTypeId;
	}
	public int getbComy() {
		return bComy;
	}
	public void setbComy(int bComy) {
		this.bComy = bComy;
	}

	public String getBeg() {
		return beg;
	}
	public void setBeg(String beg) {
		this.beg = beg;
	}
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Books(int bid, String bname, int bTypeId, int bComy, String bComData,
			String beg) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.bTypeId = bTypeId;
		this.bComy = bComy;
		this.bComData = bComData;
		this.beg = beg;
	}
	
	public String getbComData() {
		return bComData;
	}
	public void setbComData(String bComData) {
		this.bComData = bComData;
	}
	@Override
	public String toString() {
		return "Books [bid=" + bid + ", bname=" + bname + ", bTypeId="
				+ bTypeId + ", bComy=" + bComy + ", bComData=" + bComData
				+ ", beg=" + beg + "]";
	}
	
}
