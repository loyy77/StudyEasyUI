package loyy.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import loyy.entity.Books;

public class BaseDao {

	static Map<Object, Object> db = new HashMap<Object, Object>();
	private static BaseDao baseDao=null;
	static {initDB();}
	private BaseDao() {
		super();
		initDB();

	}

	@SuppressWarnings("deprecation")
	public  static  void initDB() {
		for (int i = 0; i < 97; i++) {
			Books book = new Books();
			book.setBid(i);
			book.setbComData(new Date().toLocaleString());
			book.setbComy((i % 2 == 1) ? Comy.COMY1 : Comy.COMY2);
			book.setBeg("备注");
			book.setBname("书名" + i);
			book.setbTypeId((i % 2 == 1) ? BooksType.Computer
					: BooksType.Progamer);
			db.put(book.getBid(), book);
		}
	}
	
	public static BaseDao getInstance(){
		if(baseDao==null){
			baseDao=new BaseDao();
		}
		return baseDao;
	}

	/**
	 * 根据Id返回对象
	 * 
	 * @param i
	 * @return
	 */
	public Books get(int i) {
		return (Books) db.get(i);
	}

	/**
	 * 查找所有元素作为列表输出
	 * 
	 * @return
	 */
	public List<Books> find() {
		List<Books> list = new ArrayList<Books>();
		Iterator<Object> it = db.values().iterator();
		while (it.hasNext()) {
			list.add((Books) it.next());
		}
		return list;
	}

	/**
	 * 添加元素
	 * 
	 * @param book
	 * @return
	 */
	public boolean add(Books book) {
		int key=Math.abs(new Random().nextInt()*10);
		book.setBid(key);
		db.put(key, book);
		return (db.containsKey(key));
	}

	/**
	 * 删除元素
	 * 
	 * @param bid
	 * @return
	 */
	public boolean delete(int bid) {
		db.remove(bid);
		if (!db.containsKey(bid))
			return true;
		return false;
	}

	/**
	 * 更新图书
	 * 
	 * @param book
	 * @return
	 */
	public boolean update(Books book) {
	
		db.put(book.getBid(), book);
		if (db.containsKey(book.getBid()))
			return true;
		return false;
	}

	/**
	 * 打印出列表内容
	 * 
	 * @param list
	 */
	public void printList() {
		List<?> list = find();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public static void main(String[] args) {
		BaseDao dao = new BaseDao();
		System.out.println("原始列表");
		dao.printList();
		// 删除
		dao.delete(1);
		dao.delete(3);
		dao.delete(76);
		// 跟更新
		Books book = (Books) BaseDao.db.get(5);
		book.setBeg("我是一本神奇的书");
		dao.update(book);
		// 添加
		Books book1 = new Books();
		book1.setBid(Math.abs(new Random().nextInt()));
		book1.setBname("Java 编程思想");
		book1.setbComy(Comy.COMY1);
		book1.setbTypeId(BooksType.Computer);
		dao.add(book1);
		System.out.println("修改过的列表");
		// 列表
		dao.printList();

	}

}