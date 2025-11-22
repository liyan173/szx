-- ----------------------------
-- 品达速运 - 车辆管理表
-- ----------------------------
create table pd_vehicle (
    vehicle_id            bigint(20)      not null                   comment '车辆ID',
    vehicle_no            varchar(20)     not null                   comment '车牌号',
    vehicle_code          varchar(50)     not null                   comment '车辆编号',
    
    -- 车辆基本信息
    vehicle_type          char(1)         default '1'                comment '车辆类型（1厢式货车 2平板货车 3冷藏车 4危险品车）',
    vehicle_brand         varchar(50)     default null               comment '车辆品牌',
    vehicle_model         varchar(50)     default null               comment '车型',
    vehicle_color         varchar(20)     default null               comment '车辆颜色',
    
    vin                   varchar(30)     default null               comment '车架号（VIN）',
    engine_no             varchar(30)     default null               comment '发动机号',
    
    purchase_date         date            default null               comment '购买日期',
    manufacture_date      date            default null               comment '出厂日期',
    register_date         date            default null               comment '注册日期',
    
    -- 车辆规格
    load_capacity         decimal(10,2)   default 0.00               comment '载重（吨）',
    volume_capacity       decimal(10,2)   default 0.00               comment '容积（立方米）',
    seat_count            int(2)          default 2                  comment '座位数',
    
    length                decimal(6,2)    default 0.00               comment '车长（米）',
    width                 decimal(6,2)    default 0.00               comment '车宽（米）',
    height                decimal(6,2)    default 0.00               comment '车高（米）',
    
    -- 证件信息
    vehicle_license_no    varchar(50)     default null               comment '行驶证号',
    license_expire_date   date            default null               comment '行驶证到期日期',
    license_photo         varchar(500)    default null               comment '行驶证照片URL',
    
    operation_license_no  varchar(50)     default null               comment '道路运输证号',
    operation_expire_date date            default null               comment '道路运输证到期日期',
    operation_photo       varchar(500)    default null               comment '道路运输证照片URL',
    
    insurance_no          varchar(50)     default null               comment '保险单号',
    insurance_company     varchar(100)    default null               comment '保险公司',
    insurance_expire_date date            default null               comment '保险到期日期',
    insurance_photo       varchar(500)    default null               comment '保险单照片URL',
    
    -- 使用信息
    dept_id               bigint(20)      not null                   comment '所属部门ID',
    dept_name             varchar(100)    default null               comment '所属部门名称',
    
    current_driver_id     bigint(20)      default null               comment '当前司机ID',
    current_driver_name   varchar(50)     default null               comment '当前司机姓名',
    
    vehicle_status        char(1)         default '0'                comment '车辆状态（0空闲 1使用中 2维修中 3报废）',
    use_status            char(1)         default '0'                comment '使用状态（0可用 1在途 2维修 3停用）',
    
    -- 位置信息
    current_location      varchar(200)    default null               comment '当前位置',
    current_longitude     decimal(10,6)   default null               comment '当前经度',
    current_latitude      decimal(10,6)   default null               comment '当前纬度',
    last_location_time    datetime        default null               comment '最后定位时间',
    
    -- 统计信息
    total_mileage         decimal(10,2)   default 0.00               comment '总行驶里程（公里）',
    month_mileage         decimal(10,2)   default 0.00               comment '本月行驶里程（公里）',
    total_trips           int(11)         default 0                  comment '累计趟次',
    month_trips           int(11)         default 0                  comment '本月趟次',
    
    last_maintenance_date date            default null               comment '上次保养日期',
    last_maintenance_mileage decimal(10,2) default 0.00              comment '上次保养里程',
    next_maintenance_date date            default null               comment '下次保养日期',
    next_maintenance_mileage decimal(10,2) default 0.00              comment '下次保养里程',
    
    last_inspection_date  date            default null               comment '上次年检日期',
    next_inspection_date  date            default null               comment '下次年检日期',
    
    -- 设备信息
    gps_device_id         varchar(100)    default null               comment 'GPS设备ID',
    gps_device_type       varchar(50)     default null               comment 'GPS设备型号',
    gps_install_date      date            default null               comment 'GPS安装日期',
    
    status                char(1)         default '0'                comment '状态（0正常 1停用）',
    del_flag              char(1)         default '0'                comment '删除标志（0代表存在 1代表删除）',
    remark                varchar(500)    default null               comment '备注',
    create_dept           bigint(20)      default null               comment '创建部门',
    create_by             bigint(20)      default null               comment '创建者',
    create_time           datetime                                   comment '创建时间',
    update_by             bigint(20)      default null               comment '更新者',
    update_time           datetime                                   comment '更新时间',
    
    primary key (vehicle_id),
    unique key uk_vehicle_no (vehicle_no),
    unique key uk_vehicle_code (vehicle_code),
    key idx_dept_id (dept_id),
    key idx_vehicle_status (vehicle_status),
    key idx_current_driver (current_driver_id)
) engine=innodb comment = '车辆管理表';

