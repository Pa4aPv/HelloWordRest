package book.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import book.model.Book;

@Stateless
public class DAOBookImp implements DAOBook{
	@PersistenceContext
	private EntityManager em;

	@Override
	public void add(Book book) {
		em.persist(book);
		
	}

	@Override
	public List<Book> getAll() {
	
	return em.createQuery("Select t from " + Book.class.getSimpleName() + " t", Book.class).getResultList();
	}

	@Override
	public Book getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Book book) {
		// TODO Auto-generated method stub
		
	}

}
