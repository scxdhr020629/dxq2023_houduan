package com.example.testjpa.formbean;

import lombok.Data;

@Data
public class CommentFormBean {
    String userRealName;
    String Content;
    Integer like;
}
