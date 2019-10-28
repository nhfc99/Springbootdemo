create schema cms_demo collate utf8_general_ci;

create table t_cms_ad
(
	id int auto_increment
		primary key,
	ad_name varchar(150) null comment '广告名称',
	start_date datetime null comment '开始时间',
	end_date datetime null comment '结束时间',
	ad_body text null comment '广告内容（如代码）',
	sort_id int null comment '排序编号',
	group_id int null comment '广告分组'
)
comment '广告';

create table t_cms_ad_group
(
	id int auto_increment
		primary key,
	group_name varchar(150) default '' not null,
	status tinyint(1) default 1 not null
)
comment '广告分组';

create table t_cms_ad_silder
(
	id int auto_increment
		primary key,
	silde_name varchar(100) default '' not null,
	img varchar(255) default '' null,
	silde_url varchar(255) default '' not null,
	sort_id int default 0 null,
	status tinyint(1) default 1 null,
	start_date datetime null,
	end_date datetime null,
	type int(6) null
)
comment '幻灯片广告';

create table t_cms_category
(
	category_id bigint auto_increment
		primary key,
	alias varchar(255) default '' not null comment '别名',
	category_name varchar(255) default '' not null comment '分类明细',
	site_id int default 1 null comment '站点编号',
	parent_id bigint default 0 null comment '父类编号',
	model_id int null comment '模型编号',
	alone tinyint(1) default 0 null comment '单页（0：不是，1：是）',
	content mediumtext null comment '文本',
	index_tpl varchar(255) default '' not null comment '模板',
	list_tpl varchar(255) default '' not null comment '列表页面',
	content_tpl varchar(255) default '' not null comment '内容页面',
	is_nav tinyint(1) default 0 not null comment '导航',
	url varchar(255) null comment '地址',
	has_child tinyint(1) default 0 null comment '是否有子类',
	is_common tinyint(1) default 0 null comment '是否为通用栏目（子站点也默认继承此栏目）',
	allow_front_submit tinyint(1) default 1 null,
	page_size int null comment '栏目分页数量',
	allow_search tinyint(1) unsigned default 0 null comment '当前栏目下的是否支持全文搜索',
	category_icon varchar(255) null comment '栏目图标',
	permission_key varchar(100) null comment '栏目权限标识',
	sort_id int(11) unsigned default 0 null,
	translated_category_id bigint null
)
comment '分类表';

create index category_id
	on t_cms_category (category_id);

create index short_name
	on t_cms_category (alias);

create table t_cms_content
(
	content_id bigint auto_increment
		primary key,
	site_id int default 0 not null comment '站点编号',
	user_id int default 0 not null comment '用户id',
	category_id bigint default 0 not null comment '栏目',
	model_id int default 0 null comment '模型id',
	title varchar(255) default '' not null comment '标题',
	keywords char(40) default '' null comment '关键字',
	description text null comment '描述',
	top tinyint(1) default 0 null comment '热门',
	recommend tinyint(1) default 0 not null comment '推荐',
	thumb varchar(255) null comment '封面',
	status tinyint(1) default 1 not null comment '状态',
	inputdate timestamp null comment '发布时间',
	updatedate timestamp null comment '更新时间',
	url char(100) default '' null comment '文章地址',
	author char(20) default '' not null comment '用户名',
	view_num int(11) unsigned default 0 not null comment '查看次数'
)
comment '内容表';

create index catid
	on t_cms_content (category_id, model_id);

create table t_cms_content_news
(
	content_id bigint default 0 not null
		primary key,
	content mediumtext not null,
	fujian varchar(128) null,
	laiyuan varchar(50) default 'XXX市文联' null
);

create table t_cms_ebook
(
	id bigint auto_increment
		primary key,
	ebook_name varchar(200) null,
	url varchar(500) null,
	create_time datetime null,
	file_path varchar(2000) null,
	view_name varchar(500) null
)
charset=utf8mb4;

create table t_cms_form
(
	form_id bigint(11) unsigned auto_increment
		primary key,
	model_id int(11) unsigned default 0 not null comment '模型id',
	from_name varchar(255) null comment '表单名称',
	create_date datetime null comment '创建时间',
	from_action varchar(255) null comment '表单提交地址',
	required_login tinyint(1) unsigned null comment '是否登陆',
	return_type int(1) null comment '返回类型（1 JSON 、2 html）',
	enable_verify_code tinyint(1) null comment '开启验证码'
)
comment '表单';

create index from_action
	on t_cms_form (from_action);

