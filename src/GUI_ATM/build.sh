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
 if javac -d $DIR --module-path $REALPATH_JAVA_FX --add-modules javafx.controls,javafx.fxml *.java;
then
    echo classes compiled
    cd ./bin
     jar cfe App.jar GUI_ATM.App ./GUI_ATM #*.class *.fxml #/c/xampp/htdocs/school/project_3-4/bankAutomaat/src/GUI_ATM/lib/javafx-sdk-13.0.2/lib
     echo jar made
     java  --module-path $REALPATH_JAVA_FX --add-modules javafx.controls,javafx.fxml -jar App.jar
fi