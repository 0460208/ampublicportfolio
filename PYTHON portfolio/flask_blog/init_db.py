# import sqlite3
import sqlite3

# open a connection to the datebase
connection = sqlite3.connect('database.db')

# create the schema.sql file
with open('schema.sql') as f:
    connection.executescript(f.read())

# create cursor object
cur = connection.cursor()

# insert data into table posts
cur.execute("INSERT INTO posts (title, content) VALUES (?, ?)",
             ('First Post', 'Content for the first post')
             )

cur.execute("INSERT INTO posts (title, content) VALUES (?, ?)",
            ('Second Post', 'Content for the second post')
                )

# commit changes to database and closet the connection
connection.commit()
connection.close()