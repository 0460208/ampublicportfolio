# Author: Amanda Martel
# Filename: hello.py
# Description: A fully functional web application using Flask.
# Class: WDD 3500 - week 12 assignment
# Date: 4/27/2023

# import Flask object from flask package
from flask import Flask

# create Flask application instance
# pass variable __name__
app = Flask(__name__)


# create route
@app.route('/')
def hello():
    return 'Hello, World!'


