package com.gcit.lbms.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.gcit.lbms.dao.BookGenreDAO;
import com.gcit.lbms.dao.GenreDAO;
import com.gcit.lbms.entity.Genre;
import com.gcit.lbms.exception.IllegalNameException;

public class GenreService {
	@Autowired
	GenreDAO genredao;
	@Autowired
	BookGenreDAO bookGenredao;

	public Genre readGenreById(Integer genreId)  {
		try {
			return genredao.readGenreById(genreId);
		} catch (ClassNotFoundException | IllegalNameException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Genre> readGenreByName(String genreName)  {
		try {
			return genredao.readBooksByGenreName(genreName);
		} catch (ClassNotFoundException | IllegalNameException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Genre> readAllGenres(Integer pageNo)  {
		try {
			return genredao.readAllGenres(pageNo);
		} catch (ClassNotFoundException | IllegalNameException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public List<Genre> readAllGenres()  {
		try {
			return genredao.readAllGenres();
		} catch (ClassNotFoundException | IllegalNameException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Transactional
	public void addgenre(Genre genre)  {
		try {
			genredao.addGenre(genre);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Transactional
	public void updateGenre(Genre genre)  {
		try {
			genredao.updateGenre(genre);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Transactional
	public void deleteGenre(Genre genre)  {
		try {
			genredao.deleteGenre(genre);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// public Integer getGenreCount(){
	// Connection conn = null;
	// try {
	// conn = util.getConnection();
	// GenreDAO gdao = new GenreDAO(conn);
	// return gdao.getGenreCount();
	// } catch (ClassNotFoundException | SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return null;
	//
	// }
	@Transactional
	public void addBookGenre(int genre_id, int bookId)  {
		try {
			bookGenredao.addBookGenre(genre_id, bookId);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Transactional
	public void deleteBookGenre(int genre_id, int bookId)  {
		try {
			bookGenredao.deleteBookGenre(genre_id, bookId);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Transactional
	public void deleteBookGenreByBookId(int bookId)  {
		try {
			bookGenredao.deleteBookGenreByBookId(bookId);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Integer> readBookGenreByBookId(int bookId)  {
		try {
			return bookGenredao.readBookGenrebybookId(bookId);
		} catch (ClassNotFoundException | IllegalNameException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
