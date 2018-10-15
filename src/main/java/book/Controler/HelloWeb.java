package book.Controler;
  
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import book.model.Book;



@Path("/hello")
@Stateless
public class HelloWeb {
	@PersistenceContext
	private EntityManager em;
	
	@GET
	@Path("/")
	public String sayHello ()
	{
	//	em.persist( new Book("Hello Word"));
		return "Hello World";
	}
	
	@GET
	@Path ("/{message}")
	public String sayMessage(@PathParam("message") String massage) {
	//	em.createNamedQuery(massage, null);
	
		em.persist( new Book(massage));
		return massage;
		
	}
	

}
