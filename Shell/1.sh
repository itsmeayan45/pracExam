#!/bin/bash

read -p "Enter the value of x: " x
read -p "Enter the number of terms: " n

sum=0

for (( i=1; i<=n; i++ )); do
    if [ $i -eq 1 ]; then
        term=$x
    else
        p=$(( 2 * (i - 1) ))
        
        # Calculate factorial
        fact=1
        for (( j=1; j<=p; j++ )); do
            fact=$(( fact * j ))
        done
        
       
        term=$(awk "BEGIN {printf \"%.4f\", ($x ^ $p) / $fact}")
    fi
    
    # USE AWK TO ADD TO SUM
    sum=$(awk "BEGIN {printf \"%.4f\", $sum + $term}")
done

echo "Sum of the series is: $sum"