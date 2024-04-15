DROP TABLE IF EXISTS posts;
CREATE TABLE posts (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    title TEXT NOT NULL,
    title2 TEXT NOT NULL,
    content TEXT NOT NULL
--    birdhouse TEXT NOT NULL,
--    obdate INT NOT NULL,
--    species VARCHAR(100) NOT NULL,
--    living INT NOT NULL,
--    dead INT NOT NULL,
--    comments TEXT NOT NULL
);