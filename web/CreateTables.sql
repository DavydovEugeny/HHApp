USE hr;

CREATE TABLE `departments` (
  `id_dep` int(11) NOT NULL AUTO_INCREMENT,
  `bossdep` varchar(50) DEFAULT NULL,
  `namedep` varchar(50) DEFAULT NULL,
  `region` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_dep`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `employees` (
  `id_em` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `middlename` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `salary` varchar(20) DEFAULT NULL,
  `id_dep` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_em`),
  FOREIGN KEY (`department_id`) REFERENCES `departments` (`id_dep`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8