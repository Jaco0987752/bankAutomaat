#!/bin/bash
CWD=$(pwd)
JAVA_FX=lib/javafx-sdk-13.0.2/lib
REALPATH_JAVA_FX=$CWD/$JAVA_FX
echo $REALPATH_JAVA_FX

DIR=bin
 if [ ! -d "$DIR" ]; then
     mkdir -p $DIR
 fi

#-d $DIR
 if javac -d $DIR --module-path $REALPATH_JAVA_FX -classpath $(pwd)/lib/jSerialComm-2.6.0.jar:$(pwd)/lib/org.json-chargebee-1.0.jar --add-modules javafx.controls,javafx.fxml $(find . -name '*.java');
then
    echo classes compiled

    cp -r ./View ./$DIR
    cd ./$DIR
    jar cfe App.jar ViewModel.App ./
    echo jar made

    java  --module-path $REALPATH_JAVA_FX --add-modules javafx.controls,javafx.fxml -jar App.jar
fi
cd ../
rm  -r bin
#rm -r $(find . -name '*.class') $(find . -name '*.fxml')