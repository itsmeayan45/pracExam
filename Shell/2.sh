#!/bin/bash

# Prompt user for input
read -p "Enter the value of x: " x
read -p "Enter the number of terms (n): " n

# We use awk to handle the logic and floating point math
# -v x="$x" passes the shell variable x into awk
# -v n="$n" passes the shell variable n into awk

awk -v x="$x" -v n="$n" '
BEGIN {
    
    sum = 1;

    for (i = 2; i <= n; i++) {
        
        term = (x / 2) ^ i;

        
        if (i % 2 == 0) {
            
            sum = sum + term;
        } else {
            
            sum = sum - term;
        }
    }
    printf "-----------------------------------\n";
    printf "The sum of the series is: %.4f\n", sum;
    printf "-----------------------------------\n";
}'