REM Prevent anything from displaying to the screen
@echo off

REM Change to the directory this script is in
cd /d "%~dp0"

REM Run the Main.class file with the provided arguments
java -cp "..\lib\two-slices-0.9.4.jar;." Main %*

exit
