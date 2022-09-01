create database pos;
use pos;

create table config_payments (
	payment_uid			int auto_increment	primary key,
    payment_id			varchar(20) not null unique key,
    name				varchar(20) not null,
    is_default			boolean not null
);
insert into config_payments (payment_id, name, is_default)
values ('cash', '現金', 1),
		('credit-card', '信用卡', 0),
		('member-point', '會員點數', 0),
		('stored-cash', '儲值金', 0);

create table config_product_catagorys (
	catagory_uid		int auto_increment	primary key,
    catagory_id			varchar(20) not null unique key,
    name				varchar(20) not null
);

create table config_member_levels (
	level_uid			int auto_increment	primary key,
    level_id			varchar(20) not null unique key,
    name				varchar(20) not null,
    is_default			boolean not null
);

create table venders (
	vender_uid			int auto_increment primary key,
    vender_id			varchar(20) not null unique key,
    name				varchar(20) not null
);

create table stores (
	store_uid			int auto_increment primary key,
	store_id			varchar(20) not null unique key,
    name				varchar(20) not null,
    cashbox				int not null
);

create table members (
	member_uid			int auto_increment	primary key,
    member_id			varchar(20) not null unique key,
    name				varchar(20) not null,
    level_uid			int not null,
    mobile_no			char(10) not null,
    email				varchar(50),
    address				varchar(50),
    stored_cash			int not null,
    member_point		int not null,
    note				varchar(100),
    foreign key(level_uid) references config_member_levels(level_uid)
);

create table products (
	product_uid			int auto_increment	primary key,
    product_id			varchar(20) not null unique key,
    name				varchar(20) not null,
    catagory_uid		int not null,
    is_service			bool not null,
    allow_sell_insufficient	bool not null,
    is_conbination		bool not null,
    is_invalid			bool not null,
    is_deleted			bool not null,
    note				varchar(100),
    foreign key(catagory_uid) references config_product_catagorys(catagory_uid)
);

create table product_quantitys (
	product_quantity_uid int auto_increment	primary key,
	store_uid			int not null,
    product_uid			int not null,
    quantity			int not null,
    foreign key(store_uid) references stores(store_uid),
    foreign key(product_uid) references products(product_uid)
);

create table product_prices (
	product_price_uid	int auto_increment	primary key,
	product_uid			int not null,
    level_uid			int not null,
    price				int not null,
    foreign key(product_uid) references products(product_uid),
    foreign key(level_uid) references config_member_levels(level_uid)
);

create table product_barcodes (
	product_barcode_uid int auto_increment	primary key,
	product_uid			int not null,
    barcode				varchar(20) not null,
    foreign key(product_uid) references products(product_uid),
    unique(product_uid, barcode)
);

create table product_venders (
	product_vender_uid	int auto_increment	primary key,
	product_uid			int not null,
    vender_uid			int not null,
    foreign key(product_uid) references products(product_uid),
    foreign key(vender_uid) references venders(vender_uid)
);

create table product_combinations (
	product_combination_uid	int auto_increment	primary key,
	product_uid			int not null,
    content_product_uid	int not null,
    quantity			int not null,
    foreign key(product_uid) references products(product_uid),
    foreign key(content_product_uid) references products(product_uid)
);

create table exchange_orders (
	exchange_uid		int auto_increment	primary key,
    store_uid			int not null,
    vender_uid			int not null,
    create_datetime		datetime not null,
    vender_took			boolean not null,
    vender_took_datetime datetime,
    closed				boolean not null,
    note				varchar(100),
    foreign key(store_uid) references stores(store_uid),
    foreign key(vender_uid) references venders(vender_uid)    
);

create table exchange_order_details (
	exchange_detail_uid	int auto_increment	primary key,
    exchange_uid		int not null,
    product_uid			int not null,
    exchange_quantity	int not null,
    receive_quantity	int not null,
    note				varchar(100),
    foreign key(exchange_uid) references exchange_orders(exchange_uid),
    foreign key(product_uid) references products(product_uid)    
);

create table exhcange_order_receipts (
	exchange_receipt_uid int auto_increment	primary key,
    exchange_uid		int not null,
    product_uid			int not null,
    quantity			int not null,
    create_datetime		datetime not null,
    foreign key(exchange_uid) references exchange_orders(exchange_uid),
    foreign key(product_uid) references products(product_uid)   
);

create table cash_active_orders (
	cash_active_uid		int auto_increment	primary key,
    store_uid			int not null,
    action				enum('deposit', 'withdraw') not null,
    cash				int not null,
    create_datetime		datetime not null,
    note				varchar(100) not null,
    foreign key(store_uid) references stores(store_uid)
);

