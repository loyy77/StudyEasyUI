package loyy.dao;

import java.util.List;

import loyy.entity.Books;

public class BooksDao {
	BaseDao baseDao = null;

	public BooksDao() {
		baseDao = BaseDao.getInstance();
	}

	public boolean add(Books b) {

		return baseDao.add(b);
	}

	public boolean del(int id) {

		return baseDao.delete(id);
	}

	public boolean updata(Books book) {

		return baseDao.update(book);
	}

	public List<Books> find() {

		return baseDao.find();
	}
	
	public Books get(int bid){
		return baseDao.get(bid);
	}

}
