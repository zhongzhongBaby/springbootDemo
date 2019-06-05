package com.example.demo.entity.request;

public class FindRequestBase  extends RequestBase{


    // 封装分页请求
    private Integer page;
    private Integer limit;
    private Integer pageSize;
    private String dateLength;
    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getDateLength() {
        return dateLength;
    }

    public void setDateLength(String dateLength) {
        this.dateLength = dateLength;
    }
}
