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
package com.pig4cloud.pig.apps.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.apps.entity.AppInfo;
import org.apache.ibatis.annotations.Param;

/**
 * 应用信息表
 *
 * @author Ligang.Wang
 * @date 2019-07-18 23:00:08
 */
public interface AppInfoMapper extends BaseMapper<AppInfo> {
  /**
    * 应用信息表简单分页查询
    * @param appInfo 应用信息表
    * @return
    */
  IPage<AppInfo> getAppInfoPage(Page page, @Param("appInfo") AppInfo appInfo);


}
