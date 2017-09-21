/*
SQLyog v10.2 
MySQL - 5.1.33-community-log : Database - tongxuelu
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tongxuelu` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `tongxuelu`;

/*Table structure for table `activity` */

DROP TABLE IF EXISTS `activity`;

CREATE TABLE `activity` (
  `activity_id` int(11) NOT NULL,
  `activity_name` varchar(100) DEFAULT NULL COMMENT '活动名称',
  `start_time` date DEFAULT NULL COMMENT '活动开始时间',
  `activity_comment` varchar(255) DEFAULT NULL COMMENT '活动说明',
  `activity_state` int(11) DEFAULT NULL COMMENT '活动状态（0，未发布、1，已通知所有好友、2正在进行、3.活动结束）',
  `delete_state` int(11) DEFAULT NULL COMMENT '删除状态',
  `tissue_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`activity_id`),
  KEY `FK_Reference_3` (`tissue_id`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`tissue_id`) REFERENCES `tissue` (`tissue_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动表';

/*Data for the table `activity` */

/*Table structure for table `album` */

DROP TABLE IF EXISTS `album`;

CREATE TABLE `album` (
  `album_id` int(11) NOT NULL,
  `album_name` varchar(100) DEFAULT NULL COMMENT '相册名称',
  `view_lock` int(11) DEFAULT NULL COMMENT '查看权限：（0，仅所有者、1.回答问题、2.好友、3.公开）',
  `view_issue` varchar(100) DEFAULT NULL COMMENT '访问问题：可null',
  `view_key` varchar(100) DEFAULT NULL COMMENT '问题答案',
  `user_id` varchar(18) DEFAULT NULL,
  PRIMARY KEY (`album_id`),
  KEY `FK_Reference_9` (`user_id`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='相册表';

/*Data for the table `album` */

/*Table structure for table `blog_category` */

DROP TABLE IF EXISTS `blog_category`;

CREATE TABLE `blog_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(100) DEFAULT NULL COMMENT '分类名称',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博客分类表（日志分类）';

/*Data for the table `blog_category` */

/*Table structure for table `blog_comment` */

DROP TABLE IF EXISTS `blog_comment`;

CREATE TABLE `blog_comment` (
  `blog_comment_id` varchar(18) NOT NULL,
  `blog_id` varchar(18) DEFAULT NULL,
  `user_id` varchar(18) DEFAULT NULL COMMENT '被评论者id',
  `who_comment_id` varchar(18) DEFAULT NULL COMMENT '评论者id',
  `comment_content` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `comment_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '评论时间',
  `delete_state` int(11) DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`blog_comment_id`),
  KEY `FK_Reference_8` (`blog_id`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`blog_id`) REFERENCES `user_blog` (`blog_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志评论表';

/*Data for the table `blog_comment` */

/*Table structure for table `friend` */

DROP TABLE IF EXISTS `friend`;

CREATE TABLE `friend` (
  `f_id` int(11) NOT NULL COMMENT '自增主键',
  `my_id` varchar(18) DEFAULT NULL COMMENT '同学1的账号',
  `friend_id` varchar(18) DEFAULT NULL COMMENT '同学2账号',
  `comment` varchar(100) DEFAULT NULL COMMENT '好友备注',
  `is_attention` int(11) DEFAULT NULL COMMENT '是否特别关注',
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='好友表';

/*Data for the table `friend` */

/*Table structure for table `insert_pic` */

DROP TABLE IF EXISTS `insert_pic`;

CREATE TABLE `insert_pic` (
  `img_id` varchar(18) NOT NULL,
  `imgurl` varchar(100) DEFAULT NULL COMMENT '同学录T开头，日志R开头',
  PRIMARY KEY (`img_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='插图表（同学录T开头+日志R开头）';

/*Data for the table `insert_pic` */

/*Table structure for table `latter` */

DROP TABLE IF EXISTS `latter`;

CREATE TABLE `latter` (
  `latter_id` int(11) NOT NULL,
  `send_id` varchar(18) DEFAULT NULL COMMENT '发信者账号',
  `get_id` varchar(18) DEFAULT NULL COMMENT '收信者账号',
  `latter_title` varchar(100) DEFAULT NULL COMMENT '私信标题',
  `latter_content` text COMMENT '私信内容',
  `latter_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '私信时间',
  `delete_state` int(11) DEFAULT NULL,
  PRIMARY KEY (`latter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='私信';

/*Data for the table `latter` */

/*Table structure for table `leave_word` */

DROP TABLE IF EXISTS `leave_word`;

CREATE TABLE `leave_word` (
  `leave_word_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(18) DEFAULT NULL COMMENT '用户自己账号',
  `leave_user_id` varchar(18) DEFAULT NULL COMMENT '留言者用户id',
  `leave_word_content` varchar(255) DEFAULT NULL COMMENT '留言内容',
  `leave_word_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '留言时间',
  `is_name_hidden` int(11) DEFAULT NULL COMMENT '是否匿名',
  `delete_state` int(11) DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`leave_word_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='留言表';

/*Data for the table `leave_word` */

/*Table structure for table `photo` */

DROP TABLE IF EXISTS `photo`;

CREATE TABLE `photo` (
  `photo_id` int(11) NOT NULL,
  `album_id` int(11) DEFAULT NULL,
  `photo_desc` varchar(100) DEFAULT NULL COMMENT '相片描述',
  `photo_url` varchar(100) DEFAULT NULL COMMENT '相片地址',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '上传时间',
  `delete_state` int(11) DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`photo_id`),
  KEY `FK_Reference_10` (`album_id`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`album_id`) REFERENCES `album` (`album_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='相片表';

/*Data for the table `photo` */

/*Table structure for table `reply_comment` */

DROP TABLE IF EXISTS `reply_comment`;

CREATE TABLE `reply_comment` (
  `reply_comment_id` varchar(18) NOT NULL,
  `blog_comment_id` varchar(18) DEFAULT NULL,
  `talk_comment_id` varchar(18) DEFAULT NULL,
  `user_id` varchar(18) DEFAULT NULL COMMENT '被评论者id',
  `who_comment_id` varchar(18) DEFAULT NULL COMMENT '评论者id',
  `comment_content` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `comment_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '评论时间',
  `delete_state` int(11) DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`reply_comment_id`),
  KEY `FK_Reference_11` (`blog_comment_id`),
  KEY `FK_Reference_12` (`talk_comment_id`),
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`talk_comment_id`) REFERENCES `talk_comment` (`talk_comment_id`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`blog_comment_id`) REFERENCES `blog_comment` (`blog_comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='回复评论表';

/*Data for the table `reply_comment` */

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `user_id` varchar(18) NOT NULL COMMENT '用户账号',
  `password` varchar(18) DEFAULT NULL,
  `nickname` varchar(20) DEFAULT NULL COMMENT '昵称',
  `gender` varchar(20) DEFAULT NULL COMMENT '性别',
  `birth` date DEFAULT NULL COMMENT '出身年月',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` varchar(18) DEFAULT NULL COMMENT '邮件地址',
  `qq` varchar(18) DEFAULT NULL COMMENT 'qq号',
  `register_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间，使用时间戳',
  `address` varchar(100) NOT NULL COMMENT '现住址',
  `school` varchar(100) DEFAULT NULL COMMENT '学校',
  `profession` varchar(100) DEFAULT NULL COMMENT '职业',
  `imgurl` varchar(100) DEFAULT NULL COMMENT '头像地址',
  `signal` varchar(100) NOT NULL COMMENT '个性签名',
  `description` varchar(255) NOT NULL COMMENT '个人说明描述',
  `active` varchar(11) DEFAULT NULL COMMENT '激活状态',
  `state` int(8) DEFAULT NULL COMMENT '是否锁定',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='同学录的普通用户表';

/*Data for the table `t_user` */

insert  into `t_user`(`user_id`,`password`,`nickname`,`gender`,`birth`,`age`,`email`,`qq`,`register_time`,`address`,`school`,`profession`,`imgurl`,`signal`,`description`,`active`,`state`) values ('20170904','123123123','明大帅','男','2017-09-05',28,'1021011249@QQ.com','1021011249','2017-09-04 20:15:32','峡江','江西农业大学','项目经理',NULL,'很帅','反正就是帅','1',0);

/*Table structure for table `talk_comment` */

DROP TABLE IF EXISTS `talk_comment`;

CREATE TABLE `talk_comment` (
  `talk_comment_id` varchar(18) NOT NULL,
  `talk_id` int(11) DEFAULT NULL,
  `user_id` varchar(18) DEFAULT NULL COMMENT '被评论者id',
  `who_comment_id` varchar(18) DEFAULT NULL COMMENT '评论者id',
  `comment_content` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `comment_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '评论时间',
  `delete_state` int(11) DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`talk_comment_id`),
  KEY `FK_Reference_7` (`talk_id`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`talk_id`) REFERENCES `talk_note` (`talk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='说说评论表';

/*Data for the table `talk_comment` */

/*Table structure for table `talk_note` */

DROP TABLE IF EXISTS `talk_note`;

CREATE TABLE `talk_note` (
  `talk_id` int(11) NOT NULL AUTO_INCREMENT,
  `talk_content` text,
  `release_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_state` int(11) DEFAULT NULL,
  `user_id` varchar(18) DEFAULT NULL,
  PRIMARY KEY (`talk_id`),
  KEY `FK_Reference_4` (`user_id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='心情说说表';

/*Data for the table `talk_note` */

/*Table structure for table `tissue` */

DROP TABLE IF EXISTS `tissue`;

CREATE TABLE `tissue` (
  `tissue_id` int(11) NOT NULL,
  `tissue_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`tissue_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织表';

/*Data for the table `tissue` */

/*Table structure for table `user_blog` */

DROP TABLE IF EXISTS `user_blog`;

CREATE TABLE `user_blog` (
  `blog_id` varchar(18) NOT NULL,
  `category_id` int(11) DEFAULT NULL,
  `blog_title` varchar(100) DEFAULT NULL COMMENT '日志标题',
  `blog_content` text COMMENT '日志内容',
  `release_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '发布时间',
  `delete_state` int(11) DEFAULT NULL COMMENT '删除状态',
  `user_id` varchar(18) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`blog_id`),
  KEY `FK_Reference_5` (`category_id`),
  KEY `FK_Reference_6` (`user_id`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`category_id`) REFERENCES `blog_category` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='个人日志表';

/*Data for the table `user_blog` */

/*Table structure for table `user_tissue` */

DROP TABLE IF EXISTS `user_tissue`;

CREATE TABLE `user_tissue` (
  `user_id` varchar(18) NOT NULL,
  `tissue_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`tissue_id`),
  KEY `FK_Reference_2` (`tissue_id`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`tissue_id`) REFERENCES `tissue` (`tissue_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户组织表';

/*Data for the table `user_tissue` */

/*Table structure for table `visitor` */

DROP TABLE IF EXISTS `visitor`;

CREATE TABLE `visitor` (
  `v_id` int(11) NOT NULL AUTO_INCREMENT,
  `visitor_id` varchar(18) DEFAULT NULL COMMENT '访客账号',
  `visitor_nickname` varchar(100) DEFAULT NULL COMMENT '访客昵称',
  `my_id` varchar(18) DEFAULT NULL COMMENT '我的账号（被访者账号）',
  `visitor_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '到访时间',
  PRIMARY KEY (`v_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='访客表';

/*Data for the table `visitor` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
