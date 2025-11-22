-- ----------------------------
-- 品达速运 - 司机管理表
-- ----------------------------
create table pd_driver (
    driver_id             bigint(20)      not null                   comment '司机ID',
    user_id               bigint(20)      default null               comment '关联用户ID',
    driver_no             varchar(50)     not null                   comment '司机编号',
    driver_name           varchar(50)     not null                   comment '司机姓名',
    
    phone                 varchar(20)     not null                   comment '手机号码',
    id_card               varchar(20)     not null                   comment '身份证号',
    
    gender                char(1)         default '0'                comment '性别（0男 1女）',
    birthday              date            default null               comment '出生日期',
    avatar                varchar(500)    default null               comment '头像URL',
    
    -- 工作信息
    dept_id               bigint(20)      not null                   comment '所属部门ID',
    dept_name             varchar(100)    default null               comment '所属部门名称',
    driver_type           char(1)         default '1'                comment '司机类型（1短途 2长途 3市内配送）',
    job_status            char(1)         default '0'                comment '在职状态（0在职 1离职 2休假）',
    
    entry_date            date            default null               comment '入职日期',
    resign_date           date            default null               comment '离职日期',
    
    -- 驾驶证信息
    driver_license_no     varchar(30)     not null                   comment '驾驶证号',
    driver_license_type   varchar(10)     not null                   comment '驾驶证类型（A1/A2/B1/B2/C1等）',
    license_issue_date    date            default null               comment '驾驶证发证日期',
    license_expire_date   date            default null               comment '驾驶证到期日期',
    license_photo         varchar(500)    default null               comment '驾驶证照片URL',
    
    -- 从业资格证
    qualification_no      varchar(50)     default null               comment '从业资格证号',
    qualification_expire_date date        default null               comment '从业资格证到期日期',
    qualification_photo   varchar(500)    default null               comment '从业资格证照片URL',
    
    -- 工作状态
    work_status           char(1)         default '0'                comment '工作状态（0空闲 1配送中 2休息中）',
    online_status         char(1)         default '0'                comment '在线状态（0离线 1在线）',
    current_vehicle_id    bigint(20)      default null               comment '当前车辆ID',
    current_longitude     decimal(10,6)   default null               comment '当前经度',
    current_latitude      decimal(10,6)   default null               comment '当前纬度',
    current_location      varchar(200)    default null               comment '当前位置',
    last_location_time    datetime        default null               comment '最后定位时间',
    
    -- 统计信息
    total_trips           int(11)         default 0                  comment '累计趟次',
    month_trips           int(11)         default 0                  comment '本月趟次',
    total_mileage         decimal(10,2)   default 0.00               comment '累计里程（公里）',
    month_mileage         decimal(10,2)   default 0.00               comment '本月里程（公里）',
    rating_score          decimal(3,2)    default 5.00               comment '评分（满分5分）',
    violation_count       int(11)         default 0                  comment '违规次数',
    accident_count        int(11)         default 0                  comment '事故次数',
    
    -- 设备信息
    device_id             varchar(100)    default null               comment '设备ID',
    device_type           varchar(20)     default null               comment '设备类型',
    app_version           varchar(20)     default null               comment 'APP版本',
    
    -- 紧急联系人
    emergency_contact     varchar(50)     default null               comment '紧急联系人',
    emergency_phone       varchar(20)     default null               comment '紧急联系电话',
    emergency_relation    varchar(20)     default null               comment '紧急联系人关系',
    
    status                char(1)         default '0'                comment '状态（0正常 1停用）',
    del_flag              char(1)         default '0'                comment '删除标志（0代表存在 1代表删除）',
    remark                varchar(500)    default null               comment '备注',
    create_dept           bigint(20)      default null               comment '创建部门',
    create_by             bigint(20)      default null               comment '创建者',
    create_time           datetime                                   comment '创建时间',
    update_by             bigint(20)      default null               comment '更新者',
    update_time           datetime                                   comment '更新时间',
    
    primary key (driver_id),
    unique key uk_driver_no (driver_no),
    unique key uk_phone (phone),
    unique key uk_id_card (id_card),
    unique key uk_driver_license_no (driver_license_no),
    key idx_dept_id (dept_id),
    key idx_work_status (work_status),
    key idx_online_status (online_status)
) engine=innodb comment = '司机管理表';

