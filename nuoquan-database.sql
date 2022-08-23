-- MySQL dump 10.13  Distrib 5.7.37, for Linux (x86_64)
--
-- Host: localhost    Database: nuoquan
-- ------------------------------------------------------
-- Server version	5.7.37

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin_notice`
--

DROP TABLE IF EXISTS `admin_notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin_notice` (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '主键',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '内容',
  `type` int(5) DEFAULT NULL COMMENT '类型',
  `create_id` varchar(255) DEFAULT NULL COMMENT '创建人id',
  `create_username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '创建人name',
  `create_date` datetime DEFAULT NULL COMMENT '发信时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公告';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_notice`
--

LOCK TABLES `admin_notice` WRITE;
/*!40000 ALTER TABLE `admin_notice` DISABLE KEYS */;
INSERT INTO `admin_notice` VALUES ('330381411007729664','测试公告','<p>啊啊啊<img src=\"http://img.baidu.com/hi/jx2/j_0002.gif\"/><img src=\"http://img.baidu.com/hi/jx2/j_0024.gif\"/></p>',1,'1','admin','2019-09-08 02:24:37'),('330381806358630400','鲜花视频','<p>哈哈哈哈<img src=\"http://img.baidu.com/hi/jx2/j_0024.gif\"/></p>',2,'1','admin','2019-09-08 02:26:11'),('373478036928073728','顶顶顶顶顶顶顶顶顶','<p>顶顶顶顶顶顶顶顶顶顶<img src=\"http://img.baidu.com/hi/jx2/j_0014.gif\"/></p>',1,'1','admin','2020-01-05 00:35:13');
/*!40000 ALTER TABLE `admin_notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_permission`
--

DROP TABLE IF EXISTS `admin_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin_permission` (
  `id` varchar(255) NOT NULL COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '权限名称',
  `description` varchar(255) DEFAULT NULL COMMENT '权限描述',
  `url` varchar(255) DEFAULT NULL COMMENT '授权链接',
  `is_blank` int(255) DEFAULT '0' COMMENT '是否跳转 0 不跳转 1跳转',
  `pid` varchar(255) DEFAULT NULL COMMENT '父节点id',
  `perms` varchar(255) DEFAULT NULL COMMENT '权限标识',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `visible` int(255) DEFAULT NULL COMMENT '是否可见',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_permission`
--

LOCK TABLES `admin_permission` WRITE;
/*!40000 ALTER TABLE `admin_permission` DISABLE KEYS */;
INSERT INTO `admin_permission` VALUES ('1','首页','首页','#',0,'0','#',0,'fa fa-home',1,0),('10','角色集合','角色集合','/RoleController/list',0,'9','system:role:list',2,'',NULL,0),('11','角色添加','角色添加','/RoleController/add',0,'9','system:role:add',2,'entypo-plus-squared',NULL,0),('12','角色删除','角色删除','/RoleController/remove',0,'9','system:role:remove',2,'entypo-trash',NULL,0),('13','角色修改','角色修改','/RoleController/edit',0,'9','system:role:edit',2,'fa fa-wrench',NULL,0),('14','权限展示','权限展示','/PermissionController/view',0,'592059865673760768','system:permission:view',1,'fa fa-key',3,0),('15','权限集合','权限集合','/PermissionController/list',0,'14','system:permission:list',2,'',NULL,0),('16','权限添加','权限添加','/permissionController/add',0,'14','system:permission:add',2,'entypo-plus-squared',NULL,0),('17','权限删除','权限删除','/PermissionController/remove',0,'14','system:permission:remove',2,'entypo-trash',NULL,0),('18','权限修改','权限修改','/PermissionController/edit',0,'14','system:permission:edit',2,'fa fa-wrench',NULL,0),('19','文件展示','文件展示','/FileController/view',0,'592059865673760768','system:file:view',1,'fa fa-file-image-o',4,0),('20','文件添加','文件添加','/FileController/add',0,'19','system:file:add',2,'entypo-plus-squared',NULL,0),('200208FNAFB5G06W','文章审核','文章人工审核','/CheckArticle/view',0,'592059865673760768','system:article:view',1,'fa fa-newspaper-o',5,0),('200211FWF60B5THH','文章修改','修改文章状态','/CheckArticle/edit',0,'200208FNAFB5G06W','system:article:edit',2,NULL,NULL,0),('200211G0WZMCK8H0','文章集合','文章集合','/CheckArticle/list',0,'200208FNAFB5G06W','system:article:list',2,NULL,NULL,0),('200211G2SMD5AKD4','投票审核','投票人工审核','/CheckVote/view',0,'592059865673760768','system:vote:view',1,'fa fa-hand-stop-o',6,0),('200211G93398W0M8','投票修改','修改投票','/CheckVote/edit',0,'200211G2SMD5AKD4','system:vote:edit',2,NULL,NULL,0),('200211H1YF65C4H0','投票集合','投票集合','/CheckVote/list',0,'200211G2SMD5AKD4','system:vote:list',2,NULL,NULL,0),('21','文件删除','文件删除','/FileController/remove',0,'1','system:file:remove',2,'entypo-trash',NULL,0),('22','文件修改','文件修改','/FileController/edit',0,'19','system:file:edit',2,'fa fa-wrench',NULL,0),('23','文件集合','文件集合','/FileController/list',0,'19','system:file:list',2,'',NULL,0),('330365026642825216','公告管理','公告展示','/SysNoticeController/view',0,'592059865673760768','gen:sysNotice:view',1,'fa fa-telegram',10,0),('3303650266428252171','公告集合','公告集合','/SysNoticeController/list',0,'330365026642825216','gen:sysNotice:list',2,'',NULL,0),('3303650266428252182','公告添加','公告添加','/SysNoticeController/add',0,'330365026642825216','gen:sysNotice:add',2,'entypo-plus-squared',NULL,0),('3303650266428252193','公告删除','公告删除','/SysNoticeController/remove',0,'330365026642825216','gen:sysNotice:remove',2,'entypo-trash',NULL,0),('3303650266428252204','公告修改','公告修改','/SysNoticeController/edit',0,'330365026642825216','gen:sysNotice:edit',2,'fa fa-wrench',NULL,0),('331778807298134016','定时器表达式','','/quartz/view',0,'592059865673760768','#',1,'fa fa-flash',12,0),('332157860920299520','定时任务','定时任务调度表展示','/SysQuartzJobController/view',0,'592059865673760768','gen:sysQuartzJob:view',1,'fa fa-hourglass-1',13,0),('3321578609202995211','定时任务调度表集合','定时任务调度表集合','/SysQuartzJobController/list',0,'332157860920299520','gen:sysQuartzJob:list',2,'',NULL,0),('3321578609202995222','定时任务调度表添加','定时任务调度表添加','/SysQuartzJobController/add',0,'332157860920299520','gen:sysQuartzJob:add',2,'entypo-plus-squared',NULL,0),('3321578609202995233','定时任务调度表删除','定时任务调度表删除','/SysQuartzJobController/remove',0,'332157860920299520','gen:sysQuartzJob:remove',2,'entypo-trash',NULL,0),('3321578609202995244','定时任务调度表修改','定时任务调度表修改','/SysQuartzJobController/edit',0,'332157860920299520','gen:sysQuartzJob:edit',2,'fa fa-wrench',NULL,0),('332857281479839744','定时任务日志','定时任务日志','/SysQuartzJobLogController/view',0,'592059865673760768','gen:sysQuartzJobLog:view',1,'fa fa-database',14,0),('3328572814798397451','定时任务调度日志表集合','定时任务调度日志表集合','/SysQuartzJobLogController/list',0,'332857281479839744','gen:sysQuartzJobLog:list',2,'',NULL,0),('3328572814798397473','定时任务调度日志表删除','定时任务调度日志表删除','/SysQuartzJobLogController/remove',0,'332857281479839744','gen:sysQuartzJobLog:remove',2,'entypo-trash',NULL,0),('335330315113467904','Json工具','Json格式化工具','/Json/view',1,'617766548966211584','#',1,'fa fa-retweet',10,0),('340066503263129600','省份设置','省份设置',NULL,0,'1',NULL,0,'fa fa-building',4,0),('340067579836108800','省份管理','','#',0,'340066503263129600','#',1,'fa fa-building-o',NULL,0),('340068151804956672','省份表管理','省份表展示','/SysProvinceController/view',0,'340067579836108800','gen:sysProvince:view',1,'fa fa-quora',2,0),('3400681518049566731','省份表集合','省份表集合','/SysProvinceController/list',0,'340068151804956672','gen:sysProvince:list',2,'',NULL,0),('3400681518049566742','省份表添加','省份表添加','/SysProvinceController/add',0,'340068151804956672','gen:sysProvince:add',2,'entypo-plus-squared',NULL,0),('3400681518049566753','省份表删除','省份表删除','/SysProvinceController/remove',0,'340068151804956672','gen:sysProvince:remove',2,'entypo-trash',NULL,0),('3400681518049566764','省份表修改','省份表修改','/SysProvinceController/edit',0,'340068151804956672','gen:sysProvince:edit',2,'fa fa-wrench',NULL,0),('340088022018166784','城市表管理','城市设置展示','/SysCityController/view',0,'340067579836108800','gen:sysCity:view',1,'fa fa-quora',3,0),('3400880220181667851','城市设置集合','城市设置集合','/SysCityController/list',0,'340088022018166784','gen:sysCity:list',2,'',NULL,0),('3400880220181667862','城市设置添加','城市设置添加','/SysCityController/add',0,'340088022018166784','gen:sysCity:add',2,'entypo-plus-squared',NULL,0),('3400880220181667873','城市设置删除','城市设置删除','/SysCityController/remove',0,'340088022018166784','gen:sysCity:remove',2,'entypo-trash',NULL,0),('3400880220181667884','城市设置修改','城市设置修改','/SysCityController/edit',0,'340088022018166784','gen:sysCity:edit',2,'fa fa-wrench',NULL,0),('340096183135506432','地区设置管理','地区设置展示','/SysAreaController/view',0,'340067579836108800','gen:sysArea:view',1,'fa fa-quora',4,0),('3400961831355064331','地区设置集合','地区设置集合','/SysAreaController/list',0,'340096183135506432','gen:sysArea:list',2,'',NULL,0),('3400961831355064342','地区设置添加','地区设置添加','/SysAreaController/add',0,'340096183135506432','gen:sysArea:add',2,'entypo-plus-squared',NULL,0),('3400961831355064353','地区设置删除','地区设置删除','/SysAreaController/remove',0,'340096183135506432','gen:sysArea:remove',2,'entypo-trash',NULL,0),('3400961831355064364','地区设置修改','地区设置修改','/SysAreaController/edit',0,'340096183135506432','gen:sysArea:edit',2,'fa fa-wrench',NULL,0),('340127412270534656','街道设置管理','街道设置展示','/SysStreetController/view',0,'340067579836108800','gen:sysStreet:view',1,'fa fa-quora',5,0),('3401274122705346571','街道设置集合','街道设置集合','/SysStreetController/list',0,'340127412270534656','gen:sysStreet:list',2,'',NULL,0),('3401274122705346582','街道设置添加','街道设置添加','/SysStreetController/add',0,'340127412270534656','gen:sysStreet:add',2,'entypo-plus-squared',NULL,0),('3401274122705346593','街道设置删除','街道设置删除','/SysStreetController/remove',0,'340127412270534656','gen:sysStreet:remove',2,'entypo-trash',NULL,0),('3401274122705346604','街道设置修改','街道设置修改','/SysStreetController/edit',0,'340127412270534656','gen:sysStreet:edit',2,'fa fa-wrench',NULL,0),('340301160042860544','省份联动','省份联动','/ProvinceLinkageController/view',0,'340067579836108800','#',1,'fa fa-etsy',1,0),('340381240911859712','JavaScript格式化','JavaScript格式化','/static/admin/htmlformat/javascriptFormat.html',1,'617766548966211584','#',1,'fa fa-magic',11,0),('354851114446884864','七牛文件上传','七牛文件上传','/QiNiuCloudController/view',0,'592059865673760768','system:qiNiuCloud:view',1,'fa fa-globe',15,0),('354865752219717632','云文件集合','云文件集合','/QiNiuCloudController/list',0,'354851114446884864','system:qiNiuCloud:list',2,NULL,NULL,0),('373489907429150720','URL拦截管理','拦截url表展示','/SysInterUrlController/view',0,'592059865673760768','gen:sysInterUrl:view',1,'fa fa-hand-stop-o',NULL,0),('3734899074291507211','拦截url表集合','拦截url表集合','/SysInterUrlController/list',0,'373489907429150720','gen:sysInterUrl:list',2,'',NULL,0),('3734899074291507222','拦截url表添加','拦截url表添加','/SysInterUrlController/add',0,'373489907429150720','gen:sysInterUrl:add',2,'entypo-plus-squared',NULL,0),('3734899074291507233','拦截url表删除','拦截url表删除','/SysInterUrlController/remove',0,'373489907429150720','gen:sysInterUrl:remove',2,'entypo-trash',NULL,0),('3734899074291507244','拦截url表修改','拦截url表修改','/SysInterUrlController/edit',0,'373489907429150720','gen:sysInterUrl:edit',2,'fa fa-wrench',NULL,0),('4','用户管理','用户展示','/UserController/view',0,'592059865673760768','system:user:view',1,'icon icon-user',1,0),('486690002869157888','用户密码修改','用户密码修改','/UserController/editPwd',0,'4','system:user:editPwd',2,'entypo-tools',3,0),('496126970468237312','日志展示','日志管理','/LogController/view',0,'592059865673760768','system:log:view',1,'fa fa-info',9,0),('496127240363311104','日志删除','日志删除','/LogController/remove',0,'496126970468237312','system:log:remove',2,'entypo-trash',NULL,0),('496127794879660032','日志集合','日志集合','/LogController/list',0,'496126970468237312','system:log:list',2,NULL,NULL,0),('496782496638173184','系统设置','后台设置',NULL,0,'1',NULL,0,'fa fa-gear',3,0),('5','用户集合','用户集合','/UserController/list',0,'4','system:user:list',2,'',NULL,0),('581541547099553792','druid监控','druid监控','/druid/',0,'617766548966211584','user:list',1,'fa fa-line-chart',6,0),('583063272123531264','API文档','API文档','/swagger-ui.html',1,'617766548966211584','--',1,'fa fa-font',8,0),('586003694080753664','表单构建','表单构建','/ToolController/view',0,'617766548966211584','system:tool:view',1,'fa fa-list-alt',5,0),('587453033487532032','后台模板','后台模板','/static/admin/bootstarp/index.html',1,'617766548966211584','system:htmb:view',1,'fa fa-telegram',9,0),('589559475422101504','测试目录','测试目录',NULL,0,'1',NULL,0,'fa fa-etsy',5,0),('589559748521623552','一级菜单','测试菜单','#',0,'589559475422101504','#',1,'fa fa-address-book',NULL,0),('589559916704825344','二级菜单','二级菜单','#',0,'589559748521623552','#',1,'fa fa-address-book',1,0),('592059865673760768','系统管理','后台管理','#',0,'496782496638173184','#',1,'fa fa-home',1,0),('592067570522128384','测试跳转','测试跳转','http://www.baidu.com',1,'589559748521623552','#',1,'fa fa-address-book',NULL,0),('592167738407911424','系统监控','系统监控','/ServiceController/view',0,'617766548966211584','system:service:view',1,'fa fa-video-camera',7,0),('594691026430459904','电子邮件管理','电子邮件展示','/EmailController/view',0,'592059865673760768','system:email:view',1,'fa fa-envelope',8,0),('5946910264304599041','电子邮件集合','电子邮件集合','/EmailController/list',0,'594691026430459904','system:email:list',2,'',NULL,0),('5946910264304599042','电子邮件添加','电子邮件添加','/EmailController/add',0,'594691026430459904','system:email:add',2,'entypo-plus-squared',NULL,0),('5946910264304599043','电子邮件删除','电子邮件删除','/EmailController/remove',0,'594691026430459904','system:email:remove',2,'entypo-trash',NULL,0),('5946910264304599044','电子邮件修改','电子邮件修改','/EmailController/edit',0,'594691026430459904','system:email:edit',2,'fa fa-wrench',NULL,0),('6','用户添加','用户添加','/UserController/add',0,'4','system:user:add',2,'entypo-plus-squared',NULL,0),('610635485890478080','代码生成新','代码生成2','#',0,'617751079701970944','#',1,'fa fa-blind',1,0),('610635950447394816','全局配置','','/autoCodeController/global',0,'610635485890478080','system:autocode:global',1,'fa fa-university',NULL,0),('610983815791247360','单表生成','','/autoCodeController/one',0,'610635485890478080','system:autocode:one',1,'fa fa-hand-peace-o',NULL,0),('617751079701970944','代码生成','代码生成',NULL,0,'1',NULL,0,'fa fa-500px',4,0),('617766548966211584','系统工具','系统工具','#',0,'496782496638173184','#',1,'fa fa-th-large',2,0),('618918631769636864','字典管理','字典类型表展示','/DictTypeController/view',0,'592059865673760768','system:dictType:view',1,'fa fa-puzzle-piece',11,0),('6189186317738311681','字典类型表集合','字典类型表集合','/DictTypeController/list',0,'618918631769636864','system:dictType:list',2,NULL,NULL,0),('6189186317948026882','字典类型表添加','字典类型表添加','/DictTypeController/add',0,'618918631769636864','system:dictType:add',2,NULL,NULL,0),('6189186317948026883','字典类型表删除','字典类型表删除','/DictTypeController/remove',0,'618918631769636864','system:dictType:remove',2,NULL,NULL,0),('6189186317989969924','字典类型表修改','字典类型表修改','/DictTypeController/edit',0,'618918631769636864','system:dictType:edit',2,NULL,NULL,0),('6192095214866268161','字典数据表集合','字典数据表集合','/DictDataController/list',0,'618918631769636864','system:dictData:list',2,NULL,NULL,0),('6192095214866268162','字典数据表添加','字典数据表添加','/DictDataController/add',0,'618918631769636864','system:dictData:add',2,NULL,NULL,0),('6192095215075983363','字典数据表删除','字典数据表删除','/DictDataController/remove',0,'618918631769636864','system:dictData:remove',2,NULL,NULL,0),('6192095215075983364','字典数据表修改','字典数据表修改','/DictDataController/edit',0,'618918631769636864','system:dictData:edit',2,NULL,NULL,0),('619836559427895296','字典数据视图','字典数据视图','/DictDataController/view',0,'618918631769636864','system:dictData:view',2,NULL,NULL,0),('7','用户删除','用户删除','/UserController/remove',0,'4','system:user:remove',2,'entypo-trash',NULL,0),('8','用户修改','用户修改','/UserController/edit',0,'4','system:user:edit',2,'fa fa-wrench',NULL,0),('9','角色管理','角色展示','/RoleController/view',0,'592059865673760768','system:role:view',1,'fa fa-group',2,0);
/*!40000 ALTER TABLE `admin_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_role`
--

DROP TABLE IF EXISTS `admin_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin_role` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_role`
--

LOCK TABLES `admin_role` WRITE;
/*!40000 ALTER TABLE `admin_role` DISABLE KEYS */;
INSERT INTO `admin_role` VALUES ('0','L1系统管理员'),('1','L2管理员'),('200207FXDDHX6K40','L3组织社团');
/*!40000 ALTER TABLE `admin_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_role_permission`
--

DROP TABLE IF EXISTS `admin_role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin_role_permission` (
  `id` varchar(255) NOT NULL,
  `role_id` varchar(255) DEFAULT NULL COMMENT '角色id',
  `permission_id` varchar(255) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`),
  KEY `role_id_idx` (`role_id`),
  KEY `permission_id_idx` (`permission_id`),
  CONSTRAINT `admin_role_permission_ibfk_1` FOREIGN KEY (`permission_id`) REFERENCES `admin_permission` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `admin_role_permission_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `admin_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限中间表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_role_permission`
--

LOCK TABLES `admin_role_permission` WRITE;
/*!40000 ALTER TABLE `admin_role_permission` DISABLE KEYS */;
INSERT INTO `admin_role_permission` VALUES ('200207FZ4HTP45GC','0','1'),('200207FZ4HTYZ7C0','0','21'),('200207FZ4HW5S98H','0','496782496638173184'),('200207FZ4HW95W6W','0','592059865673760768'),('200207FZ4HWCKB54','0','373489907429150720'),('200207FZ4HWH0Y3C','0','3734899074291507211'),('200207FZ4HWNCD1P','0','3734899074291507222'),('200207FZ4HWSW000','0','3734899074291507233'),('200207FZ4HWY7FY8','0','3734899074291507244'),('200207FZ4HX52HSW','0','4'),('200207FZ4HX8F3R4','0','5'),('200207FZ4HXBXMNC','0','6'),('200207FZ4HXG95KP','0','7'),('200207FZ4HXS47F8','0','8'),('200207FZ4HXXGSCH','0','486690002869157888'),('200207FZ4HY0Z9AW','0','9'),('200207FZ4HY4AW94','0','10'),('200207FZ4HY7SB7C','0','11'),('200207FZ4HYFKD40','0','12'),('200207FZ4HYFKD41','0','13'),('200207FZ4HYM1028','0','14'),('200207FZ4HYRCG0H','0','15'),('200207FZ4HYWW1YW','0','16'),('200207FZ4HZ07HX4','0','17'),('200207FZ4HZ3N3TC','0','18'),('200207FZ4HZ72MRP','0','19'),('200207FZ4HZAF5P0','0','20'),('200207FZ4HZDXPM8','0','22'),('200207FZ4HZDXPM9','0','23'),('200207FZ4HZK97HH','0','594691026430459904'),('200207FZ4HZPPSFW','0','5946910264304599041'),('200207FZ4HZW49D4','0','5946910264304599042'),('200207FZ4K02ZB9P','0','5946910264304599043'),('200207FZ4K06AY80','0','5946910264304599044'),('200207FZ4K09SD68','0','496126970468237312'),('200207FZ4K0D604H','0','496127240363311104'),('200207FZ4K0HKG2W','0','496127794879660032'),('200207FZ4K0P1214','0','330365026642825216'),('200207FZ4K0TCHZC','0','3303650266428252171'),('200207FZ4K0YW3XP','0','3303650266428252182'),('200207FZ4K127MW0','0','3303650266428252193'),('200207FZ4K15N5S8','0','3303650266428252204'),('200207FZ4K192PPH','0','618918631769636864'),('200207FZ4K1CF7MW','0','619836559427895296'),('200207FZ4K1GXSK4','0','6189186317738311681'),('200207FZ4K1GXSK5','0','6189186317948026882'),('200207FZ4K1N99GC','0','6189186317948026883'),('200207FZ4K1SPWDP','0','6189186317989969924'),('200207FZ4K1Y4BC0','0','6192095214866268161'),('200207FZ4K21GYA8','0','6192095214866268162'),('200207FZ4K24ZD8H','0','6192095215075983363'),('200207FZ4K28B06W','0','6192095215075983364'),('200207FZ4K2BSG54','0','331778807298134016'),('200207FZ4K2G623C','0','332157860920299520'),('200207FZ4K2G623D','0','3321578609202995211'),('200207FZ4K2MKK1P','0','3321578609202995222'),('200207FZ4K2S1400','0','3321578609202995233'),('200207FZ4K2XCMY8','0','3321578609202995244'),('200207FZ4K30W5WH','0','332857281479839744'),('200207FZ4K347PSW','0','3328572814798397451'),('200207FZ4K37N7R4','0','3328572814798397473'),('200207FZ4K3B2SNC','0','354851114446884864'),('200207FZ4K3FF9KP','0','354865752219717632'),('200207FZ4K3KXWH0','0','617766548966211584'),('200207FZ4K3R9BF8','0','586003694080753664'),('200207FZ4K3R9BF9','0','581541547099553792'),('200207FZ4K3WPYCH','0','592167738407911424'),('200207FZ4K404DAW','0','583063272123531264'),('200207FZ4K43H094','0','587453033487532032'),('200207FZ4K46ZG7C','0','335330315113467904'),('200207FZ4K4AB25P','0','340381240911859712'),('200207FZ4K4DSK40','0','340066503263129600'),('200207FZ4K4DSK41','0','340067579836108800'),('200207FZ4K4K6428','0','340301160042860544'),('200207FZ4K4PKN0H','0','340068151804956672'),('200207FZ4K4W15YW','0','3400681518049566731'),('200207FZ4K4ZCPX4','0','3400681518049566742'),('200207FZ4K567SRP','0','3400681518049566753'),('200207FZ4K59N9P0','0','3400681518049566764'),('200207FZ4K5D2WM8','0','340088022018166784'),('200207FZ4K5HFBHH','0','3400880220181667851'),('200207FZ4K5NXYFW','0','3400880220181667862'),('200207FZ4K5YR0BC','0','3400880220181667873'),('200207FZ4K6CB44H','0','3400880220181667884'),('200207FZ4K6N6614','0','340096183135506432'),('200207FZ4K6SKPZC','0','3400961831355064331'),('200207FZ4K6Y17XP','0','3400961831355064342'),('200207FZ4K71CSW0','0','3400961831355064353'),('200207FZ4K787WPH','0','3400961831355064364'),('200207FZ4K7BNBMW','0','340127412270534656'),('200207FZ4K7G2YK4','0','3401274122705346571'),('200207FZ4K7MFDGC','0','3401274122705346582'),('200207FZ4K7X9GC0','0','3401274122705346593'),('200207FZ4K844K8H','0','3401274122705346604'),('200207FZ4K87H46W','0','617751079701970944'),('200207FZ4K8FB63C','0','610635485890478080'),('200207FZ4K8R6800','0','610635950447394816'),('200207FZ4K8WKSY8','0','610983815791247360'),('200207FZ4K9019WH','0','589559475422101504'),('200207FZ4K93CWSW','0','589559748521623552'),('200207FZ4K96WBR4','0','592067570522128384'),('200207FZ4K9A7YNC','0','589559916704825344'),('200211H23SMF977C','1','1'),('200211H23SMR4940','1','496782496638173184'),('200211H23SMWGW28','1','592059865673760768'),('200211H23SN3AXYW','1','4'),('200211H23SN6SCX4','1','5'),('200211H23SNDKFRP','1','6'),('200211H23SNK11P0','1','7'),('200211H23SNTW3HH','1','8'),('200211H23SNZ7MFW','1','486690002869157888'),('200211H23SP2N5D4','1','9'),('200211H23SP62PBC','1','10'),('200211H23SP9F79P','1','11'),('200211H23SPCXS80','1','12'),('200211H23SPNPW4H','1','13'),('200211H23SPYGY14','1','14'),('200211H23SR1ZCZC','1','15'),('200211H23SR5AZXP','1','16'),('200211H23SR8SFW0','1','17'),('200211H23SRC61S8','1','18'),('200211H23SRGKHPH','1','200208FNAFB5G06W'),('200211H23SRN13MW','1','200211FWF60B5THH'),('200211H23SRSCMK4','1','200211G0WZMCK8H0'),('200211H23SRXW5GC','1','200211G2SMD5AKD4'),('200211H23SS4N7C0','1','200211G93398W0M8'),('200211H23SS82SA8','1','200211H1YF65C4H0');
/*!40000 ALTER TABLE `admin_role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_user`
--

DROP TABLE IF EXISTS `admin_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin_user` (
  `id` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `nickname` varchar(45) DEFAULT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `description` varchar(45) DEFAULT NULL COMMENT '备注，用于标注账号所属人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_user`
--

LOCK TABLES `admin_user` WRITE;
/*!40000 ALTER TABLE `admin_user` DISABLE KEYS */;
INSERT INTO `admin_user` VALUES ('0','admin','09d2057e436277488b71f769a9cf927d','test-account','2020-02-02 16:26:08','测试账号'),('1','admin1','3e282ce925b9a5e3bac8163aa1028297','运营账号1','2020-02-03 20:08:34','运营账号1');
/*!40000 ALTER TABLE `admin_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_user_notice`
--

DROP TABLE IF EXISTS `admin_user_notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin_user_notice` (
  `id` varchar(255) NOT NULL COMMENT '主键',
  `notice_id` varchar(255) DEFAULT NULL COMMENT '公告id',
  `user_id` varchar(255) DEFAULT NULL COMMENT '用户id',
  `state` int(2) DEFAULT NULL COMMENT '0未阅读 1 阅读',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公告_用户外键';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_user_notice`
--

LOCK TABLES `admin_user_notice` WRITE;
/*!40000 ALTER TABLE `admin_user_notice` DISABLE KEYS */;
INSERT INTO `admin_user_notice` VALUES ('330381411037089792','330381411007729664','0',1),('330381411045478400','330381411007729664','488294747442511872',0),('330381806375407616','330381806358630400','0',1),('330381806379601920','330381806358630400','488294747442511872',0),('330622143622680576','330622143597514752','0',1),('330622143626874880','330622143597514752','488294747442511872',0),('354984345649418240','354984345632641024','0',1),('373478037158760448','373478036928073728','1',1),('373478037162954752','373478036928073728','368026921239449600',0),('373478037171343360','373478036928073728','368026937181999104',0),('373478037175537664','373478036928073728','368027013392502784',0),('373478037183926272','373478036928073728','368027030899527680',0),('373478037192314880','373478036928073728','368027048402358272',0),('373478037204897792','373478036928073728','368027066563694592',0),('373478037213286400','373478036928073728','368027087866564608',0),('373478037217480704','373478036928073728','368027104895438848',0),('373478037225869312','373478036928073728','368027130728157184',0),('373478037230063616','373478036928073728','368027151624179712',0),('373478037238452224','373478036928073728','368382463233363968',0);
/*!40000 ALTER TABLE `admin_user_notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_user_role`
--

DROP TABLE IF EXISTS `admin_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin_user_role` (
  `id` varchar(45) CHARACTER SET utf8mb4 NOT NULL,
  `admin_user_id` varchar(45) DEFAULT NULL,
  `role_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id_idx` (`admin_user_id`),
  KEY `role_id_idx` (`role_id`),
  CONSTRAINT `admin_user_role_ibfk_1` FOREIGN KEY (`admin_user_id`) REFERENCES `admin_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `admin_user_role_ibfk_2` FOREIGN KEY (`admin_user_id`) REFERENCES `admin_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_user_role`
--

LOCK TABLES `admin_user_role` WRITE;
/*!40000 ALTER TABLE `admin_user_role` DISABLE KEYS */;
INSERT INTO `admin_user_role` VALUES ('220811AT3W37Y51P','0','0'),('220811AZCAYZCTF8','1','1'),('220811AZCB0N68M8','1','200207FXDDHX6K40');
/*!40000 ALTER TABLE `admin_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `advert`
--

DROP TABLE IF EXISTS `advert`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `advert` (
  `id` varchar(255) NOT NULL,
  `advertiser` varchar(255) NOT NULL,
  `position` varchar(45) NOT NULL,
  `stream_type` varchar(45) NOT NULL DEFAULT 'text',
  `content` varchar(255) DEFAULT NULL,
  `resource_url` varchar(255) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `is_jump` int(11) NOT NULL DEFAULT '0',
  `view_num` int(11) NOT NULL DEFAULT '0',
  `click_num` int(11) NOT NULL DEFAULT '0',
  `create_date` datetime NOT NULL,
  `expire_date` datetime NOT NULL,
  `period` varchar(255) DEFAULT NULL COMMENT '显示时段：\n1. 每天某一个时间段。\n2. 自定义时间段，例如：几小时/几天/…\n\n解析方式参照schedule类：\n@Scheduled(cron = "0 */15 9,12,18,19,20,21,23 * * ?")  // 每天 9，18，21点每隔15分钟',
  `status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advert`
