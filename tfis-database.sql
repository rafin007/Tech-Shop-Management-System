-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 31, 2016 at 12:47 AM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tfis-database`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `Name` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Email` varchar(20) NOT NULL,
  `Gender` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Name`, `Password`, `Email`, `Gender`) VALUES
('Admin', 'Admin', 'admin@live.com', 'Male'),
('Admin', 'admin', 'admin', 'Male');

-- --------------------------------------------------------

--
-- Table structure for table `cpu_list`
--

CREATE TABLE `cpu_list` (
  `Product ID` int(15) NOT NULL,
  `Model` varchar(40) NOT NULL,
  `Regular Price` int(20) NOT NULL,
  `Discounted Price` int(20) NOT NULL,
  `Quantity` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cpu_list`
--

INSERT INTO `cpu_list` (`Product ID`, `Model`, `Regular Price`, `Discounted Price`, `Quantity`) VALUES
(1, 'AMD FX™ 8370 processor', 12000, 11890, 15),
(2, 'Core i5 6th 3.20Ghz', 14500, 13800, 20),
(3, 'BullDozer HQ 4.10Ghz', 34500, 32000, 22),
(4, 'Intel Core i7 Skylake 6700HQ 4.10Ghz ', 28500, 26700, 30),
(6, 'Intel Pantium Quad Core 4300 2.60Ghz', 6500, 6200, 20),
(7, 'Intel core i5 5th gen', 11500, 10700, 25);

-- --------------------------------------------------------

--
-- Table structure for table `gpu_list`
--

CREATE TABLE `gpu_list` (
  `Product ID` int(20) NOT NULL,
  `Model` varchar(50) NOT NULL,
  `Regular Price` int(20) NOT NULL,
  `Discounted Price` int(20) NOT NULL,
  `Quantity` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `gpu_list`
--

INSERT INTO `gpu_list` (`Product ID`, `Model`, `Regular Price`, `Discounted Price`, `Quantity`) VALUES
(4, 'Gigabyte Radeon HD 6770 2GB DDR5', 8500, 8100, 30),
(5, 'MSI TwinFrozer GTX 1080 6GB DDR5 ', 75000, 72300, 5),
(8, 'Sapphire Radeon R9 360 3GB DDR5', 25000, 24600, 5),
(10, 'Asus Strix GTX 960 4GB DDR5 ', 21800, 21000, 15),
(11, 'Asus GTX 750 ti 2GB DDR5', 11500, 11000, 10),
(12, 'Zotac GTX 1080 4GB DDR5', 54500, 52000, 6);

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `Model` varchar(40) NOT NULL,
  `Price` int(20) NOT NULL,
  `Quantity` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`Model`, `Price`, `Quantity`) VALUES
('Sapphire Radeon R9 360 3GB DDR5', 24600, 1),
('Sapphire Radeon R9 360 3GB DDR5', 24600, 1);

-- --------------------------------------------------------

--
-- Table structure for table `io_list`
--

