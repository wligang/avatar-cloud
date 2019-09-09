/*
 Navicat Premium Data Transfer

 Source Server         : localhos-local
 Source Server Type    : MySQL
 Source Server Version : 50644
 Source Host           : localhost:3306
 Source Schema         : avatar

 Target Server Type    : MySQL
 Target Server Version : 50644
 File Encoding         : 65001

 Date: 09/09/2019 11:06:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app_info
-- ----------------------------
DROP TABLE IF EXISTS `app_info`;
CREATE TABLE `app_info`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `app_id` int(10) NULL DEFAULT NULL,
  `app_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `app_secret` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `org_id` int(10) NULL DEFAULT NULL,
  `org_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '应用信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of app_info
-- ----------------------------
INSERT INTO `app_info` VALUES (1, 10001, 'APP-1', 'app-secret', 1, '创软科技', '2019-08-10 15:10:40', '2019-08-10 15:10:44');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `dept_id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  `parent_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门管理' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (1, '山东', NULL, '2018-01-22 19:00:23', '2018-09-13 01:46:29', '0', 0);
INSERT INTO `sys_dept` VALUES (2, '沙县国际', NULL, '2018-01-22 19:00:38', '2018-09-13 01:46:30', '0', 0);
INSERT INTO `sys_dept` VALUES (3, '潍坊', NULL, '2018-01-22 19:00:44', '2018-09-13 01:46:31', '0', 1);
INSERT INTO `sys_dept` VALUES (4, '高新', NULL, '2018-01-22 19:00:52', '2018-10-06 10:41:52', '0', 3);
INSERT INTO `sys_dept` VALUES (5, '院校', NULL, '2018-01-22 19:00:57', '2018-10-06 10:42:51', '0', 4);
INSERT INTO `sys_dept` VALUES (6, '潍院', NULL, '2018-01-22 19:01:06', '2019-01-09 10:58:18', '1', 5);
INSERT INTO `sys_dept` VALUES (7, '山东沙县', NULL, '2018-01-22 19:01:57', '2018-09-13 01:46:42', '0', 2);
INSERT INTO `sys_dept` VALUES (8, '潍坊沙县', NULL, '2018-01-22 19:02:03', '2018-09-13 01:46:43', '0', 7);
INSERT INTO `sys_dept` VALUES (9, '高新沙县', NULL, '2018-01-22 19:02:14', '2018-09-13 01:46:44', '1', 8);
INSERT INTO `sys_dept` VALUES (10, '院校沙县', NULL, '2018-12-10 21:19:26', NULL, '0', 8);

-- ----------------------------
-- Table structure for sys_dept_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept_relation`;
CREATE TABLE `sys_dept_relation`  (
  `ancestor` int(11) NOT NULL COMMENT '祖先节点',
  `descendant` int(11) NOT NULL COMMENT '后代节点',
  PRIMARY KEY (`ancestor`, `descendant`) USING BTREE,
  INDEX `idx1`(`ancestor`) USING BTREE,
  INDEX `idx2`(`descendant`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '部门关系表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_dept_relation
-- ----------------------------
INSERT INTO `sys_dept_relation` VALUES (1, 1);
INSERT INTO `sys_dept_relation` VALUES (1, 3);
INSERT INTO `sys_dept_relation` VALUES (1, 4);
INSERT INTO `sys_dept_relation` VALUES (1, 5);
INSERT INTO `sys_dept_relation` VALUES (2, 2);
INSERT INTO `sys_dept_relation` VALUES (2, 7);
INSERT INTO `sys_dept_relation` VALUES (2, 8);
INSERT INTO `sys_dept_relation` VALUES (2, 11);
INSERT INTO `sys_dept_relation` VALUES (3, 3);
INSERT INTO `sys_dept_relation` VALUES (3, 4);
INSERT INTO `sys_dept_relation` VALUES (3, 5);
INSERT INTO `sys_dept_relation` VALUES (4, 4);
INSERT INTO `sys_dept_relation` VALUES (4, 5);
INSERT INTO `sys_dept_relation` VALUES (5, 5);
INSERT INTO `sys_dept_relation` VALUES (7, 7);
INSERT INTO `sys_dept_relation` VALUES (7, 8);
INSERT INTO `sys_dept_relation` VALUES (7, 11);
INSERT INTO `sys_dept_relation` VALUES (8, 8);
INSERT INTO `sys_dept_relation` VALUES (8, 11);
INSERT INTO `sys_dept_relation` VALUES (10, 10);
INSERT INTO `sys_dept_relation` VALUES (11, 11);

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `id` int(64) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '数据值',
  `label` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签名',
  `type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '描述',
  `sort` int(10) NOT NULL COMMENT '排序（升序）',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `sys_dict_value`(`value`) USING BTREE,
  INDEX `sys_dict_label`(`label`) USING BTREE,
  INDEX `sys_dict_del_flag`(`del_flag`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES (1, '9', '异常', 'log_type', '日志异常', 1, '2018-07-09 06:16:14', '2018-11-24 07:25:11', '日志异常', '0');
INSERT INTO `sys_dict` VALUES (2, '0', '正常', 'log_type', '正常', 0, '2018-07-09 06:15:40', '2018-11-24 07:25:14', '正常', '0');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '日志类型',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '日志标题',
  `service_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务ID',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `remote_addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作IP地址',
  `user_agent` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户代理',
  `request_uri` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求URI',
  `method` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作方式',
  `params` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '操作提交的数据',
  `time` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '执行时间',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标记',
  `exception` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '异常信息',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `sys_log_create_by`(`create_by`) USING BTREE,
  INDEX `sys_log_request_uri`(`request_uri`) USING BTREE,
  INDEX `sys_log_type`(`type`) USING BTREE,
  INDEX `sys_log_create_date`(`create_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '日志表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `permission` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单权限标识',
  `path` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前端URL',
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '父菜单ID',
  `icon` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `component` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'VUE页面',
  `sort` int(11) NULL DEFAULT 1 COMMENT '排序值',
  `keep_alive` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '0-开启，1- 关闭',
  `type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单类型 （0菜单 1按钮）',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '逻辑删除标记(0--正常 1--删除)',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单权限表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1000, '权限管理', NULL, '/upms', -1, 'icon-quanxianguanli', 'Layout', 0, '0', '0', '2018-09-28 08:29:53', '2018-09-28 08:53:01', '0');
INSERT INTO `sys_menu` VALUES (1100, '用户管理', NULL, 'user', 1000, 'icon-yonghuguanli', 'views/admin/user/index', 1, '0', '0', '2017-11-02 22:24:37', '2018-09-28 09:00:41', '0');
INSERT INTO `sys_menu` VALUES (1101, '用户新增', 'sys_user_add', NULL, 1100, NULL, NULL, NULL, '0', '1', '2017-11-08 09:52:09', '2018-09-28 09:06:34', '0');
INSERT INTO `sys_menu` VALUES (1102, '用户修改', 'sys_user_edit', NULL, 1100, NULL, NULL, NULL, '0', '1', '2017-11-08 09:52:48', '2018-09-28 09:06:37', '0');
INSERT INTO `sys_menu` VALUES (1103, '用户删除', 'sys_user_del', NULL, 1100, NULL, NULL, NULL, '0', '1', '2017-11-08 09:54:01', '2018-09-28 09:06:42', '0');
INSERT INTO `sys_menu` VALUES (1200, '菜单管理', NULL, 'menu', 1000, 'icon-caidanguanli', 'views/admin/menu/index', 2, '0', '0', '2017-11-08 09:57:27', '2018-09-28 09:00:45', '0');
INSERT INTO `sys_menu` VALUES (1201, '菜单新增', 'sys_menu_add', NULL, 1200, NULL, NULL, NULL, '0', '1', '2017-11-08 10:15:53', '2018-09-28 09:07:16', '0');
INSERT INTO `sys_menu` VALUES (1202, '菜单修改', 'sys_menu_edit', NULL, 1200, NULL, NULL, NULL, '0', '1', '2017-11-08 10:16:23', '2018-09-28 09:07:18', '0');
INSERT INTO `sys_menu` VALUES (1203, '菜单删除', 'sys_menu_del', NULL, 1200, NULL, NULL, NULL, '0', '1', '2017-11-08 10:16:43', '2018-09-28 09:07:22', '0');
INSERT INTO `sys_menu` VALUES (1300, '角色管理', NULL, 'role', 1000, 'icon-jiaoseguanli', 'views/admin/role/index', 3, '0', '0', '2017-11-08 10:13:37', '2018-09-28 09:00:48', '0');
INSERT INTO `sys_menu` VALUES (1301, '角色新增', 'sys_role_add', NULL, 1300, NULL, NULL, NULL, '0', '1', '2017-11-08 10:14:18', '2018-09-28 09:07:46', '0');
INSERT INTO `sys_menu` VALUES (1302, '角色修改', 'sys_role_edit', NULL, 1300, NULL, NULL, NULL, '0', '1', '2017-11-08 10:14:41', '2018-09-28 09:07:49', '0');
INSERT INTO `sys_menu` VALUES (1303, '角色删除', 'sys_role_del', NULL, 1300, NULL, NULL, NULL, '0', '1', '2017-11-08 10:14:59', '2018-09-28 09:07:53', '0');
INSERT INTO `sys_menu` VALUES (1304, '分配权限', 'sys_role_perm', NULL, 1300, NULL, NULL, NULL, '0', '1', '2018-04-20 07:22:55', '2018-09-28 09:13:23', '0');
INSERT INTO `sys_menu` VALUES (1400, '部门管理', NULL, 'dept', 1000, 'icon-web-icon-', 'views/admin/dept/index', 4, '0', '0', '2018-01-20 13:17:19', '2018-12-09 16:35:12', '0');
INSERT INTO `sys_menu` VALUES (1401, '部门新增', 'sys_dept_add', NULL, 1400, NULL, NULL, NULL, '0', '1', '2018-01-20 14:56:16', '2018-09-28 09:08:13', '0');
INSERT INTO `sys_menu` VALUES (1402, '部门修改', 'sys_dept_edit', NULL, 1400, NULL, NULL, NULL, '0', '1', '2018-01-20 14:56:59', '2018-09-28 09:08:16', '0');
INSERT INTO `sys_menu` VALUES (1403, '部门删除', 'sys_dept_del', NULL, 1400, NULL, NULL, NULL, '0', '1', '2018-01-20 14:57:28', '2018-09-28 09:08:18', '0');
INSERT INTO `sys_menu` VALUES (2000, '系统管理', NULL, '/admin', -1, 'icon-xitongguanli', 'Layout', 1, '0', '0', '2017-11-07 20:56:00', '2018-09-28 08:53:18', '0');
INSERT INTO `sys_menu` VALUES (2100, '日志管理', NULL, 'log', 2000, 'icon-rizhiguanli', 'views/admin/log/index', 5, '0', '0', '2017-11-20 14:06:22', '2018-09-28 09:01:52', '0');
INSERT INTO `sys_menu` VALUES (2101, '日志删除', 'sys_log_del', NULL, 2100, NULL, NULL, NULL, '0', '1', '2017-11-20 20:37:37', '2018-09-28 09:08:44', '0');
INSERT INTO `sys_menu` VALUES (2200, '字典管理', NULL, 'dict', 2000, 'icon-navicon-zdgl', 'views/admin/dict/index', 6, '0', '0', '2017-11-29 11:30:52', '2018-09-28 09:01:47', '0');
INSERT INTO `sys_menu` VALUES (2201, '字典删除', 'sys_dict_del', NULL, 2200, NULL, NULL, NULL, '0', '1', '2017-11-29 11:30:11', '2018-09-28 09:09:10', '0');
INSERT INTO `sys_menu` VALUES (2202, '字典新增', 'sys_dict_add', NULL, 2200, NULL, NULL, NULL, '0', '1', '2018-05-11 22:34:55', '2018-09-28 09:09:12', '0');
INSERT INTO `sys_menu` VALUES (2203, '字典修改', 'sys_dict_edit', NULL, 2200, NULL, NULL, NULL, '0', '1', '2018-05-11 22:36:03', '2018-09-28 09:09:16', '0');
INSERT INTO `sys_menu` VALUES (2300, '代码生成', '', 'gen', 2000, 'icon-weibiaoti46', 'views/gen/index', 8, '0', '0', '2018-01-20 13:17:19', '2018-11-24 05:21:01', '0');
INSERT INTO `sys_menu` VALUES (2400, '终端管理', '', 'client', 2000, 'icon-shouji', 'views/admin/client/index', 9, '0', '0', '2018-01-20 13:17:19', '2018-09-28 09:01:43', '0');
INSERT INTO `sys_menu` VALUES (2401, '客户端新增', 'sys_client_add', NULL, 2400, '1', NULL, NULL, '0', '1', '2018-05-15 21:35:18', '2018-09-28 09:10:25', '0');
INSERT INTO `sys_menu` VALUES (2402, '客户端修改', 'sys_client_edit', NULL, 2400, NULL, NULL, NULL, '0', '1', '2018-05-15 21:37:06', '2018-09-28 09:10:27', '0');
INSERT INTO `sys_menu` VALUES (2403, '客户端删除', 'sys_client_del', NULL, 2400, NULL, NULL, NULL, '0', '1', '2018-05-15 21:39:16', '2018-09-28 09:10:30', '0');
INSERT INTO `sys_menu` VALUES (2500, '服务监控', NULL, 'http://127.0.0.1:5001', 2000, 'icon-server', NULL, 10, '0', '0', '2018-06-26 10:50:32', '2019-02-01 20:41:30', '0');
INSERT INTO `sys_menu` VALUES (2600, '令牌管理', NULL, 'token', 2000, 'icon-denglvlingpai', 'views/admin/token/index', 11, '0', '0', '2018-09-04 05:58:41', '2018-09-28 09:01:38', '0');
INSERT INTO `sys_menu` VALUES (2601, '令牌删除', 'sys_token_del', NULL, 2600, NULL, NULL, 1, '0', '1', '2018-09-04 05:59:50', '2018-09-28 09:11:24', '0');
INSERT INTO `sys_menu` VALUES (2700, '链路调用', NULL, 'http://127.0.0.1:5002', 2000, 'icon-server', NULL, 10, '0', '0', '2018-06-26 10:50:32', '2019-02-01 20:41:30', '0');
INSERT INTO `sys_menu` VALUES (5000, '一级菜单', NULL, '/crud', -1, 'icon-caidanguanli', '', 4, '0', '0', '2018-08-28 01:50:22', '2018-09-28 08:58:20', '0');
INSERT INTO `sys_menu` VALUES (5001, '一级菜单', NULL, 'index', 5000, 'icon-caidanguanli', 'views/crud/index', 1, '0', '0', '2018-08-28 01:50:48', '2018-11-21 17:48:19', '1');
INSERT INTO `sys_menu` VALUES (5002, '二级菜单', NULL, 'crud', 5001, 'icon-caidanguanli', 'views/crud/index', 1, '0', '0', '2018-08-28 01:51:23', '2018-11-21 17:47:40', '1');
INSERT INTO `sys_menu` VALUES (5003, '二级菜单', NULL, '', 5000, 'icon-caidanguanli', '', 1, '0', '0', '2018-11-21 17:49:18', '2018-11-21 17:53:25', '0');
INSERT INTO `sys_menu` VALUES (5004, '二级菜单', NULL, 'index', 5003, 'icon-caidanguanli', 'views/crud/index', 1, '0', '0', '2018-11-21 17:53:51', '2018-12-20 14:26:53', '1');
INSERT INTO `sys_menu` VALUES (9999, '系统官网', NULL, 'https://pig4cloud.com/#/', -1, 'icon-guanwangfangwen', NULL, 9, '0', '0', '2019-01-17 17:05:19', '2019-01-17 17:29:06', '0');

-- ----------------------------
-- Table structure for sys_oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `sys_oauth_client_details`;
CREATE TABLE `sys_oauth_client_details`  (
  `client_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `resource_ids` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `client_secret` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `scope` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `authorized_grant_types` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `authorities` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `access_token_validity` int(11) NULL DEFAULT NULL,
  `refresh_token_validity` int(11) NULL DEFAULT NULL,
  `additional_information` varchar(4096) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `autoapprove` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`client_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '终端信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_oauth_client_details
-- ----------------------------
INSERT INTO `sys_oauth_client_details` VALUES ('app', NULL, 'app', 'server', 'password,refresh_token', NULL, NULL, NULL, NULL, NULL, 'true');
INSERT INTO `sys_oauth_client_details` VALUES ('daemon', NULL, 'daemon', 'server', 'password,refresh_token', NULL, NULL, NULL, NULL, NULL, 'true');
INSERT INTO `sys_oauth_client_details` VALUES ('gen', NULL, 'gen', 'server', 'password,refresh_token', NULL, NULL, NULL, NULL, NULL, 'true');
INSERT INTO `sys_oauth_client_details` VALUES ('pig', NULL, 'pig', 'server', 'password,refresh_token,authorization_code,client_credentials', 'http://localhost:4040/sso1/login,http://localhost:4041/sso1/login', NULL, NULL, NULL, NULL, 'true');
INSERT INTO `sys_oauth_client_details` VALUES ('test', NULL, 'test', 'server', 'password,refresh_token', NULL, NULL, NULL, NULL, NULL, 'true');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `role_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `role_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT '0' COMMENT '删除标识（0-正常,1-删除）',
  PRIMARY KEY (`role_id`) USING BTREE,
  UNIQUE INDEX `role_idx1_role_code`(`role_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '系统角色表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '管理员', 'ROLE_ADMIN', '管理员', '2017-10-29 15:45:51', '2018-12-26 14:09:11', '0');
INSERT INTO `sys_role` VALUES (2, 'ROLE_CQQ', 'ROLE_CQQ', 'ROLE_CQQ', '2018-11-11 19:42:26', '2018-12-26 14:09:07', '0');

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `role_id` int(20) NULL DEFAULT NULL COMMENT '角色ID',
  `dept_id` int(20) NULL DEFAULT NULL COMMENT '部门ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色与部门对应关系' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------
INSERT INTO `sys_role_dept` VALUES (1, 1, 8);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色菜单表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 1000);
INSERT INTO `sys_role_menu` VALUES (1, 1100);
INSERT INTO `sys_role_menu` VALUES (1, 1101);
INSERT INTO `sys_role_menu` VALUES (1, 1102);
INSERT INTO `sys_role_menu` VALUES (1, 1103);
INSERT INTO `sys_role_menu` VALUES (1, 1200);
INSERT INTO `sys_role_menu` VALUES (1, 1201);
INSERT INTO `sys_role_menu` VALUES (1, 1202);
INSERT INTO `sys_role_menu` VALUES (1, 1203);
INSERT INTO `sys_role_menu` VALUES (1, 1300);
INSERT INTO `sys_role_menu` VALUES (1, 1301);
INSERT INTO `sys_role_menu` VALUES (1, 1302);
INSERT INTO `sys_role_menu` VALUES (1, 1303);
INSERT INTO `sys_role_menu` VALUES (1, 1304);
INSERT INTO `sys_role_menu` VALUES (1, 1400);
INSERT INTO `sys_role_menu` VALUES (1, 1401);
INSERT INTO `sys_role_menu` VALUES (1, 1402);
INSERT INTO `sys_role_menu` VALUES (1, 1403);
INSERT INTO `sys_role_menu` VALUES (1, 2000);
INSERT INTO `sys_role_menu` VALUES (1, 2100);
INSERT INTO `sys_role_menu` VALUES (1, 2101);
INSERT INTO `sys_role_menu` VALUES (1, 2200);
INSERT INTO `sys_role_menu` VALUES (1, 2201);
INSERT INTO `sys_role_menu` VALUES (1, 2202);
INSERT INTO `sys_role_menu` VALUES (1, 2203);
INSERT INTO `sys_role_menu` VALUES (1, 2300);
INSERT INTO `sys_role_menu` VALUES (1, 2400);
INSERT INTO `sys_role_menu` VALUES (1, 2401);
INSERT INTO `sys_role_menu` VALUES (1, 2402);
INSERT INTO `sys_role_menu` VALUES (1, 2403);
INSERT INTO `sys_role_menu` VALUES (1, 2500);
INSERT INTO `sys_role_menu` VALUES (1, 2600);
INSERT INTO `sys_role_menu` VALUES (1, 2601);
INSERT INTO `sys_role_menu` VALUES (1, 2700);
INSERT INTO `sys_role_menu` VALUES (1, 9999);
INSERT INTO `sys_role_menu` VALUES (2, 1000);
INSERT INTO `sys_role_menu` VALUES (2, 1100);
INSERT INTO `sys_role_menu` VALUES (2, 1101);
INSERT INTO `sys_role_menu` VALUES (2, 1102);
INSERT INTO `sys_role_menu` VALUES (2, 1103);
INSERT INTO `sys_role_menu` VALUES (2, 1200);
INSERT INTO `sys_role_menu` VALUES (2, 1201);
INSERT INTO `sys_role_menu` VALUES (2, 1202);
INSERT INTO `sys_role_menu` VALUES (2, 1203);
INSERT INTO `sys_role_menu` VALUES (2, 1300);
INSERT INTO `sys_role_menu` VALUES (2, 1301);
INSERT INTO `sys_role_menu` VALUES (2, 1302);
INSERT INTO `sys_role_menu` VALUES (2, 1303);
INSERT INTO `sys_role_menu` VALUES (2, 1304);
INSERT INTO `sys_role_menu` VALUES (2, 1400);
INSERT INTO `sys_role_menu` VALUES (2, 1401);
INSERT INTO `sys_role_menu` VALUES (2, 1402);
INSERT INTO `sys_role_menu` VALUES (2, 1403);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `salt` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '随机盐',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '简介',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '头像',
  `dept_id` int(11) NULL DEFAULT NULL COMMENT '部门ID',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `lock_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT '0' COMMENT '0-正常，9-锁定',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT '0' COMMENT '0-正常，1-删除',
  `wx_openid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '微信openid',
  `qq_openid` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT 'QQ openid',
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `user_wx_openid`(`wx_openid`) USING BTREE,
  INDEX `user_qq_openid`(`qq_openid`) USING BTREE,
  INDEX `user_idx1_username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '$2a$10$RpFJjxYiXdEsAGnWp/8fsOetMuOON96Ntk/Ym2M/RKRyU0GZseaDC', NULL, '17034642999', '', 1, '2018-04-20 07:15:18', '2019-01-31 14:29:07', '0', '0', 'o_0FT0uyg_H1vVy2H0JpSwlVGhWQ', NULL);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (2, 2);

-- ----------------------------
-- Table structure for zipkin_annotations
-- ----------------------------
DROP TABLE IF EXISTS `zipkin_annotations`;
CREATE TABLE `zipkin_annotations`  (
  `trace_id_high` bigint(20) NOT NULL DEFAULT 0 COMMENT 'If non zero, this means the trace uses 128 bit traceIds instead of 64 bit',
  `trace_id` bigint(20) NOT NULL COMMENT 'coincides with zipkin_spans.trace_id',
  `span_id` bigint(20) NOT NULL COMMENT 'coincides with zipkin_spans.id',
  `a_key` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'BinaryAnnotation.key or Annotation.value if type == -1',
  `a_value` blob NULL COMMENT 'BinaryAnnotation.value(), which must be smaller than 64KB',
  `a_type` int(11) NOT NULL COMMENT 'BinaryAnnotation.type() or -1 if Annotation',
  `a_timestamp` bigint(20) NULL DEFAULT NULL COMMENT 'Used to implement TTL; Annotation.timestamp or zipkin_spans.timestamp',
  `endpoint_ipv4` int(11) NULL DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null',
  `endpoint_ipv6` binary(16) NULL DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null, or no IPv6 address',
  `endpoint_port` smallint(6) NULL DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null',
  `endpoint_service_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null',
  UNIQUE INDEX `trace_id_high`(`trace_id_high`, `trace_id`, `span_id`, `a_key`, `a_timestamp`) USING BTREE COMMENT 'Ignore insert on duplicate',
  INDEX `trace_id_high_2`(`trace_id_high`, `trace_id`, `span_id`) USING BTREE COMMENT 'for joining with zipkin_spans',
  INDEX `trace_id_high_3`(`trace_id_high`, `trace_id`) USING BTREE COMMENT 'for getTraces/ByIds',
  INDEX `endpoint_service_name`(`endpoint_service_name`) USING BTREE COMMENT 'for getTraces and getServiceNames',
  INDEX `a_type`(`a_type`) USING BTREE COMMENT 'for getTraces and autocomplete values',
  INDEX `a_key`(`a_key`) USING BTREE COMMENT 'for getTraces and autocomplete values',
  INDEX `trace_id`(`trace_id`, `span_id`, `a_key`) USING BTREE COMMENT 'for dependencies job'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for zipkin_dependencies
-- ----------------------------
DROP TABLE IF EXISTS `zipkin_dependencies`;
CREATE TABLE `zipkin_dependencies`  (
  `day` date NOT NULL,
  `parent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `child` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `call_count` bigint(20) NULL DEFAULT NULL,
  `error_count` bigint(20) NULL DEFAULT NULL,
  UNIQUE INDEX `day`(`day`, `parent`, `child`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for zipkin_spans
-- ----------------------------
DROP TABLE IF EXISTS `zipkin_spans`;
CREATE TABLE `zipkin_spans`  (
  `trace_id_high` bigint(20) NOT NULL DEFAULT 0 COMMENT 'If non zero, this means the trace uses 128 bit traceIds instead of 64 bit',
  `trace_id` bigint(20) NOT NULL,
  `id` bigint(20) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `parent_id` bigint(20) NULL DEFAULT NULL,
  `debug` bit(1) NULL DEFAULT NULL,
  `start_ts` bigint(20) NULL DEFAULT NULL COMMENT 'Span.timestamp(): epoch micros used for endTs query and to implement TTL',
  `duration` bigint(20) NULL DEFAULT NULL COMMENT 'Span.duration(): micros used for minDuration and maxDuration query',
  UNIQUE INDEX `trace_id_high`(`trace_id_high`, `trace_id`, `id`) USING BTREE COMMENT 'ignore insert on duplicate',
  INDEX `trace_id_high_2`(`trace_id_high`, `trace_id`, `id`) USING BTREE COMMENT 'for joining with zipkin_annotations',
  INDEX `trace_id_high_3`(`trace_id_high`, `trace_id`) USING BTREE COMMENT 'for getTracesByIds',
  INDEX `name`(`name`) USING BTREE COMMENT 'for getTraces and getSpanNames',
  INDEX `start_ts`(`start_ts`) USING BTREE COMMENT 'for getTraces ordering and range'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
