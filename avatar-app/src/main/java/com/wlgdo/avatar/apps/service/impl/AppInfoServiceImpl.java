/*
 *    Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: lengleng (wangiegie@gmail.com)
 */
package com.wlgdo.avatar.apps.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.xml.bind.v2.schemagen.xmlschema.Appinfo;
import com.wlgdo.avatar.apps.entity.AppInfo;
import com.wlgdo.avatar.apps.mapper.AppInfoMapper;
import com.wlgdo.avatar.apps.service.AppInfoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 应用信息表
 *
 * @author Ligang.Wang
 * @date 2019-07-18 23:00:08
 */
@Service("appInfoService")
@AllArgsConstructor
public class AppInfoServiceImpl extends ServiceImpl<AppInfoMapper, AppInfo> implements AppInfoService {

	private final AppInfoMapper appInfoMapper;

	/**
	 * 应用信息表简单分页查询
	 *
	 * @param appInfo 应用信息表
	 * @return
	 */
	@Override
	public IPage<AppInfo> getAppInfoPage(Page<AppInfo> page, AppInfo appInfo) {
		return baseMapper.getAppInfoPage(page, appInfo);
	}

	@Override
	public Map getMap(String field, QueryWrapper quaryWrapper) throws IntrospectionException {
		List<AppInfo> list = appInfoMapper.selectList(quaryWrapper);
		Class clazz = AppInfo.class;
		PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field, clazz);

		//注意在lambda中key相同时会异常
		Map<Object, AppInfo> collect = list.stream().collect(Collectors.toMap(act -> {
			try {
				return (propertyDescriptor.getReadMethod().invoke(act));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			return null;
		}, act -> act));
		return collect;
	}


}
