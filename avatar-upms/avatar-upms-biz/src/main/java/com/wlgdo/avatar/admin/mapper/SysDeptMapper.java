package com.wlgdo.avatar.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wlgdo.avatar.admin.api.entity.SysDept;

import java.util.List;

/**
 * <p>
 * 部门管理 Mapper 接口
 * </p>
 *
* @author Feify
 */
public interface SysDeptMapper extends BaseMapper<SysDept> {

	/**
	 * 关联dept——relation
	 *
	 * @return 数据列表
	 */
	List<SysDept> listDepts();
}
