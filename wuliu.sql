/*
Navicat MySQL Data Transfer

Source Server         : wuliu
Source Server Version : 50611
Source Host           : localhost:3306
Source Database       : wuliu

Target Server Type    : MYSQL
Target Server Version : 50611
File Encoding         : 65001

Date: 2018-06-09 10:48:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tauto
-- ----------------------------
DROP TABLE IF EXISTS `tauto`;
CREATE TABLE `tauto` (
  `autoid` varchar(20) NOT NULL,
  `cartypeid` varchar(30) DEFAULT NULL,
  `cartweight` double DEFAULT NULL,
  `carvol` double DEFAULT NULL,
  `driver1` varchar(20) DEFAULT NULL,
  `driver2` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`autoid`),
  KEY `FK_TAUTO_REFERENCE_TCARTYPE` (`cartypeid`),
  CONSTRAINT `FK_TAUTO_REFERENCE_TCARTYPE` FOREIGN KEY (`cartypeid`) REFERENCES `tcartype` (`cartypeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tauto
-- ----------------------------
INSERT INTO `tauto` VALUES ('HL000000000001', 'HLL-000000', '10', '10', '2', '1');
INSERT INTO `tauto` VALUES ('HL00000000401', 'HLL-000004', '20', '20', '3', '2');
INSERT INTO `tauto` VALUES ('HLL0000000000000', 'HLL-000000', '8', '8', '1', '1');

-- ----------------------------
-- Table structure for tbaseroad
-- ----------------------------
DROP TABLE IF EXISTS `tbaseroad`;
CREATE TABLE `tbaseroad` (
  `baseid` int(11) NOT NULL,
  `sendpointid` int(11) DEFAULT NULL,
  `recvpointid` int(11) DEFAULT NULL,
  `basename` varchar(30) DEFAULT NULL,
  `basevalue` float DEFAULT NULL,
  `lenght` float DEFAULT NULL,
  PRIMARY KEY (`baseid`),
  KEY `FK_SEND_REFERENCE_TPOINT` (`sendpointid`),
  KEY `FK_RECV_REFERENCE_TPOINT` (`recvpointid`),
  CONSTRAINT `FK_RECV_REFERENCE_TPOINT` FOREIGN KEY (`recvpointid`) REFERENCES `tpoint` (`pointid`),
  CONSTRAINT `FK_SEND_REFERENCE_TPOINT` FOREIGN KEY (`sendpointid`) REFERENCES `tpoint` (`pointid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbaseroad
-- ----------------------------

-- ----------------------------
-- Table structure for tcartype
-- ----------------------------
DROP TABLE IF EXISTS `tcartype`;
CREATE TABLE `tcartype` (
  `cartypeid` varchar(30) NOT NULL,
  `cartypename` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`cartypeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tcartype
-- ----------------------------
INSERT INTO `tcartype` VALUES ('HLL-000000', '呼啦啦000');
INSERT INTO `tcartype` VALUES ('HLL-000001', '呼啦啦001');
INSERT INTO `tcartype` VALUES ('HLL-000002', '呼啦啦002');
INSERT INTO `tcartype` VALUES ('HLL-000003', '呼啦啦003');
INSERT INTO `tcartype` VALUES ('HLL-000004', '呼啦啦004');

-- ----------------------------
-- Table structure for tcharge
-- ----------------------------
DROP TABLE IF EXISTS `tcharge`;
CREATE TABLE `tcharge` (
  `chargeid` int(11) NOT NULL,
  `cityid` varchar(10) DEFAULT NULL,
  `firstweight` float DEFAULT NULL,
  `firstvol` float DEFAULT NULL,
  `secondweight` float DEFAULT NULL,
  `secondvol` float DEFAULT NULL,
  `starttime` date DEFAULT NULL,
  `endtime` date DEFAULT NULL,
  `chargestate` varchar(10) NOT NULL DEFAULT '0',
  `chargeremarks` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`chargeid`),
  KEY `FK_TCHARGE_REFERENCE_TCITY` (`cityid`),
  CONSTRAINT `FK_TCHARGE_REFERENCE_TCITY` FOREIGN KEY (`cityid`) REFERENCES `tcity` (`cityid`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tcharge
-- ----------------------------
INSERT INTO `tcharge` VALUES ('1', '1', '12', '12', '5', '5', '2018-05-03', null, '1', '                 起价12元 超1kg后，每    超1kg递增5元                ');
INSERT INTO `tcharge` VALUES ('2', '2', '12', '12', '5', '5', '2018-03-21', '2018-03-21', '-1', 'aaa');
INSERT INTO `tcharge` VALUES ('3', '3', '15', '15', '5', '5', '2018-03-21', null, '1', '           bbbbbbb             ');
INSERT INTO `tcharge` VALUES ('6', '4', '10', '15', '6', '6', '2018-03-21', null, '1', null);
INSERT INTO `tcharge` VALUES ('7', '6', '10', '15', '5', '6', '2018-03-21', null, '1', '                        ');
INSERT INTO `tcharge` VALUES ('9', '5', '12', '0', '0', '5', null, '2018-05-03', '-1', '');

-- ----------------------------
-- Table structure for tcity
-- ----------------------------
DROP TABLE IF EXISTS `tcity`;
CREATE TABLE `tcity` (
  `cityid` varchar(10) NOT NULL,
  `province` varchar(40) DEFAULT NULL,
  `city` varchar(40) DEFAULT NULL,
  `district` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`cityid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tcity
-- ----------------------------
INSERT INTO `tcity` VALUES ('1', '山西省', '太原市', '万柏林区');
INSERT INTO `tcity` VALUES ('2', '山西省', '晋中市', '榆次区');
INSERT INTO `tcity` VALUES ('3', '北京', '北京市', '昌平区');
INSERT INTO `tcity` VALUES ('4', '河北省', '廊坊市', '安次区');
INSERT INTO `tcity` VALUES ('5', '湖南省', '长沙市', '望城区');
INSERT INTO `tcity` VALUES ('6', '甘肃省', '平凉市', '静宁县');
INSERT INTO `tcity` VALUES ('hbsxysxcq', '湖北省', '襄阳市', '襄城区');
INSERT INTO `tcity` VALUES ('shshshkq', '上海', '上海市', '虹口区');
INSERT INTO `tcity` VALUES ('shshsjaq', '上海', '上海市', '静安区');
INSERT INTO `tcity` VALUES ('sxtyxd', '山西省', '太原市', '小店区');
INSERT INTO `tcity` VALUES ('zjshzsjgq', '浙江省', '杭州市', '江干区');
INSERT INTO `tcity` VALUES ('zjshzsxhq', '浙江省', '杭州市', '西湖区');

-- ----------------------------
-- Table structure for tclass
-- ----------------------------
DROP TABLE IF EXISTS `tclass`;
CREATE TABLE `tclass` (
  `tclassid` int(8) NOT NULL,
  `troadid` int(11) DEFAULT NULL,
  `autoid` varchar(20) DEFAULT NULL,
  `tclassstarttime` datetime DEFAULT NULL,
  `tclassendtime` datetime DEFAULT NULL,
  `tclassstate` varchar(10) DEFAULT NULL,
  `classremarks` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`tclassid`),
  KEY `FK_TCLASS_REFERENCE_TROAD` (`troadid`),
  KEY `FK_TCLASS_REFERENCE_TAUTO` (`autoid`),
  CONSTRAINT `FK_TCLASS_REFERENCE_TAUTO` FOREIGN KEY (`autoid`) REFERENCES `tauto` (`autoid`),
  CONSTRAINT `FK_TCLASS_REFERENCE_TROAD` FOREIGN KEY (`troadid`) REFERENCES `troad` (`troadid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tclass
-- ----------------------------
INSERT INTO `tclass` VALUES ('1', '1', 'HL000000000001', '2018-04-23 14:35:11', '2018-04-26 14:35:38', '', '');
INSERT INTO `tclass` VALUES ('2', '2', 'HLL0000000000000', '2018-04-27 16:37:02', '2018-04-27 16:37:05', '上线', '');
INSERT INTO `tclass` VALUES ('3', '1', 'HLL0000000000000', '2018-06-02 11:10:34', '2018-06-04 11:10:39', '上线中', '');
INSERT INTO `tclass` VALUES ('4', '6', 'HL00000000401', '2018-06-02 11:24:45', '2018-06-04 11:24:46', '上线中', '');

-- ----------------------------
-- Table structure for tclasstime
-- ----------------------------
DROP TABLE IF EXISTS `tclasstime`;
CREATE TABLE `tclasstime` (
  `tclasstimeid` int(11) NOT NULL,
  `waypassid` int(11) DEFAULT NULL,
  `tclassid` int(8) DEFAULT NULL,
  `cometime` date DEFAULT NULL,
  `gotime` date DEFAULT NULL,
  PRIMARY KEY (`tclasstimeid`),
  KEY `FK_TCLASSTI_REFERENCE_TROADWAY` (`waypassid`),
  KEY `FK_TCLASSTI_REFERENCE_TCLASS` (`tclassid`),
  CONSTRAINT `FK_TCLASSTI_REFERENCE_TCLASS` FOREIGN KEY (`tclassid`) REFERENCES `tclass` (`tclassid`),
  CONSTRAINT `FK_TCLASSTI_REFERENCE_TROADWAY` FOREIGN KEY (`waypassid`) REFERENCES `troadwaybypoint` (`waypassid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tclasstime
-- ----------------------------

-- ----------------------------
-- Table structure for texcorder
-- ----------------------------
DROP TABLE IF EXISTS `texcorder`;
CREATE TABLE `texcorder` (
  `excid` int(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `orderid` varchar(20) DEFAULT NULL,
  `joinid` varchar(20) DEFAULT NULL,
  `exctime` datetime DEFAULT NULL,
  `accident` varchar(300) DEFAULT NULL,
  `resolve` varchar(300) DEFAULT NULL,
  `position` varchar(300) DEFAULT NULL,
  `excstate` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`excid`),
  KEY `FK_TEXCORDE_REFERENCE_TJOIN` (`joinid`),
  KEY `FK_TEXCORDE_REFERENCE_TORDER` (`orderid`),
  CONSTRAINT `FK_TEXCORDE_REFERENCE_TJOIN` FOREIGN KEY (`joinid`) REFERENCES `tjoin` (`joinid`),
  CONSTRAINT `FK_TEXCORDE_REFERENCE_TORDER` FOREIGN KEY (`orderid`) REFERENCES `torder` (`orderid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of texcorder
-- ----------------------------
INSERT INTO `texcorder` VALUES ('00000000000000000001', '20180507165944202', null, '2018-05-08 09:52:50', '途中运输货车起火，货物被焚烧', '赔钱', '售后服务良好', '已解决');

-- ----------------------------
-- Table structure for tgoodstype
-- ----------------------------
DROP TABLE IF EXISTS `tgoodstype`;
CREATE TABLE `tgoodstype` (
  `goodstypeid` int(11) NOT NULL,
  `goodstypename` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`goodstypeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tgoodstype
-- ----------------------------
INSERT INTO `tgoodstype` VALUES ('0', '文件');
INSERT INTO `tgoodstype` VALUES ('1', '衣物');
INSERT INTO `tgoodstype` VALUES ('2', '易碎物品');

-- ----------------------------
-- Table structure for tjoin
-- ----------------------------
DROP TABLE IF EXISTS `tjoin`;
CREATE TABLE `tjoin` (
  `joinid` varchar(20) NOT NULL,
  `sendpointid` int(11) DEFAULT NULL,
  `recvpointid` int(11) DEFAULT NULL,
  `classid` int(11) DEFAULT NULL,
  `joinvol` float DEFAULT NULL,
  `joinweight` float DEFAULT NULL,
  `joinsendtime` date DEFAULT NULL,
  `joinexptime` date DEFAULT NULL,
  `joinrecvtime` date DEFAULT NULL,
  `joinstate` varchar(20) DEFAULT '未处理' COMMENT '交接单状态：是否已到达下一站交接完成',
  PRIMARY KEY (`joinid`),
  KEY `FK_TJOIN_REFERENCE_TSEND` (`sendpointid`),
  KEY `FK_TJOIN_REFERENCE_TRECV` (`recvpointid`),
  KEY `FK_TJOIN_REFERENCE_TCLASS` (`classid`),
  CONSTRAINT `FK_TJOIN_REFERENCE_TCLASS` FOREIGN KEY (`classid`) REFERENCES `tclass` (`tclassid`),
  CONSTRAINT `FK_TJOIN_REFERENCE_TRECV` FOREIGN KEY (`recvpointid`) REFERENCES `tpoint` (`pointid`),
  CONSTRAINT `FK_TJOIN_REFERENCE_TSEND` FOREIGN KEY (`sendpointid`) REFERENCES `tpoint` (`pointid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tjoin
-- ----------------------------
INSERT INTO `tjoin` VALUES ('1', '0', '2', '1', null, null, null, null, null, '已处理');
INSERT INTO `tjoin` VALUES ('2', '2', '1', '1', null, null, null, null, null, '已处理');
INSERT INTO `tjoin` VALUES ('3', '0', '5', '1', null, null, null, null, null, '已处理');
INSERT INTO `tjoin` VALUES ('4', '5', '2', '4', null, null, null, null, null, '已处理');
INSERT INTO `tjoin` VALUES ('5', '2', '1', '4', null, null, null, null, null, '已处理');

-- ----------------------------
-- Table structure for torder
-- ----------------------------
DROP TABLE IF EXISTS `torder`;
CREATE TABLE `torder` (
  `orderid` varchar(20) NOT NULL,
  `startpointid` int(11) DEFAULT NULL,
  `endpointid` int(11) DEFAULT NULL,
  `mailing` int(11) DEFAULT NULL,
  `goodstypeid` int(11) DEFAULT NULL,
  `startcityid` varchar(10) DEFAULT NULL,
  `endcityid` varchar(10) DEFAULT NULL,
  `senddelivery` smallint(6) DEFAULT NULL,
  `recvdelivery` smallint(6) DEFAULT NULL,
  `sendtime` datetime DEFAULT NULL,
  `exptime` datetime DEFAULT NULL,
  `recvtime` datetime DEFAULT NULL,
  `safe` double DEFAULT '0',
  `weight` double DEFAULT '2',
  `volume` double DEFAULT '0',
  `describ` varchar(300) DEFAULT '',
  `sendname` varchar(20) DEFAULT NULL,
  `sendphone` varchar(30) DEFAULT NULL,
  `sendaddress` varchar(100) DEFAULT NULL,
  `recvname` varchar(20) DEFAULT NULL,
  `recvphone` varchar(30) DEFAULT NULL,
  `recvaddress` varchar(300) DEFAULT NULL,
  `fast` smallint(6) DEFAULT '0',
  `fastcost` double DEFAULT '0',
  `cost` double DEFAULT '0',
  `transfer` int(11) DEFAULT NULL,
  `state` varchar(10) DEFAULT '-2' COMMENT '-3 ---审核未通过\r\n-2 ---待审核\r\n-1 ---入库			\r\n 0 ---已揽件	\r\n 1 ---发出\r\n 2 ---抵达\r\n 3 ---完成\r\n 4 ---异常',
  `remarks` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`orderid`),
  KEY `FK_TORDER_REFERENCE_TSTART` (`startpointid`),
  KEY `FK_TORDER_REFERENCE_TEND` (`endpointid`),
  KEY `FK_TORDER_REFERENCE_TGOODSTY` (`goodstypeid`),
  KEY `FK93D6A35A6580F973` (`mailing`),
  KEY `FK_TORDER_REFERENCE_TEDCITY` (`endcityid`),
  KEY `FK_TORDER_REFERENCE_TSTCITY` (`startcityid`),
  CONSTRAINT `FK_TORDER_REFERENCE_TEDCITY` FOREIGN KEY (`endcityid`) REFERENCES `tcity` (`cityid`) ON UPDATE CASCADE,
  CONSTRAINT `FK_TORDER_REFERENCE_TEND` FOREIGN KEY (`endpointid`) REFERENCES `tpoint` (`pointid`),
  CONSTRAINT `FK_TORDER_REFERENCE_TGOODSTY` FOREIGN KEY (`goodstypeid`) REFERENCES `tgoodstype` (`goodstypeid`),
  CONSTRAINT `FK_TORDER_REFERENCE_TSTART` FOREIGN KEY (`startpointid`) REFERENCES `tpoint` (`pointid`),
  CONSTRAINT `FK_TORDER_REFERENCE_TSTCITY` FOREIGN KEY (`startcityid`) REFERENCES `tcity` (`cityid`) ON UPDATE CASCADE,
  CONSTRAINT `FK_TORDER_REFERENCE_TUSER` FOREIGN KEY (`mailing`) REFERENCES `tuser` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of torder
-- ----------------------------
INSERT INTO `torder` VALUES ('20180507165944202', '0', '1', null, '0', null, null, null, null, '2018-05-07 16:59:36', '2018-05-09 00:00:00', null, '0', '2', null, null, '陈家兴', '117813543322', '山西省太原市万柏林区下元智成御景', '李达', '15935407794', '北京北京市昌平区北京交通职业技术学院', '0', '0', '12', null, '异常', '');
INSERT INTO `torder` VALUES ('20180508142654493', '1', '3', null, '0', null, null, null, null, '2018-05-08 14:25:51', '2018-05-11 00:00:00', null, '0', '2', null, null, '朵朵', '17833442031', '北京北京市昌平区北京交通职业技术学院', '孟杰', '15534700002', '山西省太原市万柏林区千峰路口国际能源中心', '0', '0', '10', null, '待审核', '');
INSERT INTO `torder` VALUES ('20180519113849941', '0', '1', '4', '0', null, null, null, null, '2018-05-19 11:38:27', '2018-05-21 00:00:00', '2018-05-19 11:43:21', '0', '2', null, null, '张君', '15935407794', '山西省太原市下元智成御景', '王晓然', '15988775460', '北京昌平区北京交通职业技术学校', '0', '0', '12', null, '已签收', '');
INSERT INTO `torder` VALUES ('20180602092347971', '0', '1', '4', '1', null, null, null, null, '2018-06-02 09:23:24', '2018-06-04 00:00:00', '2018-06-02 12:38:43', '0', '5', null, null, '张君', '15935407794', '山西省太原市万柏林区智成御景', '王展宏', '15536451053', '北京昌平区北京交通职业技术学院', '1', '10', '12', null, '已签收', '');

-- ----------------------------
-- Table structure for torderbyjoin
-- ----------------------------
DROP TABLE IF EXISTS `torderbyjoin`;
CREATE TABLE `torderbyjoin` (
  `orderbyjoinid` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `joinid` varchar(20) DEFAULT NULL,
  `orderid` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`orderbyjoinid`),
  KEY `FK_TORDERBY_REFERENCE_TJOIN` (`joinid`),
  KEY `FK_TORDERBY_REFERENCE_TORDER` (`orderid`),
  CONSTRAINT `FK_TORDERBY_REFERENCE_TJOIN` FOREIGN KEY (`joinid`) REFERENCES `tjoin` (`joinid`),
  CONSTRAINT `FK_TORDERBY_REFERENCE_TORDER` FOREIGN KEY (`orderid`) REFERENCES `torder` (`orderid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of torderbyjoin
-- ----------------------------
INSERT INTO `torderbyjoin` VALUES ('00000000001', '1', '20180519113849941');
INSERT INTO `torderbyjoin` VALUES ('00000000002', '2', '20180519113849941');
INSERT INTO `torderbyjoin` VALUES ('00000000003', '3', '20180602092347971');
INSERT INTO `torderbyjoin` VALUES ('00000000004', '4', '20180602092347971');
INSERT INTO `torderbyjoin` VALUES ('00000000005', '5', '20180602092347971');

-- ----------------------------
-- Table structure for tpoint
-- ----------------------------
DROP TABLE IF EXISTS `tpoint`;
CREATE TABLE `tpoint` (
  `pointid` int(11) NOT NULL,
  `cityid` varchar(10) DEFAULT NULL,
  `pointname` varchar(20) DEFAULT NULL,
  `pointaddr` varchar(100) DEFAULT NULL,
  `pointphone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`pointid`),
  KEY `FK_TPOINT_REFERENCE_TCITY` (`cityid`),
  CONSTRAINT `FK_TPOINT_REFERENCE_TCITY` FOREIGN KEY (`cityid`) REFERENCES `tcity` (`cityid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tpoint
-- ----------------------------
INSERT INTO `tpoint` VALUES ('0', '1', '下元C区智诚双喜店', '山西省太原市万柏林区下元社区智诚小区', '15977028840');
INSERT INTO `tpoint` VALUES ('1', '3', '北京交通职业技术学院新世纪华联店', '北京北京市昌平区北京交通职业技术学院', '13333445521');
INSERT INTO `tpoint` VALUES ('2', '4', '石家庄转运中心', '河北省石家庄市物流转运中心', '15800034245');
INSERT INTO `tpoint` VALUES ('3', '1', '太原国际能源中心菜鸟驿站', '山西省太原市万柏林区千峰路口国际能源中心', '0351-8720299');
INSERT INTO `tpoint` VALUES ('4', '5', '郑州转运中心', '湖南省-长沙市-望城区郑州转运中心', '0355-6987222');
INSERT INTO `tpoint` VALUES ('5', 'sxtyxd', '太原转运中心', '山西省太原市小店区太原xxxx街道xx号', '0351-6332771');

-- ----------------------------
-- Table structure for tprofits
-- ----------------------------
DROP TABLE IF EXISTS `tprofits`;
CREATE TABLE `tprofits` (
  `profitsid` int(11) NOT NULL,
  `orderid` varchar(20) DEFAULT NULL,
  `allprofits` int(11) DEFAULT NULL,
  `sendprofits` float DEFAULT NULL,
  `companyprofits` float DEFAULT NULL,
  `recvprofits` float DEFAULT NULL,
  `gettime` date DEFAULT NULL,
  `profitsremarks` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`profitsid`),
  KEY `FK_TPROFITS_REFERENCE_TORDER` (`orderid`),
  CONSTRAINT `FK_TPROFITS_REFERENCE_TORDER` FOREIGN KEY (`orderid`) REFERENCES `torder` (`orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tprofits
-- ----------------------------

-- ----------------------------
-- Table structure for tprofitsset
-- ----------------------------
DROP TABLE IF EXISTS `tprofitsset`;
CREATE TABLE `tprofitsset` (
  `profitsname` varchar(10) NOT NULL,
  `sendpoint` int(11) DEFAULT NULL,
  `recvpoint` int(11) DEFAULT NULL,
  `company` int(11) DEFAULT NULL,
  PRIMARY KEY (`profitsname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tprofitsset
-- ----------------------------

-- ----------------------------
-- Table structure for transfee
-- ----------------------------
DROP TABLE IF EXISTS `transfee`;
CREATE TABLE `transfee` (
  `transfeeid` int(11) NOT NULL,
  `firstw` float DEFAULT NULL,
  `secondw` float DEFAULT NULL,
  `firstv` float DEFAULT NULL,
  `secondv` float DEFAULT NULL,
  PRIMARY KEY (`transfeeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of transfee
-- ----------------------------

-- ----------------------------
-- Table structure for transfer
-- ----------------------------
DROP TABLE IF EXISTS `transfer`;
CREATE TABLE `transfer` (
  `transferid` int(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `pointid` int(11) DEFAULT NULL,
  `orderid` varchar(20) DEFAULT NULL,
  `sequence` int(11) DEFAULT NULL,
  `transferTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`transferid`),
  KEY `FK_TRANSFER_REFERENCE_TORDER` (`orderid`),
  KEY `FK_TRANSFER_REFERENCE_TPOINT` (`pointid`),
  CONSTRAINT `FK_TRANSFER_REFERENCE_TORDER` FOREIGN KEY (`orderid`) REFERENCES `torder` (`orderid`),
  CONSTRAINT `FK_TRANSFER_REFERENCE_TPOINT` FOREIGN KEY (`pointid`) REFERENCES `tpoint` (`pointid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of transfer
-- ----------------------------
INSERT INTO `transfer` VALUES ('00000000000000000001', '0', '20180519113849941', null, '2018-05-19 11:40:42');
INSERT INTO `transfer` VALUES ('00000000000000000002', '2', '20180519113849941', null, '2018-05-19 11:41:55');
INSERT INTO `transfer` VALUES ('00000000000000000003', '1', '20180519113849941', null, '2018-05-19 11:43:06');
INSERT INTO `transfer` VALUES ('00000000000000000004', '0', '20180602092347971', null, '2018-06-02 09:51:13');
INSERT INTO `transfer` VALUES ('00000000000000000005', '5', '20180602092347971', null, '2018-06-02 11:32:11');
INSERT INTO `transfer` VALUES ('00000000000000000006', '2', '20180602092347971', null, '2018-06-02 11:39:12');
INSERT INTO `transfer` VALUES ('00000000000000000007', '1', '20180602092347971', null, '2018-06-02 12:38:24');

-- ----------------------------
-- Table structure for troad
-- ----------------------------
DROP TABLE IF EXISTS `troad`;
CREATE TABLE `troad` (
  `troadid` int(11) NOT NULL,
  `startpointid` int(11) DEFAULT NULL,
  `endpointid` int(11) DEFAULT NULL,
  `roadname` varchar(30) DEFAULT NULL,
  `raodlength` float DEFAULT NULL,
  `raodvalue` float DEFAULT NULL,
  PRIMARY KEY (`troadid`),
  KEY `FK_STARTTROAD_REFERENCE_TPOINT` (`startpointid`),
  KEY `FK_ENDTROAD_REFERENCE_TPOINT` (`endpointid`),
  CONSTRAINT `FK_ENDTROAD_REFERENCE_TPOINT` FOREIGN KEY (`endpointid`) REFERENCES `tpoint` (`pointid`),
  CONSTRAINT `FK_STARTTROAD_REFERENCE_TPOINT` FOREIGN KEY (`startpointid`) REFERENCES `tpoint` (`pointid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of troad
-- ----------------------------
INSERT INTO `troad` VALUES ('1', '0', '1', '太原万柏林下元--》北京昌平邓庄', '100', '12');
INSERT INTO `troad` VALUES ('2', '1', '0', '北交职技 -->> 太原下元', '500', '12');
INSERT INTO `troad` VALUES ('5', '3', '1', '国能--》北交职', '100', '12');
INSERT INTO `troad` VALUES ('6', '0', '1', '下元智成御景--->北交职业', '500', '12');

-- ----------------------------
-- Table structure for troadwaybypoint
-- ----------------------------
DROP TABLE IF EXISTS `troadwaybypoint`;
CREATE TABLE `troadwaybypoint` (
  `waypassid` int(11) NOT NULL,
  `troadid` int(11) DEFAULT NULL,
  `passpointid` int(11) DEFAULT NULL,
  `sequence` int(11) DEFAULT NULL,
  PRIMARY KEY (`waypassid`),
  KEY `FK_TROADWAY_REFERENCE_TROAD` (`troadid`),
  KEY `FK_TROADWAY_REFERENCE_TPOINT` (`passpointid`),
  CONSTRAINT `FK_TROADWAY_REFERENCE_TPOINT` FOREIGN KEY (`passpointid`) REFERENCES `tpoint` (`pointid`),
  CONSTRAINT `FK_TROADWAY_REFERENCE_TROAD` FOREIGN KEY (`troadid`) REFERENCES `troad` (`troadid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of troadwaybypoint
-- ----------------------------
INSERT INTO `troadwaybypoint` VALUES ('1', '1', '2', '0');
INSERT INTO `troadwaybypoint` VALUES ('2', '2', '2', '0');
INSERT INTO `troadwaybypoint` VALUES ('7', '5', '4', '0');
INSERT INTO `troadwaybypoint` VALUES ('8', '5', '2', '1');
INSERT INTO `troadwaybypoint` VALUES ('9', '6', '5', '0');
INSERT INTO `troadwaybypoint` VALUES ('10', '6', '2', '1');

-- ----------------------------
-- Table structure for trole
-- ----------------------------
DROP TABLE IF EXISTS `trole`;
CREATE TABLE `trole` (
  `roleid` int(2) NOT NULL,
  `rolename` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trole
-- ----------------------------
INSERT INTO `trole` VALUES ('1', '管理员');
INSERT INTO `trole` VALUES ('2', '配送点');
INSERT INTO `trole` VALUES ('3', '普通用户');

-- ----------------------------
-- Table structure for tstaff
-- ----------------------------
DROP TABLE IF EXISTS `tstaff`;
CREATE TABLE `tstaff` (
  `staffid` int(11) NOT NULL,
  `staffname` varchar(10) DEFAULT NULL,
  `staffpost` varchar(10) DEFAULT NULL,
  `staffphone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`staffid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tstaff
-- ----------------------------
INSERT INTO `tstaff` VALUES ('1', '张三', 'xxxx*****x', '152****1053');
INSERT INTO `tstaff` VALUES ('2', '李思', 'xxxx******', '152****1053');
INSERT INTO `tstaff` VALUES ('3', '王五', 'xxxx******', '152****1053');

-- ----------------------------
-- Table structure for tuser
-- ----------------------------
DROP TABLE IF EXISTS `tuser`;
CREATE TABLE `tuser` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `pointid` int(11) DEFAULT NULL,
  `roleid` int(2) DEFAULT NULL,
  `username` varchar(40) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  KEY `FK_TUSER_REFERENCE_TPOINT` (`pointid`),
  KEY `FK_TUSER_REFERENCE_TROLE` (`roleid`),
  CONSTRAINT `FK_TUSER_REFERENCE_TPOINT` FOREIGN KEY (`pointid`) REFERENCES `tpoint` (`pointid`),
  CONSTRAINT `FK_TUSER_REFERENCE_TROLE` FOREIGN KEY (`roleid`) REFERENCES `trole` (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tuser
-- ----------------------------
INSERT INTO `tuser` VALUES ('-1', null, null, null, null);
INSERT INTO `tuser` VALUES ('1', null, '1', 'admin', 'admin');
INSERT INTO `tuser` VALUES ('2', '0', '2', '张三', 'zhangsan');
INSERT INTO `tuser` VALUES ('3', '2', '2', 'lisi', '12345');
INSERT INTO `tuser` VALUES ('4', '1', '2', 'wangwu', '12345');
INSERT INTO `tuser` VALUES ('5', null, '3', 'zhangsan', '12345');
INSERT INTO `tuser` VALUES ('7', '2', '2', 'zhaoliu', '12345');
INSERT INTO `tuser` VALUES ('8', '4', '2', 'chengjiaxin', '12345');
INSERT INTO `tuser` VALUES ('9', '3', '2', 'zhenqi', '12345');
INSERT INTO `tuser` VALUES ('10', '5', '2', 'lida', '12345');
