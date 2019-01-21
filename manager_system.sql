/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : manager_system

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2019-01-21 18:09:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `class_method` varchar(255) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `method` varchar(255) DEFAULT NULL,
  `operation_date` varchar(255) DEFAULT NULL,
  `operation_id` bigint(20) DEFAULT NULL,
  `params` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `resource_id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL,
  `resource_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `permission` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `create_date` varchar(255) DEFAULT NULL,
  `update_date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=142 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES ('1', '0', '系统管理', '系统管理', null, null, '0', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('2', '1', '管理员列表', '管理员列表', 'sys:user:list', 'sys/user/list', '1', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('3', '1', '角色管理', '角色管理', 'sys:role:list', 'sys/role/list', '1', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('4', '1', '菜单管理', '菜单管理', 'sys:resource:list', 'sys/resource/list', '1', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('5', '2', '查看', '查看管理员', 'sys:user:show', null, '2', '2018年12月27日16:24:07', '');
INSERT INTO `sys_resource` VALUES ('6', '2', '新增', '新增管理员', 'sys:user:add', null, '2', '2018年12月27日16:24:07', '');
INSERT INTO `sys_resource` VALUES ('7', '2', '修改', '修改管理员', 'sys:user:edit', null, '2', '2018年12月27日16:24:07', '');
INSERT INTO `sys_resource` VALUES ('8', '2', '删除', '删除管理员', 'sys:user:delete', null, '2', '2018年12月27日16:24:07', '');
INSERT INTO `sys_resource` VALUES ('9', '3', '查看', '查看角色', 'sys:role:show', null, '2', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('10', '3', '新增', '新增角色', 'sys:role:add', null, '2', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('11', '3', '修改', '修改角色', 'sys:role:edit', null, '2', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('12', '3', '删除', '删除角色', 'sys:role:delete', null, '2', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('13', '4', '查看', '查看菜单', 'sys:resource:show', null, '2', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('14', '4', '新增', '新增菜单', 'sys:resource:add', null, '2', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('15', '4', '修改', '修改菜单', 'sys:resource:edit', null, '2', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('16', '4', '删除', '删除菜单', 'sys:resource:delete', null, '2', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('17', '1', '参数管理', '参数管理', 'sys:config:list', 'sys/config/list', '1', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('18', '1', '系统日志', '系统日志', 'sys:log:list', 'sys/log/list', '1', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('19', '1', '地区管理', '地区管理', 'area:list', 'area/list', '1', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('20', null, '查看', '查看地区', 'area:show', null, '2', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('21', null, '新增', '新增地区', 'area:add', null, '2', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('22', null, '修改', '修改地区', 'area:edit', null, '2', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('23', null, '删除', '删除地区', 'area:delete', null, '2', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('24', '1', '字典管理', '字典管理', null, null, '1', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('25', null, '查看', '查看字典', null, null, '2', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('26', null, '新增', '新增字典', null, null, '2', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('27', null, '修改', '修改字典', null, null, '2', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('28', null, '删除', '删除字典', null, null, '2', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('29', '1', '部门管理', '部门管理', null, null, '1', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('30', null, '查看', '查看部门', null, null, '2', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('31', null, '新增', '新增部门', null, null, '2', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('32', null, '修改', '修改部门', null, null, '2', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('33', null, '删除', '删除部门', null, null, '2', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('34', '1', 'oss配置', 'oss配置', null, null, '1', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('35', null, '查看', '查看', null, null, '2', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('36', null, '新增', '新增', null, null, '2', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('37', null, '修改', '修改', null, null, '2', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('38', null, '删除', '删除', null, null, '2', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('39', '0', '开发工具', '开发工具', null, null, '0', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('40', '39', '代码生成器', '代码生成器', null, '/sys/generator/list', '1', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('41', '39', 'sql监控', 'sql监控', null, '/druid/sql.html', '1', '2018年12月27日16:24:07', null);
INSERT INTO `sys_resource` VALUES ('42', '39', 'api接口文档', 'api接口文档', null, '/swagger-ui.html', '1', '2018年12月27日16:24:07', null);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `create_date` varchar(255) DEFAULT NULL,
  `update_date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员', '拥有所有权限', '2018年12月25日15:40:55', '2018年12月25日15:40:58');
