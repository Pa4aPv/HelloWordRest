package book.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

import book.dao.DAOBook;
import book.model.Book;

@Stateless
public class BookService  {
	
	@Inject
	DAOBook daoBook;
	
	
	    @Transactional
	public void createBook(@NotNull String nameBook) {
		Book newBook = new Book();
		newBook.setName(nameBook);
		daoBook.add(newBook);
		}
	
	 @NotNull
	    @Transactional
	
	public List<Book> getAllBook () {
		return daoBook.getAll(); 
		
	}
}
