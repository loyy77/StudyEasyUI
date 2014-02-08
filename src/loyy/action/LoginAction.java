package loyy.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import loyy.dao.BooksDao;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;

/**
 * @author LiShixi
 * 
 */
public class LoginAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3455149688163281560L;
	Logger log = Logger.getLogger(LoginAction.class);
	BooksDao dao = new BooksDao();
	List<?> bookList = dao.find();
	Map<String, Object> book = new HashMap<String, Object>();
	String test = "";

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public List<?> getBookList() {
		return bookList;
	}

	public void setBookList(List<?> bookList) {
		this.bookList = bookList;
	}

	String username;
	String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String input() {
		System.out.println("input.....");
		return INPUT;
	}

	public String execute() {
		log.info("login begin....");
		log.info(this);
		// 登录次数计时器
		ActionContext ctx = ActionContext.getContext();
		Integer count = (Integer) ctx.getApplication().get("count");
		if (count == null) {
			count = 0;
		} else {
			count = count + 1;
		}
		ctx.getApplication().put("count", count);

		System.out.println("登录次数：" + ctx.getApplication().get("count"));

		// 登录操作
		if (!login(username, password)) {
			log.debug("登录失败");
			return INPUT;
		}
		// 测试

		Map<String, String> author = new HashMap<String, String>();
		author.put("info", "Biologist,1924-1985,Canada");
		author.put("name", "Julia Smith");
		book.put("author", author);
		book.put("title", "Breeding green mouses");
		// test end.

		log.info("login success!");
		return SUCCESS;
	}

	public Map<String, Object> getBook() {
		return book;
	}

	public void setBook(Map<String, Object> book) {
		this.book = book;
	}

	/**
	 * 验证用户名和密码
	 */
	public boolean login(String username, String pwd) {
		return (username.equals("lsx") && pwd.equals("123"));
	}

	@Override
	public String toString() {
		return "Login [log=" + log + ", username=" + username + ", password="
				+ password + "]";
	}

}
