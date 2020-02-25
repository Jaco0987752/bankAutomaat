#!/bin/bash
CWD=$(pwd)

echo $CWD

DIR=bin
 if [ ! -d "$DIR" ]; then
     mkdir -p $DIR
 fi

#-d $DIR
 if javac  -d $DIR *.java;
then
    echo classes compiled
    cd ./bin
     jar cfe App.jar GUI_ATM.App ./GUI_ATM
     echo jar made
     DISPLAY=:0 java -jar App.jar
fi