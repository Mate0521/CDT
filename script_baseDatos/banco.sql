-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-07-2025 a las 18:00:27
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `banco`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cdt`
--

CREATE TABLE `cdt` (
  `numerocuenta` int(11) NOT NULL,
  `inversion` decimal(20,2) NOT NULL,
  `interes` double NOT NULL,
  `plazo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cdt`
--

INSERT INTO `cdt` (`numerocuenta`, `inversion`, `interes`, `plazo`) VALUES
(1001, 500000.00, 5.5, 12),
(1002, 750000.00, 4.8, 24),
(1003, 300000.00, 6, 6),
(1004, 1000000.00, 5.2, 18),
(1005, 250000.00, 4.5, 12),
(1006, 800000.00, 6.3, 36),
(1007, 400000.00, 4.9, 18),
(1008, 150000.00, 5, 6),
(1009, 200000.00, 5.7, 12),
(1010, 600000.00, 4.6, 24),
(1011, 950000.00, 5.1, 36),
(1012, 1200000.00, 6.2, 48),
(1013, 180000.00, 4.4, 12),
(1014, 330000.00, 5.6, 24),
(1015, 210000.00, 5, 18),
(1016, 700000.00, 5.9, 30),
(1017, 990000.00, 6, 24),
(1018, 100000.00, 4.3, 6),
(1019, 850000.00, 6.1, 36),
(1020, 500000.00, 5.4, 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `cedula` bigint(20) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `nacionalidad` varchar(20) NOT NULL,
  `fecha_nac` date NOT NULL,
  `numerocuenta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`cedula`, `nombre`, `nacionalidad`, `fecha_nac`, `numerocuenta`) VALUES
(1010101010, 'Paula', 'Colombiana', '1987-12-01', 1010),
(1111111111, 'Juan', 'Colombiana', '1990-05-12', 1001),
(1212121212, 'Jorge', 'Colombiana', '1990-04-08', 1011),
(1313131313, 'Valeria', 'Colombiana', '1992-07-19', 1012),
(1414141414, 'Camilo', 'Colombiana', '1993-11-23', 1013),
(1515151515, 'Tatiana', 'Colombiana', '1989-05-30', 1014),
(1616161616, 'Samuel', 'Colombiana', '1991-02-11', 1015),
(1717171717, 'Isabel', 'Colombiana', '1996-08-17', 1016),
(1818181818, 'Nicolas', 'Colombiana', '1994-03-22', 1017),
(1919191919, 'Angela', 'Colombiana', '1995-09-14', 1018),
(2020202020, 'Esteban', 'Colombiana', '1986-10-06', 1019),
(2121212121, 'Luisa', 'Colombiana', '1997-01-28', 1020),
(2222222222, 'Ana', 'Colombiana', '1985-08-22', 1002),
(3333333333, 'Carlos', 'Colombiana', '1992-03-15', 1003),
(4444444444, 'Laura', 'Colombiana', '1995-10-30', 1004),
(5555555555, 'Pedro', 'Colombiana', '1988-01-25', 1005),
(6666666666, 'Sofia', 'Colombiana', '1993-06-18', 1006),
(7777777777, 'Luis', 'Colombiana', '1991-11-09', 1007),
(8888888888, 'Diana', 'Colombiana', '1996-07-04', 1008),
(9999999999, 'Andres', 'Colombiana', '1994-09-12', 1009);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cdt`
--
ALTER TABLE `cdt`
  ADD PRIMARY KEY (`numerocuenta`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`cedula`),
  ADD KEY `numerocuenta` (`numerocuenta`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`numerocuenta`) REFERENCES `cdt` (`numerocuenta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
