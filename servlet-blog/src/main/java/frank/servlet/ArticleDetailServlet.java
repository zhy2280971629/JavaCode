package frank.servlet;

import frank.dao.ArticleDAO;
import frank.exception.BusinessException;
import frank.exception.ClientException;
import frank.model.Article;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@WebServlet("/articleDetail")
public class ArticleDetailServlet extends AbstractBaseServlet{
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //获取请求数据中的文章id
        String id=req.getParameter("id");
        Integer articleId;
        try {
            articleId=Integer.parseInt(id);


        }catch (Exception e) {
            throw new ClientException("001","请求参数错误：[id="+id+"]");
        }
        Article article = ArticleDAO.query(articleId);
        if(article == null){
            throw new BusinessException("002", "查询不到文章详情id=" + articleId);
        }
        return article;//测试代码以后替换为数据库查询代码，根据文章id
    }
//    public static Article testData() {
//        Article a1 = new Article();
//        a1.setId(1);
//        a1.setTitle("How are you");
//        a1.setContent("舞低杨柳楼心月，歌尽桃花扇底风");
//        a1.setUserId(1);
//        a1.setCreateTime(new Date());
//        return a1;
//    }
}
