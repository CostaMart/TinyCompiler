@echo off
echo STARTING COMPILATION PROCESS

IF "%1"=="" (
    echo Specifica un nome di file come argomento.
)

IF NOT EXIST "javaFile\" (
    echo creating javaFile
    mkdir "javaFile\"
)

cd javaFile
echo Y | del *.java
cd ..

echo Javacc CALLED -------------
echo.
call javacc %1

move *.java "javaFile\"
echo.

cd javaFile

if NOT EXIST "javaCompiled\" (
    echo creating javaCompiled
    mkdir "javaCompiled\"
)

call javac *.java
cd javaCompiled
echo Y | del *.*

cd ..
move *.class "javaCompiled\"
cd ..
echo.
echo COMPILED SUCCESSFULLY!!.