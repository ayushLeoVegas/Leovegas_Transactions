DROP TABLE IF EXISTS transaction_details;

DROP TABLE IF EXISTS account_details;
 
CREATE TABLE transaction_details (
  transaction_id bigint AUTO_INCREMENT  PRIMARY KEY,
  amount bigint NOT NULL,
  created_at TIMESTAMP NOT NULL,
  direction ENUM ('CREDIT','DEBIT') NOT NULL,
  currency VARCHAR(250) NOT NULL,
  player_id VARCHAR(250) NOT NULL,
  account_number VARCHAR(250) NOT NULL
);


CREATE TABLE account_details (
  amount bigint NOT NULL,
  created_at TIMESTAMP NOT NULL,
  currency VARCHAR(250) NOT NULL,
  player_id VARCHAR(250) NOT NULL,
  account_number VARCHAR(250) NOT NULL PRIMARY KEY
);


INSERT INTO 
	account_details (amount, created_at, currency,player_id,account_number) 
VALUES
  	('500', '1970-01-01 00:00:01', 'GBP','A1','20201'),
  	('1000', '1970-01-01 00:00:01', 'GBP','A2','20202');
 