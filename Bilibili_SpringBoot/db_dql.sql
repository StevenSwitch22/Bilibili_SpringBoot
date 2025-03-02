

# 背景：我有一张员工表，id, username, password, name, gender, image, job, entry_time, create_time, update_time，这是表中的字段
#
# 问题：现在站在Java后端实际开发过程中的角度上给我想场景。
#
# 根据上面表中的字段，我给你几道题，你要写出该题在实际生活中在实际用户使用的过程中发生的场景
#
# 以下为问题：
# 1. 查询姓名为zhang的员工（姓名只是个例子，你可以不用听我的）
# 2. 查询 id小于5的员工信息（id只是个例子，你可以不用听我的）
# 3. 查询没有分配职位的员工信息（职位只是个例子，你可以不用听我的）
# 4. 查询有职位的员工信息（职位只是个例子，你可以不用听我的）
# 5. 查询密码不等于 '1233'的员工信息（密码只是个例子，你可以不用听我的）
# 6. 查询入职日期在 '2000-1-1（包含）'到'2010-1-1'（包含）之间的员工信息（入职日期只是个例子，你可以不用听我的）
# 7. 查询入职日期在 '2000-1-1（包含）'到'2010-1-1'（包含）之间且性别为女的员工信息（入职日期只是个例子，你可以不用听我的）
# 8. 查询职位是2 （讲师），3（主管），4（老师）的员工信息（职位只是个例子，你可以不用听我的）
# 9. 查询姓名为两个字的员工信息（姓名只是个例子，你可以不用听我的）
# 10. 查询姓'zhang'的员工信息（姓只是个例子，你可以不用听我的）
#
# 限制：你的回复必须是真实的发生在现实生活中的场景
#
# 格式：只需要回复场景就行，不用再把问题复述一遍，且不要回复其他
-- auto-generated definition
create table colleague
(
    id          int auto_increment comment '员工ID'
        primary key,
    username    varchar(20)                     not null comment '员工账号',
    password    varchar(10)      default '1111' not null comment '员工账号密码',
    name        varchar(20)                     not null comment '员工真实姓名',
    gender      tinyint unsigned default '1'    null comment '员工性别，说明：1 男 2 女',
    image       varchar(200)                    null comment '员工头像',
    job         tinyint unsigned                null comment '员工职位，说明：1 产品经理 2 UI设计 3 前端开发 4 后端开发 5 测试开发',
    entry_time  date                            null comment '员工入职日期',
    create_time datetime                        not null comment '该记录创建时间',
    update_time datetime                        not null comment '该记录修改日期',
    constraint colleague_exam_pk
        unique (username)
)
    comment 'Colleague table';