-- ----------------------------
-- 司机运输任务表
-- ----------------------------
create table pd_driver_task (
    task_id               bigint(20)      not null                   comment '任务ID',
    task_no               varchar(50)     not null                   comment '任务编号',
    
    driver_id             bigint(20)      not null                   comment '司机ID',
    driver_name           varchar(50)     default null               comment '司机姓名',
    vehicle_id            bigint(20)      not null                   comment '车辆ID',
    vehicle_no            varchar(20)     default null               comment '车牌号',
    
    task_type             char(1)         default '1'                comment '任务类型（1揽收运输 2转运 3配送）',
    task_status           char(1)         default '0'                comment '任务状态（0待接单 1已接单 2运输中 3已完成 4已取消）',
    
    -- 路线信息
    start_location        varchar(100)    not null                   comment '起点',
    start_longitude       decimal(10,6)   default null               comment '起点经度',
    start_latitude        decimal(10,6)   default null               comment '起点纬度',
    
    end_location          varchar(100)    not null                   comment '终点',
    end_longitude         decimal(10,6)   default null               comment '终点经度',
    end_latitude          decimal(10,6)   default null               comment '终点纬度',
    
    planned_distance      decimal(10,2)   default 0.00               comment '计划里程（公里）',
    actual_distance       decimal(10,2)   default 0.00               comment '实际里程（公里）',
    
    -- 货物信息
    waybill_count         int(11)         default 0                  comment '运单数量',
    goods_weight          decimal(10,2)   default 0.00               comment '货物总重量（kg）',
    goods_volume          decimal(10,2)   default 0.00               comment '货物总体积（立方米）',
    
    -- 时间信息
    planned_start_time    datetime        default null               comment '计划出发时间',
    planned_arrive_time   datetime        default null               comment '计划到达时间',
    
    accept_time           datetime        default null               comment '接单时间',
    actual_start_time     datetime        default null               comment '实际出发时间',
    actual_arrive_time    datetime        default null               comment '实际到达时间',
    finish_time           datetime        default null               comment '完成时间',
    
    -- 费用信息
    transport_fee         decimal(10,2)   default 0.00               comment '运输费用（元）',
    oil_fee               decimal(10,2)   default 0.00               comment '油费（元）',
    toll_fee              decimal(10,2)   default 0.00               comment '过路费（元）',
    other_fee             decimal(10,2)   default 0.00               comment '其他费用（元）',
    
    remark                varchar(500)    default null               comment '备注',
    del_flag              char(1)         default '0'                comment '删除标志（0代表存在 1代表删除）',
    create_dept           bigint(20)      default null               comment '创建部门',
    create_by             bigint(20)      default null               comment '创建者',
    create_time           datetime                                   comment '创建时间',
    update_by             bigint(20)      default null               comment '更新者',
    update_time           datetime                                   comment '更新时间',
    
    primary key (task_id),
    unique key uk_task_no (task_no),
    key idx_driver_id (driver_id),
    key idx_vehicle_id (vehicle_id),
    key idx_task_status (task_status),
    key idx_planned_start_time (planned_start_time)
) engine=innodb comment = '司机运输任务表';

-- ----------------------------
-- 司机运输任务运单关联表
-- ----------------------------
create table pd_driver_task_waybill (
    id                    bigint(20)      not null                   comment 'ID',
    task_id               bigint(20)      not null                   comment '任务ID',
    waybill_id            bigint(20)      not null                   comment '运单ID',
    waybill_no            varchar(50)     not null                   comment '运单编号',
    
    load_time             datetime        default null               comment '装车时间',
    unload_time           datetime        default null               comment '卸车时间',
    
    create_time           datetime                                   comment '创建时间',
    
    primary key (id),
    key idx_task_id (task_id),
    key idx_waybill_id (waybill_id)
) engine=innodb comment = '司机运输任务运单关联表';

-- ----------------------------
-- 司机GPS轨迹表
-- ----------------------------
create table pd_driver_gps_trace (
    trace_id              bigint(20)      not null                   comment '轨迹ID',
    driver_id             bigint(20)      not null                   comment '司机ID',
    task_id               bigint(20)      default null               comment '任务ID',
    vehicle_id            bigint(20)      default null               comment '车辆ID',
    
    longitude             decimal(10,6)   not null                   comment '经度',
    latitude              decimal(10,6)   not null                   comment '纬度',
    location              varchar(200)    default null               comment '位置描述',
    
    speed                 decimal(6,2)    default 0.00               comment '速度（km/h）',
    direction             int(3)          default 0                  comment '方向角度（0-360）',
    altitude              decimal(8,2)    default 0.00               comment '海拔（米）',
    
    gps_time              datetime        not null                   comment 'GPS时间',
    create_time           datetime                                   comment '创建时间',
    
    primary key (trace_id),
    key idx_driver_id (driver_id),
    key idx_task_id (task_id),
    key idx_gps_time (gps_time)
) engine=innodb comment = '司机GPS轨迹表';

-- ----------------------------
-- 司机考勤表
-- ----------------------------
create table pd_driver_attendance (
    attendance_id         bigint(20)      not null                   comment '考勤ID',
    driver_id             bigint(20)      not null                   comment '司机ID',
    driver_name           varchar(50)     default null               comment '司机姓名',
    
    attendance_date       date            not null                   comment '考勤日期',
    
    clock_in_time         datetime        default null               comment '上班打卡时间',
    clock_in_longitude    decimal(10,6)   default null               comment '上班打卡经度',
    clock_in_latitude     decimal(10,6)   default null               comment '上班打卡纬度',
    clock_in_location     varchar(200)    default null               comment '上班打卡地址',
    
    clock_out_time        datetime        default null               comment '下班打卡时间',
    clock_out_longitude   decimal(10,6)   default null               comment '下班打卡经度',
    clock_out_latitude    decimal(10,6)   default null               comment '下班打卡纬度',
    clock_out_location    varchar(200)    default null               comment '下班打卡地址',
    
    work_hours            decimal(5,2)    default 0.00               comment '工作时长（小时）',
    drive_hours           decimal(5,2)    default 0.00               comment '驾驶时长（小时）',
    
    attendance_status     char(1)         default '0'                comment '考勤状态（0正常 1迟到 2早退 3缺勤 4请假）',
    
    remark                varchar(500)    default null               comment '备注',
    create_time           datetime                                   comment '创建时间',
    
    primary key (attendance_id),
    key idx_driver_id (driver_id),
    key idx_attendance_date (attendance_date)
) engine=innodb comment = '司机考勤表';