--

LOCK TABLES `advert` WRITE;
/*!40000 ALTER TABLE `advert` DISABLE KEYS */;
/*!40000 ALTER TABLE `advert` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `id` varchar(45) CHARACTER SET utf8 NOT NULL,
  `article_title` varchar(45) NOT NULL,
  `user_id` varchar(45) CHARACTER SET utf8 NOT NULL,
  `tags` varchar(128) CHARACTER SET utf8 DEFAULT NULL,
  `article_content` text NOT NULL,
  `like_num` int(11) NOT NULL DEFAULT '0',
  `dislike_num` int(11) NOT NULL DEFAULT '0',
  `comment_num` int(11) NOT NULL DEFAULT '0',
  `collect_num` int(11) NOT NULL DEFAULT '0',
  `reported_num` int(11) DEFAULT '0',
  `popularity` int(11) NOT NULL DEFAULT '0',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '0 = unreadable, 1 = readable, 2 = checking',
  `create_date` datetime NOT NULL,
  `is_anonymous` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0 = not anonymous, 1 = anonymous',
  `view_num` int(11) NOT NULL DEFAULT '0' COMMENT '浏览量',
  PRIMARY KEY (`id`),
  KEY `id_idx` (`id`),
  KEY `article_ibfk_1` (`user_id`),
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES ('22081710D7115CDP','G站正式上线运营啦！','E158271B5E5439DA18CE67C43D4C08E6','','从Nottinghome成为GTChannel, 历经三个月的升级开发，UNNCer专属的公众平台终于与大家见面啦！\n我们希望大家可以在这里：\n1.独立的思考，自由的表达\n2.保持理性，远离网络暴力\n3.秉持公正，拒绝一切不公平\n4.热爱UNNC，共同打造健康的校园网络社区\nJumbox团队祝大家生活愉快！',0,0,0,0,0,0,0,'2022-08-16 17:25:29',0,1),('22081710G1P7PCBC','不会吧不会吧','7557AC4BFC97560DE064B04D0F1B3A05','','盒盒盒盒盒',0,0,0,0,0,0,0,'2022-08-16 17:25:41',0,1),('22081714A5A98094','叶博源没jj','7557AC4BFC97560DE064B04D0F1B3A05','','嘿嘿嘿',0,0,0,0,0,0,0,'2022-08-16 17:37:10',0,14),('22081714M3PH9400','G站正式上线运营啦！','E158271B5E5439DA18CE67C43D4C08E6','','从Nottinghome成为GTChannel, 历经三个月的升级开发，UNNCer专属的公众平台终于与大家见面啦！\n我们希望大家可以在这里：\n1.独立的思考，自由的表达\n2.保持理性，远离网络暴力\n3.秉持公正，拒绝一切不公平\n4.热爱UNNC，共同打造健康的校园网络社区\nJumbox团队祝大家生活愉快！',5,0,3,1,0,1,1,'2022-08-16 17:38:01',0,82),('2208176KSFH52XYW','谨以此帖铭记G占上线','6BAA5F41471DB8DF9177F4D868B7C738','','两年后毕业来考古！！！',3,0,3,0,0,1,1,'2022-08-17 01:17:52',0,73),('220817BBMKBH204H','耶耶！','7557AC4BFC97560DE064B04D0F1B3A05','','占楼',3,0,0,0,0,0,0,'2022-08-17 07:59:47',0,35),('220817BCW6MWSH4H','太开心了','EA536DDADA4931D7E659109AF6A88A2A','','加油加油',2,0,0,0,0,0,0,'2022-08-17 08:03:24',0,33),('220817BDZ8559WH0','vdhsudj','0EBD21F315F8DE78B14DFE07365EB529','','hrixjke',1,0,0,0,0,0,0,'2022-08-17 08:06:44',0,5),('220817BF2Z7G8G9P','哈哈哈哈哈','462256A48FE823E17C35C25CF3D0F796','','我来啦哈哈哈哈哈',0,0,0,0,0,0,1,'2022-08-17 08:07:07',0,53),('220817BG4M0W58X4','我来了','B6D297D920606D5F78AB2251406670DC','','来来来',0,0,0,0,0,0,1,'2022-08-17 08:10:18',0,53),('220817BNC71Z24BC','按摩保健','B6D297D920606D5F78AB2251406670DC','','128起步',0,0,3,1,1,0,1,'2022-08-17 08:23:08',0,56),('220817BYX8Z8CPH0','ddd','E0EB0920B26077190F224C5B729C1995','','tty',0,0,1,0,0,0,1,'2022-08-17 08:45:33',0,48),('220817C07MWDC4H0','不知道发什么','0BD5685FDAC552B67BF559EABDA447D9','','浅水一下',1,0,0,0,0,0,1,'2022-08-17 08:49:40',0,49),('220817C3Z8H2F4BC','我刘海添回来了','28B21AC61A51DE81DB7048687B163A64','','???????????',2,0,3,1,1,0,1,'2022-08-17 09:00:46',0,49),('220817C4M5DZC18H','哈','7889771600DB3F638A8D5EC82228B327','','☺',3,0,3,0,0,0,1,'2022-08-17 09:02:48',0,48),('220817C9AFDRB540','什么东西','B3E38B58C46AD7F380D877317AC97D01','#社团组织','都是些什么东西？',1,0,0,0,0,0,0,'2022-08-17 09:16:59',0,13),('220817CBZFDBK7HH','什么东西','B3E38B58C46AD7F380D877317AC97D01','','都是些什么东西啊？',1,0,0,0,0,0,0,'2022-08-17 09:24:49',0,14),('220817CGM14CH7TC','Hey，','7889771600DB3F638A8D5EC82228B327','','Wish you a happy day～✨',3,0,0,0,0,0,1,'2022-08-17 09:35:48',0,45),('220817CMM3C4NA14','哈哈','7557AC4BFC97560DE064B04D0F1B3A05','','什么情况啊',0,0,0,0,0,0,0,'2022-08-17 09:44:49',0,3),('220817FCF274HNHH','你们没人用的','B3E38B58C46AD7F380D877317AC97D01','','不会有人用的',0,0,0,0,0,0,0,'2022-08-17 12:14:31',0,2),('220817FCHWCWM5AW','底蕴','B3E38B58C46AD7F380D877317AC97D01','','什么是底蕴 知道吗？',1,0,3,0,0,3,0,'2022-08-17 12:14:49',0,12),('220817G0F47WTGHH','前端展示还有些小毛病','B6D297D920606D5F78AB2251406670DC','','英文的展示我怎么感觉在论坛里，下面展示的不完全',0,0,2,0,0,2,1,'2022-08-17 13:02:34',0,29),('220817GABGW247F8','百度（北京）实习干货分享','EA536DDADA4931D7E659109AF6A88A2A','#职场前辈说','本文略长，按时间线整理，希望会有帮助～\n\n2022年4月15日：开始找实习，修改简历，完善信息，然后去寻找合适的职位。找实习的话比较推荐实习僧和boss直聘。公司官网和其他软件（诸如51job，猎聘，拉勾）由于渠道问题不太推荐使用，效率很慢，这个之后出帖子细说。\n\n2022年4月27日：接到了北京字节的面试邀请，参加了视频面试。后来陆续收到了瑞幸咖啡，金山云，小米，蔚来（北京）的面试邀请，但是由于时间和行业问题都回绝了，没有参加。\n\n2022年5月8日：接到了百度的面试邀请，参与了视频面试和简单的笔试。笔试的题目主要是和招聘，绩效，人才库，劳动法，社保公积金相关的人资基础题。当时面试官挺恐怖的，全程面无表情，语速语调基本没啥变化，搞的我贼紧张…\n\n这段时间就在等字节和百度的消息，这个暑假我是抱定决心，一定要去一线城市的互联网头部大厂刷个经验，所以没太关注其他的公司。这段时间我想如果申不上北京的字节和百度的话就回家学GRE和德语托福了，顺便还能把驾照考完，也不错～\n\n2022年5月13日：悬着的心终于落定，百度发来了录用通知书，通知我18号去报道。感觉很开心吧，自己的能力受到了认可，也算是能去大厂的人了。中间因为考试推迟了一周，直到21号才赶到北京报道。\n\n2022年5月22日：顺利报道，办好入职手续，入职百度！后续就是大概为期3天的培训和熟悉工作。在百度主要是做常规的HR实习，支持IDG（智能驾驶业务线）+ACG（智能云业务线）+MEG（移动生态业务线）+集团综合财务部的人才工作，包括招聘绩效员工关系等等，单招聘就要单独负责支持15个岗位。\n\n那段时间非常的累，基本上每天的作息都是10:00上班，22:00下班。周末有急事还要优先支持，随叫随到，非常恐怖。公司是20:00之后有免费晚餐，21:00后可以免费打车，待遇还是可以的，只不过工资有点少（才100块一天…）。公司在上地十街，北京西二旗那边，晚上十一点了还是灯火通明，街上都是人。那一片除了百度大厦还有快手，新浪，贝壳的总部，都是和我们一样的年轻人，在为了自己的事业和未来奔波。\n\n2022年6月22日：接到了英雄互娱（北京）的新offer，离开了百度，跳槽到英雄互娱去实习了。一是实习的工资很高（每天200块），二是第一次接触游戏公司，也很想尝试一下，所以果断跳槽了。这个下一个帖子细说。\n\n不妨点个关注～谢谢支持',7,0,2,0,0,9,1,'2022-08-17 13:32:19',0,22),('220817GND4GTR968','背单词盖楼','7557AC4BFC97560DE064B04D0F1B3A05','#单词打卡','想找个人一起背单词 有人吗有人吗！',1,0,1,0,0,2,1,'2022-08-17 13:59:30',0,17),('2208183P2DWT111P','??','C1D3928A8F12AC9979FC25718FF7B049','','所以说这平台功能到底是啥',0,0,1,0,0,1,1,'2022-08-17 21:12:31',0,9);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_copy`
--

DROP TABLE IF EXISTS `article_copy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article_copy` (
  `id` varchar(45) CHARACTER SET utf8 NOT NULL,
  `article_title` varchar(45) NOT NULL,
  `user_id` varchar(45) CHARACTER SET utf8 NOT NULL,
  `tags` varchar(128) CHARACTER SET utf8 DEFAULT NULL,
  `article_content` text NOT NULL,
  `like_num` int(11) NOT NULL DEFAULT '0',
  `dislike_num` int(11) NOT NULL DEFAULT '0',
  `comment_num` int(11) NOT NULL DEFAULT '0',
  `collect_num` int(11) NOT NULL DEFAULT '0',
  `popularity` int(11) NOT NULL DEFAULT '0',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '0 = unreadable, 1 = readable, 2 = checking',
  `create_date` datetime NOT NULL,
  `is_anonymous` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0 = not anonymous, 1 = anonymous',
  `view_num` int(11) NOT NULL DEFAULT '0' COMMENT '浏览量',
  PRIMARY KEY (`id`),
  KEY `id_idx` (`id`),
  KEY `article_copy_ibfk_1` (`user_id`),
  CONSTRAINT `article_copy_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_copy`
--

LOCK TABLES `article_copy` WRITE;
/*!40000 ALTER TABLE `article_copy` DISABLE KEYS */;
/*!40000 ALTER TABLE `article_copy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_image`
--

DROP TABLE IF EXISTS `article_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article_image` (
  `id` varchar(45) CHARACTER SET utf8 NOT NULL,
  `article_id` varchar(45) CHARACTER SET utf8 NOT NULL,
  `image_path` varchar(255) NOT NULL,
  `image_order` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `article_image_idx` (`article_id`),
  CONSTRAINT `article_image_ibfk_1` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_image`
--

LOCK TABLES `article_image` WRITE;
/*!40000 ALTER TABLE `article_image` DISABLE KEYS */;
INSERT INTO `article_image` VALUES ('22081714M6YZZ0H0','22081714M3PH9400','nqprod/img/22081712334657437696.jpg',0),('2208176KSKZHKN0H','2208176KSFH52XYW','nqprod/img/22081770197746597888.jpg',0),('220817BCW82DMZ7C','220817BCW6MWSH4H','nqprod/img/220817121224090877952.gif',0),('220817BG4S43W0ZC','220817BG4M0W58X4','nqprod/img/220817122093641400320.jpg',0),('220817BNC8Z9DTHH','220817BNC71Z24BC','nqprod/img/220817123707118845952.jpg',0),('220817C3ZFT5BTC0','220817C3Z8H2F4BC','nqprod/img/220817128445682024448.jpg',0),('220817C9AHP7NWPH','220817C9AFDRB540','nqprod/img/220817130484285734912.jpg',0),('220817CBZK6BYCX4','220817CBZFDBK7HH','nqprod/img/220817131469364166656.jpg',0),('220817GABNARSBXP','220817GABGW247F8','nqprod/img/220817162611769376768.jpg',4),('220817GABNBZXR8H','220817GABGW247F8','nqprod/img/220817162611578535936.jpg',5),('220817GABNBZXR8K','220817GABGW247F8','nqprod/img/220817162611656130560.jpg',2),('220817GABNFGGZ0H','220817GABGW247F8','nqprod/img/220817162611641450496.jpg',1),('220817GABNT96AK4','220817GABGW247F8','nqprod/img/220817162611373015040.jpg',0),('220817GABP4D3B0H','220817GABGW247F8','nqprod/img/220817162611633061888.jpg',3),('220817GABPGSC094','220817GABGW247F8','nqprod/img/220817162612992016384.jpg',6),('220817GABPWCMWZC','220817GABGW247F8','nqprod/img/220817162613113651200.jpg',8),('220817GABPY10T54','220817GABGW247F8','nqprod/img/220817162613096873984.jpg',7);
/*!40000 ALTER TABLE `article_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authenticated_user`
--

DROP TABLE IF EXISTS `authenticated_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authenticated_user` (
  `id` varchar(45) NOT NULL,
  `user_id` varchar(45) CHARACTER SET utf8 NOT NULL,
  `type` tinyint(4) NOT NULL DEFAULT 0,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `authenticated_user_id_idx` (`id`),
  CONSTRAINT `authenticated_user_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='认证用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat_msg`
--

LOCK TABLES `authenticated_user` WRITE;
/*!40000 ALTER TABLE `authenticated_user` DISABLE KEYS */;
INSERT INTO `authenticated_user` VALUES ('1','oDwsO5MorWPzml_QeYekVZnRA1aw',1,'2019-10-16 16:27:31');
/*!40000 ALTER TABLE `authenticated_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chat_msg`
--

DROP TABLE IF EXISTS `chat_msg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chat_msg` (
  `id` varchar(45) NOT NULL,
  `send_user_id` varchar(45) CHARACTER SET utf8 NOT NULL,
  `accept_user_id` varchar(45) CHARACTER SET utf8 NOT NULL,
  `msg` varchar(255) NOT NULL,
  `sign_flag` int(11) NOT NULL COMMENT '0: 未签收\n1：签收',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `send_id_idx` (`send_user_id`),
  KEY `accept_user_id_idx` (`accept_user_id`),
  CONSTRAINT `chat_msg_ibfk_1` FOREIGN KEY (`accept_user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `chat_msg_ibfk_2` FOREIGN KEY (`send_user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='聊天记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat_msg`
--

LOCK TABLES `chat_msg` WRITE;
/*!40000 ALTER TABLE `chat_msg` DISABLE KEYS */;
INSERT INTO `chat_msg` VALUES ('220817041YM6A2RP','22081702KBZTN2FW','22081703A4PM6NC0','嘻嘻嘻嘻嘻',1,'2022-08-16 16:12:13'),('22081707Z37TDN0H','22081703A4PM6NC0','22081705RF35XT7C','sesa',1,'2022-08-16 16:23:55'),('22081708KWMBNPSW','22081703A4PM6NC0','22081702KBZTN2FW','哈哈哈哈',0,'2022-08-16 16:25:56'),('2208170CPMDR8YCH','2208170CNA69W1KP','22081705RF35XT7C','？？？',1,'2022-08-16 16:38:14'),('22081714Z2013P4H','7557AC4BFC97560DE064B04D0F1B3A05','E158271B5E5439DA18CE67C43D4C08E6','哈哈哈',1,'2022-08-16 17:38:59'),('22081714ZRGX2CX4','E158271B5E5439DA18CE67C43D4C08E6','7557AC4BFC97560DE064B04D0F1B3A05','艹',1,'2022-08-16 17:39:03'),('220817156RFABG7C','E158271B5E5439DA18CE67C43D4C08E6','7557AC4BFC97560DE064B04D0F1B3A05','删掉缓存',1,'2022-08-16 17:39:48'),('220817157C226140','E158271B5E5439DA18CE67C43D4C08E6','7557AC4BFC97560DE064B04D0F1B3A05','我还是我',1,'2022-08-16 17:39:52'),('220817BMSH5T558H','EA536DDADA4931D7E659109AF6A88A2A','B6D297D920606D5F78AB2251406670DC','你好',1,'2022-08-17 08:21:14'),('220817BN339H9028','B6D297D920606D5F78AB2251406670DC','EA536DDADA4931D7E659109AF6A88A2A','你好',1,'2022-08-17 08:22:09'),('220817BN430H26NC','B6D297D920606D5F78AB2251406670DC','EA536DDADA4931D7E659109AF6A88A2A','按摩保健吗',1,'2022-08-17 08:22:16'),('220817BN4X2K884H','B6D297D920606D5F78AB2251406670DC','EA536DDADA4931D7E659109AF6A88A2A','128起步',1,'2022-08-17 08:22:21'),('220817BN6SXNSYY8','B6D297D920606D5F78AB2251406670DC','EA536DDADA4931D7E659109AF6A88A2A','可以有特殊服务',1,'2022-08-17 08:22:33'),('220817BP6NF1A4BC','EA536DDADA4931D7E659109AF6A88A2A','B6D297D920606D5F78AB2251406670DC','太贵了',1,'2022-08-17 08:25:32'),('220817BP7D97F98H','EA536DDADA4931D7E659109AF6A88A2A','B6D297D920606D5F78AB2251406670DC','有10块钱的吗',1,'2022-08-17 08:25:37'),('220817BR0Y732X8H','EA536DDADA4931D7E659109AF6A88A2A','E158271B5E5439DA18CE67C43D4C08E6','你好',1,'2022-08-17 08:27:55'),('220817BR1PHT7GXP','EA536DDADA4931D7E659109AF6A88A2A','E158271B5E5439DA18CE67C43D4C08E6','我是接盘侠',1,'2022-08-17 08:28:00'),('220817BR34H1N0H0','E158271B5E5439DA18CE67C43D4C08E6','EA536DDADA4931D7E659109AF6A88A2A','操',1,'2022-08-17 08:28:09'),('220817BR3CYKK1P0','E158271B5E5439DA18CE67C43D4C08E6','EA536DDADA4931D7E659109AF6A88A2A','你',1,'2022-08-17 08:28:11'),('220817BR3TPNPMY8','E158271B5E5439DA18CE67C43D4C08E6','EA536DDADA4931D7E659109AF6A88A2A','妈',1,'2022-08-17 08:28:13'),('220817BR48DPKXGC','E158271B5E5439DA18CE67C43D4C08E6','EA536DDADA4931D7E659109AF6A88A2A','傻',1,'2022-08-17 08:28:16'),('220817BR4KMTRMA8','E158271B5E5439DA18CE67C43D4C08E6','EA536DDADA4931D7E659109AF6A88A2A','逼',1,'2022-08-17 08:28:18'),('220817BR6ANBG8PH','EA536DDADA4931D7E659109AF6A88A2A','E158271B5E5439DA18CE67C43D4C08E6','谢谢',1,'2022-08-17 08:28:30'),('220817BSNDRBYS14','B6D297D920606D5F78AB2251406670DC','EA536DDADA4931D7E659109AF6A88A2A','没有',1,'2022-08-17 08:32:55'),('220817BSR0RNWKYW','B6D297D920606D5F78AB2251406670DC','EA536DDADA4931D7E659109AF6A88A2A','但是我们这玩的花',1,'2022-08-17 08:33:05'),('220817BSR54G2C6W','EA536DDADA4931D7E659109AF6A88A2A','B6D297D920606D5F78AB2251406670DC','太low了',1,'2022-08-17 08:33:05'),('220817BSS5TC4TTC','B6D297D920606D5F78AB2251406670DC','EA536DDADA4931D7E659109AF6A88A2A','花花的',1,'2022-08-17 08:33:13'),('220817BSSWK34DP0','EA536DDADA4931D7E659109AF6A88A2A','B6D297D920606D5F78AB2251406670DC','能让我得杏病吗',1,'2022-08-17 08:33:16'),('220817BSTFH6YBXP','B6D297D920606D5F78AB2251406670DC','EA536DDADA4931D7E659109AF6A88A2A','人兽',1,'2022-08-17 08:33:21'),('220817BSWAFSNC00','EA536DDADA4931D7E659109AF6A88A2A','B6D297D920606D5F78AB2251406670DC','太好了',1,'2022-08-17 08:33:26'),('220817BSWKYH02K4','B6D297D920606D5F78AB2251406670DC','EA536DDADA4931D7E659109AF6A88A2A','多人',1,'2022-08-17 08:33:28'),('220817BSY5779R8H','B6D297D920606D5F78AB2251406670DC','EA536DDADA4931D7E659109AF6A88A2A','老少欢',1,'2022-08-17 08:33:38'),('220817BSZBAHPK8H','B6D297D920606D5F78AB2251406670DC','EA536DDADA4931D7E659109AF6A88A2A','户外',1,'2022-08-17 08:33:46'),('220817BT07B6DN9P','B6D297D920606D5F78AB2251406670DC','EA536DDADA4931D7E659109AF6A88A2A','乱伦',1,'2022-08-17 08:33:52'),('220817BT0RG0AHDP','B6D297D920606D5F78AB2251406670DC','EA536DDADA4931D7E659109AF6A88A2A','人妻',1,'2022-08-17 08:33:55'),('220817BT17YHKKP0','B6D297D920606D5F78AB2251406670DC','EA536DDADA4931D7E659109AF6A88A2A','都有',1,'2022-08-17 08:33:58'),('220817BW02AA5YFW','1207A251D249E08C896F68FC1A1D5AC8','E158271B5E5439DA18CE67C43D4C08E6','?',1,'2022-08-17 08:36:50'),('220817BWKY48Z9AW','E158271B5E5439DA18CE67C43D4C08E6','1207A251D249E08C896F68FC1A1D5AC8','??',1,'2022-08-17 08:38:44'),('220817BWR1ZNHFNC','1207A251D249E08C896F68FC1A1D5AC8','E158271B5E5439DA18CE67C43D4C08E6','❤',1,'2022-08-17 08:39:05'),('220817BWSW1WCT54','E158271B5E5439DA18CE67C43D4C08E6','1207A251D249E08C896F68FC1A1D5AC8','/:heart',1,'2022-08-17 08:39:16'),('220817BXA7342428','EA536DDADA4931D7E659109AF6A88A2A','B6D297D920606D5F78AB2251406670DC','来个图',1,'2022-08-17 08:40:55'),('220817BXBZ16WBR4','EA536DDADA4931D7E659109AF6A88A2A','B6D297D920606D5F78AB2251406670DC','哦对发不了图',1,'2022-08-17 08:41:06'),('220817C0HN5CMGTC','E158271B5E5439DA18CE67C43D4C08E6','0BD5685FDAC552B67BF559EABDA447D9','哈喽',1,'2022-08-17 08:50:37'),('220817C0KWDR5HBC','E158271B5E5439DA18CE67C43D4C08E6','0BD5685FDAC552B67BF559EABDA447D9','谢谢宝宝的关注',1,'2022-08-17 08:50:45'),('220817C1846SP4X4','0BD5685FDAC552B67BF559EABDA447D9','E158271B5E5439DA18CE67C43D4C08E6','嗯呢 不谢哦 宝宝',1,'2022-08-17 08:52:43'),('220817C1Z4A0H3XP','EA536DDADA4931D7E659109AF6A88A2A','E0EB0920B26077190F224C5B729C1995','hello',0,'2022-08-17 08:54:45'),('220817GD3TA5CXD4','6BAA5F41471DB8DF9177F4D868B7C738','0C0FDA9B8EA936EE3874E98D22505872','嘿嘿嘿',0,'2022-08-17 13:40:30'),('220817GD676ASPPH','6BAA5F41471DB8DF9177F4D868B7C738','0C0FDA9B8EA936EE3874E98D22505872','私信里打字上面会消失，好奇怪',0,'2022-08-17 13:40:45'),('220817H5FXXDY5P0','462256A48FE823E17C35C25CF3D0F796','EA536DDADA4931D7E659109AF6A88A2A','hi',1,'2022-08-17 14:41:44'),('220817H5HFGD93MW','462256A48FE823E17C35C25CF3D0F796','EA536DDADA4931D7E659109AF6A88A2A','金总',1,'2022-08-17 14:41:54'),('220817H6ZHCNCM80','EA536DDADA4931D7E659109AF6A88A2A','462256A48FE823E17C35C25CF3D0F796','啊这',1,'2022-08-17 14:46:06'),('220817H702H32YK4','EA536DDADA4931D7E659109AF6A88A2A','462256A48FE823E17C35C25CF3D0F796','你是？',1,'2022-08-17 14:46:09'),('220817H8PDT44YCH','462256A48FE823E17C35C25CF3D0F796','EA536DDADA4931D7E659109AF6A88A2A','哈哈哈哈',1,'2022-08-17 14:51:20'),('220817H8RDAA4KYW','462256A48FE823E17C35C25CF3D0F796','EA536DDADA4931D7E659109AF6A88A2A','我是凯新',1,'2022-08-17 14:51:27');
/*!40000 ALTER TABLE `chat_msg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `events_calendar`
--

DROP TABLE IF EXISTS `events_calendar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `events_calendar` (
  `id` varchar(45) CHARACTER SET utf8 NOT NULL,
  `title` varchar(45) NOT NULL COMMENT '事件名称',
  `description` text COMMENT '事件简介',
  `faculty` varchar(45) NOT NULL COMMENT '学院',
  `degree` varchar(45) NOT NULL COMMENT '学历',
  `venue` varchar(45) NOT NULL COMMENT '事件地点',
  `date` varchar(45) NOT NULL COMMENT '事件日期',
  `time` varchar(45) NOT NULL COMMENT '事件具体时间',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '0:unreadable/1:readable/2:checking',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `events_calendar`
--

LOCK TABLES `events_calendar` WRITE;
/*!40000 ALTER TABLE `events_calendar` DISABLE KEYS */;
/*!40000 ALTER TABLE `events_calendar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `featured_article`
--

DROP TABLE IF EXISTS `featured_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `featured_article` (
  `id` varchar(45) CHARACTER SET utf8 NOT NULL,
  `article_id` varchar(45) CHARACTER SET utf8 NOT NULL COMMENT '文章id',
  `cover_path` varchar(255) NOT NULL COMMENT '封面图片',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否加精 0:取消加精/1:精选文章',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `article_id_idx` (`article_id`),
  CONSTRAINT `featured_article_ibfk_1` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `featured_article`
--

LOCK TABLES `featured_article` WRITE;
/*!40000 ALTER TABLE `featured_article` DISABLE KEYS */;
/*!40000 ALTER TABLE `featured_article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `headlines`
--

DROP TABLE IF EXISTS `headlines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `headlines` (
  `target_id` varchar(45) NOT NULL COMMENT '对象id',
  `target_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`target_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='头条文章';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `headlines`
--

LOCK TABLES `headlines` WRITE;
/*!40000 ALTER TABLE `headlines` DISABLE KEYS */;
INSERT INTO `headlines` VALUES ('200925DXMXCABCM8','longarticle'),('201003DPM2MA4T54','longarticle'),('201012BWFF3PGH6W','longarticle');
/*!40000 ALTER TABLE `headlines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notify_remind`
--

DROP TABLE IF EXISTS `notify_remind`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notify_remind` (
  `id` varchar(45) NOT NULL,
  `sender_id` varchar(45) NOT NULL COMMENT '操作者的ID，三个0代表是系统发送的；',
  `sender_action` varchar(45) NOT NULL COMMENT '操作者的动作，如：like, comment、follow、donate、collect;',
  `source_id` varchar(45) DEFAULT NULL COMMENT '动作源对象ID，如评论内容',
  `target_id` varchar(45) NOT NULL COMMENT '目标对象ID；',
  `target_type` varchar(45) NOT NULL COMMENT '被操作对象类型，如：user, article, vote',
  `recipient_id` varchar(45) NOT NULL COMMENT '消息接收者；可能是对象的所有者或订阅者；',
  `sign_flag` int(11) NOT NULL COMMENT '0: 未签收\\n1：签收',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `read_date` datetime DEFAULT NULL COMMENT '阅读时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notify_remind`
--

LOCK TABLES `notify_remind` WRITE;
/*!40000 ALTER TABLE `notify_remind` DISABLE KEYS */;
INSERT INTO `notify_remind` VALUES ('220724F8DAB7WN7C','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','220724F8DAABZYNC','191031940T5Z3TC0','article','oDwsO5MorWPzml_QeYekVZnRA1aw',0,'2022-07-24 12:02:26',NULL),('220724F8FF9GX6Y8','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','220724F8FF7W3RS8','1910319MHZSK1AW0','article','oDwsO5AOSFKNEG1zD3eG0R1hmMXU',0,'2022-07-24 12:02:33',NULL),('220724F8GKX0791P','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','220724F8GKW0Z1GC','1910319MHZSK1AW0','article','oDwsO5AOSFKNEG1zD3eG0R1hmMXU',0,'2022-07-24 12:02:41',NULL),('220725GT8A0YXCDP','oDwsO5HQKpQA8hMWfVllfwPRuz7w','like','220725GT89ZZK4ZC','220725CGCSB82MCH','article','oDwsO5FDozoraPzxqwIo9kx0RBxY',1,'2022-07-25 14:11:00',NULL),('220725GTA4G240ZC','oDwsO5HQKpQA8hMWfVllfwPRuz7w','comment','220725GTA4F9MT9P','220725CGCSB82MCH','article','oDwsO5FDozoraPzxqwIo9kx0RBxY',1,'2022-07-25 14:11:12',NULL),('22072604SX3FBA14','oDwsO5OBHV3ySBMuKiy8aUDFH0ds','like','22072604SX0YR494','1910312CX6FK5N0H','article','oDwsO5Mjxnj2-O1yXl064bOQbELQ',0,'2022-07-25 16:14:28',NULL),('220726AFDF09BTC0','oDwsO5FDozoraPzxqwIo9kx0RBxY','like','220726AFDDZDG2W0','2207269ZPP3BK4ZC','article','oDwsO5OBHV3ySBMuKiy8aUDFH0ds',1,'2022-07-26 06:44:11',NULL),('220726B9R48NPMY8','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','220726B9R47TTYA8','22072608X65T391P','article','oDwsO5OBHV3ySBMuKiy8aUDFH0ds',1,'2022-07-26 07:54:04',NULL),('220726B9TC231XWH','oDwsO5DzaZCsdhIWECabpZgoiWr0','comment','220726B9TC0M3FK4','22072608X65T391P','article','oDwsO5OBHV3ySBMuKiy8aUDFH0ds',1,'2022-07-26 07:54:18',NULL),('220726B9TYC6AGTC','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','220726B9TYAM0KKP','220726056HKKSZHH','article','oDwsO5OBHV3ySBMuKiy8aUDFH0ds',1,'2022-07-26 07:54:22',NULL),('220726B9WXRP0568','oDwsO5DzaZCsdhIWECabpZgoiWr0','comment','220726B9WXPK8ARP','220726056HKKSZHH','article','oDwsO5OBHV3ySBMuKiy8aUDFH0ds',1,'2022-07-26 07:54:28',NULL),('220726BBFF75D968','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','220726BBFF69HHM8','22072605CKH3M1S8','article','oDwsO5OBHV3ySBMuKiy8aUDFH0ds',1,'2022-07-26 07:59:21',NULL),('220726BBM1Y0DP00','oDwsO5DzaZCsdhIWECabpZgoiWr0','comment','220726BBM1WMYTMW','220725CGAKZD34DP','article','oDwsO5FDozoraPzxqwIo9kx0RBxY',1,'2022-07-26 07:59:44',NULL),('220726BBMAPX0KYW','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','220726BBMAP4GC94','220725CGAKZD34DP','article','oDwsO5FDozoraPzxqwIo9kx0RBxY',1,'2022-07-26 07:59:46',NULL),('220726C2914MKNMW','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','220726C2913SPZ2W','220726A27MPBRNMW','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-07-26 08:55:49',NULL),('220726C294D7N540','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','220726C294C8AXKP','220726A1M5W8XD40','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-07-26 08:55:50',NULL),('220726D4KNP298H0','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','220726D4KNM096K4','220726CZ7KF360SW','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-07-26 10:26:49',NULL),('220726D4KT3W2MCH','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','220726D4KT2WSAY8','220726CZSMCCADWH','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-07-26 10:26:50',NULL),('220726D4KZGMHP6W','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','220726D4KZFY3FK4','220726CZXGHX372W','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-07-26 10:26:51',NULL),('220726D4N5CMGTC0','oDwsO5DzaZCsdhIWECabpZgoiWr0','comment','220726D4N5B90Z2W','220726CZXGHX372W','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-07-26 10:26:59',NULL),('220728B2WAH6A04H','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','220728B2WAFM01YW','220726CT4X95G2W0','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-07-28 07:33:23',NULL),('220728B2ZHZW6H4H','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','220728B2ZHZ3RAFW','2207269ZPP3BK4ZC','article','oDwsO5OBHV3ySBMuKiy8aUDFH0ds',1,'2022-07-28 07:33:44',NULL),('22072993TSTCFA80','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','22072993TSS2ZDYW','220728AZFMSH5N9P','article','oDwsO5A-1gkeGk_1dVrslR6HYVvA',0,'2022-07-29 04:48:11',NULL),('22072993XRB06MRP','oDwsO5DzaZCsdhIWECabpZgoiWr0','comment','22072993XRA7RD40','220726CZSMCCADWH','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-07-29 04:48:24',NULL),('22073100G26FDXWH','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','22073100G25BS3C0','220730HA0G7BXR8H','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-07-30 16:01:37',NULL),('22073100GSGYA2RP','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','22073100GSFZ1T7C','220730HZ2KT0S4BC','comment','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-07-30 16:01:42',NULL),('22073100K557MKD4','oDwsO5DzaZCsdhIWECabpZgoiWr0','comment','22073100K53SP65P','220730HZ2KT0S4BC','comment','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-07-30 16:01:51',NULL),('22073105X3T1NXAW','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','22073105X3S2BKWH','220730G8M9C16NR4','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-07-30 16:17:42',NULL),('220731063X6WH6FW','oDwsO5DzaZCsdhIWECabpZgoiWr0','comment','220731063X6430X4','220730G8M9C16NR4','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-07-30 16:18:26',NULL),('2207312HBR4R92A8','oDwsO5DChzIXeC7VpPMWS8Z6VdlM','comment','2207312HBR3MK7XP','220731063X6430X4','comment','oDwsO5DzaZCsdhIWECabpZgoiWr0',1,'2022-07-30 19:37:26',NULL),('220731AG7BMZ2H4H','oDwsO5DzaZCsdhIWECabpZgoiWr0','comment','220731AG7BHFTXAW','220731063X6430X4','comment','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-07-31 06:46:32',NULL),('220731AG8X55XA5P','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','220731AG8X2RMNC0','2207312T1B4ARX68','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-07-31 06:46:42',NULL),('220731AG917415YW','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','220731AG91684DAW','2207312SBYPD30H0','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-07-31 06:46:42',NULL),('220731AG9G8018H0','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','220731AG9G6MFC6W','220730HA0G7BXR8H','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-07-31 06:46:46',NULL),('2208028551WMK400','oDwsO5KKi7LvApN5bAErRN-tS6ew','comment','2208028551TN8WDP','220802836GAGB8BC','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-02 03:28:07',NULL),('2208028FDGWCW8DP','oDwsO5DzaZCsdhIWECabpZgoiWr0','comment','2208028FDGTTSKS8','22080289ZPTR4GMW','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-02 03:56:03',NULL),('2208028FKNSM5DD4','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','2208028FKNRGDN0H','2208028FH4XX62RP','article','oDwsO5FDozoraPzxqwIo9kx0RBxY',1,'2022-08-02 03:56:30',NULL),('2208028FM0T3MYK4','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','2208028FM0S4AN2W','2208028F9727TNTC','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-02 03:56:32',NULL),('2208028FM5WDDTHH','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','2208028FM5TF5H28','2208028DPYK0BZMW','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-02 03:56:33',NULL),('2208028FMARGX1P0','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','2208028FMANZG3F8','2208028BAW6RH280','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-02 03:56:34',NULL),('2208028FMG2N9AW0','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','2208028FMG1TCM80','22080289ZPTR4GMW','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-02 03:56:35',NULL),('2208028FMNCS1ZF8','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','2208028FMNBNA51P','2208028855P3HR68','article','oDwsO5FDozoraPzxqwIo9kx0RBxY',1,'2022-08-02 03:56:36',NULL),('2208028FMTCX0T54','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','2208028FMTBS90PH','22080287ZSM98YCH','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-02 03:56:37',NULL),('2208028FMZSKFT0H','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','2208028FMZRM6GF8','22080285ZKSHMGTC','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-02 03:56:38',NULL),('2208028FN3RFA98H','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','2208028FN3PMDHPH','22080285XZHWB2W0','article','oDwsO5FDozoraPzxqwIo9kx0RBxY',1,'2022-08-02 03:56:39',NULL),('220802CDBY0BYPPH','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','220802CDBXZ5TB9P','220802CAXP04AB7C','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-02 09:29:09',NULL),('220802CDCNXP2ZHH','oDwsO5DzaZCsdhIWECabpZgoiWr0','comment','220802CDCNWZKRYW','220802CAXP04AB7C','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-02 09:29:14',NULL),('220802CFAPCN558H','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','220802CFAPBNWXS8','220802CCGF1TXFRP','article','oDwsO5HQKpQA8hMWfVllfwPRuz7w',1,'2022-08-02 09:32:02',NULL),('220802D0W1A4ZTR4','oDwsO5DzaZCsdhIWECabpZgoiWr0','comment','220802D0W18HKXGC','220802CAXP04AB7C','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-02 10:15:29',NULL),('220802D0WS5W1CDP','oDwsO5DzaZCsdhIWECabpZgoiWr0','comment','220802D0WS56ZRS8','220802CAXP04AB7C','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-02 10:15:34',NULL),('220802D0XCZ1AYK4','oDwsO5DzaZCsdhIWECabpZgoiWr0','comment','220802D0XCY5F614','220802CAXP04AB7C','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-02 10:15:38',NULL),('220802D0XZM8HHZC','oDwsO5DzaZCsdhIWECabpZgoiWr0','comment','220802D0XZKH3B9P','220802CAXP04AB7C','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-02 10:15:42',NULL),('220802D0YTP11DD4','oDwsO5DzaZCsdhIWECabpZgoiWr0','comment','220802D0YTN8H7TC','220802CAXP04AB7C','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-02 10:15:47',NULL),('220802D102D7ZRD4','oDwsO5DzaZCsdhIWECabpZgoiWr0','comment','220802D102CMY2RP','220802CAXP04AB7C','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-02 10:15:55',NULL),('220804BR5ZYXRKP0','oDwsO5DChzIXeC7VpPMWS8Z6VdlM','comment','220804BR5ZWA3C00','220802CFF4ANYPPH','article','oDwsO5DzaZCsdhIWECabpZgoiWr0',1,'2022-08-04 08:28:28',NULL),('220804BR7SKS20SW','oDwsO5DChzIXeC7VpPMWS8Z6VdlM','comment','220804BR7SK50A3C','220802CCGF1TXFRP','article','oDwsO5HQKpQA8hMWfVllfwPRuz7w',1,'2022-08-04 08:28:40',NULL),('220804BRCKXK9PM8','oDwsO5KKi7LvApN5bAErRN-tS6ew','comment','220804BRCKWWWG0H','220804BR0GNDSGTC','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-04 08:29:11',NULL),('220804BRFFKFBT2W','oDwsO5DChzIXeC7VpPMWS8Z6VdlM','comment','220804BRFFHXA4BC','2208028TW6RA037C','article','oDwsO5DzaZCsdhIWECabpZgoiWr0',1,'2022-08-04 08:29:23',NULL),('220805GBCXRBS8M8','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','220805GBCXNP0TF8','220805G41GNWAW94','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-05 13:35:28',NULL),('220805GBD6433WPH','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','220805GBD62X0G9P','220804BR0GNDSGTC','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-05 13:35:30',NULL),('220805GBDYCSFW00','oDwsO5DzaZCsdhIWECabpZgoiWr0','comment','220805GBDYC21MA8','220804BR0GNDSGTC','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-05 13:35:34',NULL),('220805HSP5GSWFA8','oDwsO5DChzIXeC7VpPMWS8Z6VdlM','comment','220805HSP5DZNF80','220805GDNWCXN8BC','article','oDwsO5DzaZCsdhIWECabpZgoiWr0',1,'2022-08-05 15:33:20',NULL),('2208060087GPBD8H','oDwsO5KKi7LvApN5bAErRN-tS6ew','like','2208060087FKNMW0','220805G41GNWAW94','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-05 16:00:53',NULL),('22080601KRSKM51P','oDwsO5DzaZCsdhIWECabpZgoiWr0','comment','22080601KRRRRCDP','220805HSP5DZNF80','comment','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-05 16:04:55',NULL),('2208069RM9BMD4ZC','oDwsO5DChzIXeC7VpPMWS8Z6VdlM','comment','2208069RM9ASHCBC','22080685CKDSSXYW','article','oDwsO5DzaZCsdhIWECabpZgoiWr0',1,'2022-08-06 05:41:39',NULL),('220807BC8MBF8GMW','oDwsO5DChzIXeC7VpPMWS8Z6VdlM','comment','220807BC8MARTA14','22080797CXNWP5GC','article','oDwsO5DzaZCsdhIWECabpZgoiWr0',1,'2022-08-07 08:01:44',NULL),('220807BCRC3G5Y5P','oDwsO5DChzIXeC7VpPMWS8Z6VdlM','comment','220807BCRC2Y47F8','22080685RX8KA1S8','article','oDwsO5DzaZCsdhIWECabpZgoiWr0',1,'2022-08-07 08:03:06',NULL),('220807BCRYC8ZNTC','oDwsO5DChzIXeC7VpPMWS8Z6VdlM','like','220807BCRYAPKRKP','22080685RX8KA1S8','article','oDwsO5DzaZCsdhIWECabpZgoiWr0',1,'2022-08-07 08:03:09',NULL),('220809B4WMA9D1AW','oDwsO5A-1gkeGk_1dVrslR6HYVvA','comment','220809B4WG97YM3C','220807F6T2F5WDAW','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-09 07:39:25',NULL),('220809B6499593MW','oDwsO5KKi7LvApN5bAErRN-tS6ew','comment','220809B6498CTY14','220807F6T2F5WDAW','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-09 07:43:15',NULL),('220809BFRCAA1THH','oDwsO5A-1gkeGk_1dVrslR6HYVvA','comment','220809BFR9HPMZHH','220807F6T2F5WDAW','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-09 08:09:06',NULL),('220809FS86P2NYA8','oDwsO5KKi7LvApN5bAErRN-tS6ew','like','220809FS86N6T5S8','220731G6M3MD763C','article','oDwsO5DzaZCsdhIWECabpZgoiWr0',1,'2022-08-09 12:43:55',NULL),('220811AYDNMNKHPH','oDwsO5OBHV3ySBMuKiy8aUDFH0ds','comment','220811AYDNKTPW4H','220802CAXP04AB7C','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-11 07:20:14',NULL),('220811AYHCPZBC94','oDwsO5OBHV3ySBMuKiy8aUDFH0ds','comment','220811AYHCP6Y6NC','220802CAXP04AB7C','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-11 07:20:32',NULL),('220811AYMRA41P94','oDwsO5OBHV3ySBMuKiy8aUDFH0ds','comment','220811AYMR9G01KP','220802CAXP04AB7C','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-11 07:20:47',NULL),('220811B0TDRXDY5P','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','220811B0TDR1K5KP','220811B0NB4497XP','article','oDwsO5OBHV3ySBMuKiy8aUDFH0ds',1,'2022-08-11 07:27:17',NULL),('220811B0WDAD0F14','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','220811B0WD9K3RD4','220811B0H2FK5N0H','article','oDwsO5OBHV3ySBMuKiy8aUDFH0ds',1,'2022-08-11 07:27:24',NULL),('220811B0WPBZP9S8','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','220811B0WPAX0G9P','220811B0H2FK5N0H','article','oDwsO5OBHV3ySBMuKiy8aUDFH0ds',1,'2022-08-11 07:27:25',NULL),('220811B0XZX9KMNC','oDwsO5DzaZCsdhIWECabpZgoiWr0','comment','220811B0XZTFCMK4','220811B0H2FK5N0H','article','oDwsO5OBHV3ySBMuKiy8aUDFH0ds',1,'2022-08-11 07:27:33',NULL),('220811B0ZXWSZG7C','oDwsO5DzaZCsdhIWECabpZgoiWr0','comment','220811B0ZXTZ2SNC','220811B0NB4497XP','article','oDwsO5OBHV3ySBMuKiy8aUDFH0ds',1,'2022-08-11 07:27:46',NULL),('220811B10D4BANC0','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','220811B10D2T0R68','220807F6T2F5WDAW','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-11 07:27:49',NULL),('220811BYDDBPGB0H','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','220811BYDDAR73F8','220811B1BYND1TXP','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-11 08:44:17',NULL),('220811BYDGGCAT0H','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','220811BYDGFD2GF8','220811B6PGTZKA5P','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-11 08:44:17',NULL),('220811BYFYA769YW','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','220811BYFY9B9KAW','220811AYWY2X2140','article','oDwsO5OBHV3ySBMuKiy8aUDFH0ds',1,'2022-08-11 08:44:26',NULL),('2208129Z7S7KAYK4','oDwsO5FDozoraPzxqwIo9kx0RBxY','comment','2208129Z7S6WXPZC','220811B0NB4497XP','article','oDwsO5OBHV3ySBMuKiy8aUDFH0ds',1,'2022-08-12 05:58:32',NULL),('220812ANBND2YFFW','oDwsO5DChzIXeC7VpPMWS8Z6VdlM','like','220812ANBNC3M70H','220812AKDZ8YPBC0','article','oDwsO5DzaZCsdhIWECabpZgoiWr0',1,'2022-08-12 06:59:00',NULL),('220812C735HWSMRP','oDwsO5KKi7LvApN5bAErRN-tS6ew','comment','220812C735H7R028','220811B0NB4497XP','article','oDwsO5OBHV3ySBMuKiy8aUDFH0ds',1,'2022-08-12 09:10:12',NULL),('220812C9T6C5MBHH','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','220812C9T6B9RN0H','220812C6SZ5NAM3C','article','oDwsO5KKi7LvApN5bAErRN-tS6ew',1,'2022-08-12 09:18:21',NULL),('22081304DY04W5WH','oDwsO5DChzIXeC7VpPMWS8Z6VdlM','like','22081304DXY67MW0','220812H7PS93PXD4','article','oDwsO5KKi7LvApN5bAErRN-tS6ew',1,'2022-08-12 16:13:30',NULL),('22081304H4XY7YNC','oDwsO5DChzIXeC7VpPMWS8Z6VdlM','comment','22081304H4X96800','220812H7PS93PXD4','article','oDwsO5KKi7LvApN5bAErRN-tS6ew',1,'2022-08-12 16:13:45',NULL),('22081306AGC4B44H','oDwsO5DChzIXeC7VpPMWS8Z6VdlM','comment','22081306AGBBXYFW','220811AYHCP6Y6NC','comment','oDwsO5OBHV3ySBMuKiy8aUDFH0ds',1,'2022-08-12 16:19:09',NULL),('220813088BXMWM80','oDwsO5KKi7LvApN5bAErRN-tS6ew','comment','220813088BWYBCM8','22081307BM89GYA8','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-12 16:24:55',NULL),('220813093FR5GD8H','oDwsO5DChzIXeC7VpPMWS8Z6VdlM','comment','220813093FP9MPPH','220813088BWYBCM8','comment','oDwsO5KKi7LvApN5bAErRN-tS6ew',1,'2022-08-12 16:27:24',NULL),('2208138SSM1SA6NC','oDwsO5FDozoraPzxqwIo9kx0RBxY','comment','2208138SSM0T1Z54','220813088BWYBCM8','comment','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-13 04:21:03',NULL),('2208138SZR9P42Y8','oDwsO5FDozoraPzxqwIo9kx0RBxY','comment','2208138SZR8PTTC0','220813088BWYBCM8','comment','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-13 04:21:36',NULL),('220813FFKC075FCH','oDwsO5DChzIXeC7VpPMWS8Z6VdlM','comment','220813FFKBZ1251P','2208138R31D08754','article','oDwsO5DzaZCsdhIWECabpZgoiWr0',1,'2022-08-13 12:20:53',NULL),('220813G1HMD7CTF8','oDwsO5DChzIXeC7VpPMWS8Z6VdlM','like','220813G1HM8WKKP0','220813FFM37NPCBC','article','oDwsO5FDozoraPzxqwIo9kx0RBxY',1,'2022-08-13 13:05:50',NULL),('220813GC9WF4XZF8','oDwsO5DChzIXeC7VpPMWS8Z6VdlM','comment','220813GC9WCHH18H','220813FFM37NPCBC','article','oDwsO5FDozoraPzxqwIo9kx0RBxY',1,'2022-08-13 13:38:08',NULL),('220813GD0Z1763C0','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','220813GD0YZ8KHBC','220813FCGZ8CAW94','article','oDwsO5GjIzUB0-QRK90ZufPEQVpk',1,'2022-08-13 13:40:11',NULL),('220813GD3XNAT9P0','oDwsO5DzaZCsdhIWECabpZgoiWr0','comment','220813GD3XHCYG54','220813FFKBZ1251P','comment','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-13 13:40:30',NULL),('220813GFRGGAD2A8','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','220813GFRGCY6BHH','220813GDT6G7SKS8','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-13 13:45:24',NULL),('220813GFS3TP2428','oDwsO5DzaZCsdhIWECabpZgoiWr0','comment','220813GFS3R4BYA8','220813GDT6G7SKS8','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-13 13:45:28',NULL),('220813GKM03PC65P','oDwsO5DChzIXeC7VpPMWS8Z6VdlM','comment','220813GKM00XYYK4','220813GHDSRSY2RP','article','oDwsO5DzaZCsdhIWECabpZgoiWr0',1,'2022-08-13 13:54:01',NULL),('220813GKRN4KCDP0','oDwsO5DChzIXeC7VpPMWS8Z6VdlM','comment','220813GKRN2GCBR4','220813GHDSRSY2RP','article','oDwsO5DzaZCsdhIWECabpZgoiWr0',1,'2022-08-13 13:54:25',NULL),('220813H0Z7X0W37C','oDwsO5FDozoraPzxqwIo9kx0RBxY','like','220813H0Z7KTGKWH','220813GDT6G7SKS8','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-13 14:28:03',NULL),('220813H39M6WH18H','oDwsO5FDozoraPzxqwIo9kx0RBxY','comment','220813H39M3T7NTC','220813GDT6G7SKS8','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-13 14:35:10',NULL),('220813H39Z2DH4X4','oDwsO5FDozoraPzxqwIo9kx0RBxY','comment','220813H39Z0RSNR4','220813GDT6G7SKS8','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-13 14:35:12',NULL),('220813H3A80BBC94','oDwsO5FDozoraPzxqwIo9kx0RBxY','comment','220813H3A7W0H6FW','220813GDT6G7SKS8','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-13 14:35:14',NULL),('220813HCCXYS6PPH','oDwsO5FDozoraPzxqwIo9kx0RBxY','comment','220813HCCXTPYB7C','220813GDT6G7SKS8','article','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-13 15:02:32',NULL),('220813HCX9AKZ91P','oDwsO5FDozoraPzxqwIo9kx0RBxY','comment','220813HCX98SS8ZC','220813GKRN2GCBR4','comment','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-13 15:03:52',NULL),('220813HD0WTPKKP0','oDwsO5FDozoraPzxqwIo9kx0RBxY','comment','220813HD0WRS12NC','220813GKM00XYYK4','comment','oDwsO5DChzIXeC7VpPMWS8Z6VdlM',1,'2022-08-13 15:04:15',NULL),('220813HK9A1060DP','oDwsO5FDozoraPzxqwIo9kx0RBxY','comment','220813HK99YCGSRP','220813HFKFFYYTMW','article','oDwsO5DzaZCsdhIWECabpZgoiWr0',1,'2022-08-13 15:17:10',NULL),('220814AHDRRYWPX4','oDwsO5DChzIXeC7VpPMWS8Z6VdlM','like','220814AHDRM1NMW0','220814A98K6A4CPH','article','oDwsO5DzaZCsdhIWECabpZgoiWr0',1,'2022-08-14 06:50:13',NULL),('220814AHHHM8YW94','oDwsO5DChzIXeC7VpPMWS8Z6VdlM','comment','220814AHHHHW0D1P','220814A98K6A4CPH','article','oDwsO5DzaZCsdhIWECabpZgoiWr0',1,'2022-08-14 06:50:31',NULL),('220814AY5C6KH3HH','oDwsO5KKi7LvApN5bAErRN-tS6ew','comment','220814AY5C54KP94','220814A98K6A4CPH','article','oDwsO5DzaZCsdhIWECabpZgoiWr0',1,'2022-08-14 07:19:21',NULL),('220815886T0ZTANC','oDwsO5DChzIXeC7VpPMWS8Z6VdlM','comment','220815886STZYF5P','220814AY5C54KP94','comment','oDwsO5KKi7LvApN5bAErRN-tS6ew',1,'2022-08-15 03:37:19',NULL),('220815C0ZYH98TTC','oDwsO5DzaZCsdhIWECabpZgoiWr0','like','220815C0ZYC8P6W0','220815AX875GBC94','article','oDwsO5HQKpQA8hMWfVllfwPRuz7w',1,'2022-08-15 08:51:50',NULL),('220815G6B2SX26A8','oDwsO5DChzIXeC7VpPMWS8Z6VdlM','like','220815G6B2KMA800','220813HK99YCGSRP','comment','oDwsO5FDozoraPzxqwIo9kx0RBxY',1,'2022-08-15 13:20:15',NULL),('220815G6CAXMWTF8','oDwsO5DChzIXeC7VpPMWS8Z6VdlM','like','220815G6CASF4Z2W','220813HFKFFYYTMW','article','oDwsO5DzaZCsdhIWECabpZgoiWr0',1,'2022-08-15 13:20:24',NULL),('220815HW9WCSG6CH','oDwsO5DChzIXeC7VpPMWS8Z6VdlM','comment','220815HW9W8G3GHH','220814AY5C54KP94','comment','oDwsO5KKi7LvApN5bAErRN-tS6ew',1,'2022-08-15 15:38:14',NULL),('220816GZW808A9YW','a6pfQUcduN+Rd/TYaLfHOA==','like','220816GZW7X06YK4','220816GYRT0C0S5P','article','4VgnG15UOdoYzmfEPUwI5g==',1,'2022-08-16 14:24:43',NULL),('220816GZZ1BTCPX4','a6pfQUcduN+Rd/TYaLfHOA==','comment','220816GZZ1A72SNC','220816GYRT0C0S5P','article','4VgnG15UOdoYzmfEPUwI5g==',1,'2022-08-16 14:25:01',NULL),('220816H07THZWWDP','4VgnG15UOdoYzmfEPUwI5g==','comment','220816H07TF8T3TC','220816GZZ1A72SNC','comment','a6pfQUcduN+Rd/TYaLfHOA==',1,'2022-08-16 14:25:58',NULL),('220816H0F69X9CSW','a6pfQUcduN+Rd/TYaLfHOA==','comment','220816H0F672W568','220816GZZ1A72SNC','comment','4VgnG15UOdoYzmfEPUwI5g==',1,'2022-08-16 14:26:39',NULL),('220816H0MK9ZK2A8','4VgnG15UOdoYzmfEPUwI5g==','comment','220816H0MK7BYWM8','220816GZZ1A72SNC','comment','a6pfQUcduN+Rd/TYaLfHOA==',1,'2022-08-16 14:27:07',NULL),('220816H291DKBBMW','4VgnG15UOdoYzmfEPUwI5g==','comment','220816H291ANFK40','220816GZZ1A72SNC','comment','a6pfQUcduN+Rd/TYaLfHOA==',1,'2022-08-16 14:32:06',NULL),('220816H3CXZN29KP','4VgnG15UOdoYzmfEPUwI5g==','like','220816H3CXX00HZC','220816H32C36XSY8','article','a6pfQUcduN+Rd/TYaLfHOA==',0,'2022-08-16 14:35:31',NULL),('220816H3MHFCS4BC','4VgnG15UOdoYzmfEPUwI5g==','comment','220816H3MHCWC65P','220816H32C36XSY8','article','a6pfQUcduN+Rd/TYaLfHOA==',0,'2022-08-16 14:36:07',NULL),('220816HSYK1GR968','dVesS/yXVg3gZLBNDxs6BQ==','like','220816HSYHYB1CSW','220816H32C36XSY8','article','a6pfQUcduN+Rd/TYaLfHOA==',0,'2022-08-16 15:34:02',NULL),('220816HT0WP80TF8','dVesS/yXVg3gZLBNDxs6BQ==','comment','220816HT0WM2K6K4','220816H32C36XSY8','article','a6pfQUcduN+Rd/TYaLfHOA==',0,'2022-08-16 15:34:16',NULL),('220817042H08D9GC','22081702KBZTN2FW','like','220817042GXF01YW','22081703CYY6WM80','article','22081703A4PM6NC0',1,'2022-08-16 16:12:17',NULL),('220817043F8XDFCH','22081702KBZTN2FW','comment','220817043F75P18H','22081703CYY6WM80','article','22081703A4PM6NC0',1,'2022-08-16 16:12:23',NULL),('2208170835DX3354','22081703A4PM6NC0','comment','2208170835BT3168','22081707MXPX0T54','article','22081705RF35XT7C',1,'2022-08-16 16:24:22',NULL),('220817083HN53SRP','22081703A4PM6NC0','like','220817083HFC204H','22081707MXPX0T54','article','22081705RF35XT7C',1,'2022-08-16 16:24:24',NULL),('2208170HNKH446W0','2208170FZKRT6DWH','like','2208170HNKF5GNTC','2208170FW58Y5TXP','article','2208170CNA69W1KP',0,'2022-08-16 16:50:09',NULL),('22081714ZHNG4CBC','7557AC4BFC97560DE064B04D0F1B3A05','like','22081714ZHHW2NR4','22081714M3PH9400','article','E158271B5E5439DA18CE67C43D4C08E6',1,'2022-08-16 17:39:02',NULL),('22081715012CWB2W','7557AC4BFC97560DE064B04D0F1B3A05','comment','22081715010AW940','22081714M3PH9400','article','E158271B5E5439DA18CE67C43D4C08E6',1,'2022-08-16 17:39:05',NULL),('22081792ZP41HZ2W','E158271B5E5439DA18CE67C43D4C08E6','comment','22081792ZP1DYRAW','2208176KSFH52XYW','article','6BAA5F41471DB8DF9177F4D868B7C738',1,'2022-08-17 04:45:36',NULL),('220817BCWZXX4S5P','EA536DDADA4931D7E659109AF6A88A2A','like','220817BCWZTYH754','220817BBMKBH204H','article','7557AC4BFC97560DE064B04D0F1B3A05',1,'2022-08-17 08:03:29',NULL),('220817BD49857Z0H','462256A48FE823E17C35C25CF3D0F796','like','220817BD495KKR8H','22081714M3PH9400','article','E158271B5E5439DA18CE67C43D4C08E6',1,'2022-08-17 08:04:16',NULL),('220817BDFMW6DA5P','E158271B5E5439DA18CE67C43D4C08E6','like','220817BDFMS4D86W','220817BBMKBH204H','article','7557AC4BFC97560DE064B04D0F1B3A05',1,'2022-08-17 08:05:23',NULL),('220817BF0B9MKY5P','EA536DDADA4931D7E659109AF6A88A2A','like','220817BF0B7HKW6W','220817BDZ8559WH0','article','0EBD21F315F8DE78B14DFE07365EB529',1,'2022-08-17 08:06:51',NULL),('220817BSMSWNMSNC','EA536DDADA4931D7E659109AF6A88A2A','comment','220817BSMSSWDSK4','220817BNC71Z24BC','article','B6D297D920606D5F78AB2251406670DC',1,'2022-08-17 08:32:51',NULL),('220817C0D6WYD3MW','0BD5685FDAC552B67BF559EABDA447D9','like','220817C0D6SKKZTC','22081714M3PH9400','article','E158271B5E5439DA18CE67C43D4C08E6',1,'2022-08-17 08:50:16',NULL),('220817C0K8NMRYFW','0BD5685FDAC552B67BF559EABDA447D9','comment','220817C0K8M9725P','22081714M3PH9400','article','E158271B5E5439DA18CE67C43D4C08E6',1,'2022-08-17 08:50:42',NULL),('220817C0TXPRW094','E158271B5E5439DA18CE67C43D4C08E6','comment','220817C0TXH45PM8','220817C0K8M9725P','comment','0BD5685FDAC552B67BF559EABDA447D9',1,'2022-08-17 08:51:24',NULL),('220817C1R96Y3FK4','E158271B5E5439DA18CE67C43D4C08E6','comment','220817C1R95D539P','220817BYX8Z8CPH0','article','E0EB0920B26077190F224C5B729C1995',0,'2022-08-17 08:54:08',NULL),('220817C2B36GRGR4','E158271B5E5439DA18CE67C43D4C08E6','comment','220817C2B34A9YW0','220817BNC71Z24BC','article','B6D297D920606D5F78AB2251406670DC',1,'2022-08-17 08:56:02',NULL),('220817C4F0FS1WX4','EA536DDADA4931D7E659109AF6A88A2A','comment','220817C4F0D93DKP','220817C3Z8H2F4BC','article','28B21AC61A51DE81DB7048687B163A64',1,'2022-08-17 09:02:21',NULL),('220817C4F9GFABXP','EA536DDADA4931D7E659109AF6A88A2A','like','220817C4F9CT8N7C','220817C3Z8H2F4BC','article','28B21AC61A51DE81DB7048687B163A64',1,'2022-08-17 09:02:23',NULL),('220817C4FGRKZTC0','EA536DDADA4931D7E659109AF6A88A2A','like','220817C4FGN29KP0','220817C07MWDC4H0','article','0BD5685FDAC552B67BF559EABDA447D9',0,'2022-08-17 09:02:25',NULL),('220817C54AK0YXKP','E158271B5E5439DA18CE67C43D4C08E6','comment','220817C54AGNC18H','220817C3Z8H2F4BC','article','28B21AC61A51DE81DB7048687B163A64',1,'2022-08-17 09:04:19',NULL),('220817C57AXYR0BC','EA536DDADA4931D7E659109AF6A88A2A','like','220817C57AW04DAW','220817C4M5DZC18H','article','7889771600DB3F638A8D5EC82228B327',1,'2022-08-17 09:04:39',NULL),('220817C58HMY3FK4','EA536DDADA4931D7E659109AF6A88A2A','comment','220817C58HHAD8X4','220817C4M5DZC18H','article','7889771600DB3F638A8D5EC82228B327',1,'2022-08-17 09:04:46',NULL),('220817C6G7DKPPX4','7889771600DB3F638A8D5EC82228B327','comment','220817C6G7BXZ7R4','220817C58HHAD8X4','comment','EA536DDADA4931D7E659109AF6A88A2A',1,'2022-08-17 09:08:30',NULL),('220817CBGZWPTCZC','B3E38B58C46AD7F380D877317AC97D01','like','220817CBGZSGBW28','22081714M3PH9400','article','E158271B5E5439DA18CE67C43D4C08E6',1,'2022-08-17 09:23:35',NULL),('220817CMX5ANDW6W','462256A48FE823E17C35C25CF3D0F796','like','220817CMX57M5FRP','220817C3Z8H2F4BC','article','28B21AC61A51DE81DB7048687B163A64',1,'2022-08-17 09:45:35',NULL),('220817CMYBD1HCPH','462256A48FE823E17C35C25CF3D0F796','comment','220817CMYBBD6FFW','220817C3Z8H2F4BC','article','28B21AC61A51DE81DB7048687B163A64',1,'2022-08-17 09:45:43',NULL),('220817CP0SC0GW28','E158271B5E5439DA18CE67C43D4C08E6','comment','220817CP0SA1Z91P','2208176KSFH52XYW','article','6BAA5F41471DB8DF9177F4D868B7C738',1,'2022-08-17 09:48:59',NULL),('220817DWAKCYGPSW','EA536DDADA4931D7E659109AF6A88A2A','like','220817DWAKAAXG2W','220817C9AFDRB540','article','B3E38B58C46AD7F380D877317AC97D01',1,'2022-08-17 11:26:07',NULL),('220817DWB0302R1P','EA536DDADA4931D7E659109AF6A88A2A','like','220817DWB014XPZC','220817CBZFDBK7HH','article','B3E38B58C46AD7F380D877317AC97D01',1,'2022-08-17 11:26:09',NULL),('220817DYANZ70K8H','6BAA5F41471DB8DF9177F4D868B7C738','comment','220817DYANXBTK68','220817CP0SA1Z91P','comment','E158271B5E5439DA18CE67C43D4C08E6',1,'2022-08-17 11:32:07',NULL),('220817DYDYK68Y3C','B6D297D920606D5F78AB2251406670DC','like','220817DYDYGB3Y14','220817CGM14CH7TC','article','7889771600DB3F638A8D5EC82228B327',1,'2022-08-17 11:32:28',NULL),('220817DYFRW4R11P','B6D297D920606D5F78AB2251406670DC','like','220817DYFRRK2T9P','220817C4M5DZC18H','article','7889771600DB3F638A8D5EC82228B327',1,'2022-08-17 11:32:34',NULL),('220817DYH7DH7NF8','B6D297D920606D5F78AB2251406670DC','comment','220817DYH7AFZA14','220817C58HHAD8X4','comment','EA536DDADA4931D7E659109AF6A88A2A',1,'2022-08-17 11:32:43',NULL),('220817FCZA2K4ACH','EA536DDADA4931D7E659109AF6A88A2A','like','220817FCZ9ZY2KS8','220817CGM14CH7TC','article','7889771600DB3F638A8D5EC82228B327',1,'2022-08-17 12:15:57',NULL),('220817FD2F111X68','EA536DDADA4931D7E659109AF6A88A2A','like','220817FD2DZ5WX40','220817FCHWCWM5AW','article','B3E38B58C46AD7F380D877317AC97D01',1,'2022-08-17 12:16:17',NULL),('220817FDFPR135S8','EA536DDADA4931D7E659109AF6A88A2A','like','220817FDFPN5Y5P0','220817FCHWCWM5AW','article','B3E38B58C46AD7F380D877317AC97D01',1,'2022-08-17 12:17:36',NULL),('220817FMSGM0XMA8','EA536DDADA4931D7E659109AF6A88A2A','comment','220817FMSGGTF1D4','220817FCHWCWM5AW','article','B3E38B58C46AD7F380D877317AC97D01',1,'2022-08-17 12:33:27',NULL),('220817FNNY6YXP94','BA598B0A17E7F804DF9C760D4C921132','comment','220817FNNY5KAW00','220817FCHWCWM5AW','article','B3E38B58C46AD7F380D877317AC97D01',1,'2022-08-17 12:36:10',NULL),('220817G1XX62MPBC','0C0FDA9B8EA936EE3874E98D22505872','like','220817G1XX3G0FNC','2208176KSFH52XYW','article','6BAA5F41471DB8DF9177F4D868B7C738',1,'2022-08-17 13:06:50',NULL),('220817G221ZN29KP','B981CFAD8239731FC14A47C6E7A15C77','like','220817G221XTX9GC','22081714M3PH9400','article','E158271B5E5439DA18CE67C43D4C08E6',1,'2022-08-17 13:07:17',NULL),('220817G6RXDYYK40','7557AC4BFC97560DE064B04D0F1B3A05','comment','220817G6RXCF05WH','220817G0F47WTGHH','article','B6D297D920606D5F78AB2251406670DC',0,'2022-08-17 13:21:25',NULL),('220817G74RKHZMFW','B3E38B58C46AD7F380D877317AC97D01','comment','220817G74RFXXXWH','220817FNNY5KAW00','comment','BA598B0A17E7F804DF9C760D4C921132',0,'2022-08-17 13:22:35',NULL),('220817GAYMC659GC','6BAA5F41471DB8DF9177F4D868B7C738','like','220817GAYMA457HH','220817GABGW247F8','article','EA536DDADA4931D7E659109AF6A88A2A',1,'2022-08-17 13:33:56',NULL),('220817GD8WGZR7XP','1B3D4B79BE41E68F0AB4BF6B5D41A8DA','like','220817GD8WDC325P','220817GABGW247F8','article','EA536DDADA4931D7E659109AF6A88A2A',1,'2022-08-17 13:41:02',NULL),('220817GGH0HWMAK4','A626164C4DA2862C1F0414B1AC514CC9','like','220817GGH0FSM8M8','220817GABGW247F8','article','EA536DDADA4931D7E659109AF6A88A2A',1,'2022-08-17 13:47:48',NULL),('220817GGPY3HDAW0','A626164C4DA2862C1F0414B1AC514CC9','comment','220817GGPY203CM8','220817GABGW247F8','article','EA536DDADA4931D7E659109AF6A88A2A',1,'2022-08-17 13:48:20',NULL),('220817GKP0377FK4','EA536DDADA4931D7E659109AF6A88A2A','comment','220817GKP005Z540','220817GGPY203CM8','comment','A626164C4DA2862C1F0414B1AC514CC9',0,'2022-08-17 13:54:14',NULL),('220817GMNBNAK028','28B21AC61A51DE81DB7048687B163A64','like','220817GMNBKMTFY8','220817GABGW247F8','article','EA536DDADA4931D7E659109AF6A88A2A',1,'2022-08-17 13:57:11',NULL),('220817GNT5YXZ6CH','EA536DDADA4931D7E659109AF6A88A2A','like','220817GNT5WK42K4','220817GND4GTR968','article','7557AC4BFC97560DE064B04D0F1B3A05',1,'2022-08-17 14:00:35',NULL),('220817GNX9F74DP0','EA536DDADA4931D7E659109AF6A88A2A','comment','220817GNX9C1PWSW','220817GND4GTR968','article','7557AC4BFC97560DE064B04D0F1B3A05',1,'2022-08-17 14:00:49',NULL),('220817H5AYHTD4M8','462256A48FE823E17C35C25CF3D0F796','like','220817H5AYG3NNF8','220817GABGW247F8','article','EA536DDADA4931D7E659109AF6A88A2A',1,'2022-08-17 14:41:18',NULL),('2208185A94W2XP94','E158271B5E5439DA18CE67C43D4C08E6','comment','2208185A94S0XMA8','2208183P2DWT111P','article','C1D3928A8F12AC9979FC25718FF7B049',0,'2022-08-17 23:31:22',NULL),('2208188AC8MS9G2W','EA536DDADA4931D7E659109AF6A88A2A','like','2208188AC8DXW5GC','2208185A94S0XMA8','comment','E158271B5E5439DA18CE67C43D4C08E6',1,'2022-08-18 03:43:54',NULL);
/*!40000 ALTER TABLE `notify_remind` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `official_account`
--

DROP TABLE IF EXISTS `official_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `official_account` (
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='关联的公众号';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `official_account`
--

LOCK TABLES `official_account` WRITE;
/*!40000 ALTER TABLE `official_account` DISABLE KEYS */;
INSERT INTO `official_account` VALUES ('公众号-DiversityUNNC'),('公众号-FashionSociety'),('公众号-gh_d42073931e2b'),('公众号-HealthyUunnc'),('公众号-HSSAELSA'),('公众号-HSSAESA'),('公众号-HSSAICV PDD'),('公众号-Jumbox Tech'),('公众号-Jumbox 产品'),('公众号-SSC'),('公众号-TK199'),('公众号-UNNC MC中文角'),('公众号-UNNCAIS'),('公众号-UNNCBSA'),('公众号-UNNCKoreansociety'),('公众号-UNNC书友会'),('公众号-UNNC口才与演讲'),('公众号-unnc开拓者'),('公众号-UNNC日语交流社'),('公众号-UNNC爱中华'),('公众号-UNNC音乐协会'),('公众号-U漫社'),('公众号-宁波诺丁汉大学校友会'),('公众号-宁诺IMA学术发展平台'),('公众号-柠诺表白墙'),('公众号-职来职往 宁诺职协'),('公众号-艾话剧社idrama'),('公众号-诺丁汉孵化园');
/*!40000 ALTER TABLE `official_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organization`
--

DROP TABLE IF EXISTS `organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organization` (
  `id` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL COMMENT '组织名称',
  `intro` varchar(45) DEFAULT NULL COMMENT '组织简介',
  `division` text NOT NULL COMMENT '部门组成',
  `activity_intro` text NOT NULL COMMENT '活动介绍',
  `logo_path` varchar(255) NOT NULL COMMENT '组织logo地址',
  `official_account_link` varchar(255) DEFAULT NULL COMMENT '组织公众号或推文链接',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '0:unreadable/1:readable/2:checking',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organization`
--

LOCK TABLES `organization` WRITE;
/*!40000 ALTER TABLE `organization` DISABLE KEYS */;
INSERT INTO `organization` VALUES ('0','理工学生联合会','100+人','AO，IT','科技博览会xjp','/test10304/vote/200526FAX6NSBT2W/0.jpg','https://mp.weixin.qq.com/s/dk6jid0M4dqEIfaNua0xFA','2020-09-18 22:29:31',1),('1','青年志愿者协会','100+人','春风','暑期社会实践活动','/test10304/vote/200526FAX6NSBT2W/0.jpg','https://mp.weixin.qq.com/s/dk6jid0M4dqEIfdsua0xFA','2020-09-18 22:29:31',1),('220804G991GX1P00','叶博源的后宫','叶博源的后宫3000佳丽，每一个都倾国倾城、貌美如花。','他们来自不同国家，不同名族','哥们编不下去了','/nqprod/img/220804124304763125760.jpg',NULL,'2022-08-04 21:29:02',1),('220804GD7MKFTRD4','邵yf的后宫','syf还能有后宫？','笑死人了','别想了','nqprod/img/220804124304763125760.jpg',NULL,'2022-08-04 21:40:54',1),('220814BBF15AXN0H','，。。。','。。。','。。。。','。。。。。','nqdev/img/220814120703808438272.heic',NULL,'2022-08-14 15:59:18',1),('220814BKZ3RPMD68','调酒社','仅限单身人是','难忘经典 新时代调酒','好酒莫贪杯，微醺胜买醉','nqprod/img/220814123143637172224.jpg',NULL,'2022-08-14 16:19:03',1);
/*!40000 ALTER TABLE `organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organization_image`
--

DROP TABLE IF EXISTS `organization_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organization_image` (
  `id` varchar(45) NOT NULL,
  `organization_id` varchar(45) NOT NULL,
  `image_path` varchar(255) NOT NULL,
  `image_order` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '0:unreadable/1:readable/2:checking',
  PRIMARY KEY (`id`),
  KEY `organization_image_idx` (`organization_id`),
  CONSTRAINT `organization_image_ibfk_1` FOREIGN KEY (`organization_id`) REFERENCES `organization` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organization_image`
--

LOCK TABLES `organization_image` WRITE;
/*!40000 ALTER TABLE `organization_image` DISABLE KEYS */;
INSERT INTO `organization_image` VALUES ('0','0','/test10304/vote/200526FAX6NSBT2W/0.jpg',0,1),('1','0','/test10999/vote/200526FAX6NSBT2W/0.jpg',1,1),('220804GBWZNPZ9AW','220804G991GX1P00','nqdev/img/220804163168282214400.jpg',1,1),('220814BMT64YZ3F8','220814BKZ3RPMD68','nqprod/img/220814123476186759168.jpg',1,1),('220814BPCMXFRX68','220814BKZ3RPMD68','nqprod/img/220814124088322359296.jpg',2,1);
/*!40000 ALTER TABLE `organization_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `search_record`
--

DROP TABLE IF EXISTS `search_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `search_record` (
  `id` varchar(45) NOT NULL,
  `content` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `search_record`
--

LOCK TABLES `search_record` WRITE;
/*!40000 ALTER TABLE `search_record` DISABLE KEYS */;
INSERT INTO `search_record` VALUES ('220817G1H66ZB4DP','哈');
/*!40000 ALTER TABLE `search_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `source_map`
--

DROP TABLE IF EXISTS `source_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `source_map` (
  `source` varchar(45) NOT NULL COMMENT '来源',
  `author_id` varchar(128) NOT NULL COMMENT '分配的作者，多个用“，”隔开',
  PRIMARY KEY (`source`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='根据来源分配作者的map表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `source_map`
--

LOCK TABLES `source_map` WRITE;
/*!40000 ALTER TABLE `source_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `source_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tags`
--

DROP TABLE IF EXISTS `tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tags` (
  `id` varchar(45) NOT NULL,
  `tag` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tags`
--

LOCK TABLES `tags` WRITE;
/*!40000 ALTER TABLE `tags` DISABLE KEYS */;
INSERT INTO `tags` VALUES ('1','单词打卡'),('10','填填问卷'),('11','申研'),('12','中介'),('13','内推'),('14','影视'),('15','文书'),('16','图书馆订房'),('17','健身'),('18','学术网站'),('19','生活咨询'),('2','吃喝玩乐'),('3','面试经验'),('4','实习'),('5','职场前辈说'),('6','文书'),('7','种草'),('8','有空座吗'),('9','红墙摄影大赛');
/*!40000 ALTER TABLE `tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` varchar(45) CHARACTER SET utf8 NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  `nickname` varchar(45) NOT NULL,
  `signature` varchar(55) DEFAULT NULL COMMENT '个人简介',
  `create_date` datetime NOT NULL,
  `face_img` varchar(255) DEFAULT NULL,
  `face_img_thumb` varchar(255) DEFAULT NULL COMMENT '小头像',
  `follow_num` int(11) NOT NULL DEFAULT '0' COMMENT '关注数',
  `fans_num` int(11) NOT NULL DEFAULT '0' COMMENT '粉丝数',
  `gender` tinyint(4) DEFAULT NULL COMMENT '0 = female, 1 = male, 2 = others',
  `major` varchar(45) DEFAULT NULL,
  `graduation_year` int(5) DEFAULT NULL COMMENT 'Example: 2022',
  `degree` tinyint(4) DEFAULT NULL COMMENT '0 = high school, 1 = undergraduate, 2 = graduate',
  `receive_like_counts` int(11) DEFAULT '0',
  `cid` varchar(45) DEFAULT NULL COMMENT 'Client-id 设备id，用于消息推送',
  `reputation` int(11) DEFAULT '0',
  `latest_login` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('0BD5685FDAC552B67BF559EABDA447D9','biyrl18@nottingham.edu.cn','ChangeMe','July','不知道写什么','2022-08-17 08:45:46','nqprod/img/220817126808670339072.png','nqprod/img/220817126808670339072.png',1,0,0,'NUBS',2024,1,1,NULL,57,'2022-08-17 08:46:15'),('0C0FDA9B8EA936EE3874E98D22505872','smyhz1@nottingham.edu.cn','ChangeMe','微信用户',NULL,'2022-08-17 13:00:36','https://thirdwx.qlogo.cn/mmopen/vi_32/POgEwh4mIHO4nibH0KlMECNjjGxQUq24ZEaGT4poC6icRiccVGKSyXwibcPq4BWmiaIGuG1icwxaQX6grC9VemZoJ8rg/132',NULL,0,1,NULL,NULL,NULL,NULL,0,NULL,12,'2022-08-17 13:06:57'),('0EBD21F315F8DE78B14DFE07365EB529',NULL,'ChangeMe','微信用户',NULL,'2022-08-17 08:03:05','https://thirdwx.qlogo.cn/mmopen/vi_32/POgEwh4mIHO4nibH0KlMECNjjGxQUq24ZEaGT4poC6icRiccVGKSyXwibcPq4BWmiaIGuG1icwxaQX6grC9VemZoJ8rg/132',NULL,0,1,NULL,NULL,NULL,NULL,1,NULL,20,'2022-08-17 08:03:07'),('1207A251D249E08C896F68FC1A1D5AC8',NULL,'ChangeMe','微信用户',NULL,'2022-08-17 08:13:38','https://thirdwx.qlogo.cn/mmopen/vi_32/POgEwh4mIHO4nibH0KlMECNjjGxQUq24ZEaGT4poC6icRiccVGKSyXwibcPq4BWmiaIGuG1icwxaQX6grC9VemZoJ8rg/132',NULL,1,0,NULL,NULL,NULL,NULL,0,NULL,0,'2022-08-17 08:36:22'),('1B3D4B79BE41E68F0AB4BF6B5D41A8DA',NULL,'ChangeMe','微信用户',NULL,'2022-08-17 13:37:40','https://thirdwx.qlogo.cn/mmopen/vi_32/POgEwh4mIHO4nibH0KlMECNjjGxQUq24ZEaGT4poC6icRiccVGKSyXwibcPq4BWmiaIGuG1icwxaQX6grC9VemZoJ8rg/132',NULL,1,0,NULL,NULL,NULL,NULL,0,NULL,0,'2022-08-17 13:41:42'),('28B21AC61A51DE81DB7048687B163A64',NULL,'ChangeMe','微信用户',NULL,'2022-08-17 09:00:07','https://thirdwx.qlogo.cn/mmopen/vi_32/POgEwh4mIHO4nibH0KlMECNjjGxQUq24ZEaGT4poC6icRiccVGKSyXwibcPq4BWmiaIGuG1icwxaQX6grC9VemZoJ8rg/132',NULL,0,1,1,'',2024,1,2,NULL,82,'2022-08-17 13:56:46'),('3B3CF40992671452E9D54B86FF40A2BA',NULL,'ChangeMe','微信用户',NULL,'2022-08-17 08:20:40','https://thirdwx.qlogo.cn/mmopen/vi_32/POgEwh4mIHO4nibH0KlMECNjjGxQUq24ZEaGT4poC6icRiccVGKSyXwibcPq4BWmiaIGuG1icwxaQX6grC9VemZoJ8rg/132',NULL,0,0,NULL,NULL,NULL,NULL,0,NULL,0,'2022-08-17 12:15:32'),('462256A48FE823E17C35C25CF3D0F796','1193874@wku.edu.cn','ChangeMe','微信用户',NULL,'2022-08-17 08:03:10','https://thirdwx.qlogo.cn/mmopen/vi_32/POgEwh4mIHO4nibH0KlMECNjjGxQUq24ZEaGT4poC6icRiccVGKSyXwibcPq4BWmiaIGuG1icwxaQX6grC9VemZoJ8rg/132',NULL,2,0,NULL,NULL,NULL,NULL,0,NULL,53,'2022-08-18 02:18:16'),('5C0EF3547D80D3CCC08B2CC1FCF07BC2','scyfg1@nottingham.edu.cn','ChangeMe','jerry',NULL,'2022-08-17 13:02:18','https://thirdwx.qlogo.cn/mmopen/vi_32/POgEwh4mIHO4nibH0KlMECNjjGxQUq24ZEaGT4poC6icRiccVGKSyXwibcPq4BWmiaIGuG1icwxaQX6grC9VemZoJ8rg/132',NULL,0,0,1,'CS',2023,1,0,NULL,0,'2022-08-17 13:06:56'),('6BAA5F41471DB8DF9177F4D868B7C738','sayyx3@nottingham.edu.cn','ChangeMe','谢岳宁',NULL,'2022-08-17 01:15:44','nqprod/img/22081796743674871808.png','nqprod/img/22081796743674871808.png',1,0,1,'CS',2024,1,3,NULL,92,'2022-08-18 04:15:07'),('7557AC4BFC97560DE064B04D0F1B3A05','scyys7@nottingham.edu.cn','ChangeMe','灰灰',NULL,'2022-08-16 17:24:37','nqprod/img/220817120817696374784.png','nqprod/img/220817120817696374784.png',1,1,1,'CS',2023,1,4,NULL,99,'2022-08-18 03:52:36'),('7889771600DB3F638A8D5EC82228B327','hmyww1@nottingham.edu.cn','ChangeMe','蓝紫',NULL,'2022-08-17 08:56:40','nqprod/img/220817133486428028928.png','nqprod/img/220817133486428028928.png',0,2,0,'ECON',2024,1,6,NULL,140,'2022-08-17 13:20:14'),('A626164C4DA2862C1F0414B1AC514CC9',NULL,'ChangeMe','微信用户',NULL,'2022-08-17 13:35:00','https://thirdwx.qlogo.cn/mmopen/vi_32/POgEwh4mIHO4nibH0KlMECNjjGxQUq24ZEaGT4poC6icRiccVGKSyXwibcPq4BWmiaIGuG1icwxaQX6grC9VemZoJ8rg/132',NULL,0,0,2,'CS',2024,1,0,NULL,5,'2022-08-17 13:47:43'),('B3E38B58C46AD7F380D877317AC97D01',NULL,'ChangeMe','ALK官方',NULL,'2022-08-17 09:15:20','nqprod/img/220817169624068947968.png','nqprod/img/220817169624068947968.png',1,1,2,'',2026,1,3,NULL,72,'2022-08-17 14:26:17'),('B6D297D920606D5F78AB2251406670DC','scyfz2@nottingham.edu.cn','ChangeMe','摸鱼中','么么么么么么么么摸鱼','2022-08-17 04:53:56','nqprod/img/220817123430007472128.png','nqprod/img/220817123430007472128.png',1,1,1,'CS',2024,1,0,NULL,175,'2022-08-17 12:37:15'),('B981CFAD8239731FC14A47C6E7A15C77',NULL,'ChangeMe','微信用户',NULL,'2022-08-17 13:05:16','https://thirdwx.qlogo.cn/mmopen/vi_32/POgEwh4mIHO4nibH0KlMECNjjGxQUq24ZEaGT4poC6icRiccVGKSyXwibcPq4BWmiaIGuG1icwxaQX6grC9VemZoJ8rg/132',NULL,0,0,NULL,NULL,NULL,NULL,0,NULL,0,'2022-08-17 13:09:39'),('BA598B0A17E7F804DF9C760D4C921132',NULL,'ChangeMe','广告请私聊','广告请私聊','2022-08-17 08:46:51','nqprod/img/220817155425563475968.png','nqprod/img/220817155425563475968.png',0,0,1,'',2023,1,0,NULL,5,'2022-08-17 12:34:27'),('BB160A659B05B9EC6F6B2E50D0B368CA',NULL,'ChangeMe','超级大可爱',NULL,'2022-08-16 17:56:47','https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKpZyrfkibXUuKr8ecJDls0Nib2k3fch9HXHj1xst50y6EH9nghSKPbcQyL1Sia9dFGdPeA4QT4vgOqg/132',NULL,0,0,NULL,NULL,NULL,NULL,0,NULL,0,'2022-08-16 17:56:51'),('C1D3928A8F12AC9979FC25718FF7B049','ssysw7@nottingham.edu.cn','ChangeMe','hzsz',NULL,'2022-08-17 21:06:57','https://thirdwx.qlogo.cn/mmopen/vi_32/POgEwh4mIHO4nibH0KlMECNjjGxQUq24ZEaGT4poC6icRiccVGKSyXwibcPq4BWmiaIGuG1icwxaQX6grC9VemZoJ8rg/132',NULL,0,0,1,'',2025,1,0,NULL,14,'2022-08-17 22:51:16'),('E0EB0920B26077190F224C5B729C1995',NULL,'ChangeMe','微信用户',NULL,'2022-08-17 08:45:07','https://thirdwx.qlogo.cn/mmopen/vi_32/POgEwh4mIHO4nibH0KlMECNjjGxQUq24ZEaGT4poC6icRiccVGKSyXwibcPq4BWmiaIGuG1icwxaQX6grC9VemZoJ8rg/132',NULL,0,0,NULL,NULL,NULL,NULL,0,NULL,53,'2022-08-17 08:45:16'),('E158271B5E5439DA18CE67C43D4C08E6',NULL,'ChangeMe','Jumbox官方✨','我自风情万种，与世无争','2022-08-16 17:24:54','nqprod/img/22081712366764834816.png','nqprod/img/22081712366764834816.png',0,6,1,'CS',2022,1,6,NULL,188,'2022-08-18 03:53:52'),('EA536DDADA4931D7E659109AF6A88A2A','heyfj1@nottingham.edu.cn','ChangeMe','HR小金','人资管理师，三段大厂HR经历，随缘分享','2022-08-17 07:43:22','nqprod/img/220817124214363291648.png','nqprod/img/220817124214363291648.png',7,2,1,'NUBS',2023,1,9,NULL,121,'2022-08-18 03:43:42'),('EAAF5B4FD4E17A85242AF549B5C59244','scyxz3@nottingham.edu.cn','ChangeMe','微信用户',NULL,'2022-08-17 13:05:04','https://thirdwx.qlogo.cn/mmopen/vi_32/POgEwh4mIHO4nibH0KlMECNjjGxQUq24ZEaGT4poC6icRiccVGKSyXwibcPq4BWmiaIGuG1icwxaQX6grC9VemZoJ8rg/132',NULL,0,0,NULL,NULL,NULL,NULL,0,NULL,0,'2022-08-17 13:06:29');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_collect`
--

DROP TABLE IF EXISTS `user_collect`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_collect` (
  `id` varchar(45) NOT NULL,
  `user_id` varchar(45) NOT NULL,
  `target_type` varchar(45) NOT NULL,
  `target_id` varchar(45) NOT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_collect`
--

LOCK TABLES `user_collect` WRITE;
/*!40000 ALTER TABLE `user_collect` DISABLE KEYS */;
INSERT INTO `user_collect` VALUES ('220817151ZGNRGR4','7557AC4BFC97560DE064B04D0F1B3A05','article','22081714M3PH9400','2022-08-16 17:39:18'),('220817C4W22PR3MW','EA536DDADA4931D7E659109AF6A88A2A','article','220817BNC71Z24BC','2022-08-17 09:03:26'),('220817C6A3CR3354','EA536DDADA4931D7E659109AF6A88A2A','article','220817C3Z8H2F4BC','2022-08-17 09:07:56');
/*!40000 ALTER TABLE `user_collect` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_comment`
--

DROP TABLE IF EXISTS `user_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_comment` (
  `id` varchar(45) CHARACTER SET utf8 NOT NULL,
  `from_user_id` varchar(45) CHARACTER SET utf8 NOT NULL COMMENT '评论人',
  `to_user_id` varchar(45) CHARACTER SET utf8 NOT NULL,
  `target_type` varchar(45) CHARACTER SET utf8 NOT NULL COMMENT '评论对象类型，如评论，文章，投票',
  `target_id` varchar(45) CHARACTER SET utf8 NOT NULL COMMENT '评论对象Id',
  `comment` varchar(255) NOT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `like_num` int(11) NOT NULL DEFAULT '0',
  `dislike_num` int(11) NOT NULL DEFAULT '0',
  `comment_num` int(11) NOT NULL DEFAULT '0',
  `reported_num` int(11) DEFAULT '0',
  `under_comment_id` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `sign_flag` int(11) DEFAULT '0' COMMENT '评论消息是否被签收 0: 未签收 1：签收',
  `status` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_comment`
--

LOCK TABLES `user_comment` WRITE;
/*!40000 ALTER TABLE `user_comment` DISABLE KEYS */;
INSERT INTO `user_comment` VALUES ('22081715010AW940','7557AC4BFC97560DE064B04D0F1B3A05','E158271B5E5439DA18CE67C43D4C08E6','article','22081714M3PH9400','好！','2022-08-16 17:39:05',0,0,0,0,NULL,0,1),('22081792ZP1DYRAW','E158271B5E5439DA18CE67C43D4C08E6','6BAA5F41471DB8DF9177F4D868B7C738','article','2208176KSFH52XYW','谢谢这位同学的支持','2022-08-17 04:45:36',0,0,0,0,NULL,0,1),('220817BSMSSWDSK4','EA536DDADA4931D7E659109AF6A88A2A','B6D297D920606D5F78AB2251406670DC','article','220817BNC71Z24BC','好','2022-08-17 08:32:51',0,0,0,0,NULL,0,1),('220817BT31BYM8M8','B6D297D920606D5F78AB2251406670DC','B6D297D920606D5F78AB2251406670DC','article','220817BNC71Z24BC','要的私聊嗷','2022-08-17 08:34:09',0,0,0,0,NULL,0,1),('220817C0K8M9725P','0BD5685FDAC552B67BF559EABDA447D9','E158271B5E5439DA18CE67C43D4C08E6','article','22081714M3PH9400','尊?? ?','2022-08-17 08:50:42',0,0,1,0,NULL,0,1),('220817C0TXH45PM8','E158271B5E5439DA18CE67C43D4C08E6','0BD5685FDAC552B67BF559EABDA447D9','article','22081714M3PH9400','谢谢这位同学的支持喔','2022-08-17 08:51:24',0,0,0,0,'220817C0K8M9725P',0,1),('220817C1R95D539P','E158271B5E5439DA18CE67C43D4C08E6','E0EB0920B26077190F224C5B729C1995','article','220817BYX8Z8CPH0','发啥呢，傻逼','2022-08-17 08:54:08',0,0,0,0,NULL,0,1),('220817C2B34A9YW0','E158271B5E5439DA18CE67C43D4C08E6','B6D297D920606D5F78AB2251406670DC','article','220817BNC71Z24BC','请不要打广告喔','2022-08-17 08:56:02',0,0,0,0,NULL,0,1),('220817C4F0D93DKP','EA536DDADA4931D7E659109AF6A88A2A','28B21AC61A51DE81DB7048687B163A64','article','220817C3Z8H2F4BC','你头像呢？','2022-08-17 09:02:21',0,0,0,0,NULL,0,1),('220817C54AGNC18H','E158271B5E5439DA18CE67C43D4C08E6','28B21AC61A51DE81DB7048687B163A64','article','220817C3Z8H2F4BC','欢迎刘同学','2022-08-17 09:04:19',0,0,0,0,NULL,0,1),('220817C58HHAD8X4','EA536DDADA4931D7E659109AF6A88A2A','7889771600DB3F638A8D5EC82228B327','article','220817C4M5DZC18H','你是谁啊','2022-08-17 09:04:46',0,0,2,0,NULL,0,1),('220817C6G7BXZ7R4','7889771600DB3F638A8D5EC82228B327','EA536DDADA4931D7E659109AF6A88A2A','article','220817C4M5DZC18H','哈哈哈\n','2022-08-17 09:08:30',0,0,0,0,'220817C58HHAD8X4',0,1),('220817CMYBBD6FFW','462256A48FE823E17C35C25CF3D0F796','28B21AC61A51DE81DB7048687B163A64','article','220817C3Z8H2F4BC','帅哥啊\n','2022-08-17 09:45:43',0,0,0,0,NULL,0,1),('220817CP0SA1Z91P','E158271B5E5439DA18CE67C43D4C08E6','6BAA5F41471DB8DF9177F4D868B7C738','article','2208176KSFH52XYW','打错字了嗷，宝贝','2022-08-17 09:48:59',0,0,1,0,NULL,0,1),('220817DYANXBTK68','6BAA5F41471DB8DF9177F4D868B7C738','E158271B5E5439DA18CE67C43D4C08E6','article','2208176KSFH52XYW','没事的亲亲','2022-08-17 11:32:07',0,0,0,0,'220817CP0SA1Z91P',0,1),('220817DYH7AFZA14','B6D297D920606D5F78AB2251406670DC','EA536DDADA4931D7E659109AF6A88A2A','article','220817C4M5DZC18H','这我同学','2022-08-17 11:32:43',0,0,0,0,'220817C58HHAD8X4',0,1),('220817FMSGGTF1D4','EA536DDADA4931D7E659109AF6A88A2A','B3E38B58C46AD7F380D877317AC97D01','article','220817FCHWCWM5AW','我不到啊','2022-08-17 12:33:27',0,0,0,0,NULL,0,1),('220817FNNY5KAW00','BA598B0A17E7F804DF9C760D4C921132','B3E38B58C46AD7F380D877317AC97D01','article','220817FCHWCWM5AW','需要打广告吗 请私聊','2022-08-17 12:36:10',0,0,1,0,NULL,0,1),('220817G0NYY51494','B6D297D920606D5F78AB2251406670DC','B6D297D920606D5F78AB2251406670DC','article','220817G0F47WTGHH','前端调整建议','2022-08-17 13:03:11',0,0,0,0,NULL,0,1),('220817G6RXCF05WH','7557AC4BFC97560DE064B04D0F1B3A05','B6D297D920606D5F78AB2251406670DC','article','220817G0F47WTGHH','展开说说？','2022-08-17 13:21:25',0,0,0,0,NULL,0,1),('220817G74RFXXXWH','B3E38B58C46AD7F380D877317AC97D01','BA598B0A17E7F804DF9C760D4C921132','article','220817FCHWCWM5AW','不要','2022-08-17 13:22:35',0,0,0,0,'220817FNNY5KAW00',0,1),('220817GGPY203CM8','A626164C4DA2862C1F0414B1AC514CC9','EA536DDADA4931D7E659109AF6A88A2A','article','220817GABGW247F8','金哥牛? 学到了学到了','2022-08-17 13:48:20',0,0,1,0,NULL,0,1),('220817GKP005Z540','EA536DDADA4931D7E659109AF6A88A2A','A626164C4DA2862C1F0414B1AC514CC9','article','220817GABGW247F8','太客气了','2022-08-17 13:54:14',0,0,0,0,'220817GGPY203CM8',0,1),('220817GNX9C1PWSW','EA536DDADA4931D7E659109AF6A88A2A','7557AC4BFC97560DE064B04D0F1B3A05','article','220817GND4GTR968','GRE的还是雅思的？','2022-08-17 14:00:49',0,0,0,0,NULL,0,1),('2208185A94S0XMA8','E158271B5E5439DA18CE67C43D4C08E6','C1D3928A8F12AC9979FC25718FF7B049','article','2208183P2DWT111P','这是UNNC专属校园论坛喔','2022-08-17 23:31:22',1,0,0,0,NULL,0,1);
/*!40000 ALTER TABLE `user_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_fans`
--

DROP TABLE IF EXISTS `user_fans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_fans` (
  `id` varchar(45) NOT NULL,
  `user_id` varchar(45) DEFAULT NULL,
  `fans_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_fans_rel` (`user_id`,`fans_id`) USING BTREE,
  KEY `fans_id_idx` (`fans_id`),
  CONSTRAINT `user_fans_ibfk_1` FOREIGN KEY (`fans_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `user_fans_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_fans`
--

LOCK TABLES `user_fans` WRITE;
/*!40000 ALTER TABLE `user_fans` DISABLE KEYS */;
INSERT INTO `user_fans` VALUES ('220817GD2N3KC1YW','0C0FDA9B8EA936EE3874E98D22505872','6BAA5F41471DB8DF9177F4D868B7C738'),('220817BF0KGS79P0','0EBD21F315F8DE78B14DFE07365EB529','EA536DDADA4931D7E659109AF6A88A2A'),('220817C4D2K7G7C0','28B21AC61A51DE81DB7048687B163A64','EA536DDADA4931D7E659109AF6A88A2A'),('220817BCX89N64PH','7557AC4BFC97560DE064B04D0F1B3A05','EA536DDADA4931D7E659109AF6A88A2A'),('220817DYD6TFHH94','7889771600DB3F638A8D5EC82228B327','B6D297D920606D5F78AB2251406670DC'),('220817C57SY7KGC0','7889771600DB3F638A8D5EC82228B327','EA536DDADA4931D7E659109AF6A88A2A'),('220817DY0SKPNZ0H','B3E38B58C46AD7F380D877317AC97D01','EA536DDADA4931D7E659109AF6A88A2A'),('220817BMRW67N6CH','B6D297D920606D5F78AB2251406670DC','EA536DDADA4931D7E659109AF6A88A2A'),('220817C0C2N9PGMW','E158271B5E5439DA18CE67C43D4C08E6','0BD5685FDAC552B67BF559EABDA447D9'),('220817BTYBPH4MK4','E158271B5E5439DA18CE67C43D4C08E6','1207A251D249E08C896F68FC1A1D5AC8'),('220817BF6145Z540','E158271B5E5439DA18CE67C43D4C08E6','462256A48FE823E17C35C25CF3D0F796'),('22081714YBRP18H0','E158271B5E5439DA18CE67C43D4C08E6','7557AC4BFC97560DE064B04D0F1B3A05'),('220817CBG11KSSA8','E158271B5E5439DA18CE67C43D4C08E6','B3E38B58C46AD7F380D877317AC97D01'),('220817BR036ZPMY8','E158271B5E5439DA18CE67C43D4C08E6','EA536DDADA4931D7E659109AF6A88A2A'),('220817GDBD7XZCZC','EA536DDADA4931D7E659109AF6A88A2A','1B3D4B79BE41E68F0AB4BF6B5D41A8DA'),('220817BTHN09X2A8','EA536DDADA4931D7E659109AF6A88A2A','462256A48FE823E17C35C25CF3D0F796');
/*!40000 ALTER TABLE `user_fans` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_like`
--

DROP TABLE IF EXISTS `user_like`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_like` (
  `id` varchar(45) NOT NULL,
  `user_id` varchar(45) NOT NULL,
  `target_type` varchar(45) NOT NULL COMMENT '点赞对象类型，如文章，投票，评论',
  `target_id` varchar(45) NOT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_like`
--

LOCK TABLES `user_like` WRITE;
/*!40000 ALTER TABLE `user_like` DISABLE KEYS */;
INSERT INTO `user_like` VALUES ('22081714ZHHW2NR4','7557AC4BFC97560DE064B04D0F1B3A05','article','22081714M3PH9400','2022-08-16 17:39:02'),('220817BCWST5T0X4','EA536DDADA4931D7E659109AF6A88A2A','article','220817BCW6MWSH4H','2022-08-17 08:03:28'),('220817BCWZTYH754','EA536DDADA4931D7E659109AF6A88A2A','article','220817BBMKBH204H','2022-08-17 08:03:29'),('220817BD495KKR8H','462256A48FE823E17C35C25CF3D0F796','article','22081714M3PH9400','2022-08-17 08:04:16'),('220817BDFMS4D86W','E158271B5E5439DA18CE67C43D4C08E6','article','220817BBMKBH204H','2022-08-17 08:05:23'),('220817BDR7G9RN0H','oDwsO5Mjxnj2-O1yXl064bOQbELQ','article','220817BBMKBH204H','2022-08-17 08:06:05'),('220817BDS0YWAKS8','oDwsO5Mjxnj2-O1yXl064bOQbELQ','article','2208176KSFH52XYW','2022-08-17 08:06:10'),('220817BDWKP7G63C','oDwsO5Mjxnj2-O1yXl064bOQbELQ','article','220817BCW6MWSH4H','2022-08-17 08:06:27'),('220817BF0B7HKW6W','EA536DDADA4931D7E659109AF6A88A2A','article','220817BDZ8559WH0','2022-08-17 08:06:51'),('220817BHC14KC37C','6BAA5F41471DB8DF9177F4D868B7C738','article','2208176KSFH52XYW','2022-08-17 08:14:06'),('220817C0D6SKKZTC','0BD5685FDAC552B67BF559EABDA447D9','article','22081714M3PH9400','2022-08-17 08:50:16'),('220817C4F9CT8N7C','EA536DDADA4931D7E659109AF6A88A2A','article','220817C3Z8H2F4BC','2022-08-17 09:02:23'),('220817C4FGN29KP0','EA536DDADA4931D7E659109AF6A88A2A','article','220817C07MWDC4H0','2022-08-17 09:02:25'),('220817C57AW04DAW','EA536DDADA4931D7E659109AF6A88A2A','article','220817C4M5DZC18H','2022-08-17 09:04:39'),('220817C7G1N8Z2W0','7889771600DB3F638A8D5EC82228B327','article','220817C4M5DZC18H','2022-08-17 09:11:28'),('220817CBGZSGBW28','B3E38B58C46AD7F380D877317AC97D01','article','22081714M3PH9400','2022-08-17 09:23:35'),('220817CH2DSRWTTC','7889771600DB3F638A8D5EC82228B327','article','220817CGM14CH7TC','2022-08-17 09:37:09'),('220817CMX57M5FRP','462256A48FE823E17C35C25CF3D0F796','article','220817C3Z8H2F4BC','2022-08-17 09:45:35'),('220817DWAKAAXG2W','EA536DDADA4931D7E659109AF6A88A2A','article','220817C9AFDRB540','2022-08-17 11:26:07'),('220817DWB014XPZC','EA536DDADA4931D7E659109AF6A88A2A','article','220817CBZFDBK7HH','2022-08-17 11:26:09'),('220817DYDYGB3Y14','B6D297D920606D5F78AB2251406670DC','article','220817CGM14CH7TC','2022-08-17 11:32:28'),('220817DYFRRK2T9P','B6D297D920606D5F78AB2251406670DC','article','220817C4M5DZC18H','2022-08-17 11:32:34'),('220817FCZ9ZY2KS8','EA536DDADA4931D7E659109AF6A88A2A','article','220817CGM14CH7TC','2022-08-17 12:15:57'),('220817FDFPN5Y5P0','EA536DDADA4931D7E659109AF6A88A2A','article','220817FCHWCWM5AW','2022-08-17 12:17:36'),('220817G1XX3G0FNC','0C0FDA9B8EA936EE3874E98D22505872','article','2208176KSFH52XYW','2022-08-17 13:06:50'),('220817G221XTX9GC','B981CFAD8239731FC14A47C6E7A15C77','article','22081714M3PH9400','2022-08-17 13:07:17'),('220817GAYMA457HH','6BAA5F41471DB8DF9177F4D868B7C738','article','220817GABGW247F8','2022-08-17 13:33:56'),('220817GBT148MGTC','EA536DDADA4931D7E659109AF6A88A2A','article','220817GABGW247F8','2022-08-17 13:36:33'),('220817GD8WDC325P','1B3D4B79BE41E68F0AB4BF6B5D41A8DA','article','220817GABGW247F8','2022-08-17 13:41:02'),('220817GGH0FSM8M8','A626164C4DA2862C1F0414B1AC514CC9','article','220817GABGW247F8','2022-08-17 13:47:48'),('220817GMNBKMTFY8','28B21AC61A51DE81DB7048687B163A64','article','220817GABGW247F8','2022-08-17 13:57:11'),('220817GNT5WK42K4','EA536DDADA4931D7E659109AF6A88A2A','article','220817GND4GTR968','2022-08-17 14:00:35'),('220817H5AYG3NNF8','462256A48FE823E17C35C25CF3D0F796','article','220817GABGW247F8','2022-08-17 14:41:18'),('220817HKY8T0YT0H','oDwsO5Mjxnj2-O1yXl064bOQbELQ','article','220817GABGW247F8','2022-08-17 15:18:59'),('2208188AC8DXW5GC','EA536DDADA4931D7E659109AF6A88A2A','comment','2208185A94S0XMA8','2022-08-18 03:43:54');
/*!40000 ALTER TABLE `user_like` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_report`
--

DROP TABLE IF EXISTS `user_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_report` (
  `id` varchar(45) NOT NULL,
  `user_id` varchar(45) NOT NULL,
  `target_type` varchar(45) NOT NULL COMMENT 'ARTICLE/LONGARTICLE/COMMENT',
  `target_id` varchar(45) NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_report`
--

LOCK TABLES `user_report` WRITE;
/*!40000 ALTER TABLE `user_report` DISABLE KEYS */;
INSERT INTO `user_report` VALUES ('220817C4TRCDWDAW','EA536DDADA4931D7E659109AF6A88A2A','article','220817BNC71Z24BC','2022-08-17 09:03:24'),('220817C6AAR68ACH','EA536DDADA4931D7E659109AF6A88A2A','article','220817C3Z8H2F4BC','2022-08-17 09:07:58');
/*!40000 ALTER TABLE `user_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vote`
--

DROP TABLE IF EXISTS `vote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vote` (
  `id` varchar(45) NOT NULL,
  `vote_title` varchar(45) CHARACTER SET utf8mb4 NOT NULL,
  `vote_type` int(11) NOT NULL DEFAULT '0' COMMENT '0 = single choice, 1 = multiple choice',
  `user_id` varchar(45) NOT NULL,
  `vote_content` text CHARACTER SET utf8mb4 NOT NULL,
  `comment_num` int(11) NOT NULL DEFAULT '0',
  `sum_vote` int(11) NOT NULL DEFAULT '0',
  `sum_user` int(11) NOT NULL DEFAULT '0',
  `status` int(11) NOT NULL DEFAULT '2' COMMENT '0 = unreadable, 1 = readable, 2 = checking',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `expiry_date` datetime NOT NULL,
  `duration_time` int(11) NOT NULL DEFAULT '3',
  `view_num` int(11) NOT NULL DEFAULT '0' COMMENT '浏览量',
  PRIMARY KEY (`id`),
  KEY `user_vote_idx` (`user_id`),
  CONSTRAINT `vote_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vote`
--

LOCK TABLES `vote` WRITE;
/*!40000 ALTER TABLE `vote` DISABLE KEYS */;
/*!40000 ALTER TABLE `vote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vote_image`
--

DROP TABLE IF EXISTS `vote_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vote_image` (
  `id` varchar(45) NOT NULL,
  `vote_id` varchar(45) NOT NULL,
  `image_path` varchar(255) NOT NULL,
  `image_order` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `vote_image_idx` (`vote_id`),
  CONSTRAINT `vote_image_ibfk_1` FOREIGN KEY (`vote_id`) REFERENCES `vote` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vote_image`
--

LOCK TABLES `vote_image` WRITE;
/*!40000 ALTER TABLE `vote_image` DISABLE KEYS */;
/*!40000 ALTER TABLE `vote_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vote_option`
--

DROP TABLE IF EXISTS `vote_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vote_option` (
  `id` varchar(45) NOT NULL,
  `vote_id` varchar(45) NOT NULL,
  `content` text CHARACTER SET utf8mb4 NOT NULL,
  `img` varchar(255) DEFAULT NULL COMMENT '投票选项的图片',
  `index` int(11) NOT NULL DEFAULT '0',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `count` int(11) NOT NULL DEFAULT '0',
  `percent` double unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `vote_option_idx` (`vote_id`),
  CONSTRAINT `vote_option_ibfk_1` FOREIGN KEY (`vote_id`) REFERENCES `vote` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vote_option`
--

LOCK TABLES `vote_option` WRITE;
/*!40000 ALTER TABLE `vote_option` DISABLE KEYS */;
/*!40000 ALTER TABLE `vote_option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vote_user`
--

DROP TABLE IF EXISTS `vote_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vote_user` (
  `id` varchar(45) NOT NULL,
  `user_id` varchar(45) NOT NULL,
  `vote_id` varchar(45) NOT NULL,
  `option_id` varchar(45) NOT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_option_idx` (`option_id`),
  KEY `user_option_rel` (`user_id`,`option_id`),
  CONSTRAINT `vote_user_ibfk_1` FOREIGN KEY (`option_id`) REFERENCES `vote_option` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `vote_user_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vote_user`
--

LOCK TABLES `vote_user` WRITE;
/*!40000 ALTER TABLE `vote_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `vote_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-18 12:21:35
