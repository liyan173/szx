-- ----------------------------
-- 品达速运 - 快递员管理表
-- ----------------------------
create table pd_courier (
    courier_id            bigint(20)      not null                   comment '快递员ID',
    user_id               bigint(20)      default null               comment '关联用户ID',
    courier_no            varchar(50)     not null                   comment '快递员编号',
    courier_name          varchar(50)     not null                   comment '快递员姓名',
    
    phone                 varchar(20)     not null                   comment '手机号码',
    id_card               varchar(20)     not null                   comment '身份证号',
    
    gender                char(1)         default '0'                comment '性别（0男 1女）',
    birthday              date            default null               comment '出生日期',
    avatar                varchar(500)    default null               comment '头像URL',
    
    -- 工作信息
    dept_id               bigint(20)      not null                   comment '所属网点ID',
    dept_name             varchar(100)    default null               comment '所属网点名称',
    courier_type          char(1)         default '1'                comment '快递员类型（1取件员 2派件员 3全职）',
    job_status            char(1)         default '0'                comment '在职状态（0在职 1离职 2休假）',
    
    entry_date            date            default null               comment '入职日期',
    resign_date           date            default null               comment '离职日期',
    
    -- 服务区域
    service_province      varchar(50)     default null               comment '服务省份',
    service_city          varchar(50)     default null               comment '服务城市',
    service_district      varchar(50)     default null               comment '服务区县',
    service_area          varchar(500)    default null               comment '服务区域详细描述',
    
    -- 工作状态
    work_status           char(1)         default '0'                comment '工作状态（0空闲 1工作中 2休息中）',
    online_status         char(1)         default '0'                comment '在线状态（0离线 1在线）',
    current_longitude     decimal(10,6)   default null               comment '当前经度',
    current_latitude      decimal(10,6)   default null               comment '当前纬度',
    last_location_time    datetime        default null               comment '最后定位时间',
    
    -- 统计信息
    total_orders          int(11)         default 0                  comment '累计订单数',
    month_orders          int(11)         default 0                  comment '本月订单数',
    rating_score          decimal(3,2)    default 5.00               comment '评分（满分5分）',
    complaint_count       int(11)         default 0                  comment '投诉次数',
    praise_count          int(11)         default 0                  comment '表扬次数',
    
    -- 设备信息
    device_id             varchar(100)    default null               comment '设备ID',
    device_type           varchar(20)     default null               comment '设备类型',
    app_version           varchar(20)     default null               comment 'APP版本',
    
    status                char(1)         default '0'                comment '状态（0正常 1停用）',
    del_flag              char(1)         default '0'                comment '删除标志（0代表存在 1代表删除）',
    remark                varchar(500)    default null               comment '备注',
    create_dept           bigint(20)      default null               comment '创建部门',
    create_by             bigint(20)      default null               comment '创建者',
    create_time           datetime                                   comment '创建时间',
    update_by             bigint(20)      default null               comment '更新者',
    update_time           datetime                                   comment '更新时间',
    
    primary key (courier_id),
    unique key uk_courier_no (courier_no),
    unique key uk_phone (phone),
    unique key uk_id_card (id_card),
    key idx_dept_id (dept_id),
    key idx_work_status (work_status),
    key idx_online_status (online_status)
) engine=innodb comment = '快递员管理表';

