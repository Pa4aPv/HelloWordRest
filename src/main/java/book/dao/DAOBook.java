package book.dao;

import java.util.List;

import book.model.Book;

public interface DAOBook {
	
	
	//create
	void add(Book book);

	//read
	List<Book> getAll();
	
	Book getById (int id);
	
	//update
	void update (Book book);
	
	//delete
	void remove (Book book);
}
