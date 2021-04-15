CREATE DATABASE rdcc;

#用户表
CREATE TABLE users(
	user_id INT PRIMARY KEY AUTO_INCREMENT,
	user_name VARCHAR(100) UNIQUE NOT NULL,-- 用户名
	PASSWORD VARCHAR(30) NOT NULL,-- 密码
	birthday DATE,-- 生日
	sex CHAR(1) DEFAULT'男',-- 性别
	telephone VARCHAR(11) UNIQUE NOT NULL-- 手机号
);

INSERT INTO users(`user_name`,`password`,`birthday`,`sex`,`telephone`) VALUES ('张三','123456',STR_TO_DATE('2000-1-1','%Y-%c-%d'),'男','13143672983');
INSERT INTO users(`user_name`,`password`,`birthday`,`sex`,`telephone`) VALUES ('李四','123456',STR_TO_DATE('2001-3-1','%Y-%c-%d'),'男','13198202983');
INSERT INTO users(`user_name`,`password`,`birthday`,`sex`,`telephone`) VALUES ('王五','123456',STR_TO_DATE('2002-9-1','%Y-%c-%d'),'女','19243672983');
	
SELECT * FROM users;

#-----------------------------------------------------------------------------------

#管理员表
CREATE TABLE manager(
	manager_id INT PRIMARY KEY AUTO_INCREMENT,
	manager_name VARCHAR(100) UNIQUE NOT NULL,-- 管理员名字
	PASSWORD VARCHAR(30) NOT NULL
);

INSERT INTO manager(`manager_name`,`PASSWORD`) VALUES('张小明','654321');
	
SELECT * FROM manager;

#-----------------------------------------------------------------------------------

#笔记表
CREATE TABLE note(
	note_id INT PRIMARY KEY AUTO_INCREMENT,
	user_id INT,-- 笔记作者
	category_id INT,-- 笔记分类
	title VARCHAR(100), -- 标题
	like_number INT DEFAULT 0, -- 点赞数
	issue_time DATETIME, -- 日期+时间
	if_open VARCHAR(10) DEFAULT'公开',
	note_content TEXT NOT NULL
); 
ALTER TABLE note ADD CONSTRAINT u_n1 FOREIGN KEY (user_id) REFERENCES users(user_id) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE note ADD CONSTRAINT u_n2 FOREIGN KEY (category_id) REFERENCES category(category_id) ON UPDATE CASCADE ON DELETE CASCADE;

INSERT INTO note(`title`,`user_id`,`category_id`,`issue_time`,note_content) VALUES('研发冲冲冲',1,1,NOW(),'研发研发研发');
INSERT INTO note(`title`,`user_id`,`category_id`,`issue_time`,note_content) VALUES('520研发',2,1,NOW(),'rdcrdcrdc');
INSERT INTO note(`title`,`user_id`,`category_id`,`issue_time`,note_content) VALUES('研发RDC',2,1,NOW(),'hhhhh我爱mysql');
INSERT INTO note(`title`,`user_id`,`category_id`,`issue_time`,note_content) VALUES('研发1314',3,1,NOW(),'努力学习努力学习我爱后台我爱后台~');

	
SELECT * FROM note;

#--------------------------------------------------------------------------------------------------

#收藏表
CREATE TABLE favorite(
	user_id INT,-- 收藏该笔记的用户
	note_id INT,-- 被收藏的笔记
	favourite_time DATE,-- 收藏的时间
	PRIMARY KEY(user_id,note_id) -- 复合主键:一个用户只能收藏一篇笔记一次
	#constraint u_f FOREIGN KEY(user_id) REFERENCES users(user_id) ON UPDATE CASCADE ON DELETE CASCADE,
	#CONSTRAINT n_f FOREIGN KEY(note_id) REFERENCES note(note_id) ON UPDATE CASCADE ON DELETE CASCADE
);
ALTER TABLE favorite ADD CONSTRAINT u_f FOREIGN KEY(user_id) REFERENCES users(user_id) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE favorite ADD CONSTRAINT n_f FOREIGN KEY(note_id) REFERENCES note(note_id) ON UPDATE CASCADE ON DELETE CASCADE;

INSERT INTO favorite (`user_id`,`note_id`,`favourite_time`) VALUES (1,1,NOW());
INSERT INTO favorite (`user_id`,`note_id`,`favourite_time`) VALUES (1,2,NOW());
INSERT INTO favorite (`user_id`,`note_id`,`favourite_time`) VALUES (2,1,NOW());
INSERT INTO favorite (`user_id`,`note_id`,`favourite_time`) VALUES (3,1,NOW());

SELECT * FROM favorite;
#-----------------------------------------------------------------------------------

#分类表
CREATE TABLE category(
	category_id INT PRIMARY KEY AUTO_INCREMENT,
	category_name VARCHAR(50) UNIQUE-- 分类名称
);
INSERT INTO category (`category_name`) VALUES ('研发工作室');
INSERT INTO category (`category_name`) VALUES ('研发研发');

SELECT * FROM category;

#-----------------------------------------------------------------------------------