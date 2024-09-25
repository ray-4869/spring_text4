package com.sbb.sbb.article;

import com.sbb.sbb.DataNotFoundException;
import com.sbb.sbb.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> getList () {
        return this.articleRepository.findAll();
    }

    public void create (String title, String content, SiteUser user) {
        Article ca = new Article();
        ca.setTitle(title);
        ca.setContent(content);
        ca.setCreateDate(LocalDateTime.now());
        ca.setAuthor(user);
        this.articleRepository.save(ca);
    }

    public Article getArticle(Integer id){
        Optional<Article> article = this.articleRepository.findById(id);
        if(article.isPresent()){
            return article.get();
        }else {
            throw new DataNotFoundException("article not found");
        }
    }
}
