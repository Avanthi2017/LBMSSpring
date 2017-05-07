package com.gcit.lbms.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcit.lbms.dao.BookCopiesDAO;
import com.gcit.lbms.dao.BranchDAO;
import com.gcit.lbms.entity.BookCopies;
import com.gcit.lbms.entity.Branch;
import com.gcit.lbms.exception.IllegalNameException;

public class BranchService {

	@Autowired
	BranchDAO bdao;
	@Autowired
	BookCopiesDAO bcdao;

	public List<Branch> readAllBranches(Integer pageNo) {
		try {
			return bdao.readAllBranchs(pageNo);

		} catch (ClassNotFoundException | SQLException | IllegalNameException e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<Branch> readAllBranches() {
		try {
			return bdao.readAllBranchs();

		} catch (ClassNotFoundException | SQLException | IllegalNameException e) {
			e.printStackTrace();
		}
		return null;

	}

	// public Integer getBranchCount() throws SQLException {
	// Connection conn = null;
	// try {
	// conn = util.getConnection();
	// BranchDAO bdao = new BranchDAO(conn);
	// return bdao.getBranchCount();
	// } catch (ClassNotFoundException | SQLException e) {
	// e.printStackTrace();
	// } finally {
	// if (conn != null)
	// conn.close();
	// }
	// return null;
	// }
	public List<Branch> readBranchs(String branchName) {
		try {
			return bdao.readAllBranchesByName(branchName);

		} catch (ClassNotFoundException | SQLException | IllegalNameException e) {
			e.printStackTrace();
		}
		return null;

	}

	public Branch readBranchById(Integer branchId) {
		try {
			return bdao.readBranchById(branchId);
		} catch (ClassNotFoundException | SQLException | IllegalNameException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addBranch(Branch branch) {

		try {
			bdao.addBranch(branch);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateBranch(Branch branch) {

		try {
			bdao.updateBranch(branch);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteBranch(Branch branch) {

		try {
			bdao.deleteBranch(branch);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void addBookCopies(BookCopies bookcopies) {

		try {
			bcdao.addBookCopies(bookcopies);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateBookCopies(BookCopies bookcopies) {
		try {
			bcdao.updateBookCopies(bookcopies);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<BookCopies> readAllBookCopies() {
		try {
			return bcdao.readAllBookCopies();
		} catch (ClassNotFoundException | SQLException | IllegalNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void deleteBookCopies(BookCopies bookcopies) {
		try {
			bcdao.deleteBookCopies(bookcopies);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<BookCopies> readBookCopiesbyBookId(int bookId) {
		try {
			return bcdao.readAllBookCopiesByBookId(bookId);
		} catch (ClassNotFoundException | SQLException | IllegalNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public List<BookCopies> readBookCopiesByBranchId(int branchId) {
		try {
			return bcdao.readAllBookCopiesByBranchId(branchId);
		} catch (ClassNotFoundException | SQLException | IllegalNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public int readBookCopiesByBookIdAndBranchId(int bookId, int branchId) {
		try {
			return bcdao.readBookCopiesByBranchIdAndBookId(bookId, branchId);
		} catch (ClassNotFoundException | SQLException | IllegalNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

}
