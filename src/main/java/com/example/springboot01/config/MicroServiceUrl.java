package com.example.springboot01.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 获取yml文件前缀为url的地址
 *
 * */

@Component
@ConfigurationProperties(prefix = "url")
public class MicroServiceUrl {

    /** 订单服务 */
    private String orderUrl;
    /** 用户服务 */
    private String userUrl;

    public String getOrderUrl() {
        return orderUrl;
    }

    public void setOrderUrl(String orderUrl) {
        this.orderUrl = orderUrl;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }
}
