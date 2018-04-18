package ua.nure.ihor.zhazhkyi.entity;

import java.util.Objects;

public class PageArguments {

    private int page;

    private int pageSize;

    public PageArguments(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PageArguments orderPage = (PageArguments) o;
        return page == orderPage.page &&
                pageSize == orderPage.pageSize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(page, pageSize);
    }
}
