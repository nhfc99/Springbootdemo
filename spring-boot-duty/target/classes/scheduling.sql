/*
 Navicat MySQL Data Transfer

 Source Server         : aliyun
 Source Server Type    : MySQL
 Source Server Version : 50173
 Source Host           : 39.106.44.187:3306
 Source Schema         : scheduling

 Target Server Type    : MySQL
 Target Server Version : 50173
 File Encoding         : 65001

 Date: 09/09/2019 00:04:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '院系id',
  `d_name` varchar(255) NOT NULL COMMENT '院系名字',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='各个院系';

-- ----------------------------
-- Records of department
-- ----------------------------
BEGIN;
INSERT INTO `department` VALUES (1, '中文系');
INSERT INTO `department` VALUES (2, '旅游系');
INSERT INTO `department` VALUES (3, '经贸系');
INSERT INTO `department` VALUES (4, '财会系');
INSERT INTO `department` VALUES (5, '管理系');
INSERT INTO `department` VALUES (6, '机电系');
INSERT INTO `department` VALUES (7, '计算机系');
INSERT INTO `department` VALUES (8, '建工系');
INSERT INTO `department` VALUES (9, '环工系');
INSERT INTO `department` VALUES (10, '理化系');
INSERT INTO `department` VALUES (11, '政法系');
INSERT INTO `department` VALUES (12, '数学系');
COMMIT;

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '职位id',
  `name` varchar(255) NOT NULL COMMENT '职位名称',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='各个职位列表';

-- ----------------------------
-- Records of position
-- ----------------------------
BEGIN;
INSERT INTO `position` VALUES (1, '副主任');
INSERT INTO `position` VALUES (2, '团总支书记');
INSERT INTO `position` VALUES (3, '专职辅导员');
INSERT INTO `position` VALUES (4, '兼职辅导员');
COMMIT;

-- ----------------------------
-- Table structure for restday
-- ----------------------------
DROP TABLE IF EXISTS `restday`;
CREATE TABLE `restday` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '法定节假日id号',
  `h_date` varchar(32) NOT NULL COMMENT '法定节假日',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=87 DEFAULT CHARSET=utf8 COMMENT='法定节假日表';

-- ----------------------------
-- Records of restday
-- ----------------------------
BEGIN;
INSERT INTO `restday` VALUES (83, '2020-01-04');
INSERT INTO `restday` VALUES (82, '2019-12-29');
INSERT INTO `restday` VALUES (81, '2019-12-28');
INSERT INTO `restday` VALUES (80, '2019-12-22');
INSERT INTO `restday` VALUES (79, '2019-12-21');
INSERT INTO `restday` VALUES (78, '2019-12-15');
INSERT INTO `restday` VALUES (77, '2019-12-14');
INSERT INTO `restday` VALUES (76, '2019-12-08');
INSERT INTO `restday` VALUES (75, '2019-12-07');
INSERT INTO `restday` VALUES (74, '2019-12-01');
INSERT INTO `restday` VALUES (73, '2019-11-30');
INSERT INTO `restday` VALUES (72, '2019-11-24');
INSERT INTO `restday` VALUES (71, '2019-11-23');
INSERT INTO `restday` VALUES (70, '2019-11-17');
INSERT INTO `restday` VALUES (69, '2019-11-16');
INSERT INTO `restday` VALUES (68, '2019-11-10');
INSERT INTO `restday` VALUES (67, '2019-11-09');
INSERT INTO `restday` VALUES (66, '2019-11-03');
INSERT INTO `restday` VALUES (65, '2019-11-02');
INSERT INTO `restday` VALUES (64, '2019-10-27');
INSERT INTO `restday` VALUES (63, '2019-10-26');
INSERT INTO `restday` VALUES (62, '2019-10-20');
INSERT INTO `restday` VALUES (61, '2019-10-19');
INSERT INTO `restday` VALUES (60, '2019-10-13');
INSERT INTO `restday` VALUES (59, '2019-10-07');
INSERT INTO `restday` VALUES (58, '2019-10-06');
INSERT INTO `restday` VALUES (57, '2019-10-05');
INSERT INTO `restday` VALUES (56, '2019-10-04');
INSERT INTO `restday` VALUES (55, '2019-10-03');
INSERT INTO `restday` VALUES (54, '2019-10-02');
INSERT INTO `restday` VALUES (53, '2019-10-01');
INSERT INTO `restday` VALUES (52, '2019-09-28');
INSERT INTO `restday` VALUES (51, '2019-09-22');
INSERT INTO `restday` VALUES (50, '2019-09-21');
INSERT INTO `restday` VALUES (49, '2019-09-15');
INSERT INTO `restday` VALUES (48, '2019-09-14');
INSERT INTO `restday` VALUES (47, '2019-09-13');
INSERT INTO `restday` VALUES (46, '2019-09-08');
INSERT INTO `restday` VALUES (45, '2019-09-07');
INSERT INTO `restday` VALUES (44, '2019-09-01');
INSERT INTO `restday` VALUES (43, '2019-08-31');
INSERT INTO `restday` VALUES (84, '2020-01-05');
INSERT INTO `restday` VALUES (85, '2020-01-11');
INSERT INTO `restday` VALUES (86, '2020-01-12');
COMMIT;

-- ----------------------------
-- Table structure for result
-- ----------------------------
DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `r_date` varchar(64) NOT NULL COMMENT '值班日期',
  `r_dpuid` int(11) NOT NULL COMMENT '值班领导id',
  `r_fid1` int(11) NOT NULL COMMENT '值班辅导员id',
  `r_fid2` int(11) NOT NULL COMMENT '值班辅导员id',
  `r_dutytype` int(8) NOT NULL DEFAULT '1' COMMENT '白班还是夜班',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=491 DEFAULT CHARSET=utf8 COMMENT='结果表';

-- ----------------------------
-- Table structure for sduty
-- ----------------------------
DROP TABLE IF EXISTS `sduty`;
CREATE TABLE `sduty` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `s_type` int(8) DEFAULT '1' COMMENT '1表示全天值班，2表示夜间值班',
  `s_name` varchar(255) NOT NULL COMMENT '值班类型名称',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='1表示全天值班，2表示夜间值班';

-- ----------------------------
-- Records of sduty
-- ----------------------------
BEGIN;
INSERT INTO `sduty` VALUES (1, 1, '白班');
INSERT INTO `sduty` VALUES (2, 2, '夜班');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(16) NOT NULL COMMENT '用户名称',
  `u_phone` varchar(11) NOT NULL COMMENT '用户手机号',
  `u_dpid` int(8) NOT NULL COMMENT '用户系别',
  `u_pid` int(8) NOT NULL COMMENT '用户职位类别',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=75 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, '冯俊伶', '13623625191', 1, 1);
INSERT INTO `user` VALUES (2, '常靖', '13934669725', 1, 2);
INSERT INTO `user` VALUES (3, '谷秀琴', '15535158345', 1, 3);
INSERT INTO `user` VALUES (4, '侯倩', '18935449290', 1, 3);
INSERT INTO `user` VALUES (6, '代芳芳', '18103514616', 1, 4);
INSERT INTO `user` VALUES (7, '徐睿', '18234088850', 1, 4);
INSERT INTO `user` VALUES (8, '张一燕', '13834230252', 2, 1);
INSERT INTO `user` VALUES (9, '师永强', '18734558942', 2, 2);
INSERT INTO `user` VALUES (10, '耿巍', '18953319374', 2, 3);
INSERT INTO `user` VALUES (11, '苏慧娟', '18435101976', 2, 3);
INSERT INTO `user` VALUES (12, '程凌燕', '18235133930', 2, 3);
INSERT INTO `user` VALUES (13, '张芸', '18635181525', 2, 3);
INSERT INTO `user` VALUES (14, '马潇', '15503635193', 2, 3);
INSERT INTO `user` VALUES (15, '郭玉婷', '15123030397', 2, 4);
INSERT INTO `user` VALUES (16, '赵慧', '18734892991', 2, 4);
INSERT INTO `user` VALUES (17, '李彩兰', '13633451580', 3, 1);
INSERT INTO `user` VALUES (18, '杨鹏', '13513609783', 3, 2);
INSERT INTO `user` VALUES (19, '李慧敏', '13613442302', 3, 3);
INSERT INTO `user` VALUES (20, '董晶', '13834169563', 3, 3);
INSERT INTO `user` VALUES (21, '杨凡', '18635134118', 3, 3);
INSERT INTO `user` VALUES (22, '和晨阳', '13889127083', 3, 3);
INSERT INTO `user` VALUES (23, '郝书帆', '15735122888', 3, 3);
INSERT INTO `user` VALUES (24, '王子健', '13753487578', 4, 2);
INSERT INTO `user` VALUES (25, '马欣', '15035146359', 4, 3);
INSERT INTO `user` VALUES (26, '杨琇敏', '18735110414', 4, 3);
INSERT INTO `user` VALUES (27, '程丽媛', '15235131380', 4, 3);
INSERT INTO `user` VALUES (28, '郭宇晨', '18335192711', 4, 3);
INSERT INTO `user` VALUES (29, '吴超', '13934566810', 4, 3);
INSERT INTO `user` VALUES (31, '程  明', '13453151881', 5, 1);
INSERT INTO `user` VALUES (32, '王宁', '15534474189', 5, 2);
INSERT INTO `user` VALUES (33, '张岩梅', '13453165491', 5, 3);
INSERT INTO `user` VALUES (34, '杨  洁', '18835796753', 5, 3);
INSERT INTO `user` VALUES (36, '梁泽', '17806255297', 5, 3);
INSERT INTO `user` VALUES (37, '尹一帆', '18603458825', 6, 1);
INSERT INTO `user` VALUES (38, '胡建功', '13934628798', 6, 2);
INSERT INTO `user` VALUES (39, '安叶青', '13353518560', 6, 3);
INSERT INTO `user` VALUES (40, '毛晓忻', '15235170513', 6, 3);
INSERT INTO `user` VALUES (41, '韩宝珠', '15620963499', 6, 3);
INSERT INTO `user` VALUES (42, '王娜', '13934206508', 6, 3);
INSERT INTO `user` VALUES (43, '李之光', '13994255624', 6, 3);
INSERT INTO `user` VALUES (44, '杨立波', '13994230144', 7, 1);
INSERT INTO `user` VALUES (45, '赵俊峰', '18655799553', 7, 1);
INSERT INTO `user` VALUES (46, '程凤伟', '18734157203', 7, 2);
INSERT INTO `user` VALUES (47, '潘妍', '18734168802', 7, 3);
INSERT INTO `user` VALUES (48, '董国珍', '18834838626', 7, 3);
INSERT INTO `user` VALUES (49, '郭凯彬', '15534016664', 7, 3);
INSERT INTO `user` VALUES (50, '苗丽娟', '15111956798', 7, 3);
INSERT INTO `user` VALUES (52, '封俊', '13934138060', 7, 4);
INSERT INTO `user` VALUES (53, '卢  青', '13703580882', 8, 1);
INSERT INTO `user` VALUES (54, '郝艳 ', '18636112185', 8, 2);
INSERT INTO `user` VALUES (55, '王蓉', '王蓉', 8, 3);
INSERT INTO `user` VALUES (56, '刘苹', '17852266230', 8, 3);
INSERT INTO `user` VALUES (57, '周姝航', '15536303023', 8, 4);
INSERT INTO `user` VALUES (58, '雷晓丹', '19834525433', 8, 4);
INSERT INTO `user` VALUES (59, '张钰', '15392620629', 8, 4);
INSERT INTO `user` VALUES (60, '张云飞', '15503630005', 8, 4);
INSERT INTO `user` VALUES (61, '赵翠玉', '15536914044', 8, 4);
INSERT INTO `user` VALUES (62, '邢淑芳', '13994265220', 9, 1);
INSERT INTO `user` VALUES (63, '南昊', '13546722911', 9, 2);
INSERT INTO `user` VALUES (64, '郭嘉琦', '郭嘉琦', 9, 3);
INSERT INTO `user` VALUES (65, '郑康强', '13593149871', 9, 3);
INSERT INTO `user` VALUES (66, '黄莺', '15034068498', 9, 3);
INSERT INTO `user` VALUES (67, '许改云', '18735104344', 9, 3);
INSERT INTO `user` VALUES (68, '王天', '15035688227', 9, 3);
INSERT INTO `user` VALUES (69, '郝秀萍', '18322694344', 10, 4);
INSERT INTO `user` VALUES (70, '张  武', '15386885995', 11, 1);
INSERT INTO `user` VALUES (71, '李婷婷', '13934666120', 11, 2);
INSERT INTO `user` VALUES (72, '孙嘉', '18636169299', 11, 3);
INSERT INTO `user` VALUES (73, '张为锋', '15834186036', 12, 1);
INSERT INTO `user` VALUES (74, '杨芸', '18636667417', 12, 3);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
