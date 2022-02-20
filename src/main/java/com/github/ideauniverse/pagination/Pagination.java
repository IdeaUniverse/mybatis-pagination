package com.github.ideauniverse.pagination;

import java.util.List;

/**
 * 分页
 */
public class Pagination<T> {

    /**
     * mybatis dao 传入的分页参数名
     */
    public static final String PARAM_NAME = "pagination";

    /**
     * sql 中分页占位符
     */
    public static final String LIMIT_TAG = "limitTag";

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

    /**
     * 依据分页的数据库字段，如果是单表查询可不设置
     */
    private transient String keyColumn;

    /**
     * 内容
     */
    private List<? extends T> content;

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

    public List<? extends T> getContent() {
        return content;
    }

    public void setContent(List<? extends T> content) {
        this.content = content;
    }

    public String getKeyColumn() {
        return keyColumn;
    }

    public void setKeyColumn(String keyColumn){
        this.keyColumn = keyColumn;
    }
}
