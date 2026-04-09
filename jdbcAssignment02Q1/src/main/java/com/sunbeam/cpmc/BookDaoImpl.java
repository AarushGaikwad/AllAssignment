package com.sunbeam.cpmc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements AutoCloseable, BookDao {
	
	private Connection con;
	public BookDaoImpl() throws Exception{
		con = DbUtil.connect();
	}
	
	@Override
	public void close() throws Exception {
		if(con != null)
			con.close();
	}

	@Override
	public BookPojo findById(int id) throws Exception {
		String sql = "SELECT * FROM books WHERE id = ?";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, id);
			try(ResultSet rs = stmt.executeQuery()){
				if(rs.next()) {
					String name = rs.getString("name");
					String author = rs.getString("author");
					String subject = rs.getString("subject");
					Double price = rs.getDouble("price");
					
					BookPojo book = new BookPojo(id, name, author, subject, price);
					return book;
				}
			}
		}
		return null;
	}
	
	@Override
	public List<BookPojo> findAll() throws Exception {
		String sql = "SELECT * FROM books";
		List<BookPojo> bookList = new ArrayList<>();
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			try(ResultSet rs = stmt.executeQuery()){
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String author = rs.getString("author");
					String subject = rs.getString("subject");
					Double price = rs.getDouble("price");
					
					BookPojo pojo = new BookPojo(id, name, author, subject, price);
					bookList.add(pojo);
				}
			}
		}
		return bookList;
	}
	
	@Override
	public List<BookPojo> findByName(String name) throws Exception {
		String sql = "SELECT * FROM  books WHERE name LIKE ?";
		
		List<BookPojo> bookList = new ArrayList<>();
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, "%" + name + "%");
			try(ResultSet rs = stmt.executeQuery()){
				while(rs.next()) {
					int id = rs.getInt("id");
					String bookName = rs.getString("name");
					String author = rs.getString("author");
					String subject = rs.getString("subject");
					Double price = rs.getDouble("price");
					
					BookPojo pojo = new BookPojo(id, bookName, author, subject, price);
					bookList.add(pojo);
				}
			}
		}
		return bookList;
	}
	
	@Override
	public List<BookPojo> findByAuthor(String author) throws Exception {
		String sql = "SELECT * FROM  books WHERE LOWER(author) LIKE LOWER(?)";
		
		List<BookPojo> bookList = new ArrayList<>();
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, "%" + author.trim().toLowerCase() + "%");
			try(ResultSet rs = stmt.executeQuery()){
				while(rs.next()) {
					int id = rs.getInt("id");
					String bookName = rs.getString("name");
					String bookAuthor = rs.getString("author");
					String subject = rs.getString("subject");
					Double price = rs.getDouble("price");
					
					BookPojo pojo = new BookPojo(id, bookName, bookAuthor, subject, price);
					bookList.add(pojo);
				}
			}
		}
		return bookList;
	}
	
	@Override
	public List<BookPojo> findBySubject(String subject) throws Exception {
		String sql = "SELECT * FROM  books WHERE LOWER(subject) LIKE LOWER(?)";
		
		List<BookPojo> bookList = new ArrayList<>();
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, "%" + subject.trim().toLowerCase() + "%");
			try(ResultSet rs = stmt.executeQuery()){
				while(rs.next()) {
					int id = rs.getInt("id");
					String bookName = rs.getString("name");
					String bookAuthor = rs.getString("author");
					String bookSubject = rs.getString("subject");
					Double price = rs.getDouble("price");
					
					BookPojo pojo = new BookPojo(id, bookName, bookAuthor, bookSubject, price);
					bookList.add(pojo);
				}
			}
		}
		return bookList;
	}
	
	@Override
	public List<BookPojo> findByPriceBetween(double minPrice, double maxPrice) throws Exception {
		String sql = "SELECT * FROM books WHERE price BETWEEN ? AND ?";
		
		List<BookPojo> bookList = new ArrayList<>();
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setDouble(1, minPrice);
			stmt.setDouble(2, maxPrice);
			try(ResultSet rs = stmt.executeQuery()){
				while(rs.next()) {
					int id = rs.getInt("id");
					String bookName = rs.getString("name");
					String bookAuthor = rs.getString("author");
					String bookSubject = rs.getString("subject");
					Double price = rs.getDouble("price");
					
					BookPojo pojo = new BookPojo(id, bookName, bookAuthor, bookSubject, price);
					bookList.add(pojo);
				}
			}
		}
		return bookList;
	}
	
	@Override
	public int saveBook(BookPojo book) throws Exception {
		String sql = "INSERT INTO books (name, author, subject, price) VALUES (?, ?, ?, ?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, book.getName());
			stmt.setString(2, book.getAuthor());
			stmt.setString(3, book.getSubject());
			stmt.setDouble(4, book.getPrice());
			
			int count = stmt.executeUpdate();
			return count;
		}
		
	}
	
	@Override
	public int update(BookPojo book) throws Exception {
		String sql = "UPDATE books SET	name=?, author=?, subject=?, price=? WHERE id=?";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, book.getName());
			stmt.setString(2, book.getAuthor());
			stmt.setString(3, book.getSubject());
			stmt.setDouble(4, book.getPrice());
			stmt.setInt(5, book.getId());
			
			int count = stmt.executeUpdate();
			return count;
		}
		
	}
	
	@Override
	public int deleteById(int id) throws Exception {
		String sql = "DELETE FROM books WHERE id = ?";
	    
	    try (PreparedStatement stmt = con.prepareStatement(sql)) {
	        stmt.setInt(1, id);
	        
	        int count = stmt.executeUpdate();
	        return count;
	    }
	}

	
	
}
