import com.lucky.pojo.Books;
import com.lucky.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService) applicationContext.getBean("BookServiceImpl");
        List<Books> booksList = bookService.queryAllBook();
        for (Books books : booksList){
            System.out.println(books);
        }
    }
}
