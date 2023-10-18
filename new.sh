#!/bin/bash

# Copy a file
# Get the current working directory
current_directory=$(pwd)

# Get the source file from the user
source_file=$current_directory/"app/src/demoRelease/generated/baselineProfiles/baseline-prof.txt"

# Get the destination file from the user
destination_file=$current_directory/"app/src/prodRelease/generated/baselineProfiles/baseline-prof.txt"

# Create the destination file if it does not exist
if [ ! -f "$destination_file" ]; then
  mkdir -p "$(dirname "$destination_file")"
  touch "$destination_file"
fi

# Copy the file
cp "$source_file" "$destination_file"

foo foo foo foo
foo foo foo foo
foo foo foo foo
foo foo foo foo