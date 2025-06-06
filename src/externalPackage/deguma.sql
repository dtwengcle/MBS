-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 27, 2025 at 11:00 AM
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
-- Database: `deguma`
--

-- --------------------------------------------------------

--
-- Table structure for table `logs`
--

CREATE TABLE `logs` (
  `log_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `action` text NOT NULL,
  `date_time` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `logs`
--

INSERT INTO `logs` (`log_id`, `user_id`, `action`, `date_time`) VALUES
(1, 15, 'User successfully logged in.', '2025-05-27 15:24:48'),
(2, 15, 'Login failed - incorrect password.', '2025-05-27 15:28:52'),
(3, 15, 'User with ID 15 logged in.', '2025-05-27 15:28:58'),
(4, 15, 'Login failed - incorrect password.', '2025-05-27 15:35:20'),
(5, 15, 'User with ID 15 logged in.', '2025-05-27 15:35:27'),
(6, 15, 'User with ID 15 opened Add User form.', '2025-05-27 15:35:33'),
(7, 15, 'User with ID 15 logged in.', '2025-05-27 15:39:48'),
(8, 15, 'User with ID 15 added new user: ashuri', '2025-05-27 15:40:37'),
(9, 15, 'User with ID 15 logged in.', '2025-05-27 15:56:36'),
(10, 15, 'User with ID 15 deleted user: 123123123', '2025-05-27 15:57:06'),
(11, 15, 'User with ID 15 updated user: test', '2025-05-27 15:57:23'),
(12, 15, 'User with ID 15 logged in.', '2025-05-27 16:00:58'),
(13, 15, 'User with ID 15 logged in.', '2025-05-27 16:13:54'),
(14, 15, 'User with ID 15 logged in.', '2025-05-27 16:16:00'),
(15, 15, 'User with ID 15 logged in.', '2025-05-27 16:34:08'),
(16, 15, 'User with ID 15 logged in.', '2025-05-27 16:46:03'),
(18, 15, 'User with ID 15 logged in.', '2025-05-27 16:48:01'),
(24, 15, 'User with ID 15 logged in.', '2025-05-27 16:58:50');

-- --------------------------------------------------------

--
-- Table structure for table `medicines`
--

CREATE TABLE `medicines` (
  `medicine_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` text DEFAULT NULL,
  `price` decimal(10,2) NOT NULL,
  `quantity_in_stock` int(11) NOT NULL,
  `expiration_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `medicines`
--

INSERT INTO `medicines` (`medicine_id`, `name`, `description`, `price`, `quantity_in_stock`, `expiration_date`) VALUES
(2, 'Rexidol Forte', NULL, 10.00, 30, '2025-05-22'),
(3, 'Biogesic', NULL, 8.00, 30, '2025-05-22'),
(4, 'biotgisex', NULL, 10.00, 1000, '2025-05-22'),
(5, 'neozeop', NULL, 5.00, 100, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL,
  `customer_name` varchar(100) NOT NULL,
  `order_date` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`order_id`, `customer_name`, `order_date`) VALUES
(3, 'Queny', '2025-05-21 00:00:00'),
(5, 'maasdf', '2025-05-21 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `order_items`
--

CREATE TABLE `order_items` (
  `order_item_id` int(11) NOT NULL,
  `order_id` int(11) DEFAULT NULL,
  `medicine_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `total_price` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `order_items`
--

INSERT INTO `order_items` (`order_item_id`, `order_id`, `medicine_id`, `quantity`, `total_price`) VALUES
(3, 3, 3, 30, 240.00),
(5, 5, 2, 3, 30.00);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `gender` varchar(100) NOT NULL,
  `role` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  `security_question` varchar(255) DEFAULT NULL,
  `security_answer` varchar(255) DEFAULT NULL,
  `profile_pic` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `username`, `gender`, `role`, `email`, `password`, `status`, `security_question`, `security_answer`, `profile_pic`) VALUES
(1, 'Twengcle Deguma', 'deguma', 'Female', 'Admin', 'twengcledeguma@gmail.com', 'pass143', 'Active', '', '', ''),
(2, 'Kasane Teto', 'poteto', 'Female', 'Staff', 'tetoworlddomination@gmail.com', '123123123', 'Pending', '', '', ''),
(5, 'Twengcle nay Gamay', 'qwe', 'Female', 'Admin', 'tengcle', 'qweqweqwe', 'Active', '', '', ''),
(6, 'Testing', 'test', 'Male', 'Staff', 'test@test', '123123', 'Pending', '', '', ''),
(8, 'Mark', 'markj', 'Male', 'Admin', 'markj@gmail.com', 'ba5d35b0a80f547ee9cbc42f9bc4ab1260d56e84a465ad0e1849e1fb2c0248f7', 'Active', 'What was the model of your first car?', 'bmw', ''),
(12, 'mark', 'mark', 'Male', 'Staff', 'mark', '240be518fabd2724ddb6f04eeb1da5967448d7e831c08c8fa822809f74c720a9', 'Active', '', '', ''),
(14, 'testinging', 'testinging', 'Female', 'Admin', 'testinging@.cikm', '51baf95e1473e5373faa564fa39b04a1406e6bd8b390be91e67158f42666cb4d', 'Active', NULL, NULL, ''),
(15, 'John Phil Esconde', 'jampil', 'Male', 'Admin', 'john@gmail.com', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', 'Active', NULL, NULL, 'Ferdinand_E_Marcos.jpg'),
(16, 'Ash', 'ashuri', 'Female', 'Admin', 'ash@gmail.com', '123456', 'Active', NULL, NULL, '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `logs`
--
ALTER TABLE `logs`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `medicines`
--
ALTER TABLE `medicines`
  ADD PRIMARY KEY (`medicine_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`);

--
-- Indexes for table `order_items`
--
ALTER TABLE `order_items`
  ADD PRIMARY KEY (`order_item_id`),
  ADD KEY `order_id` (`order_id`),
  ADD KEY `medicine_id` (`medicine_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `logs`
--
ALTER TABLE `logs`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `medicines`
--
ALTER TABLE `medicines`
  MODIFY `medicine_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `order_items`
--
ALTER TABLE `order_items`
  MODIFY `order_item_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `logs`
--
ALTER TABLE `logs`
  ADD CONSTRAINT `logs_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `order_items`
--
ALTER TABLE `order_items`
  ADD CONSTRAINT `order_items_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `order_items_ibfk_2` FOREIGN KEY (`medicine_id`) REFERENCES `medicines` (`medicine_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
