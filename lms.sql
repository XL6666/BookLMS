/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50087
Source Host           : localhost:3306
Source Database       : lms

Target Server Type    : MYSQL
Target Server Version : 50087
File Encoding         : 65001

Date: 2018-06-10 18:22:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `user` varchar(12) NOT NULL,
  `password` varchar(12) default NULL,
  `user_name` varchar(10) default NULL,
  PRIMARY KEY  (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', 'admin', '徐浩军');
INSERT INTO `admin` VALUES ('xhj', 'xhj', 'xhj');
INSERT INTO `admin` VALUES ('xl', 'xl', 'xl');
INSERT INTO `admin` VALUES ('许磊', '123456', '许磊');

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bk_code` int(10) NOT NULL auto_increment,
  `bk_name` varchar(30) default NULL,
  `bk_number` varchar(10) default NULL,
  `bk_type` int(11) default NULL,
  `writer` varchar(10) default NULL,
  `price` float default NULL,
  `addtime` date default NULL,
  `op_name` varchar(10) default NULL,
  `bs_number` varchar(4) default NULL,
  `bk_state` int(11) default '0',
  PRIMARY KEY  (`bk_code`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('2', '星辰变', '34', '1', '番茄', '100', '2017-09-11', '徐浩军', '2', '1');
INSERT INTO `book` VALUES ('3', '艰辛的农药路', '245', '1', '许磊', '12', '2017-09-11', '徐浩军', '3', '0');
INSERT INTO `book` VALUES ('4', '大神成长日记', '3466', '4', '刘西宁', '100', '2017-09-11', '徐浩军', '4', '0');
INSERT INTO `book` VALUES ('5', '浩军的恋爱史', '567', '2', '浩军', '678', '2017-09-11', '徐浩军', '1', '0');
INSERT INTO `book` VALUES ('6', '磊子的考研之路', '6789', '1', '许磊', '789', '2017-09-11', '徐浩军', '7', '0');
INSERT INTO `book` VALUES ('7', '软件设计', '4567', '3', '王辉', '300', '2017-09-13', '徐浩军', '3', '0');
INSERT INTO `book` VALUES ('8', 'Javaweb', '989', '2', '徐浩军', '677', '2017-09-13', '徐浩军', '4', '0');

-- ----------------------------
-- Table structure for `booktype`
-- ----------------------------
DROP TABLE IF EXISTS `booktype`;
CREATE TABLE `booktype` (
  `bt_id` int(11) NOT NULL,
  `bt_name` varchar(20) default NULL,
  PRIMARY KEY  (`bt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of booktype
-- ----------------------------
INSERT INTO `booktype` VALUES ('1', '玄幻');
INSERT INTO `booktype` VALUES ('2', '修仙');
INSERT INTO `booktype` VALUES ('3', '都市');
INSERT INTO `booktype` VALUES ('4', '言情');

-- ----------------------------
-- Table structure for `borrow`
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow` (
  `borrowid` int(11) NOT NULL auto_increment,
  `readerid` varchar(8) NOT NULL,
  `bk_code` varchar(10) NOT NULL,
  `borrowtime` date default NULL,
  `duedate` date default NULL,
  `op_name` varchar(10) default NULL,
  `borrowstate` int(11) default '0',
  PRIMARY KEY  (`borrowid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES ('3', '2', '2', '2017-09-14', '2017-10-14', '徐浩军', '0');

-- ----------------------------
-- Table structure for `reader`
-- ----------------------------
DROP TABLE IF EXISTS `reader`;
CREATE TABLE `reader` (
  `readerid` int(8) NOT NULL auto_increment,
  `rd_name` varchar(10) default NULL,
  `rd_type` int(11) default NULL,
  `system` varchar(16) default NULL,
  `rclass` varchar(16) default NULL,
  `phone` varchar(13) default NULL,
  `reg_time` date default NULL,
  `borrowed_num` int(11) default '0',
  PRIMARY KEY  (`readerid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reader
-- ----------------------------
INSERT INTO `reader` VALUES ('3', '许磊', '2', '软件工程系', '信1505-1班', '15732119665', '2017-09-13', '0');
INSERT INTO `reader` VALUES ('4', '王辉', '2', '软件工程系', '信1505-2班', '15732119771', '2017-09-13', '0');
INSERT INTO `reader` VALUES ('5', '王建民', '2', '软件工程系', '信1505-2班', '15732119771', '2017-09-13', '0');
INSERT INTO `reader` VALUES ('6', '徐浩军', '1', '软件工程系', '信1505-2班', '15732119771', '2017-09-14', '0');

-- ----------------------------
-- Table structure for `readertype`
-- ----------------------------
DROP TABLE IF EXISTS `readertype`;
CREATE TABLE `readertype` (
  `rt_id` int(11) NOT NULL,
  `rt_name` varchar(10) default NULL,
  `rt_number` int(11) default NULL,
  `rt_time` int(11) default NULL,
  PRIMARY KEY  (`rt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of readertype
-- ----------------------------
INSERT INTO `readertype` VALUES ('1', '学生', '10', '30');
INSERT INTO `readertype` VALUES ('2', '教师', '20', '30');

-- ----------------------------
-- Table structure for `return1`
-- ----------------------------
DROP TABLE IF EXISTS `return1`;
CREATE TABLE `return1` (
  `returnid` int(11) NOT NULL auto_increment,
  `readerid` varchar(8) NOT NULL,
  `bk_code` varchar(10) NOT NULL,
  `returntime` date default NULL,
  `op_name` varchar(10) default NULL,
  PRIMARY KEY  (`returnid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of return1
-- ----------------------------
INSERT INTO `return1` VALUES ('1', '1', '1', '2017-09-12', '徐浩军');
INSERT INTO `return1` VALUES ('2', '1', '3', '2017-09-13', '徐浩军');
INSERT INTO `return1` VALUES ('3', '2', '2', '2017-09-12', '徐浩军');
INSERT INTO `return1` VALUES ('4', '2', '3', '2017-09-13', '徐浩军');
INSERT INTO `return1` VALUES ('5', '2', '4', '2017-09-13', '徐浩军');
INSERT INTO `return1` VALUES ('6', '1', '1', '2017-09-13', '徐浩军');
INSERT INTO `return1` VALUES ('7', '1', '1', '2017-09-13', '徐浩军');
INSERT INTO `return1` VALUES ('8', '1', '1', '2017-09-13', '徐浩军');
INSERT INTO `return1` VALUES ('9', '1', '2', '2017-09-13', '徐浩军');
INSERT INTO `return1` VALUES ('10', '1', '1', '2017-09-13', '徐浩军');
INSERT INTO `return1` VALUES ('11', '2', '1', '2017-09-13', '徐浩军');
INSERT INTO `return1` VALUES ('12', '2', '2', '2017-09-13', '徐浩军');
INSERT INTO `return1` VALUES ('13', '1', '1', '2017-09-13', '徐浩军');
INSERT INTO `return1` VALUES ('14', '1', '1', '2017-09-13', '徐浩军');
INSERT INTO `return1` VALUES ('15', '1', '1', '2017-09-13', '徐浩军');
INSERT INTO `return1` VALUES ('16', '1', '2', '2017-09-13', '徐浩军');
INSERT INTO `return1` VALUES ('17', '2', '2', '2017-09-14', '徐浩军');
INSERT INTO `return1` VALUES ('18', '2', '2', '2017-09-14', '徐浩军');
