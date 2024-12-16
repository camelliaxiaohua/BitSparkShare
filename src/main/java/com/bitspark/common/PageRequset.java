package com.bitspark.common;

import java.io.Serializable;

/**
 * @Datetime: 2024年12月16日21:50
 * @Author: Camellia.xiaohua/Bitspark
 * @Package: com.bitspark.common
 * @Project: BitSpark-Share-Backend
 * @Description: 通用的分页请求
 */
public class PageRequset implements Serializable {

    private static final long serialVersionUID = -1031485010687480223L;

    /**
     * 当前页码
     */
    private Integer currentPage = 1;

    /**
     * 每页显示数量
     */
    private Integer pageSize = 10;

    /**
     * 排序字段
     */
    private String sortField;

    /**
     * 排序方式
     */
    private String sortOrder = "descend";
}
