package com.lhx.charity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Configurable
@EnableScheduling
@Component
@Slf4j
public class TaskTimer {



	@Value("${mails.dev:true}")
	private Boolean isDev;


	//收集外接邮件
//	@Scheduled(cron = "4 3 2,10,13,16 ? * *") // 每天2点,10点,13点,16点3分4秒执行
	@Scheduled(cron = "17 0/30 * * * ?") // 30分钟执行一次
	public void execute1() {

		if (!isDev){
			log.info("开始收集邮件");
			//正式环境执行

			log.info("结束收集邮件");
		}

	}



}
