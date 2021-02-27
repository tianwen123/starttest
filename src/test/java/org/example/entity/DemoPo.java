package org.example.entity;


import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class DemoPo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private Map<String,Object> infoData;
}
