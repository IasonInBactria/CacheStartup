package com.argo.service.impl;

import com.argo.dao.BookMapper;
import com.argo.domain.Book;
import com.argo.service.IBookService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;


/**
 * @author YangY
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {
    /**
     * @param book
     * @return
     */

    @Autowired
    private BookMapper bookMapper;
    @Override
    public boolean saveBook(Book book) {
        return bookMapper.insert(book) > 0;
    }

    /**
     * @param book
     * @return
     */
    @Override
    public boolean modify(Book book) {
        return bookMapper.updateById(book) > 0;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public boolean delete(Integer id) {
        return bookMapper.deleteById(id) > 0;
    }

    /**
     * @param curPage
     * @param pageSize
     * @param book
     * @return
     */
    @Override
    public IPage<Book> getPage(int curPage, int pageSize, Book book) {
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Strings.isNotEmpty(book.getType()), Book::getType, book.getType());
        lambdaQueryWrapper.like(Strings.isNotEmpty(book.getName()), Book::getName, book.getName());
        lambdaQueryWrapper.like(Strings.isNotEmpty(book.getDescription()), Book::getDescription, book.getDescription());
        IPage bookIPage = new Page(curPage, pageSize);
        return bookMapper.selectPage(bookIPage, lambdaQueryWrapper);
    }

    /**
     * @param curPage
     * @param pageSize
     * @return
     */
    @Override
    public IPage<Book> getPage(int curPage, int pageSize) {
        return bookMapper.selectPage(new Page(curPage, pageSize), null);
    }

    /**
     * @param book
     * @return
     */
    public boolean delete(Book book) {
        return bookMapper.deleteById(book) > 0;
    }

    private HashMap<Integer, Book> cache = new HashMap<>();

//    @Override
//    public Book getById(Integer id){
//        //如果缓存中没有，则查询数据库，否则返回缓存数据
//        Book book = cache.get(id);
//        if (book == null){
//            Book queryBook = bookMapper.selectById(id);
//            cache.put(id, queryBook);
//            return queryBook;
//        }
//        return book;
//    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    @Cacheable(value = "cacheSpace", key = "#id")
    public Book getById(Integer id){
        return bookMapper.selectById(id);
    }
}
