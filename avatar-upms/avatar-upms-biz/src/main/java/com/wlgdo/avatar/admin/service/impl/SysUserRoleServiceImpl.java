

package com.wlgdo.avatar.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wlgdo.avatar.admin.api.entity.SysUserRole;
import com.wlgdo.avatar.admin.mapper.SysUserRoleMapper;
import com.wlgdo.avatar.admin.service.SysUserRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
* @author Feify
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

	/**
	 * 根据用户Id删除该用户的角色关系
	 *
	 * @param userId 用户ID
	 * @return boolean
	 * @author 寻欢·李
	 * @date 2017年12月7日 16:31:38
	 */
	@Override
	public Boolean removeRoleByUserId(Integer userId) {
		return baseMapper.deleteByUserId(userId);
	}
}
