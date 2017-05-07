package com.gcit.lbms.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.gcit.lbms.dao.PublisherDAO;
import com.gcit.lbms.entity.Publisher;
import com.gcit.lbms.exception.IllegalNameException;

public class PublisherService {
	@Autowired
	PublisherDAO pdao;

	public List<Publisher> readAllPublishers(Integer PageNo) {
		try {
			return pdao.readAllPublisher(PageNo);
		} catch (ClassNotFoundException | IllegalNameException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public List<Publisher> readAllPublishers()  {
		try {
			return pdao.readAllPublisher();
		} catch (ClassNotFoundException | IllegalNameException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public Publisher readPublisherById(Integer publisherId)  {
		try {
			return pdao.readPublisherById(publisherId);
		} catch (ClassNotFoundException | IllegalNameException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	public void addPublisher(Publisher publisher)  {
		try {
			pdao.addPublisher(publisher);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Transactional
	public void updatePublisher(Publisher publisher)  {
		try {
			pdao.updatePublisher(publisher);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Transactional
	public void deletePublisher(Publisher publisher)  {
		try {
			pdao.deletePublisher(publisher);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Publisher> readPublishers(String publisherName)  {
		try {
			return pdao.readAllPublisherByName(publisherName);
		} catch (ClassNotFoundException | IllegalNameException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	// public Integer getPublisherCount() throws SQLException {
	// Connection conn = null;
	// try {
	// conn = util.getConnection(); 
	// PublisherDAO adao = new PublisherDAO(conn);
	// return adao.getPublisherCount();
	// } catch (ClassNotFoundException | SQLException e) {
	// e.printStackTrace();
	// } finally {
	// if (conn != null)
	// conn.close();
	// }
	// return null;
	// }

}
