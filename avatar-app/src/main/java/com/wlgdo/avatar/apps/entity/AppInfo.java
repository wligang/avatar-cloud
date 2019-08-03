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
package com.wlgdo.avatar.apps.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 应用信息表
 *
 * @author Ligang.Wang
 * @date 2019-07-18 23:00:08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("app_info")
public class AppInfo extends Model<AppInfo> {
private static final long serialVersionUID = 1L;

    /**
   *
   */
    @TableId
    private Integer id;
    /**
   *
   */
    private Integer appId;
    /**
   *
   */
    private String appName;
    /**
   *
   */
    private String appSecret;
    /**
   *
   */
    private LocalDateTime createTime;
    /**
   *
   */
    private LocalDateTime updateTime;

}