create table t_cms_friendlink
(
	id int auto_increment
		primary key,
	link_name varchar(100) default '' not null,
	link_type int(1) default 0 not null,
	img varchar(255) default '' null,
	link_url varchar(255) default '' not null,
	sort_id int default 0 null,
	status tinyint(1) default 1 null,
	group_id int(1) default 0 not null
)
comment '友情链接';

create table t_cms_friendlink_group
(
	id int auto_increment
		primary key,
	group_name varchar(255) null,
	status tinyint(1) null
);

create table t_cms_linkage
(
	id int(5) unsigned auto_increment
		primary key,
	site_id int default 0 not null comment '站点id',
	name varchar(30) not null,
	parent_id int(11) unsigned default 0 not null,
	grade int(1) default 0 not null,
	childs varchar(200) default '' not null,
	sort_id smallint(5) unsigned default 0 not null,
	is_common tinyint(1) default 0 null comment '是否为通用'
);

create index child
	on t_cms_linkage (grade);

create index keyid
	on t_cms_linkage (site_id);

create index list
	on t_cms_linkage (site_id, parent_id, sort_id);

create table t_cms_model
(
	model_id int auto_increment
		primary key,
	model_name varchar(255) null comment '模型名称',
	table_name varchar(255) null comment '模型表名称',
	site_id bigint null comment '站点id',
	des varchar(255) default '' null comment '字段描述',
	status tinyint(1) default 1 not null comment '状态'
)
comment '模型表';

create table t_cms_model_filed
(
	filed_id int auto_increment comment '字段编号'
		primary key,
	model_id int default 0 not null comment '模型编号',
	filed_name varchar(255) default '' not null comment '字段名称',
	filed_class varchar(255) default '' not null comment '字段类型（如文本）',
	filed_value text null comment '字段值',
	filed_type varchar(255) default '0' not null comment '字段类别（数据库类别）',
	alias varchar(255) default '' not null comment '别名',
	not_null tinyint(1) default 0 not null comment '是否为空',
	filed_length int default 0 null comment '字段长度',
	is_primary tinyint(1) default 0 not null comment '是否为主键',
	setting varchar(255) default '' null
)
comment '模型字段';

create table t_cms_search_words
(
	id int auto_increment
		primary key,
	name varchar(255) not null comment '搜索词汇',
	hit_count int default 0 not null comment '搜索次数',
	is_recommend tinyint(1) default 0 not null comment '推荐',
	site_id int default 1 not null comment '站点'
)
comment '搜索热词';

create table t_cms_site
(
	site_id int auto_increment comment '站点id（0为主站，不能删除）'
		primary key,
	site_name varchar(255) null comment '站点名称',
	domain varchar(255) default '' null comment '域名',
	language char(10) default '' null comment '语言',
	template varchar(20) default '' null comment '模板',
	title varchar(64) null,
	keyword varchar(60) default '' null comment '关键字',
	description text null comment '描述',
	is_mobile tinyint(1) default 0 null comment '移动是否开启',
	mobile_tpl varchar(255) default 'mobile' null comment '手机模板',
	status tinyint(1) default 0 null comment '站点状态',
	logo varchar(255) null,
	site_key varchar(200) null
)
comment '站点';

create table t_cms_tag
(
	tag_id int auto_increment
		primary key,
	tag_name varchar(64) default '' not null,
	letter varchar(255) default '' not null,
	count int default 0 null
)
comment 'cmstag';

create index letter
	on t_cms_tag (letter);

create index name
	on t_cms_tag (tag_name);

create table t_cms_tag_content
(
	id int auto_increment
		primary key,
	tag_id int default 0 not null,
	content_id bigint default 0 not null
)
comment '标签内容';

create index content_id
	on t_cms_tag_content (content_id);

create index tag_Id
	on t_cms_tag_content (tag_id);

create table t_cms_topic
(
	topic_id int auto_increment
		primary key,
	category_ids varchar(2000) null,
	topic_name varchar(150) not null comment '名称',
	short_name varchar(150) null comment '简称',
	keywords varchar(255) null comment '关键字',
	description varchar(255) null comment '描述',
	title_img varchar(100) null comment '标题图',
	content_img varchar(100) null comment '内容图',
	topic_tpl varchar(100) null comment '专题模板',
	sort_id int default 10 not null comment '排列顺序',
	is_recommend tinyint(1) default 0 not null comment '是否推??',
	site_id int null comment '站点Id'
)
comment 'CMS专题表';

create table t_cms_user_site
(
	id int auto_increment
		primary key,
	user_id int null comment '用户id（这个用户id只代表后台管理员用户）',
	site_id int null comment '站点id'
)
comment '系统管理员和用户关联表';

