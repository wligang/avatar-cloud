package com.wlgdo.avatar.apps.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wlgdo.avatar.apps.entity.AppInfo;
import com.wlgdo.avatar.apps.service.AppInfoService;
import com.wlgdo.avatar.common.core.util.R;
import com.wlgdo.avatar.common.log.annotation.SysLog;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


/**
 * 应用信息表
 *
 * @author Ligang.Wang
 * @date 2019-07-18 23:00:08
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/appinfo")
public class AppInfoController {

  private final AppInfoService appInfoService;

  /**
   * 简单分页查询
   * @param page 分页对象
   * @param appInfo 应用信息表
   * @return
   */
  @GetMapping("/page")
  public R<IPage<AppInfo>> getAppInfoPage(Page<AppInfo> page, AppInfo appInfo) {
  	return  new R<>(appInfoService.getAppInfoPage(page,appInfo));
  }


  /**
   * 通过id查询单条记录
   * @param id
   * @return R
   */
  @GetMapping("/{id}")
  public R<AppInfo> getById(@PathVariable("id") Integer id){
    return new R<>(appInfoService.getById(id));
  }

  /**
   * 新增记录
   * @param appInfo
   * @return R
   */
  @SysLog("新增应用信息表")
  @PostMapping
  @PreAuthorize("@pms.hasPermission('app_appinfo_add')")
  public R save(@RequestBody AppInfo appInfo){
    return new R<>(appInfoService.save(appInfo));
  }

  /**
   * 修改记录
   * @param appInfo
   * @return R
   */
  @SysLog("修改应用信息表")
  @PutMapping
  @PreAuthorize("@pms.hasPermission('app_appinfo_edit')")
  public R update(@RequestBody AppInfo appInfo){
    return new R<>(appInfoService.updateById(appInfo));
  }

  /**
   * 通过id删除一条记录
   * @param id
   * @return R
   */
  @SysLog("删除应用信息表")
  @DeleteMapping("/{id}")
  @PreAuthorize("@pms.hasPermission('app_appinfo_del')")
  public R removeById(@PathVariable Integer id){
    return new R<>(appInfoService.removeById(id));
  }

}
