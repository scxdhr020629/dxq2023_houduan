package com.example.testjpa.formbean;

import lombok.Data;

@Data
public class CommentFormBean {
    Integer iid;
    String userRealName;
    String Content;
    Integer like;
}
