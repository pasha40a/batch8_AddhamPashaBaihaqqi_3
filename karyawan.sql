-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 26 Mar 2021 pada 17.16
-- Versi server: 10.1.38-MariaDB
-- Versi PHP: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `karyawan`
--

DELIMITER $$
--
-- Prosedur
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `coba` (IN `nilai` INT)  NO SQL
SELECT department,COUNT(*)from worker GROUP BY department$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllSalary` (IN `nilai` INT(100))  NO SQL
SELECT * from worker$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getUpsalary` (IN `worker_id` INT(100), IN `first_name` VARCHAR(100), IN `last_name` VARCHAR(100), IN `salary` INT(100))  NO SQL
select worker_id,first_name,last_name,salary
from worker
where salary > 100000
order by worker_id ASC$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `bonus`
--

CREATE TABLE `bonus` (
  `worker_ref_id` int(11) NOT NULL,
  `bonus_date` datetime NOT NULL,
  `bonus_amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `bonus`
--

INSERT INTO `bonus` (`worker_ref_id`, `bonus_date`, `bonus_amount`) VALUES
(1, '2016-02-20 00:00:00', 5000),
(2, '2016-06-11 00:00:00', 3000),
(3, '2016-02-20 00:00:00', 4000),
(1, '2016-02-20 00:00:00', 4500),
(2, '2016-06-11 00:00:00', 3500);

-- --------------------------------------------------------

--
-- Struktur dari tabel `title`
--

CREATE TABLE `title` (
  `worker_ref_id` int(11) NOT NULL,
  `worker_title` varchar(30) NOT NULL,
  `affected_from` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `title`
--

INSERT INTO `title` (`worker_ref_id`, `worker_title`, `affected_from`) VALUES
(1, 'Manager', '2016-02-20 00:00:00'),
(2, 'Executive', '2016-06-11 00:00:00'),
(8, 'Executive', '2016-06-11 00:00:00'),
(5, 'Manager', '2016-06-11 00:00:00'),
(7, 'Executive', '2016-06-11 00:00:00'),
(6, 'Lead', '2016-06-11 00:00:00'),
(1, 'Lead', '2016-06-11 00:00:00');

-- --------------------------------------------------------

--
-- Struktur dari tabel `worker`
--

CREATE TABLE `worker` (
  `worker_id` int(11) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `salary` int(11) NOT NULL,
  `joining_date` datetime NOT NULL,
  `department` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `worker`
--

INSERT INTO `worker` (`worker_id`, `first_name`, `last_name`, `salary`, `joining_date`, `department`) VALUES
(1, 'Monika', 'Arora', 100000, '2014-02-20 00:00:00', 'HR'),
(2, 'Niharika', 'Verma', 80000, '2014-06-11 00:00:00', 'Admin'),
(3, 'Vishal', 'Singhal', 300000, '2014-02-20 00:00:00', 'HR'),
(4, 'Amitabh', 'Singh', 500000, '2014-02-20 00:00:00', 'Admin'),
(5, 'Vivek', 'Bhati', 500000, '2014-06-11 00:00:00', 'Admin'),
(6, 'Vipul', 'Diwan', 200000, '2014-06-11 00:00:00', 'Account'),
(7, 'Satish', 'Kumar', 75000, '2014-01-20 00:00:00', 'Account'),
(8, 'Geetika', 'Chauhan', 90000, '2014-04-11 00:00:00', 'Admin'),
(9, 'fikri', 'Ahay', 10000, '2014-04-11 00:00:00', 'Leader');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `worker`
--
ALTER TABLE `worker`
  ADD PRIMARY KEY (`worker_id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `worker`
--
ALTER TABLE `worker`
  MODIFY `worker_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
