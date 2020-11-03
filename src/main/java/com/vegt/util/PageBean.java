package com.vegt.util;

public class PageBean<T> {
    //currentPage表示当前页,默认是第一页
    private Integer currentPage=1;

    //PageCount 查询每页的行数,默认每页显示10行
    private int pageCount=10;

    //总记录数
    private int totalCount;

    //总页数（总记录数/每页显示的行数）+1
    private int totalPage;

    //分页查询显示的数据,使用泛型,可以重复使用
    private T pageData;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        if(totalCount%pageCount==0){
            totalPage = totalCount/pageCount;
        }else{
            totalPage = totalCount/pageCount+1;
        }
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public T getPageData() {
        return pageData;
    }

    public void setPageData(T pageData) {
        this.pageData = pageData;
    }
}
