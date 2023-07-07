package com.example.testjpa.formbean;

import lombok.Data;

import java.sql.Date;

@Data
public class DormitoryWaterAndPowerFormBean {
    Integer iid;
    Integer dormitoryIid;
    String buildingName;
    String buildingNumber;
    Double powerPrice;
    Double waterPrice;
    Date beginDate;
    Date endDate;
    String status;
}