-- ----------------------------
-- 车辆保养记录表
-- ----------------------------
create table pd_vehicle_maintenance (
    maintenance_id        bigint(20)      not null                   comment '保养ID',
    vehicle_id            bigint(20)      not null                   comment '车辆ID',
    vehicle_no            varchar(20)     not null                   comment '车牌号',
    
    maintenance_type      char(1)         not null                   comment '保养类型（1日常保养 2一级保养 3二级保养 4大修）',
    maintenance_date      date            not null                   comment '保养日期',
    maintenance_mileage   decimal(10,2)   default 0.00               comment '保养时里程（公里）',
    
    maintenance_location  varchar(200)    default null               comment '保养地点',
    maintenance_company   varchar(100)    default null               comment '保养单位',
    
    maintenance_items     varchar(1000)   default null               comment '保养项目',
    maintenance_cost      decimal(10,2)   default 0.00               comment '保养费用（元）',
    
    parts_replaced        varchar(1000)   default null               comment '更换配件',
    parts_cost            decimal(10,2)   default 0.00               comment '配件费用（元）',
    
    handler_id            bigint(20)      default null               comment '经办人ID',
    handler_name          varchar(50)     default null               comment '经办人姓名',
    
    next_maintenance_date date            default null               comment '下次保养日期',
    next_maintenance_mileage decimal(10,2) default 0.00              comment '下次保养里程',
    
    invoice_no            varchar(50)     default null               comment '发票号',
    invoice_photo         varchar(500)    default null               comment '发票照片URL',
    
    remark                varchar(500)    default null               comment '备注',
    create_dept           bigint(20)      default null               comment '创建部门',
    create_by             bigint(20)      default null               comment '创建者',
    create_time           datetime                                   comment '创建时间',
    update_by             bigint(20)      default null               comment '更新者',
    update_time           datetime                                   comment '更新时间',
    
    primary key (maintenance_id),
    key idx_vehicle_id (vehicle_id),
    key idx_maintenance_date (maintenance_date)
) engine=innodb comment = '车辆保养记录表';

-- ----------------------------
-- 车辆维修记录表
-- ----------------------------
create table pd_vehicle_repair (
    repair_id             bigint(20)      not null                   comment '维修ID',
    vehicle_id            bigint(20)      not null                   comment '车辆ID',
    vehicle_no            varchar(20)     not null                   comment '车牌号',
    
    repair_type           char(1)         not null                   comment '维修类型（1故障维修 2事故维修 3定期检修）',
    repair_date           date            not null                   comment '维修日期',
    repair_start_time     datetime        default null               comment '维修开始时间',
    repair_end_time       datetime        default null               comment '维修结束时间',
    
    fault_desc            varchar(1000)   default null               comment '故障描述',
    fault_location        varchar(200)    default null               comment '故障发生地点',
    fault_time            datetime        default null               comment '故障发生时间',
    
    repair_location       varchar(200)    default null               comment '维修地点',
    repair_company        varchar(100)    default null               comment '维修单位',
    
    repair_items          varchar(1000)   default null               comment '维修项目',
    parts_replaced        varchar(1000)   default null               comment '更换配件',
    
    labor_cost            decimal(10,2)   default 0.00               comment '工时费（元）',
    parts_cost            decimal(10,2)   default 0.00               comment '配件费（元）',
    other_cost            decimal(10,2)   default 0.00               comment '其他费用（元）',
    total_cost            decimal(10,2)   default 0.00               comment '总费用（元）',
    
    handler_id            bigint(20)      default null               comment '经办人ID',
    handler_name          varchar(50)     default null               comment '经办人姓名',
    
    invoice_no            varchar(50)     default null               comment '发票号',
    invoice_photo         varchar(500)    default null               comment '发票照片URL',
    
    repair_status         char(1)         default '0'                comment '维修状态（0待维修 1维修中 2已完成）',
    
    remark                varchar(500)    default null               comment '备注',
    create_dept           bigint(20)      default null               comment '创建部门',
    create_by             bigint(20)      default null               comment '创建者',
    create_time           datetime                                   comment '创建时间',
    update_by             bigint(20)      default null               comment '更新者',
    update_time           datetime                                   comment '更新时间',
    
    primary key (repair_id),
    key idx_vehicle_id (vehicle_id),
    key idx_repair_date (repair_date),
    key idx_repair_status (repair_status)
) engine=innodb comment = '车辆维修记录表';

