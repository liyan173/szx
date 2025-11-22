-- ----------------------------
-- 品达速运 - 订单管理表
-- ----------------------------
create table pd_order (
    order_id              bigint(20)      not null                   comment '订单ID',
    order_no              varchar(50)     not null                   comment '订单编号',
    user_id               bigint(20)      not null                   comment '用户ID',
    order_type            char(1)         default '1'                comment '订单类型（1普通件 2特快件 3贵重物品）',
    order_status          char(1)         default '0'                comment '订单状态（0待支付 1待取件 2运输中 3派送中 4已签收 5已取消）',
    
    -- 寄件人信息
    sender_name           varchar(50)     not null                   comment '寄件人姓名',
    sender_phone          varchar(20)     not null                   comment '寄件人电话',
    sender_province       varchar(50)     not null                   comment '寄件省份',
    sender_city           varchar(50)     not null                   comment '寄件城市',
    sender_district       varchar(50)     not null                   comment '寄件区县',
    sender_address        varchar(255)    not null                   comment '寄件详细地址',
    sender_longitude      decimal(10,6)   default null               comment '寄件经度',
    sender_latitude       decimal(10,6)   default null               comment '寄件纬度',
    
    -- 收件人信息
    receiver_name         varchar(50)     not null                   comment '收件人姓名',
    receiver_phone        varchar(20)     not null                   comment '收件人电话',
    receiver_province     varchar(50)     not null                   comment '收件省份',
    receiver_city         varchar(50)     not null                   comment '收件城市',
    receiver_district     varchar(50)     not null                   comment '收件区县',
    receiver_address      varchar(255)    not null                   comment '收件详细地址',
    receiver_longitude    decimal(10,6)   default null               comment '收件经度',
    receiver_latitude     decimal(10,6)   default null               comment '收件纬度',
    
    -- 物品信息
    goods_name            varchar(100)    default null               comment '物品名称',
    goods_weight          decimal(10,2)   default 0.00               comment '物品重量（kg）',
    goods_volume          decimal(10,2)   default 0.00               comment '物品体积（立方米）',
    goods_count           int(4)          default 1                  comment '物品数量',
    goods_value           decimal(10,2)   default 0.00               comment '物品价值（元）',
    
    -- 费用信息
    freight_fee           decimal(10,2)   default 0.00               comment '运费（元）',
    insurance_fee         decimal(10,2)   default 0.00               comment '保价费（元）',
    package_fee           decimal(10,2)   default 0.00               comment '包装费（元）',
    total_fee             decimal(10,2)   default 0.00               comment '总费用（元）',
    payment_method        char(1)         default '1'                comment '支付方式（1在线支付 2货到付款）',
    payment_status        char(1)         default '0'                comment '支付状态（0未支付 1已支付 2已退款）',
    payment_time          datetime        default null               comment '支付时间',
    
    -- 时间信息
    estimated_pickup_time datetime        default null               comment '预计取件时间',
    actual_pickup_time    datetime        default null               comment '实际取件时间',
    estimated_delivery_time datetime      default null               comment '预计送达时间',
    actual_delivery_time  datetime        default null               comment '实际送达时间',
    
    -- 业务关联
    courier_id            bigint(20)      default null               comment '取件快递员ID',
    delivery_courier_id   bigint(20)      default null               comment '派件快递员ID',
    waybill_id            bigint(20)      default null               comment '运单ID',
    
    remark                varchar(500)    default null               comment '备注',
    del_flag              char(1)         default '0'                comment '删除标志（0代表存在 1代表删除）',
    create_dept           bigint(20)      default null               comment '创建部门',
    create_by             bigint(20)      default null               comment '创建者',
    create_time           datetime                                   comment '创建时间',
    update_by             bigint(20)      default null               comment '更新者',
    update_time           datetime                                   comment '更新时间',
    
    primary key (order_id),
    unique key uk_order_no (order_no),
    key idx_user_id (user_id),
    key idx_order_status (order_status),
    key idx_create_time (create_time)
) engine=innodb comment = '订单管理表';

-- ----------------------------
-- 订单状态流转记录表
-- ----------------------------
create table pd_order_status_log (
    log_id                bigint(20)      not null                   comment '日志ID',
    order_id              bigint(20)      not null                   comment '订单ID',
    order_no              varchar(50)     not null                   comment '订单编号',
    status_before         char(1)         default null               comment '变更前状态',
    status_after          char(1)         not null                   comment '变更后状态',
    operator_id           bigint(20)      default null               comment '操作人ID',
    operator_name         varchar(50)     default null               comment '操作人姓名',
    operator_type         char(1)         default '1'                comment '操作人类型（1客户 2快递员 3司机 4系统）',
    remark                varchar(500)    default null               comment '备注',
    create_time           datetime                                   comment '创建时间',
    
    primary key (log_id),
    key idx_order_id (order_id),
    key idx_order_no (order_no),
    key idx_create_time (create_time)
) engine=innodb comment = '订单状态流转记录表';