-- 扩展30条同事表数据
INSERT INTO colleague (username, password, name, gender, image, job, entry_time, create_time, update_time)
VALUES
    ('xiaobai@123.com', '123456', '小白', 2, '2.jpg', 2, '2020-02-15', '2020-02-15 09:30:00', '2020-02-15 09:30:00'),
    ('zhangsan@123.com', 'abc123', '张三', 1, '3.jpg', 3, '2020-03-22', '2020-03-22 10:15:00', '2021-05-01 14:20:00'),
    ('lisi@123.com', '1111', '李四', 1, '4.jpg', 4, '2020-04-10', '2020-04-10 11:00:00', '2020-04-10 11:00:00'),
    ('wangwu@123.com', 'test123', '王五', 2, '5.jpg', 5, '2020-05-05', '2020-05-05 13:45:00', '2022-08-15 16:30:00'),
    ('zhaoliu@123.com', '123456', '赵六', 1, '6.jpg', 1, '2020-06-18', '2020-06-18 14:20:00', '2020-06-18 14:20:00'),
    ('qianqi@123.com', 'pass123', '钱七', 2, '7.jpg', 2, '2020-07-12', '2020-07-12 15:10:00', '2021-09-20 17:00:00'),
    ('sunba@123.com', '1111', '孙八', 1, '8.jpg', 3, '2020-08-25', '2020-08-25 16:05:00', '2020-08-25 16:05:00'),
    ('zhoujiu@123.com', 'admin123', '周九', 2, '9.jpg', 4, '2020-09-30', '2020-09-30 17:30:00', '2023-04-10 09:15:00'),
    ('wu10@123.com', '123456', '吴十', 1, '10.jpg', 5, '2020-10-15', '2020-10-15 18:20:00', '2020-10-15 18:20:00'),
    ('zheng11@123.com', 'temp123', '郑十一', 2, '11.jpg', 1, '2020-11-20', '2020-11-20 19:10:00', '2022-11-25 11:40:00'),
    ('feng12@123.com', '1111', '冯十二', 1, '12.jpg', 2, '2020-12-25', '2020-12-25 20:00:00', '2020-12-25 20:00:00'),
    ('chen13@123.com', 'user123', '陈十三', 2, '13.jpg', 3, '2021-01-10', '2021-01-10 08:30:00', '2023-01-15 10:25:00'),
    ('liu14@123.com', '123456', '刘十四', 1, '14.jpg', 4, '2021-02-14', '2021-02-14 09:15:00', '2021-02-14 09:15:00'),
    ('gao15@123.com', 'dev2021', '高十五', 2, '15.jpg', 5, '2021-03-18', '2021-03-18 10:45:00', '2022-03-22 15:35:00'),
    ('guo16@123.com', '1111', '郭十六', 1, '16.jpg', 1, '2021-04-22', '2021-04-22 11:30:00', '2021-04-22 11:30:00'),
    ('he17@123.com', 'test2021', '何十七', 2, '17.jpg', 2, '2021-05-25', '2021-05-25 12:20:00', '2021-05-25 12:20:00'),
    ('lin18@123.com', '123456', '林十八', 1, '18.jpg', 3, '2021-06-30', '2021-06-30 13:10:00', '2022-07-05 14:10:00'),
    ('deng19@123.com', 'admin2021', '邓十九', 2, '19.jpg', 4, '2021-07-15', '2021-07-15 14:50:00', '2023-07-20 16:00:00'),
    ('ma20@123.com', '1111', '马二十', 1, '20.jpg', 5, '2021-08-20', '2021-08-20 15:30:00', '2021-08-20 15:30:00'),
    ('huang21@123.com', 'pass2021', '黄二一', 2, '21.jpg', 1, '2021-09-25', '2021-09-25 16:20:00', '2021-09-25 16:20:00'),
    ('xu22@123.com', '123456', '徐二二', 1, '22.jpg', 2, '2021-10-30', '2021-10-30 17:15:00', '2022-11-05 09:00:00'),
    ('cai23@123.com', 'temp2021', '蔡二三', 2, '23.jpg', 3, '2021-11-15', '2021-11-15 18:05:00', '2021-11-15 18:05:00'),
    ('yu24@123.com', '1111', '余二四', 1, '24.jpg', 4, '2021-12-20', '2021-12-20 19:10:00', '2023-12-25 14:30:00'),
    ('jiang25@123.com', 'user2021', '江二五', 2, '25.jpg', 5, '2022-01-25', '2022-01-25 20:00:00', '2022-01-25 20:00:00'),
    ('han26@123.com', '123456', '韩二六', 1, '26.jpg', 1, '2022-02-28', '2022-02-28 08:45:00', '2022-02-28 08:45:00'),
    ('wei27@123.com', 'dev2022', '魏二七', 2, '27.jpg', 2, '2022-03-15', '2022-03-15 09:30:00', '2023-03-20 11:20:00'),
    ('cheng28@123.com', '1111', '程二八', 1, '28.jpg', 3, '2022-04-20', '2022-04-20 10:20:00', '2022-04-20 10:20:00'),
    ('fang29@123.com', 'test2022', '方二九', 2, '29.jpg', 4, '2022-05-25', '2022-05-25 11:10:00', '2022-05-25 11:10:00'),
    ('zeng30@123.com', '123456', '曾三十', 1, '30.jpg', 5, '2022-06-30', '2022-06-30 12:00:00', '2023-07-05 16:45:00');













-- 基本查询格式： select ** from **
-- 场景1：HR要给新入职的员工发工牌，需要统计员工的编号，姓名，照片，职位
select id, name, image, job from colleague;

