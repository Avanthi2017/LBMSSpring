package com.gcit.lbms.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.gcit.lbms.dao.AuthorDAO;
import com.gcit.lbms.dao.BookAuthorDAO;
import com.gcit.lbms.dao.BookDAO;
import com.gcit.lbms.entity.Author;
import com.gcit.lbms.exception.IllegalNameException;

public class AuthorService {
	@Autowired
	AuthorDAO adao;
	@Autowired
	BookAuthorDAO badao;
	@Autowired
	BookDAO bdao;

	public Author readAuthorById(Integer authorId) {
		try {
			return adao.readAuthorById(authorId);
		} catch (ClassNotFoundException | IllegalNameException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Author> readAllAuthors(Integer pageNo)  {
		List<Author>authors= new ArrayList<>();
				
		try {
			authors= adao.readAllAuthors(pageNo);
			for(Author a:authors){
					a.setBooks(bdao.readAllBooksByAuthorID(a.getAuthorId()));
				}
			return authors;
		} catch (ClassNotFoundException | SQLException | IllegalNameException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Author> readAllAuthors() {
		List<Author>authors= new ArrayList<>();
		try {
			authors= adao.readAllAuthors();
			for(Author a:authors){
				a.setBooks(bdao.readAllBooksByAuthorID(a.getAuthorId()));
			}
			return authors;
		} catch (ClassNotFoundException | IllegalNameException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public List<Author> readAuthorsByName(Integer pageNo, String authorName) {
		try {
			return adao.readAllAuthorsByName(authorName);
		} catch (ClassNotFoundException | IllegalNameException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// public Integer getAuthoursCount() throws SQLException{
	// Connection conn = null;
	// try {
	// conn = util.getConnection();
	// AuthorDAO adao = new AuthorDAO(conn);
	// return adao.getAuthorsCount();
	// } catch (ClassNotFoundException | SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }finally{
	// if(conn!=null){
	// conn.close();
	// }
	// }
	//
	// return null;
	//
	//
	// }
	@Transactional
	public void addAuthor(Author author)  {
		try {
			adao.addAuthor(author);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Transactional
	public void udpateAuthor(Author author)  {
		try {
			adao.updateAuthor(author);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Transactional
	public void deleteAuthor(Author author) {
		try {
			adao.deleteAuthor(author);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Transactional
	public void addBookAuthours(int bookId, int authorId)  {
		try {
			badao.addBookAuthors(bookId, authorId);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Transactional
	public void deleteBookAuthour(int authorId, int bookId) {
		try {
			badao.deleteBookAuthors(authorId, bookId);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Transactional
	public void deleteBookAuthorsByBookId(int bookId)  {
		try {
			badao.deleteBookAuthorsByBookId(bookId);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Integer> readBookAuthorByBookId(int bookId)  {
		try {
			return badao.readBookAuthorsbybookId(bookId);
		} catch (ClassNotFoundException | IllegalNameException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
