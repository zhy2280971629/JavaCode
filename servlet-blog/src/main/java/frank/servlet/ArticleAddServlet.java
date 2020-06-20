package frank.servlet;

import frank.dao.ArticleDAO;
import frank.exception.BusinessException;
import frank.model.Article;
import frank.uti.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/articleAdd")
public class ArticleAddServlet extends AbstractBaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        InputStream is = req.getInputStream();
        //http请求Content-type为application/json，请求体是json字符串，需要反序列化为java对象
        //需要检查json字符串的键，必须和Java类型中的属性，能匹配
        // 如果json中的字符串在java类型中没有会抛异常
        Article article = JSONUtil.deserialize(is, Article.class);
        System.out.println("=====================\n" + article);
        int num = ArticleDAO.insert(article);
        if(num != 1){
            throw new BusinessException("001", "插入文章错误");
        }
        //模拟数据库插入数据操作
        return null;
    }
}
