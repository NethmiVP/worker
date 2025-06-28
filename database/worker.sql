-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:4306
-- Generation Time: Jun 28, 2025 at 11:25 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `worker`
--

-- --------------------------------------------------------

--
-- Table structure for table `worker`
--

CREATE TABLE `worker` (
  `id` int(11) NOT NULL,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `contact` int(10) NOT NULL,
  `location` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `worker`
--

INSERT INTO `worker` (`id`, `fname`, `lname`, `contact`, `location`, `username`, `password`) VALUES
(1, 'Amal', 'Perera', 789204532, 'Colombo', 'amalperera', '123'),
(2, 'Kasun', 'Silva', 762411289, 'Gampaha', 'kasunsilva', '456'),
(4, 'Amal', 'Kumara', 734567891, 'Matara', 'amalkumara', '789'),
(5, 'Saman', 'Kumara', 734567891, 'Colombo', 'samankumara', '123'),
(6, 'Wasantha', 'Kumara', 734567891, 'Colombo', 'wasanthakumara', '123'),
(7, 'Wasantha', 'Perera', 734567891, 'Colombo', 'wasanthaperera', '$2a$10$qdjEhE0uHMO80TYyvep1AeOkpBEUw.bAQ3KeMLF.Ji3p2v.rX54xO');

-- --------------------------------------------------------

--
-- Table structure for table `worker_skill`
--

CREATE TABLE `worker_skill` (
  `id` int(11) NOT NULL,
  `work_id` int(11) NOT NULL,
  `service_id` int(11) NOT NULL,
  `work_experience` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `worker_skill`
--

INSERT INTO `worker_skill` (`id`, `work_id`, `service_id`, `work_experience`) VALUES
(1, 1, 1, '5 years'),
(2, 2, 1, '7 years');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `worker`
--
ALTER TABLE `worker`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `worker_skill`
--
ALTER TABLE `worker_skill`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `worker`
--
ALTER TABLE `worker`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `worker_skill`
--
ALTER TABLE `worker_skill`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
