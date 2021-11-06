CREATE DATABASE IF NOT EXISTS gemini;

CREATE USER 'gemini'@'%' IDENTIFIED BY 'gemini';

GRANT ALL ON `gemini`.* TO 'gemini'@'%';