package loyy.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import loyy.dao.BaseDao;
import loyy.dao.BooksDao;
import loyy.entity.Books;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

/**
 * @author LiShixi
 * 
 */
public class BookAJAXAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6796468542661715856L;
	Logger log = Logger.getLogger(BookAJAXAction.class);
	Books book = null;
	BooksDao dao = new BooksDao();
	List<Books> bookList = new ArrayList<Books>();
	String result = "";
	String bookIds;
	String failIds = "";
	
	String bname;
	String beg;
	String bComData;
	int bComy;
	int bTypeId;

	
	
	public String getFailIds() {
		return failIds;
	}

	public void setFailIds(String failIds) {
		this.failIds = failIds;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBeg() {
		return beg;
	}

	public void setBeg(String beg) {
		this.beg = beg;
	}

	public String getbComData() {
		return bComData;
	}

	public void setbComData(String bComData) {
		this.bComData = bComData;
	}

	

	public int getbComy() {
		return bComy;
	}

	public void setbComy(int bComy) {
		this.bComy = bComy;
	}

	public int getbTypeId() {
		return bTypeId;
	}

	public void setbTypeId(int bTypeId) {
		this.bTypeId = bTypeId;
	}

	public String getBookIds() {
		return bookIds;
	}

	public void setBookIds(String bookIds) {
		this.bookIds = bookIds;
	}

	/**
	 * 删除book
	 * 
	 * @return
	 */
	public String delete() {
		System.out.println("bookIds:" + bookIds);
		String[] bookIds = this.bookIds.split(",");

		if (bookIds.length > 1) {
			for (int i = 0; i < bookIds.length; i++) {
				if (!dao.del(Integer.valueOf(bookIds[i]))) {
					failIds += bookIds[i] + ",";
				}
			}
		} else {
			int bid = -1;
			if (book == null) {
				if (bookIds != null) {
					bid = Integer.valueOf(this.bookIds);
				}
			} else {
				bid = book.getBid();
			}

			dao.del(bid);
			
		}
		return SUCCESS;

	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * 列表
	 * 
	 * @return
	 */
	public String list() {
		bookList = dao.find();
		return SUCCESS;

	}

	/**
	 * 转到 编辑页面
	 * 
	 * @return
	 */
	public String toEdit() {
		if (book != null) {
			book = dao.get(book.getBid());
		}
		return "toEdit";

	}

	/**
	 * 编辑
	 * 
	 * @return
	 */
	public String edit() {
		HttpServletRequest request=	ServletActionContext.getRequest();
		try {
			ServletActionContext.getRequest().setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		book.setbComData(request.getParameter("bComData"));
		book.setbComy(Integer.valueOf(request.getParameter("bComy")));
		book.setBeg(request.getParameter("beg"));
		book.setBname(request.getParameter("bname"));
		book.setbTypeId(Integer.valueOf(request.getParameter("bTypeId")));
		dao.updata(book);
		result="ok";
		return SUCCESS;

	}

	/**
	 * 添加
	 * 
	 * @return
	 */
	public String add() {
		HttpServletRequest request=	ServletActionContext.getRequest();
		book=new Books();
		book.setbComData(request.getParameter("bComData"));
		book.setbComy(Integer.valueOf(request.getParameter("bComy")));
		book.setBeg(request.getParameter("beg"));
		book.setBname(request.getParameter("bname"));
		book.setbTypeId(Integer.valueOf(request.getParameter("bTypeId")));
		dao.add(book);
		result="ok";
		return SUCCESS;
	}

	/**
	 * 转到添加页面
	 * 
	 * @return
	 */
	public String toAdd() {
		return "toAdd";
	}

	public String initdb() {

		BaseDao.initDB();
		return list();
	}

	public Books getBook() {
		return book;
	}

	public void setBook(Books book) {
		this.book = book;
	}

	public List<Books> getBookList() {
		return bookList;
	}

	public void setBookList(List<Books> bookList) {
		this.bookList = bookList;
	}

}
