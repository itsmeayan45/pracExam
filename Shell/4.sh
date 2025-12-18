#!/bin/bash

# Check if arguments are provided
if [ $# -eq 0 ]; then
    echo "Usage: $0 num1 num2 [num3 ...]"
    exit 1
fi

# --- Function to calculate GCD of two numbers ---
# Uses the Euclidean algorithm:
# while b != 0: t = b; b = a % b; a = t
gcd_two() {
    local dividend=$1
    local divisor=$2
    
    while [ $divisor -ne 0 ]; do
        local remainder=$((dividend % divisor))
        dividend=$divisor
        divisor=$remainder
    done
    echo $dividend
}

# --- Function to calculate LCM of two numbers ---
# Formula: (a * b) / gcd(a, b)
# Implementation: (a / gcd(a,b)) * b  <-- prevents intermediate overflow
lcm_two() {
    local a=$1
    local b=$2
    
    # Handle zero cases
    if [ $a -eq 0 ] || [ $b -eq 0 ]; then
        echo 0
        return
    fi
    
    local current_gcd=$(gcd_two $a $b)
    local result=$(( (a / current_gcd) * b ))
    echo $result
}

# --- Main Logic ---

# Initialize current GCD and LCM with the first number
# We calculate iteratively: GCD(a, b, c) = GCD(GCD(a, b), c)
final_gcd=$1
final_lcm=$1

# Loop through the remaining arguments
shift # Remove the first argument ($1) so $@ starts from the second number
for num in "$@"; do
    final_gcd=$(gcd_two $final_gcd $num)
    final_lcm=$(lcm_two $final_lcm $num)
done

# --- Output Results ---
echo "Numbers: $1 $@" # Note: $1 is gone due to shift, but we print remaining
# To verify input visually, usually, we rely on the input line, 
# but here is the final calculation:

echo "-------------------------"
echo "GCD: $final_gcd"
echo "LCM: $final_lcm"
echo "-------------------------"