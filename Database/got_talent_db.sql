-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Generation Time: Dec 14, 2020 at 07:48 PM
-- Server version: 8.0.18
-- PHP Version: 7.3.12

SET SQL_MODE
= "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT
= 0;
START TRANSACTION;
SET time_zone
= "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `got_talent_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
CREATE TABLE
IF NOT EXISTS `administrator`
(
  `id` int
(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar
(200) NOT NULL,
  `last_name` varchar
(200) NOT NULL,
  `email` varchar
(200) NOT NULL,
  `phone` varchar
(200) NOT NULL,
  `password` varchar
(200) NOT NULL,
  PRIMARY KEY
(`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE
IF NOT EXISTS `category`
(
  `id` int
(11) NOT NULL AUTO_INCREMENT,
  `name` int
(200) NOT NULL,
  PRIMARY KEY
(`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `participation`
--

DROP TABLE IF EXISTS `participation`;
CREATE TABLE
IF NOT EXISTS `participation`
(
  `id_user` int
(11) NOT NULL,
  `id_category` int
(11) NOT NULL,
  `description` varchar
(200) NOT NULL,
  `show_start_time` timestamp NOT NULL,
  `show_end_time` timestamp NOT NULL,
  `attached_file` varchar
(200) NOT NULL,
  `is_accepted` tinyint
(1) NOT NULL,
  KEY `id_category`
(`id_category`),
  KEY `id_user`
(`id_user`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE
IF NOT EXISTS `user` (
  `id` int
(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar
(200) NOT NULL,
  `last_name` varchar
(200) NOT NULL,
  `email` varchar
(200) NOT NULL,
  `phone` varchar
(200) NOT NULL,
  PRIMARY KEY
(`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
