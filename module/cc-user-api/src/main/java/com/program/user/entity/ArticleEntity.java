package com.program.user.entity;

import java.io.Serializable;
import java.util.List;

public class ArticleEntity implements Serializable {

    private String id;
    private String title;
    private String content;
    private UserEntity userEntity;
    private List<CommentEntity> commentEntityList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public List<CommentEntity> getCommentEntityList() {
        return commentEntityList;
    }

    public void setCommentEntityList(List<CommentEntity> commentEntityList) {
        this.commentEntityList = commentEntityList;
    }

    @Override
    public String toString() {
        return "ArticleEntity{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", userEntity=" + userEntity +
                ", commentEntityList=" + commentEntityList +
                '}';
    }
}