CREATE TABLE `io_list` (
  `Product ID` int(20) NOT NULL,
  `Model` varchar(30) NOT NULL,
  `Regular Price` int(20) NOT NULL,
  `Discounted Price` int(20) NOT NULL,
  `Quantity` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `io_list`
--

INSERT INTO `io_list` (`Product ID`, `Model`, `Regular Price`, `Discounted Price`, `Quantity`) VALUES
(21, 'ThermalTake Gaming Keyboard', 3000, 2500, 10),
(22, 'Rapoo Mouse and Keyboard Combo', 4770, 4550, 10),
(23, 'Logitech B110 Mouse', 1220, 1000, 10),
(24, 'Havit H350 Wireless Keyboard', 1790, 1540, 10);

-- --------------------------------------------------------

--
-- Table structure for table `printer_list`
--

CREATE TABLE `printer_list` (
  `Product ID` int(20) NOT NULL,
  `Model` varchar(40) NOT NULL,
  `Regular Price` int(20) NOT NULL,
  `Discounted Price` int(20) NOT NULL,
  `Quantity` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `printer_list`
--

INSERT INTO `printer_list` (`Product ID`, `Model`, `Regular Price`, `Discounted Price`, `Quantity`) VALUES
(31, 'HP LaserJet M477', 8000, 7550, 10),
(32, 'HP Deskjet X476', 6000, 5740, 10),
(33, 'HP OfficeJet 5110 3in1 printer', 6500, 6390, 10),
(34, 'Epson L220 InkJet', 8000, 7770, 10),
(35, 'Brother MFC-85190 Laser Printer', 9000, 8850, 10),
(36, 'Brother HL 5440 Laser Printer', 7500, 7299, 10);

-- --------------------------------------------------------

--
-- Table structure for table `purchase_history`
--

CREATE TABLE `purchase_history` (
  `Product Model` varchar(40) NOT NULL,
  `Price` int(20) NOT NULL,
  `Product Quantity` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchase_history`
--

INSERT INTO `purchase_history` (`Product Model`, `Price`, `Product Quantity`) VALUES
('AMD FX™ 8370 processor', 11890, 1),
('Intel core i5 5th gen', 32100, 3),
('Core i5 6th 3.20Ghz', 69000, 5),
('Core i5 6th 3.20Ghz', 69000, 5),
('AMD FX™ 8370 processor', 59450, 5),
('BullDozer HQ 4.10Ghz', 160000, 5),
('Zotac GTX 1080 4GB DDR5', 208000, 4),
('Core i5 6th 3.20Ghz', 55200, 4),
('AMD FX™ 8370 processor', 35670, 3),
('BullDozer HQ 4.10Ghz', 96000, 3),
('', 0, 1),
('', 0, 1),
('Core i5 6th 3.20Ghz', 69000, 5),
('MSI TwinFrozer GTX 1080 6GB DDR5 ', 72300, 1),
('Sapphire Radeon R9 360 3GB DDR5', 24600, 1),
('Sapphire Radeon R9 360 3GB DDR5', 24600, 1);

-- --------------------------------------------------------

--
-- Table structure for table `ram_list`
--

CREATE TABLE `ram_list` (
  `Product ID` int(20) NOT NULL,
  `Model` varchar(40) NOT NULL,
  `Regular Price` int(20) NOT NULL,
  `Discounted Price` int(20) NOT NULL,
  `Quantity` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ram_list`
--

INSERT INTO `ram_list` (`Product ID`, `Model`, `Regular Price`, `Discounted Price`, `Quantity`) VALUES
(41, 'Patriot Viper 4 16GB DDR4', 12000, 11700, 10),
(42, 'G.Skill Ripjaws 4 16GB DDR4', 10000, 9800, 10),
(43, 'Mushkin Enhanced Redline 16GB DDR4', 14000, 13900, 10),
(44, 'Corsair Vengeance LPX 16GB DDR4', 40000, 38500, 10),
(45, 'G.Skill Trident 6GB DDR4 F4-3400C16D', 9500, 9220, 10);

-- --------------------------------------------------------

--
-- Table structure for table `registered_users`
--

CREATE TABLE `registered_users` (
  `Name` varchar(50) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `Gender` varchar(30) NOT NULL,
  `Address` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registered_users`
--

INSERT INTO `registered_users` (`Name`, `Email`, `Password`, `Gender`, `Address`) VALUES
('Fahad Ahmed', 'fahad1415@yahoo.com', '6251', 'Male', 'Kollyanpur,Dhaka'),
('Arefin', 'arefin@outlook.com', 'arefin', 'Male', 'Dhaka'),
('Navid', 'navid@gmail.com', 'navid', 'Male', 'Dhaka'),
('Fahim Ahmed', 'fahim152@gmail.com', '1234', 'Male', 'Dhaka');

-- --------------------------------------------------------

--
-- Table structure for table `storage_list`
--

CREATE TABLE `storage_list` (
  `Product ID` int(20) NOT NULL,
  `Model` varchar(40) NOT NULL,
  `Regular Price` int(20) NOT NULL,
  `Discounted Price` int(20) NOT NULL,
  `Quantity` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `storage_list`
--

INSERT INTO `storage_list` (`Product ID`, `Model`, `Regular Price`, `Discounted Price`, `Quantity`) VALUES
(51, 'Western Digital 7200rpm 1TB HDD', 8000, 7800, 10),
(52, 'SeaGate 2TB 7200rpm 6Gbps HDD', 13000, 12899, 10),
(53, 'Transcend 500GB Grade Portable HDD', 5000, 4880, 10),
(54, 'Corsair 256 GB SSD', 10000, 9800, 10),
(55, 'Intel® SSD 600p 256GB', 12000, 11800, 10);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cpu_list`
--
ALTER TABLE `cpu_list`
  ADD PRIMARY KEY (`Product ID`);

--
-- Indexes for table `gpu_list`
--
ALTER TABLE `gpu_list`
  ADD PRIMARY KEY (`Product ID`);

--
-- Indexes for table `io_list`
--
ALTER TABLE `io_list`
  ADD PRIMARY KEY (`Product ID`);

--
-- Indexes for table `printer_list`
--
ALTER TABLE `printer_list`
  ADD PRIMARY KEY (`Product ID`);

--
-- Indexes for table `ram_list`
--
ALTER TABLE `ram_list`
  ADD PRIMARY KEY (`Product ID`);

--
-- Indexes for table `storage_list`
--
ALTER TABLE `storage_list`
  ADD PRIMARY KEY (`Product ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