create table quantity_adjust_orders (
	quantity_adjust_uid int auto_increment	primary key,
    store_uid			int not null,
    create_datetime		datetime not null,
    is_approved			bool,
    is_approve_datetime	datetime,
    note				varchar(100),
    foreign key(store_uid) references stores(store_uid)
);

create table quantity_adjust_order_details (
	quantity_adjust_detail_uid	int auto_increment	primary key,
    quantity_adjust_uid	int not null,
    product_uid			int not null,
    system_quantity		int not null,
    actual_quantity		int not null,
    note				varchar(100),
    foreign key(quantity_adjust_uid) references quantity_adjust_orders(quantity_adjust_uid),
    foreign key(product_uid) references products(product_uid)
);

create table delivery_orders (
	delivery_uid		int auto_increment	primary key,
    src_store_uid		int not null,
    dst_store_uid		int not null,
    create_datetime		datetime not null,
    is_packed			bool,
    pack_datetie		datetime,
    closed				bool,
    close_datetime		datetime,
    note				varchar(100),
    foreign key(src_store_uid) references stores(store_uid),
    foreign key(dst_store_uid) references stores(store_uid)
);

create table delivery_order_details (
	delivery_detail_uid	int auto_increment	primary key,
    delivery_uid		int not null,
    product_uid			int not null,
    delivery_quantity	int not null,
    receive_quantity	int not null,
    foreign key(delivery_uid) references delivery_orders(delivery_uid),
    foreign key(product_uid) references products(product_uid)
);

create table purchase_orders (
	purchase_uid		int auto_increment	primary key,
    vender_uid			int not null,
    create_datetime		datetime not null,
	foreign key(vender_uid) references venders(vender_uid)
);

create table purchase_order_details (
	purchase_detail_uid	int auto_increment	primary key,
    purchase_uid		int not null,
    product_name		varchar(20) not null,
    quantity			int not null,
	foreign key(purchase_uid) references purchase_orders(purchase_uid)
);

create table stockin_orders (
	stockin_uid			int auto_increment	primary key,
    store_uid			int not null,
    vender_uid			int not null,
    create_datetime		datetime not null,
    foreign key(store_uid) references stores(store_uid),
    foreign key(vender_uid) references venders(vender_uid)
);

create table stockin_order_details (
	stockin_detail_uid	int auto_increment	primary key,
    stockin_uid			int not null,
    product_uid			int not null,
    total_quantity		int not null,
    total_price			int not null,
    expired_date		date not null,
    foreign key(stockin_uid) references stockin_orders(stockin_uid),
    foreign key(product_uid) references products(product_uid)
);

create table sell_orders (
	sell_uid			int auto_increment	primary key,
    store_uid			int not null,
    member_uid			int not null,
    create_datetime		datetime not null,
    total_price			int not null,
    closed				bool not null,
    is_invalid			bool not null,
    invalid_datetime	datetime,
    foreign key(store_uid) references stores(store_uid),
    foreign key(member_uid) references members(member_uid)
);

create table sell_order_details (
	sell_detail_uid		int auto_increment	primary key,
    sell_uid			int not null,
    product_uid			int not null,
    quantity			int not null,
    level				varchar(20) not null,
    level_price			int not null,
    foreign key(sell_uid) references sell_orders(sell_uid),
    foreign key(product_uid) references products(product_uid)
);

create table sell_order_payments (
	sell_payment_uid	int auto_increment	primary key,
    sell_uid			int not null,
    payment_uid			int not null,
    price				int not null,
    create_datetime		datetime not null,
    foreign key(sell_uid) references sell_orders(sell_uid),
    foreign key(payment_uid) references config_payments(payment_uid)
);

create table destory_orders (
	destory_uid			int auto_increment	primary key,
    store_uid			int not null,
    create_datetime		datetime not null,
    is_approved			bool,
    note				varchar(100),
    foreign key(store_uid) references stores(store_uid)
);

create table destory_order_details (
	destory_detail_uid	int auto_increment	primary key,
    destory_uid			int not null,
    product_uid			int not null,
    quantity			int not null,
    note				varchar(100),
    foreign key(destory_uid) references destory_orders(destory_uid),
    foreign key(product_uid) references products(product_uid)
);

create table stored_cash_orders (
	stored_cash_uid		int auto_increment	primary key,
    member_uid			int not null,
    current_cash		int not null,
    store_cash			int not null,
    create_datetime		datetime not null,
    foreign key(member_uid) references members(member_uid)
);