package com.cb.edu.entity.AllChapter;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OneChapter {
    private String id;
    private String title;
    private List<TwoVideo> Children = new ArrayList<>();

}
