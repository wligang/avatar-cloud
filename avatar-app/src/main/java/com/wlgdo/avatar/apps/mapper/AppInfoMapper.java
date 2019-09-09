package com.wlgdo.avatar.apps.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wlgdo.avatar.apps.entity.AppInfo;
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
