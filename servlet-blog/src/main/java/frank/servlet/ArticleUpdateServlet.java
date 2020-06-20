package frank.servlet;

import frank.dao.ArticleDAO;
import frank.exception.BaseException;
import frank.exception.BusinessException;
import frank.model.Article;
import frank.uti.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

@WebServlet("/articleUpdate")
public class ArticleUpdateServlet extends AbstractBaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //文章修改：包含id,title,content
        InputStream is = req.getInputStream();
        Article article = JSONUtil.deserialize(is, Article.class);
        //模拟数据库插入数据操作
        System.out.println("=====================\n" + article);
        int num = ArticleDAO.update(article);
        if(num != 1)
            throw new BusinessException("004", "文章修改出错");
        return null;
    }
}
