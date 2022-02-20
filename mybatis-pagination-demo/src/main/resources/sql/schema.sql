--
-- 表的结构 user
--

CREATE TABLE user (
                        id int(11) PRIMARY KEY AUTO_INCREMENT,
                        name varchar(16) NOT NULL,
                        status int(11) DEFAULT '1'
);

--
-- 转存表中的数据 user_order
--
CREATE TABLE user_order (
                              id int(11) PRIMARY KEY AUTO_INCREMENT,
                              name varchar(16) NOT NULL,
                              user_id int(11) NOT NULL
);