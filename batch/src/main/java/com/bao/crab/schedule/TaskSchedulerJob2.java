package com.bao.crab.schedule;

import com.bao.crab.util.Print;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * BaoDaShuai
 *
 * 2020年4月21日
 */
@Component
public class TaskSchedulerJob2 {
	private static final Logger logger = LoggerFactory.getLogger(TaskSchedulerJob2.class);

//	@Scheduled(fixedRate = 10000)
	public void reportCurrentTime() {
		logger.info(Print.printTime());
	}



}