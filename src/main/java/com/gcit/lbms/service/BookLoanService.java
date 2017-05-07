package com.gcit.lbms.service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcit.lbms.dao.BookLoansDAO;
import com.gcit.lbms.entity.BookLoan;
import com.gcit.lbms.exception.IllegalNameException;

public class BookLoanService {
	@Autowired
	BookLoansDAO bldao;

	public List<BookLoan> readAllBookLoans() {
		try {
			return bldao.readAllBookLoans();

		} catch (ClassNotFoundException | SQLException | IllegalNameException e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<BookLoan> readbookloansbyCardNo(int cardNo) {
		try {
			return bldao.readLoansByCardNo(cardNo);
		} catch (ClassNotFoundException | SQLException | IllegalNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<BookLoan> readActiveBookLoansbyCardNo(int cardNo) {
		try {
			return bldao.readActiveBookLoansbyCardNo(cardNo);
		} catch (ClassNotFoundException | SQLException | IllegalNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<BookLoan> readActiveBookLoansbyBookId(int bookId) {
		try {
			return bldao.readActiveBookLoansbyBookId(bookId);
		} catch (ClassNotFoundException | SQLException | IllegalNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<BookLoan> readBookLoansbyCardNoAndBranchId(int cardNo, int branchId) {
		try {
			return bldao.readLoansByCardNoAndBranchId(cardNo, branchId);
		} catch (ClassNotFoundException | SQLException | IllegalNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<BookLoan> readBookLoansbyBookIdAndBranchId(int bookId, int branchId) {
		try {
			return bldao.readBookLoansbyBookIdAndBranchId(bookId, branchId);
		} catch (ClassNotFoundException | SQLException | IllegalNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public BookLoan readBookLoansbyIds(int cardNo, int branchId, int bookId) {
		try {
			return bldao.readBookLoanByIds(cardNo, branchId, bookId);
		} catch (ClassNotFoundException | SQLException | IllegalNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void addBookLoan(BookLoan bookloan) {

		DateTimeFormatter ft = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		LocalDateTime date = LocalDateTime.now();
		// bookloan.get
		bookloan.setDateOut(date.format(ft));
		bookloan.setDueDate(date.plusDays(7).format(ft));

		try {
			bldao.bookCheckOut(bookloan);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		}

	}

	public void updateBookLoan(BookLoan bookloan) {
		DateTimeFormatter ft = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		LocalDateTime date = LocalDateTime.now();
		// bookloan.get
		bookloan.setDateIn(date.format(ft));
		try {
			bldao.bookCheckIn(bookloan);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void overWriteDueDate(BookLoan bookloan) {
		try {
			bldao.overrideDueDate(bookloan);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
