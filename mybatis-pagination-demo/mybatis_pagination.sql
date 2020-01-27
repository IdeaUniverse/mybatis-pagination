-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- 主机： mysql
-- 生成日期： 2020-01-27 10:15:03
-- 服务器版本： 5.7.26
-- PHP 版本： 7.2.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `mybatis_pagination`
--
CREATE DATABASE IF NOT EXISTS `mybatis_pagination` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `mybatis_pagination`;

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `status` int(11) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`id`, `name`, `status`) VALUES
(1, 'IQ5IXh', 1),
(2, '4rHprP', 1),
(3, '78esKo', 1),
(4, 'wU8nmi', 1),
(5, '7ABfXs', 1),
(6, 'EcWhRI', 1),
(7, 'RiXjGD', 1),
(8, 'JdGrIl', 1),
(9, 'cmKc47', 1),
(10, 'ZokRm6', 1),
(11, 'LuQnjt', 1),
(12, 'ZM4BqQ', 1),
(13, 'Q9eCNJ', 1),
(14, 'hUAYRS', 1),
(15, 'd8OrOe', 1),
(16, 'kBwkU0', 1),
(17, 'heUhs4', 1),
(18, '3JKB94', 1),
(19, 'WJczE4', 1),
(20, 'dkTSOp', 1);

-- --------------------------------------------------------

--
-- 表的结构 `user_order`
--

CREATE TABLE `user_order` (
  `id` int(11) NOT NULL,
  `name` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `user_order`
--

INSERT INTO `user_order` (`id`, `name`, `user_id`) VALUES
(1, 'IQ5IXh', 1),
(2, 'IQ5IXh', 1),
(3, 'IQ5IXh', 1),
(4, '4rHprP', 2),
(5, '4rHprP', 2),
(6, '4rHprP', 2),
(7, '78esKo', 3),
(8, '78esKo', 3),
(9, '78esKo', 3),
(10, 'wU8nmi', 4),
(11, 'wU8nmi', 4),
(12, 'wU8nmi', 4),
(13, '7ABfXs', 5),
(14, '7ABfXs', 5),
(15, '7ABfXs', 5),
(16, 'EcWhRI', 6),
(17, 'EcWhRI', 6),
(18, 'EcWhRI', 6),
(19, 'RiXjGD', 7),
(20, 'RiXjGD', 7),
(21, 'RiXjGD', 7),
(22, 'JdGrIl', 8),
(23, 'JdGrIl', 8),
(24, 'JdGrIl', 8),
(25, 'cmKc47', 9),
(26, 'cmKc47', 9),
(27, 'cmKc47', 9),
(28, 'ZokRm6', 10),
(29, 'ZokRm6', 10),
(30, 'ZokRm6', 10),
(31, 'LuQnjt', 11),
(32, 'LuQnjt', 11),
(33, 'LuQnjt', 11),
(34, 'ZM4BqQ', 12),
(35, 'ZM4BqQ', 12),
(36, 'ZM4BqQ', 12),
(37, 'Q9eCNJ', 13),
(38, 'Q9eCNJ', 13),
(39, 'Q9eCNJ', 13),
(40, 'hUAYRS', 14),
(41, 'hUAYRS', 14),
(42, 'hUAYRS', 14),
(43, 'd8OrOe', 15),
(44, 'd8OrOe', 15),
(45, 'd8OrOe', 15),
(46, 'kBwkU0', 16),
(47, 'kBwkU0', 16),
(48, 'kBwkU0', 16),
(49, 'heUhs4', 17),
(50, 'heUhs4', 17),
(51, 'heUhs4', 17),
(52, '3JKB94', 18),
(53, '3JKB94', 18),
(54, '3JKB94', 18),
(55, 'WJczE4', 19),
(56, 'WJczE4', 19),
(57, 'WJczE4', 19),
(58, 'dkTSOp', 20),
(59, 'dkTSOp', 20),
(60, 'dkTSOp', 20);

--
-- 转储表的索引
--

--
-- 表的索引 `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `user_order`
--
ALTER TABLE `user_order`
  ADD PRIMARY KEY (`id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- 使用表AUTO_INCREMENT `user_order`
--
ALTER TABLE `user_order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
