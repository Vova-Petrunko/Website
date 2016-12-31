package com.albums;

import java.util.Date;

/**
 * Created by Вова on 31.12.2016.
 */
public class ViewersResponse {
    private int viewers;
    private Date now;

    public ViewersResponse(int viewers) {
        this.viewers = viewers;
        this.now = new Date();
    }

    public int getViewers() {
        return viewers;
    }

    public void setViewers(int viewers) {
        this.viewers = viewers;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }
}
