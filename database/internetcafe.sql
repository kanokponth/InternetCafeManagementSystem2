-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 04, 2018 at 04:05 AM
-- Server version: 5.6.34-log
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `internetcafe`
--

-- --------------------------------------------------------

--
-- Table structure for table `computer`
--

CREATE TABLE `computer` (
  `computer_number` int(2) NOT NULL,
  `status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `computer`
--

INSERT INTO `computer` (`computer_number`, `status`) VALUES
(1, 'no'),
(2, 'yes'),
(3, 'no'),
(4, 'no'),
(5, 'no'),
(6, 'no'),
(7, 'no'),
(8, 'no'),
(9, 'no'),
(10, 'no'),
(11, 'no'),
(12, 'no'),
(13, 'no'),
(14, 'no'),
(15, 'no'),
(16, 'no');

-- --------------------------------------------------------

--
-- Table structure for table `food`
--

CREATE TABLE `food` (
  `food_id` int(3) NOT NULL,
  `food_name` varchar(30) NOT NULL,
  `price` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `food`
--

INSERT INTO `food` (`food_id`, `food_name`, `price`) VALUES
(101, 'Lays', 10),
(102, 'Paprika', 5),
(103, 'Cornae', 30),
(104, 'Testo', 15),
(105, 'Potae', 20),
(106, 'Pringles', 30),
(201, 'Water', 8),
(202, 'Est', 10),
(203, 'Coke', 15),
(204, 'Ichitan', 20),
(205, 'Sprite', 15),
(206, 'CokeZero', 20);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(3) NOT NULL,
  `computer_number` varchar(5) NOT NULL,
  `detail` varchar(200) NOT NULL,
  `total_price` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `computer_number`, `detail`, `total_price`) VALUES
(4, '2', ' Testo: 1', '15'),
(5, '2', ' Testo: 2 Water: 3 Ichitan: 2', '94'),
(6, '2', ' Testo: 3 Water: 3', '69'),
(7, '2', ' Testo: 2 Water: 4 Ichitan: 5', '162'),
(8, '2', ' Lay: 6 Water: 6', '108'),
(9, '3', ' Lay: 1 Est: 1 Testo: 1', '40'),
(10, '2', ' Testo: 3', '45'),
(11, '1', ' Lay: 3 Coke: 3 Coke Zero: 6 Testo: 2 Potae: 3', '285');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(20) NOT NULL,
  `access_level` varchar(10) NOT NULL,
  `balance` int(10) NOT NULL,
  `hour` int(10) NOT NULL,
  `min` int(2) NOT NULL,
  `sec` int(2) NOT NULL,
  `status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `email`, `access_level`, `balance`, `hour`, `min`, `sec`, `status`) VALUES
(2, 'user', 'NzY1NDMyMQ==', 'user@test.com', 'guest', 470, 27, 53, 41, 'online'),
(19, 'admin', 'MTIzNDU2Nw==', 'admin@test.com', 'admin', 0, 0, 0, 0, 'offline');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `computer`
--
ALTER TABLE `computer`
  ADD PRIMARY KEY (`computer_number`);

--
-- Indexes for table `food`
--
ALTER TABLE `food`
  ADD PRIMARY KEY (`food_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
