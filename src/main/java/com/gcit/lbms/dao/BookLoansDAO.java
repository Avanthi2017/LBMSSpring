package com.gcit.lbms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.gcit.lbms.entity.BookLoan;
import com.gcit.lbms.exception.IllegalNameException;

public class BookLoansDAO extends BaseDAO implements ResultSetExtractor<List<BookLoan>>{
	LocalDateTime date;
	DateTimeFormatter ft = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

	public void bookCheckOut(BookLoan bookloans) throws SQLException, ClassNotFoundException {
		template.update("insert into  tbl_book_loans (tbl_book_loans.bookId,tbl_book_loans.branchId,tbl_book_loans.cardNo,tbl_book_loans.dateOut,tbl_book_loans.dueDate)values(?,?,?,?,?)",
				new Object[] { bookloans.getBookId(), bookloans.getBranchId(), bookloans.getCardNo(),
						bookloans.getDateOut(), bookloans.getDueDate()});
	}

	public void bookCheckIn(BookLoan bookloans) throws SQLException, ClassNotFoundException {
		template.update("update  tbl_book_loans set tbl_book_loans.dateIn=? "
				+ " where( (tbl_book_loans.bookId=?) and(tbl_book_loans.branchId=?)and(tbl_book_loans.cardNo=?))",
				new Object[] { bookloans.getDateIn(),bookloans.getBookId(),bookloans.getBranchId(),bookloans.getCardNo()});
	}
	public void overrideDueDate(BookLoan bookloans) throws SQLException, ClassNotFoundException {
		template.update("update  tbl_book_loans set tbl_book_loans.dueDate=? "
				+ " where( (tbl_book_loans.bookId=?) and(tbl_book_loans.branchId=?)and(tbl_book_loans.cardNo=?))",
				new Object[] { bookloans.getDueDate(), bookloans.getBookId(),bookloans.getBranchId(),bookloans.getCardNo()});
	}
	public List<BookLoan> readLoansByCardNo(Integer cardNo) throws ClassNotFoundException, SQLException, IllegalNameException{
		return template.query("select * from tbl_book_loans where cardNo = ?", new Object[]{cardNo},this);
		
		
	}
	public List<BookLoan> readActiveBookLoansbyCardNo(Integer cardNo) throws ClassNotFoundException, SQLException, IllegalNameException{
		return template.query("select * from tbl_book_loans where cardNo = ? and dateIn is null", new Object[]{cardNo},this);
		
	}
	public List<BookLoan> readActiveBookLoansbyBookId(Integer bookId) throws ClassNotFoundException, SQLException, IllegalNameException{
		return template.query("select * from tbl_book_loans where bookId = ? and dateIn is null", new Object[]{bookId},this);
		
	}
	public List<BookLoan> readLoansByCardNoAndBranchId(Integer cardNo,Integer branchId) throws ClassNotFoundException, SQLException, IllegalNameException{
		return template.query("select * from tbl_book_loans where cardNo=? and branchId=? and dateIn is null", new Object[]{cardNo,branchId},this);
		
	}
	public BookLoan readBookLoanByIds(Integer cardNo,Integer branchId,Integer bookId) throws ClassNotFoundException, SQLException, IllegalNameException{
		return (BookLoan) template.query("select * from tbl_book_loans where cardNo=? and branchId=? and bookId=? and dateIn is null", new Object[]{cardNo,branchId,bookId},this).get(0);
		
	}
	public List<BookLoan> readBookLoansbyBookIdAndBranchId(Integer bookId,Integer branchId) throws ClassNotFoundException, SQLException, IllegalNameException{
		return template.query("select * from tbl_book_loans where bookId=? and branchId=? and dateIn is null", new Object[]{bookId,branchId},this);
		
	}
	public List<BookLoan> readAllBookLoans() throws ClassNotFoundException, SQLException, IllegalNameException{
		return template.query("SELECT * FROM tbl_book_loans", this);
	}
	public void deleteBookLoans(BookLoan bookloans) throws SQLException, ClassNotFoundException {
template.update("delete * from tbl_book_loans where cardNo=?", new Object[] { bookloans.getCardNo() });
	}


	@Override
	public  List<BookLoan> extractData(ResultSet rs) throws SQLException {
		List<BookLoan> bookloans= new ArrayList<>();
		while(rs.next()){
			BookLoan b= new BookLoan();
			b.setDateIn(rs.getString("dateIn"));
			b.setDateOut(rs.getString("dateOut"));
			b.setDueDate(rs.getString("dueDate"));
			b.setBookId(rs.getInt("bookId"));
			b.setBranchId(rs.getInt("branchId"));
			b.setCardNo(rs.getInt("cardNo"));
			bookloans.add(b);
			
		}
		return bookloans;
	}

}
