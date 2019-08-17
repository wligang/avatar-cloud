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
package com.wlgdo.avatar.apps.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wlgdo.avatar.apps.entity.AppInfo;

import java.awt.image.Kernel;
import java.beans.IntrospectionException;
import java.util.Map;

/**
 * 应用信息表
 *
 * @author Ligang.Wang
 * @date 2019-07-18 23:00:08
 */
public interface AppInfoService extends IService<AppInfo> {

	/**
	 * 应用信息表简单分页查询
	 *
	 * @param appInfo 应用信息表
	 * @return
	 */
	IPage<AppInfo> getAppInfoPage(Page<AppInfo> page, AppInfo appInfo);


	/**
	 * 将对象转化未Map
	 *
	 * @param quaryWrapper
	 * @return
	 */
	Map getMap(String method,QueryWrapper quaryWrapper) throws IntrospectionException;
}