INSERT INTO `sys_role` VALUES ('2', '用户管理员', '管理用户', '2018年12月25日15:41:25', '2018年12月25日15:41:26');
INSERT INTO `sys_role` VALUES ('3', '系统管理员', '管理系统设置', '2018年12月25日15:42:05', '2018年12月25日15:42:06');

-- ----------------------------
-- Table structure for sys_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resource`;
CREATE TABLE `sys_role_resource` (
  `role_id` int(11) NOT NULL,
  `resource_id` int(11) NOT NULL,
  KEY `FKkj7e3cva1e2s3nsd0yghpbsnk` (`resource_id`),
  KEY `FK7urjh5xeujvp29nihwbs5b9kr` (`role_id`),
  CONSTRAINT `sys_role_resource_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`),
  CONSTRAINT `sys_role_resource_ibfk_2` FOREIGN KEY (`resource_id`) REFERENCES `sys_resource` (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of sys_role_resource
-- ----------------------------
INSERT INTO `sys_role_resource` VALUES ('1', '25');
INSERT INTO `sys_role_resource` VALUES ('1', '14');
INSERT INTO `sys_role_resource` VALUES ('1', '15');
INSERT INTO `sys_role_resource` VALUES ('1', '16');
INSERT INTO `sys_role_resource` VALUES ('1', '17');
INSERT INTO `sys_role_resource` VALUES ('1', '18');
INSERT INTO `sys_role_resource` VALUES ('1', '19');
INSERT INTO `sys_role_resource` VALUES ('1', '20');
INSERT INTO `sys_role_resource` VALUES ('1', '21');
INSERT INTO `sys_role_resource` VALUES ('1', '22');
INSERT INTO `sys_role_resource` VALUES ('1', '23');
INSERT INTO `sys_role_resource` VALUES ('1', '24');
INSERT INTO `sys_role_resource` VALUES ('1', '1');
INSERT INTO `sys_role_resource` VALUES ('1', '2');
INSERT INTO `sys_role_resource` VALUES ('1', '3');
INSERT INTO `sys_role_resource` VALUES ('1', '4');
INSERT INTO `sys_role_resource` VALUES ('1', '5');
INSERT INTO `sys_role_resource` VALUES ('1', '6');
INSERT INTO `sys_role_resource` VALUES ('1', '7');
INSERT INTO `sys_role_resource` VALUES ('1', '8');
INSERT INTO `sys_role_resource` VALUES ('1', '9');
INSERT INTO `sys_role_resource` VALUES ('1', '10');
INSERT INTO `sys_role_resource` VALUES ('1', '11');
INSERT INTO `sys_role_resource` VALUES ('1', '12');
INSERT INTO `sys_role_resource` VALUES ('1', '13');
INSERT INTO `sys_role_resource` VALUES ('1', '26');
INSERT INTO `sys_role_resource` VALUES ('1', '27');
INSERT INTO `sys_role_resource` VALUES ('1', '28');
INSERT INTO `sys_role_resource` VALUES ('1', '29');
INSERT INTO `sys_role_resource` VALUES ('1', '30');
INSERT INTO `sys_role_resource` VALUES ('1', '31');
INSERT INTO `sys_role_resource` VALUES ('1', '32');
INSERT INTO `sys_role_resource` VALUES ('1', '33');
INSERT INTO `sys_role_resource` VALUES ('1', '34');
INSERT INTO `sys_role_resource` VALUES ('1', '35');
INSERT INTO `sys_role_resource` VALUES ('1', '36');
INSERT INTO `sys_role_resource` VALUES ('1', '37');
INSERT INTO `sys_role_resource` VALUES ('1', '38');
INSERT INTO `sys_role_resource` VALUES ('1', '39');
INSERT INTO `sys_role_resource` VALUES ('1', '40');
INSERT INTO `sys_role_resource` VALUES ('1', '41');
INSERT INTO `sys_role_resource` VALUES ('1', '42');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `mobile` varchar(11) DEFAULT NULL,
  `status` smallint(6) DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `create_date` varchar(255) DEFAULT NULL,
  `update_date` varchar(255) DEFAULT NULL,
  `remake` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '202cb962ac59075b964b07152d234b70', '17864308125', '1', '1365992340@qq.com', '2018年12月17日16:49:27', '2018年12月17日16:49:33', '超级');
INSERT INTO `sys_user` VALUES ('2', 'uadmin', '202cb962ac59075b964b07152d234b70', '99999999999', '1', null, null, null, '用户');
INSERT INTO `sys_user` VALUES ('3', 'sadmin', '202cb962ac59075b964b07152d234b70', '00000000000', '1', null, null, null, '系统');
INSERT INTO `sys_user` VALUES ('65', 'admin1', '202cb962ac59075b964b07152d234b70', '2147483647', '1', null, '2018年12月17日16:49:27', '2018年12月17日16:49:33', '超级');
INSERT INTO `sys_user` VALUES ('66', 'uadmin1', '202cb962ac59075b964b07152d234b70', '2147483647', '1', null, '', '', '用户');
INSERT INTO `sys_user` VALUES ('67', 'sadmin1', '202cb962ac59075b964b07152d234b70', '2147483647', '1', null, '', '', '系统');
INSERT INTO `sys_user` VALUES ('68', 'admin2', '202cb962ac59075b964b07152d234b70', '2147483647', '1', null, '2018年12月17日16:49:27', '2018年12月17日16:49:33', '超级');
INSERT INTO `sys_user` VALUES ('69', 'uadmin2', '202cb962ac59075b964b07152d234b70', '2147483647', '1', null, '', '', '用户');
INSERT INTO `sys_user` VALUES ('70', 'sadmin2', '202cb962ac59075b964b07152d234b70', '2147483647', '1', null, '', '', '系统');
INSERT INTO `sys_user` VALUES ('71', 'admin3', '202cb962ac59075b964b07152d234b70', '2147483647', '1', null, '2018年12月17日16:49:27', '2018年12月17日16:49:33', '超级');
INSERT INTO `sys_user` VALUES ('72', 'uadmin3', '202cb962ac59075b964b07152d234b70', '2147483647', '1', null, '', '', '用户');
INSERT INTO `sys_user` VALUES ('73', 'sadmin3', '202cb962ac59075b964b07152d234b70', '2147483647', '1', null, '', '', '系统');
INSERT INTO `sys_user` VALUES ('74', 'admin11', '202cb962ac59075b964b07152d234b70', '2147483647', '1', null, '2018年12月17日16:49:27', '2018年12月17日16:49:33', '超级');
INSERT INTO `sys_user` VALUES ('75', 'uadmin11', '202cb962ac59075b964b07152d234b70', '2147483647', '1', null, '', '', '用户');
INSERT INTO `sys_user` VALUES ('76', 'sadmin11', '202cb962ac59075b964b07152d234b70', '2147483647', '1', null, '', '', '系统');
INSERT INTO `sys_user` VALUES ('77', 'admin22', '202cb962ac59075b964b07152d234b70', '2147483647', '1', null, '2018年12月17日16:49:27', '2018年12月17日16:49:33', '超级');
INSERT INTO `sys_user` VALUES ('78', 'uadmin22', '202cb962ac59075b964b07152d234b70', '2147483647', '1', null, '', '', '用户');
INSERT INTO `sys_user` VALUES ('79', 'sadmin22', '202cb962ac59075b964b07152d234b70', '2147483647', '1', null, '', '', '系统');
INSERT INTO `sys_user` VALUES ('80', 'admin33', '202cb962ac59075b964b07152d234b70', '2147483647', '1', null, '2018年12月17日16:49:27', '2018年12月17日16:49:33', '超级');
INSERT INTO `sys_user` VALUES ('81', 'uadmin33', '202cb962ac59075b964b07152d234b70', '2147483647', '1', null, '', '', '用户');
INSERT INTO `sys_user` VALUES ('82', 'sadmin33', '202cb962ac59075b964b07152d234b70', '2147483647', '1', null, '', '', '系统');
INSERT INTO `sys_user` VALUES ('83', 'admin111', '202cb962ac59075b964b07152d234b70', '2147483647', '1', null, '2018年12月17日16:49:27', '2018年12月17日16:49:33', '超级');
INSERT INTO `sys_user` VALUES ('84', 'uadmin111', '202cb962ac59075b964b07152d234b70', '2147483647', '1', null, '', '', '用户');
INSERT INTO `sys_user` VALUES ('85', 'sadmin111', '202cb962ac59075b964b07152d234b70', '2147483647', '1', null, '', '', '系统');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `role_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  KEY `FKb40xxfch70f5qnyfw8yme1n1s` (`user_id`),
  KEY `FKhh52n8vd4ny9ff4x9fb8v65qx` (`role_id`),
  CONSTRAINT `sys_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`),
  CONSTRAINT `sys_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2');
INSERT INTO `sys_user_role` VALUES ('3', '3');
