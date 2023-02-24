#!/bin/bash

rm *.class
rm visitor/*.class
rm syntaxtree/*.class

javac Main.java < out.java

