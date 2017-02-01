-- phpMyAdmin SQL Dump
-- version 4.6.4deb1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Feb 01, 2017 at 11:34 AM
-- Server version: 5.7.17-0ubuntu0.16.10.1
-- PHP Version: 7.0.13-0ubuntu0.16.10.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `progra3_exa2`
--

-- --------------------------------------------------------

--
-- Table structure for table `Author`
--

CREATE TABLE `Author` (
  `idAuthor` int(11) NOT NULL,
  `name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Author`
--

INSERT INTO `Author` (`idAuthor`, `name`) VALUES
(1221, 'Ericka'),
(4343, 'Mauricio'),
(7989, 'Duck');

-- --------------------------------------------------------

--
-- Table structure for table `AuthorContact`
--

CREATE TABLE `AuthorContact` (
  `idAuthorContact` int(11) NOT NULL,
  `contact` text NOT NULL,
  `type` text NOT NULL,
  `idAuthor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `AuthorContact`
--

INSERT INTO `AuthorContact` (`idAuthorContact`, `contact`, `type`, `idAuthor`) VALUES
(1012, '76757432', 'celular', 4343),
(3323, 'mau@hotmail.com', 'correo', 7989),
(5656, '89878685', 'celular', 1221);

-- --------------------------------------------------------

--
-- Table structure for table `Book`
--

CREATE TABLE `Book` (
  `idBook` int(11) NOT NULL,
  `idAuthor` int(11) NOT NULL,
  `name` text NOT NULL,
  `dataRelease` date NOT NULL,
  `price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Book`
--

INSERT INTO `Book` (`idBook`, `idAuthor`, `name`, `dataRelease`, `price`) VALUES
(7007, 4343, 'Solo Escucha', '2016-06-30', 30000),
(8008, 7989, 'Accion enfocada', '2016-11-02', 50000),
(9009, 1221, 'Las Reliquias de Santa Catalina', '2017-01-31', 12000);

-- --------------------------------------------------------

--
-- Table structure for table `BookType`
--

CREATE TABLE `BookType` (
  `idType` int(11) NOT NULL,
  `idBook` int(11) NOT NULL,
  `Type` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `BookType`
--

INSERT INTO `BookType` (`idType`, `idBook`, `Type`) VALUES
(1001, 7007, 'Aprendizaje'),
(2002, 8008, 'Motivacion'),
(3003, 9009, 'Religion');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Author`
--
ALTER TABLE `Author`
  ADD PRIMARY KEY (`idAuthor`);

--
-- Indexes for table `AuthorContact`
--
ALTER TABLE `AuthorContact`
  ADD PRIMARY KEY (`idAuthorContact`);

--
-- Indexes for table `Book`
--
ALTER TABLE `Book`
  ADD PRIMARY KEY (`idBook`);

--
-- Indexes for table `BookType`
--
ALTER TABLE `BookType`
  ADD PRIMARY KEY (`idType`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Author`
--
ALTER TABLE `Author`
  MODIFY `idAuthor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7990;
--
-- AUTO_INCREMENT for table `AuthorContact`
--
ALTER TABLE `AuthorContact`
  MODIFY `idAuthorContact` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5657;
--
-- AUTO_INCREMENT for table `Book`
--
ALTER TABLE `Book`
  MODIFY `idBook` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9010;
--
-- AUTO_INCREMENT for table `BookType`
--
ALTER TABLE `BookType`
  MODIFY `idType` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3004;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
