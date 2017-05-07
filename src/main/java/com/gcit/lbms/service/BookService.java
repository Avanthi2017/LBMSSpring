package com.gcit.lbms.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.gcit.lbms.dao.BookDAO;
import com.gcit.lbms.entity.Book;
import com.gcit.lbms.exception.IllegalNameException;

public class BookService {
	@Autowired
	BookDAO bdao;

//	public Integer getBookCount() throws SQLException {
//		Connection conn = null;
//		try {
//			conn = util.getConnection();
//			BookDAO bdao = new BookDAO(conn);
//			return bdao.getBooksCount();
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if (conn != null)
//				conn.close();
//		}
//		return null;
//	}

	public Book readBookByPk(Integer bookId)  {
			try {
				return bdao.readBookById(bookId);
			} catch (ClassNotFoundException | IllegalNameException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}

	public List<Book> readAllBooks(Integer pageNo)  {
		try {
			return bdao.readAllBooks(pageNo);

		} catch (ClassNotFoundException | IllegalNameException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Book> readBookbyTitle(String name) {
		try {
			return bdao.readAllBooksByName(name);
		} catch (ClassNotFoundException | IllegalNameException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Transactional
	public int addBookWithID(Book book)  {
		int bookId = 0;
		try {
			bookId = bdao.addBookWithID(book);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return bookId;
	}

	@Transactional
	public void udpateBook(Book book) {
		try {
			bdao.updateBook(book);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Transactional
	public void deleteBook(int bookId)  {
		try {
			bdao.deleteBook(bookId);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
