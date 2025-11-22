-- ----------------------------
-- 品达速运 - 运单管理表
-- ----------------------------
create table pd_waybill (
    waybill_id            bigint(20)      not null                   comment '运单ID',
    waybill_no            varchar(50)     not null                   comment '运单编号',
    order_id              bigint(20)      not null                   comment '关联订单ID',
    order_no              varchar(50)     not null                   comment '订单编号',
    
    waybill_status        char(1)         default '0'                comment '运单状态（0待取件 1已取件 2运输中 3派送中 4已签收 5异常 6已取消）',
    transport_type        char(1)         default '1'                comment '运输方式（1陆运 2空运 3铁路）',
    
    -- 路线信息
    start_city            varchar(50)     not null                   comment '始发城市',
    end_city              varchar(50)     not null                   comment '目的城市',
    current_location      varchar(100)    default null               comment '当前位置',
    current_longitude     decimal(10,6)   default null               comment '当前经度',
    current_latitude      decimal(10,6)   default null               comment '当前纬度',
    
    -- 承运信息
    pickup_courier_id     bigint(20)      default null               comment '取件快递员ID',
    pickup_courier_name   varchar(50)     default null               comment '取件快递员姓名',
    pickup_time           datetime        default null               comment '取件时间',
    
    delivery_courier_id   bigint(20)      default null               comment '派件快递员ID',
    delivery_courier_name varchar(50)     default null               comment '派件快递员姓名',
    delivery_time         datetime        default null               comment '派件时间',
    
    driver_id             bigint(20)      default null               comment '当前司机ID',
    driver_name           varchar(50)     default null               comment '当前司机姓名',
    vehicle_id            bigint(20)      default null               comment '当前车辆ID',
    vehicle_no            varchar(20)     default null               comment '当前车牌号',
    
    -- 签收信息
    sign_type             char(1)         default '1'                comment '签收类型（1本人签收 2代签 3快递柜）',
    sign_person           varchar(50)     default null               comment '签收人',
    sign_time             datetime        default null               comment '签收时间',
    sign_img              varchar(500)    default null               comment '签收图片URL',
    
    -- 异常信息
    exception_type        char(1)         default null               comment '异常类型（1破损 2丢失 3延误 4拒收 5其他）',
    exception_desc        varchar(500)    default null               comment '异常描述',
    exception_time        datetime        default null               comment '异常发生时间',
    exception_handler     bigint(20)      default null               comment '异常处理人ID',
    exception_status      char(1)         default null               comment '异常状态（0待处理 1处理中 2已解决）',
    
    remark                varchar(500)    default null               comment '备注',
    del_flag              char(1)         default '0'                comment '删除标志（0代表存在 1代表删除）',
    create_dept           bigint(20)      default null               comment '创建部门',
    create_by             bigint(20)      default null               comment '创建者',
    create_time           datetime                                   comment '创建时间',
    update_by             bigint(20)      default null               comment '更新者',
    update_time           datetime                                   comment '更新时间',
    
    primary key (waybill_id),
    unique key uk_waybill_no (waybill_no),
    key idx_order_id (order_id),
    key idx_waybill_status (waybill_status),
    key idx_pickup_courier (pickup_courier_id),
    key idx_delivery_courier (delivery_courier_id),
    key idx_driver (driver_id),
    key idx_create_time (create_time)
) engine=innodb comment = '运单管理表';

-- ----------------------------
-- 运单轨迹表
-- ----------------------------
create table pd_waybill_trace (
    trace_id              bigint(20)      not null                   comment '轨迹ID',
    waybill_id            bigint(20)      not null                   comment '运单ID',
    waybill_no            varchar(50)     not null                   comment '运单编号',
    
    trace_type            char(1)         not null                   comment '节点类型（1揽收 2运输 3派送 4签收 5异常）',
    trace_status          varchar(50)     not null                   comment '状态描述',
    trace_desc            varchar(500)    default null               comment '详细描述',
    
    location              varchar(100)    default null               comment '位置',
    longitude             decimal(10,6)   default null               comment '经度',
    latitude              decimal(10,6)   default null               comment '纬度',
    
    operator_id           bigint(20)      default null               comment '操作人ID',
    operator_name         varchar(50)     default null               comment '操作人姓名',
    operator_type         char(1)         default null               comment '操作人类型（1快递员 2司机 3系统）',
    
    trace_time            datetime        not null                   comment '发生时间',
    create_time           datetime                                   comment '创建时间',
    
    primary key (trace_id),
    key idx_waybill_id (waybill_id),
    key idx_waybill_no (waybill_no),
    key idx_trace_time (trace_time)
) engine=innodb comment = '运单轨迹表';

-- ----------------------------
-- 运单中转记录表
-- ----------------------------
create table pd_waybill_transfer (
    transfer_id           bigint(20)      not null                   comment '中转ID',
    waybill_id            bigint(20)      not null                   comment '运单ID',
    waybill_no            varchar(50)     not null                   comment '运单编号',
    
    transfer_station      varchar(100)    not null                   comment '中转站点',
    transfer_type         char(1)         default '1'                comment '中转类型（1分拨中心 2转运中心 3配送站）',
    
    arrival_time          datetime        default null               comment '到达时间',
    departure_time        datetime        default null               comment '发出时间',
    
    from_driver_id        bigint(20)      default null               comment '来源司机ID',
    from_vehicle_id       bigint(20)      default null               comment '来源车辆ID',
    to_driver_id          bigint(20)      default null               comment '目的司机ID',
    to_vehicle_id         bigint(20)      default null               comment '目的车辆ID',
    
    handler_id            bigint(20)      default null               comment '操作人ID',
    handler_name          varchar(50)     default null               comment '操作人姓名',
    
    remark                varchar(500)    default null               comment '备注',
    create_time           datetime                                   comment '创建时间',
    
    primary key (transfer_id),
    key idx_waybill_id (waybill_id),
    key idx_waybill_no (waybill_no),
    key idx_transfer_station (transfer_station)
) engine=innodb comment = '运单中转记录表';
