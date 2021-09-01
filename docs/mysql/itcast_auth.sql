/*
 Source Server Type    : MySQL
 Source Server Version : 80020
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for itcast_application
-- ----------------------------
DROP TABLE IF EXISTS `itcast_application`;
CREATE TABLE `itcast_application` (
                                      `id` bigint NOT NULL COMMENT 'ID',
                                      `name` varchar(100)  NOT NULL DEFAULT '' COMMENT '名称',
                                      `status` bit(1) DEFAULT b'1' COMMENT '状态',
                                      `describe_` varchar(255) DEFAULT '' COMMENT '描述',
                                      `url` varchar(255) DEFAULT NULL COMMENT '路径',
                                      `color` varchar(255) DEFAULT NULL COMMENT '颜色',
                                      `logo` longtext COMMENT 'logo图片',
                                      `create_time` datetime DEFAULT NULL,
                                      `create_user` bigint DEFAULT NULL,
                                      `update_time` datetime DEFAULT NULL,
                                      `update_user` bigint DEFAULT NULL,
                                      PRIMARY KEY (`id`) USING BTREE,
                                      UNIQUE KEY `index_app_name` (`name`)
) ENGINE=InnoDB  ROW_FORMAT=COMPACT COMMENT='应用';

-- ----------------------------
-- Records of itcast_application
-- ----------------------------
BEGIN;
INSERT INTO `itcast_application` VALUES (819609733802491937, '品达物流', b'1', '品达物流', NULL, NULL, NULL, '2021-03-12 08:36:28', 0, '2021-08-23 15:04:41', 1);
INSERT INTO `itcast_application` VALUES (819611999649398913, '集信达', b'0', '一个提供发送短信服务的短信聚合平台，它聚合了包括阿里、华为', NULL, 'theme-red', NULL, '2021-03-12 08:45:29', 0, '2021-08-23 15:04:37', 1);
INSERT INTO `itcast_application` VALUES (829772421929117665, '黑马头条', b'1', '一款基于个性化推荐引擎技术，根据每个用户的兴趣、爱好等多个\n', NULL, 'theme-green', NULL, '2021-04-08 17:39:22', 1, '2021-08-23 14:51:57', 1);
INSERT INTO `itcast_application` VALUES (829772506662447169, '青橙', b'1', '属于全品类B2C电商系统，分为网站前台和管理后台。', NULL, NULL, NULL, '2021-04-09 01:39:42', 1, '2021-08-23 14:51:47', 1);
INSERT INTO `itcast_application` VALUES (831890820348164641, '传智健康', b'1', '一款应用于健康管理机构的业务系统，实现健康管理机构\n工作内容', NULL, NULL, NULL, '2021-04-14 13:57:08', 1, '2021-08-23 14:51:30', 1);
INSERT INTO `itcast_application` VALUES (831890921313450625, '闪聚支付', b'1', '一个提供聚合支付的平台，聚合支付目前主要的做法就是线上聚\n合', NULL, NULL, NULL, '2021-04-14 13:57:32', 1, '2021-08-23 14:51:17', 1);
INSERT INTO `itcast_application` VALUES (834003593324413697, '畅购', b'1', '一个B2C商城，B2C商城目前属于市面上高薪的主流项目。', NULL, NULL, NULL, '2021-04-20 09:52:32', 1, '2021-08-23 14:49:54', 1);
INSERT INTO `itcast_application` VALUES (834728079367610721, '品优购', b'1', '属于B2B2C电商，类似于京东、天猫等运营模式，商家可以申请', NULL, 'default', NULL, '2021-04-22 09:51:23', 1, '2021-08-23 14:50:54', 1);
INSERT INTO `itcast_application` VALUES (835090007927576481, '智牛谷', b'1', '一个提供沪深股票实时高速行情、支持在线安全模拟交易服务、精选', NULL, NULL, NULL, '2021-04-23 09:49:33', 1, '2021-08-23 14:52:38', 1);
INSERT INTO `itcast_application` VALUES (856958443553031905, '流程审批中心', b'1', 'Activiti7 流程审批中心', NULL, 'theme-purple', 'data:image/png;base64,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', '2021-06-22 18:06:55', 1, '2021-08-12 20:37:00', 1);
INSERT INTO `itcast_application` VALUES (879377986862749857, '万信金融', b'1', '一款基于互联网的网络借贷平台，有资金并且有理财投资想法的个人', NULL, NULL, NULL, '2021-08-23 14:54:10', 1, '2021-08-23 14:54:10', 1);
INSERT INTO `itcast_application` VALUES (879378196670224641, '探花交友', b'1', '一个在线社交平台，内置了 “一键打招呼”、“左滑右滑”、“小', NULL, NULL, NULL, '2021-08-23 14:55:00', 1, '2021-08-23 14:55:00', 1);
INSERT INTO `itcast_application` VALUES (879378303536896353, '亿可控', b'1', '一个物联网设备监控系统，能够对各种硬件设备进行远程监控，上报', NULL, NULL, NULL, '2021-08-23 14:55:26', 1, '2021-08-23 14:55:26', 1);
INSERT INTO `itcast_application` VALUES (879378447342803393, '元蜂WMS', b'1', '支持多仓库，多货主，多业务模式，及支持库内、出库、入库多种作', NULL, NULL, NULL, '2021-08-23 14:56:00', 1, '2021-08-23 14:56:00', 1);
INSERT INTO `itcast_application` VALUES (879380421530393121, '康云医药', b'1', '利用计算机信息网络技术为医药卫生行业服务的电子交易系统', NULL, NULL, NULL, '2021-08-23 15:03:51', 1, '2021-08-23 15:03:51', 1);
INSERT INTO `itcast_application` VALUES (879380532578785921, '充吧', b'1', '是传统电商常见业务之一，相对于实物电商业务，虚拟业务最大特点', NULL, NULL, NULL, '2021-08-23 15:04:17', 1, '2021-08-23 15:04:17', 1);
COMMIT;

-- ----------------------------
-- Table structure for itcast_auth_menu
-- ----------------------------
DROP TABLE IF EXISTS `itcast_auth_menu`;
CREATE TABLE `itcast_auth_menu` (
                                    `id` bigint NOT NULL COMMENT '主键',
                                    `name` varchar(20) NOT NULL DEFAULT '' COMMENT '菜单名称',
                                    `describe_` varchar(200) DEFAULT '' COMMENT '功能描述',
                                    `is_public` bit(1) DEFAULT b'0' COMMENT '是否公开菜单\r\n就是无需分配就可以访问的。所有人可见',
                                    `path` varchar(255) DEFAULT '' COMMENT '对应路由path',
                                    `component` varchar(255) DEFAULT NULL COMMENT '对应路由组件component',
                                    `is_enable` bit(1) DEFAULT b'1' COMMENT '状态',
                                    `sort_value` int DEFAULT '1' COMMENT '排序',
                                    `icon` varchar(255) DEFAULT '' COMMENT '菜单图标',
                                    `group_` varchar(20) DEFAULT '' COMMENT '菜单分组',
                                    `application_id` bigint DEFAULT NULL COMMENT '应用id',
                                    `parent_id` bigint DEFAULT '0' COMMENT '父级菜单id',
                                    `create_user` bigint DEFAULT NULL COMMENT '创建人id',
                                    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                    `update_user` bigint DEFAULT NULL COMMENT '更新人id',
                                    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                    PRIMARY KEY (`id`) USING BTREE,
                                    UNIQUE KEY `PAM_name` (`name`,`application_id`) USING BTREE,
                                    KEY `INX_STATUS` (`is_enable`,`is_public`) USING BTREE
) ENGINE=InnoDB  ROW_FORMAT=COMPACT COMMENT='菜单';

-- ----------------------------
-- Records of itcast_auth_menu
-- ----------------------------
BEGIN;
INSERT INTO `itcast_auth_menu` VALUES (101, '用户管理', '系统管理', b'0', '/user', '/user/index', b'1', 1, 'el-icon-user-solid', '', 1, 0, 1, '2019-08-20 23:35:12', 1, '2021-08-17 14:07:26');
INSERT INTO `itcast_auth_menu` VALUES (104, '监控管理', '开发者', b'0', '/developer', '/developer/index', b'1', 6, 'el-icon-user-solid', '', 1, 0, 1, '2019-12-08 06:38:34', 1, '2021-04-12 18:23:14');
INSERT INTO `itcast_auth_menu` VALUES (603976297063910529, '菜单配置', '', b'0', '/menu', '/menu/index', b'1', 2, 'el-icon-tickets', '', 1, 0, 1, '2019-08-07 23:46:11', 1, '2021-08-11 10:58:49');
INSERT INTO `itcast_auth_menu` VALUES (603981723864141121, '角色管理', '', b'0', '/role', '/role/index', b'1', 2, 'el-icon-s-custom', '', 1, 0, 1, '2019-08-10 00:07:45', 1, '2021-04-14 00:48:00');
INSERT INTO `itcast_auth_menu` VALUES (603982542332235201, '组织管理', '', b'0', '/organization', '/organization/index', b'1', 3, 'el-icon-s-flag', '', 1, 0, 1, '2019-08-06 16:11:00', 1, '2021-04-14 00:50:26');
INSERT INTO `itcast_auth_menu` VALUES (603982713849908801, '岗位管理', '', b'0', '/post', '/post/index', b'1', 4, 'el-icon-s-platform', '', 1, 0, 1, '2019-08-07 00:11:41', 1, '2021-04-08 02:12:12');
INSERT INTO `itcast_auth_menu` VALUES (603983082961243905, '普通用户管理', '', b'0', '/users/user-list', '/users/user-list/index', b'1', 0, '', '', 1, 101, 1, '2019-08-06 16:13:09', 1, '2021-08-17 14:07:26');
INSERT INTO `itcast_auth_menu` VALUES (605078672772170209, '操作日志', '', b'0', '/monitoring/log-operation', '/monitoring/log-operation/index', b'1', 1, '', '', 1, 104, 1, '2019-08-01 00:46:38', 1, '2021-04-01 10:09:52');
INSERT INTO `itcast_auth_menu` VALUES (645215230518909025, '登录日志', '', b'0', '/monitoring/log-login', '/monitoring/log-login/index', b'1', 0, '', '', 1, 104, 3, '2019-11-19 18:54:59', 1, '2021-04-01 10:09:52');
INSERT INTO `itcast_auth_menu` VALUES (820229424300438465, '用户组管理', '系统管理', b'0', '/users/user-group', '/users/user-group/index', b'1', 1, '', '', 1, 101, 3, '2021-03-19 09:38:54', 1, '2021-08-17 14:07:26');
INSERT INTO `itcast_auth_menu` VALUES (829717676565049825, '应用管理', '', b'0', '/adhibition', '/adhibition/index', b'1', 5, 'el-icon-menu', '', 1, 0, 1, '2021-04-08 22:01:50', 1, '2021-04-14 00:47:35');
INSERT INTO `itcast_auth_menu` VALUES (834002593268115937, '首页', '', b'0', '/dashboard', '/dashboard/index', b'1', 0, 'el-icon-house', '', 1, 0, 1, '2021-04-20 17:48:33', 1, '2021-04-20 22:02:14');
INSERT INTO `itcast_auth_menu` VALUES (856959482712824161, '流程中心', '', b'0', '/', '//index', b'1', 2, 'el-icon-set-up', '', 856958443553031905, 0, 856959053190927169, '2021-06-22 18:11:02', 856959053190927169, '2021-07-16 18:24:51');
INSERT INTO `itcast_auth_menu` VALUES (857938224469811329, '业务中心', '', b'0', '/', '//index', b'1', 1, 'el-icon-office-building', '', 856958443553031905, 0, 856959053190927169, '2021-06-25 11:00:13', 856959053190927169, '2021-07-16 18:24:44');
INSERT INTO `itcast_auth_menu` VALUES (857938392577515841, '请假管理', '', b'0', '/office/leave-manage', '/office/leave-manage/index', b'1', 0, 'el-icon-document-add', '', 856958443553031905, 857938224469811329, 856959053190927169, '2021-06-25 11:00:53', 856959053190927169, '2021-07-16 18:24:44');
INSERT INTO `itcast_auth_menu` VALUES (857938631489266177, '待办管理', '', b'0', '/office/my-todo-task', '/office/my-todo-task/index', b'1', 2, 'el-icon-document', '', 856958443553031905, 865660192518335553, 856959053190927169, '2021-06-25 11:01:50', 856959053190927169, '2021-07-16 18:26:38');
INSERT INTO `itcast_auth_menu` VALUES (857938895436817281, '已办管理', '', b'0', '/office/my-join-task', '/office/my-join-task/index', b'1', 3, 'el-icon-document-checked', '', 856958443553031905, 865660192518335553, 856959053190927169, '2021-06-25 11:02:53', 856959053190927169, '2021-07-16 18:26:38');
INSERT INTO `itcast_auth_menu` VALUES (863081063625264673, '抄送我的', '', b'0', '/office/my-send-task', '/office/my-send-task/index', b'1', 4, 'el-icon-chat-line-square', '', 856958443553031905, 865660192518335553, 856959053190927169, '2021-07-09 15:36:01', 856959053190927169, '2021-07-16 18:26:38');
INSERT INTO `itcast_auth_menu` VALUES (864827475257992705, '报销管理', '', b'0', '/office/reimbursement-manage', '/office/reimbursement-manage/index', b'1', 1, 'el-icon-notebook-2', '', 856958443553031905, 857938224469811329, 856959053190927169, '2021-07-14 11:15:38', 856959053190927169, '2021-07-16 18:24:44');
INSERT INTO `itcast_auth_menu` VALUES (865660192518335553, '我的任务', '', b'0', '/', '//index', b'1', 0, 'el-icon-document', '', 856958443553031905, 0, 856959053190927169, '2021-07-16 18:24:33', 856959053190927169, '2021-07-16 18:26:38');
INSERT INTO `itcast_auth_menu` VALUES (866641193251944449, '模型管理', '', b'0', '/activiti/model', '/activiti/model/index', b'1', 1, '', '', 856958443553031905, 856959482712824161, 856959053190927169, '2021-07-19 11:22:42', 856959053190927169, '2021-07-19 11:22:42');
INSERT INTO `itcast_auth_menu` VALUES (877216131566273217, '权限管理', '', b'0', '/', '//index', b'1', 0, 'el-icon-setting', '', 831890921313450625, 0, 877215047032506913, '2021-08-17 15:43:44', 877215047032506913, '2021-08-17 16:01:39');
COMMIT;

-- ----------------------------
-- Table structure for itcast_auth_resource
-- ----------------------------
DROP TABLE IF EXISTS `itcast_auth_resource`;
CREATE TABLE `itcast_auth_resource` (
                                        `id` bigint NOT NULL COMMENT 'ID',
                                        `code` varchar(150) DEFAULT '' COMMENT '资源编码\n规则：\n链接：\n数据列：\n按钮：',
                                        `name` varchar(150) NOT NULL DEFAULT '' COMMENT '接口名称',
                                        `menu_id` bigint DEFAULT NULL COMMENT '菜单ID\n#c_auth_menu',
                                        `method` varchar(10) DEFAULT NULL,
                                        `url` varchar(255) DEFAULT NULL,
                                        `describe_` varchar(255) DEFAULT '' COMMENT '接口描述',
                                        `application_id` bigint DEFAULT NULL COMMENT '应用id',
                                        `create_user` bigint DEFAULT NULL COMMENT '创建人id',
                                        `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                        `update_user` bigint DEFAULT NULL COMMENT '更新人id',
                                        `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                        PRIMARY KEY (`id`) USING BTREE,
                                        UNIQUE KEY `UN_CODE` (`code`) USING BTREE COMMENT '编码唯一'
) ENGINE=InnoDB  ROW_FORMAT=COMPACT COMMENT='资源';

-- ----------------------------
-- Records of itcast_auth_resource
-- ----------------------------
BEGIN;
INSERT INTO `itcast_auth_resource` VALUES (643444685339100193, 'org:add', '添加', 603982542332235201, 'POST', '/org', '', 1, 3, '2019-11-12 13:39:28', 3, '2019-11-12 13:39:50');
INSERT INTO `itcast_auth_resource` VALUES (643444685339100194, 'role:config', '配置', 603981723864141121, 'POST', '/role/authority', '', 1, 3, '2019-11-12 13:39:28', 3, '2020-03-04 19:57:51');
INSERT INTO `itcast_auth_resource` VALUES (643444685339100195, 'resource:add', '添加资源', 603976297063910529, 'POST', '/resource', '', 1, 3, '2019-11-12 13:39:28', 1, '2021-03-20 01:47:26');
INSERT INTO `itcast_auth_resource` VALUES (643444685339100196, 'resource:update', '修改资源', 603976297063910529, 'PUT', '/resource', '', 1, 3, '2019-11-12 13:39:28', 1, '2021-03-20 01:47:34');
INSERT INTO `itcast_auth_resource` VALUES (643444685339100197, 'resource:delete', '删除资源', 603976297063910529, 'DELETE', '/resource', '', 1, 3, '2019-11-12 13:39:28', 1, '2021-03-20 01:47:40');
INSERT INTO `itcast_auth_resource` VALUES (643444819758154945, 'org:update', '修改', 603982542332235201, 'PUT', '/org', '', 1, 3, '2019-11-12 13:40:00', 3, '2019-11-12 13:40:00');
INSERT INTO `itcast_auth_resource` VALUES (643444858974897441, 'org:delete', '删除', 603982542332235201, 'DELETE', '/org', '', 1, 3, '2019-11-12 13:40:09', 3, '2019-11-12 13:40:09');
INSERT INTO `itcast_auth_resource` VALUES (643444897201784193, 'org:tree', '组织树', 603982542332235201, 'GET', '/org/tree', '', 1, 3, '2019-11-12 13:40:18', 3, '2020-03-04 19:53:41');
INSERT INTO `itcast_auth_resource` VALUES (643445116756821697, 'station:add', '添加', 603982713849908801, 'POST', '/station', '', 1, 3, '2019-11-12 13:41:11', 3, '2019-11-12 13:41:11');
INSERT INTO `itcast_auth_resource` VALUES (643445162915137313, 'station:update', '修改', 603982713849908801, 'PUT', '/station', '', 1, 3, '2019-11-12 13:41:22', 3, '2019-11-12 13:41:22');
INSERT INTO `itcast_auth_resource` VALUES (643445197954353025, 'station:delete', '删除', 603982713849908801, 'DELETE', '/station', '', 1, 3, '2019-11-12 13:41:30', 3, '2019-11-12 13:41:30');
INSERT INTO `itcast_auth_resource` VALUES (643445229575210977, 'station:page', '分页', 603982713849908801, 'GET', '/station/page', '', 1, 3, '2019-11-12 13:41:38', 3, '2020-04-10 09:21:06');
INSERT INTO `itcast_auth_resource` VALUES (643445352703199521, 'user:add', '添加', 603983082961243905, 'POST', '/user', '', 1, 3, '2019-11-12 13:42:07', 3, '2020-03-10 21:34:38');
INSERT INTO `itcast_auth_resource` VALUES (643445412774021505, 'user:update', '修改', 603983082961243905, 'PUT', '/user/**', '', 1, 3, '2019-11-12 13:42:21', 3, '2020-06-24 07:56:10');
INSERT INTO `itcast_auth_resource` VALUES (643445448081672673, 'user:delete', '删除', 603983082961243905, 'DELETE', '/user', '', 1, 3, '2019-11-12 13:42:30', 3, '2019-11-12 13:42:30');
INSERT INTO `itcast_auth_resource` VALUES (643445477274028609, 'user:page', '分页', 603983082961243905, 'GET', '/user/page', '', 1, 3, '2019-11-12 13:42:37', 1, '2021-08-13 17:40:15');
INSERT INTO `itcast_auth_resource` VALUES (643445514607528609, 'user:import', '导入', 603983082961243905, 'POST', '/user/importExcel', '', 1, 3, '2019-11-12 13:42:46', 822139309904628833, '2021-03-19 16:40:48');
INSERT INTO `itcast_auth_resource` VALUES (643445641149680705, 'menu:add', '添加菜单', 603976297063910529, 'POST', '/menu', '', 1, 3, '2019-11-12 13:43:16', 1, '2021-03-20 01:47:50');
INSERT INTO `itcast_auth_resource` VALUES (643445674330819745, 'menu:update', '修改菜单', 603976297063910529, 'PUT', '/menu', '', 1, 3, '2019-11-12 13:43:24', 1, '2021-03-20 01:47:54');
INSERT INTO `itcast_auth_resource` VALUES (643445704177487105, 'menu:delete', '删除菜单', 603976297063910529, 'DELETE', '/menu', '', 1, 3, '2019-11-12 13:43:31', 1, '2021-03-20 01:48:00');
INSERT INTO `itcast_auth_resource` VALUES (643448338154263521, 'role:add', '添加', 603981723864141121, 'POST', '/role', '', 1, 3, '2019-11-12 13:53:59', 3, '2019-11-12 13:53:59');
INSERT INTO `itcast_auth_resource` VALUES (643448369779315777, 'role:update', '修改', 603981723864141121, 'PUT', '/role', '', 1, 3, '2019-11-12 13:54:06', 3, '2019-11-12 13:54:06');
INSERT INTO `itcast_auth_resource` VALUES (643448507767723169, 'role:delete', '删除', 603981723864141121, 'DELETE', '/role', '', 1, 3, '2019-11-12 13:54:39', 3, '2019-11-12 13:54:39');
INSERT INTO `itcast_auth_resource` VALUES (643448611161511169, 'role:page', '分页', 603981723864141121, 'GET', '/role/page', '', 1, 3, '2019-11-12 13:55:04', 3, '2020-03-04 19:55:44');
INSERT INTO `itcast_auth_resource` VALUES (643448826945869409, 'role:auth', '授权', 603981723864141121, 'POST', '/role/user', '', 1, 3, '2019-11-12 13:55:55', 3, '2020-03-04 19:57:57');
INSERT INTO `itcast_auth_resource` VALUES (643450770317909249, 'optLog:view', '查看', 605078672772170209, 'GET', '/optLog/page', '', 1, 3, '2019-11-12 14:03:39', 3, '2020-03-10 21:45:24');
INSERT INTO `itcast_auth_resource` VALUES (643450853134441825, 'optLog:export', '导出', 605078672772170209, 'GET', '/optLog', '', 1, 3, '2019-11-12 14:03:58', 3, '2019-11-12 14:03:58');
INSERT INTO `itcast_auth_resource` VALUES (645288214990422241, 'optLog:delete', '删除', 605078672772170209, 'DELETE', '/optLog', '', 1, 3, '2019-11-17 15:45:00', 3, '2019-11-17 15:45:00');
INSERT INTO `itcast_auth_resource` VALUES (645288283693121889, 'loginLog:delete', '删除', 645215230518909025, 'DELETE', '/loginLog', '', 1, 3, '2019-11-17 15:45:16', 3, '2019-11-17 15:45:16');
INSERT INTO `itcast_auth_resource` VALUES (645288375300915649, 'loginLog:export', '导出', 645215230518909025, 'GET', '/loginLog', '', 1, 3, '2019-11-17 15:45:38', 3, '2019-11-17 15:45:38');
INSERT INTO `itcast_auth_resource` VALUES (684536767625301441, 'rule:config-get', '配置-查看', 603981723864141121, 'GET', '/role/authority/*', '', 1, 3, '2020-03-04 23:04:44', 3, '2020-03-04 23:26:26');
INSERT INTO `itcast_auth_resource` VALUES (684539815017848257, 'resource:page', '资源分页', 603976297063910529, 'GET', '/resource/page', '', 1, 3, '2020-03-04 23:16:50', 1, '2021-03-20 01:48:11');
INSERT INTO `itcast_auth_resource` VALUES (686681252069121761, 'role:user-list', '查看用户', 603981723864141121, 'GET', '/role/user/*', '', 1, 3, '2020-03-10 21:06:09', 3, '2020-03-10 21:06:09');
INSERT INTO `itcast_auth_resource` VALUES (686690530444191361, 'loginLog:page', '分页查询', 645215230518909025, 'GET', '/loginLog/page', '', 1, 3, '2020-03-10 21:43:01', 3, '2020-03-10 21:47:09');
INSERT INTO `itcast_auth_resource` VALUES (697738050637137985, 'station:list', '查询', 603982713849908801, 'GET', '/station/list', '', 1, 3, '2020-04-10 09:21:55', 3, '2020-04-10 09:21:55');
INSERT INTO `itcast_auth_resource` VALUES (819979689903793377, 'role:get', '查看角色', 603981723864141121, 'GET', '/role/*', '', 1, 3, '2021-03-13 17:06:33', 3, '2021-03-13 17:06:33');
INSERT INTO `itcast_auth_resource` VALUES (819980292310707361, 'menu:resource-tree', '查看菜单资源树', 603981723864141121, 'GET', '/menu/resource/tree', '', 1, 3, '2021-03-13 17:08:56', 3, '2021-03-13 17:08:56');
INSERT INTO `itcast_auth_resource` VALUES (819980764757114209, 'menu:get', '查看菜单', 603976297063910529, 'GET', '/menu/*', '', 1, 3, '2021-03-13 17:10:49', 1, '2021-03-20 01:48:19');
INSERT INTO `itcast_auth_resource` VALUES (819981352018401697, 'org:get', '查看组织', 603982542332235201, 'GET', '/org/*', '', 1, 3, '2021-03-13 17:13:09', 3, '2021-03-13 17:13:09');
INSERT INTO `itcast_auth_resource` VALUES (819981559128939745, 'menu:enable', '禁用菜单', 603976297063910529, 'PUT', '/menu/enable', '', 1, 3, '2021-03-13 17:13:58', 1, '2021-03-20 01:48:28');
INSERT INTO `itcast_auth_resource` VALUES (819984731746600865, 'org:status', '组织状态变更', 603982542332235201, 'PUT', '/org/status', '', 1, 3, '2021-03-13 17:26:35', 3, '2021-03-13 17:26:35');
INSERT INTO `itcast_auth_resource` VALUES (819985775964724545, 'org:move', '拖动组织', 603982542332235201, 'PUT', '/org/move', '', 1, 3, '2021-03-13 17:30:44', 3, '2021-03-13 17:30:44');
INSERT INTO `itcast_auth_resource` VALUES (820003240325155361, 'menu:move', '移动菜单', 603976297063910529, 'PUT', '/menu/move', '', 1, 819970379316561441, '2021-03-13 18:40:08', 819970379316561441, '2021-03-13 18:40:08');
INSERT INTO `itcast_auth_resource` VALUES (820231629682264673, 'userGroup:page', '用户组分页', 820229424300438465, 'GET', '/userGroup/page', '', 1, 819970379316561441, '2021-03-14 09:47:40', 821033290931822305, '2021-03-16 15:48:29');
INSERT INTO `itcast_auth_resource` VALUES (821039319551796065, 'userGroup:org-user-tree', '组织用户树', 820229424300438465, 'GET', '/userGroup/orgUserTree', '', 1, 821033290931822305, '2021-03-16 15:17:08', 821033290931822305, '2021-03-16 15:48:07');
INSERT INTO `itcast_auth_resource` VALUES (821039557997979393, 'userGroup:get', '查询用户组', 820229424300438465, 'GET', '/userGroup/*', '', 1, 821033290931822305, '2021-03-16 15:18:05', 821033290931822305, '2021-03-16 15:48:22');
INSERT INTO `itcast_auth_resource` VALUES (821039876387597985, 'userGroup:delete', '删除用户组', 820229424300438465, 'DELETE', '/userGroup', '', 1, 821033290931822305, '2021-03-16 15:19:21', 821033290931822305, '2021-03-16 15:48:35');
INSERT INTO `itcast_auth_resource` VALUES (821040097440002593, 'user:get', '查询用户', 603983082961243905, 'GET', '/user/*', '', 1, 821033290931822305, '2021-03-16 15:20:14', 1, '2021-08-13 17:40:30');
INSERT INTO `itcast_auth_resource` VALUES (821040509899474241, 'userGroup:add', '添加用户组', 820229424300438465, 'POST', '/userGroup', '', 1, 821033290931822305, '2021-03-16 15:21:52', 821033290931822305, '2021-03-16 15:48:40');
INSERT INTO `itcast_auth_resource` VALUES (821040586592323105, 'userGroup:update', '修改用户组', 820229424300438465, 'PUT', '/userGroup', '', 1, 821033290931822305, '2021-03-16 15:22:10', 821033290931822305, '2021-03-16 15:48:47');
INSERT INTO `itcast_auth_resource` VALUES (821043867263674209, 'resource:get', '查看资源', 603976297063910529, 'GET', '/resource/*', '', 1, 821033290931822305, '2021-03-16 15:35:12', 1, '2021-03-20 01:48:41');
INSERT INTO `itcast_auth_resource` VALUES (857648193905653729, 'application:list', '查询应用列表', 603981723864141121, 'GET', '/application/list', '', 1, 1, '2021-06-24 15:47:44', 1, '2021-06-24 15:48:05');
INSERT INTO `itcast_auth_resource` VALUES (860103477676743073, 'user:listall', '查询全部用户', 603983082961243905, 'GET', '/user', '', 1, 1, '2021-07-01 10:24:09', 1, '2021-07-01 10:24:09');
INSERT INTO `itcast_auth_resource` VALUES (874599773141730049, 'user:update-role', '分配角色', 603983082961243905, 'PUT', '/user/role', '', 1, 1, '2021-08-10 10:27:15', 1, '2021-08-10 10:27:26');
INSERT INTO `itcast_auth_resource` VALUES (876848743419269377, 'application:page', '分页', 829717676565049825, 'GET', '/application/page', '', 1, 1, '2021-08-16 15:23:52', 1, '2021-08-16 15:23:52');
INSERT INTO `itcast_auth_resource` VALUES (876848904275022241, 'application:add', '添加', 829717676565049825, 'POST', '/application', '', 1, 1, '2021-08-16 15:24:30', 1, '2021-08-16 15:24:30');
INSERT INTO `itcast_auth_resource` VALUES (876849034311029281, 'application:update', '修改', 829717676565049825, 'PUT', '/application', '', 1, 1, '2021-08-16 15:25:01', 1, '2021-08-16 15:25:01');
INSERT INTO `itcast_auth_resource` VALUES (876849208202678913, 'application:delete', '删除', 829717676565049825, 'DELETE', '/application', '', 1, 1, '2021-08-16 15:25:43', 1, '2021-08-16 15:25:43');
INSERT INTO `itcast_auth_resource` VALUES (877220301786592577, 'system:add', '添加', 877216131566273217, 'POST', '/system', '', 831890921313450625, 877215047032506913, '2021-08-17 16:00:18', 877215047032506913, '2021-08-17 16:00:18');
COMMIT;

-- ----------------------------
-- Table structure for itcast_auth_role
-- ----------------------------
DROP TABLE IF EXISTS `itcast_auth_role`;
CREATE TABLE `itcast_auth_role` (
                                    `id` bigint NOT NULL,
                                    `name` varchar(50)  NOT NULL DEFAULT '' COMMENT '角色名称',
                                    `code` varchar(20) DEFAULT '' COMMENT '角色编码',
                                    `describe_` varchar(100) DEFAULT '' COMMENT '功能描述',
                                    `status` bit(1) DEFAULT b'1' COMMENT '状态',
                                    `readonly` bit(1) DEFAULT b'0' COMMENT '是否内置角色',
                                    `ds_type` varchar(20) NOT NULL DEFAULT 'SELF' COMMENT '数据权限类型\n#DataScopeType{ALL:1,全部;THIS_LEVEL:2,本级;THIS_LEVEL_CHILDREN:3,本级以及子级;CUSTOMIZE:4,自定义;SELF:5,个人;}',
                                    `repel` bigint DEFAULT NULL COMMENT '互斥角色',
                                    `application_id` bigint DEFAULT NULL COMMENT '应用id',
                                    `create_user` bigint DEFAULT '0' COMMENT '创建人id',
                                    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                    `update_user` bigint DEFAULT '0' COMMENT '更新人id',
                                    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                    PRIMARY KEY (`id`) USING BTREE,
                                    UNIQUE KEY `UN_CODE` (`code`,`application_id`) USING BTREE,
                                    UNIQUE KEY `PAR_NAME` (`name`,`application_id`) USING BTREE
) ENGINE=InnoDB  ROW_FORMAT=COMPACT COMMENT='角色';

-- ----------------------------
-- Records of itcast_auth_role
-- ----------------------------
BEGIN;
INSERT INTO `itcast_auth_role` VALUES (100, '管理员', 'PT_ADMIN', '平台内置管理员', b'1', b'1', 'ALL', 834004562678405921, 1, 1, '2019-10-25 21:46:00', 1, '2021-04-20 22:05:50');
INSERT INTO `itcast_auth_role` VALUES (643779012732130273, '普通员工', 'BASE_USER', '只有最基本的权限', b'1', b'0', 'CUSTOMIZE', 834004562678405921, 1, 3, '2019-11-12 19:47:58', 1, '2021-04-20 22:05:47');
INSERT INTO `itcast_auth_role` VALUES (645198153556958497, '部门经理', 'DEPT_MANAGER', '管理本级以及子级用户', b'1', b'0', 'THIS_LEVEL_CHILDREN', 834004562678405921, 1, 3, '2019-11-16 17:47:07', 1, '2021-04-20 22:05:53');
INSERT INTO `itcast_auth_role` VALUES (830513015051781377, '集信达审核员', 'BJUMUZBD', '', b'1', b'0', 'ALL', NULL, 819611999649398913, 1, '2021-04-10 18:42:13', 1, '2021-04-10 18:42:13');
INSERT INTO `itcast_auth_role` VALUES (834004562678405921, '平台管理员', 'BKFRXACV', '', b'1', b'0', 'THIS_LEVEL_CHILDREN', NULL, 1, 1, '2021-04-20 17:56:23', 1, '2021-04-20 22:05:04');
INSERT INTO `itcast_auth_role` VALUES (834018171361985217, '九点钟', 'BKFRXADL', '', b'1', b'0', 'ALL', NULL, 834004063107434337, 1, '2021-04-20 10:50:28', 1, '2021-04-20 10:50:28');
INSERT INTO `itcast_auth_role` VALUES (834734304285174753, '团团购管理员', 'BKHGEGEB', '', b'1', b'0', 'ALL', NULL, 1, 1, '2021-04-22 18:16:07', 1, '2021-04-22 18:16:07');
INSERT INTO `itcast_auth_role` VALUES (856958590768908481, '工作流管理员', 'BLMRJKWF', '', b'1', b'0', 'ALL', NULL, 1, 1, '2021-06-22 18:07:30', 1, '2021-08-09 11:12:38');
INSERT INTO `itcast_auth_role` VALUES (856960598519324385, '研发人员', 'BLMRJKWV', '', b'1', b'0', 'ALL', NULL, 856958443553031905, 856959053190927169, '2021-06-22 18:15:28', 856959053190927169, '2021-06-25 11:27:40');
INSERT INTO `itcast_auth_role` VALUES (857939052358313665, '主管', 'BLMRJKYB', '', b'1', b'0', 'ALL', NULL, 856958443553031905, 856959053190927169, '2021-06-25 11:03:30', 856959053190927169, '2021-06-25 11:27:35');
INSERT INTO `itcast_auth_role` VALUES (857939588088377665, '部门经理', 'BLMRJLAN', '', b'1', b'0', 'ALL', NULL, 856958443553031905, 856959053190927169, '2021-06-25 11:05:38', 856959053190927169, '2021-06-25 11:27:30');
INSERT INTO `itcast_auth_role` VALUES (857939640307462945, '总经理', 'BLMRJLBD', '', b'1', b'0', 'ALL', NULL, 856958443553031905, 856959053190927169, '2021-06-25 11:05:50', 856959053190927169, '2021-06-25 11:27:25');
INSERT INTO `itcast_auth_role` VALUES (857939725581858049, '人事', 'BLMRJLBT', '', b'1', b'0', 'ALL', NULL, 856958443553031905, 856959053190927169, '2021-06-25 11:06:11', 856959053190927169, '2021-06-25 11:27:20');
INSERT INTO `itcast_auth_role` VALUES (857939868301440929, '管理员', 'BLMRJLCZ', '', b'1', b'0', 'ALL', NULL, 856958443553031905, 856959053190927169, '2021-06-25 11:06:45', 856959053190927169, '2021-06-25 11:27:14');
INSERT INTO `itcast_auth_role` VALUES (864904849311940737, '财务', 'BNTSGKGN', '', b'1', b'0', 'ALL', NULL, 856958443553031905, 856959053190927169, '2021-07-14 16:23:05', 856959053190927169, '2021-07-14 16:23:05');
INSERT INTO `itcast_auth_role` VALUES (872875447132627937, 'actest', 'BPAKTVDX', '', b'1', b'0', 'ALL', NULL, NULL, 856959053190927169, '2021-08-05 16:15:24', 856959053190927169, '2021-08-05 16:15:24');
INSERT INTO `itcast_auth_role` VALUES (874250002388504161, '车联网管理员', 'BPBTTQQJ', '', b'1', b'0', 'ALL', NULL, 1, 1, '2021-08-09 11:17:24', 1, '2021-08-17 14:11:24');
INSERT INTO `itcast_auth_role` VALUES (877220449673557729, '管理员', 'BPOLLRCB', '', b'1', b'0', 'ALL', NULL, 831890921313450625, 877215047032506913, '2021-08-17 16:00:53', 877215047032506913, '2021-08-17 16:01:45');
COMMIT;

-- ----------------------------
-- Table structure for itcast_auth_role_application
-- ----------------------------
DROP TABLE IF EXISTS `itcast_auth_role_application`;
CREATE TABLE `itcast_auth_role_application` (
                                                `id` bigint NOT NULL COMMENT 'ID',
                                                `role_id` bigint DEFAULT NULL COMMENT '角色ID',
                                                `application_id` bigint DEFAULT NULL COMMENT '应用ID',
                                                `create_time` datetime DEFAULT NULL,
                                                `create_user` bigint DEFAULT NULL,
                                                PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB  COMMENT='角色应用关系';

-- ----------------------------
-- Records of itcast_auth_role_application
-- ----------------------------
BEGIN;
INSERT INTO `itcast_auth_role_application` VALUES (834018171408122593, 834018171361985217, 834004063107434337, '2021-04-20 10:50:28', 1);
INSERT INTO `itcast_auth_role_application` VALUES (834067147117344929, 834004562678405921, 834003593324413697, '2021-04-20 14:05:04', 1);
INSERT INTO `itcast_auth_role_application` VALUES (834067324943261729, 643779012732130273, 831890921313450625, '2021-04-20 14:05:47', 1);
INSERT INTO `itcast_auth_role_application` VALUES (834067337006080481, 100, 831890921313450625, '2021-04-20 14:05:50', 1);
INSERT INTO `itcast_auth_role_application` VALUES (834067350687900417, 645198153556958497, 831890921313450625, '2021-04-20 14:05:53', 1);
INSERT INTO `itcast_auth_role_application` VALUES (834734304461335745, 834734304285174753, 834728079367610721, '2021-04-22 10:16:07', 1);
INSERT INTO `itcast_auth_role_application` VALUES (857945026972407201, 857939868301440929, 856958443553031905, '2021-06-25 11:27:14', 856959053190927169);
INSERT INTO `itcast_auth_role_application` VALUES (857945048816342785, 857939725581858049, 856958443553031905, '2021-06-25 11:27:20', 856959053190927169);
INSERT INTO `itcast_auth_role_application` VALUES (857945071121651809, 857939640307462945, 856958443553031905, '2021-06-25 11:27:25', 856959053190927169);
INSERT INTO `itcast_auth_role_application` VALUES (857945090792937921, 857939588088377665, 856958443553031905, '2021-06-25 11:27:30', 856959053190927169);
INSERT INTO `itcast_auth_role_application` VALUES (857945111017872481, 857939052358313665, 856958443553031905, '2021-06-25 11:27:35', 856959053190927169);
INSERT INTO `itcast_auth_role_application` VALUES (857945132463349345, 856960598519324385, 856958443553031905, '2021-06-25 11:27:40', 856959053190927169);
INSERT INTO `itcast_auth_role_application` VALUES (864904849836228961, 864904849311940737, 856958443553031905, '2021-07-14 16:23:06', 856959053190927169);
INSERT INTO `itcast_auth_role_application` VALUES (874248805925538881, 856958590768908481, 856958443553031905, '2021-08-09 11:12:38', 1);
INSERT INTO `itcast_auth_role_application` VALUES (877192895000490913, 874250002388504161, 835090007927576481, '2021-08-17 14:11:24', 1);
COMMIT;

-- ----------------------------
-- Table structure for itcast_auth_role_authority
-- ----------------------------
DROP TABLE IF EXISTS `itcast_auth_role_authority`;
CREATE TABLE `itcast_auth_role_authority` (
                                              `id` bigint NOT NULL COMMENT '主键',
                                              `authority_id` bigint NOT NULL COMMENT '资源id\n#c_auth_resource\n#c_auth_menu',
                                              `authority_type` varchar(10) NOT NULL DEFAULT 'MENU' COMMENT '权限类型\n#AuthorizeType{MENU:菜单;RESOURCE:资源;}',
                                              `role_id` bigint NOT NULL COMMENT '角色id\n#c_auth_role',
                                              `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                              `create_user` bigint DEFAULT '0' COMMENT '创建人',
                                              PRIMARY KEY (`id`) USING BTREE,
                                              KEY `IDX_KEY` (`role_id`,`authority_type`,`authority_id`) USING BTREE
) ENGINE=InnoDB  ROW_FORMAT=COMPACT COMMENT='角色的资源';

-- ----------------------------
-- Records of itcast_auth_role_authority
-- ----------------------------
BEGIN;
INSERT INTO `itcast_auth_role_authority` VALUES (831120082259157217, 643444685339100197, 'RESOURCE', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082271740161, 643445802106097185, 'RESOURCE', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082271740193, 643448826945869409, 'RESOURCE', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082271740225, 643445116756821697, 'RESOURCE', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082275934561, 643444685339100196, 'RESOURCE', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082275934593, 643444992357959137, 'RESOURCE', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082280128929, 643444685339100193, 'RESOURCE', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082280128961, 643444685339100195, 'RESOURCE', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082284323297, 643444685339100194, 'RESOURCE', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082284323329, 643445641149680705, 'RESOURCE', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082284323361, 643445229575210977, 'RESOURCE', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082284323393, 643444819758154945, 'RESOURCE', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082284323425, 643448369779315777, 'RESOURCE', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082288517761, 643448507767723169, 'RESOURCE', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082288517793, 686681252069121761, 'RESOURCE', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082288517825, 643445197954353025, 'RESOURCE', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082288517857, 643444897201784193, 'RESOURCE', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082292712193, 643448338154263521, 'RESOURCE', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082292712225, 643445704177487105, 'RESOURCE', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082292712257, 643448730950833601, 'RESOURCE', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082292712289, 643445283996305569, 'RESOURCE', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082296906625, 697738050637137985, 'RESOURCE', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082296906657, 643445674330819745, 'RESOURCE', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082296906689, 643445262110427201, 'RESOURCE', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082296906721, 643448656451605857, 'RESOURCE', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082296906753, 643445774687931841, 'RESOURCE', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082296906785, 684539815017848257, 'RESOURCE', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082301101121, 684536767625301441, 'RESOURCE', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082301101153, 643445747320098145, 'RESOURCE', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082301101185, 643448611161511169, 'RESOURCE', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082301101217, 643445016773002817, 'RESOURCE', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082301101249, 643445162915137313, 'RESOURCE', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082301101281, 643444858974897441, 'RESOURCE', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082301101313, 101, 'MENU', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082305295649, 603983082961243905, 'MENU', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082305295681, 603982542332235201, 'MENU', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082305295713, 603981723864141121, 'MENU', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082305295745, 820229424300438465, 'MENU', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082305295777, 829717676565049825, 'MENU', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082305295809, 603982713849908801, 'MENU', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082309490145, 603976297063910529, 'MENU', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831120082309490177, 822137241831746529, 'MENU', 831102307646055841, '2021-04-12 18:54:29', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831846270116114209, 831843354638620033, 'RESOURCE', 831198678990455969, '2021-04-14 19:00:06', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831846270120308545, 645215230518909025, 'MENU', 831198678990455969, '2021-04-14 19:00:06', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831846270124502881, 820229424300438465, 'MENU', 831198678990455969, '2021-04-14 19:00:06', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831846270124502913, 101, 'MENU', 831198678990455969, '2021-04-14 19:00:06', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831846270124502945, 831841858815593377, 'MENU', 831198678990455969, '2021-04-14 19:00:06', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831846270124502977, 104, 'MENU', 831198678990455969, '2021-04-14 19:00:06', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831846270124503009, 603983082961243905, 'MENU', 831198678990455969, '2021-04-14 19:00:06', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831846270124503041, 605078672772170209, 'MENU', 831198678990455969, '2021-04-14 19:00:06', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831846270124503073, 603976297063910529, 'MENU', 831198678990455969, '2021-04-14 19:00:06', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831846270124503105, 822137241831746529, 'MENU', 831198678990455969, '2021-04-14 19:00:06', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831848426701407521, 831841858815593377, 'MENU', 831846999841126689, '2021-04-14 19:08:40', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831922040956225313, 643445116756821697, 'RESOURCE', 831163310740100961, '2021-04-15 00:01:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831922040964613953, 697738050637137985, 'RESOURCE', 831163310740100961, '2021-04-15 00:01:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831922040964613985, 643445262110427201, 'RESOURCE', 831163310740100961, '2021-04-15 00:01:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831922040964614017, 643444685339100193, 'RESOURCE', 831163310740100961, '2021-04-15 00:01:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831922040964614049, 643445229575210977, 'RESOURCE', 831163310740100961, '2021-04-15 00:01:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831922040964614081, 643444819758154945, 'RESOURCE', 831163310740100961, '2021-04-15 00:01:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831922040964614113, 643445197954353025, 'RESOURCE', 831163310740100961, '2021-04-15 00:01:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831922040964614145, 643444897201784193, 'RESOURCE', 831163310740100961, '2021-04-15 00:01:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831922040964614177, 643445016773002817, 'RESOURCE', 831163310740100961, '2021-04-15 00:01:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831922040964614209, 643445162915137313, 'RESOURCE', 831163310740100961, '2021-04-15 00:01:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831922040964614241, 643444858974897441, 'RESOURCE', 831163310740100961, '2021-04-15 00:01:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831922040964614273, 643445283996305569, 'RESOURCE', 831163310740100961, '2021-04-15 00:01:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831922040964614305, 820229424300438465, 'MENU', 831163310740100961, '2021-04-15 00:01:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831922040964614337, 603982713849908801, 'MENU', 831163310740100961, '2021-04-15 00:01:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831922040964614369, 101, 'MENU', 831163310740100961, '2021-04-15 00:01:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831922040964614401, 603983082961243905, 'MENU', 831163310740100961, '2021-04-15 00:01:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831922040964614433, 603982542332235201, 'MENU', 831163310740100961, '2021-04-15 00:01:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (831922040964614465, 603981723864141121, 'MENU', 831163310740100961, '2021-04-15 00:01:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (833735137555389921, 820229424300438465, 'MENU', 833733606319852545, '2021-04-20 00:05:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (833735137563778561, 101, 'MENU', 833733606319852545, '2021-04-20 00:05:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (833735137563778593, 603983082961243905, 'MENU', 833733606319852545, '2021-04-20 00:05:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (833735137563778625, 603976297063910529, 'MENU', 833733606319852545, '2021-04-20 00:05:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (833735137563778657, 822137241831746529, 'MENU', 833733606319852545, '2021-04-20 00:05:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (833735239716054625, 643445116756821697, 'RESOURCE', 833735224088077313, '2021-04-20 00:06:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (833735239724443265, 697738050637137985, 'RESOURCE', 833735224088077313, '2021-04-20 00:06:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (833735239724443297, 643445262110427201, 'RESOURCE', 833735224088077313, '2021-04-20 00:06:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (833735239724443329, 643444685339100193, 'RESOURCE', 833735224088077313, '2021-04-20 00:06:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (833735239724443361, 643445229575210977, 'RESOURCE', 833735224088077313, '2021-04-20 00:06:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (833735239728637697, 643444819758154945, 'RESOURCE', 833735224088077313, '2021-04-20 00:06:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (833735239728637729, 643445197954353025, 'RESOURCE', 833735224088077313, '2021-04-20 00:06:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (833735239728637761, 643444897201784193, 'RESOURCE', 833735224088077313, '2021-04-20 00:06:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (833735239728637793, 643445016773002817, 'RESOURCE', 833735224088077313, '2021-04-20 00:06:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (833735239728637825, 643445162915137313, 'RESOURCE', 833735224088077313, '2021-04-20 00:06:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (833735239728637857, 643444858974897441, 'RESOURCE', 833735224088077313, '2021-04-20 00:06:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (833735239732832193, 643445283996305569, 'RESOURCE', 833735224088077313, '2021-04-20 00:06:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (833735239732832225, 820229424300438465, 'MENU', 833735224088077313, '2021-04-20 00:06:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (833735239732832257, 603982713849908801, 'MENU', 833735224088077313, '2021-04-20 00:06:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (833735239732832289, 101, 'MENU', 833735224088077313, '2021-04-20 00:06:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (833735239732832321, 603983082961243905, 'MENU', 833735224088077313, '2021-04-20 00:06:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (833735239732832353, 603982542332235201, 'MENU', 833735224088077313, '2021-04-20 00:06:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (833735239737026689, 603976297063910529, 'MENU', 833735224088077313, '2021-04-20 00:06:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (833735239737026721, 822137241831746529, 'MENU', 833735224088077313, '2021-04-20 00:06:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (833743771114931937, 820229424300438465, 'MENU', 833743712193348673, '2021-04-20 00:40:05', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (833743771123320577, 101, 'MENU', 833743712193348673, '2021-04-20 00:40:05', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (833743771127514913, 603983082961243905, 'MENU', 833743712193348673, '2021-04-20 00:40:05', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (833775505139331777, 820229424300438465, 'MENU', 833747799567778817, '2021-04-20 02:46:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (833775505147720417, 101, 'MENU', 833747799567778817, '2021-04-20 02:46:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (833775505147720449, 603983082961243905, 'MENU', 833747799567778817, '2021-04-20 02:46:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (833775505147720481, 822137241831746529, 'MENU', 833747799567778817, '2021-04-20 02:46:11', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (834002691486135297, 820229424300438465, 'MENU', 834002361541204865, '2021-04-20 17:48:57', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (834002691494523937, 101, 'MENU', 834002361541204865, '2021-04-20 17:48:57', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (834002691498718273, 603983082961243905, 'MENU', 834002361541204865, '2021-04-20 17:48:57', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (834002691498718305, 603976297063910529, 'MENU', 834002361541204865, '2021-04-20 17:48:57', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (834031870285998241, 686690530444191361, 'RESOURCE', 834031856230885089, '2021-04-20 19:44:54', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (834031870294386881, 645288214990422241, 'RESOURCE', 834031856230885089, '2021-04-20 19:44:54', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (834031870294386913, 645288283693121889, 'RESOURCE', 834031856230885089, '2021-04-20 19:44:54', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (834031870294386945, 643450853134441825, 'RESOURCE', 834031856230885089, '2021-04-20 19:44:54', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (834031870298581281, 643450770317909249, 'RESOURCE', 834031856230885089, '2021-04-20 19:44:54', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (834031870298581313, 645288375300915649, 'RESOURCE', 834031856230885089, '2021-04-20 19:44:54', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (834031870302775649, 645215230518909025, 'MENU', 834031856230885089, '2021-04-20 19:44:54', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (834031870302775681, 834002593268115937, 'MENU', 834031856230885089, '2021-04-20 19:44:54', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (834031870302775713, 820229424300438465, 'MENU', 834031856230885089, '2021-04-20 19:44:54', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (834031870302775745, 101, 'MENU', 834031856230885089, '2021-04-20 19:44:54', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (834031870302775777, 603983082961243905, 'MENU', 834031856230885089, '2021-04-20 19:44:54', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (834031870302775809, 605078672772170209, 'MENU', 834031856230885089, '2021-04-20 19:44:54', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399785486593, 643445802106097185, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399793875233, 831215983262695937, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399793875265, 643444685339100197, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399793875297, 643448826945869409, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399793875329, 643445116756821697, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399793875361, 643444685339100196, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399793875393, 643444685339100193, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399793875425, 819984731746600865, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399793875457, 643445514607528609, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399793875489, 643444685339100195, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399793875521, 643444685339100194, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399798069857, 643448507767723169, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399798069889, 820231629682264673, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399798069921, 645288283693121889, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399798069953, 686681252069121761, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399798069985, 643445197954353025, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399798070017, 643444897201784193, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399798070049, 831192990360799681, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399798070081, 821040509899474241, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399798070113, 821040097440002593, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399798070145, 820003240325155361, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399798070177, 831210807554492033, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399798070209, 643445412774021505, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399798070241, 686690530444191361, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399798070273, 643445262110427201, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399802264609, 819981559128939745, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399802264641, 643448656451605857, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399802264673, 643450853134441825, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399802264705, 643445774687931841, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399802264737, 819980764757114209, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399802264769, 684539815017848257, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399802264801, 643445477274028609, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399802264833, 821039876387597985, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399802264865, 684536767625301441, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399802264897, 643445352703199521, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399802264929, 643445747320098145, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399802264961, 643445016773002817, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399802264993, 643445162915137313, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399806459329, 643444858974897441, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399806459361, 643450770317909249, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399806459393, 819993365423633153, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399806459425, 831191950517339937, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399806459457, 821039557997979393, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399806459489, 643445641149680705, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399806459521, 821043867263674209, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399810653857, 643445229575210977, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399810653889, 643444819758154945, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399814848225, 643448369779315777, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399814848257, 821040586592323105, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399814848289, 643448338154263521, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399814848321, 819985775964724545, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399814848353, 643445704177487105, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399814848385, 643445283996305569, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399814848417, 831192210241226625, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399814848449, 697738050637137985, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399814848481, 643445674330819745, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399814848513, 643445542076025601, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399814848545, 645288214990422241, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399814848577, 645288375300915649, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399819042913, 819979689903793377, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399819042945, 821039319551796065, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399819042977, 819981352018401697, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399819043009, 643445448081672673, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399819043041, 643448611161511169, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399819043073, 819980292310707361, 'RESOURCE', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399819043105, 645215230518909025, 'MENU', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399819043137, 834002593268115937, 'MENU', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399819043169, 101, 'MENU', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399819043201, 104, 'MENU', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399819043233, 603983082961243905, 'MENU', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399819043265, 603982542332235201, 'MENU', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399819043297, 603981723864141121, 'MENU', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399819043329, 820229424300438465, 'MENU', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399823237665, 829717676565049825, 'MENU', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399823237697, 603982713849908801, 'MENU', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399823237729, 605078672772170209, 'MENU', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (857647399823237761, 603976297063910529, 'MENU', 100, '2021-06-24 15:44:35', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (866641695624707585, 864827475257992705, 'MENU', 856960598519324385, '2021-07-19 11:24:42', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641695641484833, 857938392577515841, 'MENU', 856960598519324385, '2021-07-19 11:24:42', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641695641484865, 866641193251944449, 'MENU', 856960598519324385, '2021-07-19 11:24:42', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641695645679201, 857938895436817281, 'MENU', 856960598519324385, '2021-07-19 11:24:42', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641695645679233, 865660192518335553, 'MENU', 856960598519324385, '2021-07-19 11:24:42', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641695649873569, 866641657007750177, 'MENU', 856960598519324385, '2021-07-19 11:24:42', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641695649873601, 857938631489266177, 'MENU', 856960598519324385, '2021-07-19 11:24:42', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641695649873633, 863081063625264673, 'MENU', 856960598519324385, '2021-07-19 11:24:42', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641695654067969, 857938224469811329, 'MENU', 856960598519324385, '2021-07-19 11:24:42', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641695654068001, 856959482712824161, 'MENU', 856960598519324385, '2021-07-19 11:24:42', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641707121295489, 864827475257992705, 'MENU', 857939052358313665, '2021-07-19 11:24:45', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641707142267041, 857938392577515841, 'MENU', 857939052358313665, '2021-07-19 11:24:45', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641707146461377, 866641193251944449, 'MENU', 857939052358313665, '2021-07-19 11:24:45', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641707150655713, 857938895436817281, 'MENU', 857939052358313665, '2021-07-19 11:24:45', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641707150655745, 865660192518335553, 'MENU', 857939052358313665, '2021-07-19 11:24:45', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641707154850081, 866641657007750177, 'MENU', 857939052358313665, '2021-07-19 11:24:45', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641707154850113, 857938631489266177, 'MENU', 857939052358313665, '2021-07-19 11:24:45', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641707159044449, 863081063625264673, 'MENU', 857939052358313665, '2021-07-19 11:24:45', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641707159044481, 857938224469811329, 'MENU', 857939052358313665, '2021-07-19 11:24:45', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641707163238817, 856959482712824161, 'MENU', 857939052358313665, '2021-07-19 11:24:45', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641716914995969, 864827475257992705, 'MENU', 857939588088377665, '2021-07-19 11:24:47', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641716927578913, 857938392577515841, 'MENU', 857939588088377665, '2021-07-19 11:24:47', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641716927578945, 866641193251944449, 'MENU', 857939588088377665, '2021-07-19 11:24:47', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641716931773281, 857938895436817281, 'MENU', 857939588088377665, '2021-07-19 11:24:47', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641716931773313, 865660192518335553, 'MENU', 857939588088377665, '2021-07-19 11:24:47', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641716935967649, 866641657007750177, 'MENU', 857939588088377665, '2021-07-19 11:24:47', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641716935967681, 857938631489266177, 'MENU', 857939588088377665, '2021-07-19 11:24:47', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641716940162017, 863081063625264673, 'MENU', 857939588088377665, '2021-07-19 11:24:47', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641716940162049, 857938224469811329, 'MENU', 857939588088377665, '2021-07-19 11:24:47', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641716944356385, 856959482712824161, 'MENU', 857939588088377665, '2021-07-19 11:24:47', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641728440944001, 864827475257992705, 'MENU', 857939640307462945, '2021-07-19 11:24:50', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641728474498465, 857938392577515841, 'MENU', 857939640307462945, '2021-07-19 11:24:50', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641728478692801, 866641193251944449, 'MENU', 857939640307462945, '2021-07-19 11:24:50', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641728482887137, 857938895436817281, 'MENU', 857939640307462945, '2021-07-19 11:24:50', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641728482887169, 865660192518335553, 'MENU', 857939640307462945, '2021-07-19 11:24:50', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641728482887201, 866641657007750177, 'MENU', 857939640307462945, '2021-07-19 11:24:50', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641728487081537, 857938631489266177, 'MENU', 857939640307462945, '2021-07-19 11:24:50', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641728487081569, 863081063625264673, 'MENU', 857939640307462945, '2021-07-19 11:24:50', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641728491275905, 857938224469811329, 'MENU', 857939640307462945, '2021-07-19 11:24:50', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641728491275937, 856959482712824161, 'MENU', 857939640307462945, '2021-07-19 11:24:50', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641739320969217, 864827475257992705, 'MENU', 857939725581858049, '2021-07-19 11:24:52', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641739333552161, 857938392577515841, 'MENU', 857939725581858049, '2021-07-19 11:24:52', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641739333552193, 866641193251944449, 'MENU', 857939725581858049, '2021-07-19 11:24:52', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641739337746529, 857938895436817281, 'MENU', 857939725581858049, '2021-07-19 11:24:52', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641739337746561, 865660192518335553, 'MENU', 857939725581858049, '2021-07-19 11:24:52', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641739337746593, 866641657007750177, 'MENU', 857939725581858049, '2021-07-19 11:24:52', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641739341940929, 857938631489266177, 'MENU', 857939725581858049, '2021-07-19 11:24:52', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641739341940961, 863081063625264673, 'MENU', 857939725581858049, '2021-07-19 11:24:52', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641739346135297, 857938224469811329, 'MENU', 857939725581858049, '2021-07-19 11:24:52', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641739346135329, 856959482712824161, 'MENU', 857939725581858049, '2021-07-19 11:24:52', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641765904469185, 864827475257992705, 'MENU', 864904849311940737, '2021-07-19 11:24:59', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641765929635041, 857938392577515841, 'MENU', 864904849311940737, '2021-07-19 11:24:59', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641765929635073, 866641193251944449, 'MENU', 864904849311940737, '2021-07-19 11:24:59', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641765929635105, 857938895436817281, 'MENU', 864904849311940737, '2021-07-19 11:24:59', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641765933829441, 865660192518335553, 'MENU', 864904849311940737, '2021-07-19 11:24:59', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641765933829473, 866641657007750177, 'MENU', 864904849311940737, '2021-07-19 11:24:59', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641765933829505, 857938631489266177, 'MENU', 864904849311940737, '2021-07-19 11:24:59', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641765938023841, 863081063625264673, 'MENU', 864904849311940737, '2021-07-19 11:24:59', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641765938023873, 857938224469811329, 'MENU', 864904849311940737, '2021-07-19 11:24:59', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641765938023905, 856959482712824161, 'MENU', 864904849311940737, '2021-07-19 11:24:59', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641781356285761, 864827475257992705, 'MENU', 857939868301440929, '2021-07-19 11:25:02', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641781364674401, 857938392577515841, 'MENU', 857939868301440929, '2021-07-19 11:25:02', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641781368868737, 866641193251944449, 'MENU', 857939868301440929, '2021-07-19 11:25:02', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641781368868769, 857938895436817281, 'MENU', 857939868301440929, '2021-07-19 11:25:02', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641781373063105, 865660192518335553, 'MENU', 857939868301440929, '2021-07-19 11:25:02', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641781373063137, 866641657007750177, 'MENU', 857939868301440929, '2021-07-19 11:25:02', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641781373063169, 857938631489266177, 'MENU', 857939868301440929, '2021-07-19 11:25:02', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641781377257505, 863081063625264673, 'MENU', 857939868301440929, '2021-07-19 11:25:02', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641781377257537, 857938224469811329, 'MENU', 857939868301440929, '2021-07-19 11:25:02', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (866641781377257569, 856959482712824161, 'MENU', 857939868301440929, '2021-07-19 11:25:02', 856959053190927169);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276766811777, 643444685339100197, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276800366241, 643448826945869409, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276808754881, 860103477676743073, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276812949217, 643444685339100196, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276825532161, 643444685339100195, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276838115105, 821039557997979393, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276838115137, 643444685339100194, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276842309473, 643445229575210977, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276850698113, 643445641149680705, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276854892449, 821043867263674209, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276854892481, 643448369779315777, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276859086817, 643448507767723169, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276863281153, 820231629682264673, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276863281185, 686681252069121761, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276867475521, 643444897201784193, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276871669857, 643448338154263521, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276875864193, 821040097440002593, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276880058529, 643445704177487105, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276884252865, 820003240325155361, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276884252897, 697738050637137985, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276888447233, 643445674330819745, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276892641569, 819981559128939745, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276892641601, 819980764757114209, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276896835937, 684539815017848257, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276901030273, 643445477274028609, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276901030305, 684536767625301441, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276905224641, 819979689903793377, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276905224673, 821039319551796065, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276909419009, 819981352018401697, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276909419041, 643445747320098145, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276913613377, 643448611161511169, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276913613409, 857648193905653729, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276922002049, 819980292310707361, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276922002081, 874599773141730049, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276926196417, 819993365423633153, 'RESOURCE', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276930390753, 834002593268115937, 'MENU', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276930390785, 820229424300438465, 'MENU', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276934585121, 101, 'MENU', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276938779457, 603983082961243905, 'MENU', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276942973793, 603976297063910529, 'MENU', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (874618276942973825, 603981723864141121, 'MENU', 834734304285174753, '2021-08-10 11:40:47', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751703860577, 643444685339100197, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751716443521, 643448826945869409, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751720637857, 860103477676743073, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751720637889, 643444685339100196, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751720637921, 643444685339100195, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751724832257, 821039557997979393, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751724832289, 643444685339100194, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751729026625, 643445229575210977, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751729026657, 643445641149680705, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751733220993, 821043867263674209, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751733221025, 643448369779315777, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751733221057, 643448507767723169, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751737415393, 820231629682264673, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751737415425, 686681252069121761, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751741609761, 643444897201784193, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751741609793, 643448338154263521, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751741609825, 821040097440002593, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751745804161, 643445704177487105, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751745804193, 820003240325155361, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751749998529, 697738050637137985, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751749998561, 643445674330819745, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751749998593, 819981559128939745, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751754192929, 819980764757114209, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751754192961, 684539815017848257, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751758387297, 643445477274028609, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751758387329, 684536767625301441, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751762581665, 819979689903793377, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751762581697, 821039319551796065, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751762581729, 819981352018401697, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751766776065, 643445747320098145, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751766776097, 643448611161511169, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751766776129, 857648193905653729, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751770970465, 819980292310707361, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751770970497, 874599773141730049, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751775164833, 819993365423633153, 'RESOURCE', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751775164865, 820229424300438465, 'MENU', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751779359201, 101, 'MENU', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751779359233, 603983082961243905, 'MENU', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751779359265, 603976297063910529, 'MENU', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877193751783553601, 603981723864141121, 'MENU', 874250002388504161, '2021-08-17 14:14:48', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878247544897, 643444685339100197, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878268516449, 643448826945869409, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878272710785, 860103477676743073, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878272710817, 643444685339100196, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878272710849, 643444685339100195, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878276905185, 821039557997979393, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878276905217, 643444685339100194, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878276905249, 643445229575210977, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878276905281, 643445641149680705, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878281099617, 821043867263674209, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878281099649, 643448369779315777, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878285293985, 643448507767723169, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878285294017, 820231629682264673, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878289488353, 686681252069121761, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878289488385, 643444897201784193, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878289488417, 643448338154263521, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878293682753, 821040097440002593, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878293682785, 643445704177487105, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878293682817, 820003240325155361, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878293682849, 697738050637137985, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878297877185, 643445674330819745, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878297877217, 819981559128939745, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878297877249, 876848743419269377, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878302071585, 819980764757114209, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878302071617, 684539815017848257, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878302071649, 643445477274028609, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878306265985, 684536767625301441, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878306266017, 819979689903793377, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878306266049, 821039319551796065, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878310460385, 819981352018401697, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878310460417, 643445747320098145, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878310460449, 643448611161511169, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878310460481, 857648193905653729, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878314654817, 819980292310707361, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878314654849, 874599773141730049, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878318849185, 819993365423633153, 'RESOURCE', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878318849217, 834002593268115937, 'MENU', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878318849249, 101, 'MENU', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878323043585, 603983082961243905, 'MENU', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878323043617, 603976297063910529, 'MENU', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877220878323043649, 603981723864141121, 'MENU', 856958590768908481, '2021-08-17 16:02:36', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374846523873, 643448826945869409, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374859106817, 860103477676743073, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374863301153, 643445116756821697, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374863301185, 643444685339100196, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374863301217, 643444685339100193, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374867495553, 819984731746600865, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374867495585, 643445514607528609, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374867495617, 643444685339100195, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374867495649, 821039557997979393, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374871689985, 643444685339100194, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374871690017, 876849034311029281, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374871690049, 643445229575210977, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374875884385, 643445641149680705, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374875884417, 821043867263674209, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374875884449, 643444819758154945, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374880078785, 643448369779315777, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374880078817, 820231629682264673, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374880078849, 686681252069121761, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374884273185, 643444897201784193, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374884273217, 643448338154263521, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374884273249, 821040586592323105, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374884273281, 821040097440002593, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374888467617, 819985775964724545, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374888467649, 821040509899474241, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374892661985, 643445704177487105, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374892662017, 820003240325155361, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374896856353, 643445412774021505, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374896856385, 697738050637137985, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374896856417, 643445674330819745, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374901050753, 819981559128939745, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374901050785, 876848743419269377, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374901050817, 876848904275022241, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374905245153, 819980764757114209, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374905245185, 684539815017848257, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374905245217, 643445477274028609, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374905245249, 684536767625301441, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374909439585, 819979689903793377, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374909439617, 821039319551796065, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374909439649, 643445352703199521, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374909439681, 819981352018401697, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374913634017, 643445747320098145, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374913634049, 643448611161511169, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374917828385, 857648193905653729, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374917828417, 819980292310707361, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374917828449, 643445162915137313, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374922022785, 874599773141730049, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374922022817, 819993365423633153, 'RESOURCE', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374926217153, 645215230518909025, 'MENU', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374926217185, 834002593268115937, 'MENU', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374926217217, 101, 'MENU', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374930411553, 104, 'MENU', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374930411585, 603983082961243905, 'MENU', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374934605921, 603982542332235201, 'MENU', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374934605953, 603981723864141121, 'MENU', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374934605985, 820229424300438465, 'MENU', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374934606017, 829717676565049825, 'MENU', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374938800353, 603982713849908801, 'MENU', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374938800385, 605078672772170209, 'MENU', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (877222374938800417, 603976297063910529, 'MENU', 643779012732130273, '2021-08-17 16:08:32', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603739124545, 643444685339100197, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603768484705, 643448826945869409, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603768484737, 860103477676743073, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603772679073, 643444685339100196, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603776873409, 643444685339100195, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603776873441, 821039557997979393, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603781067777, 643444685339100194, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603781067809, 643445229575210977, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603785262145, 643445641149680705, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603789456481, 821043867263674209, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603793650817, 643448369779315777, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603793650849, 643448507767723169, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603797845185, 820231629682264673, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603797845217, 686681252069121761, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603802039553, 643444897201784193, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603802039585, 643448338154263521, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603806233921, 821040097440002593, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603806233953, 643445704177487105, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603810428289, 820003240325155361, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603810428321, 697738050637137985, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603810428353, 643445674330819745, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603814622689, 819981559128939745, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603814622721, 819980764757114209, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603814622753, 684539815017848257, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603814622785, 643445477274028609, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603818817121, 684536767625301441, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603818817153, 819979689903793377, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603818817185, 821039319551796065, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603823011521, 819981352018401697, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603823011553, 643445747320098145, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603823011585, 643448611161511169, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603827205921, 857648193905653729, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603831400257, 819980292310707361, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603831400289, 874599773141730049, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603835594625, 819993365423633153, 'RESOURCE', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603835594657, 645215230518909025, 'MENU', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603839788993, 834002593268115937, 'MENU', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603839789025, 101, 'MENU', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603839789057, 104, 'MENU', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603843983393, 603983082961243905, 'MENU', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603843983425, 603982542332235201, 'MENU', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603843983457, 603981723864141121, 'MENU', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603848177793, 820229424300438465, 'MENU', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603848177825, 829717676565049825, 'MENU', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603848177857, 603982713849908801, 'MENU', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603852372193, 605078672772170209, 'MENU', 834004562678405921, '2021-08-23 15:32:23', 1);
INSERT INTO `itcast_auth_role_authority` VALUES (879387603852372225, 603976297063910529, 'MENU', 834004562678405921, '2021-08-23 15:32:23', 1);
COMMIT;

-- ----------------------------
-- Table structure for itcast_auth_role_org
-- ----------------------------
DROP TABLE IF EXISTS `itcast_auth_role_org`;
CREATE TABLE `itcast_auth_role_org` (
                                        `id` bigint NOT NULL COMMENT 'ID',
                                        `role_id` bigint DEFAULT NULL COMMENT '角色ID\n#c_auth_role',
                                        `org_id` bigint DEFAULT NULL COMMENT '部门ID\n#c_core_org',
                                        `create_time` datetime DEFAULT NULL,
                                        `create_user` bigint DEFAULT NULL,
                                        PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB  ROW_FORMAT=COMPACT COMMENT='角色组织关系';

-- ----------------------------
-- Records of itcast_auth_role_org
-- ----------------------------
BEGIN;
INSERT INTO `itcast_auth_role_org` VALUES (831135153291018529, 831102307646055841, 830495716823533281, '2021-04-12 19:54:22', 1);
INSERT INTO `itcast_auth_role_org` VALUES (831135153299407169, 831102307646055841, 831133375581404257, '2021-04-12 19:54:23', 1);
INSERT INTO `itcast_auth_role_org` VALUES (831135153299407201, 831102307646055841, 831133401435094241, '2021-04-12 19:54:23', 1);
INSERT INTO `itcast_auth_role_org` VALUES (831135153299407233, 831102307646055841, 831133426835799393, '2021-04-12 19:54:23', 1);
INSERT INTO `itcast_auth_role_org` VALUES (831846878562825345, 831198678990455969, 830495716823533281, '2021-04-14 19:02:31', 1);
INSERT INTO `itcast_auth_role_org` VALUES (831849718760952129, 831846999841126689, 830495716823533281, '2021-04-14 19:13:48', 1);
INSERT INTO `itcast_auth_role_org` VALUES (831849718765146465, 831846999841126689, 831133375581404257, '2021-04-14 19:13:48', 1);
INSERT INTO `itcast_auth_role_org` VALUES (831849718765146497, 831846999841126689, 831133401435094241, '2021-04-14 19:13:48', 1);
INSERT INTO `itcast_auth_role_org` VALUES (831849718765146529, 831846999841126689, 831133426835799393, '2021-04-14 19:13:48', 1);
INSERT INTO `itcast_auth_role_org` VALUES (831849718765146561, 831846999841126689, 831579687959458433, '2021-04-14 19:13:48', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833735158497550145, 833733606319852545, 831858877577411073, '2021-04-20 00:05:52', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833735158501744481, 833733606319852545, 831858961039866529, '2021-04-20 00:05:52', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833735158501744513, 833733606319852545, 831859164782378273, '2021-04-20 00:05:52', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833735158505938849, 833733606319852545, 831859219404799393, '2021-04-20 00:05:52', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833735158505938881, 833733606319852545, 831859052316310561, '2021-04-20 00:05:52', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833735158505938913, 833733606319852545, 831859095488281761, '2021-04-20 00:05:52', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833735261627099521, 833735224088077313, 831858877577411073, '2021-04-20 00:06:17', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833735261635488161, 833735224088077313, 831858961039866529, '2021-04-20 00:06:17', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833735261635488193, 833735224088077313, 831859164782378273, '2021-04-20 00:06:17', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833735261635488225, 833735224088077313, 831859219404799393, '2021-04-20 00:06:17', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833735261635488257, 833735224088077313, 831859052316310561, '2021-04-20 00:06:17', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833735261639682593, 833735224088077313, 831859095488281761, '2021-04-20 00:06:17', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833735532302316577, 833735512643613281, 831858877577411073, '2021-04-20 00:07:21', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833735532306510913, 833735512643613281, 831858961039866529, '2021-04-20 00:07:21', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833735532306510945, 833735512643613281, 831859164782378273, '2021-04-20 00:07:21', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833735532306510977, 833735512643613281, 831859219404799393, '2021-04-20 00:07:21', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833735532306511009, 833735512643613281, 831859052316310561, '2021-04-20 00:07:21', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833735532310705345, 833735512643613281, 831859095488281761, '2021-04-20 00:07:21', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833735702272293185, 833735649990293409, 831858877577411073, '2021-04-20 00:08:02', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833735702276487521, 833735649990293409, 831858961039866529, '2021-04-20 00:08:02', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833735702276487553, 833735649990293409, 831859164782378273, '2021-04-20 00:08:02', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833735702276487585, 833735649990293409, 831859219404799393, '2021-04-20 00:08:02', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833735702280681921, 833735649990293409, 831859052316310561, '2021-04-20 00:08:02', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833735702280681953, 833735649990293409, 831859095488281761, '2021-04-20 00:08:02', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833740200407491393, 833739530430341505, 831859095488281761, '2021-04-20 00:25:54', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833743817281636641, 833743712193348673, 831858877577411073, '2021-04-20 00:40:16', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833743817294219585, 833743712193348673, 831858961039866529, '2021-04-20 00:40:16', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833743817294219617, 833743712193348673, 831859164782378273, '2021-04-20 00:40:16', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833743817294219649, 833743712193348673, 831859219404799393, '2021-04-20 00:40:16', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833743817298413985, 833743712193348673, 831859052316310561, '2021-04-20 00:40:16', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833743817298414017, 833743712193348673, 831859095488281761, '2021-04-20 00:40:16', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833744943930413761, 833739496846548769, 831859164782378273, '2021-04-20 00:44:45', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833745149845575777, 833745115863324321, 831858877577411073, '2021-04-20 00:45:34', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833745149853964417, 833745115863324321, 831858961039866529, '2021-04-20 00:45:34', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833745149853964449, 833745115863324321, 831859164782378273, '2021-04-20 00:45:34', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833745149853964481, 833745115863324321, 831859219404799393, '2021-04-20 00:45:34', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833745149853964513, 833745115863324321, 831859052316310561, '2021-04-20 00:45:34', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833745149853964545, 833745115863324321, 831859095488281761, '2021-04-20 00:45:34', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833745311980592417, 833745283031505793, 831858877577411073, '2021-04-20 00:46:13', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833745311984786753, 833745283031505793, 831858961039866529, '2021-04-20 00:46:13', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833745311984786785, 833745283031505793, 831859164782378273, '2021-04-20 00:46:13', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833745311984786817, 833745283031505793, 831859219404799393, '2021-04-20 00:46:13', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833745311988981153, 833745283031505793, 831859052316310561, '2021-04-20 00:46:13', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833745311988981185, 833745283031505793, 831859095488281761, '2021-04-20 00:46:13', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833745757709279969, 833745726340079937, 831858877577411073, '2021-04-20 00:47:59', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833745757717668609, 833745726340079937, 831858961039866529, '2021-04-20 00:47:59', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833745757717668641, 833745726340079937, 831859164782378273, '2021-04-20 00:47:59', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833745757717668673, 833745726340079937, 831859219404799393, '2021-04-20 00:47:59', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833745757721863009, 833745726340079937, 831859052316310561, '2021-04-20 00:47:59', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833745757721863041, 833745726340079937, 831859095488281761, '2021-04-20 00:47:59', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833746066686879777, 833746022046901889, 831859164782378273, '2021-04-20 00:49:13', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833775637377352033, 833746514005208481, 831858877577411073, '2021-04-20 02:46:43', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833775637381546369, 833746514005208481, 831858961039866529, '2021-04-20 02:46:43', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833775637381546401, 833746514005208481, 831859052316310561, '2021-04-20 02:46:43', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833775637381546433, 833746514005208481, 831859095488281761, '2021-04-20 02:46:43', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833775637381546465, 833746514005208481, 831859164782378273, '2021-04-20 02:46:43', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833775637381546497, 833746514005208481, 831859219404799393, '2021-04-20 02:46:43', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833990387709286913, 833739457931795681, 831858877577411073, '2021-04-20 17:00:03', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833990387713481249, 833739457931795681, 831858961039866529, '2021-04-20 17:00:03', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833990387717675585, 833739457931795681, 831859052316310561, '2021-04-20 17:00:03', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833990387717675617, 833739457931795681, 831859095488281761, '2021-04-20 17:00:03', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833990387717675649, 833739457931795681, 831859164782378273, '2021-04-20 17:00:03', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833990387717675681, 833739457931795681, 831859219404799393, '2021-04-20 17:00:03', 1);
INSERT INTO `itcast_auth_role_org` VALUES (833999303004391265, 833747278341617697, 831859095488281761, '2021-04-20 17:35:29', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834002527153301121, 834002361541204865, 831858877577411073, '2021-04-20 17:48:18', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834002527161689761, 834002361541204865, 831858961039866529, '2021-04-20 17:48:18', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834002527161689793, 834002361541204865, 831859164782378273, '2021-04-20 17:48:18', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834002527161689825, 834002361541204865, 831859219404799393, '2021-04-20 17:48:18', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834002527161689857, 834002361541204865, 831859052316310561, '2021-04-20 17:48:18', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834002527165884193, 834002361541204865, 831859095488281761, '2021-04-20 17:48:18', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834002588146870465, 833747565928267009, 831858877577411073, '2021-04-20 17:48:32', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834002588151064801, 833747565928267009, 831858961039866529, '2021-04-20 17:48:32', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834002588151064833, 833747565928267009, 831859164782378273, '2021-04-20 17:48:32', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834002588151064865, 833747565928267009, 831859219404799393, '2021-04-20 17:48:32', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834002588151064897, 833747565928267009, 831859052316310561, '2021-04-20 17:48:32', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834002588155259233, 833747565928267009, 831859095488281761, '2021-04-20 17:48:32', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834021812462461473, 834021798050832449, 831858877577411073, '2021-04-20 19:04:56', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834021812466655809, 834021798050832449, 831858961039866529, '2021-04-20 19:04:56', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834021812466655841, 834021798050832449, 831859052316310561, '2021-04-20 19:04:56', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834021812466655873, 834021798050832449, 831859095488281761, '2021-04-20 19:04:56', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834021812466655905, 834021798050832449, 831859164782378273, '2021-04-20 19:04:56', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834021812466655937, 834021798050832449, 831859219404799393, '2021-04-20 19:04:56', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834021916971935777, 834021906570061377, 831858877577411073, '2021-04-20 19:05:21', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834021916992907329, 834021906570061377, 831858961039866529, '2021-04-20 19:05:21', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834021916992907361, 834021906570061377, 831859052316310561, '2021-04-20 19:05:21', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834021916992907393, 834021906570061377, 831859095488281761, '2021-04-20 19:05:21', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834021916992907425, 834021906570061377, 831859164782378273, '2021-04-20 19:05:21', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834021916992907457, 834021906570061377, 831859219404799393, '2021-04-20 19:05:21', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834022030587243713, 834022030557883553, 831858877577411073, '2021-04-20 19:05:48', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834022030591438049, 834022030557883553, 831858961039866529, '2021-04-20 19:05:48', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834022030595632385, 834022030557883553, 831859052316310561, '2021-04-20 19:05:48', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834022030595632417, 834022030557883553, 831859095488281761, '2021-04-20 19:05:48', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834022030595632449, 834022030557883553, 831859164782378273, '2021-04-20 19:05:48', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834022030595632481, 834022030557883553, 831859219404799393, '2021-04-20 19:05:48', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834022073419477377, 834022065374801793, 831858877577411073, '2021-04-20 19:05:58', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834022073423671713, 834022065374801793, 831858961039866529, '2021-04-20 19:05:58', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834022073423671745, 834022065374801793, 831859052316310561, '2021-04-20 19:05:58', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834022073423671777, 834022065374801793, 831859095488281761, '2021-04-20 19:05:58', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834022073423671809, 834022065374801793, 831859164782378273, '2021-04-20 19:05:58', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834022073423671841, 834022065374801793, 831859219404799393, '2021-04-20 19:05:58', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834022268173596609, 834022246308689377, 831858877577411073, '2021-04-20 19:06:44', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834022268181985249, 834022246308689377, 831858961039866529, '2021-04-20 19:06:44', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834022268181985281, 834022246308689377, 831859052316310561, '2021-04-20 19:06:44', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834022268181985313, 834022246308689377, 831859095488281761, '2021-04-20 19:06:44', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834022268181985345, 834022246308689377, 831859164782378273, '2021-04-20 19:06:44', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834022268181985377, 834022246308689377, 831859219404799393, '2021-04-20 19:06:44', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834022487388896897, 834022465024867457, 831858877577411073, '2021-04-20 19:07:37', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834022487393091233, 834022465024867457, 831858961039866529, '2021-04-20 19:07:37', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834022487393091265, 834022465024867457, 831859052316310561, '2021-04-20 19:07:37', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834022487397285601, 834022465024867457, 831859095488281761, '2021-04-20 19:07:37', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834022487397285633, 834022465024867457, 831859164782378273, '2021-04-20 19:07:37', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834022487397285665, 834022465024867457, 831859219404799393, '2021-04-20 19:07:37', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834022643593167969, 831163310740100961, 831858877577411073, '2021-04-20 19:08:14', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834022643597362305, 831163310740100961, 831858961039866529, '2021-04-20 19:08:14', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834022643597362337, 831163310740100961, 831859164782378273, '2021-04-20 19:08:14', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834022643597362369, 831163310740100961, 831859219404799393, '2021-04-20 19:08:14', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834022643597362401, 831163310740100961, 831859052316310561, '2021-04-20 19:08:14', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834022643597362433, 831163310740100961, 831859095488281761, '2021-04-20 19:08:14', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834023337083590305, 834023337058424449, 831858877577411073, '2021-04-20 19:10:59', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834023337091978945, 834023337058424449, 831858961039866529, '2021-04-20 19:10:59', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834023337091978977, 834023337058424449, 831859052316310561, '2021-04-20 19:10:59', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834023337091979009, 834023337058424449, 831859095488281761, '2021-04-20 19:10:59', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834023337091979041, 834023337058424449, 831859164782378273, '2021-04-20 19:10:59', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834023337091979073, 834023337058424449, 831859219404799393, '2021-04-20 19:10:59', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834023385662020417, 834023377663482209, 831858877577411073, '2021-04-20 19:11:11', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834023385666214753, 834023377663482209, 831858961039866529, '2021-04-20 19:11:11', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834023385666214785, 834023377663482209, 831859052316310561, '2021-04-20 19:11:11', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834023385666214817, 834023377663482209, 831859095488281761, '2021-04-20 19:11:11', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834023385666214849, 834023377663482209, 831859164782378273, '2021-04-20 19:11:11', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834023385666214881, 834023377663482209, 831859219404799393, '2021-04-20 19:11:11', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834026950866502081, 834026950736478625, 831858877577411073, '2021-04-20 19:25:21', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834026950887473633, 834026950736478625, 831858961039866529, '2021-04-20 19:25:21', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834026950887473665, 834026950736478625, 831859052316310561, '2021-04-20 19:25:21', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834026950891668001, 834026950736478625, 831859095488281761, '2021-04-20 19:25:21', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834026950891668033, 834026950736478625, 831859164782378273, '2021-04-20 19:25:21', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834026950900056673, 834026950736478625, 831859219404799393, '2021-04-20 19:25:21', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834027012703127137, 834027002255115393, 831858877577411073, '2021-04-20 19:25:36', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834027012711515777, 834027002255115393, 831858961039866529, '2021-04-20 19:25:36', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834027012715710113, 834027002255115393, 831859052316310561, '2021-04-20 19:25:36', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834027012715710145, 834027002255115393, 831859095488281761, '2021-04-20 19:25:36', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834027012719904481, 834027002255115393, 831859164782378273, '2021-04-20 19:25:36', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834027012719904513, 834027002255115393, 831859219404799393, '2021-04-20 19:25:36', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834027567521467873, 834027559053167585, 831858877577411073, '2021-04-20 19:27:48', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834027567529856513, 834027559053167585, 831858961039866529, '2021-04-20 19:27:48', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834027567529856545, 834027559053167585, 831859052316310561, '2021-04-20 19:27:48', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834027567534050881, 834027559053167585, 831859095488281761, '2021-04-20 19:27:48', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834027567534050913, 834027559053167585, 831859164782378273, '2021-04-20 19:27:48', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834027567534050945, 834027559053167585, 831859219404799393, '2021-04-20 19:27:48', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834027628582147297, 834027628544398529, 831858877577411073, '2021-04-20 19:28:02', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834027628586341633, 834027628544398529, 831858961039866529, '2021-04-20 19:28:02', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834027628586341665, 834027628544398529, 831859052316310561, '2021-04-20 19:28:02', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834027628590536001, 834027628544398529, 831859095488281761, '2021-04-20 19:28:02', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834027628590536033, 834027628544398529, 831859164782378273, '2021-04-20 19:28:02', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834027628590536065, 834027628544398529, 831859219404799393, '2021-04-20 19:28:02', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834027686337715041, 834027677340932449, 831858877577411073, '2021-04-20 19:28:16', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834027686346103681, 834027677340932449, 831858961039866529, '2021-04-20 19:28:16', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834027686346103713, 834027677340932449, 831859052316310561, '2021-04-20 19:28:16', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834027686346103745, 834027677340932449, 831859095488281761, '2021-04-20 19:28:16', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834027686346103777, 834027677340932449, 831859164782378273, '2021-04-20 19:28:16', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834027686346103809, 834027677340932449, 831859219404799393, '2021-04-20 19:28:16', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834027931217962241, 834027914512048929, 831858877577411073, '2021-04-20 19:29:15', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834027931226350881, 834027914512048929, 831858961039866529, '2021-04-20 19:29:15', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834027931230545217, 834027914512048929, 831859052316310561, '2021-04-20 19:29:15', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834027931230545249, 834027914512048929, 831859095488281761, '2021-04-20 19:29:15', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834027931230545281, 834027914512048929, 831859164782378273, '2021-04-20 19:29:15', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834027931230545313, 834027914512048929, 831859219404799393, '2021-04-20 19:29:15', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834028185279540705, 834028154208136193, 831858877577411073, '2021-04-20 19:30:15', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834028185287929345, 834028154208136193, 831858961039866529, '2021-04-20 19:30:15', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834028185287929377, 834028154208136193, 831859052316310561, '2021-04-20 19:30:15', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834028185287929409, 834028154208136193, 831859095488281761, '2021-04-20 19:30:15', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834028185287929441, 834028154208136193, 831859164782378273, '2021-04-20 19:30:15', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834028185287929473, 834028154208136193, 831859219404799393, '2021-04-20 19:30:15', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834028594610058241, 834028570081767969, 831858877577411073, '2021-04-20 19:31:53', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834028594614252577, 834028570081767969, 831858961039866529, '2021-04-20 19:31:53', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834028594614252609, 834028570081767969, 831859052316310561, '2021-04-20 19:31:53', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834028594614252641, 834028570081767969, 831859095488281761, '2021-04-20 19:31:53', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834028594614252673, 834028570081767969, 831859164782378273, '2021-04-20 19:31:53', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834028594614252705, 834028570081767969, 831859219404799393, '2021-04-20 19:31:53', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834029353623895169, 834029332006451873, 831858877577411073, '2021-04-20 19:34:54', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834029353632283809, 834029332006451873, 831858961039866529, '2021-04-20 19:34:54', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834029353632283841, 834029332006451873, 831859052316310561, '2021-04-20 19:34:54', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834029353632283873, 834029332006451873, 831859095488281761, '2021-04-20 19:34:54', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834029353632283905, 834029332006451873, 831859164782378273, '2021-04-20 19:34:54', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834029353632283937, 834029332006451873, 831859219404799393, '2021-04-20 19:34:54', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834030555669480513, 834030555640120353, 831858877577411073, '2021-04-20 19:39:40', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834030555703034977, 834030555640120353, 831858961039866529, '2021-04-20 19:39:40', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834030555703035009, 834030555640120353, 831859052316310561, '2021-04-20 19:39:40', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834030555703035041, 834030555640120353, 831859095488281761, '2021-04-20 19:39:40', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834030555703035073, 834030555640120353, 831859164782378273, '2021-04-20 19:39:40', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834030555703035105, 834030555640120353, 831859219404799393, '2021-04-20 19:39:40', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031001507220129, 834030950991022273, 831858877577411073, '2021-04-20 19:41:27', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031001515608769, 834030950991022273, 831858961039866529, '2021-04-20 19:41:27', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031001515608801, 834030950991022273, 831859052316310561, '2021-04-20 19:41:27', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031001515608833, 834030950991022273, 831859095488281761, '2021-04-20 19:41:27', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031001515608865, 834030950991022273, 831859164782378273, '2021-04-20 19:41:27', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031001515608897, 834030950991022273, 831859219404799393, '2021-04-20 19:41:27', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031464432554337, 834031438146850689, 831858877577411073, '2021-04-20 19:43:17', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031464436748673, 834031438146850689, 831858961039866529, '2021-04-20 19:43:17', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031464436748705, 834031438146850689, 831859052316310561, '2021-04-20 19:43:17', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031464440943041, 834031438146850689, 831859095488281761, '2021-04-20 19:43:17', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031464440943073, 834031438146850689, 831859164782378273, '2021-04-20 19:43:17', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031464440943105, 834031438146850689, 831859219404799393, '2021-04-20 19:43:17', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031703054899137, 834031688613909953, 831858877577411073, '2021-04-20 19:44:14', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031703063287777, 834031688613909953, 831858961039866529, '2021-04-20 19:44:14', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031703063287809, 834031688613909953, 831859052316310561, '2021-04-20 19:44:14', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031703063287841, 834031688613909953, 831859095488281761, '2021-04-20 19:44:14', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031703063287873, 834031688613909953, 831859164782378273, '2021-04-20 19:44:14', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031703063287905, 834031688613909953, 831859219404799393, '2021-04-20 19:44:14', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031752577047841, 834031743102114625, 831858877577411073, '2021-04-20 19:44:26', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031752581242177, 834031743102114625, 831858961039866529, '2021-04-20 19:44:26', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031752581242209, 834031743102114625, 831859052316310561, '2021-04-20 19:44:26', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031752581242241, 834031743102114625, 831859095488281761, '2021-04-20 19:44:26', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031752585436577, 834031743102114625, 831859164782378273, '2021-04-20 19:44:26', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031752585436609, 834031743102114625, 831859219404799393, '2021-04-20 19:44:26', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031826560377857, 834031795451224033, 831858877577411073, '2021-04-20 19:44:43', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031826568766497, 834031795451224033, 831858961039866529, '2021-04-20 19:44:43', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031826568766529, 834031795451224033, 831859052316310561, '2021-04-20 19:44:43', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031826568766561, 834031795451224033, 831859095488281761, '2021-04-20 19:44:43', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031826568766593, 834031795451224033, 831859164782378273, '2021-04-20 19:44:43', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031826568766625, 834031795451224033, 831859219404799393, '2021-04-20 19:44:43', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031886287268577, 834031856230885089, 831858877577411073, '2021-04-20 19:44:57', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031886291462913, 834031856230885089, 831858961039866529, '2021-04-20 19:44:57', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031886291462945, 834031856230885089, 831859164782378273, '2021-04-20 19:44:57', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031886291462977, 834031856230885089, 831859219404799393, '2021-04-20 19:44:57', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031886291463009, 834031856230885089, 831859052316310561, '2021-04-20 19:44:57', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834031886295657345, 834031856230885089, 831859095488281761, '2021-04-20 19:44:57', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834036394929193441, 834036383139004385, 831858877577411073, '2021-04-20 20:02:52', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834036394937582081, 834036383139004385, 831858961039866529, '2021-04-20 20:02:52', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834036394937582113, 834036383139004385, 831859052316310561, '2021-04-20 20:02:52', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834036394937582145, 834036383139004385, 831859095488281761, '2021-04-20 20:02:52', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834036394937582177, 834036383139004385, 831859164782378273, '2021-04-20 20:02:52', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834036394937582209, 834036383139004385, 831859219404799393, '2021-04-20 20:02:52', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834067147096373377, 834004562678405921, 831859095488281761, '2021-04-20 22:05:04', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834067336972525857, 100, 831858877577411073, '2021-04-20 22:05:50', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834067336976720193, 100, 831858961039866529, '2021-04-20 22:05:50', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834067336976720225, 100, 831859052316310561, '2021-04-20 22:05:50', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834067336976720257, 100, 831859095488281761, '2021-04-20 22:05:50', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834067336976720289, 100, 831859164782378273, '2021-04-20 22:05:50', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834067336980914625, 100, 831859219404799393, '2021-04-20 22:05:50', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834067350662734561, 645198153556958497, 831859095488281761, '2021-04-20 22:05:53', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834734304385838081, 834734304285174753, 831858877577411073, '2021-04-22 18:16:07', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834734304394226721, 834734304285174753, 831858961039866529, '2021-04-22 18:16:07', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834734304398421057, 834734304285174753, 831859052316310561, '2021-04-22 18:16:07', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834734304398421089, 834734304285174753, 831859095488281761, '2021-04-22 18:16:07', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834734304398421121, 834734304285174753, 831859164782378273, '2021-04-22 18:16:07', 1);
INSERT INTO `itcast_auth_role_org` VALUES (834734304402615457, 834734304285174753, 831859219404799393, '2021-04-22 18:16:07', 1);
INSERT INTO `itcast_auth_role_org` VALUES (857940013785073153, 857940013768295905, 856959818055818209, '2021-06-25 11:07:19', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (857940013789267489, 857940013768295905, 856959868358106209, '2021-06-25 11:07:19', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (857940013793461825, 857940013768295905, 856959895214234849, '2021-06-25 11:07:19', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (857945026951435585, 857939868301440929, 856959818055818209, '2021-06-25 11:27:14', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (857945026955629921, 857939868301440929, 856959868358106209, '2021-06-25 11:27:14', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (857945026955629953, 857939868301440929, 856959895214234849, '2021-06-25 11:27:14', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (857945048795371169, 857939725581858049, 856959818055818209, '2021-06-25 11:27:20', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (857945048799565505, 857939725581858049, 856959868358106209, '2021-06-25 11:27:20', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (857945048799565537, 857939725581858049, 856959895214234849, '2021-06-25 11:27:20', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (857945071092291585, 857939640307462945, 856959818055818209, '2021-06-25 11:27:25', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (857945071100680225, 857939640307462945, 856959868358106209, '2021-06-25 11:27:25', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (857945071100680257, 857939640307462945, 856959895214234849, '2021-06-25 11:27:25', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (857945090771966305, 857939588088377665, 856959818055818209, '2021-06-25 11:27:30', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (857945090776160641, 857939588088377665, 856959868358106209, '2021-06-25 11:27:30', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (857945090776160673, 857939588088377665, 856959895214234849, '2021-06-25 11:27:30', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (857945098686618337, 857945098669841089, 856959818055818209, '2021-06-25 11:27:32', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (857945098695006977, 857945098669841089, 856959868358106209, '2021-06-25 11:27:32', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (857945098695007009, 857945098669841089, 856959895214234849, '2021-06-25 11:27:32', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (857945110996900865, 857939052358313665, 856959818055818209, '2021-06-25 11:27:35', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (857945111001095201, 857939052358313665, 856959868358106209, '2021-06-25 11:27:35', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (857945111001095233, 857939052358313665, 856959895214234849, '2021-06-25 11:27:35', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (857945132442377729, 856960598519324385, 856959818055818209, '2021-06-25 11:27:40', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (857945132446572065, 856960598519324385, 856959868358106209, '2021-06-25 11:27:40', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (857945132446572097, 856960598519324385, 856959895214234849, '2021-06-25 11:27:40', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (864904849676845217, 864904849311940737, 860164944203622593, '2021-07-14 16:23:06', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (864904849697816769, 864904849311940737, 860164099101696673, '2021-07-14 16:23:06', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (864904849697816801, 864904849311940737, 856959818055818209, '2021-07-14 16:23:06', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (864904849706205441, 864904849311940737, 856959868358106209, '2021-07-14 16:23:06', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (864904849710399777, 864904849311940737, 856959895214234849, '2021-07-14 16:23:06', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (864904849714594113, 864904849311940737, 860169970170998305, '2021-07-14 16:23:06', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (872875447300400129, 872875447132627937, 834018221249037409, '2021-08-05 16:15:24', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (872875447354926113, 872875447132627937, 860164944203622593, '2021-08-05 16:15:24', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (872875447354926145, 872875447132627937, 860164099101696673, '2021-08-05 16:15:24', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (872875447359120481, 872875447132627937, 856959117544133665, '2021-08-05 16:15:24', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (872875447359120513, 872875447132627937, 856959818055818209, '2021-08-05 16:15:24', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (872875447363314849, 872875447132627937, 856959868358106209, '2021-08-05 16:15:24', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (872875447363314881, 872875447132627937, 856959895214234849, '2021-08-05 16:15:24', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (872875447363314913, 872875447132627937, 860169970170998305, '2021-08-05 16:15:24', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (872875447363314945, 872875447132627937, 831858961039866529, '2021-08-05 16:15:24', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (872875447363314977, 872875447132627937, 831859164782378273, '2021-08-05 16:15:24', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (872875447367509313, 872875447132627937, 831859219404799393, '2021-08-05 16:15:24', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (872875447367509345, 872875447132627937, 831859095488281761, '2021-08-05 16:15:24', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (872875447367509377, 872875447132627937, 831859052316310561, '2021-08-05 16:15:24', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (872875447367509409, 872875447132627937, 831858877577411073, '2021-08-05 16:15:24', 856959053190927169);
INSERT INTO `itcast_auth_role_org` VALUES (874248805711628801, 856958590768908481, 860164944203622593, '2021-08-09 11:12:38', 1);
INSERT INTO `itcast_auth_role_org` VALUES (874248805728406049, 856958590768908481, 860164099101696673, '2021-08-09 11:12:38', 1);
INSERT INTO `itcast_auth_role_org` VALUES (874248805728406081, 856958590768908481, 856959818055818209, '2021-08-09 11:12:38', 1);
INSERT INTO `itcast_auth_role_org` VALUES (874248805736794721, 856958590768908481, 873610883387885665, '2021-08-09 11:12:38', 1);
INSERT INTO `itcast_auth_role_org` VALUES (874248805740989057, 856958590768908481, 873610940698855649, '2021-08-09 11:12:38', 1);
INSERT INTO `itcast_auth_role_org` VALUES (874248805745183393, 856958590768908481, 874227091069997953, '2021-08-09 11:12:38', 1);
INSERT INTO `itcast_auth_role_org` VALUES (874248805745183425, 856958590768908481, 874227150599754753, '2021-08-09 11:12:38', 1);
INSERT INTO `itcast_auth_role_org` VALUES (874248805745183457, 856958590768908481, 874226837155221889, '2021-08-09 11:12:38', 1);
INSERT INTO `itcast_auth_role_org` VALUES (874248805749377793, 856958590768908481, 874227341549639265, '2021-08-09 11:12:38', 1);
INSERT INTO `itcast_auth_role_org` VALUES (874248805749377825, 856958590768908481, 874227005095154401, '2021-08-09 11:12:38', 1);
INSERT INTO `itcast_auth_role_org` VALUES (874248805749377857, 856958590768908481, 873611036215740769, '2021-08-09 11:12:38', 1);
INSERT INTO `itcast_auth_role_org` VALUES (874248805753572193, 856958590768908481, 874227400349587233, '2021-08-09 11:12:38', 1);
INSERT INTO `itcast_auth_role_org` VALUES (874248805757766529, 856958590768908481, 874227210372781217, '2021-08-09 11:12:38', 1);
INSERT INTO `itcast_auth_role_org` VALUES (874248805757766561, 856958590768908481, 874227474735568801, '2021-08-09 11:12:38', 1);
INSERT INTO `itcast_auth_role_org` VALUES (874248805761960897, 856958590768908481, 874227615173449825, '2021-08-09 11:12:38', 1);
INSERT INTO `itcast_auth_role_org` VALUES (874248805761960929, 856958590768908481, 874227278576358753, '2021-08-09 11:12:38', 1);
INSERT INTO `itcast_auth_role_org` VALUES (874248805761960961, 856958590768908481, 856959868358106209, '2021-08-09 11:12:38', 1);
INSERT INTO `itcast_auth_role_org` VALUES (874248805766155297, 856958590768908481, 856959895214234849, '2021-08-09 11:12:38', 1);
INSERT INTO `itcast_auth_role_org` VALUES (877192894820135265, 874250002388504161, 860164944203622593, '2021-08-17 14:11:24', 1);
INSERT INTO `itcast_auth_role_org` VALUES (877192894832718209, 874250002388504161, 860164099101696673, '2021-08-17 14:11:24', 1);
INSERT INTO `itcast_auth_role_org` VALUES (877192894836912545, 874250002388504161, 856959818055818209, '2021-08-17 14:11:24', 1);
INSERT INTO `itcast_auth_role_org` VALUES (877192894836912577, 874250002388504161, 873610883387885665, '2021-08-17 14:11:24', 1);
INSERT INTO `itcast_auth_role_org` VALUES (877192894836912609, 874250002388504161, 873610940698855649, '2021-08-17 14:11:24', 1);
INSERT INTO `itcast_auth_role_org` VALUES (877192894841106945, 874250002388504161, 874227091069997953, '2021-08-17 14:11:24', 1);
INSERT INTO `itcast_auth_role_org` VALUES (877192894841106977, 874250002388504161, 874227150599754753, '2021-08-17 14:11:24', 1);
INSERT INTO `itcast_auth_role_org` VALUES (877192894845301313, 874250002388504161, 874226837155221889, '2021-08-17 14:11:24', 1);
INSERT INTO `itcast_auth_role_org` VALUES (877192894845301345, 874250002388504161, 874227341549639265, '2021-08-17 14:11:24', 1);
INSERT INTO `itcast_auth_role_org` VALUES (877192894845301377, 874250002388504161, 874227005095154401, '2021-08-17 14:11:24', 1);
INSERT INTO `itcast_auth_role_org` VALUES (877192894849495713, 874250002388504161, 873611036215740769, '2021-08-17 14:11:24', 1);
INSERT INTO `itcast_auth_role_org` VALUES (877192894849495745, 874250002388504161, 874227400349587233, '2021-08-17 14:11:24', 1);
INSERT INTO `itcast_auth_role_org` VALUES (877192894849495777, 874250002388504161, 874227210372781217, '2021-08-17 14:11:24', 1);
INSERT INTO `itcast_auth_role_org` VALUES (877192894853690113, 874250002388504161, 874227474735568801, '2021-08-17 14:11:24', 1);
INSERT INTO `itcast_auth_role_org` VALUES (877192894853690145, 874250002388504161, 874227615173449825, '2021-08-17 14:11:24', 1);
INSERT INTO `itcast_auth_role_org` VALUES (877192894853690177, 874250002388504161, 874227278576358753, '2021-08-17 14:11:24', 1);
INSERT INTO `itcast_auth_role_org` VALUES (877192894857884513, 874250002388504161, 856959868358106209, '2021-08-17 14:11:24', 1);
INSERT INTO `itcast_auth_role_org` VALUES (877192894857884545, 874250002388504161, 856959895214234849, '2021-08-17 14:11:24', 1);
INSERT INTO `itcast_auth_role_org` VALUES (877220666120618721, 877220449673557729, 860164944203622593, '2021-08-17 16:01:45', 877215047032506913);
INSERT INTO `itcast_auth_role_org` VALUES (877220666133201665, 877220449673557729, 860164099101696673, '2021-08-17 16:01:45', 877215047032506913);
INSERT INTO `itcast_auth_role_org` VALUES (877220666137396001, 877220449673557729, 856959818055818209, '2021-08-17 16:01:45', 877215047032506913);
INSERT INTO `itcast_auth_role_org` VALUES (877220666137396033, 877220449673557729, 873610883387885665, '2021-08-17 16:01:45', 877215047032506913);
INSERT INTO `itcast_auth_role_org` VALUES (877220666137396065, 877220449673557729, 873610940698855649, '2021-08-17 16:01:45', 877215047032506913);
INSERT INTO `itcast_auth_role_org` VALUES (877220666141590401, 877220449673557729, 874227091069997953, '2021-08-17 16:01:45', 877215047032506913);
INSERT INTO `itcast_auth_role_org` VALUES (877220666141590433, 877220449673557729, 874227150599754753, '2021-08-17 16:01:45', 877215047032506913);
INSERT INTO `itcast_auth_role_org` VALUES (877220666141590465, 877220449673557729, 874226837155221889, '2021-08-17 16:01:45', 877215047032506913);
INSERT INTO `itcast_auth_role_org` VALUES (877220666145784801, 877220449673557729, 874227341549639265, '2021-08-17 16:01:45', 877215047032506913);
INSERT INTO `itcast_auth_role_org` VALUES (877220666145784833, 877220449673557729, 874227005095154401, '2021-08-17 16:01:45', 877215047032506913);
INSERT INTO `itcast_auth_role_org` VALUES (877220666145784865, 877220449673557729, 873611036215740769, '2021-08-17 16:01:45', 877215047032506913);
INSERT INTO `itcast_auth_role_org` VALUES (877220666149979201, 877220449673557729, 874227400349587233, '2021-08-17 16:01:45', 877215047032506913);
INSERT INTO `itcast_auth_role_org` VALUES (877220666149979233, 877220449673557729, 874227210372781217, '2021-08-17 16:01:45', 877215047032506913);
INSERT INTO `itcast_auth_role_org` VALUES (877220666149979265, 877220449673557729, 874227474735568801, '2021-08-17 16:01:45', 877215047032506913);
INSERT INTO `itcast_auth_role_org` VALUES (877220666158367905, 877220449673557729, 874227615173449825, '2021-08-17 16:01:45', 877215047032506913);
INSERT INTO `itcast_auth_role_org` VALUES (877220666162562241, 877220449673557729, 874227278576358753, '2021-08-17 16:01:45', 877215047032506913);
INSERT INTO `itcast_auth_role_org` VALUES (877220666162562273, 877220449673557729, 856959868358106209, '2021-08-17 16:01:45', 877215047032506913);
INSERT INTO `itcast_auth_role_org` VALUES (877220666166756609, 877220449673557729, 856959895214234849, '2021-08-17 16:01:45', 877215047032506913);
COMMIT;

-- ----------------------------
-- Table structure for itcast_auth_user
-- ----------------------------
DROP TABLE IF EXISTS `itcast_auth_user`;
CREATE TABLE `itcast_auth_user` (
                                    `id` bigint NOT NULL COMMENT 'ID',
                                    `account` varchar(30) NOT NULL COMMENT '账号',
                                    `name` varchar(50) NOT NULL COMMENT '姓名',
                                    `org_id` bigint DEFAULT NULL COMMENT '组织ID\n#c_core_org',
                                    `station_id` bigint DEFAULT NULL COMMENT '岗位ID\n#c_core_station',
                                    `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
                                    `mobile` varchar(20) DEFAULT '' COMMENT '手机',
                                    `sex` varchar(1) DEFAULT 'N' COMMENT '性别\n#Sex{W:女;M:男;N:未知}',
                                    `status` bit(1) DEFAULT b'0' COMMENT '启用状态 1启用 0禁用',
                                    `avatar` varchar(255) DEFAULT '' COMMENT '头像',
                                    `work_describe` varchar(255) DEFAULT '' COMMENT '工作描述\r\n比如：  市长、管理员、局长等等   用于登陆展示',
                                    `password_error_last_time` datetime DEFAULT NULL COMMENT '最后一次输错密码时间',
                                    `password_error_num` int DEFAULT '0' COMMENT '密码错误次数',
                                    `password_expire_time` datetime DEFAULT NULL COMMENT '密码过期时间',
                                    `password` varchar(64) NOT NULL DEFAULT '' COMMENT '密码',
                                    `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
                                    `superior` bigint DEFAULT NULL COMMENT '上级领导',
                                    `create_user` bigint DEFAULT '0' COMMENT '创建人id',
                                    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                    `update_user` bigint DEFAULT '0' COMMENT '更新人id',
                                    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                    PRIMARY KEY (`id`) USING BTREE,
                                    UNIQUE KEY `UN_ACCOUNT` (`account`) USING BTREE
) ENGINE=InnoDB  ROW_FORMAT=COMPACT COMMENT='用户';

-- ----------------------------
-- Records of itcast_auth_user
-- ----------------------------
BEGIN;
INSERT INTO `itcast_auth_user` VALUES (1, 'admin', '平台管理员', 860164099101696673, 857940157460957537, '', '13756644565', 'M', b'1', 'http://oss-file-services.oss-cn-zhangjiakou.aliyuncs.com/pd_files/2021/04/ffdc9d9b-287f-4c5c-beb5-8487132898d3.jpg', '超级管理员', '2021-08-31 06:03:21', 0, NULL, 'e10adc3949ba59abbe56e057f20f883e', '2021-08-31 14:03:22', NULL, 1, '2019-09-02 19:32:02', 1, '2021-08-09 11:00:28');
INSERT INTO `itcast_auth_user` VALUES (856959053190927169, 'lidingyu', '李定宇', 856959818055818209, 856959193226155201, NULL, '18510971101', 'M', b'1', '', '', '2021-08-27 02:41:10', 0, NULL, 'e10adc3949ba59abbe56e057f20f883e', '2021-08-27 10:41:10', NULL, 1, '2021-06-22 18:09:20', 1, '2021-08-30 15:32:51');
INSERT INTO `itcast_auth_user` VALUES (856961019472258305, 'wangweilong', '王伟龙', 856959868358106209, 856960124659441089, NULL, '18510971102', 'M', b'1', '', '', '2021-08-11 07:37:10', 0, NULL, 'e10adc3949ba59abbe56e057f20f883e', '2021-06-22 18:17:33', 857949190481772609, 856959053190927169, '2021-06-22 18:17:09', 1, '2021-08-30 15:32:18');
INSERT INTO `itcast_auth_user` VALUES (857945286130066209, 'zhangfeixiong', '张飞熊', 860164099101696673, 857940157460957537, NULL, '17610012001', 'M', b'1', '', '', '2021-08-30 06:41:27', 0, NULL, 'e10adc3949ba59abbe56e057f20f883e', '2021-08-23 14:46:30', 857945286130066209, 856959053190927169, '2021-06-25 11:28:16', 1, '2021-08-30 15:32:07');
INSERT INTO `itcast_auth_user` VALUES (857946496711058625, 'xuxiaoqing', '徐晓庆', 860164099101696673, 857940190092642753, NULL, '17610012003', 'M', b'1', '', '', '2021-08-10 05:39:07', 0, NULL, 'e10adc3949ba59abbe56e057f20f883e', NULL, 857946496711058625, 856959053190927169, '2021-06-25 11:33:05', 1, '2021-08-30 15:31:53');
INSERT INTO `itcast_auth_user` VALUES (857946656644064609, 'zhaodapeng', '赵大鹏', 856959818055818209, 857940212792216097, NULL, '17610012004', 'M', b'1', '', '', '2021-08-06 09:33:41', 0, NULL, 'e10adc3949ba59abbe56e057f20f883e', NULL, 857946496711058625, 856959053190927169, '2021-06-25 11:33:43', 1, '2021-08-30 15:31:36');
INSERT INTO `itcast_auth_user` VALUES (857947344241487297, 'zhangweilong', '张伟龙', 860164944203622593, 857940249404296065, NULL, '17610012006', 'M', b'1', '', '', '2021-08-10 01:44:36', 0, NULL, 'e10adc3949ba59abbe56e057f20f883e', NULL, 857946496711058625, 856959053190927169, '2021-06-25 11:36:27', 1, '2021-08-30 15:31:09');
INSERT INTO `itcast_auth_user` VALUES (857948632266108577, 'zhangqianqian', '张倩倩', 856959868358106209, 856960124659441089, NULL, '17610012007', 'M', b'1', '', '', '2021-08-06 09:33:59', 0, NULL, 'e10adc3949ba59abbe56e057f20f883e', NULL, 857949190481772609, 856959053190927169, '2021-06-25 11:41:34', 1, '2021-08-30 15:30:31');
INSERT INTO `itcast_auth_user` VALUES (857949190481772609, 'boxiaogu', '薄小谷', 856959868358106209, 857940231804996385, NULL, '17600111002', 'M', b'1', '', '', '2021-08-06 09:32:44', 0, NULL, 'e10adc3949ba59abbe56e057f20f883e', NULL, 857946656644064609, 856959053190927169, '2021-06-25 11:43:47', 1, '2021-08-30 15:30:14');
INSERT INTO `itcast_auth_user` VALUES (860107506054073857, 'mabiancheng', '马边城', 856959895214234849, 856960124659441089, NULL, '17610092011', 'M', b'1', '', '', '2021-07-14 06:42:25', 0, NULL, 'e10adc3949ba59abbe56e057f20f883e', NULL, 857949190481772609, 856959053190927169, '2021-07-01 10:40:10', 1, '2021-08-30 15:29:43');
INSERT INTO `itcast_auth_user` VALUES (864905248198641409, 'zhangyihu', '张一虎', 860164099101696673, 857940231804996385, NULL, '17800001111', 'M', b'1', '', '', '2021-08-24 09:13:00', 0, NULL, 'e10adc3949ba59abbe56e057f20f883e', NULL, 857946496711058625, 856959053190927169, '2021-07-14 16:24:41', 1, '2021-08-30 15:29:14');
INSERT INTO `itcast_auth_user` VALUES (864905381179049889, 'wangyuren', '王育人', 860164099101696673, 857940231804996385, NULL, '17800002222', 'M', b'1', '', '', NULL, 0, NULL, 'e10adc3949ba59abbe56e057f20f883e', NULL, 857946496711058625, 856959053190927169, '2021-07-14 16:25:12', 1, '2021-08-30 15:29:04');
INSERT INTO `itcast_auth_user` VALUES (877215047032506913, 'lichuanbo', '李传播', 860164099101696673, 856959193226155201, NULL, '17691000111', 'M', b'1', '', '', '2021-08-17 07:46:32', 0, NULL, 'e10adc3949ba59abbe56e057f20f883e', '2021-08-17 15:46:33', NULL, 1, '2021-08-17 15:39:25', 1, '2021-08-30 15:28:51');
COMMIT;

-- ----------------------------
-- Table structure for itcast_auth_user_group
-- ----------------------------
DROP TABLE IF EXISTS `itcast_auth_user_group`;
CREATE TABLE `itcast_auth_user_group` (
                                          `id` bigint NOT NULL,
                                          `name` varchar(30) NOT NULL DEFAULT '' COMMENT '用户组名称',
                                          `user_count` int NOT NULL COMMENT '用户数量',
                                          `role_id` bigint NOT NULL COMMENT '角色id',
                                          `describe_` varchar(100) DEFAULT '' COMMENT '功能描述',
                                          `status` bit(1) DEFAULT b'1' COMMENT '状态',
                                          `create_user` bigint DEFAULT '0' COMMENT '创建人id',
                                          `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                          `update_user` bigint DEFAULT '0' COMMENT '更新人id',
                                          `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                                          PRIMARY KEY (`id`) USING BTREE,
                                          UNIQUE KEY `user_group_name` (`name`) USING BTREE
) ENGINE=InnoDB  COMMENT='用户组';

-- ----------------------------
-- Records of itcast_auth_user_group
-- ----------------------------
BEGIN;
INSERT INTO `itcast_auth_user_group` VALUES (833740654944191361, '产品组', 1, 100, '', b'1', 1, '2021-04-20 00:27:43', 1, '2021-04-20 00:27:43');
INSERT INTO `itcast_auth_user_group` VALUES (834004912844072385, '测试组', 1, 643779012732130273, '', b'1', 1, '2021-04-20 17:57:46', 1, '2021-08-10 15:45:51');
INSERT INTO `itcast_auth_user_group` VALUES (834018512866413473, '九点钟', 1, 834018171361985217, '', b'1', 1, '2021-04-20 10:51:49', 1, '2021-04-20 10:51:49');
COMMIT;

-- ----------------------------
-- Table structure for itcast_auth_user_group_user
-- ----------------------------
DROP TABLE IF EXISTS `itcast_auth_user_group_user`;
CREATE TABLE `itcast_auth_user_group_user` (
                                               `id` bigint NOT NULL,
                                               `group_id` bigint NOT NULL DEFAULT '0' COMMENT '用户组ID',
                                               `user_id` bigint NOT NULL DEFAULT '0' COMMENT '用户ID',
                                               `create_user` bigint DEFAULT NULL COMMENT '创建人ID',
                                               `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                               PRIMARY KEY (`id`) USING BTREE,
                                               KEY `IDX_KEY` (`group_id`,`user_id`) USING BTREE
) ENGINE=InnoDB  COMMENT='用户组、用户绑定';

-- ----------------------------
-- Records of itcast_auth_user_group_user
-- ----------------------------
BEGIN;
INSERT INTO `itcast_auth_user_group_user` VALUES (831823440754270945, 831823425554112993, 1, 1, '2021-04-14 17:29:23');
INSERT INTO `itcast_auth_user_group_user` VALUES (831823440762659585, 831823425554112993, 831588401974178945, 1, '2021-04-14 17:29:23');
INSERT INTO `itcast_auth_user_group_user` VALUES (831823440762659617, 831823425554112993, 830496053856831713, 1, '2021-04-14 17:29:23');
INSERT INTO `itcast_auth_user_group_user` VALUES (831823440762659649, 831823425554112993, 831120225570138209, 1, '2021-04-14 17:29:23');
INSERT INTO `itcast_auth_user_group_user` VALUES (831849911145289793, 831221167757984449, 1, 1, '2021-04-14 19:14:34');
INSERT INTO `itcast_auth_user_group_user` VALUES (831856608299556897, 831851174431909921, 1, 1, '2021-04-14 19:41:11');
INSERT INTO `itcast_auth_user_group_user` VALUES (831856608303751233, 831851174431909921, 830496053856831713, 1, '2021-04-14 19:41:11');
INSERT INTO `itcast_auth_user_group_user` VALUES (831856608303751265, 831851174431909921, 831120225570138209, 1, '2021-04-14 19:41:11');
INSERT INTO `itcast_auth_user_group_user` VALUES (831856658568290561, 831856658509570273, 1, 1, '2021-04-14 19:41:23');
INSERT INTO `itcast_auth_user_group_user` VALUES (831856658576679201, 831856658509570273, 830496053856831713, 1, '2021-04-14 19:41:23');
INSERT INTO `itcast_auth_user_group_user` VALUES (831856658576679233, 831856658509570273, 831120225570138209, 1, '2021-04-14 19:41:23');
INSERT INTO `itcast_auth_user_group_user` VALUES (831907837855887329, 831907837809749953, 830496053856831713, 1, '2021-04-14 23:04:45');
INSERT INTO `itcast_auth_user_group_user` VALUES (831908494243492961, 831908494201549889, 830496053856831713, 1, '2021-04-14 23:07:21');
INSERT INTO `itcast_auth_user_group_user` VALUES (831908853435299137, 831907964393844897, 830496053856831713, 1, '2021-04-14 23:08:47');
INSERT INTO `itcast_auth_user_group_user` VALUES (831909211654026689, 831909211591112097, 830496053856831713, 1, '2021-04-14 23:10:12');
INSERT INTO `itcast_auth_user_group_user` VALUES (831911166946279553, 831851997023007649, 1, 1, '2021-04-14 23:17:59');
INSERT INTO `itcast_auth_user_group_user` VALUES (831911166954668193, 831851997023007649, 830496053856831713, 1, '2021-04-14 23:17:59');
INSERT INTO `itcast_auth_user_group_user` VALUES (831922499536262017, 831922499490124641, 830496053856831713, 1, '2021-04-15 00:03:00');
INSERT INTO `itcast_auth_user_group_user` VALUES (831922594474333217, 831922594419807233, 830496053856831713, 1, '2021-04-15 00:03:23');
INSERT INTO `itcast_auth_user_group_user` VALUES (831922784950261537, 831922784895735553, 830496053856831713, 1, '2021-04-15 00:04:09');
INSERT INTO `itcast_auth_user_group_user` VALUES (831958832900187841, 831922749437089409, 830496053856831713, 1, '2021-04-15 02:27:23');
INSERT INTO `itcast_auth_user_group_user` VALUES (832186404787197409, 832185971150687681, 831120225570138209, 1, '2021-04-15 17:31:40');
INSERT INTO `itcast_auth_user_group_user` VALUES (833707812038146625, 832186519174256705, 1, 1, '2021-04-19 22:17:12');
INSERT INTO `itcast_auth_user_group_user` VALUES (833707812042340961, 832186519174256705, 830496053856831713, 1, '2021-04-19 22:17:12');
INSERT INTO `itcast_auth_user_group_user` VALUES (833707812046535297, 832186519174256705, 831120225570138209, 1, '2021-04-19 22:17:12');
INSERT INTO `itcast_auth_user_group_user` VALUES (833708017127029601, 832188866604567073, 1, 1, '2021-04-19 22:18:01');
INSERT INTO `itcast_auth_user_group_user` VALUES (833708017131223937, 832188866604567073, 830496053856831713, 1, '2021-04-19 22:18:01');
INSERT INTO `itcast_auth_user_group_user` VALUES (833708017131223969, 832188866604567073, 831120225570138209, 1, '2021-04-19 22:18:01');
INSERT INTO `itcast_auth_user_group_user` VALUES (833711518632672449, 832192384258278177, 831120225570138209, 1, '2021-04-19 22:31:56');
INSERT INTO `itcast_auth_user_group_user` VALUES (833724539367096737, 833724539304182145, 1, 1, '2021-04-19 23:23:40');
INSERT INTO `itcast_auth_user_group_user` VALUES (833724539371291073, 833724539304182145, 830496053856831713, 1, '2021-04-19 23:23:40');
INSERT INTO `itcast_auth_user_group_user` VALUES (833724539371291105, 833724539304182145, 831120225570138209, 1, '2021-04-19 23:23:40');
INSERT INTO `itcast_auth_user_group_user` VALUES (833724539371291137, 833724539304182145, 833724248244650145, 1, '2021-04-19 23:23:40');
INSERT INTO `itcast_auth_user_group_user` VALUES (833740655095186337, 833740654944191361, 831120225570138209, 1, '2021-04-20 00:27:43');
INSERT INTO `itcast_auth_user_group_user` VALUES (834018512908356545, 834018512866413473, 834018444163713697, 1, '2021-04-20 18:51:49');
INSERT INTO `itcast_auth_user_group_user` VALUES (834065426144077217, 834065262868210657, 1, 1, '2021-04-20 21:58:14');
INSERT INTO `itcast_auth_user_group_user` VALUES (834065426152465857, 834065262868210657, 830496053856831713, 1, '2021-04-20 21:58:14');
INSERT INTO `itcast_auth_user_group_user` VALUES (834065426152465889, 834065262868210657, 831120225570138209, 1, '2021-04-20 21:58:14');
INSERT INTO `itcast_auth_user_group_user` VALUES (834473890834085793, 834004912844072385, 1, 1, '2021-04-22 01:01:20');
INSERT INTO `itcast_auth_user_group_user` VALUES (834473890838280129, 834004912844072385, 830496053856831713, 1, '2021-04-22 01:01:20');
INSERT INTO `itcast_auth_user_group_user` VALUES (834473890842474465, 834004912844072385, 831120225570138209, 1, '2021-04-22 01:01:20');
INSERT INTO `itcast_auth_user_group_user` VALUES (834483324515779521, 834483238310248929, 831120225570138209, 1, '2021-04-22 01:38:49');
COMMIT;

-- ----------------------------
-- Table structure for itcast_auth_user_role
-- ----------------------------
DROP TABLE IF EXISTS `itcast_auth_user_role`;
CREATE TABLE `itcast_auth_user_role` (
                                         `id` bigint NOT NULL,
                                         `role_id` bigint NOT NULL DEFAULT '0' COMMENT '角色ID\n#c_auth_role',
                                         `user_id` bigint NOT NULL DEFAULT '0' COMMENT '用户ID\n#c_core_accou',
                                         `type` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0用户 1 用户组',
                                         `application_id` bigint DEFAULT NULL COMMENT '应用id',
                                         `create_user` bigint DEFAULT NULL COMMENT '创建人ID',
                                         `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                         PRIMARY KEY (`id`) USING BTREE,
                                         KEY `IDX_KEY` (`role_id`,`user_id`) USING BTREE
) ENGINE=InnoDB  ROW_FORMAT=COMPACT COMMENT='角色分配\r\n账号角色绑定';

-- ----------------------------
-- Records of itcast_auth_user_role
-- ----------------------------
BEGIN;
INSERT INTO `itcast_auth_user_role` VALUES (872881535085183489, 864904849311940737, 864905381179049889, 0, 856958443553031905, 856959053190927169, '2021-08-05 16:39:36');
INSERT INTO `itcast_auth_user_role` VALUES (872906209529696481, 864904849311940737, 864905248198641409, 0, 856958443553031905, 1, '2021-08-05 18:17:38');
INSERT INTO `itcast_auth_user_role` VALUES (873256177813685601, 857939588088377665, 857946656644064609, 0, 856958443553031905, 1, '2021-08-06 17:28:17');
INSERT INTO `itcast_auth_user_role` VALUES (873256370579703585, 856960598519324385, 857948632266108577, 0, 856958443553031905, 1, '2021-08-06 17:29:03');
INSERT INTO `itcast_auth_user_role` VALUES (873256404280936353, 857939052358313665, 857949190481772609, 0, 856958443553031905, 1, '2021-08-06 17:29:11');
INSERT INTO `itcast_auth_user_role` VALUES (873256430214318113, 857939725581858049, 857947344241487297, 0, 856958443553031905, 1, '2021-08-06 17:29:17');
INSERT INTO `itcast_auth_user_role` VALUES (873256484329228577, 856960598519324385, 856961019472258305, 0, 856958443553031905, 1, '2021-08-06 17:29:30');
INSERT INTO `itcast_auth_user_role` VALUES (874248705597785985, 856958590768908481, 856959053190927169, 0, 1, 1, '2021-08-09 11:12:14');
INSERT INTO `itcast_auth_user_role` VALUES (874589888958174849, 857939640307462945, 857946496711058625, 0, 856958443553031905, 856959053190927169, '2021-08-10 09:47:59');
INSERT INTO `itcast_auth_user_role` VALUES (874589888979146401, 857939868301440929, 857946496711058625, 0, 856958443553031905, 856959053190927169, '2021-08-10 09:47:59');
INSERT INTO `itcast_auth_user_role` VALUES (874647556863305377, 874250002388504161, 857945286130066209, 0, 1, 1, '2021-08-10 13:37:08');
INSERT INTO `itcast_auth_user_role` VALUES (874647556892665537, 856958590768908481, 857945286130066209, 0, 1, 1, '2021-08-10 13:37:08');
INSERT INTO `itcast_auth_user_role` VALUES (874647556892665569, 834734304285174753, 857945286130066209, 0, 1, 1, '2021-08-10 13:37:08');
INSERT INTO `itcast_auth_user_role` VALUES (874978169109632577, 857939868301440929, 857945286130066209, 0, 856958443553031905, 857945286130066209, '2021-08-11 11:30:52');
INSERT INTO `itcast_auth_user_role` VALUES (875052547499391361, 856960598519324385, 860107506054073857, 0, 856958443553031905, 1, '2021-08-11 16:26:25');
INSERT INTO `itcast_auth_user_role` VALUES (877215047166724673, 643779012732130273, 877215047032506913, 0, 1, 1, '2021-08-17 15:39:25');
COMMIT;

-- ----------------------------
-- Table structure for itcast_common_login_log
-- ----------------------------
DROP TABLE IF EXISTS `itcast_common_login_log`;
CREATE TABLE `itcast_common_login_log` (
                                           `id` bigint NOT NULL COMMENT '主键',
                                           `request_ip` varchar(50) DEFAULT '' COMMENT '操作IP',
                                           `user_id` bigint DEFAULT NULL COMMENT '登录人ID',
                                           `user_name` varchar(50) DEFAULT NULL COMMENT '登录人姓名',
                                           `account` varchar(30) DEFAULT '' COMMENT '登录人账号',
                                           `description` varchar(255) DEFAULT '' COMMENT '登录描述',
                                           `login_date` date DEFAULT NULL COMMENT '登录时间',
                                           `ua` varchar(500) DEFAULT '0' COMMENT '浏览器请求头',
                                           `browser` varchar(100) DEFAULT NULL COMMENT '浏览器名称',
                                           `browser_version` varchar(255) DEFAULT NULL COMMENT '浏览器版本',
                                           `operating_system` varchar(100) DEFAULT NULL COMMENT '操作系统',
                                           `location` varchar(50) DEFAULT '' COMMENT '登录地点',
                                           `create_time` datetime DEFAULT NULL,
                                           `create_user` bigint DEFAULT NULL,
                                           PRIMARY KEY (`id`) USING BTREE,
                                           KEY `IDX_BROWSER` (`browser`) USING BTREE,
                                           KEY `IDX_OPERATING` (`operating_system`) USING BTREE,
                                           KEY `IDX_LOGIN_DATE` (`login_date`,`account`) USING BTREE,
                                           KEY `IDX_ACCOUNT_IP` (`account`,`request_ip`) USING BTREE
) ENGINE=InnoDB  ROW_FORMAT=COMPACT COMMENT='登录日志';

-- ----------------------------
-- Records of itcast_common_login_log
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for itcast_common_opt_log
-- ----------------------------
DROP TABLE IF EXISTS `itcast_common_opt_log`;
CREATE TABLE `itcast_common_opt_log` (
                                         `id` bigint NOT NULL COMMENT '主键',
                                         `request_ip` varchar(50) DEFAULT '' COMMENT '操作IP',
                                         `type` varchar(5) DEFAULT 'OPT' COMMENT '日志类型\n#LogType{OPT:操作类型;EX:异常类型}',
                                         `user_name` varchar(50) DEFAULT '' COMMENT '操作人',
                                         `description` varchar(255) DEFAULT '' COMMENT '操作描述',
                                         `class_path` varchar(255) DEFAULT '' COMMENT '类路径',
                                         `action_method` varchar(50) DEFAULT '' COMMENT '请求方法',
                                         `request_uri` varchar(50) DEFAULT '' COMMENT '请求地址',
                                         `http_method` varchar(10) DEFAULT 'GET' COMMENT '请求类型\n#HttpMethod{GET:GET请求;POST:POST请求;PUT:PUT请求;DELETE:DELETE请求;PATCH:PATCH请求;TRACE:TRACE请求;HEAD:HEAD请求;OPTIONS:OPTIONS请求;}',
                                         `params` longtext COMMENT '请求参数',
                                         `result` longtext COMMENT '返回值',
                                         `ex_desc` longtext COMMENT '异常详情信息',
                                         `ex_detail` longtext COMMENT '异常描述',
                                         `start_time` timestamp NULL DEFAULT NULL COMMENT '开始时间',
                                         `finish_time` timestamp NULL DEFAULT NULL COMMENT '完成时间',
                                         `consuming_time` bigint DEFAULT '0' COMMENT '消耗时间',
                                         `ua` varchar(500) DEFAULT '' COMMENT '浏览器',
                                         `create_time` datetime DEFAULT NULL,
                                         `create_user` bigint DEFAULT NULL,
                                         PRIMARY KEY (`id`) USING BTREE,
                                         KEY `index_type` (`type`) USING BTREE COMMENT '日志类型'
) ENGINE=InnoDB  ROW_FORMAT=COMPACT COMMENT='系统日志';

-- ----------------------------
-- Records of itcast_common_opt_log
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for itcast_core_org
-- ----------------------------
DROP TABLE IF EXISTS `itcast_core_org`;
CREATE TABLE `itcast_core_org` (
                                   `id` bigint NOT NULL COMMENT 'ID',
                                   `name` varchar(100)  NOT NULL DEFAULT '' COMMENT '名称',
                                   `abbreviation` varchar(255) DEFAULT '' COMMENT '简称',
                                   `parent_id` bigint DEFAULT '0' COMMENT '父ID',
                                   `org_type` tinyint(1) DEFAULT NULL COMMENT '部门类型 1为分公司，2为一级转运中心 3为二级转运中心 4为网点',
                                   `province_id` bigint DEFAULT NULL COMMENT '省',
                                   `city_id` bigint DEFAULT NULL COMMENT '市',
                                   `county_id` bigint DEFAULT NULL COMMENT '区',
                                   `address` varchar(255) DEFAULT NULL COMMENT '地址',
                                   `contract_number` varchar(20) DEFAULT NULL COMMENT '联系电话',
                                   `manager_id` bigint DEFAULT NULL COMMENT '负责人id',
                                   `tree_path` varchar(255) DEFAULT ',' COMMENT '树结构',
                                   `sort_value` int DEFAULT '1' COMMENT '排序',
                                   `status` bit(1) DEFAULT b'1' COMMENT '状态',
                                   `describe_` varchar(255) DEFAULT '' COMMENT '描述',
                                   `create_time` datetime DEFAULT NULL,
                                   `create_user` bigint DEFAULT NULL,
                                   `update_time` datetime DEFAULT NULL,
                                   `update_user` bigint DEFAULT NULL,
                                   PRIMARY KEY (`id`) USING BTREE,
                                   UNIQUE KEY `PCO_NAME` (`name`) USING BTREE,
                                   FULLTEXT KEY `FU_PATH` (`tree_path`)
) ENGINE=InnoDB  ROW_FORMAT=COMPACT COMMENT='组织';

-- ----------------------------
-- Records of itcast_core_org
-- ----------------------------
BEGIN;
INSERT INTO `itcast_core_org` VALUES (856959818055818209, '工作流项目组', '', 860164099101696673, NULL, NULL, NULL, NULL, NULL, NULL, NULL, ',', 0, b'1', '', '2021-06-22 18:12:22', 856959053190927169, '2021-07-01 14:25:11', 856959053190927169);
INSERT INTO `itcast_core_org` VALUES (856959868358106209, '技术一组', '', 856959818055818209, NULL, NULL, NULL, NULL, NULL, NULL, 857946656644064609, ',856959818055818209,', 0, b'1', '', '2021-06-22 18:12:34', 856959053190927169, '2021-07-02 17:19:54', 856959053190927169);
INSERT INTO `itcast_core_org` VALUES (856959895214234849, '技术二组', '', 856959818055818209, NULL, NULL, NULL, NULL, NULL, NULL, 857946656644064609, ',856959818055818209,', 0, b'1', '', '2021-06-22 18:12:41', 856959053190927169, '2021-07-02 17:19:59', 856959053190927169);
INSERT INTO `itcast_core_org` VALUES (860164099101696673, '传智播客', '', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, ',', 0, b'1', '', '2021-07-01 14:25:03', 856959053190927169, '2021-08-17 16:01:32', 877215047032506913);
INSERT INTO `itcast_core_org` VALUES (860164944203622593, '人事部', '', 860164099101696673, NULL, NULL, NULL, NULL, NULL, NULL, 857947344241487297, ',860164099101696673,', 0, b'1', '', '2021-07-01 14:28:24', 856959053190927169, '2021-07-01 14:47:34', 856959053190927169);
INSERT INTO `itcast_core_org` VALUES (873610883387885665, '总部', '', 860164099101696673, NULL, NULL, NULL, NULL, NULL, NULL, 1, ',860164099101696673,', 0, b'1', '', '2021-08-07 16:57:46', 1, '2021-08-07 16:57:46', 1);
INSERT INTO `itcast_core_org` VALUES (873610940698855649, '总部研究院', '', 873610883387885665, NULL, NULL, NULL, NULL, NULL, NULL, NULL, ',860164099101696673,873610883387885665,', 0, b'1', '', '2021-08-07 16:57:59', 1, '2021-08-07 16:57:59', 1);
INSERT INTO `itcast_core_org` VALUES (873611036215740769, '总部研究院公共服务中心', '', 873610940698855649, NULL, NULL, NULL, NULL, NULL, NULL, NULL, ',860164099101696673,873610883387885665,873610940698855649,', 0, b'1', '', '2021-08-07 16:58:22', 1, '2021-08-07 16:58:22', 1);
INSERT INTO `itcast_core_org` VALUES (874226837155221889, '总部研究院Python和大数据研发中心', '', 873610940698855649, NULL, NULL, NULL, NULL, NULL, NULL, NULL, ',860164099101696673,873610883387885665,873610940698855649,873611036215740769,', 1, b'1', '', '2021-08-09 09:45:21', 1, '2021-08-09 09:45:41', 1);
INSERT INTO `itcast_core_org` VALUES (874227005095154401, '总部研究院人工智能研发中心', '', 873610940698855649, NULL, NULL, NULL, NULL, NULL, NULL, NULL, ',860164099101696673,873610883387885665,873610940698855649,', 2, b'1', '', '2021-08-09 09:46:01', 1, '2021-08-09 09:46:01', 1);
INSERT INTO `itcast_core_org` VALUES (874227091069997953, '总部研究院Java架构师孵化中心', '', 873610940698855649, NULL, NULL, NULL, NULL, NULL, NULL, NULL, ',860164099101696673,873610883387885665,873610940698855649,', 3, b'1', '', '2021-08-09 09:46:21', 1, '2021-08-09 09:46:21', 1);
INSERT INTO `itcast_core_org` VALUES (874227150599754753, '总部研究院Java课研中心', '', 873610940698855649, NULL, NULL, NULL, NULL, NULL, NULL, NULL, ',860164099101696673,873610883387885665,873610940698855649,', 4, b'1', '', '2021-08-09 09:46:35', 1, '2021-08-09 09:46:35', 1);
INSERT INTO `itcast_core_org` VALUES (874227210372781217, '总部研究院新媒体课研中心', '', 873610940698855649, NULL, NULL, NULL, NULL, NULL, NULL, NULL, ',860164099101696673,873610883387885665,873610940698855649,', 5, b'1', '', '2021-08-09 09:46:50', 1, '2021-08-09 09:46:50', 1);
INSERT INTO `itcast_core_org` VALUES (874227278576358753, '总部研究院软件测试研发中心', '', 873610940698855649, NULL, NULL, NULL, NULL, NULL, NULL, NULL, ',860164099101696673,873610883387885665,873610940698855649,', 7, b'1', '', '2021-08-09 09:47:06', 1, '2021-08-09 09:47:06', 1);
INSERT INTO `itcast_core_org` VALUES (874227341549639265, '总部研究院UI研发中心', '', 873610940698855649, NULL, NULL, NULL, NULL, NULL, NULL, NULL, ',860164099101696673,873610883387885665,873610940698855649,', 8, b'1', '', '2021-08-09 09:47:21', 1, '2021-08-09 09:47:21', 1);
INSERT INTO `itcast_core_org` VALUES (874227400349587233, '总部研究院前端研发中心', '', 873610940698855649, NULL, NULL, NULL, NULL, NULL, NULL, NULL, ',860164099101696673,873610883387885665,873610940698855649,', 9, b'1', '', '2021-08-09 09:47:35', 1, '2021-08-09 09:47:35', 1);
INSERT INTO `itcast_core_org` VALUES (874227474735568801, '总部研究院本部', '', 873610940698855649, NULL, NULL, NULL, NULL, NULL, NULL, NULL, ',860164099101696673,873610883387885665,873610940698855649,', 10, b'1', '', '2021-08-09 09:47:53', 1, '2021-08-09 09:47:53', 1);
INSERT INTO `itcast_core_org` VALUES (874227615173449825, '总部研究院研发公共中心', '', 873610940698855649, NULL, NULL, NULL, NULL, NULL, NULL, NULL, ',860164099101696673,873610883387885665,873610940698855649,', 11, b'1', '', '2021-08-09 09:48:26', 1, '2021-08-09 09:48:26', 1);
COMMIT;

-- ----------------------------
-- Table structure for itcast_core_station
-- ----------------------------
DROP TABLE IF EXISTS `itcast_core_station`;
CREATE TABLE `itcast_core_station` (
                                       `id` bigint NOT NULL COMMENT 'ID',
                                       `name` varchar(100)  NOT NULL DEFAULT '' COMMENT '名称',
                                       `org_id` bigint DEFAULT '0' COMMENT '组织ID\n#c_core_org',
                                       `status` bit(1) DEFAULT b'1' COMMENT '状态',
                                       `describe_` varchar(255) DEFAULT '' COMMENT '描述',
                                       `create_time` datetime DEFAULT NULL,
                                       `create_user` bigint DEFAULT NULL,
                                       `update_time` datetime DEFAULT NULL,
                                       `update_user` bigint DEFAULT NULL,
                                       PRIMARY KEY (`id`) USING BTREE,
                                       UNIQUE KEY `PCS_NAME` (`name`) USING BTREE
) ENGINE=InnoDB  ROW_FORMAT=COMPACT COMMENT='岗位';

-- ----------------------------
-- Records of itcast_core_station
-- ----------------------------
BEGIN;
INSERT INTO `itcast_core_station` VALUES (742438735295031233, '财务', 0, b'1', '', '2020-08-11 01:46:29', 3, '2021-04-15 17:17:18', 1);
INSERT INTO `itcast_core_station` VALUES (831885507637179553, '产品', 0, b'1', '', '2021-04-14 21:36:01', 1, '2021-04-20 00:17:38', 1);
INSERT INTO `itcast_core_station` VALUES (834003162275790369, '测试', 0, b'1', '', '2021-04-20 17:50:49', 1, '2021-04-20 17:50:49', 1);
INSERT INTO `itcast_core_station` VALUES (856959193226155201, '技术', 0, b'1', '', '2021-06-22 18:09:53', 1, '2021-06-22 18:09:53', 1);
INSERT INTO `itcast_core_station` VALUES (856960124659441089, '开发', 0, b'1', '', '2021-06-22 18:13:35', 856959053190927169, '2021-06-22 18:13:35', 856959053190927169);
INSERT INTO `itcast_core_station` VALUES (857940157460957537, '管理员', 0, b'1', '', '2021-06-25 11:07:54', 856959053190927169, '2021-06-25 11:07:54', 856959053190927169);
INSERT INTO `itcast_core_station` VALUES (857940190092642753, '总经理', 0, b'1', '', '2021-06-25 11:08:01', 856959053190927169, '2021-06-25 11:08:01', 856959053190927169);
INSERT INTO `itcast_core_station` VALUES (857940212792216097, '部门经理', 0, b'1', '', '2021-06-25 11:08:07', 856959053190927169, '2021-06-25 11:08:07', 856959053190927169);
INSERT INTO `itcast_core_station` VALUES (857940231804996385, '主管', 0, b'1', '', '2021-06-25 11:08:11', 856959053190927169, '2021-06-25 11:08:11', 856959053190927169);
INSERT INTO `itcast_core_station` VALUES (857940249404296065, '人事', 0, b'1', '', '2021-06-25 11:08:15', 856959053190927169, '2021-06-25 11:08:15', 856959053190927169);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
