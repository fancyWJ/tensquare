package com.tensquare.article.service;

import com.tensquare.article.dao.ArticleDao;
import com.tensquare.article.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private RedisTemplate redisTemplate;

    public Article findById(String id){
        Article article = (Article) redisTemplate.opsForValue().get("article_" + id);
        if(article == null){
            article = articleDao.findById(id).get();
            redisTemplate.opsForValue().set("article_"+id,article,10, TimeUnit.SECONDS);
        }
        return article;
    }

    public void update(Article article){
        redisTemplate.delete("article_"+article.getId());
        articleDao.save(article);
    }
}
