CREATE TABLE users (
  chat_id       BIGINT          NOT NULL PRIMARY KEY,
  user_id       INT          NOT NULL,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL
)
  ENGINE = InnoDB;