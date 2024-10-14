:: this file must be in the root.
@echo off
echo STARTING COMPILATION PROCESS

IF "%1"=="" (
    echo Specifica un nome di file come argomento.
)

IF NOT EXIST "it\unisannio\paradigmi\generated" (
    mkdir "it\unisannio\paradigmi\generated"
)

cd "it\unisannio\paradigmi\generated"
del *.java
cd ..
cd ..
cd ..
cd ..

call javacc %1

move *.java "it\unisannio\paradigmi\generated"
echo.



echo COMPILED SUCCESSFULLY!!.