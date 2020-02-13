package com.lhx.charity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
@Slf4j
public class WechatApplicationRunner implements ApplicationRunner {




	@Override
	public void run(ApplicationArguments arg0) {


	}



}
