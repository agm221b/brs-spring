CREATE TABLE IF NOT EXISTS bus(
bus_id INTEGER AUTO_INCREMENT PRIMARY KEY,
bus_name VARCHAR(50) NOT NULL,
bus_type VARCHAR(50) NOT NULL,
bus_class VARCHAR(50) NOT NULL,
bus_source VARCHAR(50) NOT NULL,
bus_destination VARCHAR(50) NOT NULL,
start_time TIME NOT NULL,
end_time TIME NOT NULL,
no_of_seats TIME NOT NULL,
cost_per_seat TIME NOT NULL,
delete_flag INT NOT NULL DEFAULT 0);
--
CREATE TABLE IF NOT EXISTS bus_transaction(
transaction_id BIGINT AUTO_INCREMENT PRIMARY KEY,
journey_date DATE NOT NULL,
available_seats INT NOT NULL,
delete_flag INT NOT NULL DEFAULT 0);
--
CREATE TABLE IF NOT EXISTS booking(
booking_id INTEGER AUTO_INCREMENT PRIMARY KEY,
date_of_journey DATE NOT NULL,
mode_of_payment VARCHAR(20) NOT NULL,
total_cost DOUBLE NOT NULL,
booking_status VARCHAR(20) NOT NULL,
delete_flag INT NOT NULL DEFAULT 0);

CREATE TABLE IF NOT EXISTS passenger(
passenger_id INTEGER AUTO_INCREMENT PRIMARY KEY,
passenger_name VARCHAR(50) NOT NULL,
passenger_age INT NOT NULL,
passenger_gender CHAR(1) NOT NULL CHECK(passenger_gender='M' OR passenger_gender='F'))

CREATE TABLE IF NOT EXISTS user_details(
user_id INTEGER AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(50) NOT NULL UNIQUE,
pass VARCHAR(50) NOT NULL UNIQUE,
user_type CHAR(1) NOT NULL CHECK(user_type='C' OR user_type='A'),
email VARCHAR(50) NOT NULL,
phone_number INTEGER NOT NULL,
delete_flag INT NOT NULL DEFAULT 0
);