-- --------------------------------------------------------
-- 主机:                           47.99.32.132
-- 服务器版本:                        5.5.60-MariaDB - MariaDB Server
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  9.5.0.5289
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出  表 trade.trade_coupon 结构
CREATE TABLE IF NOT EXISTS `trade_coupon` (
  `coupon_id` varchar(32) NOT NULL COMMENT '优惠券ID',
  `coupon_price` decimal(10,2) DEFAULT NULL COMMENT '优惠券金额',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `oder_id` varchar(32) DEFAULT NULL COMMENT '订单ID',
  `is_used` char(1) DEFAULT NULL COMMENT '是否已使用 0未使用 1已使用',
  `used_time` datetime DEFAULT NULL COMMENT '使用时间',
  PRIMARY KEY (`coupon_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='优惠券表';

-- 数据导出被取消选择。
-- 导出  表 trade.trade_goods 结构
CREATE TABLE IF NOT EXISTS `trade_goods` (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `goods_name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `goods_number` int(11) DEFAULT NULL COMMENT '商品库存',
  `goods_price` decimal(10,2) DEFAULT NULL COMMENT '商品价格',
  `goods_desc` varchar(255) DEFAULT NULL COMMENT '商品描述',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

-- 数据导出被取消选择。
-- 导出  表 trade.trade_goods_number_log 结构
CREATE TABLE IF NOT EXISTS `trade_goods_number_log` (
  `goods_id` int(11) NOT NULL COMMENT '商品ID',
  `order_id` varchar(32) NOT NULL COMMENT '订单ID',
  `goods_number` int(11) DEFAULT NULL COMMENT '库存数量',
  `log_time` datetime DEFAULT NULL,
  PRIMARY KEY (`goods_id`,`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库存日志表';

-- 数据导出被取消选择。
-- 导出  表 trade.trade_mq_consumer_log 结构
CREATE TABLE IF NOT EXISTS `trade_mq_consumer_log` (
  `group_name` varchar(255) NOT NULL,
  `msg_tag` varchar(255) NOT NULL,
  `msg_keys` varchar(255) NOT NULL,
  `msg_id` varchar(255) DEFAULT NULL,
  `msg_body` varchar(1024) DEFAULT NULL,
  `consumer_status` varchar(1) DEFAULT NULL,
  `consumer_times` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`group_name`,`msg_tag`,`msg_keys`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 trade.trade_mq_producer_temp 结构
CREATE TABLE IF NOT EXISTS `trade_mq_producer_temp` (
  `group_name` varchar(255) NOT NULL,
  `msg_tag` varchar(255) NOT NULL,
  `msg_keys` varchar(255) NOT NULL,
  `msg_body` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`group_name`,`msg_tag`,`msg_keys`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
-- 导出  表 trade.trade_order 结构
CREATE TABLE IF NOT EXISTS `trade_order` (
  `order_id` varchar(32) NOT NULL COMMENT '订单ID',
  `userid` int(11) DEFAULT NULL COMMENT '用户ID',
  `order_status` char(1) DEFAULT NULL COMMENT '订单状态 0未确认1已确认2无效3退货4退货',
  `pay_status` char(1) DEFAULT NULL COMMENT '支付状态 0未付款1付款中2已付款',
  `shipping_status` char(1) DEFAULT NULL COMMENT '发货状态 0未发货1已发货2已收货',
  `address` varchar(255) DEFAULT NULL COMMENT '收货地址',
  `consignee` varchar(255) DEFAULT NULL COMMENT '收货人',
  `goods_id` int(11) DEFAULT NULL COMMENT '商品ID',
  `goods_number` int(11) DEFAULT NULL COMMENT '商品数量',
  `goods_price` decimal(10,2) DEFAULT NULL COMMENT '商品价格',
  `goods_amount` decimal(10,2) DEFAULT NULL COMMENT '商品总价',
  `shipping_fee` decimal(10,2) DEFAULT NULL COMMENT '运费',
  `order_amount` decimal(10,2) DEFAULT NULL COMMENT '订单价格',
  `coupon_id` varchar(32) DEFAULT NULL COMMENT '优惠券ID',
  `coupon_paid` decimal(10,2) DEFAULT NULL COMMENT '优惠券价格',
  `money_paid` decimal(10,2) DEFAULT NULL COMMENT '已付金额',
  `pay_amount` decimal(10,2) DEFAULT NULL COMMENT '支付金额',
  `add_time` datetime DEFAULT NULL COMMENT '创建时间',
  `confirm_time` datetime DEFAULT NULL COMMENT '订单确认时间',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- 数据导出被取消选择。
-- 导出  表 trade.trade_pay 结构
CREATE TABLE IF NOT EXISTS `trade_pay` (
  `pay_id` varchar(32) NOT NULL COMMENT '支付编号',
  `order_id` varchar(32) DEFAULT NULL COMMENT '订单编号',
  `pay_amount` decimal(10,2) DEFAULT NULL COMMENT '支付金额',
  `is_paid` char(1) DEFAULT NULL COMMENT '是否已支付 0未支付 1已支付',
  PRIMARY KEY (`pay_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='支付表';

-- 数据导出被取消选择。
-- 导出  表 trade.trade_user 结构
CREATE TABLE IF NOT EXISTS `trade_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户姓名',
  `user_password` varchar(255) DEFAULT NULL COMMENT '用户密码',
  `user_mobile` varchar(255) DEFAULT NULL COMMENT '手机号',
  `user_score` int(11) DEFAULT NULL COMMENT '积分',
  `user_reg_time` datetime DEFAULT NULL COMMENT '注册时间',
  `user_money` decimal(10,2) DEFAULT NULL COMMENT '用户余额',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- 数据导出被取消选择。
-- 导出  表 trade.trade_user_money_log 结构
CREATE TABLE IF NOT EXISTS `trade_user_money_log` (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `order_id` varchar(32) NOT NULL COMMENT '订单ID',
  `money_log_type` char(50) DEFAULT NULL COMMENT '日志类型 1订单付款 2订单退款',
  `user_money` decimal(10,2) DEFAULT NULL COMMENT '金额',
  `create_time` datetime DEFAULT NULL COMMENT '日志时间',
  PRIMARY KEY (`user_id`,`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户余额日志';

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