create table t_sys_attachment
(
	id bigint auto_increment
		primary key,
	file_name varchar(50) not null comment '文件名称',
	user_id varchar(32) not null comment '用户ID',
	username varchar(32) null,
	upload_date datetime not null comment '上传时间',
	upload_ip varchar(100) default '' not null comment '上传的ID',
	file_extname varchar(100) default '' not null comment '文件扩展名',
	file_path varchar(500) default '' not null comment '文件路径',
	file_size float(10,2) unsigned default 0.00 not null comment '文件大小',
	url varchar(500) null comment '附件网址',
	file_key varchar(255) null comment '文件key',
	original_file_name varchar(255) null comment '源文件名称',
	type int default 1 null comment '（1,附件，2电子书）'
)
comment '附件表';

create table t_sys_log
(
	id int auto_increment
		primary key,
	content text not null,
	createTime timestamp default '1970-01-01 08:00:01' null,
	username varchar(255) default '' null,
	type varchar(255) null
)
comment '日志表';

create table t_sys_module
(
	id int auto_increment
		primary key,
	module_name varchar(255) null,
	is_enable tinyint(1) default 0 not null comment '是否启用',
	is_auto_expand tinyint(1) null comment '是否自动展开',
	url varchar(255) null comment '菜单url',
	icon_name varchar(64) null comment '菜单节点图标',
	permission_key varchar(64) null comment '权限key',
	pid int default 0 not null comment '父id编号',
	has_child tinyint(1) default 0 not null comment '有子节点',
	sort_no int default 0 null comment '排序'
);

create table t_sys_org
(
	id int auto_increment
		primary key,
	name varchar(64) not null comment '组织名称',
	address varchar(100) null comment '地址',
	code varchar(64) not null comment '编号',
	pid int(11) unsigned default 0 not null comment '父ID',
	tel_phone varchar(12) null comment '联系电话'
)
comment '组织机构表';

create table t_sys_org_user
(
	id int auto_increment
		primary key,
	org_id int(11) unsigned default 0 not null comment '机构编号',
	user_id int(11) unsigned default 0 not null comment '角色编号'
)
comment '机构权限表';

create index org_id
	on t_sys_org_user (org_id);

create index role_id
	on t_sys_org_user (user_id);

create table t_sys_permission
(
	permission_id int auto_increment
		primary key,
	name varchar(255) default '' not null,
	description varchar(255) null,
	pid int default 0 not null
)
comment '权限';

create table t_sys_role
(
	role_id int auto_increment comment '角色id'
		primary key,
	rolename varchar(255) default '' not null comment '角色名称',
	description text null comment '描述'
)
comment '角色表';

create table t_sys_role_permission
(
	id int auto_increment
		primary key,
	role_id int default 0 not null,
	permisson_id int default 0 not null
)
comment '角色权限表';

create index pid
	on t_sys_role_permission (permisson_id);

create index rid
	on t_sys_role_permission (role_id);

create table t_sys_schedule_job
(
	id int auto_increment
		primary key,
	cron_expression varchar(255) not null comment 'cron表达式',
	method_name varchar(255) not null comment '任务调用的方法名',
	is_concurrent varchar(255) null comment '任务是否有状态',
	description varchar(255) null comment '任务描述',
	update_by varchar(64) null comment '更新者',
	bean_class varchar(255) null comment '任务执行时调用哪个类的方法 包名+类名',
	create_date datetime null comment '创建时间',
	job_status varchar(255) null comment '任务状态',
	job_group varchar(255) null comment '任务分组',
	update_date datetime null comment '更新时间',
	create_by varchar(64) null comment '创建者',
	spring_bean varchar(255) null comment 'Spring bean',
	job_name varchar(255) null comment '任务名'
)
comment '任务调度';

create table t_sys_user
(
	user_id int auto_increment comment '用户id（0为创始人不能删除）'
		primary key,
	username varchar(64) default '' not null comment '用户名',
	password varchar(64) default '' not null comment '密码',
	create_time datetime null comment '用户创建时间',
	salt varchar(64) null comment '用户盐',
	login_time timestamp null comment '登陆时间',
	logout_time timestamp null comment '离开时间',
	last_ip varchar(100) default '' null comment '登陆IP',
	status tinyint(1) unsigned default 0 not null comment '管理员状态',
	des varchar(255) default '' null comment '管理员说明',
	avatar varchar(255) null comment '用户头像',
	constraint username
		unique (username)
)
comment '系统用户';

create table t_sys_user_role
(
	id int auto_increment
		primary key,
	user_id int default 0 not null,
	role_id int default 0 not null
)
comment '管理员权限';

create index role_id
	on t_sys_user_role (role_id);

create index user_id
	on t_sys_user_role (user_id);

