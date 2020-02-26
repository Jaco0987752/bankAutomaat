#!/bin/bash
CWD=$(PWD)
JAVA_FX=lib/javafx-sdk-13.0.2/lib
REALPATH_JAVA_FX=$CWD/$JAVA_FX

echo $REALPATH_JAVA_FX

echo $CWD

DIR=bin
 if [ ! -d "$DIR" ]; then
     mkdir -p $DIR
 fi

#-d $DIR
 if javac -d $DIR --module-path $REALPATH_JAVA_FX --add-modules javafx.controls,javafx.fxml $(find . -name '*.java');
then
    echo classes compiled

    cp -r ./View ./$DIR/ATM
    cd ./$DIR
    jar cfe App.jar ATM.App ./ATM/
    echo jar made

    java  --module-path $REALPATH_JAVA_FX --add-modules javafx.controls,javafx.fxml -jar App.jar
fi