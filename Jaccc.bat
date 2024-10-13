@echo off
echo start command

IF "%1"=="" (
    echo Specifica un nome di file come argomento.
)

IF NOT EXIST "javaFile\" (
    echo creating javaFile
    mkdir "javaFile\"
)

cd javaFile
del *.java
cd ..
cd src

echo before javacc
call javacc %1
move *.java "..\javaFile\"

cd ..
cd javaFile
echo moved java files to javaFile \n


if NOT EXIST "javaCompiled\" (
    echo creating javaCompiled
    mkdir "javaCompiled\"
)

call javac *.java
cd javaCompiled
del *.*

cd ..
move *.class "javaCompiled\"
cd ..