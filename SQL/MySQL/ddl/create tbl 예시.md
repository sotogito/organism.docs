```sql
CREATE TABLE IF NOT EXISTS tbl_user(
    user_no INT AUTO_INCREMENT, 
    user_id VARCHAR(225) NOT NULL UNIQUE, 
    user_pwd VARCHAR(225) NOT NULL,
    user_name VARCHAR(225) NOT NULL,
    gender CHAR(3) CHECK(gender IN ('남','여')),
    age INT,

    PRIMARY KEY(user_no),
    CHECK(age >= 19)
);
```
