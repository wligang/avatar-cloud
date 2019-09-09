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
