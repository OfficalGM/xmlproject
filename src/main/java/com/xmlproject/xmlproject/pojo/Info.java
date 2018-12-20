package com.xmlproject.xmlproject.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Info {

    String title;
    String showUnit;
    String descriptionFilterHtml;
    String sourceWebName;
    String startDate;
    String endDate;
    ArrayList<ShowInfo> showInfo;

}
