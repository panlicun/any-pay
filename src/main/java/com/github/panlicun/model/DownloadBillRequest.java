package com.github.panlicun.model;


/**
 * 下载对账文件请求
 */
public class DownloadBillRequest {

    //对账日期
    private String billDate;

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }
}
