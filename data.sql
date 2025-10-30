-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Oct 30, 2025 at 02:40 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hello_t2404e_springboot`
--

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `id` bigint(20) NOT NULL,
  `age` int(11) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `name` varchar(150) NOT NULL,
  `salary` double NOT NULL,
  `last_modified_at` datetime(6) DEFAULT NULL,
  `status` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`id`, `age`, `created_at`, `name`, `salary`, `last_modified_at`, `status`) VALUES
(1, 31, '2025-10-30 20:01:25', 'Bob updated', 13000, '2025-10-30 20:35:47.000000', 1),
(2, 42, '2025-10-30 20:01:25', 'Silvia', 15000, '2025-10-30 20:01:25.000000', 1),
(3, 40, '2025-10-30 20:01:25', 'Tom', 50000, '2025-10-30 20:01:25.000000', 1),
(8, 32, '2025-10-30 20:04:01', 'Sam', 22000, '2025-10-30 20:04:01.000000', 1),
(9, 30, '2025-10-30 20:20:47', 'Hà Mạnh Bảo', 25000, '2025-10-30 20:20:47.000000', 1),
(10, 25, '2025-10-30 20:35:34', 'Nguyễn Văn B', 1200.5, '2025-10-30 20:35:34.000000', 1),
(11, 30, '2025-10-30 20:38:38', 'Hà Mạnh Bảo 2', 25000, '2025-10-30 20:38:38.000000', 1),
(12, 28, '2025-10-30 20:38:38', 'Nguyễn Văn A 2', 18000, '2025-10-30 20:38:38.000000', 1),
(13, 32, '2025-10-30 20:38:38', 'Trần Thị B', 22000, '2025-10-30 20:38:38.000000', 1),
(14, 24, '2025-10-30 20:38:38', 'Lê Văn C', 15000, '2025-10-30 20:38:38.000000', 1),
(15, 29, '2025-10-30 20:38:38', 'Phạm Thu D', 27000, '2025-10-30 20:38:38.000000', 1),
(16, 26, '2025-10-30 20:38:38', 'Đỗ Minh E', 19500, '2025-10-30 20:38:38.000000', 1),
(17, 35, '2025-10-30 20:38:38', 'Hoàng Quốc F', 32000, '2025-10-30 20:38:38.000000', 1),
(18, 22, '2025-10-30 20:38:38', 'Vũ Lan G', 14000, '2025-10-30 20:38:38.000000', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `uk_employee_name` (`name`),
  ADD UNIQUE KEY `UKsd5rcqkto9rwnmx8g16o41af` (`name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
