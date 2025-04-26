#!/bin/sh

# Change to the directory this script is in
cd "$(dirname "$0")"

# Run the Main.class file with the provided arguments
java -cp "../lib/two-slices-0.9.4.jar:." Main "$@"

exit
