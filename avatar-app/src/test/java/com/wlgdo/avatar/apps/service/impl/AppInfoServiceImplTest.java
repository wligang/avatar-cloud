package com.wlgdo.avatar.apps.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wlgdo.avatar.apps.entity.AppInfo;
import com.wlgdo.avatar.apps.service.AppInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@SpringBootTest
@RunWith(SpringRunner.class)
public class AppInfoServiceImplTest {

	@Autowired
	private AppInfoService appInfoService;


	@Test
	public void getAppInfoPage() {

		AppInfo appInfo = new AppInfo();
		Page<AppInfo> page = new Page<>();
		IPage<AppInfo> data = appInfoService.getAppInfoPage(page, appInfo);

	}

	@Test
	public void getMap() {
	}



}
