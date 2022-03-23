package com.zxl.eureka.client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @auth zhangxl
 * @date 2020/12/24
 */
@FeignClient(name = "service-test-client2")
public interface ZxlFeignClient {

    @GetMapping("/zxl/testString")
    String testString();

}
