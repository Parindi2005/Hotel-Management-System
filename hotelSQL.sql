create database hotel;

use hotel;

DROP TABLE IF EXISTS checkout;
CREATE TABLE IF NOT EXISTS checkout (
  id int NOT NULL,
  customer_name varchar(45) NOT NULL,
  allocated_room varchar(45) NOT NULL,
  check_in datetime NOT NULL,
  check_out datetime NOT NULL,
  total_cash double NOT NULL,
  PRIMARY KEY (id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table checkout
--

INSERT INTO checkout (id, customer_name, allocated_room, check_in, check_out, total_cash) VALUES
(4444, 'pradeep', '22', '2024-08-23 00:00:00', '2024-08-23 00:00:00', 11000);

-- --------------------------------------------------------

--
-- Table structure for table cus_register
--

DROP TABLE IF EXISTS cus_register;
CREATE TABLE IF NOT EXISTS cus_register (
  id int NOT NULL,
  customer_name varchar(45) NOT NULL,
  gender varchar(45) NOT NULL,
  allocated_room int NOT NULL,
  check_in datetime NOT NULL,
  type varchar(10) NOT NULL,
  bed_type varchar(45) NOT NULL,
  no_of_days int NOT NULL,
  food_beverage varchar(45) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table cus_register
--

INSERT INTO cus_register (id, customer_name, gender, allocated_room, check_in, type, bed_type, no_of_days, food_beverage) VALUES
(101010, 'pariii', 'Female', 1, '2024-08-18 00:00:00', '34000', '', 0, ''),
(12345, 'lasindu', 'Male', 22, '2024-08-23 00:00:00', 'AC', 'Double', 2, 'Yes');

-- --------------------------------------------------------

--
-- Table structure for table employees
--

DROP TABLE IF EXISTS employees;
CREATE TABLE IF NOT EXISTS employees (
  name varchar(20) NOT NULL,
  emp_id int NOT NULL,
  gender varchar(20) NOT NULL,
  job varchar(45) NOT NULL,
  age varchar(45) NOT NULL,
  salary double NOT NULL,
  contact int NOT NULL,
  email varchar(45) NOT NULL,
  PRIMARY KEY (emp_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table employees
--

INSERT INTO employees (name, emp_id, gender, job, age, salary, contact, email) VALUES
('parindi', 1, 'Female', 'Front Office', '19', 20000, 76543267, 'pbinarika@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table login
--

DROP TABLE IF EXISTS login;
CREATE TABLE IF NOT EXISTS login (
  id int NOT NULL,
  username varchar(25) NOT NULL,
  password varchar(45) NOT NULL,
  role varchar(45) not null,
  PRIMARY KEY (id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table login
--

INSERT INTO login (id, username, password,role) VALUES
(1, 'admin', 'password','admin'),
(2, 'pari', 'pari','receptionist');

-- --------------------------------------------------------

--
-- Table structure for table rooms
--

DROP TABLE IF EXISTS rooms;
CREATE TABLE IF NOT EXISTS rooms (
  room_no int NOT NULL,
  availability varchar(45) NOT NULL,
  price double NOT NULL,
  bed_type varchar(45) NOT NULL,
  type varchar(45) NOT NULL,
  PRIMARY KEY (room_no)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table rooms
--

INSERT INTO rooms (room_no, availability, price, bed_type, type) VALUES
(1, 'Not Allocate', 2000, 'Single', ''),
(10, 'Not Allocate', 3000, 'Double', ''),
(20, 'Not Allocate', 4000, 'Single', 'AC'),
(22, 'Allocate', 8000, 'Double', 'AC');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;