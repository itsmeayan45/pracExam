
file=$1

echo "Processing records..."

# 3. Use AWK to find the max value
# -F '|' tells awk to split lines by the pipe symbol
awk -F '|' '
BEGIN { 
    max_marks = -1 
}
{
    # $1 is Roll, $2 is Name, $3 is Marks
    # We add +0 to $3 to force awk to treat it as a number (removes potential whitespace issues)
    current_marks = $3 + 0
    
    if (current_marks > max_marks) {
        max_marks = current_marks
        best_name = $2
        best_roll = $1
    }
}
END {
    # Print the final result after checking all lines
    print "---------------------------------"
    print "Top Student Found:"
    # specific formatting to remove leading/trailing spaces usually caused by delimiters
    gsub(/^[ \t]+|[ \t]+$/, "", best_name)
    gsub(/^[ \t]+|[ \t]+$/, "", best_roll)
    
    print "Name: " best_name
    print "Roll Number: " best_roll
    print "Marks: " max_marks
    print "---------------------------------"
}
' "$file"