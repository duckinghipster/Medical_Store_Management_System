-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 25, 2015 at 07:33 AM
-- Server version: 5.6.21
-- PHP Version: 5.5.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `medical_store`
--

-- --------------------------------------------------------

--
-- Table structure for table `medicine`
--

CREATE TABLE IF NOT EXISTS `medicine` (
  `mbno` varchar(10) NOT NULL,
  `mname` varchar(50) DEFAULT NULL,
  `mcompany` varchar(50) DEFAULT NULL,
  `mqty` int(10) DEFAULT NULL,
  `mexpdate` varchar(50) DEFAULT NULL,
  `mpurdate` varchar(50) DEFAULT NULL,
  `mtype` varchar(30) DEFAULT NULL,
  `mpurprice` float DEFAULT NULL,
  `msaleprice` float DEFAULT NULL,
  `mrackno` varchar(20) DEFAULT NULL,
  `sid` int(10) DEFAULT NULL,
  `sname` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `medicine`
--

INSERT INTO `medicine` (`mbno`, `mname`, `mcompany`, `mqty`, `mexpdate`, `mpurdate`, `mtype`, `mpurprice`, `msaleprice`, `mrackno`, `sid`, `sname`) VALUES
('as234', 'you', 'your', 45, '9-2015', '29-5-2015', 'Capsule', 70, 90, 'a', 6, 'nitin pawar'),
('E20302', 'Mecobion-OD', 'Medley pharmacceuticals ltd', 100, '8-2013', '6-2-2013', 'Tablet', 50, 78, 'm', 2, 'rupesh kamble'),
('l127', 'cystone', 'himalaya', 60, '2-2015', '6-2-2013', 'Tablet', 60, 80, 'c', 7, 'baban marne'),
('m145', 'metxl-25', 'meta parma', 10, '5-2014', '6-2-2013', 'Tablet', 80, 100, 'm', 3, 'Ganesh marne'),
('p20776', 'GlimiSave-4', 'Gilmepiride', 100, '7-2014', '6-2-2013', 'Tablet', 70, 87, 'g', 1, 'akshay mahadik'),
('q111', 'vix500', 'vix  pharma', 10, '2-2014', '7-2-2013', 'Tablet', 25, 50, 'v1', 2, 'Ganesh marne'),
('r2025', 'tiger balm', 'makson pvt ltd', 50, '2-2016', '6-2-2013', 'Balm', 15, 27, 'x', 6, 'nitin pawar'),
('s1234', 'combiflan-5mg', 'combifan pharma', 10, '4-2015', '7-2-2013', 'Tablet', 50, 100, 'c1', 2, 'rupesh kamble'),
('s167', 'supradin', 'supra phrma', 50, '8-2014', '6-2-2013', 'Tablet', 17, 30, 's', 4, 'Mayur joshi'),
('S678', 'zuphar', 'his', 100, '9-2016', '29-5-2015', 'Tablet', 40, 50, 'g', 1, 'akshay mahadik'),
('w12', 'crocine', 'crocine pharma', 10, '2-2015', '7-2-2013', 'Tablet', 50, 100, 'c`', 2, 'rupesh kamble');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE IF NOT EXISTS `supplier` (
`sid` int(10) NOT NULL,
  `sname` varchar(50) DEFAULT NULL,
  `saddress` varchar(100) DEFAULT NULL,
  `sphoneno` varchar(20) DEFAULT NULL,
  `semailid` varchar(30) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`sid`, `sname`, `saddress`, `sphoneno`, `semailid`) VALUES
(1, 'akshay mahadik', 'kothrud,pune-411038', '9604856881', 'akshay@gmail.com'),
(2, 'rupesh kamble', 'varaje,Pune-411052', '9869663450', 'rpesh@gmail.com'),
(3, 'Ganesh marne', 'sadashiv peth,pune-411001', '9922205610', 'ganesh@gmail.com'),
(4, 'Mayur joshi', 'sadashiv peth,pune-4110111', '98989863620', 'mayur@gmail.com'),
(5, 'dinesh divekar', 'kondhva', '89898565601', 'dinesh@gmail.com'),
(6, 'nitin pawar', 'pimpri,pune', '0202546468567', 'nitin@gmail.com'),
(7, 'baban marne', 'vadgaon,pune', '7788556611', 'baban@gmail.com'),
(9, 'arnav kulkarni', 'aundh,pune', '7852146585', 'arnav@gmail.com'),
(10, 'ganesh pawale', 'kothrud', '020-25487978', 'ganesh@gmail.com'),
(11, 'sagar sirke', 'ganesh nagar,pune', '8956237412', 'sagar@gmail.com'),
(12, 'sandeep shinde1', 'shashtrinagar,pune', '8789789899', 'sandeep@gmail.com'),
(13, 'akash rahane', 'kothrud,pune', '7858963258', 'aksha@gmail.com'),
(14, 'Ganesh vele', 'kothrud,pune', '7845123288', 'ganesh1@gmail.com'),
(16, 'harish rawat', 'nalstop ,pune', '78451203695', 'harish@gmail.com'),
(17, 'shubham nanda', 'A-5,SSK,Karnal', '8176026012', 'zzzshubhamnanda5474@gmail.com'),
(18, 'arjit', 'a-2,ssk', '8176026011', 'arjit@gmail.com'),
(19, 'salil', 'a-+1,ssk', '8234567891', 'salil@gmail.com'),
(20, 'sagar', 'badlapur', '8540237891', 'zzz@yahoo.in'),
(22, 'rip', 'gali', '1234567891', 'gali@cor.com'),
(23, 'hulk', 'forest', '9876543219', 'hulk@tod.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `medicine`
--
ALTER TABLE `medicine`
 ADD PRIMARY KEY (`mbno`), ADD KEY `sid` (`sid`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
 ADD PRIMARY KEY (`sid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
MODIFY `sid` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=24;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `medicine`
--
ALTER TABLE `medicine`
ADD CONSTRAINT `medicine_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `supplier` (`sid`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
