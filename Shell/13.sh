#!/bin/bash

# 1. Prompt user for input
read -p "Enter your birthday (dd/mm/yyyy): " birth_date

# 2. Extract Day, Month, Year from input
# IFS='/' sets the delimiter to slash
IFS='/' read -r b_day b_month b_year <<< "$birth_date"

# 3. Get current date details
c_day=$(date +%d)
c_month=$(date +%m)
c_year=$(date +%Y)

# Remove leading zeros (e.g., 08 -> 8) to prevent octal interpretation errors
# 10# forces base 10 interpretation
b_day=$((10#$b_day))
b_month=$((10#$b_month))
c_day=$((10#$c_day))
c_month=$((10#$c_month))

# 4. Define days in each month for calculation
# Index 0 is ignored, Index 1=Jan (31), Index 2=Feb (28), etc.
days_in_months=(0 31 28 31 30 31 30 31 31 30 31 30 31)

# Check for Leap Year to adjust February days
if (( (c_year % 4 == 0 && c_year % 100 != 0) || (c_year % 400 == 0) )); then
    days_in_months[2]=29
fi

# 5. Calculation Logic
# First, calculate the raw difference
diff_year=$((c_year - b_year))
diff_month=$((c_month - b_month))
diff_day=$((c_day - b_day))

# Adjust Days: If current day is less than birth day
if [ $diff_day -lt 0 ]; then
    # Borrow a month
    diff_month=$((diff_month - 1))
    
    # We need to know how many days were in the *previous* month
    # To find previous month index: if current is 1 (Jan), prev is 12 (Dec)
    prev_month=$((c_month - 1))
    if [ $prev_month -eq 0 ]; then
        prev_month=12
    fi
    
    # Add days from the previous month to the negative day difference
    days_in_prev=${days_in_months[$prev_month]}
    diff_day=$((diff_day + days_in_prev))
fi

# Adjust Months: If current month is less than birth month
if [ $diff_month -lt 0 ]; then
    # Borrow a year
    diff_year=$((diff_year - 1))
    # Add 12 months
    diff_month=$((diff_month + 12))
fi

# 6. Output Result
echo "-----------------------------------"
echo "Current Date: $c_day/$c_month/$c_year"
echo "Birth Date:   $b_day/$b_month/$b_year"
echo "-----------------------------------"
echo "Your Age is: $diff_year Years, $diff_month Months, and $diff_day Days."