-- Copiando estrutura do banco de dados para banco_de_dados
CREATE DATABASE IF NOT EXISTS `banco_de_dados` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_danish_ci */;
USE `banco_de_dados`;

-- Copiando estrutura para tabela banco_de_dados.tarefa
CREATE TABLE IF NOT EXISTS `tarefa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tarefa` varchar(200) COLLATE latin1_danish_ci DEFAULT NULL,
  `data` date DEFAULT NULL,
  `hora` varchar(50) COLLATE latin1_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 COLLATE=latin1_danish_ci;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela banco_de_dados.user
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE latin1_danish_ci NOT NULL,
  `email` varchar(50) COLLATE latin1_danish_ci NOT NULL,
  `password` varchar(50) COLLATE latin1_danish_ci NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1 COLLATE=latin1_danish_ci;

-- Exportação de dados foi desmarcado.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
