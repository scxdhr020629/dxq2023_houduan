package com.example.testjpa.formbean;

import lombok.Data;

import java.sql.Date;

@Data
public class ScholarShipFormBean {
    Integer iid;
    Integer studentIid;
    String scholarShipName;
    Date getDate;
}
