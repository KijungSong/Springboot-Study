package com.daebaksong;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 2. com.daebaksong.ServerInfo Bean을 생성하는 Java Config를 작성한다.
@Configuration
public class ServerInfoConfiguration {
    @Bean
    public ServerInfo serverInfo() {
        ServerInfo serverInfo = new ServerInfo();
        serverInfo.setAddress("1.1.1.2");
        serverInfo.setPort(111);
        return serverInfo;
    }
}
