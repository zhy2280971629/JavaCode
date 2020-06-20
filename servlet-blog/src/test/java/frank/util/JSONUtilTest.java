package frank.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import frank.model.Article;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
public class JSONUtilTest {
    @Test
    public void t1() throws IOException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Article article = new Article();
            article.setId(1);
            article.setTitle("How are you");
            article.setContent("舞低杨柳楼心月，歌尽桃花扇底风");
            article.setUserId(1);
            article.setCreateTime(new Date());
            //将对象序列化为json字符串
            String s =  mapper.writeValueAsString(article);
            System.out.println(s);
            //将json字符串反序列化为java对象
            Article des = mapper.readValue(s, Article.class);
            System.out.println(des);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
