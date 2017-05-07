package com.gcit.lbms.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcit.lbms.dao.BorrowerDAO;
import com.gcit.lbms.entity.Borrower;
import com.gcit.lbms.exception.IllegalNameException;

public class BorrowerService {
	@Autowired
	BorrowerDAO bdao;

	public List<Borrower> readAllBorrowers(Integer pageNo) {
		try {
			return bdao.readAllBorrowers(pageNo);

		} catch (ClassNotFoundException | SQLException | IllegalNameException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Borrower> readBorrowers(String borrowerName) {
		try {
			return bdao.readAllBorrowersbyName(borrowerName);

		} catch (ClassNotFoundException | SQLException | IllegalNameException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Borrower readBorrowerByCardNo(int cardNo) {
		try {
			return bdao.readBorrowerByCardNo(cardNo);
		} catch (ClassNotFoundException | SQLException | IllegalNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	// public Integer getBorrowerCount() {
	// try {
	// return bdao.getBorrowerCount();
	// } catch (ClassNotFoundException | SQLException e) {
	// e.printStackTrace();
	// } finally {
	// if (conn != null)
	// conn.close();
	// }
	// return null;
	// }

	public void addBorrower(Borrower borrower) {
		try {
			bdao.addBorrower(borrower);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateBorrower(Borrower borrower) {
		try {
			bdao.updateBorrower(borrower);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteBorrower(Borrower borrower) {
		try {
			bdao.deleteBorrower(borrower);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
