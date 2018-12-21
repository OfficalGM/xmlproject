package com.xmlproject.xmlproject.Model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Contest {
    int id;
    String title;
    String showUnit;
    String descriptionFilterHtml;
    String sourceWebName;
    String startDate;
    String endDate;
    String location;
    String locationName;
    String onSales;

}
