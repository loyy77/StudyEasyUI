package loyy.action;

import java.util.ArrayList;
import java.util.List;

import loyy.dao.BaseDao;
import loyy.dao.BooksDao;
import loyy.entity.Books;

/**
 * @author LiShixi
 * 
 */
public class BookAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6796468542661715856L;
	Books book = null;
	BooksDao dao = new BooksDao();
	List<Books> bookList = new ArrayList<Books>();

	/**
	 * 删除book
	 * 
	 * @return
	 */
	public String delete() {
		if (dao.del(book.getBid())) {
			return list();
		}
		return SUCCESS;

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
			book=dao.get(book.getBid());
		}
		return "toEdit";

	}

	/**
	 * 编辑
	 * 
	 * @return
	 */
	public String edit() {
		dao.updata(book);
		return SUCCESS;

	}

	/**
	 * 添加
	 * 
	 * @return
	 */
	public String add() {
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
