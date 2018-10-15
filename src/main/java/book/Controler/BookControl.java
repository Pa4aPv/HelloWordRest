package book.Controler;



import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import book.model.Book;
import book.service.BookService;

@Path("/book")

@Stateless
public class BookControl {
	
		@Inject
	    private BookService bookService;
		
		@PersistenceContext
		private EntityManager em;
		
		@GET
		@Path("/helBooks")
		public String sayHello ()
		{
		//	em.persist( new Book("Hello Word"));
			return "Hello book";
		}
		
		@GET
		@Path ("/getBooksString/{name}")
		public Response getBooksString(@PathParam("name") String name) {
			
		/*	String param = name;
		em.createNamedQuery(massage, null);*/
			
			List<Book> allBooks= bookService.getAllBook();
			String responseBody = allBooks.stream().map(Book::getName).collect(Collectors.joining("\n"));

	        return Response.ok(responseBody).build();
	}
		
		@GET
		@Path ("/getBooksJson/{name}")
		@Produces(value = MediaType.APPLICATION_JSON)
		
		public Response getMessageJson(@PathParam("name") String name) {			
			List<Book> allBooks= bookService.getAllBook();
			List<Book> responseBody = allBooks.stream().collect(Collectors.toList());
	        return Response.ok(responseBody).build();
	}

}
