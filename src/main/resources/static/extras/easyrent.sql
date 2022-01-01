-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 01, 2022 at 03:09 AM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `easyrent`
--

-- --------------------------------------------------------

--
-- Table structure for table `deals`
--

CREATE TABLE `deals` (
  `id` int(11) NOT NULL,
  `sid` text NOT NULL,
  `email` text NOT NULL,
  `name` text NOT NULL,
  `number` text NOT NULL,
  `address` text NOT NULL,
  `status` text NOT NULL DEFAULT 'Pending'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `deals`
--

INSERT INTO `deals` (`id`, `sid`, `email`, `name`, `number`, `address`, `status`) VALUES
(30, 'car0001', 'user@gmail.com', 'User', '1234', '456789fvfv', 'Pending');

-- --------------------------------------------------------

--
-- Table structure for table `profile`
--

CREATE TABLE `profile` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `email` text NOT NULL,
  `primarynumber` text NOT NULL,
  `secondarynumber` text DEFAULT NULL,
  `address` text NOT NULL,
  `city` text DEFAULT NULL,
  `country` text DEFAULT NULL,
  `postalcode` text DEFAULT NULL,
  `about` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `profile`
--

INSERT INTO `profile` (`id`, `name`, `email`, `primarynumber`, `secondarynumber`, `address`, `city`, `country`, `postalcode`, `about`) VALUES
(4, 'User', 'user@gmail.com', '1234', '1234567', '456789fvfv', 'dhaka', 'BD', '1212', '.......................'),
(5, 'tamzid', 'tamzid@g.com', '1234', '123456', '123568', 'dhaka', 'Bangladesh', '1245', '.................................');

-- --------------------------------------------------------

--
-- Table structure for table `services`
--

CREATE TABLE `services` (
  `id` int(11) NOT NULL,
  `type` text NOT NULL,
  `name` text NOT NULL,
  `img` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `services`
--

INSERT INTO `services` (`id`, `type`, `name`, `img`) VALUES
(3, 'Official', 'Transports', 'images/transports.png'),
(4, 'Sponsored', 'Transports', 'images/transports.png'),
(5, 'Official', 'Properties', 'images/properties.png'),
(6, 'Sponsored', 'Properties', 'images/properties.png'),
(7, 'Official', 'Heavy Equipment', 'images/heavy-equipments.png'),
(8, 'Sponsored', 'Heavy Equipment', 'images/heavy-equipments.png'),
(9, 'Official', 'Office Equipment', 'images/office-equipments.png'),
(10, 'Sponsored', 'Office Equipment', 'images/office-equipments.png'),
(11, 'Official', 'Event Equipment', 'images/event-equipments.png');

-- --------------------------------------------------------

--
-- Table structure for table `single_services`
--

CREATE TABLE `single_services` (
  `id` int(11) NOT NULL,
  `sid` text NOT NULL,
  `type` text NOT NULL,
  `service` text NOT NULL,
  `subservice` text NOT NULL,
  `name` text NOT NULL,
  `description` text NOT NULL,
  `cost` text NOT NULL,
  `img` text NOT NULL,
  `imgB` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `single_services`
--

INSERT INTO `single_services` (`id`, `sid`, `type`, `service`, `subservice`, `name`, `description`, `cost`, `img`, `imgB`) VALUES
(1, 'car0001', 'Official', 'Transports', 'Cars', 'Toyota bZ5X', 'Toyota’s bZ5X will be a three-row electric SUV similar in size and shape to the gas-powered Highlander crossover.', 'Tk.5000 (/Day)', 'images/toyotas.png', 'images/toyotab.png'),
(2, 'car0002', 'Sponsored', 'Transports', 'Cars', 'Toyota bZ5X', 'Toyota’s bZ5X will be a three-row electric SUV similar in size and shape to the gas-powered Highlander crossover.', 'Tk.5000 (/Day)', 'images/toyotas.png', 'images/toyotab.png');

-- --------------------------------------------------------

--
-- Table structure for table `subservices`
--

CREATE TABLE `subservices` (
  `id` int(11) NOT NULL,
  `type` text NOT NULL,
  `service` text NOT NULL,
  `subservice` text NOT NULL,
  `img` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `subservices`
--

INSERT INTO `subservices` (`id`, `type`, `service`, `subservice`, `img`) VALUES
(1, 'Official', 'Transports', 'Cars', 'images/cars.png'),
(2, 'Sponsored', 'Transports', 'Cars', 'images/cars.png');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `email` text NOT NULL,
  `password` text NOT NULL,
  `name` text NOT NULL,
  `number` text NOT NULL,
  `address` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `password`, `name`, `number`, `address`) VALUES
(17, 'user@gmail.com', '1234', 'User', '1234', '456789fvfv'),
(18, 'tamzid@g.com', '1234', 'tamzid', '1234', '123568');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `deals`
--
ALTER TABLE `deals`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `profile`
--
ALTER TABLE `profile`
  ADD PRIMARY KEY (`id`),
  ADD KEY `email` (`email`(768));

--
-- Indexes for table `services`
--
ALTER TABLE `services`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `single_services`
--
ALTER TABLE `single_services`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `subservices`
--
ALTER TABLE `subservices`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`) USING HASH;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `deals`
--
ALTER TABLE `deals`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `profile`
--
ALTER TABLE `profile`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `services`
--
ALTER TABLE `services`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `single_services`
--
ALTER TABLE `single_services`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `subservices`
--
ALTER TABLE `subservices`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
