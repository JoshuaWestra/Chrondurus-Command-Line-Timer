@echo off
cd /d "%~dp0"
java -cp "..\lib\two-slices-0.9.4.jar;." Main %*
exit