-- 场景2：系统管理员需要定期核查数据，需要全字段检查历史数据
select id, username, password, name, gender, image, job, entry_time, create_time, update_time
from colleague;

-- 场景3： 财务部需要向外界公布财务报表，需将技术字段转换为业务术语，且仅展示姓名，职位，入职日期等重要信息
select name as '姓名', entry_time as '入职日期' from colleague;
select name '姓名', entry_time '入职日期' from colleague;

-- 场景4：招聘专员在制定招聘计划时，需要获取当前公司都有哪些职位，故不能返回重复的职位，需要对查询出来的职位信息进行去重
select distinct job from colleague;


-- 条件查询格式： select ** from ** where ** = **
-- 场景1：HR需要联系姓名为赵六的员工参加表彰大会
select * from colleague where name = '赵六';

-- 场景2：财务部分需要核查前5位员工的信息
select * from colleague where id <= 5;

-- 场景3：IT部门需要找出系统中尚未分配职位的员工
select * from colleague where job is null;

-- 场景4：项目经理需要统计有职位的团队成员，便于进行资源规划
select * from colleague where job is not null;

-- 场景5：系统管理员需要筛查出未使用默认密码的员工账号
select username from colleague where password != '123456';

-- 场景6：HR需要统计2020年10月到2022年2月入职的员工信息，准备周年庆
select id, name, entry_time from colleague where entry_time between '2020-10-01' and '2022-02-01';

-- 场景7：招聘部门需要2020年10月到2022年2月入职的女性员工信息，准备女性节活动
select id, name, gender, job, entry_time from colleague
where entry_time between '2020-10-01' and '2022-02-01' and gender = 2;

-- 场景8：技术部门需要找出所有产品经理、UI设计师、前端开发工程师的员工信息，准备会议
select id, name, job from colleague where job in (1, 2, 3);

-- 场景9：门禁系统管理员需要找出姓名为两个字的员工信息，便于制作门禁卡
select id, name from colleague where name like '___';

-- 场景10：HR需要联系姓王的员工参加公司年会
select id, name from colleague where name like '方%';

-- 聚合函数

-- 场景1：HR部门需要统计当前在职员工数量向上汇报
select count(id) as '员工数量' from colleague;

-- 场景2：公司需要找出资历最老的员工嘉奖
select min(entry_time) as '最老员工入职日期' from colleague;

-- 场景3：公司需要找出最近入职的员工安排培训
select max(entry_time) as '最新员工入职日期' from colleague;

-- 场景4：IT部门需要了解当前员工ID的平均值来优化编号分配策略
select avg(id) as '员工ID平均值' from colleague;

-- 场景5：系统需要验证员工ID的总和来确保数据完整
select sum(id) as '员工ID总和' from colleague;


-- 分组查询格式： select ** from ** where ** group by ** having **
-- 场景1：HR需要统计公司男女比例准备报告
select gender, count(*) as '数量' from colleague group by gender;
select count(*) from colleague;

-- 场景2：公司需要找出哪些职位有2个及以上2022年前入职的老员工
select job, count(*) from colleague where entry_time < '2022-01-01'
group by  job having count(*) >= 2;
select job, count(*) from colleague where entry_time < '2022-01-01' group by job having count(*) >= 2;


-- 排序查询格式： select ** from ** order by ** desc/asc
-- 场景1：HR需要按照入职日期从早到晚排列员工信息，便于奖励
select id, name, job, entry_time from colleague order by entry_time;

-- 场景2：招聘部门需要查看最近入职的员工评估最近招聘结果
select id, name, job, entry_time from colleague order by entry_time desc ;

-- 场景3：IT系统需要生成花名册，按照入职从早到晚排序，同一天入职的人，按照更新时间排序
select id, name, job, entry_time, update_time from colleague
order by entry_time, update_time desc ;


-- 分页查询格式： select ** from ** limit ** offset **
-- 场景1：HR需要查看第1页前5名的员工信息
select id, name, job, entry_time from colleague limit 0, 5;

-- 场景2：HR需要查看第2页前5名的员工信息
select id, name, job from colleague limit 5, 5;