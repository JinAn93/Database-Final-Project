CREATE TABLE Users(
    user_id VARCHAR(30) NOT NULL,
    name VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    PRIMARY KEY(user_id)
);

CREATE TABLE Posts(
    id INT NOT NULL auto_increment,
    title VARCHAR(100) NOT NULL,
    contents VARCHAR(150) NOT NULL,
    post_date DATE NOT NULL,
    user_id VARCHAR(30) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id)
);