package com.github.ideauniverse.pagination;

import java.util.List;

/**
 * 分页
 */
public class Pagination<T> {

    /**
     * 当前页
     */
    private int page = 1;

    /**
     * 每页多少行
     */
    private int size = 10;

    /**
     * 总数
     */
    private int total;

    /**
     * 数据库中的开始行
     */
    private int start;

    public static final String paramName = "pagination";

    /**
     * 内容
     */
    private List<T> content;

    private String keyColumn;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getStart() {
        //mysql从第0行开始
        start = (page - 1) * size;
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> contetent) {
        this.content = contetent;
    }

    public String getLimitTag() {
        return "limitTag";
    }

    public String getKeyColumn() {
        return keyColumn;
    }

    public void setKeyColumn(String keyColumn){
        this.keyColumn = keyColumn;
    }

}
