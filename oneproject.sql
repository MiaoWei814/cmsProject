/*
 Navicat Premium Data Transfer

 Source Server         : MySQL80
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : oneproject

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 29/09/2021 09:24:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for faq
-- ----------------------------
DROP TABLE IF EXISTS `faq`;
CREATE TABLE `faq`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `createDate` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of faq
-- ----------------------------
INSERT INTO `faq` VALUES (6, '123', '<p>123</p>', '2021-09-26 14:12:14');
INSERT INTO `faq` VALUES (8, '测试统计', '<p>11</p>', '2021-09-26 14:13:15');

-- ----------------------------
-- Table structure for feedbacks
-- ----------------------------
DROP TABLE IF EXISTS `feedbacks`;
CREATE TABLE `feedbacks`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片名',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片路径',
  `createDate` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `enable` bit(2) NULL DEFAULT NULL COMMENT '默认启用状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of feedbacks
-- ----------------------------
INSERT INTO `feedbacks` VALUES (1, 'CSDN浏览器助手_壁纸_1629875096842.png', '/upload/1632642731.png', '2021-09-26 16:00:49', b'01');
INSERT INTO `feedbacks` VALUES (2, '613d670413e58.png', '/upload/1632647295.png', NULL, b'01');

-- ----------------------------
-- Table structure for problem
-- ----------------------------
DROP TABLE IF EXISTS `problem`;
CREATE TABLE `problem`  (
  `id` bigint(0) NOT NULL COMMENT '主键',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细描述',
  `linkPath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '链接地址',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `createDate` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `typeId` bigint(0) NULL DEFAULT NULL COMMENT '问题类型id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of problem
-- ----------------------------

-- ----------------------------
-- Table structure for problemtype
-- ----------------------------
DROP TABLE IF EXISTS `problemtype`;
CREATE TABLE `problemtype`  (
  `id` bigint(0) NOT NULL COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '问题类型名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of problemtype
-- ----------------------------

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `title` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `typeId` bigint(0) NULL DEFAULT NULL,
  `clickCount` int(0) NULL DEFAULT NULL,
  `content` varchar(700) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `enable` bit(1) NULL DEFAULT NULL,
  `createDate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_article
-- ----------------------------
INSERT INTO `t_article` VALUES (1, 'Java基本数据类型1', NULL, 2, 0, '<p>234324</p>', b'1', '2020-03-16 14:39:00');
INSERT INTO `t_article` VALUES (2, 'Mysql关联查询', NULL, 3, 0, '<p>33</p>', b'1', '2020-03-16 14:41:36');
INSERT INTO `t_article` VALUES (3, 'Servlet与JSP', NULL, 1, 0, '<p><br/><img src=\"http://img.baidu.com/hi/jx2/j_0002.gif\"/></p>', b'0', '2020-04-21 10:01:39');
INSERT INTO `t_article` VALUES (4, 'Json与XML12', NULL, 1, 0, '333', b'1', '2021-09-18 20:19:47');
INSERT INTO `t_article` VALUES (5, 'String与StringBuilder区别', NULL, 1, 0, '111', b'1', '2020-05-31 16:38:41');
INSERT INTO `t_article` VALUES (8, '设计模式之单例模式', NULL, 1, 0, '11', b'1', '2020-05-31 16:39:55');
INSERT INTO `t_article` VALUES (9, 'xml解析', NULL, 1, 0, '23232', b'1', '2020-05-31 16:50:53');
INSERT INTO `t_article` VALUES (10, '数据库连接池', NULL, 1, 0, '6363', b'1', '2020-05-31 16:51:29');
INSERT INTO `t_article` VALUES (26, '再试一次会员等级卷', NULL, 1, NULL, '123', b'1', '2021-09-18 20:17:00');
INSERT INTO `t_article` VALUES (27, '1123123', NULL, 1, NULL, '123121', b'1', '2021-09-18 20:18:50');
INSERT INTO `t_article` VALUES (28, '大王叫我来巡逻', NULL, 3, 0, '想看我,没门', b'1', '2021-09-19 17:00:42');
INSERT INTO `t_article` VALUES (29, '测试有无URL', '', 1, 0, '还不行?', b'1', '2021-09-19 22:48:11');
INSERT INTO `t_article` VALUES (30, '第二次了哈', NULL, 1, 0, '我快被气死了', b'1', '2021-09-19 22:53:24');
INSERT INTO `t_article` VALUES (31, '第三次', NULL, 3, 0, '123', b'1', '2021-09-19 23:04:00');
INSERT INTO `t_article` VALUES (32, '第四次', NULL, 1, 0, '123', b'1', '2021-09-19 23:06:13');
INSERT INTO `t_article` VALUES (33, '第五次', NULL, 3, 0, '123', b'1', '2021-09-19 23:08:04');
INSERT INTO `t_article` VALUES (34, '第六次', NULL, 1, 0, '123', b'1', '2021-09-19 23:09:07');
INSERT INTO `t_article` VALUES (35, '第七次1', NULL, 1, 0, '123', b'1', '2021-09-19 23:17:27');
INSERT INTO `t_article` VALUES (36, '第八次了1', NULL, 1, 0, '123123', b'1', '2021-09-19 23:22:26');
INSERT INTO `t_article` VALUES (38, '第九次', NULL, 1, 0, '2222', b'1', '2021-09-20 07:52:16');
INSERT INTO `t_article` VALUES (39, '第十次了1', '/static/templates/1632097890080.html', 1, 0, '12313', b'1', '2021-09-20 07:55:38');
INSERT INTO `t_article` VALUES (40, '第十一次1', '/static/templates/1632310086598.html', 1, 0, '<p>2021-09-22<img width=\"530\" height=\"340\" src=\"http://api.map.baidu.com/staticimage?center=116.404,39.915&zoom=10&width=530&height=340&markers=116.404,39.915\"/>123</p>', b'1', '2021-09-20 07:57:17');
INSERT INTO `t_article` VALUES (43, '测试浏览次数', '/static/templates/1632300925743.html', 1, 20, '别看了,你会出现红色异常的', b'1', '2021-09-22 16:55:25');
INSERT INTO `t_article` VALUES (44, '第二次测试浏览次数', '/static/templates/1632308899176.html', 1, 1, '<p><img src=\"/ueditor/jsp/upload/image/20210922/1632308894267076358.jpg\" title=\"1632308894267076358.jpg\" alt=\"下载.jpg\"/></p>', b'1', '2021-09-22 17:35:19');

-- ----------------------------
-- Table structure for t_article_type
-- ----------------------------
DROP TABLE IF EXISTS `t_article_type`;
CREATE TABLE `t_article_type`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_article_type
-- ----------------------------
INSERT INTO `t_article_type` VALUES (1, '技术文章', 'technology');
INSERT INTO `t_article_type` VALUES (2, '行业新闻', 'industry');
INSERT INTO `t_article_type` VALUES (3, '学科咨询', 'subject');

-- ----------------------------
-- Table structure for t_navigation_bar
-- ----------------------------
DROP TABLE IF EXISTS `t_navigation_bar`;
CREATE TABLE `t_navigation_bar`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createDate` datetime(0) NULL DEFAULT NULL,
  `typeId` bigint(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_navigation_bar
-- ----------------------------
INSERT INTO `t_navigation_bar` VALUES (1, '首页', '1', '1', '2021-09-26 10:02:17', 1);
INSERT INTO `t_navigation_bar` VALUES (3, 'Java学科', '/upload/category_java_icon.png', '2', '2021-09-26 12:47:59', 2);
INSERT INTO `t_navigation_bar` VALUES (4, 'PHP', '/upload/category_java_icon.png', 'favicon.ico', '2021-09-26 12:58:13', 2);
INSERT INTO `t_navigation_bar` VALUES (5, '这是会议名称', '/upload/category_java_icon.png', 'favicon.ico', '2021-09-26 13:01:54', 2);

-- ----------------------------
-- Table structure for t_navigation_type_bar
-- ----------------------------
DROP TABLE IF EXISTS `t_navigation_type_bar`;
CREATE TABLE `t_navigation_type_bar`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_navigation_type_bar
-- ----------------------------
INSERT INTO `t_navigation_type_bar` VALUES (1, '顶部导航', 'top');
INSERT INTO `t_navigation_type_bar` VALUES (2, '侧边导航', 'aside');

-- ----------------------------
-- Table structure for t_slide
-- ----------------------------
DROP TABLE IF EXISTS `t_slide`;
CREATE TABLE `t_slide`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createDate` datetime(0) NULL DEFAULT NULL,
  `enable` bit(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_slide
-- ----------------------------
INSERT INTO `t_slide` VALUES (17, '613c252c960f6.jpg', '/upload/1632397492.jpg', '2021-09-23 19:44:52', b'1');
INSERT INTO `t_slide` VALUES (19, '612c55be38af0.jpg', '/upload/1632472201.jpg', '2021-09-24 16:30:02', b'1');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nickName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, '中文', '123', '王天霸');
INSERT INTO `t_user` VALUES (2, 'adw', '123465', 'adw');
INSERT INTO `t_user` VALUES (5, 'JAVA', '123465', '王天霸1');

SET FOREIGN_KEY_CHECKS = 1;
