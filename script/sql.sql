ALTER TABLE `表名`
ADD COLUMN create_dept bigint DEFAULT NULL COMMENT '创建部门',
ADD COLUMN create_by bigint DEFAULT NULL COMMENT '创建者',
ADD COLUMN create_time datetime DEFAULT NULL COMMENT '创建时间',
ADD COLUMN update_by bigint DEFAULT NULL COMMENT '更新者',
ADD COLUMN update_time datetime DEFAULT NULL COMMENT '更新时间',
ADD COLUMN remark varchar(500) DEFAULT NULL COMMENT '备注';
