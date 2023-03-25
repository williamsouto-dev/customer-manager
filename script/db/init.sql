CREATE USER customermanager WITH PASSWORD '19bbb17901dd90017dda9e2be4cc2dfdd41d8cd98f00b204e9800998ecf8427e';
CREATE DATABASE db_customer_manager;

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO customermanager;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO customermanager;
GRANT ALL PRIVILEGES ON DATABASE db_customer_manager TO customermanager;