-- ----------------------------
-- 快递员任务表
-- ----------------------------
create table pd_courier_task (
    task_id               bigint(20)      not null                   comment '任务ID',
    courier_id            bigint(20)      not null                   comment '快递员ID',
    courier_name          varchar(50)     default null               comment '快递员姓名',
    
    task_type             char(1)         not null                   comment '任务类型（1取件 2派件）',
    task_status           char(1)         default '0'                comment '任务状态（0待接单 1已接单 2进行中 3已完成 4已取消）',
    
    order_id              bigint(20)      not null                   comment '关联订单ID',
    order_no              varchar(50)     not null                   comment '订单编号',
    waybill_id            bigint(20)      default null               comment '关联运单ID',
    waybill_no            varchar(50)     default null               comment '运单编号',
    
    -- 地址信息
    contact_name          varchar(50)     not null                   comment '联系人姓名',
    contact_phone         varchar(20)     not null                   comment '联系人电话',
    address               varchar(255)    not null                   comment '详细地址',
    longitude             decimal(10,6)   default null               comment '经度',
    latitude              decimal(10,6)   default null               comment '纬度',
    
    -- 时间信息
    planned_time          datetime        default null               comment '计划完成时间',
    accept_time           datetime        default null               comment '接单时间',
    start_time            datetime        default null               comment '开始时间',
    finish_time           datetime        default null               comment '完成时间',
    
    -- 完成信息
    finish_photo          varchar(500)    default null               comment '完成照片URL',
    finish_remark         varchar(500)    default null               comment '完成备注',
    
    remark                varchar(500)    default null               comment '备注',
    create_time           datetime                                   comment '创建时间',
    update_time           datetime                                   comment '更新时间',
    
    primary key (task_id),
    key idx_courier_id (courier_id),
    key idx_task_status (task_status),
    key idx_order_id (order_id),
    key idx_planned_time (planned_time)
) engine=innodb comment = '快递员任务表';

-- ----------------------------
-- 快递员考勤表
-- ----------------------------
create table pd_courier_attendance (
    attendance_id         bigint(20)      not null                   comment '考勤ID',
    courier_id            bigint(20)      not null                   comment '快递员ID',
    courier_name          varchar(50)     default null               comment '快递员姓名',
    
    attendance_date       date            not null                   comment '考勤日期',
    
    clock_in_time         datetime        default null               comment '上班打卡时间',
    clock_in_longitude    decimal(10,6)   default null               comment '上班打卡经度',
    clock_in_latitude     decimal(10,6)   default null               comment '上班打卡纬度',
    clock_in_address      varchar(200)    default null               comment '上班打卡地址',
    
    clock_out_time        datetime        default null               comment '下班打卡时间',
    clock_out_longitude   decimal(10,6)   default null               comment '下班打卡经度',
    clock_out_latitude    decimal(10,6)   default null               comment '下班打卡纬度',
    clock_out_address     varchar(200)    default null               comment '下班打卡地址',
    
    work_hours            decimal(5,2)    default 0.00               comment '工作时长（小时）',
    
    attendance_status     char(1)         default '0'                comment '考勤状态（0正常 1迟到 2早退 3缺勤 4请假）',
    
    remark                varchar(500)    default null               comment '备注',
    create_time           datetime                                   comment '创建时间',
    
    primary key (attendance_id),
    key idx_courier_id (courier_id),
    key idx_attendance_date (attendance_date)
) engine=innodb comment = '快递员考勤表';

-- ----------------------------
-- 快递员评价表
-- ----------------------------
create table pd_courier_rating (
    rating_id             bigint(20)      not null                   comment '评价ID',
    courier_id            bigint(20)      not null                   comment '快递员ID',
    courier_name          varchar(50)     default null               comment '快递员姓名',
    
    order_id              bigint(20)      not null                   comment '订单ID',
    order_no              varchar(50)     not null                   comment '订单编号',
    
    user_id               bigint(20)      not null                   comment '评价用户ID',
    user_name             varchar(50)     default null               comment '评价用户姓名',
    
    rating_type           char(1)         not null                   comment '评价类型（1表扬 2投诉）',
    rating_score          int(1)          default 5                  comment '评分（1-5分）',
    rating_content        varchar(500)    default null               comment '评价内容',
    rating_images         varchar(1000)   default null               comment '评价图片（多个用逗号分隔）',
    
    reply_content         varchar(500)    default null               comment '回复内容',
    reply_time            datetime        default null               comment '回复时间',
    
    create_time           datetime                                   comment '创建时间',
    
    primary key (rating_id),
    key idx_courier_id (courier_id),
    key idx_order_id (order_id),
    key idx_user_id (user_id)
) engine=innodb comment = '快递员评价表';
