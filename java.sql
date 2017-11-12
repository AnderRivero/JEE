-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-11-2017 a las 21:36:56
-- Versión del servidor: 10.1.25-MariaDB
-- Versión de PHP: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `java`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `amigo`
--

CREATE TABLE `amigo` (
  `cedula` varchar(20) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `us` varchar(20) DEFAULT NULL,
  `pass` varchar(30) DEFAULT NULL,
  `id_amigo` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `amigo`
--

INSERT INTO `amigo` (`cedula`, `nombre`, `us`, `pass`, `id_amigo`) VALUES
('12365495', 'Carlos Uzcategui', 'CarLug', '123124', '19668868'),
('19668868', 'Jose Gomez', 'jxzgxz', '654564', '19668868'),
('30263978', 'Angelo Romero', 'El niño', 'asdlajksd', '19668868'),
('789654', 'Doña Jaquelin', 'JoseRGuzman', 'Lasdase', '8838411'),
('9765431', 'Carmen Guanipa', 'carolina', '6548987', '19668868');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id_producto` int(11) NOT NULL,
  `codigo` int(11) DEFAULT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `importado` varchar(20) DEFAULT NULL,
  `precio` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id_producto`, `codigo`, `nombre`, `importado`, `precio`) VALUES
(1, 1, 'cambur', 'true', 2500),
(2, 2, 'fresa', 'false', 3200),
(3, 3, 'melocoton', 'true', 5000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `cedula` varchar(20) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `us` varchar(20) DEFAULT NULL,
  `pass` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`cedula`, `nombre`, `us`, `pass`) VALUES
('1478596', 'asdagfasdg', '156332151', '123112'),
('19668868', 'Alfredo Rivero', 'c', '123'),
('24299237', 'Hellmuth Wladimir', 'Htrejo', '123456'),
('8838411', 'Tibisay Miranda', 'Tmiranda', '123456');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `amigo`
--
ALTER TABLE `amigo`
  ADD PRIMARY KEY (`cedula`),
  ADD KEY `id_amigo` (`id_amigo`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id_producto`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`cedula`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `amigo`
--
ALTER TABLE `amigo`
  ADD CONSTRAINT `amigo_ibfk_1` FOREIGN KEY (`id_amigo`) REFERENCES `usuario` (`cedula`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
