CREATE TABLE product_info (
product_id VARCHAR(32) NOT NULL,
product_name VARCHAR(64) NOT NULL COMMENT "商品名称",
product_price  DECIMAL(8,2) NOT NULL COMMENT "单价",
product_stock INT NOT NULL COMMENT "库存",
product_description VARCHAR(64) COMMENT "描述",
category_type INT NOT 	NULL COMMENT "类目编号",
create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
update_time  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT "更新时间"

) COMMENT "商品表";


CREATE TABLE product_category(
	category_name VARCHAR(64) NOT NULL COMMENT "类目名字",
	category_id INT NOT NULL AUTO_INCREMENT,
	create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
	update_time  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT "更新时间",
	PRIMARY KEY (category_id),
	UNIQUE KEY upe_category_type (category_type),
	category_type INT NOT NULL COMMENT "类目编号"
) COMMENT "类目表"

CREATE TABLE order_master(
	order_id VARCHAR(32) NOT NULL,
	buyer_name VARCHAR(32) NOT NULL COMMENT "买家名字",
	buyer_phonr VARCHAR(32) NOT NULL COMMENT "买家电话",
	buter_address VARCHAR(128) NOT NULL COMMENT "卖家地址",
	buyer_openid VARCHAR(64) NOT NULL COMMENT "买家微信openid",
	order_amount DECIMAL(8,2) NOT NULL COMMENT "订单总金额",
	order_status TINYINT(3) NOT NULL  DEFAULT 0  COMMENT "订单状态  0 新订单",
	pay_status TINYINT(3) NOT NULL DEFAULT 0 COMMENT "支付状态 0未支付",
	create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT "创建时间",
	update_time  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT "更新时间",
	PRIMARY KEY(order_id),
	KEY idx_buyer_openid (buyer_openid)
) COMMENT "订单表"
