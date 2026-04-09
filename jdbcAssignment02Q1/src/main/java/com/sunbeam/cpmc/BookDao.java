package com.sunbeam.cpmc;

import java.util.List;

public interface BookDao extends AutoCloseable {
		BookPojo findById(int id) throws Exception;
		List<BookPojo> findAll() throws Exception;
		List<BookPojo> findByName(String name) throws Exception;
		List<BookPojo> findByAuthor(String author) throws Exception;
		List<BookPojo> findBySubject(String subject) throws Exception;
		List<BookPojo> findByPriceBetween(double minPrice, double maxPrice) throws Exception;
		int saveBook(BookPojo book) throws Exception;
		int update(BookPojo book) throws Exception;
		int deleteById(int id) throws Exception;
}
