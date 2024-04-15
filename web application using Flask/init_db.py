# import sqlite3
import sqlite3

# open a connection to the database
connection = sqlite3.connect('database2.db')

# create the schema.sql file
with open('schema.sql') as f:
    connection.executescript(f.read())

# create cursor object
cur = connection.cursor()

# insert data into table posts

# insert data into table posts
cur.execute("INSERT INTO posts (title2) VALUES (?)",
             ('Title2')
             )


 # cur.execute("INSERT INTO observations (birdhouse, date, species, eggs, living, dead, comments) VALUES (?, ?)",
 #            ('First Observation', 'Content for the first observation')
 #            )

# cur.execute("INSERT INTO observations (birdhouse, date, species, eggs, living, dead, comments) VALUES (?, ?)",
  #          ('Second Observation', 'Content for the second observation')
   #             )

# commit changes to database and closet the connection
connection.commit()
connection.close()