package top.fycoding.domain;

import java.util.List;

public class Page {
    // 一页多少个
    private int limit = 10;
    // 当前页码
    private int page = 1;
    // 总数量
    private int total;
    // 页码
    private List<String> pageList;
    private int maxPage = 1;

    Page(int total) {
        this.total = total;
        this.calculateMaxPage();
        this.generatePageList();
    }

    private void calculateMaxPage() {
        this.maxPage = this.total / this.limit + 1;
    }

    private void generatePageList() {
        for (int i = 1; i <= this.maxPage; i++) {
            pageList.add(String.valueOf(i));
        }
    }

    public int getNextPage() {
        return this.page + 1 > this.maxPage ? this.maxPage : this.page + 1;
    }

    public int getPrevPage() {
        return this.page - 1 < 1 ? 1 : this.page - 1;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
