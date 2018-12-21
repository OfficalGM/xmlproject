package com.xmlproject.xmlproject.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Competition {
    String title;
    String showUnit;
    String startDate;
    String endDate;
    String location;
    String locationName;
    String onSales;
}
