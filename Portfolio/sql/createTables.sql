CREATE DATABASE IF NOT EXISTS conygre;
use conygre;
CREATE TABLE stocks(
id int primary key auto_increment,
ticker varchar(255),
price double,
amount int,
transaction_type varchar(10)
);

CREATE TABLE stocks_history(
id int primary key auto_increment,
ticker varchar(255),
price double,
amount int,
is_sold int
);

insert into stocks values(1, 'AAPL', 171.40, 10, 'BUY');
insert into stocks values(2, 'AAPL', 173.80, 10, 'SELL');

use conygre; 

insert into stocks_history values(1, 'AAPL', 171.40, 10, 0);