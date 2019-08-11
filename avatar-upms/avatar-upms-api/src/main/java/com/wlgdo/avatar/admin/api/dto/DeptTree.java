

package com.wlgdo.avatar.admin.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Feify
 * @date 2019/2/1
 * 部门树
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DeptTree extends TreeNode {
	private String name;
}