-- ----------------------------
-- 车辆年检记录表
-- ----------------------------
create table pd_vehicle_inspection (
    inspection_id         bigint(20)      not null                   comment '年检ID',
    vehicle_id            bigint(20)      not null                   comment '车辆ID',
    vehicle_no            varchar(20)     not null                   comment '车牌号',
    
    inspection_date       date            not null                   comment '年检日期',
    inspection_type       char(1)         default '1'                comment '年检类型（1年检 2二次检测）',
    inspection_result     char(1)         default '0'                comment '年检结果（0合格 1不合格）',
    
    inspection_location   varchar(200)    default null               comment '检测站点',
    inspection_no         varchar(50)     default null               comment '检测单号',
    
    next_inspection_date  date            default null               comment '下次年检日期',
    
    inspection_cost       decimal(10,2)   default 0.00               comment '年检费用（元）',
    
    handler_id            bigint(20)      default null               comment '经办人ID',
    handler_name          varchar(50)     default null               comment '经办人姓名',
    
    certificate_photo     varchar(500)    default null               comment '合格证照片URL',
    
    remark                varchar(500)    default null               comment '备注',
    create_dept           bigint(20)      default null               comment '创建部门',
    create_by             bigint(20)      default null               comment '创建者',
    create_time           datetime                                   comment '创建时间',
    update_by             bigint(20)      default null               comment '更新者',
    update_time           datetime                                   comment '更新时间',
    
    primary key (inspection_id),
    key idx_vehicle_id (vehicle_id),
    key idx_inspection_date (inspection_date)
) engine=innodb comment = '车辆年检记录表';

-- ----------------------------
-- 车辆油耗记录表
-- ----------------------------
create table pd_vehicle_fuel (
    fuel_id               bigint(20)      not null                   comment '油耗ID',
    vehicle_id            bigint(20)      not null                   comment '车辆ID',
    vehicle_no            varchar(20)     not null                   comment '车牌号',
    driver_id             bigint(20)      default null               comment '司机ID',
    driver_name           varchar(50)     default null               comment '司机姓名',
    
    fuel_date             date            not null                   comment '加油日期',
    fuel_time             datetime        default null               comment '加油时间',
    
    fuel_type             char(1)         default '1'                comment '油品类型（1汽油92# 2汽油95# 3柴油 4其他）',
    fuel_volume           decimal(10,2)   not null                   comment '加油量（升）',
    fuel_price            decimal(10,2)   not null                   comment '油价（元/升）',
    fuel_amount           decimal(10,2)   not null                   comment '加油金额（元）',
    
    current_mileage       decimal(10,2)   default 0.00               comment '当前里程（公里）',
    last_mileage          decimal(10,2)   default 0.00               comment '上次里程（公里）',
    mileage_diff          decimal(10,2)   default 0.00               comment '里程差（公里）',
    fuel_consumption      decimal(10,2)   default 0.00               comment '油耗（升/百公里）',
    
    fuel_station          varchar(200)    default null               comment '加油站',
    fuel_location         varchar(200)    default null               comment '加油地点',
    
    payment_method        char(1)         default '1'                comment '支付方式（1现金 2油卡 3对公账户）',
    invoice_no            varchar(50)     default null               comment '发票号',
    invoice_photo         varchar(500)    default null               comment '发票照片URL',
    
    handler_id            bigint(20)      default null               comment '经办人ID',
    handler_name          varchar(50)     default null               comment '经办人姓名',
    
    remark                varchar(500)    default null               comment '备注',
    create_dept           bigint(20)      default null               comment '创建部门',
    create_by             bigint(20)      default null               comment '创建者',
    create_time           datetime                                   comment '创建时间',
    update_by             bigint(20)      default null               comment '更新者',
    update_time           datetime                                   comment '更新时间',
    
    primary key (fuel_id),
    key idx_vehicle_id (vehicle_id),
    key idx_driver_id (driver_id),
    key idx_fuel_date (fuel_date)
) engine=innodb comment = '车辆油耗记录表';
